package datastructure.stack.program;

import datastructure.stack.Stack;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.<br/>
 * <b>Examples:</b><br/>
 * a) For any array, rightmost element always has next greater element as
 * -1.<br/>
 * b) For an array which is sorted in decreasing order, all elements have next
 * greater element as -1.<br/>
 * c) For the input array [4, 5, 2, 25], the next greater elements for each
 * element are as follows.<br/>
 * <br/>
 * Element NGE<br/>
 * 4 --> 5<br/>
 * 5 --> 25<br/>
 * 2 --> 25<br/>
 * 25 --> -1<br/>
 * 
 * @author skedia
 *
 */
public class NextGreaterElement {

	public static void main(String[] args) throws Exception {
		int[] arr = { 4, 5, 2, 13, 6, 8, 9, 1};
		Stack<Integer> processStack = new Stack<>();
		for (int i : arr) {
			while (processStack.peek() != null && processStack.peek() < i) {
				System.out.println(processStack.pop() + "\t-->\t" + i);
			}
			processStack.push(i);
		}
		while (processStack.peek() != null)
			System.out.println(processStack.pop() + "\t-->\t" + -1);
	}

}
