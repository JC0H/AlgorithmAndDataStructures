package alg;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearch {

    int binarySearchRec(int arr[], int l, int r, int x) {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearchRec(arr, l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearchRec(arr, mid+1, r, x);
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }

    int binarySearchIter(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    @Test
    public void binaryRecSearch(){
        int [] actualArray = new int[]{1,2,3,4,5,6,7,8,9};
        int expected = 2;
        assertEquals(expected, new BinarySearch().binarySearchRec(actualArray,0,actualArray.length-1,3));
    }

    @Test
    public void binaryIterSearch(){
        int [] actualArray = new int[]{1,2,3,4,5,6,7,8,9};
        int expected = 2;
        assertEquals(expected, new BinarySearch().binarySearchIter(actualArray,3));
    }
}
