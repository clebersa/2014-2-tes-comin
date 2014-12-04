package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ModelController {

	/**
	 * O modelo.
	 */

	private Model model;

	/**
	 * Cria um novo ModelController e um novo modelo usando a ModelFactory.
	 */
	public ModelController() {
		this.model = ModelFactory.createDefaultModel();
	}

	/**
	 * Cria um novo ModelController
	 * 
	 * @param model Modelo RDF
	 */
	public ModelController(Model model) {
		this.model = model;
	}

	/**
	 * Retorna o modelo.
	 * 
	 * @return model Modelo RDF
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Define o modelo
	 * 
	 * @param model Modelo RDF
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * Imprime o modelo na tela e em um arquivo usando o formato RDF/XML.
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
	 * Imprime o modelo na tela e em um arquivo usando o formato TURTLE.
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
