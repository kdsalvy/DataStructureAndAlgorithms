package datastructure.list.program;

import datastructure.list.SinglyLinkedList;

public class BasicOperations {

    public static void main(String[] args) throws Exception {
	SinglyLinkedList sll = new SinglyLinkedList();
	for (int i = 1; i <= 15; i++) {
	    sll.add(i);
	}
	sll.insertAtFirst(16);
	sll.insertAt(17, 6);

	sll.display();

	sll.deleteFirst();
	sll.display();
	sll.deleteLast();
	sll.display();
	sll.deleteAt(3);
	sll.display();
    }

}
