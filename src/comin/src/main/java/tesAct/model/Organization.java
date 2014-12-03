package tesAct.model;

public class Organization {
	/**
	 * The organization name.
	 */
	private String name;

	/**
	 * The role in the organization.
	 */
	private String role;

	/**
	 * Creates a new organization.
	 * 
	 * @param name
	 *            The organization name.
	 * @param role
	 *            The role in the organization.
	 */
	public Organization(String name, String role) {
		this.name = name;
		this.role = role;
	}

	/**
	 * Gets the organization name.
	 * @return The organization name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the organization name.
	 * @param name The organization name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the role in the organization.
	 * @return The role in the organization.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role in the organization.
	 * @param role The role in the organization to set.
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
