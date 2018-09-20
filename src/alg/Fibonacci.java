package alg;

public class Fibonacci {

    static int fibRec(int n){
        if (n <= 1)
            return n;
        return fibRec(n-1) + fibRec(n-2);
    }

    static int fibIter(int n){
        int f[] = new int[n+2];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    public static void main (String args[])
    {
        int n = 7;
        System.out.println(fibRec(n));
        System.out.println(fibIter(n));
    }
}
