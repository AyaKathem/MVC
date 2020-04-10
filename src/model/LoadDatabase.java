package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.sqlite.SQLiteConfig;

public class LoadDatabase {
	
	public static Connection conn;
	 
	/*Connect to database
	 * */
	public static Connection getConnection()  throws ClassNotFoundException, SQLException {
		SQLiteConfig config = new SQLiteConfig();
	    config.enforceForeignKeys(true);
	    Class.forName("org.sqlite.JDBC");
	    conn = DriverManager.getConnection("jdbc:sqlite:dataYatchClub.db1", config.toProperties());
	    Database database = new Database(conn);
	   // database.clearTables(); // Uncomment if you want to clear tables 
	    database.createTables(); 
	    database.InsertData(); 
	   
	     return conn;
	}
		
}