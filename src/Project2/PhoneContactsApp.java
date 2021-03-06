package Project2;

import java.util.*;
import java.io.*;

/**
 * Project 2, CS 205. Class provides functionality of a Phonebook contacts app that reads from a given file. No method overloading, implementation of the UML provided, all static methods per specification. All static methods prevents re-use of the recordCount function code block without substantially altering the specification. Some basic user input checking, though not exhaustive. 
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

        System.out.println("Welcome to the PhoneContactsApp. Please note that data should be imported into the application via Option 1 prior to operations.");
        System.out.println("\nPlease select a number from the menu: \n");

        // ================== START USER MENU ==================

        do {
            System.out.println("1) Read contacts from file.");
            System.out.println("2) Display contacts");
            System.out.println("3) Show number of contacts");
            System.out.println("4) Add a contact");
            System.out.println("5) Remove a contact");
            System.out.println("6) Sort contacts by last name");
            System.out.println("7) Write contact list to file");
            System.out.println("8) Update contact phone number");
            System.out.println("9) Exit");
            System.out.print("Selection:  ");
            input = scnr.nextInt();
            scnr.nextLine();
            System.out.println("=========================");

            switch(input){
                case 1:
                    try{
                        fileContacts = readContactsFromFile(scnr, MAX_SIZE, MAX_FIELDS);
                        recordCount = countContacts(fileContacts);
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
                    recordCount = addContact(fileContacts, scnr, recordCount);
                    break;
                case 5:
                    recordCount = deleteContact(fileContacts, recordCount, scnr);
                    break;
                case 6:
                    sortContacts(fileContacts, recordCount, scnr);
                    break;
                case 7:
                    try{
                        writeContactsToFile(fileContacts, recordCount, scnr);
                        
                    }
                    catch (IOException eIO){
                        System.out.println("That file is not currently available to write. Data were NOT written to file.");
                    }
                    break;
                case 8:
                    updateContact(fileContacts, recordCount, scnr);
                    break;
                case 9:
                    System.out.println("Exiting the PhoneContactsApp. Goodbye.");
                    System.exit(0);
                default:
                    System.out.println("Unknown choice. Please try again.\n");
            }
        } while (input != -1);

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
     * @param MAX_SIZE max size of the 2D array
     * @param MAX_FIELDS max columns in the 2D Array
     * @return 2D String Array of first, last, phone
     * @throws IOException
     */

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

        System.out.printf("\n%d records were loaded into the array.\n", rowIndex);

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

    public static void displayContacts(String[][] fileContacts, Scanner scnr){
        
        System.out.println("\nDisplaying the contents...");

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
    
    public static int countContacts(String[][] fileContacts){
        int recordCount = 0;

        for (int i = 0; i < fileContacts.length; ++i){
            if (fileContacts[i][0] == null){
                break;
            } else{
                ++recordCount;
            }
        }

        System.out.printf("\nCurrent Record Count is:  %d.\n", recordCount);
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

    public static int addContact(String[][] fileContacts, Scanner scnr, int recordCount){
        char answer = 'n';
        boolean validConfirm = false;

        if (recordCount >= fileContacts.length){
            System.out.println("The array is full. No additional contacts may be added.\n");
            return recordCount;
        }
        
        do{
        System.out.print("\nEnter new contact's first name: ");
        fileContacts[recordCount][0] = scnr.next();
        System.out.print("Enter new contact's last name: ");
        fileContacts[recordCount][1] = scnr.next();
        System.out.print("Enter new contact's phone number 999-999-9999:  ");
        fileContacts[recordCount][2] = scnr.next();
        
        System.out.printf("Adding %s, is this correct? y/n: ", Arrays.toString(fileContacts[recordCount]));
        
            do{
                answer = scnr.next().charAt(0);

                if (answer == 'y' || answer == 'n'){
                    validConfirm = true;
                } else{
                    System.out.println("Please enter 'y' for yes and 'n' for no: ");
                }

            } while (validConfirm != true);
            

        } while (answer == 'n');

        if (answer == 'y'){
            System.out.printf("Added: %s\n\n", Arrays.toString(fileContacts[recordCount]));
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
            System.out.printf("\n%s, %s was not found in the array. No deletion occurred.\n\n", recordToDelete[0], recordToDelete[1]);
            return recordCount;
        } 
        else {
            for (int i = foundIndex; i < recordCount; ++i){
                fileContacts[i] = fileContacts[i + 1];
            }
            System.out.printf("\nThe first %s, %s found was removed from the array.\n", recordToDelete[0], recordToDelete[1]);
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

        System.out.println("\nThe array has been sorted by last name. Use option 2 to display.\n");
        
    }

    /**
     * Asks user for desired filename to write the array to. Writes to such if available
     * 
     * @param fileContacts : 2D array loaded from prior file input
     * @param recordCount : number of current records in the 2D array
     * @param scnr passed System.in from main
     * @throws IOException
     */

    public static void writeContactsToFile(String[][] fileContacts, int recordCount, Scanner scnr) throws IOException{
         String userFileName;
         FileOutputStream fileStream;
         PrintWriter outFS;
         
         System.out.print("Preparing to write data to a file. Please enter the desired filename. (Do not provide file extensions) :  ");
         
         userFileName = scnr.next();
         userFileName = userFileName + ".txt";
         fileStream = new FileOutputStream(userFileName);
         outFS = new PrintWriter(fileStream);

         for (int i = 0; i < recordCount; ++i){
            if (i != (recordCount -1)){ 
                outFS.printf("%s,%s,%s\n", fileContacts[i][0], fileContacts[i][1], fileContacts[i][2]);
            }
            else{
                outFS.printf("%s,%s,%s", fileContacts[i][0], fileContacts[i][1], fileContacts[i][2]); // correct for blank line at end
            }
         }

         System.out.println("\nSuccessfully written to file\n");

         outFS.close();

    }

    /**
     * Allows user to update the PHONE NUMBER of a record in the array. A change in name should be considered a new record.
     * 
     * @param fileContacts an oversized 2D array from previous import from file
     * @param recordCount an int representing how many records are currently in the oversizes fileContacts 2D array
     * @param scnr passed System.in from main
     */
    
    public static void updateContact(String[][] fileContacts, int recordCount, Scanner scnr){
        String firstName;
        String lastName;
        boolean found = false;
        int recordToUpdate = -1;
        char answer = 'n';
        String newNumber;
        boolean validChoice = false;


        System.out.print("Enter the first name of the person you want to update the phone number for:  ");
        firstName = scnr.next();

        System.out.print("Enter the last name of the person you want to update the phone number for:  ");
        lastName = scnr.next();

        for (int i = 0; i < recordCount; ++i){
            if ((fileContacts[i][0].equals(firstName)) && (fileContacts[i][1].equals(lastName))){
                found = true;
                recordToUpdate = i;
                break;
            } 
        }

        if (!found){
            System.out.println("The name provided was not found.\n");
            return;
        } else{
            System.out.printf("The phone number for %s, %s is currently listed as %s. Do you want to update this? y/n ", fileContacts[recordToUpdate][0], fileContacts[recordToUpdate][1], fileContacts[recordToUpdate][2]);
        }
            
        
        do{
            answer = scnr.next().charAt(0);
    
            if (answer == 'y'){
                System.out.print("Enter the new phone number: ");
                newNumber = scnr.next();
                fileContacts[recordToUpdate][2] = newNumber;
                validChoice = true;

                System.out.printf("\nThe phone number has been updated to %s\n\n", newNumber);
            } else if (answer == 'n'){
                System.out.println("Update operation cancelled\n");
                validChoice = true;
                return;
            } else{
                System.out.print("You must enter 'y' for yes and 'n' for no: ");
            }
    
        } while (validChoice != true);

       
    }



   

}
