package datastructure.heap;

import java.util.Arrays;

public class HeapUtility {

    public static int getParentIndex(int index) {
	return (index - 1) / 2;
    }

    public static int getLeftChildIndex(int index) {
	return (index * 2) + 1;
    }

    public static int getRightChildIndex(int index) {
	return (index * 2) + 2;
    }

    public static boolean hasParent(int index) {
	return getParentIndex(index) >= 0;
    }

    public static boolean hasLeftChild(int index, int size) {
	return getLeftChildIndex(index) < size;
    }

    public static boolean hasRightChild(int index, int size) {
	return getRightChildIndex(index) < size;
    }

    public static int parent(int index, int[] items) {
	return items[getParentIndex(index)];
    }

    public static int leftChild(int index, int[] items) {
	return items[getLeftChildIndex(index)];
    }

    public static int rightChild(int index, int[] items) {
	return items[getRightChildIndex(index)];
    }

    public static void swap(int parentIndex, int size, int[] items) {
	int temp = items[parentIndex];
	items[parentIndex] = items[size];
	items[size] = temp;
    }

    public static int[] ensureExtraCapacity(int[] items, int size, int capacity) {
	if (size == capacity) {
	    items = Arrays.copyOf(items, capacity * 2);
	    capacity *= 2;
	}
	return items;
    }

    public static int peek(int[] items, int size) {
	if (size == 0)
	    throw new IndexOutOfBoundsException();
	return items[0];
    }
}
