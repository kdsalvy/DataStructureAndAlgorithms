package datastructure.list.program;

public class RecursiveReverseLinkedList {

    static Node head = new Node();

    public static void main(String[] args) {
	Node cursor = head;
	for (int i = 1; i <= 10; i++) {
	    cursor.data = i;
	    if (i != 10)
		cursor.next = new Node();
	    cursor = cursor.next;
	}

	System.out.println(head);

	cursor = null;
	recursiveReverse(head);
	cursor = head;
	while (cursor != null) {
	    System.out.print(cursor.data + "\t");
	    cursor = cursor.next;
	}
    }

    public static void recursiveReverse(Node node) {
	if (node.next == null) {
	    head = node;
	    return;
	}
	recursiveReverse(node.next);
	Node temp = node.next;
	temp.next = node;
	node.next = null;
    }

}

class Node {
    Node next;
    int data;

    @Override
    public String toString() {
	return data + "\t" + ((next == null) ? "" : next);
    }
}
