package Algorithms_FourthEdition.Part_I.II_Sorting;

public class Shell {

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h +1;
        while(h>=1){
            for (int i = h; i < N ; i++){
                for (int j = i;j >= h && less(a[j],a[j-h]);j-=h){
                    System.out.println(j-=h);
                    exch(a,j,j-h);}
            }
            h = h/3;
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

    public static void main(String[] args) {
        String[] w = new String[]{"g","h","k","q","w","e","r","t","y","u"
        //        ,"i","o","a","s","d","f","h","z","x","c","v","b","n",
        };
        sort(w);
    }

}
