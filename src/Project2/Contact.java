package Project2;

/**
 * Provides a scaffold to load a user provided contact information sequence.
 * @implNote uses Comparable to enable the Collections.sort() functionality
 * 
 * @Author Robert Daniels
 * AS ADAPTED FROM SEED FILE provided by Perla Weaver, Johnson County Community College.
 * 
 */
class Contact implements Comparable<Contact> {


	private String firstName;
	private String lastName;
	private String phone;

	Contact(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;

	}
	
	Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = "";
		
	}
	

	// mutators

	 public void setFirstName(String firstName){
		 this.firstName = firstName;
	 }

	 public void setLastName(String lastName){
		 this.lastName = lastName;
	 }

	 public void setPhone(String phone){
		 this.phone = phone;
	 }

	 // accessors

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

	/**
	 * Establishes natural comparison method for the Contact class to run on last name
	 */

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
