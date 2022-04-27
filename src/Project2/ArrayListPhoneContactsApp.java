package Project2;


import java.io.*;
import java.util.*;

/**
 * Alternative method to generate a phone contacts app with OOP. 
 * @Author: Robert Daniels
 * AS ADAPTED FROM SEED FILE provided by Perla Weaver, Johnson County Community College. 
 * 
 */

public class ArrayListPhoneContactsApp {


	/**
	 * Reads in data from a text file provided. Each data point is pressed into a new Contact object. @see ~/src/Project2/Contact.java
	 * 
	 * 
	 * @param scnr passed a fileInputStream
	 * @return an ArrayList<Contact>
	 * @throws IOException
	 */
	public static ArrayList<Contact> readContactsFromFile(Scanner scnr) throws IOException {
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		String fileName;
		String line;
		FileInputStream file;
		String[] lineArray;
		Contact aContact;

		System.out.print("Please provide file to import, do not include .txt extension: ");
		fileName = scnr.next();
		fileName += ".txt";
		file = new FileInputStream(fileName);
		Scanner filesc = new Scanner(file);

		while (filesc.hasNext()) {
			line = filesc.nextLine();
			line = line.trim();

			lineArray = line.split(",");
			aContact = new Contact(lineArray[0], lineArray[1], lineArray[2]);
			contactList.add(aContact);
		}

		filesc.close();

		return contactList;
	}

	/**
	 * Iterates through ArrayList 10 Contact objects at a time. "Unpacks" the Contact object to display key fields.
	 * 
	 * @param contactList as a 1D ArrayList<Contact> @see ~/src/Project2/Contact.java
	 * @param scnr passed System.in from main
	 */

	public static void displayContacts(ArrayList<Contact> contactList, Scanner scnr) {

		int i = 0;
		for (Contact contact : contactList) {
			i++;
			System.out.println(contact.getFirstName() + ", " + 
					contact.getLastName() + ", " + contact.getPhone());

			if (i % 10 == 0) {
				scnr.nextLine();
				System.out.print("Press any key to continue...\n");
				scnr.nextLine();
			}
		}
	}

	/**
	 * Uses built-in ArrayList.size() method to return size
	 * 
	 * @param contactList an ArrayList<Contact>
	 * @return number of elements in ArrayList as an int
	 */

	public static int countContacts(ArrayList<Contact> contactList) {
		
		return contactList.size();
	}

	/**
	 * Asks user for First Name / Last Name / Phone number. Loads these data into a new Contact object, which is then appended to the ArrayList
	 * 
	 * @param contactList an ArrayList<Contact>
	 * @param scnr passed System.in from main
	 */
	public static void addContact(ArrayList<Contact> contactList, Scanner scnr) {

		String firstName;
		String lastName;
		String phone;

		System.out.print("Enter first name: ");
		firstName = scnr.next();

		System.out.print("Enter last name: ");
		lastName = scnr.next();

		System.out.print("Enter phone: ");
		phone = scnr.next();

		try{
			
			Contact newContact = new Contact(firstName, lastName, phone);
			contactList.add(newContact);	
			System.out.printf("%s, %s, %s added to the listing.\n", newContact.getFirstName(), newContact.getLastName(), newContact.getPhone());
		} catch (Exception e){
			System.out.println("Something went wrong adding a contact to the listing.");
		}
		
	}
	
	/**
	 * Allows user to delete a Contact object held in the ArrayList, provided it's found by First and Last Name
	 * 
	 * @param  an ArrayList<Contact>
	 * @param scnr passed System.in from main
	 */

	public static void deleteContact(ArrayList<Contact> contactList, Scanner scnr) { 
		Contact contactToDelete = null;
		boolean success = false;
		String firstName;
		String lastName;

		System.out.print("Enter first name: ");
		firstName = scnr.next();

		System.out.print("\nEnter last name: ");
		lastName = scnr.next();

		contactToDelete = new Contact(firstName, lastName);

		success = contactList.remove(contactToDelete);

		if (success) 
			System.out.println("Contact removed");
		else
			System.out.println("Contact not found");

	}

