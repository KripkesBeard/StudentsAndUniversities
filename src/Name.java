/**
 * @author Peter Fortin
 */

public class Name {

	/* Data Fields */
	
	private final String FIRST_NAME;
	private final String MIDDLE_NAME;
	private final String LAST_NAME;
	private final String FORMATTED_PRINT;
	private final String COMPARE_FORMATTED;
	
	
	/* Constructors */
	
	public Name(String fst, String mid, String lst) {
		this.FIRST_NAME = fst;
		this.MIDDLE_NAME = mid;
		this.LAST_NAME = lst;
		this.FORMATTED_PRINT = this.FIRST_NAME + " " + this.MIDDLE_NAME + " " + this.LAST_NAME;
		this.COMPARE_FORMATTED = this.LAST_NAME + this.FIRST_NAME + this.MIDDLE_NAME;
	}

	
	/* Getters */
	
	public String getFirstName() {
		return FIRST_NAME;
	}

	public String getMiddleName() {
		return MIDDLE_NAME;
	}

	public String getLastName() {
		return LAST_NAME;
	}
	
	
	/* Utility Methods */ 
	
	public boolean equals(Name name) {
		return this.FIRST_NAME.equals(name.FIRST_NAME)
			&& this.MIDDLE_NAME.equals(name.MIDDLE_NAME)
			&& this.LAST_NAME.equals(name.LAST_NAME);
	}
	
	public int compareTo(Name name) {
		return this.COMPARE_FORMATTED.compareTo(name.LAST_NAME + name.FIRST_NAME + name.MIDDLE_NAME);
	}
	
	public String toString() {
		return this.FORMATTED_PRINT;
	}
}
