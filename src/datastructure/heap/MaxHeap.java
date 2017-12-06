package datastructure.heap;

public class MaxHeap implements Heap {

    private int[] items = null;
    private int size;
    private int capacity = 10;

    public MaxHeap() {
	items = new int[capacity];
    }

    public void insert(int item) {
	items = HeapUtility.ensureExtraCapacity(items, size, capacity);
	if (size == capacity)
	    capacity *= 2;
	items[size++] = item;
	heapifyUp();
    }

    public void heapifyUp() {
	int index = size - 1;
	while (HeapUtility.hasParent(index) && HeapUtility.parent(index, items) < items[index]) {
	    HeapUtility.swap(HeapUtility.getParentIndex(index), index, items);
	    index = HeapUtility.getParentIndex(index);
	}
    }

    public void heapifyDown() {
	int index = 0;
	while (HeapUtility.hasLeftChild(index, size)) {
	    int biggerChildIndex = HeapUtility.getLeftChildIndex(index);
	    if (HeapUtility.hasRightChild(index, size)
		    && HeapUtility.rightChild(index, items) > HeapUtility.leftChild(index, items))
		biggerChildIndex = HeapUtility.getRightChildIndex(index);
	    if (items[index] > items[biggerChildIndex])
		break;
	    else
		HeapUtility.swap(index, biggerChildIndex, items);
	    index = biggerChildIndex;
	}
    }

    @Override
    public int pop() {
	int item = items[0];
	items[0] = items[size - 1];
	size--;
	heapifyDown();
	return item;
    }

}
