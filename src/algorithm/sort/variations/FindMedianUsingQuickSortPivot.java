package algorithm.sort.variations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FindMedianUsingQuickSortPivot {

    public static int median = -1;

    public static void main(String[] args) throws Exception {
	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D://medianInput.txt")));
	int n = Integer.parseInt(in.readLine());
	String[] inputArray = in.readLine().split(" ");
	int[] arr = new int[n];
	int i = 0;
	for (String s : inputArray) {
	    arr[i++] = Integer.parseInt(s);
	}
	// int[] arr = {0, 1, 2, 8, 6, 5, 4, 3, 9};
	recurse(arr, 0, arr.length - 1);
	System.out.println(arr[median]);
	in.close();
    }

    static int recurse(int[] arr, int low, int high) {
	if (low > high)
	    return median;
	int midpoint = arr.length / 2;
	median = partition(arr, low, high);
	if (median == midpoint)
	    return median;
	else if (median > midpoint)
	    median = recurse(arr, low, median - 1);
	else
	    median = recurse(arr, median + 1, high);
	return median;
    }

    static int partition(int[] arr, int low, int high) {
	int pivot = arr[high];
	int j = low;
	for (int i = low; i < high; i++) {
	    if (arr[i] <= pivot) {
		swap(arr, i, j);
		j++;
	    }
	}
	swap(arr, j, high);
	return j;
    }

    static int[] swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
	return arr;
    }
}
