package tesAct.database;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.Store;

public class DBController {

	Store store;

	public DBController() {
		store = DBConnection.getStore();
	}

	/**
	 * Stores a model in the database.
	 * 
	 * @param model
	 *            The model to store.
	 */
	public void storeModel(Model model) {

		String message = "";

		try {
			/*
			 * Criação de modelo RDF conectado a modelo de armazenamento em
			 * banco de dados relacional.
			 */
			Model connectedModel = SDBFactory.connectDefaultModel(this.store);

			/*
			 * Adiciona as novas TRIPLAS ao banco de dados. Caso alguma tripla
			 * já exista, ela não é armazenada.
			 */
			connectedModel.add(model);
			message = "Model stored successfully";
		} catch (Exception e) {
			e.printStackTrace();
			message = "Error storing the model. Error: " + e.getMessage();
		}

		System.out.println(message);
	}

	/**
	 * Queries RDF triples in a database.
	 * 
	 * @param queryString
	 *            The string specifying the query.
	 */
	public void queryModel(String queryString) {

		/*
		 * Criação de um objeto Query com a string de consulta na linguagem
		 * SPARQL.
		 */
		Query query = QueryFactory.create(queryString);

		/*
		 * Conexão ao banco de dados, que retorna uma coleção de GRAFOS
		 * armazenados.
		 */
		Dataset dataset = SDBFactory.connectDataset(store);

		/*
		 * Interface para a execução de uma única consulta sobre os GRAFOS
		 * retornados do BD.
		 */
		QueryExecution queryExecution = QueryExecutionFactory.create(query,
				dataset);

		/*
		 * Executa a consulta definida na string SPARQL e armazena em um
		 * ResultSet
		 */
		ResultSet resultSet = queryExecution.execSelect();

		/*
		 * Formatador dos resultados de uma consulta.
		 */
		ResultSetFormatter.out(resultSet);
	}

	/**
	 * Removes all the RDF triples from the database.
	 */
	public void removeAll() {
		String message = "";

		try {
			/*
			 * Criação de MODELO RDF conectado a modelo de armazenamento em
			 * banco de dados relacional.
			 */
			Model model = SDBFactory.connectDefaultModel(this.store);

			/*
			 * Remove todas as TRIPLAS RDF do banco de dados.
			 */
			model.removeAll();
			message = "Database cleaned!";
		} catch (Exception e) {
			message = "Error cleaning the database. Error: " + e.getMessage();
		}

		System.out.println(message);
	}
}