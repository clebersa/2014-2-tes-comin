package tesAct.controller;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public interface Resourceable {

	/**
	 * Gets the object as a resource.
	 * 
	 * @param model
	 *            The model where the resource will be created.
	 * @return The object as a resource.
	 */
	public Resource getAsResource(Model model);
}
