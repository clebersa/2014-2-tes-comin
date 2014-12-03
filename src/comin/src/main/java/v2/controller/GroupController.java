package v2.controller;

import java.util.ArrayList;

import tesAct.ontologies.Foaf;
import tesAct.ontologies.Relationship;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

public class GroupController {
	private Resource group;
	
	public GroupController(Resource group) {
		this.group = group;
	}
	
	public GroupController(ArrayList<OntClass> topics, Model model, Resource searcher){
		this(model.createResource());
		
		ArrayList<Resource> members = search(topics, model);
		
		for(Resource member: members){
			addMember(member);
		}
		
		for(OntClass topic : topics){
			addTopic(topic);
		}
	}
	
	public Resource getGroup(){
		return group;
	}
	
	public void addMember(Resource member){
		member.addProperty(Foaf.member, group);
	}
	
	public void addTopic(OntClass topic){
		topic.addProperty(Foaf.topic, group);
	}
	
	public void makeWLTK(Resource searcher){
		 StmtIterator members = group.listProperties(Foaf.member);
		 while(members.hasNext()){
			 Statement statement = members.next();
			 Resource member = statement.getObject().asResource();
			 if(member != searcher){
				 searcher.addProperty(Relationship.wouldLikeToKnow, member);
			 }
		 }
	}
	
	private ArrayList<Resource> search(ArrayList<OntClass> topics, Model model){
		String sparqlQuery = "";
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
		try{
			ResultSet resultSet = queryExecution.execSelect();
			while(resultSet.hasNext()){
				QuerySolution querySolution = resultSet.nextSolution();
			}
		}catch(Exception e)
		{}
		return null;
	}
}
