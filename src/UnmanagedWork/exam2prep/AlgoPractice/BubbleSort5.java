package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * more test prep, see original for docstring
 */
public class BubbleSort5 {

    public static void main(String[] args){
        SwapTwo swapper = new SwapTwo();
        int[] testArray = swapper.makeArray(15);

        for (int i = 0; i < testArray.length; ++i){
            for (int j = 1; j < testArray.length - i - 1; ++j){
                if (testArray[j] > testArray[j + 1] ){
                    swapper.swapTwo(testArray, i, j);
                }
            }
        }

        System.out.println(Arrays.toString(testArray));
        
        
    }
}