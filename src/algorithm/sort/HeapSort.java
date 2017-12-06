package algorithm.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
	// unsorted input array
	int[] unsortedArray = { 5, 2, 1, 0, 34, 88, 12, 3, 8, 33, 76 };
	// pass the array to heap sort algorithm
	int[] sortedArray = sort(unsortedArray);
	// print the sorted algorithm.
	System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] sort(int[] randomArray) {
	int n = randomArray.length;
	int startIndex = randomArray.length / 2;

	// Build Max Heap (rearrange array)
	for (int i = startIndex; i >= 0; i--) {
	    maxHeapify(randomArray, n, i);
	}

	// one by one extract the max element from group
	for (int i = n - 1; i >= 0; i--) {
	    // take the current root and move it to the end of the tree and
	    // heapify the reduced tree
	    int temp = randomArray[i];
	    randomArray[i] = randomArray[0];
	    randomArray[0] = temp;

	    // re-heapify the distorted reduced heap
	    maxHeapify(randomArray, i, 0);
	}

	return randomArray;

    }

    private static void maxHeapify(int[] nonHeapArray, int n, int i) {
	int largest = i;
	int left = 2 * i + 1;
	int right = 2 * i + 2;

	// if left element is larger than current largest then largest equals to
	// left
	if (left < n && nonHeapArray[left] > nonHeapArray[largest])
	    largest = left;

	// if right element is larger than current largest then largest equals
	// to right
	if (right < n && nonHeapArray[right] > nonHeapArray[largest])
	    largest = right;

	// if largest is anything but the root node then swap the largest and
	// the root node
	if (largest != i) {
	    int temp = nonHeapArray[i];
	    nonHeapArray[i] = nonHeapArray[largest];
	    nonHeapArray[largest] = temp;

	    maxHeapify(nonHeapArray, n, largest);
	}

    }

}
