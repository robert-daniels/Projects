package Project2;

import java.util.*;
import java.io.*;

/**
 * Project 2, CS 205. Class provides functionality of a Phonebook contacts app that reads from a given file. No method overloading, implementation of the UML provided, all static methods per specification. All static methods prevents re-use of the recordCount function code block without substantially altering the specification. 
 * 
 * @Author: Robert Daniels
 * 
 */

public class PhoneContactsApp {
    
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        final int MAX_FIELDS = 3; // first, last, phoneNum as strings
        final int MAX_SIZE = 50; // small placeholder
        int input;
        String[][] fileContacts = new String[MAX_SIZE][MAX_FIELDS];
        int recordCount = 0;

        System.out.println("Please select a number from the menu: ");

        // ================== START USER MENU ==================

        do {
            System.out.println("1) Read contacts from file.");
            System.out.println("2) Display contacts");
            System.out.println("3) Show number of contacts");
            System.out.println("4) Add a contact");
            System.out.println("5) Remove a contact");
            System.out.println("6) Sort contacts by last name");
            System.out.println("7) Write contact list to file");
            System.out.println("8) Exit");
            System.out.print("Selection:  ");
            input = scnr.nextInt();
            scnr.nextLine();
            System.out.println("=========================");

            switch(input){
                case 1:
                    try{
                        fileContacts = readContactsFromFile(scnr, MAX_SIZE, MAX_FIELDS);
                    } catch (IOException e){
                        System.out.println("File not found. Please try again. If the file is not in the current directory, a full filepath less the extension must be provided.");
                        System.out.println();
                    }
                    
                    break;
                case 2:
                    displayContacts(fileContacts, scnr);
                    break;
                case 3:
                    recordCount = countContacts(fileContacts);
                    break;
                case 4:
                    if (recordCount == 0){
                        recordCount = countContacts(fileContacts); // prevents logic error of insert at [0]
                    }
                    recordCount = addContact(fileContacts, scnr, recordCount);
                    break;
                case 5:
                    if (recordCount == 0){
                        recordCount = countContacts(fileContacts);
                    }
                    recordCount = deleteContact(fileContacts, recordCount, scnr);
                    break;
                case 6:
                    if (recordCount == 0){
                        recordCount = countContacts(fileContacts);
                    }
                    sortContacts(fileContacts, recordCount, scnr);
                    break;
                
                case 8:
                    System.out.println("Exiting the PhoneContactsApp. Goodbye.");
                    System.exit(0);
            }
        } while (input != 9);

