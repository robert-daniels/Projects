package Project2;

import java.util.*;
import java.io.*;

/**
 * Project 2, CS 205. Class provides functionality of a Phonebook contacts app that reads from a given file. No method overloading, direct implementation of the UML provided.
 * @see: PhoneContactsAppTester.java for testing
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
        } while (input != 9);
    }
}
