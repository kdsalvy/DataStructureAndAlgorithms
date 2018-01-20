package datastructure.graph;

import java.util.LinkedList;

public class Graph {

	public LinkedList<Integer>[] adjoints;
	public int v;

	public Graph(int v) {
		this.v = v;
		this.adjoints = new LinkedList[v];
		for (int i = 0; i < v; i++)
			this.adjoints[i] = new LinkedList<>();
	}

	public void addEdge(int u, int v) {
		adjoints[u].add(v);
	}
}
