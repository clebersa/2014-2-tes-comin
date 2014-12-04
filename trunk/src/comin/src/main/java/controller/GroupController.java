package controller;

import java.io.File;
import java.util.ArrayList;

import ontologies.Foaf;
import ontologies.Relationship;

import org.mindswap.pellet.jena.PelletReasonerFactory;

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
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ReasonerRegistry;
import com.hp.hpl.jena.util.FileManager;

public class GroupController {
	private Resource group;
	private ArrayList<Resource> members;
	private Model model;

	/**
	 * Cria um novo GroupController
	 * 
	 * @param Resource
	 *            no modelo RDF
	 * 
	 * 
	 * 
	 * **/

	public GroupController(Resource group) {
		this.group = group;
	}

	/**
	 * Cria um novo recurso usando os parâmetros e chama o outro método
	 * construtor passando esse recurso.
	 * 
	 * @param topics
	 *            Tópicos são áreas de conhecimento.
	 * @param model
	 *            Modelo RDF é onde o grupo vai ser criado.
	 * @param searcher
	 *            Pesquisador é aquele que pesquisa alguém com uma mesma área de
	 *            conhecimento.
	 */

	public GroupController(ArrayList<OntClass> topics, Model model,
			Resource searcher) {
		this(model.createResource());
		this.model = model;

		members = new ArrayList<Resource>();
		search(topics);

		for (Resource member : members) {
			addMember(member);
		}

		for (OntClass topic : topics) {
			addTopic(topic);
		}
		makeWLTK(searcher);
	}

	/**
	 * Retorna um recurso grupo.
	 * 
	 * @return Group O Grupo é formado a partir de pessoas com uma mesma área de
	 *         interesse.
	 */

	public Resource getGroup() {
		return group;
	}

	public void removeGroup() {
		for (Resource member : members) {
			model.remove(member, Foaf.member, group);
		}
		members.clear();
		group.removeAll(Foaf.topic);
	}

	/**
	 * Adiciona um membro ao grupo.
	 * 
	 * @param member
	 *            Membro é a pessoa que faz parte de um grupo
	 */

	public void addMember(Resource member) {
		member.addProperty(Foaf.member, group);
	}

	/**
	 * Adiciona um tópico ao grupo.
	 * 
	 * @param topic
	 *            É uma área de conhecimento
	 */

	public void addTopic(OntClass topic) {
		group.addProperty(Foaf.topic, topic);
	}

	/**
	 * Cria relacionamentos "Gostaria de conhecer (WouldLikeToKnow)" a partir de
	 * quem efetuou a pesquisa.
	 * 
	 * @param searcher
	 *            Pesquisador é aquele que busca uma pessoa com uma mesma área
	 *            de conhecimento.
	 * @param members
	 *            Membros são as pessoas que fazem parte de um grupo.
	 */
	public void makeWLTK(Resource searcher) {
		for (Resource member : members) {
			if (member.getURI() != searcher.getURI()) {
				searcher.addProperty(Relationship.wouldLikeToKnow, member);
			}
		}
	}

	private void search(ArrayList<OntClass> topics) {

		String queryString = "PREFIX rel:<http://www.semanticweb.org/ontologies/2014/5/foaf.owl#>"
				+ "SELECT ?Person " + "WHERE {";

		for (OntClass topic : topics) {
			queryString = queryString
					+ " ?Person <http://www.semanticweb.org/ontologies/2013/10/foaf.owl#topic_interest> <"
					+ topic + "> .";
		}

		queryString = queryString + " }";

		String schemaOntology = "src/main/java/ontologies/foaf.owl";
		Model schema = FileManager.get().loadModel(
				"src/main/java/ontologies/foaf.owl");
		// InfModel infModel = ModelFactory.createRDFSModel(schema, model);

		Reasoner reasoner = ReasonerRegistry.getOWLMicroReasoner();
		reasoner = reasoner.bindSchema(schema);
		InfModel infModel = ModelFactory.createInfModel(reasoner, model);
		/**
		 * Criação do modelo ontológico utilizando o Pellet
		 * */
		OntModel ont = ModelFactory.createOntologyModel(
				PelletReasonerFactory.THE_SPEC, null);
		ont.read(new File(schemaOntology).toURI().toString(), "RDF/XML");

		reasoner = ReasonerRegistry.getOWLReasoner();
		reasoner = reasoner.bindSchema(ont);

		/**
		 * Realiza a inferência
		 * */
		infModel = ModelFactory.createInfModel(reasoner, model);

		Query query = QueryFactory.create(queryString);
		/**
		 * Interface para a execução de uma única consulta sobre os Grafos
		 * retornados do BD
		 * */
		QueryExecution qe = QueryExecutionFactory.create(query, infModel);
		/**
		 * Executa a consulta definida na string SPARQL e amarzena em um
		 * ResultSet
		 * */
		ResultSet results = qe.execSelect();

		/**
		 * Formatador dos resultados de uma conslta
		 * ResultSetFromatter.out(results);
		 * */
		while (results.hasNext()) {
			QuerySolution querySolution = (QuerySolution) results.next();
			Resource temp = querySolution.getResource("Person");
			members.add(temp);
		}
	}
}
