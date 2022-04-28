package UnmanagedWork;

import java.util.*;

/**
 * Basic Exercises working with ArrayList methods
 * @Author: Robert Daniels
 * ADAPTED FROM SEED FILE provided by Perla Weaver, Johnson County Community College
 */

public class ArrayListExample {
    public static void main(String[] args) {
		// Variables - these should be enough, but you may add additional variables if you need to

		Scanner scnr = new Scanner(System.in);
		int number, index;
		ArrayList<Integer> rateList = new ArrayList<Integer>();

		// get values from user and put them in the rateList
		System.out.print("Enter four integer values: ");
		for (int i = 0; i < 4; ++i){
            rateList.add(scnr.nextInt());
        }
		
		
		
		System.out.println("List values: " + rateList);
		
		// get number from user
		
        System.out.print("Enter a number to add: ");
        number = scnr.nextInt();
		
		
		
		//add number to the arrayList
		rateList.add(number);



		System.out.println("List values: " + rateList);
		
		// check if value added is in the list
		System.out.print("Enter a number to check: ");
        number = scnr.nextInt();

        containsValue(rateList, number); 
		
		
		// get value and index from user
		System.out.print("Enter a number to add: ");
        number = scnr.nextInt();
        System.out.print("At index value: ");
        index = scnr.nextInt();
	
		
		// add number at index value
		rateList.add(index, number);

		System.out.println("List values: " + rateList);

		// get value and index from user to check
		System.out.print("Enter a number to check: ");
        number = scnr.nextInt();
        System.out.print("At index value: ");
        index = scnr.nextInt();


		
		// check if value exists at specific index location
		containsValue(rateList, number, index);

        System.out.println("List values: " + rateList);

	}


	/**
	 * Checks if the value is contained in the rateList
	 * Displays an appropriate message to indicate if the value is in, or is not in the list
	 *
	 * @param rateList as ArrayList<Integer>
	 * @param value as int number to check rateList contains
	 */
	
	public static void containsValue(ArrayList<Integer> rateList, int value) {
		if (rateList.contains(value)){
            System.out.printf("The number %d is in the list\n", value);
        } else {
            System.out.printf("The number %d is not in the list\n", value);
        }


	}


	/**
	 * Checks if the value is contained in the rateList at the index location
	 * Displays an appropriate message to indicate if the value is in the location,
	 * if it is in the list but in another location, or is not in the list 
	 *
	 * @param rateList as ArrayList<Integer> passed from main
	 * @param value to check as int number provided by user from main
	 * @param index of value as int number provided by user from main
	 */
	public static void containsValue(ArrayList<Integer> rateList, int value, int index) {
        

        if (rateList.contains(value)){
            if (rateList.get(index) == value){
                System.out.printf("The number %d is at index %d.\n", value, index);
            } else {
                System.out.printf("The number %d is not at index %d.\n", value, index);
                System.out.printf("The number %d is first found at index %d\n", value, rateList.indexOf(value));
            }
        } else {
            System.out.printf("The number %d is not in the list\n", value);
        }

	}
}
