package Algorithms_FourthEdition.Part_II.Graphs;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.II_Stack.Stack;

public class DepthFirdsPath {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirdsPath(Graph G, int s) {
        //initialization
        dsf(G,s);
    }

    private void dsf(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)){
            if (!marked[v]){
                dsf(g,v);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (hasPathTo(v)) return null;
        Stack<Integer> path =  new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]){
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
