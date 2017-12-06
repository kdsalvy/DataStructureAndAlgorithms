package datastructure.array.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array of non-negative integers, find a continuous sub-array
 * which adds to a given number.
 * 
 * @author skedia
 *
 */
public class SubarraySum {
    public static void main(String[] args) {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
	    int tc = Integer.parseInt(br.readLine());
	    for (int i = 0; i < tc; i++) {
		String[] lOne = br.readLine().split(" ");
		int n = Integer.parseInt(lOne[0]);
		int sum = Integer.parseInt(lOne[1]);
		String[] lTwo = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int j = 0; j < n; j++) {
		    arr[j] = Integer.parseInt(lTwo[j]);
		}
		// traverse the array taking two pointers to denote start and
		// end of the array add the contiguous numbers by incrementing
		// 1st pointer and if the sum of subArray is greater than the
		// required sum subtract the element at second pointer and
		// increment the second pointer
		int a = 0;
		int b = 0;
		boolean isPresent = false;
		int tempSum = 0;
		while (b < n || a < n) {
		    if (sum == tempSum) {
			isPresent = true;
			break;
		    }
		    tempSum += b < n ? arr[b++] : 0;
		    while (tempSum > sum) {
			tempSum -= arr[a++];
		    }
		}
		if (isPresent) {
		    System.out.print((a + 1) + " " + b + "\n");
		} else {
		    System.out.println(-1);
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
