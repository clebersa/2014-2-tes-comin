package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ModelController {

	/**
	 * The model.
	 */
	private Model model;

	/**
	 * Creates a new model controller and a new model using a ModelFactory.
	 */
	public ModelController() {
		this.model = ModelFactory.createDefaultModel();
	}

	/**
	 * Creates a new model controller.
	 * 
	 * @param model
	 *            The model.
	 */
	public ModelController(Model model) {
		this.model = model;
	}

	/**
	 * Gets the model.
	 * 
	 * @return The model.
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 * 
	 * @param model
	 *            The model to set.
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Prints the model in the screen and in a file using the RDF/XML format.
	 */
	public void printRDF() {
		String outputFile = "rdf-xml.txt";
		model.write(System.out);
		try {
			model.write(new FileOutputStream(outputFile));
			System.out
					.println("The RDF/XML serialization has been saved in the file "
							+ outputFile + " successfully.");
		} catch (FileNotFoundException e) {
			System.out
					.println("The RDF/XML serialization has not been saved. Error: "
							+ e.getMessage());
		}
	}

	/**
	 * Prints the model in the screen and in a file using the TURTLE format.
	 */
	public void printTurle() {
		String outputFile = "turtle.txt";
		model.write(System.out, "TURTLE");
		try {
			model.write(new FileOutputStream(outputFile), "TURTLE");
			System.out
					.println("The Turtle serialization has been saved in the file "
							+ outputFile + " successfully.");
		} catch (FileNotFoundException e) {
			System.out
					.println("The Turtle serialization has not been saved. Error: "
							+ e.getMessage());
		}
	}

}
