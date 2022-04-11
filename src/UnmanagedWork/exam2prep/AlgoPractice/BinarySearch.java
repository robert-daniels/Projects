package UnmanagedWork.exam2prep.AlgoPractice;

import java.util.*;

/**
 * More algo practice. 
 * 
 * Binary Search: Assuming a sorted list, check middle value. 
 * If not the correct item, set the new range to search as either
 * below or above that index as relavent. Iterate until value is found
 * 
 */


public class BinarySearch {
    
    public static void main(String[] args){

        String testString = "Hello, my name is Robert.";

        String[] splitString = testString.split("");
        Arrays.sort(splitString); // will almost certainly have to sort this "by hand" on test

        String valueToFind = "n"; // for sake of argument
        int lowIndex = 0;
        int highIndex = splitString.length - 1;
        int middleIndex;
        
        while (highIndex >= lowIndex){
            middleIndex = (highIndex + lowIndex) / 2; 

            if (splitString[middleIndex].compareTo(valueToFind) > 0){
                highIndex = middleIndex - 1;
            } 
            else if (splitString[middleIndex].compareTo(valueToFind) < 0){
                lowIndex = middleIndex + 1;
            }
            else if (splitString[middleIndex].equals(valueToFind)){
                System.out.println("Found at Index: " + middleIndex);
                break;
            }
            else{
                System.out.println(-1);
                break;
            }

            }
    
    }
}
