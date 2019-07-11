package UnionFind;

public class UFQuickUnion {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components
    private int[] sz; // access to size of components for root
    public UFQuickUnion (int N) { // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public int count() {
        return count;
    }

    private int root(int e){
        while (e != id[e]){
            id[e] = id[id[e]]; // path compression - make every next node refer to grandparent node
            e = id[e];
        }
        return e;
    }

    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int idP = root(p);
        int idQ = root(q);
        if (idP == idQ) return;
        //check what tree is bigger
        if (sz[idP] < sz[idQ]){
            id[idP] = idQ;
            sz[idQ] += sz[idP];
        }else{
            id[idQ] = idP;
            sz[idP] += sz[idQ];
        }
        id[idP] = idQ;
    }

    public static void main(String[] str)
    {
        UFQuickUnion uf = new UFQuickUnion(10);

        uf.union(9, 5);
        uf.union(8, 7);
        uf.union(3, 9);
        uf.union(4, 8);
        uf.union(7, 0);
        uf.union(5, 1);
    }

}
