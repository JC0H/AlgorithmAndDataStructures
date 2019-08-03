package old_alg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BubbleSort {
    public int[] sort(int [] array){
        int n = array.length;

        for(int i=0; i < n; i++){
            for (int j = 1; j < (n-i); j++){
                if (array[j-1] > array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    @Test
    public void solutionTest(){
        int [] actual = new int[]{9,6,3,8,5,2,1,4,7};
        int [] expected = new int[]{1,2,3,4,5,6,7,8,9};
        assertEquals(Arrays.toString(expected), Arrays.toString(new BubbleSort().sort(actual)));
    }
}
