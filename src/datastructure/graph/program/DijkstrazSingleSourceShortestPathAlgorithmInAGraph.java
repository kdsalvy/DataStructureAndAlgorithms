package datastructure.graph.program;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DijkstrazSingleSourceShortestPathAlgorithmInAGraph {

    class AdjNode {
	public int v;
	public int weight;

	public AdjNode(int v, int w) {
	    this.v = v;
	    this.weight = w;
	}
    }

    class Graph {
	public int n;
	public List<AdjNode> adjNodes[];

	public Graph(int n) {
	    this.n = n;
	    adjNodes = new LinkedList[n];
	    for (int i = 0; i < n; i++)
		adjNodes[i] = new LinkedList<>();
	}

	public void addEdge(int s, int d, int w) {
	    AdjNode node = new AdjNode(d, w);
	    adjNodes[s].add(node);
	}
    }

    public static void main(String[] args) {
	DijkstrazSingleSourceShortestPathAlgorithmInAGraph graphAlgo = new DijkstrazSingleSourceShortestPathAlgorithmInAGraph();
	// Create a graph
	Graph g = graphAlgo.new Graph(6);
	g.addEdge(0, 1, 5);
	g.addEdge(0, 2, 3);
	g.addEdge(1, 3, 6);
	g.addEdge(1, 2, 2);
	g.addEdge(2, 4, 4);
	g.addEdge(2, 5, 2);
	g.addEdge(2, 3, 7);
	g.addEdge(3, 4, -1);
	g.addEdge(4, 5, -2);

	int s = 1;
	graphAlgo.shortestPathfrom(s, g);
    }

    private void shortestPathfrom(int s, Graph g) {
	boolean[] visited = new boolean[g.n];
	for (int i = 0; i < g.n; i++) {
	    visited[i] = false;
	}

	Stack<Integer> stack = new Stack<>();

	// sort the given graph in topolgical order so that the distance finding
	// can get easier
	for (int i = 0; i < g.n; i++)
	    if (!visited[i])
		topologicalSortUtil(i, visited, stack, g);

	int[] shortestPathArray = new int[g.n];
	for (int i = 0; i < g.n; i++)
	    shortestPathArray[i] = Integer.MAX_VALUE;
	shortestPathArray[s] = 0;

	// pop the nodes one by one and get the distance from s
	while (!stack.isEmpty()) {
	    int top = stack.pop();
	    // get all the adjacent nodes
	    List<AdjNode> nodes = g.adjNodes[top];
	    Iterator<AdjNode> itr = nodes.iterator();
	    if (shortestPathArray[top] != Integer.MAX_VALUE) {
		while (itr.hasNext()) {
		    AdjNode cur = itr.next();
		    // update the path if there is a shorter one
		    if (shortestPathArray[cur.v] > shortestPathArray[top] + cur.weight)
			shortestPathArray[cur.v] = shortestPathArray[top] + cur.weight;
		}
	    }
	}

	// print the calculated distance
	for (int i = 0; i < g.n; i++) {
	    if (shortestPathArray[i] == Integer.MAX_VALUE)
		System.out.print("INF ");
	    else
		System.out.print(shortestPathArray[i] + " ");
	}
    }

    private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, Graph g) {
	// mark the node as visited
	visited[i] = true;

	List<AdjNode> node = g.adjNodes[i];
	Iterator<AdjNode> itr = node.iterator();

	while (itr.hasNext()) {
	    AdjNode cur = itr.next();
	    if (!visited[cur.v])
		topologicalSortUtil(cur.v, visited, stack, g);
	}

	stack.push(i);
    }
}
