package datastructure.stack.program;

import datastructure.stack.Stack;

public class EvaluateInfixExpression {

	public static void main(String[] args) throws Exception {
		String expression = "5+3*4-8";//"((4 + 4) * 4) / 2 - 1";
		Stack<Integer> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();

		char[] charArray = expression.toCharArray();

		for (Character character : charArray) {
			// if empty character then skip the iteration.
			if (character == ' ')
				continue;
			// if current character is a number push it on the operand stack
			if (Character.isDigit(character))
				operand.push(Character.getNumericValue(character));
			else {
				// check current and previous operator precedence
				int currPrecedence = getPrecedence(character);
				int prevPrecedence = (operator.peek() != null) ? getPrecedence(operator.peek()) : 0;

				// character is open parenthesis then push on to the operator
				// stack
				if (character == '(') {
					operator.push(character);
					continue;
				}
				// if the operator is closed parenthesis then pop the operator
				// stack once and operand stack twice, apply and get the result
				// and push it on the operand stack on each iteration until we
				// encounter left parenthesis
				if (character == ')') {
					while (operator.peek() != '(') {
						applyOpAndPushResult(operand, operator);
					}
					operator.pop();
					continue;
				}
				// if the operator on stack top has more precedence then pop the
				// operator stack and pop the operand stack twice, apply the
				// operator on them and push the result back in the stack;
				while (currPrecedence < prevPrecedence) {
					applyOpAndPushResult(operand, operator);
					prevPrecedence = (operator.peek() != null) ? getPrecedence(operator.peek()) : 0;
				}
				operator.push(character);
			}

		}

		// Evaluate the by popping the stacks
		while (operator.peek() != null)
			applyOpAndPushResult(operand, operator);
		// pop the result which will be there on the top of the stack
		System.out.println("Result is: " + operand.pop());
	}

	private static void applyOpAndPushResult(Stack<Integer> operand, Stack<Character> operator) throws Exception {
		char op = operator.pop();
		int op1 = operand.pop();
		int op2 = operand.pop();

		int result = calculate(op, op1, op2);
		operand.push(result);
	}

	private static int calculate(char op, int op1, int op2) throws Exception {
		switch (op) {
		case '+':
			return op2 + op1;
		case '-':
			return op2 - op1;
		case '*':
			return op2 * op1;
		case '/':
			return op2 / op1;
		default:
			throw new Exception("Invalid operator");
		}
	}

	private static int getPrecedence(Character op) throws Exception {
		switch (op) {
		case '+':
			return 2;
		case '-':
			return 1;
		case '*':
			return 3;
		case '/':
			return 4;
		case '(':
			return 0;
		case ')':
			return 5;
		default:
			throw new Exception("Invalid operator");
		}
	}

}
