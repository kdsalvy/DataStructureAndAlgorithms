package datastructure.stack.program;

import datastructure.stack.Stack;

public class EvaluatePostfixExpression {

    public static void main(String[] args) throws Exception {
        String expression = "2 3 1 * + 9 -";
        Integer result = evaluateExpression(expression);
        System.out.println(result);
    }

    private static Integer evaluateExpression(String expression) throws Exception {
        Stack<Integer> operandStack = new Stack<>();
        char[] charArray = expression.toCharArray();

        for (Character c : charArray) {
            if (Character.isDigit(c)) {
                operandStack.push(Character.getNumericValue(c));
                continue;
            }

            if (c == ' ')
                continue;

            operandStack.push(calculate(c, operandStack.pop(), operandStack.pop()));
        }

        Integer result = operandStack.pop();
        return result;
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
}
