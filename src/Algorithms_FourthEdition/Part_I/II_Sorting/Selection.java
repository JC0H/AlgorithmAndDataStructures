package Algorithms_FourthEdition.Part_I.II_Sorting;

public class Selection {

    public void sort(Comparable[] a){
       for (int i = 0; i < a.length; i++){
           int min = i;
           for (int j = i +1; j < a.length; j++)
               if (less(a[j],a[min])) min = j;
           exch(a,i,min);
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
