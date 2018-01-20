package datastructure.heap;

import java.util.Random;

public class HeapDemo {

	public static void main(String[] args) {
		Heap heap = new MinHeap();

		for (int i = 0; i < 10; i++)
			heap.insert(new Random().nextInt(100));

		System.out.println("Ascending order sorting");
		for (int i = 0; i < 10; i++) {
			System.out.print(heap.pop() + " ");
		}

		heap = new MaxHeap();

		for (int i = 0; i < 10; i++)
			heap.insert(new Random().nextInt(100));

		System.out.println("\nDescending order sorting");
		for (int i = 0; i < 10; i++) {
			System.out.print(heap.pop() + " ");
		}

	}

}
