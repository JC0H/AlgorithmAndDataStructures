package old_alg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Factorial {

    public static int factIter(int x){
        int result = 1;

        for (int i = 1; i <= x; i++){
            result *=i;
        }

        return result;
    }

    public static int factRec(int x){
        if (x == 0){
            return 1;
        }
        return x * factIter(x-1);
    }

    @Test
    public void testRec(){
        int actual = 5;
        int expected = 120;
        assertEquals(expected, new Factorial().factRec(actual));
    }

    @Test
    public void testIter(){
        int actual = 5;
        int expected = 120;
        assertEquals(expected, new Factorial().factIter(actual));
    }
}
