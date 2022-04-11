package UnmanagedWork.exam2prep.ArraysAll;

import java.util.*;



/**
 * Practicing using 2D arrays
 */
public class TwoDPractice {
    
    public static void main(String[] args){
        int[][] array1 = new int[10][8];
        int counter = 0;
        int valueToFind = 3;

        for (int i = 0; i < 10; ++i){
            for (int j = 0; j < 8; ++j){
                array1[i][j] = i + j;
            }
        }

        System.out.println(Arrays.deepToString(array1)); // remember deepToString!

        for (int i = 0; i < 10; ++i){
                System.out.println(Arrays.toString(array1[i]));
        }

        int[][] array2 = {
                            {3, 2, 1},
                            {6, 5, 4},
                            {9, 8, 7, 6, 5}
                         };

        System.out.printf("The length of the third array in array1 is %d\n", array1[2].length);

        System.out.printf("The length of the third array in array2 is %d\n", array2[2].length);
                        
        for (int row = 0; row < array2.length; ++row){
            for (int column = 0; column < array2[row].length; ++column){
                counter += array2[row][column];
            }
        }

        System.out.printf("The sum of all the elements in array2 is: %d", counter);

    }
}
