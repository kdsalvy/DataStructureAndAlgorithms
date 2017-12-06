package datastructure.graph;

import java.util.LinkedList;

public class Graph {

   LinkedList<Integer>[] adjoints;
   int v;
   
   public Graph(int v){
       this.adjoints = new LinkedList[v];
   }
   
   public void addEdge(int u, int v){
       adjoints[u].add(v);
   }
}
