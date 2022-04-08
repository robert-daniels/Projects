package UnmanagedWork.exam2prep.AlgoPractice;
/**
 * SwapTwo...swaps two array elements at given locations, I don't want to code this every time. 
 * 
 */


public class SwapTwo {
    
    public void swapTwo(int[] passedArray, int index1, int index2){

        int tempHolding = passedArray[index1];
        passedArray[index1] = passedArray[index2];
        passedArray[index2] = tempHolding;

    }

/**
 * Generates a testArray to work the sort algorithms with. 
 * 
 * @param size as an int (the size of the array)
 * @return int[] sorted descending
 */

    public int[] makeArray(int size){
        int[] testArray = new int[size];
        
        for (int i = size - 1; i >= 0; --i){
            testArray[i] = i;
        }

        return testArray;
    }
}
