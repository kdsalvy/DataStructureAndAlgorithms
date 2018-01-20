package datastructure.stack.program;

import java.util.Stack;

/**
 * Calculate the maximum area of a histogram. We are going to use a stack in
 * this which will store the index of the start of a rectangle inside the
 * histogram.<br/>
 * Push in the stack until the element is greater than or equal to the stack top
 * element<br/>
 * if current value is less then stack top then pop until it becomes smaller
 * than current element.<br/>
 * for each pop calculate area and out of them select the max area.<br/>
 * if stack is not empty then pop it, calculate area for each popped element and
 * select max area
 * 
 * @author skedia
 *
 */
public class MaxRectangualrAreaInAHistogram {

	public static void main(String[] args) {
		int[] histogram = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Stack<Integer> stack = new Stack<>();

		int i = 0;
		int maxArea = Integer.MIN_VALUE;
		while (i < histogram.length) {
			if (stack.isEmpty() || histogram[i] > histogram[stack.peek()])
				stack.push(i++);
			else if (histogram[i] < histogram[stack.peek()]) {
				int tmpArea = computeArea(i, stack, histogram);
				maxArea = Math.max(maxArea, tmpArea);
			}
		}

		while (!stack.isEmpty()) {
			int tmpArea = computeArea(i, stack, histogram);
			maxArea = Math.max(maxArea, tmpArea);
		}
		System.out.println(maxArea);
	}

	public static int computeArea(int i, Stack<Integer> stack, int[] histogram) {
		int top = stack.pop();
		if (stack.isEmpty()) {
			return histogram[top] * i;
		} else {
			return histogram[top] * (i - stack.peek() - 1);
		}
	}

}
