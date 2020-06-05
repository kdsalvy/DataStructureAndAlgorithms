package datastructure.heap;

public class HeapDemo {

    public static void main(String[] args) {
        Heap heap = new MinHeap();

        Integer[] intArray = { 11, 84, 8, 11, 92, 59, 44, 22, 66, 87, 1, 5, 9, 0 };

        for (int i = 0; i < intArray.length; i++)
            heap.insert(intArray[i]);

        System.out.println("Ascending order sorting");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(heap.pop() + " ");
        }

        heap = new MaxHeap();

        for (int i = 0; i < intArray.length; i++)
            heap.insert(intArray[i]);

        System.out.println("\nDescending order sorting");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(heap.pop() + " ");
        }

    }

}
