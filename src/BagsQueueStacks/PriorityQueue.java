package BagsQueueStacks;

public class PriorityQueue <Key extends Comparable<Key>>{

    private Key [] pq;
    private int N;

    public PriorityQueue(int capacity) {
        this.pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert (Key key){
        pq[N++] = key;
    }

    public Key delMax(){
        int max = 0;
        for (int i = 1; i < N; i++){
            if (less(max,i)) max = i;
        }
        exch(max,N-1);
        return pq[--N];
    }

    private static boolean less (Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
