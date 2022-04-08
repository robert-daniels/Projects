package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;
/**
 * And again
 */
public class BubbleSort6 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();
        int[] testArray = swapper.makeArray(20);

        for (int i = 0; i < testArray.length; ++i){
            for(int j = 0; j < testArray.length - i - 1; ++i){
                if (testArray[j] > testArray[j + 1]){
                    swapper.swapTwo(testArray, j, j + 1);
                }
            }
        }

        System.out.println(Arrays.toString(testArray));


    }
}
