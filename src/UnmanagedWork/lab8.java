package UnmanagedWork;
import java.util.Scanner;

public class lab8{

    public static int[] getMinimumInt(int[] listInts, int listSize){
        /**
         * @Author Robert Daniels
         * 
         * finds the minimum value in an array and returns a normalized array by subtracting that min value from each value
         * 
         * @param int[] listInts, a user input of integers populated into an array from main
         * @param int listSize, a user input of how many integers will be in the listInts
         */
        
        int[] normalized = new int[listSize];
        int minValue = listInts[0];


        for (int i = 0; i < listSize; ++i){
            if (listInts[i] < minValue){
                minValue = listInts[i];
            }
        }

        for (int i = 0; i < listSize; ++i){
            normalized[i] = listInts[i] - minValue;
        }

        return normalized;

    }

    public static void main(String[] args){

            Scanner scnr = new Scanner(System.in);
            int listSize = scnr.nextInt();
            int[] inputArray = new int[listSize];
            int[] normalized;

            for (int i = 0; i < listSize; ++i){
                inputArray[i] = scnr.nextInt();
            }
            
            normalized = getMinimumInt(inputArray, listSize);

            for (int i = 0; i < listSize; ++i){
                System.out.print(normalized[i] + " ");
            }
             

            scnr.close();
      }
    }