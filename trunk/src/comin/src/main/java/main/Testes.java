package main;

import ontologies.Relationship;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;

public class Testes {

	public static void main(String[] args) {
		Model model = ModelFactory.createDefaultModel();
		Resource cleber = model.createResource("http://Cleber/").addProperty(FOAF.name, "Cleber");
		Resource leticia = model.createResource("http://Letícia/").addProperty(FOAF.name, "Letícia");
		Resource larissa = model.createResource("http://Larissa/").addProperty(FOAF.name, "Larissa");;
		Resource samuel= model.createResource("http://Samuel/").addProperty(FOAF.name, "Samuel");
		cleber.addProperty(Relationship.friendOf, leticia);
		cleber.addProperty(Relationship.friendOf, larissa);
		samuel.addProperty(Relationship.friendOf, larissa);
		samuel.addProperty(Relationship.friendOf, cleber);
		model.remove(cleber, null, leticia);
		
		model.write(System.out);
		
		
	}

}