	/**
	 * Allow user to update a contact's phone number
	 * 
	 * @param contactList an ArrayList<Contact>
	 * @param scnr passed System.in from main
	 */

	public static void updateContact(ArrayList<Contact> contactList, Scanner scnr) { 
	
		Contact contactToFind, contactToUpdate;
		int indexToUpdate;
		String firstName;
		String lastName;
		String newPhone;


		System.out.print("Enter first name: ");
		firstName = scnr.next();

		System.out.print("Enter last name: ");
		lastName = scnr.next();

		contactToFind = new Contact(firstName, lastName);
		
		indexToUpdate = contactList.indexOf(contactToFind);
		
		// the contact was not found
		if (indexToUpdate == -1) {
			System.out.println("Contact not found");
		}
		else { // the contact was found

			
			contactToUpdate = contactList.get(indexToUpdate);

			System.out.print("Enter the new phone number: ");
			newPhone = scnr.next();

			contactToUpdate.setPhone(newPhone);
			
			// if all works out this line should display the contact with a new phone number
			System.out.println("Updated Contact Info: " +  contactToUpdate);

		}

	}
	
	/**
	 * Sorts contacts by last name
	 * 
	 * @param contactList an ArrayList<Contact>
	 */
	
	public static void sortContacts(ArrayList<Contact> contactList) {

		Collections.sort(contactList);
		System.out.println("Sorted by last name");
	}

	/**
	 * Allows user to choose a name for a new file and write 
	 * 
	 * @param contactList
	 * @param scnr
	 * @throws IOException
	 */

	public static void writeContactsToFile(ArrayList<Contact> contactList, Scanner scnr) throws IOException {
	
		String fileName;
		String userFileInput;
		FileOutputStream fileStream = null;
		PrintWriter outFS = null;
		
		System.out.print("Preparing to write data to a file. Please enter the desired filename. (Do not provide file extensions) :  ");
        
		userFileInput = scnr.next();
		fileName = userFileInput + ".txt";
		fileStream = new FileOutputStream(fileName);
		outFS = new PrintWriter(fileStream);

		for (int i = 0; i < contactList.size(); ++i){
			outFS.printf("%s\n", contactList.get(i).toString());
		}


		// flush and close the output streams
		outFS.flush();
		fileStream.close();
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Contact> contactList = null;
		int choice = -1;
		do {
			System.out.println();
			System.out.println("1) read contacts from file");
			System.out.println("2) display contacts");
			System.out.println("3) show number of contacts");
			System.out.println("4) add a contact");
			System.out.println("5) remove a contact");
			System.out.println("6) update phone number for contact");
			System.out.println("7) sort contacts by last name");
			System.out.println("8) write contact list to file");
			System.out.println("9) exit");
			System.out.println();
			System.out.print("Enter your choice: ");

			choice = scnr.nextInt();

			switch(choice) {
			case 1:
				try{
					contactList = readContactsFromFile(scnr);
					System.out.println("Import Successful");
				} catch (IOException e){
					System.out.println("Cannot find a readable file from the info provided.");
				}
				break;

			case 2:
				displayContacts(contactList, scnr);
				break;

			case 3:
				System.out.println("Number of contacts: " + countContacts(contactList));
				break;

			case 4:
				addContact(contactList, scnr);
				break;

			case 5:
				deleteContact(contactList, scnr);
				break;

			case 6:
				updateContact(contactList, scnr);
				break;

			case 7:
				sortContacts(contactList);
				break;

			case 8:
				try{
					writeContactsToFile(contactList,scnr);
					System.out.println("Write Successful");
				} catch (IOException e){
					System.out.println("Something went wrong with the file export.");
				}
				
				break;

			}
			
			scnr.nextLine();


		} while (choice != 9);

		if (choice == 9) {
			scnr.close();
			System.out.println("Program ended");
		}

		
	}

}
