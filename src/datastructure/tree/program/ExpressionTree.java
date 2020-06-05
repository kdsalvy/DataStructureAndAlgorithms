package datastructure.tree.program;

import java.util.Stack;

import datastructure.tree.TreeNode;

public class ExpressionTree {

    public static void main(String[] args) {
        String expression = "a+b";
        char[] oprArray = expression.toCharArray();
        TreeNode<Character> exprTreeRoot = constructExprTree(oprArray);

    }

    private static TreeNode<Character> constructExprTree(char[] oprArray) {
        Stack<TreeNode<Character>> oprtr = new Stack<>();
        Stack<TreeNode<Character>> oprnd = new Stack<>();
        TreeNode<Character> node = null;

        for (Character c : oprArray) {
            if (c == ' ')
                continue;
            if (Character.isDigit(c) || c == '(') {
                oprnd.push(new TreeNode<>(c));
                continue;
            }

            while (c == ')' && oprtr.peek().data != '(') {
                TreeNode<Character> tempNode = oprtr.pop();
                tempNode.right = oprnd.pop();
                tempNode.left = oprnd.pop();
                if(node == null) {
                    node = tempNode;
                }
            }

        }
    }

}
