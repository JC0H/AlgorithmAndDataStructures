package Algorithms_FourthEdition.Part_I.II_Sorting.l_Elementary_Sorts;

public class HeapSort {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int k = N/2;k >=1 ; k--){
            sink(a,k,N);
        }
        while ( N > 1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }

    private static boolean less (Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static void sink(Comparable[] a, int k, int N){
        while ( 2*k <= N){
            int j = 2*k;
            if ( j < N && less(j,j+1)) j++;
            if (!less(k,j)) break;       //if k bigger then his child then break
            exch(a,k,j);
            k = j;
        }
    }

    public static void exch(Comparable a[], int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
