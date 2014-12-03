package tesAct.controller;
import tesAct.model.Telephone;
import tesAct.model.VCARD;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class TelephoneController implements Resourceable{

	
	
	private Telephone telephone;


	public TelephoneController(Telephone telephone) {
		this.telephone = telephone;
	}

	
	public Telephone getTelephone() {
		return telephone;
	}

	
	public void setTelephone(Telephone telephone) {
		this.telephone = telephone;
	}

	
	public Resource getAsResource(Model model) {
		return model.createResource()
				.addProperty(VCARD.value, model.createTypedLiteral(telephone.getValue()))
				.addProperty(VCARD.label, model.createTypedLiteral(telephone.getType()));
	}

}
