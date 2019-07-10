package UnionFind;

public class UFQuickUnion {
    private int[] id; // access to component id (site indexed)
    private int count; // number of components

    public UFQuickUnion (int N) { // Initialize component id array.
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
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q){
        int idP = find(p);
        int idQ = find(q);

        if (idP == idQ) return;

        id[idP] = idQ;
        count--;
    }

    public static void main(String[] str)
    {
        UFQuickUnion uf = new UFQuickUnion(10);

        uf.union(9, 5);
        System.out.println(uf);
        uf.union(8, 7);
        System.out.println(uf);
        uf.union(3, 9);
        System.out.println(uf);
        uf.union(4, 8);
        System.out.println(uf);
        uf.union(7, 0);
        System.out.println(uf);
        uf.union(5, 1);
        System.out.println(uf);

        //System.out.println(uf);
    }

}
