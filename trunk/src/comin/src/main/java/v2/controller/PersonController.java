package v2.controller;

import tesAct.ontologies.Foaf;

import com.hp.hpl.jena.rdf.model.Resource;

public class PersonController {
	private Resource person;
	
	public PersonController(Resource person) {
		this.person = person;
	}
	
	public PersonController(String name, String phone, String email){
		person.addProperty(Foaf.name, name);
		person.addProperty(Foaf.phone, phone);
		person.addProperty(Foaf.account, email);
	}
	
	public String getName(){
		//Consulta sparql que busca o nome da pessoa desse perfil.
		return "";
	}
	
	public String getPhone(){
		//Consulta sparql que busca o telefone da pessoa desse perfil.
		return "";
	}
	
	public String getAccount(){
		//Consulta sparql que busca o e-mail (conta) da pessoa desse perfil.
		return "";
	}
}
