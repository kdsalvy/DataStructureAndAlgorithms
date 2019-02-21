package datastructure.tree.program;

import datastructure.tree.TreeNode;

/**
 * Check least common ancestor in BST
 * @author saukedia1
 *
 */
public class LeastCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(9);
        root.left.left = new TreeNode<>(1);
        root.left.left.right = new TreeNode<>(2);
        root.left.left.right.right = new TreeNode<>(3);
        root.left.right = new TreeNode<>(6);
        root.left.right.left = new TreeNode<>(5);

        System.out.println(lca(root, 1, 2));

    }

    public static TreeNode<Integer> lca(TreeNode<Integer> root, int v1, int v2) {
        if (root == null)
            return root;
        // check if v1, v2 exists in left tree
        if (v1 < root.data && v2 < root.data)
            root = lca(root.left, v1, v2);
        // check if v1, v2 exists in right tree
        if (v1 > root.data && v2 > root.data)
            root = lca(root.right, v1, v2);
        // at this point v1 and v2 exists on either side of the subtree's root,
        // thus this is the LCA for v1 and v2
        return root;
    }

}
