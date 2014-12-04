package main;

import java.util.ArrayList;

import ontologies.Acm;

import com.hp.hpl.jena.ontology.OntClass;

import controller.GroupController;
import controller.ModelController;
import controller.PersonController;
import database.DBController;

public class ComIN {

	public static void main(String[] args) {
		ModelController modelController = new ModelController();
		
		ArrayList<OntClass> cleberInterests = new ArrayList<OntClass>();
		cleberInterests.add(Acm.B_1_4_Microprogram_Design_Aids);
		cleberInterests.add(Acm.B_2_4_1_Cost_Performance);
		PersonController cleberController = new PersonController(
				"Cleber", 
				"(62)1029-3948", 
				"cleber.93cd@gmail.com", 
				cleberInterests, 
				modelController.getModel());
		
		ArrayList<OntClass> samuelInterests = new ArrayList<OntClass>();
		samuelInterests.add(Acm.B_1_4_Microprogram_Design_Aids);
		samuelInterests.add(Acm.B_2_4_High_Speed_Arithmetic);
		PersonController samuelController = new PersonController(
				"Samuel", 
				"(62)2938-4756", 
				"almeida.samuel.junio@gmail.com",
				samuelInterests,
				modelController.getModel());
		
		ArrayList<OntClass> leticiaInterests = new ArrayList<OntClass>();
		leticiaInterests.add(Acm.B_1_4_1_Optimization);
		leticiaInterests.add(Acm.B_2_4_1_Cost_Performance);
		PersonController leticiaController = new PersonController(
				"Letícia",
				"(62)5647-3829", 
				"leticia_nb1@hotmail.com",
				leticiaInterests, 
				modelController.getModel());
		
		ArrayList<OntClass> larissaInterests = new ArrayList<OntClass>();
		larissaInterests.add(Acm.B_1_4_1_Optimization);
		larissaInterests.add(Acm.D_2_8_2_Process_Metrics);
		PersonController larissaController = new PersonController(
				"Larissa", 
				"(62)4738-2910", 
				"larissamean@gmail.com", 
				larissaInterests, 
				modelController.getModel());
		
		//modelController.printRDF();
		
		// CHAMADA DE MÉTODOS QUE SALVA O MODELO NO BANCO DE DADOS
		//DBController dbController = new DBController();
		//dbController.storeModel(modelController.getModel());
		//dbController.removeAll();
		
		ArrayList<OntClass> searchInterests = new ArrayList<OntClass>();
		searchInterests.add(Acm.B_1_4_Microprogram_Design_Aids);
		
		GroupController groupController = new GroupController(searchInterests, 
				modelController.getModel(), leticiaController.getPerson());
		
		searchInterests = new ArrayList<OntClass>();
		searchInterests.add(Acm.B_2_4_High_Speed_Arithmetic);
		
		groupController = new GroupController(searchInterests, 
				modelController.getModel(), leticiaController.getPerson());
		
		modelController.printRDF();
		
		/*cleberController.delInterest(Acm.B_1_4_1_Optimization, modelController.getModel());
		//modelController.printRDF();
		leticiaController.delInterest(Acm.B_1_4_1_Optimization, modelController.getModel());
		//modelController.printRDF();
		samuelController.delInterest(Acm.B_1_4_1_Optimization, modelController.getModel());
		//modelController.printRDF();
		larissaController.delInterest(Acm.B_1_4_1_Optimization, modelController.getModel());
		//modelController.printRDF();*/
		
	}

}
