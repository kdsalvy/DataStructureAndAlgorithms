package datastructure.tree.program;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import datastructure.tree.TreeNode;

/**
 * https://www.hackerrank.com/challenges/tree-top-view
 * 
 * @author skedia
 *
 */
public class TreeView {

	public static void main(String[] args) {
		TreeNode<Integer> root = createTree();
		System.out.println("BFS TOP VIEW TECHNIQUE");
		topView(root);
		System.out.println("RECURSIVE TOP VIEW TECHNIQUE");
		top_view(root, 0);
	}

	public static TreeNode<Integer> createTree() {
		TreeNode<Integer> root = new TreeNode<>(3);
		root.left = new TreeNode<>(5);
		root.right = new TreeNode<>(2);

		root.left.left = new TreeNode<>(1);
		root.left.right = new TreeNode<>(4);

		root.right.left = new TreeNode<>(6);
		root.right.right = new TreeNode<>(7);

		root.left.left.right = new TreeNode<>(9);

		root.right.right.left = new TreeNode<>(8);

		return root;
	}

	/**
	 * <b>Standard BFS Technique (Level wise print of top view)</b><br/>
	 * <br/>
	 * 
	 * The distance from root is calculated for each node at every level. When
	 * seen from the top, among all the nodes having same horizontal distance from root
	 * only the top level nodes will be seen. Thus we will store the distance in
	 * a set if it doesn't contain it and enqueue the node, if the distance
	 * already else we will just leave it
	 * 
	 * @param root
	 */
	public static void topView(TreeNode<Integer> root) {
		if (root == null)
			return;

		// Create an empty hashset
		Set<Integer> set = new HashSet<Integer>();

		// Create a queue
		Queue<QItem<Integer>> q = new LinkedList<>();

		// enqueue the root and put the distance from root, i.e. 0
		q.add(new QItem<>(root, 0));

		while (!q.isEmpty()) {
			// dequeue the queue
			QItem<Integer> item = q.poll();
			int hd = item.hd;
			TreeNode<Integer> node = item.node;

			// if set doesn't contain the distance that means it is the top most
			// node of that distance from root
			if (!set.contains(hd)) {
				// add the distance in the set
				set.add(hd);
				// print the node data
				System.out.print(node.data + " ");
			}

			// if node has left subtree then enqueue it with distance =
			// current distance - 1
			if (node.left != null)
				q.add(new QItem<>(node.left, hd - 1));
			// if node has right subtree then enqueue it with distance =
			// current distance + 1
			if (node.right != null)
				q.add(new QItem<>(node.right, hd + 1));
		}

	}

	/**
	 * Recursive method to determine the top view. When traversing the left
	 * subtree pass negative value as side and thus it will just traverse the
	 * left part of the left tree, similarly we will pass positive value for
	 * right subtree which will just traverse the right part.
	 * 
	 * @param root
	 * @param side
	 */
	static void top_view(TreeNode<Integer> root, int side) {
		if (root == null)
			return;

		if (side <= 0) {
			top_view(root.left, -1);
		}

		System.out.print(root.data + " ");

		if (side >= 0) {
			top_view(root.right, 1);
		}
	}

	// A class to represent a queue item. The queue is used to do Level
	// order traversal. Every Queue item contains node and horizontal
	// distance of node from root
	static class QItem<T> {
		TreeNode<T> node;
		int hd;

		public QItem(TreeNode<T> n, int h) {
			node = n;
			hd = h;
		}

		@Override
		public String toString() {
			return "QItem [node=" + node + ", hd=" + hd + "]";
		}

	}
	
	public void leftView(TreeNode<Integer> root){
		
	}
}
