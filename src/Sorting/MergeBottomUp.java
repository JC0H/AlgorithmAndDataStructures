package Sorting;

public class MergeBottomUp {

    public static void sort(Comparable [] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int sz = 1; sz <= n; sz = sz + sz) {
            for (int lo = 0; lo <= n - sz; lo *= 2) {
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
            }
        }
    }

    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }


    public static void main(String[] args) {
        String[] w = new String[]{"g","h","k","q","w","e","r","t","y","u"
                        ,"i","o","a","s","d","f","h","z","x","c","v","b","n",
        };
        sort(w);
    }

    public void print(Comparable[] l){
        for (int i = 0; i < l.length; i++)
            System.out.print(l[i] + " ");
    }

    private static boolean less (Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }


    public static boolean isSorted( Comparable[] a){
        for (int i = 0; i < a.length; i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }
}
