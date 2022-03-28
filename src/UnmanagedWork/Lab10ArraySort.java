package UnmanagedWork;
import java.util.*;

public class Lab10ArraySort{
    /**
     * @author Robert Daniels
     * Chapt 10 int[] array sort methods lab
     */

     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] masterArray = {11, 2, 34, 14, 95, 26, 7, 18, 9, 16};
        
        // test selection sort

        int[] selectionSortArray = masterArray.clone();
        System.out.printf("\n*Array* before selectionSort: %s\n", Arrays.toString(selectionSortArray));
        selectionSort(selectionSortArray);
        System.out.printf("\n*Array after selectionSort: %s\n", Arrays.toString(selectionSortArray));
        System.out.println("Press <enter> key to continue");
        input.nextLine();

        // test insertion sort

        int[] insertionSortArray = masterArray.clone();
        System.out.printf("\n*Array* before insertionSort: %s\n", Arrays.toString(insertionSortArray));
        insertionSort(insertionSortArray);
        System.out.printf("\n*Array after insertionSort: %s\n", Arrays.toString(insertionSortArray));
        System.out.println("Press <enter> key to continue");
        input.nextLine();

        
        // test bubble sort

        int[] bubbleSortArray = masterArray.clone();
        System.out.printf("\n*Array* before bubbleSort: %s\n", Arrays.toString(bubbleSortArray));
        bubbleSort(bubbleSortArray);
        System.out.printf("\n*Array after bubbleSort: %s\n", Arrays.toString(bubbleSortArray));
        System.out.println("Press <enter> key to continue");
        input.nextLine();

        // test improved bubble sort

        int[] improvedBubbleSortArray = masterArray.clone();
        System.out.printf("\n*Array* before improved bubbleSort: %s\n", Arrays.toString(improvedBubbleSortArray));
        improvedBubbleSort(improvedBubbleSortArray);
        System.out.printf("\n*Array after improved bubbleSort: %s\n", Arrays.toString(improvedBubbleSortArray));
        System.out.println("Press <enter> key to continue");
        input.nextLine();

        input.close();

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
         * @param int[] array from main containing test sequence
         */

         int sortedIndex = array.length; // at the start, assume none of the array is sorted
         int swapCounter = 0;
         int netRunCounter = 0;
         int startingIndex = 0;

         while (sortedIndex != 0){
            int i; 
            
            System.out.printf("- Starting at index %d, bubbling up highest numbers until index %d\n", startingIndex, array.length - 1); 

            for (i = 0; i < sortedIndex -1; ++i){
                
                if (array[i] > array[i + 1]){
                    swapTwo(array, i, i + 1);
                    ++swapCounter;
                 }
             }

             --sortedIndex;
             ++netRunCounter;

            System.out.printf("Array after loop starting at index %d : %s.\n\n", startingIndex, Arrays.toString(array));   
            ++startingIndex;
         }

         System.out.printf("Running bubbleSort, I swapped a total of %d times and 'ran' %d times!\n", swapCounter, netRunCounter);
     }
    
     public static void improvedBubbleSort(int[] array){ 
        /**
         * implements an improved bubbleSort algorithm on array passed from main.
         * DOES check to see if list is sorted mid-run and breaks early if so
         * For this implementation: 
         * 
         * Starts at index 0 and compares it to its next neighbor index. If greater, swap positions.
         * When the end is reached, start again at index 0 and proceed until the index before lowest sorted. 
         * If end is reached and no swaps have occurred, the list is sorted. 
         * 
         * @param int[] array from main containing test sequence
         */

         int sortedIndex = array.length; // at the start, assume none of the array is sorted
         int netSwapCounter = 0; // counter for the algorithm
         int netRunCounter = 0;
         int loopSwapCounter = 0; // counter for each looping
         int startingIndex = 0;
         boolean sorted = false;

         while (sortedIndex != 0 && !sorted){
            int i; 
            loopSwapCounter = 0;

            System.out.printf("- Starting at index %d, bubbling up highest numbers until index %d\n", startingIndex + 1, array.length - 1); 

            for (i = 0; i < sortedIndex -1; ++i){

                if (array[i] > array[i + 1]){
                    sorted = false;
                    swapTwo(array, i, i + 1);
                    ++netSwapCounter;
                    ++loopSwapCounter;
                 }

             }

             if (loopSwapCounter == 0){
                 sorted = true;
             }

             --sortedIndex;
             ++netRunCounter;

            System.out.printf("Array after loop starting at index %d : %s.\n\n", startingIndex, Arrays.toString(array));   
            ++startingIndex;


         }
         
         System.out.printf("Running improvedBubbleSort, I swapped a total of %d times and 'ran' %d times! That's %d loops less than a standard bubbleSort!\n", netSwapCounter, netRunCounter, (array.length - 1 - netRunCounter));
     }

     public static void selectionSort(int[] array){
        /**
         * Implements selectionSort algorithm. Starts by assuming entire list is unsorted.
         * Assumes index[0] is lowest value, then checks if any elements in unsorted portion
         * are less than that value. If so, swap once end of unsorted is reached. ++sortedPortion, 
         * take first index of unsorted as next starting. 
         * 
         * @param int array from main containing test sequence
         * 
         */

         int unsortedIndex = 0;  // at start, assume the entire array is unsorted. 
         int minNumberIndex = 0;

         while (unsortedIndex != array.length - 1){

            for (int i = unsortedIndex; i < array.length; ++i){
                if (array[i] < array[minNumberIndex]){
                    minNumberIndex = i;
                }
            }

            System.out.printf("--Found next smallest value: %d at index %d.\n", array[minNumberIndex], minNumberIndex);
            swapTwo(array, unsortedIndex, minNumberIndex);
            System.out.printf("Array after loop where i = %d: %s\n", unsortedIndex, Arrays.toString(array));

            ++unsortedIndex;
         }

     }

     public static void insertionSort(int[] array){
        /**
         * Implements insertionSort algorithm. Assumes there's an unsorted and sorted portion of the array. 
         * Traverses array and recursively inserts the next value in unsorted into its correct place in the
         * sorted array. The sorted array index ++, unsorted --.
         * 
         * @param int array from main containing test sequence
         */
        
        int unsortedIndex = 1; // assumes array[1] is the start of the unsorted
        int sortedIndex;

        for (int i = unsortedIndex; i < array.length; ++i){
            sortedIndex = i;
            System.out.printf("Insert %d into sorted numbers before %d\n", array[i], array[i]);

            while (sortedIndex > 0 && (array[sortedIndex] < array[sortedIndex - 1])){
                swapTwo(array, sortedIndex, sortedIndex - 1);
                --sortedIndex;
            }
        }

     }



}