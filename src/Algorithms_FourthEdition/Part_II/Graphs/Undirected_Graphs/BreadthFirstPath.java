package Algorithms_FourthEdition.Part_II.Graphs.Undirected_Graphs;

import Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.Queue;

public class BreadthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;

    private void bfs(Graph G, int s){
        Queue<Integer> q =  new Queue<>();
        q.enqueue(s);
        marked[s] = true;
        while (!q.isEmpty()){
            int v = q.dequeue();
            for (int w : G.adj(v)){
                q.enqueue(w);
                marked[w] = true;
                edgeTo[w] = v;
            }
        }
    }
}