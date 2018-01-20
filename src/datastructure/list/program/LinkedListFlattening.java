package datastructure.list.program;

/**
 * Given a linked list where every node represents a linked list and contains
 * two pointers of its type:<br/>
 * (i) Pointer to next node in the main list (we call it ‘right’ pointer in
 * below code) <br/>
 * (ii) Pointer to a linked list where this node is head (we call it ‘down’
 * pointer in below code). All linked lists are sorted.
 * 
 * @author skedia
 *
 */
public class LinkedListFlattening {

	static class LinkedList{
		Node head;
	}

    static class Node {
		Node right;
		Node down;
		int data;
	}
	
	public static void main(){
		LinkedList list = new LinkedList();
	}
}
