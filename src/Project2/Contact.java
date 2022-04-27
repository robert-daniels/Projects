package Project2;


public class Contact implements Comparable<Contact> {

	/* declare three private string instance variables
	 * firstName, lastName, phone
	 */

	private String firstName;
	private String lastName;
	private String phone;

	
	/**
	 * Create a constructor from three parameters 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 */
	public Contact(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;

	}
	
	/**
	 * Create a constructor from two parameters.
	 * Make the phone default to an empty string.
	 * @param firstName
	 * @param lastName
	 */
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = "";
		
	}
	
	/* declare getter and setters for all the instance variables
	 * you should end up with six methods 
	 */

	
	 public void setFirstName(String firstName){
		 this.firstName = firstName;
	 }

	 public void setLastName(String lastName){
		 this.lastName = lastName;
	 }

	 public void setPhone(String phone){
		 this.phone = phone;
	 }

	 public String getFirstName(){
		 return firstName;
	 }

	 public String getLastName(){
		 return lastName;
	 }

	 public String getPhone(){
		 return phone;
	 }


	@Override
	public String toString() {
		return "[" + getFirstName() + ", " + getLastName() + ", " + getPhone() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		
		Contact aContact = (Contact) obj;

		return ((getFirstName().compareTo(aContact.getFirstName()) == 0) && 
				(getLastName().compareTo(aContact.getLastName()) == 0));
	}

	@Override
	public int compareTo(Contact aContact) {
		//
		int compareLastValue = getLastName().compareTo(aContact.getLastName());
		if ( compareLastValue == 0)
			return (getFirstName().compareTo(aContact.getFirstName()));
		else
			return compareLastValue;

	}
	

	
	
}
