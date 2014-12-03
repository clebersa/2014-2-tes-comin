package tesAct.controller;

import java.util.ArrayList;

import tesAct.model.Interest;
import tesAct.model.Profile;
import tesAct.model.VCARD;
import tesAct.ontologies.Foaf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class ProfileController implements Resourceable {

	private Profile profile;

	/**
	 * Creates a new profile controller.
	 * 
	 * @param name
	 *            The profile.
	 */
	public ProfileController(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Gets the profile.
	 * 
	 * @return The profile.
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * Sets the profile.
	 * 
	 * @param profile
	 *            The profile to set.
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * Gets the profile as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The profile as a resource.
	 */
	public Resource getAsResource(Model model) {
		// Instanciação do novo recurso
		Resource profileAsResource = model.createResource("http://"
				+ profile.getName().getFirstName().replace(" ", ".") + "/");

		// Adiciona nome completo
		profileAsResource.addProperty(VCARD.fn,
				model.createTypedLiteral(profile.getFullName()));

		// Adiciona nome estruturado
		NameController nameController = new NameController(profile.getName());
		profileAsResource.addProperty(VCARD.name,
				nameController.getAsResource(model));

		// Adiciona apelido
		profileAsResource.addProperty(VCARD.nickname,
				model.createTypedLiteral(profile.getNickname()));

		// Adiciona data de nascimento
		profileAsResource.addProperty(VCARD.bday,
				model.createTypedLiteral(profile.getBirthDate()));

		// Adiciona gênero
		profileAsResource.addProperty(VCARD.hasGender,
				model.createTypedLiteral(profile.getGender()));

		// Adiciona a estrutura de endereço
		AddressController addressController = new AddressController(
				profile.getAddress());
		profileAsResource.addProperty(VCARD.adr,
				addressController.getAsResource(model));

		// Adiciona a estrutura de email
		EmailController emailController = new EmailController(
				profile.getEmail());
		profileAsResource.addProperty(VCARD.email,
				emailController.getAsResource(model));

		// Adiciona a estrutura organização
		OrganizationController organizationController = new OrganizationController(
				profile.getOrganization());
		profileAsResource.addProperty(VCARD.organization,
				organizationController.getAsResource(model));
		
		// VOU FAZER DO JEITO MAIS FÁCIL DPS COLOCA O CONTROLLER.
		ArrayList<Interest> interests = profile.getInterests();
		
		for(Interest i : interests){
			profileAsResource.addProperty(Foaf.topic_interest,i.getInterest());
		}

		return profileAsResource;
	}

}
