package Project2;

import java.util.*;
import java.io.*;

/**
 * Project 2, CS 205. Class provides functionality of a Phonebook contacts app that reads from a given file. No method overloading, implementation of the UML provided.
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

        System.out.println("Please select a number from the menu");

        do {
            System.out.println("1) Read contacts from file.");
            System.out.println("2) Display contacts");
            System.out.println("3) Show number of contacts");
            System.out.println("4) Add a contact");
            System.out.println("5) Remove a contact");
            System.out.println("6) Update phone for a contact");
            System.out.println("7) Sort contacts by last name");
            System.out.println("8) Write contact list to file");
            System.out.println("9) Exit");
            System.out.print("Selection:  ");
            input = scnr.nextInt();
            scnr.nextLine();
            System.out.println("=========================");

            switch(input){
                case 1:
                    try{
                        fileContacts = readContactsFromFile(scnr, MAX_SIZE, MAX_FIELDS);
                    } catch (IOException e){
                        System.out.println("I couldn't find the file.");
                        System.out.println();
                    }
                    
                    break;
                case 2:
                    displayContacts(fileContacts, scnr);
            }
        } while (input != 9);
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


        while (inFS.hasNextLine()){
            contactLine = inFS.nextLine().trim();
            String[] contactLineSplit = contactLine.split(",");
            
            fileData[rowIndex] = contactLineSplit;
            ++rowIndex;
        }

        inFS.close();

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
}
