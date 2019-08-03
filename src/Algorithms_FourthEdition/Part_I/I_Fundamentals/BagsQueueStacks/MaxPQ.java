package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

public class MaxPQ< Key extends Comparable<Key>> {

    private Key [] pq;
    private int N;

    /*We add the new key at the end of the array, increment the size of the heap,
      and then swim up through the heap with that key to restore the heap condition.*/
    void insert(Key k){
        pq[++N] = k;
        swim(N);
    }

    //return the largest key
    Key max(){
        return null;
    }

    //return and remove the largest key
    public Key delMax() {
        Key max = pq[1];
        exch(1,N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    //is the priority queue empty?
    boolean isEmpty() {
        return false;
    }

    //number of keys in the priority queue
    int size() {
        return 0;
    }

    /*If the heap order is violated because a node’s key becomes smaller than one or both of that
      node’s children’s keys, then we can make progress toward fixing the violation by exchanging the node
      with the larger of its two children.   k/2 = parent node*/
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k){
        while ( 2*k <= N){
            int j = 2*k;
            if ( j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;       //if k bigger then his child then break
            exch(k,j);
            k = j;
        }
    }

    private static boolean less (Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}
