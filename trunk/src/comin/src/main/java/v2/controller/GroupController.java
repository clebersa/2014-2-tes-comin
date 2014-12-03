package v2.controller;

import java.io.File;
import java.util.ArrayList;

import org.mindswap.pellet.jena.PelletReasonerFactory;

import tesAct.ontologies.Foaf;
import tesAct.ontologies.Relationship;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.util.FileManager;

public class GroupController {
	private Resource group;

	public GroupController(Resource group) {
		this.group = group;
	}

	public GroupController(ArrayList<OntClass> topics, Model model,
			Resource searcher) {
		this(model.createResource());

		ArrayList<Resource> members = search(topics, model);

		for (Resource member : members) {
			addMember(member);
		}

		for (OntClass topic : topics) {
			addTopic(topic);
		}
	}

	public Resource getGroup() {
		return group;
	}

	public void addMember(Resource member) {
		member.addProperty(Foaf.member, group);
	}

	public void addTopic(OntClass topic) {
		topic.addProperty(Foaf.topic, group);
	}

	/**
	 * Cria relacionamentos "Gostaria de conhecer" a partir de quem efeutou a
	 * pesquisa.
	 * */
	public void makeWLTK(Resource searcher) {
		StmtIterator members = group.listProperties(Foaf.member);
		while (members.hasNext()) {
			Statement statement = members.next();
			Resource member = statement.getObject().asResource();
			if (member != searcher) {
				searcher.addProperty(Relationship.wouldLikeToKnow, member);
			}
		}
	}

	private static ArrayList<Resource> search(ArrayList<OntClass> topics,
			Model model) {

		String queryString = "PREFIX rel:<http://www.semanticweb.org/ontologies/2014/5/foaf.owl#>"
				+ "SELECT ?Person " + "WHERE {";

		for (OntClass ontClass : topics) {
			String interest = ontClass.getLocalName();
			queryString = queryString
					+ " ?Person <http://www.semanticweb.org/ontologies/2013/10/foaf.owl#topic_interest> '"
					+ interest + "' .";
		}

		queryString = queryString + " }";

		String schemaOntology = "src/main/java/tesAct/ontologies/foaf.owl";
		Model schema = FileManager.get().loadModel(
				"src/main/java/tesAct/ontologies/foaf.owl");
		// InfModel infModel = ModelFactory.createRDFSModel(schema, model);

		Reasoner reasoner = ReasonerRegistry.getOWLMicroReasoner();
		reasoner = reasoner.bindSchema(schema);
		InfModel infModel = ModelFactory.createInfModel(reasoner, model);

		// Criação do modelo ontológico utilizando o Pellet
		OntModel ont = ModelFactory.createOntologyModel(
				PelletReasonerFactory.THE_SPEC, null);
		ont.read(new File(schemaOntology).toURI().toString(), "RDF/XML");

		reasoner = ReasonerRegistry.getOWLReasoner();
		reasoner = reasoner.bindSchema(ont);

		// Realiza a inferência
		infModel = ModelFactory.createInfModel(reasoner, model);

		Query query = QueryFactory.create(queryString);

		// Interface para a execução de uma única consulta sobre os GRAFOS
		// retornados do BD
		QueryExecution qe = QueryExecutionFactory.create(query, infModel);

		// Executa a consulta definida na string SPARQL e armazena em um
		// ResultSet
		ResultSet results = qe.execSelect();

		// Formatador dos resultados de uma consulta
		// ResultSetFormatter.out(results);

		ArrayList<Resource> persons = new ArrayList<Resource>();

		while (results.hasNext()) {
			QuerySolution querySolution = (QuerySolution) results.next();
			Resource temp = querySolution.getResource("Person");
			persons.add(temp);
		}

		return persons;
	}
}
