package tesAct.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.hp.hpl.jena.ontology.OntClass;

public class Profile {

	/**
	 * Name of the profile.
	 */
	private Name name;

	/**
	 * Full name.
	 */
	private String fullName;

	/**
	 * The nickname.
	 */
	private String nickname;

	/**
	 * The birth date.
	 */
	private Calendar birthDate;

	/**
	 * The gender.
	 */
	private String gender;

	/**
	 * The gender.
	 */
	private Address address;

	/**
	 * The e-mail.
	 */
	private Email email;

	/**
	 * The organization.
	 */
	private Organization organization;

	/**
	 * Gets the profile name.
	 * 
	 * @return The profile name.
	 */
	private ArrayList<Interest> interests = new ArrayList<Interest>();
	
	
	public Name getName() {
		return name;
	}

	/**
	 * Sets the profile name.
	 * 
	 * @param name
	 *            The profile name to set.
	 */
	public void setName(Name name) {
		this.name = name;
		setFullName(name.getFirstName() + " " + name.getMiddleName() + " "
				+ name.getAdditionalName());
	}

	public void setInterest(OntClass interest) {
		Interest tempInterest = new Interest();
		tempInterest.setInterest(interest);
		interests.add(tempInterest);
	}
	
	public ArrayList<Interest> getInterests() {
		return interests;
	}

	/**
	 * Gets the full name.
	 * 
	 * @return The full name.
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 * 
	 * @param fullName
	 *            The full name to set.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the nickname.
	 * 
	 * @return The nickname.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * Sets the nickname.
	 * 
	 * @param nickname
	 *            The nickname to be set.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * Gets the birth date.
	 * 
	 * @return The birth date.
	 */
	public Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 * 
	 * @param birthDate
	 *            The birth date to set.
	 */
	public void setBirthDate(String birthDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {
			this.birthDate = Calendar.getInstance();
			this.birthDate.setTime(formatter.parse(birthDate));
		} catch (ParseException e) {
			System.out.println("Error parsing the birth date: "
					+ e.getMessage());
		}
	}

	/**
	 * Gets the gender.
	 * 
	 * @return The gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the address.
	 * 
	 * @return The address.
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            The address to set.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the e-mail.
	 * 
	 * @return The e-mail.
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * Sets the e-mail.
	 * 
	 * @param email
	 *            The e-mail to set.
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * Gets the organization.
	 * 
	 * @return The organization.
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 * 
	 * @param organization
	 *            The organization to set.
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
