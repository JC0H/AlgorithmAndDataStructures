package Algorithms_FourthEdition.Part_II.Graphs.ShortestPaths;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Bag;

public class EdgeWeightedDigraph {
    private final int V;
    private final Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.adj = (Bag<DirectedEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<DirectedEdge>();
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
    }


}
