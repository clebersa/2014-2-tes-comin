package tesAct.model;

public class Name {
	/**
	 * First name.
	 */
	private String firstName;

	/**
	 * Middle name.
	 */
	private String middleName;

	/**
	 * Additional name. It can be the last name.
	 */
	private String additionalName;

	/**
	 * Creates a name.
	 * 
	 * @param firstName
	 *            The first name.
	 * @param middleName
	 *            The middle name.
	 * @param additionalName
	 *            The additional name. It can be the last name.
	 */
	public Name(String firstName, String middleName, String additionalName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.additionalName = additionalName;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return The first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            The first name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 * 
	 * @return The middle name.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 * 
	 * @param middleName
	 *            The middle name to set.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the additional name.
	 * 
	 * @return The additional name.
	 */
	public String getAdditionalName() {
		return additionalName;
	}

	/**
	 * Sets the additional name.
	 * 
	 * @param additionalName
	 *            The additional name to set.
	 */
	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}

}
