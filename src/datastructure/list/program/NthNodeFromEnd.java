package datastructure.list.program;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a Linked List and a number n, write a function that returns the value
 * at the n’th node from end of the Linked List.
 * 
 * @author skedia
 *
 */
public class NthNodeFromEnd {

	static int i = 0;
	static int data = 0;

	public static void main(String[] args) {
		// list to perform on
		List<Integer> intList = getLinkedList();
		// index from end
		int n = 5;
		Iterator<Integer> intListIterator = intList.iterator();
		getNthNodeFromEnd(intListIterator, n);
		System.out.println(data);
	}

	/**
	 * Returns the data of nth node from end of a list
	 * 
	 * @param intListIterator
	 * @param n
	 */
	private static void getNthNodeFromEnd(Iterator<Integer> intListIterator, int n) {
		// if it is the last node of List make index = 1 and return
		if (!intListIterator.hasNext()) {
			i = 1;
			return;
		}
		// assign the node value to a temp variable
		int temp = intListIterator.next();
		// recurse the list to the end
		getNthNodeFromEnd(intListIterator, n);
		// if i equals n then assign node value in temp variable to data
		if (i == n)
			data = temp;
		// increment i and return
		i++;
		return;
	}

	/**
	 * Return a pre-constructed list to perform on.
	 * 
	 * @return List
	 */
	private static List<Integer> getLinkedList() {
		List<Integer> intList = new LinkedList<Integer>();
		intList.add(4);
		intList.add(8);
		intList.add(2);
		intList.add(9);
		intList.add(5);
		intList.add(1);
		intList.add(12);
		intList.add(10);
		intList.add(3);
		intList.add(32);
		intList.add(11);
		return intList;
	}

}
