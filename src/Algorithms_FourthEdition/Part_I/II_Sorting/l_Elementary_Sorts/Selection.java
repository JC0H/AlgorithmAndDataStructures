package Algorithms_FourthEdition.Part_I.II_Sorting.l_Elementary_Sorts;

/*
 One of the simplest sorting algorithms works as follows: First, find the smallest item in the array
and exchange it with the first entry (itself if the first entry is already the smallest). Then,
find the next smallest item and exchange it with the second entry. Continue in this way until the entire
array is sorted. This method is called selection sort because it works by repeatedly selecting the smallest
remaining item.
 As you can see from the implementation in Algorithm 2.1, the inner loop of selection sort is just a compare
to test a current item against the smallest item found so far (plus the code necessary to increment the
current index and to check that it does notexceed the array bounds); it could hardly be simpler. The work
of moving the items around falls outside the inner loop: each exchange puts an item into its final position,
so the number of exchanges is N.
*/
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
