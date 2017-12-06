package datastructure.heap;

public interface Heap {

    public void heapifyUp();

    public void heapifyDown();

    public void insert(int item);

    public int pop();
}
