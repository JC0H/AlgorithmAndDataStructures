package old_alg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Fibonacci {

    static int fibRec(int n){
       if (n <= 1){
           return n;
       }
       return fibRec(n - 1) +fibRec( n - 2);
    }

    static int fibIter(int n){
        int fib[] = new int[n+2];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    @Test
    public void solutionIter(){
        int actual = 7;
        int expected = 13;
        assertEquals(expected, new Fibonacci().fibIter(actual));
    }

    @Test
    public void solutionRec(){
        int actual = 7;
        int expected = 13;
        assertEquals(expected, new Fibonacci().fibRec(actual));
    }
}
