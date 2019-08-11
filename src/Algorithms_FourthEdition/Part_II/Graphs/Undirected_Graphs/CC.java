package Algorithms_FourthEdition.Part_II.Graphs.Undirected_Graphs;

public class CC {
    private boolean [] marked;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int v = 0; v < G.V(); v++){
            if (!marked[v]){
                bfs(G,v);
                count++;
            }
        }
    }

    private void bfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;//all verticies discovered in the same call of dfs have same id
        for (int w : G.adj(v)){
            if (!marked[w])
                bfs(G,w);
        }
    }

    public int count(){
        return count;
    }

    public int id(int v){
        return id[v];  //id of components containing v
    }
}
