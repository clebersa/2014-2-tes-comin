package tesAct.controller;

import tesAct.model.Name;
import tesAct.model.VCARD;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class NameController implements Resourceable{

	/**
	 * The name.
	 */
	private Name name;

	/**
	 * Creates a new name controller.
	 * 
	 * @param name
	 *            The name.
	 */
	public NameController(Name name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return The name.
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            The name to set.
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Gets the name as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The name as a resource.
	 */
	public Resource getAsResource(Model model) {
		return model.createResource()
				.addProperty(VCARD.given_name, model.createTypedLiteral(name.getFirstName()))
				.addProperty(VCARD.family_name, model.createTypedLiteral(name.getMiddleName()))
				.addProperty(VCARD.additional_name, model.createTypedLiteral(name.getAdditionalName()));
	}
}
