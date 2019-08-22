package Algorithms_FourthEdition.Part_II.Graphs.Minimum_Spanning_Trees;

import Algorithms_FourthEdition.Part_I.III_Searching.UnionFind.UF;
import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Queue;
import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.dataStructures.MinPQ;

public class KrushkalMST {
    private Queue<Edge> mst =  new Queue<>();

    public KrushkalMST(EdgeWeightedGraph G) {
        MinPQ<Edge> pq =  new MinPQ<>();
        for (Edge e : G.edges()){       //build priority queue
            pq.insert(e);
        }

        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v,w)){
                uf.union(v,w);
                mst.enqueue(e);
            }
        }
    }
}
