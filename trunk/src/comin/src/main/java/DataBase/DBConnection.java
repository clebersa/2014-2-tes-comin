package DataBase;

/*
 * Classe que configura e gerencia a conex�o a um SGBD relacional
 */

import java.sql.SQLException;

import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.Store;
import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.DatabaseType;
import com.hp.hpl.jena.sdb.store.LayoutType;
import com.hp.hpl.jena.sdb.util.StoreUtils;

public class DBConnection {

	public Store getStore() {

		// StoreDesc permite definir o leiaute do BD relacional para
		// armazenamento de triplas RDF no SGBD em quest�o
		StoreDesc storeDesc = new StoreDesc(LayoutType.LayoutTripleNodesIndex,
				DatabaseType.PostgreSQL);

		// SDBConnection encapsula os par�metros de conex�o ao SGBD e tamb�m
		// oferece opera��es de log
		SDBConnection conn = new SDBConnection(DBParameters.DB_URI
				+ DBParameters.DB_NAME, DBParameters.DB_USER,
				DBParameters.DB_PASSWD);

		// System.out.println(conn);
		
		Store store = SDBFactory.connectStore(conn, storeDesc);
		
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