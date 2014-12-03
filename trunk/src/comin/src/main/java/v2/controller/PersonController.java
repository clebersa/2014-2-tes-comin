package v2.controller;

import java.util.ArrayList;

import tesAct.ontologies.Foaf;
import tesAct.ontologies.Relationship;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class PersonController {
	private Resource person;
	
	/**
	 *Cria um novo PersonController
	 * @param 
	 * Resource
	 * 
	 * 
	 * 
	 * **/
	public PersonController(Resource person) {
		this.person = person;
	}
	/**
	 * Cria um novo recurso usando os parâmetros e chama o outro método construtor passando esse recurso.
	 * @param 
	 * Nome da Pessoa, Telefone, Email, Interesses e Modelo para adicionar o recurso criado.
	 * 
	 * **/
	public PersonController(String name, String phone, String email, ArrayList<OntClass> interests, Model model){
		this(model.createResource("http://" + name + "/")
				.addProperty(Foaf.name, name)
				.addProperty(Foaf.phone, phone)
				.addProperty(Foaf.mbox, email));
		for(OntClass interest: interests){
			addInterest(interest);
		}
	}
	/**
	 * Retorna um recurso Pessoa.
	 * */
	public Resource getPerson(){
		return person;
	}
	
	/**
	 * Retorna o nome da pessoa
	 * */
	public String getName(){
		return person.getProperty(Foaf.name).getString();
	}
	
	/**
	 * Retorna o telefone da pessoa
	 * */
	public String getPhone(){
		return person.getProperty(Foaf.phone).getString();
	}
	/**
	 * Retorna o email da pessoa
	 * */
	public String getEmail(){
		return person.getProperty(Foaf.mbox).getString();
	}
	
	/**
	 * Adiciona um interesse fornecido a pessoa.
	 * @param 
	 * Interesse
	 * */
	public void addInterest(OntClass interest){
		person.addProperty(Foaf.topic_interest, interest);
	}
	/**
	 * Deleta um interesse da pessoa 
	 * */
	public void delInterest(OntClass interest, Model model){
		//TO TEST
		model.removeAll(person, Foaf.topic_interest, interest);
	}
	/**
	 * Adiciona a pessoa a um grupo por meio da propriedade "member" da ontologia Foaf
	 * */
	public void addToAGroup(Resource group){
		person.addProperty(Foaf.member, group);
	}
	
	/**
	 * Cria relacionamentos "Gostaria de conhecer" a partir de um grupo fornecido
	 * */
	public void addPersonsWouldLikeToKnow(Resource group){
		 StmtIterator members = group.listProperties(Foaf.member);
		 while(members.hasNext()){
			 Statement statement = members.next();
			 Resource member = statement.getObject().asResource();
			 if(member != person){
				 person.addProperty(Relationship.wouldLikeToKnow, member);
			 }
		 }
	}
	
	/**
	 * Adiciona um pessoa fornecida como conhecida, a partir da propriedade "knows" da ontologia Foafr
	 * 
	 * */
	public void addKnown(Resource known, Model model){
		model.removeAll(person, Relationship.wouldLikeToKnow, known);
		person.addProperty(Foaf.knows, known);
	}
}
