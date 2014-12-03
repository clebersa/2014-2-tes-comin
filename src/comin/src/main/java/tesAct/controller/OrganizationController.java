package tesAct.controller;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

import tesAct.model.Organization;
import tesAct.model.VCARD;

public class OrganizationController implements Resourceable {
	/**
	 * The organization.
	 */
	private Organization organization;

	/**
	 * Creates a new organization controller.
	 * @param organization The organization.
	 */
	public OrganizationController(Organization organization) {
		this.organization = organization;
	}

	/**
	 * Gets the organization.
	 * @return The organization.
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 * @param organization The organization to set.
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	/**
	 * Gets the organization as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The organization as a resource.
	 */
	public Resource getAsResource(Model model) {
		return model.createResource()
				.addProperty(VCARD.organization_name, model.createTypedLiteral(organization.getName()))
				.addProperty(VCARD.role, model.createTypedLiteral(organization.getRole()));
	}

}
