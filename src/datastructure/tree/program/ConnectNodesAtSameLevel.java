package datastructure.tree.program;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a function to connect all the adjacent nodes at the same level in a
 * binary tree. Structure of the given Binary Tree node is like following. <br/>
 * <br/>
 * struct Node{ <br/>
 * int data; <br/>
 * Node* left; <br/>
 * Node* right; <br/>
 * Node* nextRight; <br/>
 * } <br/>
 * <br/>
 * Initially, all the nextRight pointers point to garbage values. Your function
 * should set these pointers to point next right for each node.
 * 
 * @author skedia
 *
 */
public class ConnectNodesAtSameLevel {

    public static void main(String[] args) {
	// 100 20 R 20 30 L 30 40 L 40 50 R 50 60 L 50 70 R
	Node root = new Node(3);
	root.left = new Node(1);
	root.right = new Node(2);

	new ConnectNodesAtSameLevel().connect(root);
	System.out.println(root);

    }

    void connect(Node root) {
	root.nextRight = null;
	Queue<Node> q = new LinkedList<>();
	q.add(root);
	q.add(null);
	connectRight(q);
    }

    // add all the nodes of same level to the queue and add a null after as a
    // separator between two levels. Poll the nodes one by one and add its
    // child. when the termination condition is executed the right side node is
    // returned in rNode. point the current node nextRight pointer to rNode
    Node connectRight(Queue<Node> q) {
	if (q.isEmpty())
	    return null;
	Node node = q.poll();
	if (node == null) {
	    if (q.peek() != null)
		q.add(null);
	    else
		return null;
	}
	if (node != null && node.left != null)
	    q.add(node.left);
	if (node != null && node.right != null)
	    q.add(node.right);
	Node rNode = connectRight(q);
	if (node != null)
	    node.nextRight = rNode;
	return node;
    }
}

class Node {
    int data;
    Node left, right, nextRight;

    Node(int item) {
	data = item;
	left = right = nextRight = null;

    }

    @Override
    public String toString() {
	return "Node [data=" + data + ", left=" + left + ", right=" + right + ", nextRight=" + nextRight + "]";
    }

}
