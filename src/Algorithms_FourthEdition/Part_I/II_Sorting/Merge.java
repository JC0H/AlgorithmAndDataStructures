package Algorithms_FourthEdition.Part_I.II_Sorting;

public class Merge {

    private Comparable[] aux ;

    private void merge(Comparable[]a, Comparable[] aux, int low,int mid, int hi){
        int i = low; int j = hi;

        for (int k = low; k <=hi ;k++)
            aux[k] = a[k];

        for (int k = low;k <=hi; k++){
            if      (i > mid)            a[k] = aux[j++];
            else if (j > hi)             a[k] = aux[i++];
            else if (less(aux[j],aux[i]))a[k] = aux[j++];
            else                         a[k] = aux[i++];
        }
    }

    public void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }

    private void sort(Comparable[] a, Comparable[] aux, int low, int hi) {
        if (low >= hi) return;
        int mid = low + (hi - low)/2;
        sort(a,aux,low,mid);
        sort(a,aux,mid+1,hi);
        if (!less(a[mid+1],a[mid])) return;
        merge(a,aux,low,mid,hi);
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
