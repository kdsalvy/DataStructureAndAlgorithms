package datastructure.list;

/**
 * Singly Linked List with basic insert, delete & display operations
 * @author saukedia1
 *
 */
public class SinglyLinkedList {

	public Node head = null;
	public int size = 0;

	/**
	 * Inserts data to the end of the list
	 * @param data
	 */
	public void add(int data) {
		Node current = head;
		if (current == null) {
			current = new Node(data);
			head = current;
			size++;
			return;
		}
		while (current.next != null)
			current = current.next;
		current.next = new Node(data);
		size++;
	}

	/**
	 * Inserts data at the start of the list
	 * @param data
	 */
	public void insertAtFirst(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size++;
	}

	/** 
	 * Inserts data at the given index in the list
	 * @param data - Data to be inserted
	 * @param index - Index where data needs to be inserted
	 * @throws Exception
	 */
	public void insertAt(int data, int index) throws Exception {
		Node current = head;
		Node prev = null;
		int i = 0;
		if (current == null || size < index)
			throw new Exception("Invalid Index");
		while (current.next != null && i++ != index) {
			prev = current;
			current = current.next;
		}
		prev.next = new Node(data);
		prev.next.next = current;
		size++;
	}

	/**
	 * Deletes the last element of the List & returns the deleted element
	 * @throws Exception
	 */
	public Node deleteLast() throws Exception {
	        Node result = null;
		Node current = head;
		if (current == null)
			throw new Exception("Empty List");
		while (current.next.next != null)
			current = current.next;
		result = current.next;
		current.next = null;
		size--;
		return result;
	}

	/**
	 * Delete the first Element of the List & returns the deleted element
	 * @throws Exception
	 */
	public Node deleteFirst() throws Exception {
	        Node result = null;
		Node current = head;
		if (current == null)
			throw new Exception("Empty List");
		head = current.next;
		result = current;
		current = null;
		size--;
		return result;
	}

	/**
	 * Delete the element at given index in the list
	 * @param index
	 * @throws Exception
	 */
	public void deleteAt(int index) throws Exception {
		Node current = head;
		Node prev = null;
		int i = 0;
		if (current == null || size < index)
			throw new Exception("Invalid Index");
		while (current.next != null && i++ != index) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
		size--;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + "\t");
			current = current.next;
		}
		System.out.print("\n");
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + ", size=" + size + "]";
	}

}
