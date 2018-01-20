package datastructure.list.program;

import datastructure.list.program.AddNumbersRepresentedByLinkedList.LinkedList.Node;

public class AddNumbersRepresentedByLinkedList {
    static AddNumbersRepresentedByLinkedList anrbll = new AddNumbersRepresentedByLinkedList();
    static LinkedList ll = anrbll.new LinkedList();

    public static void main(String[] args) {
	LinkedList l1 = anrbll.new LinkedList();
	l1.add(9).add(6).add(5);
	LinkedList l2 = anrbll.new LinkedList();
	l2.add(2).add(4).add(8);
	LinkedList result = anrbll.new LinkedList();

	l1.head = anrbll.reverseLinkedList(l1.head);
	l2.head = anrbll.reverseLinkedList(l2.head);

	result.head = anrbll.addNumbers(l1.head, l2.head, result.head, 0);
	result.head = anrbll.reverseLinkedList(result.head);

	System.out.println(result);
    }

    private Node reverseLinkedList(Node node) {
	if (node.next == null) {
	    return node;
	}
	Node result = reverseLinkedList(node.next);
	Node temp = node.next;
	temp.next = node;
	node.next = null;

	return result;

    }

    private Node addNumbers(Node node1, Node node2, Node result, int carry) {
	if (node1 == null && node2 == null) {
	    if (carry != 0) {
		result.next = ll.new Node();
		result = result.next;
		result.data = carry;
	    }
	    return result;
	}
	if (result == null)
	    result = ll.new Node();
	else {
	    result.next = ll.new Node();
	    result = result.next;
	}
	int a = node1 == null ? 0 : node1.data;
	int b = node2 == null ? 0 : node2.data;
	result.data = (a + b + carry) % 10;
	carry = (a + b + carry) / 10;
	addNumbers((node1 == null ? null : node1.next), (node2 == null ? null : node2.next), result, carry);
	return result;
    }

    class LinkedList {
	Node head;

	public LinkedList add(int data) {
	    if (head == null) {
		head = new Node();
		head.data = data;
	    } else {
		Node temp = head;
		while (temp.next != null)
		    temp = temp.next;
		temp.next = new Node();
		temp = temp.next;
		temp.data = data;
	    }
	    return this;
	}

	class Node {
	    int data;
	    Node next;

	    @Override
	    public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	    }
	}

	@Override
	public String toString() {
	    return "LinkedList [head=" + head + "]";
	}
    }
}
