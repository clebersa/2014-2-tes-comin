package v2.controller;

import java.util.ArrayList;

import tesAct.ontologies.Foaf;
import tesAct.ontologies.Relationship;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;

public class PersonController {
	private Resource person;
	
	public PersonController(Resource person) {
		this.person = person;
	}
	
	public PersonController(String name, String phone, String email, ArrayList<OntClass> interests, Model model){
		this(model.createResource("http://" + name + "/")
				.addProperty(Foaf.name, name)
				.addProperty(Foaf.phone, phone)
				.addProperty(Foaf.mbox, email));
		for(OntClass interest: interests){
			addInterest(interest);
		}
	}
	
	public Resource getPerson(){
		return person;
	}
	
	public String getName(){
		return person.getProperty(Foaf.name).getString();
	}
	
	public String getPhone(){
		return person.getProperty(Foaf.phone).getString();
	}
	
	public String getEmail(){
		return person.getProperty(Foaf.mbox).getString();
	}
	
	public void addInterest(OntClass interest){
		person.addProperty(Foaf.topic_interest, interest);
	}
	
	public void delInterest(OntClass interest, Model model){
		//TO TEST
		model.removeAll(person, Foaf.topic_interest, interest);
	}
	
	public void addToAGroup(Resource group){
		person.addProperty(Foaf.member, group);
	}
	
	public void addPersonWouldLikeToKnow(Resource wouldLikeToKnow){
		person.addProperty(Relationship.wouldLikeToKnow, wouldLikeToKnow);
	}
	
	public void addKnown(Resource known){
		person.addProperty(Foaf.knows, known);
	}
}
