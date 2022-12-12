/**
 * @author Peter Fortin
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcessor {

	public static void main(String[] args) {

		Scanner studentInput;
		Scanner universityInput;
		ObjectOutputStream studentOutput;
		ObjectOutputStream universityOutput;
		PrintWriter formattedOutput;
		
		ArrayList<Student> students;
		ArrayList<University> universities;

		try {
			//I know that these next to blocks are duplicated code, but I am not sure how to make it generic.
			//In Haskell I would just use a typeclass. I tried looking into Java Generics but I couldn't get
			//a method to work out, specifically because I couldn't figure out how to typeclass ArayList<Student>
			//and ArrayList<University> into ArrayList<Serializable>.
			
			//Read list of students from a CSV file, save them into an ArrayList, then write them one by one into a binary file.
			studentInput = new Scanner(new FileInputStream("StudentFile.txt"));
			studentInput.useDelimiter("[,\\n\\r]+");
			students = readStudentsData(studentInput);
			studentOutput = new ObjectOutputStream(new FileOutputStream("Students.bin"));
			for (int i = 0; i < students.size(); ++i) {
				studentOutput.writeObject(students.get(i));
			}
			
			//Read list of universities from a CSV file, save them into an ArrayList, then write them one by one into a binary file.
			universityInput = new Scanner(new FileInputStream("Universities9.txt"));
			universityInput.useDelimiter("[,\\n\\r]+");
			universities = readUniversityData(universityInput);
			universityOutput = new ObjectOutputStream(new FileOutputStream ("Universities.bin"));
			for (int i = 0; i < universities.size(); ++i) {
				universityOutput.writeObject(universities.get(i));
			}

			//Write a formatted report of the universities and students to a text file
			formattedOutput = new PrintWriter(new FileOutputStream("UniversityReport.txt"));
			formatUniversity(universities, students, formattedOutput);
			
			//Close streams
			studentInput.close();
			studentOutput.close();
			universityInput.close();
			universityOutput.close();
			formattedOutput.close();
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Reads a CSV formatted input and creates an ArrayList<Student> of students from the data,
	 * sorting and removing duplicates before returning the final list.
	 * 
	 * @param input
	 * @return ArrayList<Students> students
	 */
	private static ArrayList<Student> readStudentsData(Scanner input) {
		
		String first;
		String middle;
		String last;
		int age;
		char gender;
		String streetAddress;
		String city;
		String state;
		String zipCode;
		String phoneNumber;
		String id;
		String uniName;
		int credits;
		char inState;
		char late;
		char food;
		char health;
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			input.next();
			while (input.hasNext()) {
				first = input.next();
				middle = input.next();
				last = input.next();
				age = input.nextInt();
				gender = input.next().charAt(0);
				streetAddress = input.next();
				city = input.next();
				state = input.next();
				zipCode = input.next();
				phoneNumber = input.next();
				uniName = input.next();
				id = input.next();
				credits = input.nextInt();
				inState = input.next().charAt(0);
				late = input.next().charAt(0);
				food = input.next().charAt(0);
				health = input.next().charAt(0);

				Student newStudent = new Student(first, middle, last, age, gender, streetAddress, city, state,
						                         zipCode, phoneNumber, id, uniName, credits, inState, late, food, health);
				
				//This is an ad hoc insertion sort that also checks to make sure it's not adding in duplicates.
				if (students.size() == 0) {
					students.add(newStudent);
				} else {
					for (int i = 0; i < students.size(); ++i) {
						int compare = students.get(i).compareTo(newStudent);
						if (compare > 0) {
							students.add(i, newStudent);
							break;
						} else if (compare == 0) {
							break;
						} else if (i == students.size() - 1) {
							students.add(newStudent);
						}
					}
				}
			}
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return students;
	}

	/**
	 * Reads a CSV formatted input and creates an ArrayList<University> of universities from the data,
	 * sorting and removing duplicates before returning the final list.
	 * 
	 * @param input
	 * @return ArrayList<University> universities
	 */
	private static ArrayList<University> readUniversityData(Scanner input) {
		
		String uniName;
		String address;
		String city;
		String state;
		String zipCode;
		String phoneNumber;
		double inStateUnder12;
		double inStateUnder18;
		double inState18AndOver;
		double outStateUnder12;
		double outStateUnder18;
		double outState18AndOver;
		double mealPlanA;
		double mealPlanB;
		double mealPlanC;
		double healthCareUnder11;
		double healthCareUnder16;
		double healthCare18AndOver;
		double lateFeeRate;
		double incidentalFeeRate;
		double incidentalFeeMax;
		ArrayList<University> universities = new ArrayList<University>();
		
		try {
			input.next();
			while (input.hasNext()) {
				uniName = input.next();
				address = input.next();
				city = input.next();
				state = input.next();
				zipCode = input.next();
				phoneNumber = input.next();
				inStateUnder12 = input.nextDouble();
				inStateUnder18 = input.nextDouble();
				inState18AndOver = input.nextDouble();
				outStateUnder12 = input.nextDouble();
				outStateUnder18 = input.nextDouble();
				outState18AndOver = input.nextDouble();
				mealPlanA = input.nextDouble();
				mealPlanB = input.nextDouble();
				mealPlanC = input.nextDouble();
				healthCareUnder11 = input.nextDouble();
				healthCareUnder16 = input.nextDouble();
				healthCare18AndOver = input.nextDouble();
				lateFeeRate = input.nextDouble();
				incidentalFeeRate = input.nextDouble();
				incidentalFeeMax = input.nextDouble();
				
				University newUniversity = new University(uniName, address, city, state, zipCode, phoneNumber,
						inStateUnder12, inStateUnder18, inState18AndOver, outStateUnder12,
						outStateUnder18, outState18AndOver, mealPlanA, mealPlanB, mealPlanC,
						healthCareUnder11, healthCareUnder16, healthCare18AndOver, lateFeeRate,
						incidentalFeeRate, incidentalFeeMax);
				
				//Again, an ad hoc insertion sort that doesn't add duplicates
				if (universities.size() == 0) {
					universities.add(newUniversity);
				} else {
					for (int i = 0; i < universities.size(); ++i) {
						int compare = universities.get(i).compareTo(newUniversity);
						if (compare > 0) {
							universities.add(i, newUniversity);
							break;
						} else if (compare == 0) {
							break;
						} else if (i == universities.size() - 1) {
							universities.add(newUniversity);
						}
					}
				}
			}
			
			
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return universities;	
	}

	/**
	 * Takes a list of universities and a list of students and pretty prints a formatted report of
	 * the total data for each student and the sum total that they provide to each university.
	 * 
	 * @param universities
	 * @param students
	 * @param output
	 */
	public static void formatUniversity(ArrayList<University> universities, ArrayList<Student> students, PrintWriter output) {
		
		for (int i = 0; i < universities.size(); ++i) {
			
			int totalStudents = 0;
			int totalInState = 0;
			int totalOutState = 0;
			int totalMealsA = 0;
			double mealsACost = 0;
			int totalMealsB = 0;
			double mealsBCost = 0;
			int totalMealsC = 0;
			double mealsCCost = 0;
			double foodSubTotal = 0;
			double totalTuition = 0;
			double totalLateFee = 0;
			double totalIncidentals = 0;
			double totalHealthCare = 0;
			double totalTotal = 0;
			
			
			output.println("\t\t" + universities.get(i).getUniName().toUpperCase());
			output.println("\t\t" + universities.get(i).getAddress());
			output.println("\t\t" + universities.get(i).getCity() + ", " 
			                      + universities.get(i).getState() + " " + universities.get(i).getZipCode());
			output.println("\t\t" + formatPhoneNumber(universities.get(i).getPhoneNumber()) + "\n");
			
			for (int j = 0; j < students.size(); ++j) {
				if (students.get(j).getUniversityName().equals(universities.get(i).getUniName())) {
					
					totalStudents++;
					
					double tuition = 0;
					double lateFee = 0;
					double incidental = 0;
					double healthCare = 0;
					double mealPlan = 0;
					double total = 0;
					
					int credits = students.get(j).getEnrolledClasses();
					
					switch (students.get(j).getInState()) {
					case 'Y':
						totalInState++;
						if (credits < 12) {
							tuition = credits * universities.get(i).getInStateUnder12();
						} else if (credits < 18) {
							tuition = credits * universities.get(i).getInStateUnder18();
						} else {
							tuition = credits * universities.get(i).getInState18AndOver();
						}
						totalTuition += tuition;
						break;
					case 'N':
						totalOutState++;
						if (credits < 12) {
							tuition = credits * universities.get(i).getOutStateUnder12();
						} else if (credits < 18) {
							tuition = credits * universities.get(i).getOutStateUnder18();
						} else {
							tuition = credits * universities.get(i).getOutState18AndOver();
						}
						break;
					}
					
					switch (students.get(j).getLateFees()) {
					case 'Y':
						lateFee = tuition * universities.get(i).getLateFeeRate();
						totalLateFee += lateFee;
						break;
					case 'N':
						lateFee = 0;
						break;
					}
					
					incidental = credits * 25 > 250 ? 250 : credits * 25; 
					totalIncidentals += incidental;
					
					if (students.get(j).getHealthOption() == 'Y') {
						if (credits <= 10) {
							healthCare = credits * 25;
						} else if (credits <= 15) {
							healthCare = credits * 20;
						} else {
							healthCare = credits * 15;
						}
						totalHealthCare += healthCare;
					}
					
					switch (students.get(j).getFoodOption()) {
					case 'A':
						mealPlan = 4999;
						totalMealsA++;
						mealsACost += mealPlan;
						break;
					case 'B':
						mealPlan = 3499;
						totalMealsB++;
						mealsBCost += mealPlan;
						break;
					case 'C':
						mealPlan = 2599;
						totalMealsC++;
						mealsCCost += mealPlan;
						break;
					}
					
					total = tuition + lateFee + incidental + healthCare + mealPlan;
					
					
					output.printf("NAME        %-27.27s%-12.12s%d\n", students.get(j).getNAME(), "CREDITS", credits); 
					output.println("ADDRESS     " + students.get(j).getStreetAddress() + ", " 
					             + students.get(j).getCity() + " " + students.get(j).getState() + " "
							     + students.get(j).getZipCode());
					output.println("PHONE       " + formatPhoneNumber(students.get(j).getPhoneNumber()));
					output.printf("TUITION     $%8.2f\n", tuition);
					output.printf("LATE FEE    $%8.2f\n", lateFee);
					output.printf("INCIDENTAL  $%8.2f\n", incidental);
					output.printf("HEALTH CARE $%8.2f\n", healthCare);
					output.printf("MEAL PLAN   $%8.2f%24.24s $%8.2f\n", mealPlan, "TOTAL", total);
					output.println();
				}
			}
			
			
			
			foodSubTotal = mealsACost + mealsBCost + mealsCCost;
			totalTotal = foodSubTotal + totalTuition + totalLateFee + totalIncidentals + totalHealthCare; 
			
			
			output.println("\n\n\t\t" + universities.get(i).getUniName().toUpperCase() + " TOTALS\n");
			output.printf("NUMBER OF STUDENTS       %d\n", totalStudents);
			output.printf("INSTATE                  %d\n", totalInState);
			output.printf("OUT OF STATE             %d\n", totalOutState);
			output.printf("MEAL PLAN       3 Meals a day          %d      $%8.2f\n", totalMealsA, mealsACost);
			output.printf("                2 Meals a day          %d      $%8.2f\n", totalMealsB, mealsBCost);
			output.printf("                1 Meals a day          %d      $%8.2f\n", totalMealsC, mealsCCost);
			output.printf("                FOOD SUB TOTAL                $%8.2f\n", foodSubTotal);
			output.printf("TUITION         $%8.2f\n", totalTuition);
			output.printf("LATE FEE        $%8.2f\n", totalLateFee);
			output.printf("INCIDENTAL      $%8.2f\n", totalIncidentals);
			output.printf("HEALTH CARE     &%8.2f              TOTAL  $%8.2f\n", totalHealthCare, totalTotal);
			output.println("\n\n");
		}
	}

	/**
	 * Pretty prints a telephone number.
	 * 
	 * @param phoneNumber
	 * @return String formattedNumber
	 */
	public static String formatPhoneNumber(String phoneNumber) {
		return "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
	}
	
}
