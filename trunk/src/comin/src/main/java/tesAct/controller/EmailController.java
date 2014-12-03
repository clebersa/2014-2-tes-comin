package tesAct.controller;

import tesAct.model.Email;
import tesAct.model.VCARD;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class EmailController implements Resourceable{

	/**
	 * The e-mail.
	 */
	private Email email;

	/**
	 * Creates a new e-mail controller.
	 * 
	 * @param email
	 *            The e-mail.
	 */
	public EmailController(Email email) {
		this.email = email;
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
	 * Gets the e-mail as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The e-mail as a resource.
	 */
	public Resource getAsResource(Model model) {
		return model.createResource()
				.addProperty(VCARD.value, model.createTypedLiteral(email.getValue()))
				.addProperty(VCARD.label, model.createTypedLiteral(email.getType()));
	}

}
