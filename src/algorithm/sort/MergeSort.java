package algorithm.sort;

import java.util.Arrays;

/**
 * <b>Merge Sort<br/>
 * </b> 1. Divide array till smallest unit into left and right parts from the
 * mid element.<br/>
 * 2. Compare and merge the units back to a sorted array.<br/>
 * 
 * @author skedia
 *
 */
public class MergeSort {

    public static void main(String[] args) {
	// unsorted input array
	int[] unsortedArray = { 5, 2, 1, 0, 34, 88, 12, 3, 8, 33, 76 };
	// pass the array to insertion sort algorithm
	int[] sortedArray = sort(unsortedArray);
	// print the sorted algorithm.
	System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] sort(int[] array) {
	// recursion termination condition, when length of array is 1
	if (array.length == 1)
	    return array;

	// split the unsorted array in left and right halves
	int[] leftPart = split(array, 0, array.length / 2);
	int[] rightPart = split(array, array.length / 2, array.length);

	// call the sort function recursively
	int[] sortedLeftPart = sort(leftPart);
	int[] sortedRightPart = sort(rightPart);

	// merge both the sorted halves
	int[] mergedArray = merge(sortedLeftPart, sortedRightPart);

	// return sorted merged array
	return mergedArray;
    }

    /**
     * Creates a new array between specified start index inclusive and end index
     * exclusive from the given array
     * 
     * @param unsortedArray
     * @param i
     * @param len
     * @return sub array
     */
    private static int[] split(int[] unsortedArray, int i, int len) {
	int[] tempArray = new int[len - i];
	int k = 0;
	while (k < tempArray.length)
	    tempArray[k++] = unsortedArray[i++];
	return tempArray;
    }

    /**
     * Merges the given two sorted array in a single sorted array.
     * 
     * @param leftPart
     * @param rightPart
     * @return sorted array
     */
    private static int[] merge(int[] leftPart, int[] rightPart) {
	// Create a new merged array of length equal to sum of both given
	// array's length
	int[] mergedArray = new int[leftPart.length + rightPart.length];
	int i = 0, j = 0, k = 0;

	// while both arrays have elements put elements into the merged array
	// satisfying the condition
	while (leftPart != null && i < leftPart.length && rightPart != null && j < rightPart.length)
	    // if element of left is less then assign to merge array element
	    // else the same of right.
	    mergedArray[k++] = (leftPart[i] < rightPart[j]) ? leftPart[i++] : rightPart[j++];

	// while left part has elements left assign to merged array
	while (leftPart != null && i < leftPart.length)
	    mergedArray[k++] = leftPart[i++];

	// while right part has elements left assign to merged array
	while (rightPart != null && j < rightPart.length)
	    mergedArray[k++] = rightPart[j++];
	return mergedArray;

    }

}
