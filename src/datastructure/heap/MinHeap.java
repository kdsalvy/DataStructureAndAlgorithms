package datastructure.heap;

import java.util.Arrays;

public class MinHeap implements Heap {

    private int[] items = null;
    private int size;
    private int capacity = 5;

    public MinHeap() {
        items = new int[capacity];
        size = 0;
    }

    public void heapifyUp() {
        int index = size - 1;
        while (HeapUtility.hasParent(index) && HeapUtility.parent(index, items) > items[index]) {
            HeapUtility.swap(HeapUtility.getParentIndex(index), index, items);
            index = HeapUtility.getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while (HeapUtility.hasLeftChild(index, size)) {
            int smallerChildIndex = HeapUtility.getLeftChildIndex(index);
            if (items[index] < items[smallerChildIndex])
                break;
            if (HeapUtility.hasRightChild(index, size) && HeapUtility.rightChild(index, items) < HeapUtility.leftChild(index, items))
                smallerChildIndex = HeapUtility.getRightChildIndex(index);
            else
                HeapUtility.swap(index, smallerChildIndex, items);
            index = smallerChildIndex;
        }
    }

    @Override
    public void insert(int item) {
        items = HeapUtility.ensureExtraCapacity(items, size, capacity);
        if (size == capacity)
            capacity *= 2;
        items[size] = item;
        size++;
        heapifyUp();
    }

    @Override
    public int pop() {
        if (size == 0)
            throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    @Override
    public String toString() {
        return "MinHeap [items=" + Arrays.toString(items) + "]";
    }
}
