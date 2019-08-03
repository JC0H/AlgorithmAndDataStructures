package Algorithms_FourthEdition.Part_I.III_Searching.UnionFind;

public class UF {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public UF(int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) return;

        for (int i = 0; i < id.length; i++){
            if (id[i] == idP) id[i] = idQ;
            count--;
        }

    }
}
