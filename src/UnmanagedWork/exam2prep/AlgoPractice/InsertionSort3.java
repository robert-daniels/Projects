package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * Again, practice only. See original for docstring
 */

public class InsertionSort3 {
   
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();
        int[] testArr = {5, 4, 3, 2, 1};
        int j;

        for (int i = 1; i < testArr.length; ++i){
            j = i;
            while(j > 0 && testArr[j] < testArr[j - 1]){
                swapper.swapTwo(testArr, j, j - 1);
                --j;
            }
        }

        System.out.println(Arrays.toString(testArr));
    }
}
