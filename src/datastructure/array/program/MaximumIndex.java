package datastructure.array.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of integers, find the maximum of j - i subjected to the
 * constraint of A[i] <= A[j].<br/>
 * Example :<br/>
 * A : [3 5 4 2]<br/>
 * Output : 2 <br/>
 * for the pair (3, 4)<br/>
 * 
 * @author skedia
 *
 */
public class MaximumIndex {
    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	    int tc = Integer.parseInt(br.readLine());
	    for (int i = 0; i < tc; i++) {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] arrVals = br.readLine().split(" ");
		for (int j = 0; j < n; j++) {
		    arr[j] = Integer.parseInt(arrVals[j]);
		}

		int a = 0;
		int b = n - 1;
		int max = 0;
		while (a < b) {
		    if (max == n - 1)
			break;
		    if (max > (n - 1 - a))
			break;
		    if (arr[a] <= arr[b]) {
			max = Math.max(max, (b - a));
			a++;
			b = n - 1;
			continue;
		    }
		    b--;
		}
		System.out.println(max);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
