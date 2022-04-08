package UnmanagedWork.exam2prep.AlgoPractice;

/**
 * again, no error checking
 */
public class BinarySearch5 {
    
    public static void main(String[] args){

        SwapTwo swapper = new SwapTwo();

        int[] testArray = swapper.makeArray(50);
        int valueToFind = 23;
        int highIndex = testArray.length - 1;
        int lowIndex = 0;
        int midIndex;
        boolean found = false;
        int foundIndex = -1;

        while (highIndex >= lowIndex && !found){
            midIndex = (highIndex + lowIndex) / 2;

            if (testArray[midIndex] == valueToFind){
                foundIndex = midIndex;
                found = true;
            }
            else if (testArray[midIndex] > valueToFind){
                highIndex = midIndex - 1;
            }
            else{
                lowIndex = midIndex + 1;
            }
        }

        if (foundIndex == -1){
            System.out.printf("Couldn't find %d\n", valueToFind);
        }
        else{
            System.out.printf("I found %d at index %d", valueToFind, foundIndex);
        }

    }

}
