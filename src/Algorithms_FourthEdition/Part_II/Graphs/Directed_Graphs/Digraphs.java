package Algorithms_FourthEdition.Part_II.Graphs.Directed_Graphs;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Bag;

public class Digraphs {
    private final int V;
    private final Bag<Integer> [] adj;

    public Digraphs(int V) { // create empty digraph with V vertices
        this.V = V;
        this.adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(int v, int w){  // add a directed edge v -> w
        adj[v].add(w);
        //adj[w].add(v);    this only difference between di and not di graphs
    }

    public Iterable<Integer> adj(int v){  // vertices pointing from v
        return adj[v];
    }

    public int V(){ // count of vertices
        return V;
    }
}
