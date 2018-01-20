package datastructure.list.program;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a singly linked list and a key, count number of occurrences of given
 * key in linked list. For example, if given linked list is 1->2->1->2->1->3->1
 * and given key is 1, then output should be 4.
 * 
 * @author skedia
 *
 */
public class CountNoOfOccurance {

    public static void main(String[] args) {
	List<Integer> intList = getLinkedList();
	Iterator<Integer> iterator = intList.iterator();
	int n = 1;
	int noOfOccurance = 0;
	while (iterator.hasNext()) {
	    if (iterator.next() == n)
		noOfOccurance++;
	}
	System.out.println(noOfOccurance);
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
	intList.add(1);
	intList.add(9);
	intList.add(5);
	intList.add(1);
	intList.add(12);
	intList.add(10);
	intList.add(3);
	intList.add(1);
	intList.add(11);
	intList.add(4);
	intList.add(8);
	intList.add(1);
	intList.add(9);
	intList.add(5);
	intList.add(1);
	intList.add(12);
	intList.add(10);
	intList.add(3);
	intList.add(1);
	intList.add(11);
	return intList;
    }
}
