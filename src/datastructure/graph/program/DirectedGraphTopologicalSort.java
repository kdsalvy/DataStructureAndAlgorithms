package datastructure.graph.program;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import datastructure.graph.Graph;

/**
 * A directed graph topological sort is an order of vertices where for all path
 * going from u to v, u should appear before v in the order
 * 
 * @author skedia
 *
 */
public class DirectedGraphTopologicalSort {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		topologicalSort(g);
	}

	private static void topologicalSort(Graph graph) {
		// visited array which hold whether the node has been visited or not
		boolean[] visited = new boolean[graph.v];
		// mark all of them as unvisited
		for (int i = 0; i < graph.v; i++)
			visited[i] = false;

		// to hold the nodes in topological order
		Stack<Integer> stack = new Stack<>();

		// call helper function for not visited nodes
		for (int i = 0; i < graph.v; i++) {
			if (!visited[i])
				topologicalSortUtil(i, visited, stack, graph);
		}

		// pop until the stack is empty
		while (!stack.empty())
			System.out.print(stack.pop() + "  ");
	}

	private static void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, Graph graph) {
		// mark the node as visited
		visited[i] = true;

		// get all the adjacent nodes
		List<Integer> nodes = graph.adjoints[i];

		// visit all the child nodes and call the helper function recursively
		// for unvisited nodes
		Iterator<Integer> itr = nodes.iterator();
		while (itr.hasNext()) {
			int cur = itr.next();
			if (!visited[cur])
				topologicalSortUtil(cur, visited, stack, graph);
		}

		// once all the child nodes of this node has been explored push it onto
		// the stack
		stack.push(i);
	}

}
