package algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int key = 8;

	int pos = binarySearch(arr, key, 0, arr.length);
	System.out.println("Position: " + pos);
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
	if (low > high)
	    return -1;
	int mid = (low + high) / 2;
	if (mid == key)
	    return mid;
	else if (key < mid)
	    return binarySearch(arr, key, low, mid - 1);
	else
	    return binarySearch(arr, key, mid + 1, high);
    }

}
