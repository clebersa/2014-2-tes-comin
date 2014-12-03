package tesAct.model;

public class Address {
	/**
	 * The street.
	 */
	private String street;

	/**
	 * The city.
	 */
	private String city;

	/**
	 * The state.
	 */
	private String state;

	/**
	 * The country.
	 */
	private String country;

	/**
	 * The postal code.
	 */
	private String postalCode;

	/**
	 * Creates a new address.
	 * 
	 * @param street
	 *            The street.
	 * @param city
	 *            The city.
	 * @param state
	 *            The state.
	 * @param country
	 *            The country.
	 * @param postalCode
	 *            The postal code.
	 */
	public Address(String street, String city, String state, String country,
			String postalCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	/**
	 * Gets the street.
	 * 
	 * @return The street.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 * 
	 * @param street
	 *            The street to set.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the city.
	 * 
	 * @return The city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 * 
	 * @param city
	 *            The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 * 
	 * @return The state.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            The state to set.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            The country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the postal code.
	 * 
	 * @return The postal code.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 * 
	 * @param postalCode
	 *            The postal code to set.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
