package old_alg;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SelectionSort {

    @Test
    public void solutionTest(){
        int [] actual = new int[]{9,6,3,8,5,2,1,4,7};
        int [] expected = new int[]{1,2,3,4,5,6,7,8,9};
        assertEquals(Arrays.toString(expected), Arrays.toString(new SelectionSort().sort(actual)));
    }

    public int[] sort(int [] array){
        int n = array.length;

        for(int i=0; i < n-1; i++){

            int minVal = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[minVal])
                    minVal = j;

            int temp = array[minVal];
            array[minVal] = array[i];
            array[i] = temp;

        }
        return array;
    }
}
