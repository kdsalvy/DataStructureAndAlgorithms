package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// unsorted input array
		int[] arr = { 5, 2, 1, 0, 34, 88, 12, 3, 8, 33, 76 };

		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;
		// find pivot
		int pivotIndex = findPivotIndex(arr, low, high);
		// sort the left half
		quickSort(arr, low, pivotIndex - 1);
		// sort the right half
		quickSort(arr, pivotIndex + 1, high);
	}

	private static int findPivotIndex(int[] arr, int low, int high) {
		// randomly find the pivot element
		int pivotElement = arr[high];
		// move elements smaller to pivot to its left and larger to its right
		int j = low;
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivotElement) {
				swap(arr, i, j);
				j++;
			}
		}
		swap(arr, j, high);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
