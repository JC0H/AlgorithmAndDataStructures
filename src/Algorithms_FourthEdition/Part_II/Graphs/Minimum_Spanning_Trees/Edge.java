package Algorithms_FourthEdition.Part_II.Graphs.Minimum_Spanning_Trees;

public class Edge implements Comparable<Edge> {

    private final int v,w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if (vertex == v) return w;
        else return v;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.weight < other.weight) return -1;
        else  if (this.weight > other.weight) return +1;
        return 0;
    }
}
