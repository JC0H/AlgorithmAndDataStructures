package Algorithms_FourthEdition.Part_II.Graphs.Minimum_Spanning_Trees;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.lll_Queue.Queue;
import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.dataStructures.MinPQ;

public class LazyPrimMST {
    private boolean [] marked; //MST vertices
    private Queue <Edge> mst;
    private MinPQ <Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        mst = new Queue<>();
        marked = new boolean[G.V()];

        visit(G, 0);
        while (!pq.isEmpty()){
            Edge e =  pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }

    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)){
            if (!marked[e.other(v)])
                pq.insert(e);
        }
    }


}
