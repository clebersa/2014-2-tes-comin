package database;

import java.sql.SQLException;

import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.Store;
import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.DatabaseType;
import com.hp.hpl.jena.sdb.store.LayoutType;
import com.hp.hpl.jena.sdb.util.StoreUtils;

/**
 * Configures and manages the connection to a SGBD.
 */
public class DBConnection {

	/**
	 * URI to access the SGBD containing the JDBC access protocol, the SGBD
	 * name, IP address of the database server and the communication port.
	 */
	private final static String DB_URI = "jdbc:postgresql://localhost:5432/";

	/**
	 * Name of the database created by the user to store the RDF triples.
	 */
	private final static String DB_NAME = "topicos";

	/**
	 * User name of the database user.
	 */
	private final static String DB_USER = "postgres";

	/**
	 * Password of the database user.
	 */
	private final static String DB_PASSWD = "senha123";

	/**
	 * Reference to the JDBC of the SGBD. <br/>
	 * The .jar file of the JDBC driver must be included to the project.
	 */
	// private final static String DBDRIVER_CLASS = "org.postgresql.Driver";

	/**
	 * Gets a store
	 * 
	 * @return
	 */
	public static Store getStore() {

		/*
		 * StoreDesc permite definir o layout do banco de dados relacional para
		 * armazenamento de triplas RDF no SGBD em questão.
		 */
		StoreDesc storeDesc = new StoreDesc(LayoutType.LayoutTripleNodesIndex,
				DatabaseType.PostgreSQL);

		/*
		 * SDBConnection encapsula os parâmetros de conexão ao SGBD e também
		 * oferece operações de log.
		 */
		SDBConnection conn = new SDBConnection(DB_URI + DB_NAME, DB_USER,
				DB_PASSWD);

		// System.out.println(conn);

		/*
		 * Store conecta-se ao SGBD segundo o layout e os parâmetros de acesso
		 * definidos em SDBConnection.
		 */
		Store store = SDBFactory.connectStore(conn, storeDesc);

		/*
		 * Caso o BD (DB_NAME) exista, mas ainda não tenha sido formatado com o
		 * layout em questão,ele o será e estará pronto para uso!
		 */
		try {
			if (!StoreUtils.isFormatted(store)) {
				store.getTableFormatter().create();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// System.out.println(store);
		return store;

	}

}