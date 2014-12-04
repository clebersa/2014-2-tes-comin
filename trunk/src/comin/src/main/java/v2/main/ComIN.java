package v2.main;

import java.util.ArrayList;

import com.hp.hpl.jena.ontology.OntClass;

import v2.ontologies.Acm;
import v2.controller.GroupController;
import v2.controller.ModelController;
import v2.controller.PersonController;
import v2.database.DBController;

public class ComIN {

	public static void main(String[] args) {
		ModelController modelController = new ModelController();
		/*
		ArrayList<OntClass> cleberInterests = new ArrayList<OntClass>();
		cleberInterests.add(Acm.B_1_4_0_Languages_And_Compilers);
		cleberInterests.add(Acm.B_1_4_1_Optimization);
		cleberInterests.add(Acm.B_2_4_High_Speed_Arithmetic);
		cleberInterests.add(Acm.B_5_1_0_Arithmetic_And_Logic_Units);
		PersonController cleberController = new PersonController(
				"Cleber", 
				"(62)1029-3948", 
				"cleber.93cd@gmail.com", 
				cleberInterests, 
				modelController.getModel());
		*/
		ArrayList<OntClass> samuelInterests = new ArrayList<OntClass>();
		samuelInterests.add(Acm.B_1_4_1_Optimization);
		samuelInterests.add(Acm.B_2_4_High_Speed_Arithmetic);
		samuelInterests.add(Acm.C_0_2_Modeling_Of_Computer_Architecture);
		samuelInterests.add(Acm.C_1_2_0_Array_And_Vector_Processors);
		PersonController samuelController = new PersonController(
				"Samuel", 
				"(62)2938-4756", 
				"almeida.samuel.junio@gmail.com",
				samuelInterests, 
				modelController.getModel());
		
		ArrayList<OntClass> leticiaInterests = new ArrayList<OntClass>();
		leticiaInterests.add(Acm.B_1_4_1_Optimization);
		leticiaInterests.add(Acm.C_0_General);
		leticiaInterests.add(Acm.D_1_2_Automatic_Programming);
		PersonController leticiaController = new PersonController(
				"Letícia",
				"(62)5647-3829", 
				"leticia_nb1@hotmail.com",
				leticiaInterests, 
				modelController.getModel());
		/*
		ArrayList<OntClass> larissaInterests = new ArrayList<OntClass>();
		larissaInterests.add(Acm.B_1_4_1_Optimization);
		larissaInterests.add(Acm.D_1_2_Automatic_Programming);
		larissaInterests.add(Acm.E_1_0_Arrays);
		larissaInterests.add(Acm.B_2_4_High_Speed_Arithmetic);
		PersonController larissaController = new PersonController(
				"Larissa", 
				"(62)4738-2910", 
				"larissamean@gmail.com", 
				larissaInterests, 
				modelController.getModel());
		*/
		//modelController.printRDF();
		
		DBController dbController = new DBController();
		dbController.storeModel(modelController.getModel());
		dbController.removeAll();
		
		ArrayList<OntClass> searchInterests = new ArrayList<OntClass>();
		searchInterests.add(Acm.C_0_2_Modeling_Of_Computer_Architecture);
		GroupController groupController = new GroupController(searchInterests, 
				modelController.getModel(), leticiaController.getPerson());
		modelController.printRDF();
	}

}
