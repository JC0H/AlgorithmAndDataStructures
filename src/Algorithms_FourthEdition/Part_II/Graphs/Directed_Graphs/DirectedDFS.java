package Algorithms_FourthEdition.Part_II.Graphs.Directed_Graphs;

public class DirectedDFS {
    private boolean [] marked;

    public DirectedDFS(Digraphs G, int s){
        marked =  new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Digraphs G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)){
            if (!marked[w]) dfs(G,w);
        }
    }

    public boolean visited(int s){
        return marked[s];
    }
}
