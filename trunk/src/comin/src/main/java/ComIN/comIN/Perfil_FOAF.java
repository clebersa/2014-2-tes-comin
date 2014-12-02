package ComIN.comIN;

import ontologias.Foaf;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class Perfil_FOAF {
	private Pessoa pessoa_perfil;
	private String link_perfil;
	
	public Perfil_FOAF(Pessoa param_pessoa, String param_link_perfil){
		pessoa_perfil = param_pessoa;
		link_perfil = param_link_perfil;
	}
	
	public void registrar_pessoa(Model param_model){
		Resource perfil_foaf = param_model.createResource(link_perfil);
		perfil_foaf.addProperty(Foaf.name,pessoa_perfil.getNome());
		perfil_foaf.addProperty(Foaf.nick,pessoa_perfil.getApelido());
		

	}
	
	public void adicionar_grupo(String grupo){
		
	}
}
