package DataBase;

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

public class Controller {

	DBConnection csdb;
	Store store;

	public Controller() {
		this.csdb = new DBConnection();
		this.store = csdb.getStore();
	}

	/*
	 * M�todo para armazenamento de TRIPLAS RDF em BD relacional
	 */
	public void storeModel(Model model) {

		String msg = "";

		try {
			// Cria��o de MODELO RDF conectado a modelo de armazenamento em BD
			// relacional
			Model m = SDBFactory.connectDefaultModel(this.store);

			// Adiciona as novas TRIPLAS ao BD; caso j� existam, nada acontece!
			m.add(model);
			msg = "Modelo armazenado com sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao inserir";
		}

		System.out.println(msg);
	}

	/*
	 * M�todo para consultar TRIPLAS RDF de um BD relacional
	 */
	public void queryModel(String queryString) {

		// Cria��o de um objeto Query com a string de consulta na linguagem
		// SPARQL
		Query query = QueryFactory.create(queryString);

		// Conex�o ao BD que retorna uma cole��o de GRAFOS armazenados
		Dataset ds = SDBFactory.connectDataset(store);

		// Interface para a execu��o de uma �nica consulta sobre os GRAFOS
		// retornados do BD
		QueryExecution qe = QueryExecutionFactory.create(query, ds);

		// Executa a consulta definida na string SPARQL e armazena em um
		// ResultSet
		ResultSet results = qe.execSelect();

		// Formatador dos resultados de uma consulta
		ResultSetFormatter.out(results);
	}

	/*
	 * M�todo para remover TODAS as TRIPLAS RDF de um BD relacional
	 */
	public void removeAll() {
		String msg = "";

		try {
			// Cria��o de MODELO RDF conectado a modelo de armazenamento em BD
			// relacional
			Model m = SDBFactory.connectDefaultModel(this.store);

			// Remove todas as TRIPLAS RDF do BD :-o
			m.removeAll();
			msg = "Banco vazio";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Erro ao deletar arquivos do banco";
		}

		System.out.println(msg);
	}

}