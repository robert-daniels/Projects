package UnmanagedWork.AlgoPractice;

import java.util.*;

/**
 * Re-practice binary search. See original for actual docstring
 */


public class BinarySearch2 {
    
    public static void main(String[] args){

        Scanner scnr = new Scanner(System.in); // yes, Very Not Good. It's just me, i'll type in an int.
        int userNum = scnr.nextInt();

        int[] testArray = {1, 2, 3, 4, 5};
        int lowIndex = 0;
        int highIndex = testArray.length - 1;
        boolean found = false;
        

        while (highIndex >= lowIndex && !found){
            int midIndex = (lowIndex + highIndex) / 2;
            
            if (testArray[midIndex] == userNum){
                System.out.printf("Found %d at index %d. Goodbye\n", userNum, midIndex);
                found = true;
                
            }
            else if (testArray[midIndex] > userNum){
                highIndex = midIndex - 1;
            }
            else if (testArray[midIndex] < userNum){
                lowIndex = midIndex + 1;
            }
        }

        if (found == false){
            System.out.println(-1);
        }
            scnr.close();
    }
}
