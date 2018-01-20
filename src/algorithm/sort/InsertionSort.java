package algorithm.sort;

import java.util.Arrays;

/**
 * Insertion Sort<br/>
 * 1. for i = [1 ... n] for unsorted Array A <b /> 2. insert A[i] into sorted
 * array A[0 ... i-1] by pairwise swapping down to the correct position.
 * 
 * @author skedia
 *
 */
public class InsertionSort {

    public static void main(String[] args) {
	// unsorted input array
	int[] unsortedArray = { 5, 2, 1, 0, 34, 88, 12, 3, 8, 33, 76 };
	// pass the array to insertion sort algorithm
	int[] sortedArray = sort(unsortedArray);
	// print the sorted algorithm.
	System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * Insertion sort method.
     * 
     * @param unsortedArray
     * @return sortedArray
     */
    private static int[] sort(int[] unsortedArray) {
	// iterate from i = 1 to n - 1 and insert the element A[i] in its
	// correct position.
	for (int i = 1; i < unsortedArray.length; i++) {
	    for (int j = i - 1; j >= 0; j--) {
		// if the key element is less than the previous element then
		// swap
		if (unsortedArray[j + 1] < unsortedArray[j])
		    unsortedArray = swap(unsortedArray, j + 1, j);
	    }
	}
	// return the sorted array
	return unsortedArray;
    }

    private static int[] swap(int[] unsortedArray, int i, int j) {
	int temp = unsortedArray[i];
	unsortedArray[i] = unsortedArray[j];
	unsortedArray[j] = temp;
	return unsortedArray;
    }

}
