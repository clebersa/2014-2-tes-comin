package ComIN.comIN;

import ontologias.Acm;
import ontologias.Foaf;
import ontologias.Relationship;
import DataBase.Controller;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;

public class App 
{
	public static void queryModel(String queryString, Model m) {

		// Criação de um objeto Query com a string de consulta na linguagem SPARQL
		Query query = QueryFactory.create(queryString);

		// Interface para a execução de uma única consulta sobre os GRAFOS retornados do BD
		QueryExecution qe = QueryExecutionFactory.create(query, m);

		// Executa a consulta definida na string SPARQL e armazena em um ResultSet
		ResultSet results = qe.execSelect();

		// Formatador dos resultados de uma consulta
		ResultSetFormatter.out(results);
	}
	
    public static void main( String[] args )
    {
        
        Model model = ModelFactory.createDefaultModel();
        Resource samuel_junio = model.createResource(Foaf.getURI() + "/samuel_junio.58");
        samuel_junio.addProperty(Foaf.topic_interest,Acm.G_3_8_Queueing_Theory);
        samuel_junio.addProperty(Foaf.topic_interest,Acm.A_1_Introductory_And_Survey);
        samuel_junio.addProperty(Foaf.topic_interest,Acm.E_3_Data_Encryption);
        samuel_junio.addProperty(Foaf.topic_interest,Acm.G_1_8_Partial_Differential_Equations);
        
        
        Resource larissa_nunes = model.createResource(Foaf.getURI() + "/larissa_nunes.12");
        larissa_nunes.addProperty(Foaf.topic_interest,Acm.I_4_6_1_Pixel_Classification);
        larissa_nunes.addProperty(Foaf.topic_interest,Acm.D_3_4_7_Parsing);
        larissa_nunes.addProperty(Foaf.topic_interest,Acm.G_1_8_Partial_Differential_Equations);
        larissa_nunes.addProperty(Foaf.topic_interest,Acm.E_3_Data_Encryption);
        
        Resource cleber_souza = model.createResource(Foaf.getURI() + "/cleber_souza.74");
        cleber_souza.addProperty(Foaf.topic_interest,Acm.G_3_8_Queueing_Theory);
        cleber_souza.addProperty(Foaf.topic_interest,Acm.F_4_3_Formal_Languages);
        cleber_souza.addProperty(Foaf.topic_interest,Acm.H_1_Models_And_Principles);
        cleber_souza.addProperty(Foaf.topic_interest,Acm.A_General_Literature);
        
        Resource leticia_nunes = model.createResource(Foaf.getURI() + "/leticia_nunes.26");
        leticia_nunes.addProperty(Foaf.topic_interest,Acm.D_3_4_7_Parsing);
        leticia_nunes.addProperty(Foaf.topic_interest,Acm.G_1_8_Partial_Differential_Equations);
        leticia_nunes.addProperty(Foaf.topic_interest,Acm.D_3_2_1_Concurrent_Distributed_And_Parallel_Languages);
        leticia_nunes.addProperty(Foaf.topic_interest,Acm.F_2_1_0_Computation_Of_Transforms);
        
        
        
        samuel_junio.addProperty(Relationship.wouldLikeToKnow,Acm.I_4_6_1_Pixel_Classification);
        samuel_junio.addProperty(Relationship.wouldLikeToKnow,Acm.D_3_2_1_Concurrent_Distributed_And_Parallel_Languages);
        
        larissa_nunes.addProperty(Relationship.wouldLikeToKnow,Acm.F_2_1_0_Computation_Of_Transforms);
        larissa_nunes.addProperty(Relationship.wouldLikeToKnow,Acm.H_1_Models_And_Principles);
        
        cleber_souza.addProperty(Relationship.wouldLikeToKnow,Acm.I_4_6_1_Pixel_Classification);
        cleber_souza.addProperty(Relationship.wouldLikeToKnow,Acm.G_1_8_Partial_Differential_Equations);
        
        leticia_nunes.addProperty(Relationship.wouldLikeToKnow,Acm.E_3_Data_Encryption);
        leticia_nunes.addProperty(Relationship.wouldLikeToKnow,Acm.A_General_Literature);
        
        
        Controller temp_controller = new Controller();
        
        temp_controller.storeModel(model);
        
        
        Model schema = FileManager.get().loadModel("src/main/java/ontologias/relationship.owl");
		InfModel infModel = ModelFactory.createRDFSModel(schema, model);
        
        
        String query;
		query = "PREFIX rel: <http://www.semanticweb.org/ontologies/2014/5/relationship.owl#> "
				+ "SELECT ?pessoa1 ?pessoa2 " + "WHERE " 
				+ "{?pessoa1 rel:wouldLikeToKnow ?pessoa2 }";
		System.out.println("É mentor de...");
		queryModel(query, infModel);
		System.out.println();
		
        
        model.write(System.out);
   
    }
}
