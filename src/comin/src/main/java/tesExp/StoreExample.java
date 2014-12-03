/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tesExp;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;

import java.io.*;

import tesAct.database.DBController;

/**
 * Armazenando dados RDF de um arquivo em um BD
 */
public class StoreExample {

	// Caminho do arquivo de entrada no projeto Java corrente
	static final String inputFileName = "src/main/java/tesExp/exampleFiles/rdf-xml.txt";

	public static void main(String args[]) {

		// Criação de um MODELO RDF vazio em memória
		Model model = ModelFactory.createDefaultModel();

		// Uso da classe Java FILEMANAGER para localizar o arquivo de entrada
		InputStream in = FileManager.get().open(inputFileName);
		if (in == null) {
			throw new IllegalArgumentException("File: " + inputFileName
					+ " not found");
		}

		// Leitura do arquivo RDF de entrada na sintaxe padrão RDF/XML
		model.read(in, "");
		
		model.write(System.out);

		// Transferindo o MODELO RDF em memória para o BD relacional
		DBController ctrl = new DBController();
		ctrl.storeModel(model);

		// Exclui as todas as TRIPLAS
		 ctrl.removeAll();

		// Criação de String de consulta na sintaxe da linguagem SPARQL
		// String queryString = "SELECT ?s ?p ?o " +
		// "WHERE {?s ?p ?o}";

		// Consulta as TRIPLAS armazenadas no BD
		// ctrl.queryModel(queryString);
	}
}
