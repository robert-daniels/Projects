package UnmanagedWork.exam2prep.ArraysAll;

import java.util.*;



/**
 * Practicing using 2D arrays
 */
public class TwoDPractice {
    
    public static void main(String[] args){
        int[][] array1 = new int[10][10];

        for (int i = 0; i < 10; ++i){
            for (int j = 0; j < 10; ++j){
                array1[i][j] = i + j;
            }
        }

        System.out.println(Arrays.deepToString(array1)); // remember deepToString!

        for (int i = 0; i < 10; ++i){
                System.out.println(Arrays.toString(array1[i]));
        }

    }
}
