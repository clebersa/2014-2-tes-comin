package tesAct.model;

public class Email {

	/**
	 * The type.
	 */
	private String type;

	/**
	 * The value.
	 */
	private String value;

	/**
	 * Creates a new e-mail.
	 * 
	 * @param type
	 *            The type.
	 * @param value
	 *            The value.
	 */
	public Email(String type, String value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * Gets the e-mail type.
	 * 
	 * @return The e-mail type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the e-mail type.
	 * 
	 * @param type
	 *            The e-mail type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the e-mail value.
	 * 
	 * @return The e-mail value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the e-mail value.
	 * 
	 * @param value
	 *            The e-mail value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
