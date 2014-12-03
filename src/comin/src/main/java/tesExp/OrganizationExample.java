package tesExp;

import com.hp.hpl.jena.rdf.model.Resource;

import tesAct.controller.ModelController;
import tesAct.model.VCARD;

public class OrganizationExample {

	public static void main(String[] args) {
		ModelController modelController = new ModelController();
		Resource resource;

		resource = modelController.getModel().createResource("http://cleber/");
		resource.addProperty(VCARD.organization_name, "UFG");
		resource.addProperty(VCARD.role, "Student");
		modelController.getModel().write(System.out);

		modelController.getModel().removeAll();

		resource = modelController.getModel().createResource("http://cleber/");
		resource.addProperty(VCARD.organization_name, "UFG").addProperty(
				VCARD.role, "Student");
		modelController.getModel().write(System.out);

		modelController.getModel().removeAll();

		resource = modelController.getModel().createResource("http://cleber/");
		resource.addProperty(VCARD.organization, modelController.getModel()
				.createResource().addProperty(VCARD.organization_name, "UFG")
				.addProperty(VCARD.role, "Student"));
		modelController.getModel().write(System.out);
	}
}
