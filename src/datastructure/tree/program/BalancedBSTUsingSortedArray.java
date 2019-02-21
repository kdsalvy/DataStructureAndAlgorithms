package datastructure.tree.program;

import datastructure.tree.TreeNode;

/**
 * Create a balanced BST from a sorted array
 * @author saukedia1
 *
 */
public class BalancedBSTUsingSortedArray {

    public static void main(String[] args) {
        int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(createBalancedBST(sortedArray, 0, sortedArray.length));
    }

    /**
     * Recursively call the method for each subtree with mid index as root, left to mid as left subtree and right to mid as right subtree 
     * @param sortedArray
     * @param startIndex
     * @param endIndex
     * @return root node of balanced BST
     */
    public static TreeNode<Integer> createBalancedBST(int[] sortedArray, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int midIndex = (startIndex + endIndex) / 2;
        TreeNode<Integer> root = new TreeNode<>(midIndex);

        root.left = createBalancedBST(sortedArray, startIndex, midIndex - 1);
        root.right = createBalancedBST(sortedArray, midIndex + 1, endIndex);

        return root;
    }

}
