package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;
/**
 * more practice
 */
public class BubbleSort7 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();
        int[] testArray = swapper.makeArray(20);
    

        System.out.printf("My array to start is %s\n", Arrays.toString(testArray));

        for (int i = 0; i < testArray.length; ++i){
            for (int j = 0; j < testArray.length - i - 1; ++j){
                if (testArray[j] > testArray[j + 1]){
                    swapper.swapTwo(testArray, j, j + 1);
                }
            }
        }

        System.out.printf("My array after the sort is %s\n", Arrays.toString(testArray));

    }
}
