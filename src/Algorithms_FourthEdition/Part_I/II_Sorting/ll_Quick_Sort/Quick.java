package Algorithms_FourthEdition.Part_I.II_Sorting.ll_Quick_Sort;

/*
Quicksort is popular because it is not difficult to implement, works well for a variety of different
kinds of input data, and is substantially faster than any other sorting method in typical applications.
It is in-place (uses only a small auxiliary stack), requires time proportional to N log N on the average
to sort N items, and has an extremely short inner loop.
*/

public class Quick {

    public void sort(Comparable[] a){
        //TODO : method to shuffle array
        sort(a,0,a.length -1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j =  partition(a,lo,hi);
        sort(a,lo, j-1);
        sort(a,j+1, hi);
    }

    private static int partition (Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi;
        while(true){
            if (less(a[++i],a[lo])) if (i == hi) break;
            if (less(a[lo],a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public void print(Comparable[] l){
        for (int i = 0; i < l.length; i++)
            System.out.print(l[i] + " ");
    }

    private static boolean less (Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable a[], int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean isSorted( Comparable[] a){
        for (int i = 0; i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
}
