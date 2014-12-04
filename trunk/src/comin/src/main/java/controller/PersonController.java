package controller;

import java.util.ArrayList;

import ontologies.Foaf;
import ontologies.Relationship;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class PersonController {
	private Resource person;

	/**
	 * Cria um novo PersonController
	 * 
	 * @param person
	 *            Pessoa é quem faz uso do sistema.
	 */
	public PersonController(Resource person) {
		this.person = person;
	}

	/**
	 * Cria um novo recurso usando os parâmetros e chama o outro método
	 * construtor passando esse recurso
	 * 
	 * @param name
	 *            Nome da pessoa.
	 * @param phone
	 *            Telefone da pessoa.
	 * @param email
	 *            E-mail da pessoa.
	 * @param interests
	 *            Áreas de interesse da pessoa.
	 * @param model
	 *            Modelo RDF é onde a pessoa vai ser criada.
	 */
	public PersonController(String name, String phone, String email,
			ArrayList<OntClass> interests, Model model) {
		this(model.createResource("http://" + name + "/")
				.addProperty(Foaf.name, name).addProperty(Foaf.phone, phone)
				.addProperty(Foaf.mbox, email));
		for (OntClass interest : interests) {
			addInterest(interest);
		}
	}

	/**
	 * Retorna um recurso Pessoa.
	 * 
	 * @return person Pessoa é quem faz uso do sistema.
	 */
	public Resource getPerson() {
		return person;
	}

	/**
	 * Retorna o nome da pessoa
	 * 
	 * @return name Nome é o nome da pessoa.
	 */
	public String getName() {
		return person.getProperty(Foaf.name).getString();
	}

	/**
	 * Retorna o telefone da pessoa
	 * 
	 * @return phone Telefone é telefone da pessoa.
	 */
	public String getPhone() {
		return person.getProperty(Foaf.phone).getString();
	}

	/**
	 * Retorna o email da pessoa
	 * 
	 * @return mbox É a caixa de e-mail da pessoa.
	 */
	public String getEmail() {
		return person.getProperty(Foaf.mbox).getString();
	}

	/**
	 * Adiciona um interesse fornecido a pessoa.
	 * 
	 * @param interest
	 *            Interesse é uma área de conhecimento na qual a pessoa tem
	 *            interesse.
	 */
	public void addInterest(OntClass interest) {
		person.addProperty(Foaf.topic_interest, interest);
	}

	/**
	 * Deleta um interesse da pessoa
	 * 
	 * @param interest
	 *            Interesse é uma área de conhecimento na qual a pessoa tem
	 *            interesse.
	 * @param model
	 *            Modelo RDF é onde a pessoa vai ser criada.
	 */
	public void delInterest(OntClass interest, Model model) {
		model.removeAll(person, Foaf.topic_interest, interest);
	}

	/**
	 * Adiciona uma pessoa fornecida como conhecida, a partir da propriedade
	 * "knows" da ontologia Foaf
	 * 
	 * @param known
	 * @param model
	 *            Modelo RDF é onde a pessoa vai ser criada.
	 */
	public void addKnown(Resource known, Model model) {
		model.removeAll(person, Relationship.wouldLikeToKnow, known);
		person.addProperty(Foaf.knows, known);
	}
}
