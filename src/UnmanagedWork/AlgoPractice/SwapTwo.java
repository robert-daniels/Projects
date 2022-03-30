package UnmanagedWork.AlgoPractice;
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
}
