package UnmanagedWork.exam2prep.AlgoPractice;

/**
 * More test prep, see original for docstring
 */

public class BinarySearch4 {
    
    public static void main(String[] args){

        int[] testArray = new int[5];
        int lowIndex = 0;
        int highIndex = testArray.length - 1;
        int foundIndex = -1;
        int tryIndex;
        int valueToFind = 6;
        boolean found = false;

        for (int i = 1; i < 5; ++i){
            testArray[i] = i;
        }

        while (highIndex >= lowIndex && !found ){  // dont forget the found!
            tryIndex = (highIndex + lowIndex) / 2;

            if (testArray[tryIndex] == valueToFind){
                foundIndex = tryIndex;
                found = true;
            }
            else if (testArray[tryIndex] > valueToFind){
                highIndex = tryIndex - 1;
            }
            else if (testArray[tryIndex] < valueToFind){
                lowIndex = tryIndex + 1;
            }

        }

        if (foundIndex == -1){
            System.out.printf("Did not find %d\n", valueToFind);
        }
        else{
            System.out.printf("Found %d at index %d.\n", valueToFind, foundIndex);
        }


    }
}
