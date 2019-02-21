package datastructure.tree.program;

import datastructure.tree.TreeNode;

/**
 * Find Lowest Common Ancestor for given nodes in a Binary Tree 
 * 
 * @author saukedia1
 *
 */
public class LeastCommonAncestorBT {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(6);
        root.left.left.right = new TreeNode<>(7);
        root.left.left.right.right = new TreeNode<>(8);

        System.out.println(findLCA(root, 8, 6));
    }

    /**
     * DFS approach to finding LCA
     * @param currentNode
     * @param a
     * @param b
     * @return node if it is equal to either a or b or it is the LCA.
     */
    public static TreeNode<Integer> findLCA(TreeNode<Integer> currentNode, Integer a, Integer b) {
        // return null if current node is null
        if (currentNode == null) {
            return null;
        }
        // if current node is equal to a or b return current node
        if (currentNode.data == a || currentNode.data == b) {
            return currentNode;
        }

        // find a or b in left subtree of current
        TreeNode<Integer> left = findLCA(currentNode.left, a, b);
        // find a or b in right subtree of current
        TreeNode<Integer> right = findLCA(currentNode.right, a, b);

        // both left and right contains value then current node is LCA
        if (left != null && right != null) {
            return currentNode;
        }
        // if left is null then return right as both nodes can be on right side else return left
        if (left == null)
            return right;
        else
            return left;
    }

}
