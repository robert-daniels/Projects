import java.util.Scanner;

/**
 * Lab 10, take up to 10 integers and print each iteration of the selection sort array descending order. 
 * 
 */

 public class Lab10Selection{

   /**
    * Uses a selection sort algo to sort the given array in descending order. Prints out the array each step of the loop. 
    *
    * @param numbers : An int[] loaded from user input, up to 10 elements
    * @param numElements : number of elements in the array, not including the -1 sentinel
    */
  
   public static void selectionSortDescendTrace(int [] numbers, int numElements) {
       
        int maxIndex = 0;
        int tempHolding = 0;

        for (int i = 0; i < numElements -1; ++i){
           maxIndex = i;
           for (int innerLoopI = i + 1; innerLoopI < numElements; ++innerLoopI){
                
                if (numbers[innerLoopI] > numbers[maxIndex]){
                    maxIndex = innerLoopI;
                }
           }
        
           if (maxIndex != i){
               tempHolding = numbers[i];
               numbers[i] = numbers[maxIndex];
               numbers[maxIndex] = tempHolding;
           }

           for (int ele = 0; ele < numElements; ++ele){
               System.out.print(numbers[ele] + " ");
           }
           System.out.println("");


       }
   }
   
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int i = 0;
      int input = 0;
      int numElements = 0;
      int [] numbers = new int[10];

      while (input != -1){
          input = scnr.nextInt();
          numbers[i] = input;
          ++numElements;
          ++i;
      }

      --numElements; // compensate for the -1 going in
      
      selectionSortDescendTrace(numbers, numElements);

   }
}
