package Algorithms_FourthEdition.Part_II.Graphs.Undirected_Graphs;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Bag;

public class Graph {
    private final int V;
    private Bag<Integer> [] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V() {
        return V;
    }
}
