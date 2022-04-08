package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * more practice
 */
public class SelectionSort5 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();
        int minIndex = 0;
        int[] testArray = swapper.makeArray(40);

        System.out.printf("My array before: %s\n", Arrays.toString(testArray));

        for (int i = 0; i < testArray.length; ++i){
            minIndex = i;
            for (int j = i; j < testArray.length; ++j){
                if (testArray[j] < testArray[minIndex]){
                    minIndex = j;
                }
            }
            swapper.swapTwo(testArray, i, minIndex);
        }

        System.out.printf("My array after: %s\n", Arrays.toString(testArray));

    }
}