        // ================== /USER MENU ==================

    }

    /**
     * Asks user for a text filename without the .txt extension. If file is not in same
     * relative directory, the full filepath LESS the .txt must be given. Once
     * filename is given, opens a file object and reads standardized data as 
     * First, Last, Phone as strings. 
     * 
     * 
     * @param scnr with System.in stream from main
     * @return 2D String Array of first, last, phone
     * @throws IOException
     */
    // Done
    public static String[][] readContactsFromFile(Scanner scnr, int MAX_SIZE, int MAX_FIELDS) throws IOException{
        String fileName;
        String[][] fileData = new String[MAX_SIZE][MAX_FIELDS];
        FileInputStream fileByteStream = null;
        Scanner inFS = null;
        String contactLine;
        int rowIndex = 0;
        

        System.out.print("Enter a .txt filename to read in contacts. (Do not enter extension. Example: testFile.txt in the current directory should be entered as testFile: ");
        
        fileName = scnr.next();
        fileName = fileName + ".txt";

        fileByteStream = new FileInputStream(fileName);
        inFS = new Scanner(fileByteStream);


        while (inFS.hasNextLine() && rowIndex < MAX_SIZE){
            contactLine = inFS.nextLine().trim();
            String[] contactLineSplit = contactLine.split(",");
            
            fileData[rowIndex] = contactLineSplit;
            ++rowIndex;

            if (rowIndex == MAX_SIZE){
                System.out.printf("Warning! File import was truncated. Reason: Max Size of the array (%d records) was reached before end of file.\n", MAX_SIZE);
            }
        }

        inFS.close();

        System.out.printf("%d records were loaded into the array.\n\n", rowIndex);

        return fileData;

    }

    /**
     * Displays entire contents of the fileContacts array, 5 at a time. Should NOT
     * display null values. Array MUST be loaded before run (option 1), or 
     * nothing will print. 
     * 
     * @param fileContacts: a 2D array loaded from a file
     * @param scnr passed System.in stream from main. 
     */
    // Done
    public static void displayContacts(String[][] fileContacts, Scanner scnr){
        
        System.out.println("Displaying the contents...");

        for (int i = 0; i < fileContacts.length; ++i){
            if (fileContacts[i][0] == null){
                System.out.printf("Displayed %d contacts before finding a null. End display.\n", (i));
                System.out.println();
                break;
            }
            
            if ((i) % 5 == 0){
                System.out.println("Press any key to continue: ");
                scnr.nextLine();
            }

            System.out.println(Arrays.toString(fileContacts[i]));
        }

    }

    /**
     * Takes a filled 2D String array from main and returns the count of non-null rows as 
     * an int. 
     * 
     * 
     * @param fileContacts as loaded 2D String array from main
     * @return count of records in 2D array
     */
    // Done
    public static int countContacts(String[][] fileContacts){
        int recordCount = 0;

        for (int i = 0; i < fileContacts.length; ++i){
            if (fileContacts[i][0] == null){
                break;
            } else{
                ++recordCount;
            }
        }

        System.out.printf("Current Record Count is:  %d.\n", recordCount);
        System.out.println();

        return recordCount;

    }

    /**
     * Allows user to append new contact to lowest null index of a 2D array, provided 
     * enough space has been allocated.
     * 
     * @param fileContacts 2D String array loaded from option 1, file read
     * @param scnr object passed System.in from main
     * @param recordCount as an int. Initial number of records in oversized 2D array
     * @return new number of records in fileContacts as an int
     */
    // Done
    public static int addContact(String[][] fileContacts, Scanner scnr, int recordCount){
        char answer = 'n';

        if (recordCount >= fileContacts.length){
            System.out.println("The array is full. No additional contacts may be added.\n");
            return recordCount;
        }
        
        do{
        System.out.print("Enter new contact's first name: ");
        fileContacts[recordCount][0] = scnr.next();
        System.out.print("Enter new contact's last name: ");
        fileContacts[recordCount][1] = scnr.next();
        System.out.print("Enter new contact's phone number 999-999-9999:  ");
        fileContacts[recordCount][2] = scnr.next();
        
        System.out.printf("Adding %s, is this correct? y/n: ", Arrays.toString(fileContacts[recordCount]));
        
        answer = scnr.next().charAt(0);

        } while (answer == 'n');

        if (answer == 'y'){
            System.out.printf("Added: %s\n", Arrays.toString(fileContacts[recordCount]));
        }
         // TODO: possible logic error if no data checks

        return ++recordCount;
    }

    /**
     * Asks user for first and last name of a contact to delete from 2D array. If found, shifts all records recursively at
     * indexes greater than the array into the row that matches. If not found, alerts the user. 
     * 
     * 
     * @param fileContacts 2D String array of First Name, Last Name, Phone Number as string
     * @param recordCount number of non-null records in the fileContacts array as an int
     * @param scnr passed System.in from main
     * @return recordCount as an int, number of non-null records in oversized array.
     * 
     */

    public static int deleteContact(String[][] fileContacts, int recordCount, Scanner scnr){
        
        String[] recordToDelete = new String[2];
        boolean foundMatch = false;
        int foundIndex = -1;

        System.out.print("Enter the first name of the record to delete (case sensitive): ");
        recordToDelete[0] = scnr.next();
        System.out.print("Enter the last name of the record to delete (case sensitive):  ");
        recordToDelete[1] = scnr.next();
        
        for (int i = 0; i < recordCount; ++i){
            foundMatch = Arrays.asList(fileContacts[i]).containsAll(Arrays.asList(recordToDelete));
            
            if (foundMatch){
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1){
            System.out.printf("%s, %s was not found in the array. No deletion occurred.\n", recordToDelete[0], recordToDelete[1]);
            return recordCount;
        } 
        else {
            for (int i = foundIndex; i < recordCount; ++i){
                fileContacts[i] = fileContacts[i + 1];
            }
            System.out.printf("%s, %s was removed from the array.\n", recordToDelete[0], recordToDelete[1]);
            System.out.printf("%d records remain.\n", recordCount - 1);
            System.out.println();
        }
        return --recordCount;
    }

    /**
     * Sorts the array in ascending order by last name. Order is defined by 
     * lastName1.compareTo(lastName2). Does not use the Arrays.sort tool per specification.
     * Implements a basic insertion sort.
     * 
     * @param fileContacts: 2D array of Strings loaded from a text file
     * @param recordCount: current recordCount in fileContacts as an int
     * @param scnr passed System.in from main
     */
    
    // Done
    public static void sortContacts(String[][] fileContacts, int recordCount, Scanner scnr){
        int j;
        String[] tempHolding;

        for (int row = 1; row < recordCount; ++row){
            j = row;
            while (j > 0 && fileContacts[j][1].compareTo(fileContacts[j - 1][1]) < 0){

                tempHolding = fileContacts[j];
                fileContacts[j] = fileContacts[j - 1];
                fileContacts[j - 1] = tempHolding;

                --j;
            }
        }

        System.out.println("The array has been sorted by last name. Use option 2 to display.");
        
    }


   

}