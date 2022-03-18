import java.util.*;

public class Lab10ArraySort{
    /**
     * @author Robert Daniels
     * Chapt 10 int[] array sort methods lab
     */

     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] masterArray = {11, 2, 34, 14, 95, 26, 7, 18, 9, 16};

        // test bubble sort

        int[] bubbleSortArray = masterArray.clone();
        System.out.printf("\n*Array* before bubbleSort: %s\n", Arrays.toString(bubbleSortArray));
        bubbleSort(bubbleSortArray);
        System.out.printf("\n*Array after bubbleSort: %s\n", Arrays.toString(bubbleSortArray));
        System.out.println("Press <enter> key to continue");
        input.nextLine();

     }

     public static void swapTwo(int[] array, int index1, int index2){
        /**
         * When given an array and two indexes, swaps the position of the values at the two indexes
         * 
         * @param int[] array passed from main. 
         * @param index1, index of first swap value in int[] array
         * @param index2, index of second swap value in int[] array
         */
        
         int tempValue;

         System.out.printf("\t---Swap elements at index %d and %d\n", index1, index2);
         tempValue = array[index1];
         array[index1] = array[index2];
         array[index2] = tempValue;
     }

     public static void bubbleSort(int[] array){
        /**
         * implements a basic bubbleSort algorithm on array passed from main.
         * does NOT check to see if list is sorted mid-run
         * For this implementation: 
         * 
         * Starts at index 0 and compares it to its next neighbor index. If greater, swap positions.
         * When the end is reached, start again at index 0 and proceed until the index before lowest sorted. 
         * 
         * @param int[] array from main 
         */

         int sortedIndex = array.length; // at the start, assume none of the array is sorted
         int swapCounter = 0;
         int startingIndex = 0;

         while (sortedIndex != 0){
            int i; 
            
            System.out.printf("- Starting at index %d, bubbling up highest numbers until index %d\n", startingIndex, array.length - 1); 

            for (i = 0; i < sortedIndex -1; ++i){
                
                if (array[i] > array[i + 1]){
                    swapTwo(array, i, i + 1);
                    ++swapCounter;
                 }
                 //System.out.printf("--Array after loop with i = %d: ", i);
                 //System.out.println(Arrays.toString(array));
             }

             --sortedIndex;

            System.out.printf("Array after loop starting at index %d : %s.\n\n", startingIndex, Arrays.toString(array));   
            ++startingIndex;
         }
         System.out.printf("Running bubbleSort, I swapped a total of %d times!\n", swapCounter);
     }

}