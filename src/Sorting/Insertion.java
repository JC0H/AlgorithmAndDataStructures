package Sorting;

public class Insertion {

    public void sort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            for (int j = 1; j > 0; j--){
                if (less(a[j],a[j-1]))
                    exch(a,j,j-1);
                else
                    break;
            }
        }
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
