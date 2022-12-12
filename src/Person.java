/**
 * @author Peter Fortin
 */

public class Person {

	/* Data Fields */
	
	private final Name NAME;
	private int age;
	private char gender;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	
	
	/* Constructors */
	
	public Person(String first, String middle, String last, int age, char gender, String streetAddress, 
			String city, String state, String zipCode, String phoneNumber) {
		
		this.NAME = new Name(first, middle, last);
		this.age = age;
		this.gender = gender;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	/* Getters and Setters */

	public int getAge() {
		return this.age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return this.gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public String getStreetAddress() {
		return this.streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getCity() {
		return this.city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return this.state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipCode() {
		return this.zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getPhoneNumber() {
		return this.phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Name getNAME() {
		return this.NAME;
	}
	
	
	/* Utility Methods */
	
	public boolean equals(Person person) {
		return this.NAME.equals(person.getNAME())
			&& this.age == person.getAge()
			&& this.gender == person.getGender()
			&& this.streetAddress.equals(person.getStreetAddress())
			&& this.city.equals(person.getCity())
			&& this.state.equals(person.getState())
			&& this.zipCode.equals(person.getZipCode())
			&& this.phoneNumber.equals(person.getPhoneNumber());
	}

	public int compareTo(Person person) {
		int nameCompare = this.NAME.compareTo(person.NAME);
		int ageCompare; 
		int genderCompare;
		
		if (this.age == person.age) {
			ageCompare = 0;
		} else if (this.age < person.age) {
			ageCompare = -1;
		} else {
			ageCompare = 1;
		}
		
		if (this.gender == person.gender) {
			genderCompare = 0;
		} else if (this.gender < person.gender) {
			genderCompare = -1;
		} else {
			genderCompare = 1;
		}
		
		if (nameCompare == 0) {
			if (ageCompare == 0) {
				return genderCompare;
			} else {
				return ageCompare;
			}
		} else {
			return nameCompare;
		}
	}

	public String toString() {
		return this.NAME.toString() + " " 
			 + this.age + " "
			 + this.gender + " "
			 + this.streetAddress + " "
			 + this.city + " "
			 + this.state + " "
			 + this.zipCode + " "
			 + this.phoneNumber;
	}
}
