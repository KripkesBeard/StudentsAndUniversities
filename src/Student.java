/**
 * @author Peter Fortin
 */

import java.io.Serializable;

public class Student extends Person implements Serializable {

	/* Data Fields */

	private static final long serialVersionUID = 3471149379463850475L; //This was auto generated by Eclipse for Serializable
	private String studentID;
	private String universityName;
	private int enrolledCredits;
	private char inState;
	private char lateFees;
	private char foodOption;
	private char healthOption;
	
	
	/* Constructors */
	
	public Student(String first, String middle, String last, int age, char gender, String streetAddress, 
			String city, String state, String zipCode, String phoneNumber,
			String id, String uniName, int credits, char inState, char late, char food, char health) {
		
		super(first, middle, last, age, gender, streetAddress, city, state, zipCode, phoneNumber);
		this.studentID = id;
		this.universityName = uniName;
		this.enrolledCredits = credits;
		this.inState = inState;
		this.lateFees = late;
		this.foodOption = food;
		this.healthOption = health;
	}

	
	/* Getters and Setters */

	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getUniversityName() {
		return universityName;
	}


	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}


	public int getEnrolledClasses() {
		return enrolledCredits;
	}


	public void setEnrolledClasses(int enrolledClasses) {
		this.enrolledCredits = enrolledClasses;
	}


	public char getInState() {
		return inState;
	}


	public void setInState(char inState) {
		this.inState = inState;
	}


	public char getLateFees() {
		return lateFees;
	}


	public void setLateFees(char lateFees) {
		this.lateFees = lateFees;
	}


	public char getFoodOption() {
		return foodOption;
	}


	public void setFoodOption(char foodOption) {
		this.foodOption = foodOption;
	}


	public char getHealthOption() {
		return healthOption;
	}


	public void setHealthOption(char healthOption) {
		this.healthOption = healthOption;
	}
	
	
	/* Utility Methods */
	
	public boolean equals(Student student) {
		return this.getNAME().equals(student.getNAME()) && this.studentID.equals(student.getStudentID());
	}
	
	public int compareTo(Student student) {
		Person studentPerson = (Person)student;
		int compare = super.compareTo(studentPerson);
		
		if (compare == 0) {
			return this.studentID.compareTo(student.getStudentID());
		} else {
			return compare;
		}
	}
	
	public String toString() {
		return super.toString() + " "
			+ this.studentID + " "
			+ this.universityName + " "
			+ this.enrolledCredits + " "
			+ this.inState + " "
			+ this.lateFees + " "
			+ this.foodOption + " "
			+ this.healthOption;
	}
}