package tesAct.controller;

import tesAct.model.Address;
import tesAct.model.VCARD;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class AddressController implements Resourceable{

	/**
	 * The address.
	 */
	private Address address;

	/**
	 * Creates a new address controller.
	 * 
	 * @param address
	 *            The address.
	 */
	public AddressController(Address address) {
		this.address = address;
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
	 * Gets the address as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The address as a resource.
	 */
	public Resource getAsResource(Model model) {
		return model.createResource()
				.addProperty(VCARD.postal_code, model.createTypedLiteral(address.getPostalCode()))
				.addProperty(VCARD.country_name, model.createTypedLiteral(address.getCountry()))
				.addProperty(VCARD.region, model.createTypedLiteral(address.getState()))
				.addProperty(VCARD.locality, model.createTypedLiteral(address.getCity()))
				.addProperty(VCARD.street_address, model.createTypedLiteral(address.getStreet()));
	}

}
