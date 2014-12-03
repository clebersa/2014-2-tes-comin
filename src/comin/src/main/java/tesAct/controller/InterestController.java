package tesAct.controller;

import tesAct.model.Interest;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class InterestController implements Resourceable {
	
	private Interest interest;

	/**
	 * @return the interest
	 */
	public Interest getInterest() {
		return interest;
	}

	/**
	 * @param interest the interest to set
	 */
	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public Resource getAsResource(Model model) {
		return null;
	}

}
