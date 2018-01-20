package datastructure.list.program;

import datastructure.list.Node;
import datastructure.list.SinglyLinkedList;

/**
 * Given a singly linked list, rotate the linked list counter-clockwise by k
 * nodes. Where k is a given positive integer. For example, if the given linked
 * list is 10->20->30->40->50->60 and k is 4, the list should be modified to
 * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in
 * linked list.
 * 
 * @author skedia
 *
 */
public class RotateLinkedList {

    public static void main(String[] args) {
	SinglyLinkedList sll = new SinglyLinkedList();
	for (int i = 1; i <= 15; i++)
	    sll.add(i);

	int k = 4;
	rotate(k, sll);
	System.out.println(sll);
    }

    private static void rotate(int k, SinglyLinkedList sll) {
	Node node = sll.head;
	int count = 1;
	// traverse to kth node
	while (count < k && node != null) {
	    node = node.next;
	    count++;
	}
	// if node is null then return as solution cannot be reached
	if (node == null)
	    return;
	// store the pointer to kth node
	Node kthNode = node;
	// traverse to last node;
	while (node.next != null)
	    node = node.next;
	// attach last node to head
	node.next = sll.head;
	// make k+1 th node as head
	sll.head = kthNode.next;
	// make k + 1th node as null
	kthNode.next = null;
    }

}
