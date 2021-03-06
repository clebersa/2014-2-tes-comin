package ontologies;

/* CVS $Id: $ */
 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*;
 
/**
 * Vocabulary definitions from C:\Users\Ernesto\Dropbox\UFG\EST�GIO EM DOC�NCIA\sugestoesdeprojetos\relationship.owl 
 * @author Auto-generated by schemagen on 25 Out 2014 16:59 
 */
public class Relationship {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    public static final ObjectProperty acquaintanceOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#acquaintanceOf" );
    
    public static final ObjectProperty ambivalentOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#ambivalentOf" );
    
    public static final ObjectProperty ancestorOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#ancestorOf" );
    
    public static final ObjectProperty antagonistOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#antagonistOf" );
    
    public static final ObjectProperty apprenticeTo = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#apprenticeTo" );
    
    public static final ObjectProperty childOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#childOf" );
    
    public static final ObjectProperty closeFriendOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#closeFriendOf" );
    
    public static final ObjectProperty collaboratesWith = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#collaboratesWith" );
    
    public static final ObjectProperty colleagueOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#colleagueOf" );
    
    public static final ObjectProperty descendantOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#descendantOf" );
    
    public static final ObjectProperty employedBy = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#employedBy" );
    
    public static final ObjectProperty employerOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#employerOf" );
    
    public static final ObjectProperty enemyOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#enemyOf" );
    
    public static final ObjectProperty engagedTo = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#engagedTo" );
    
    public static final ObjectProperty friendOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#friendOf" );
    
    public static final ObjectProperty grandchildOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#grandchildOf" );
    
    public static final ObjectProperty grandparentOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#grandparentOf" );
    
    public static final ObjectProperty hasMet = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#hasMet" );
    
    public static final ObjectProperty influencedBy = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#influencedBy" );
    
    public static final ObjectProperty knowsByReputation = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#knowsByReputation" );
    
    public static final ObjectProperty knowsInPassing = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#knowsInPassing" );
    
    public static final ObjectProperty knowsOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#knowsOf" );
    
    public static final ObjectProperty lifePartnerOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#lifePartnerOf" );
    
    public static final ObjectProperty livesWith = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#livesWith" );
    
    public static final ObjectProperty lostContactWith = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#lostContactWith" );
    
    public static final ObjectProperty mentorOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#mentorOf" );
    
    public static final ObjectProperty neighborOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#neighborOf" );
    
    public static final ObjectProperty parentOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#parentOf" );
    
    public static final ObjectProperty participant = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#participant" );
    
    public static final ObjectProperty participantIn = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#participantIn" );
    
    public static final ObjectProperty siblingOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#siblingOf" );
    
    public static final ObjectProperty spouseOf = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#spouseOf" );
    
    public static final ObjectProperty worksWith = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#worksWith" );
    
    public static final ObjectProperty wouldLikeToKnow = m_model.createObjectProperty( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#wouldLikeToKnow" );
    
    public static final OntClass Relationship = m_model.createClass( "http://www.semanticweb.org/ontologies/2014/5/relationship.owl#Relationship" );
    
}
