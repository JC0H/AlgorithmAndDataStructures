package Algorithms_FourthEdition.Part_II.Graphs.Minimum_Spanning_Trees;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Bag;

public class EdgeWeightedGraph {
    private final int V;
    private final Bag<Edge> [] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
//   return adj[v]; - gives us error because Bag iterable Integers but not Edge(our new class )
    public Iterable<Edge> adj(int v){
        //return adj[v];
        return null;
    }
}
