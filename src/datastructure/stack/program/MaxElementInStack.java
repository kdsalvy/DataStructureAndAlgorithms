package datastructure.stack.program;

import datastructure.stack.Stack;

public class MaxElementInStack {

	static long max = 0;

	public static void main(String[] args) throws Exception {
		Stack<Long> stack = new Stack<>();
		stack.push(-2L);
		stack.push(-5L);
		stack.push(190L);
		stack.push(12L);
		stack.push(500L);
		System.out.println(stack);
		getMaxNumber(stack);
		System.out.println(max);
		System.out.println(stack);
	}

	public static void getMaxNumber(Stack<Long> st) throws Exception {
		if (st.peek() == null)
			return;
		long temp = st.pop();
		max = (max > temp) ? max : temp;
		getMaxNumber(st);
		st.push(temp);
	}

}
