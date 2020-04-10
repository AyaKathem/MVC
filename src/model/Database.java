package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
		private String Member = "Member";
		private String Boat = "Boat";
		
	    public Connection conn;
	    public Database(Connection conn) {
		        this.conn = conn;
		    }
		   	 
	    protected void createTables() {
		        try {
		        	Statement tablesSt = conn.createStatement();
		        	tablesSt.executeUpdate( "CREATE TABLE IF NOT EXISTS "+ Boat +
			                    " (Boat_ID INT PRIMARY KEY," +
			            		" Member_ID INT NOT NULL,"+
			            		" Size INT NOT NULL ,"+
			            		" Type TEXT NOT NULL ,"+
			                    " FOREIGN KEY (Member_ID) REFERENCES " + Member + "(Member_ID) ON DELETE CASCADE) ");

		        	tablesSt.close();
			            
			         
		        	tablesSt = conn.createStatement();
		        	tablesSt.executeUpdate( "CREATE TABLE IF NOT EXISTS "+ Member +
		            			" (Member_ID INT PRIMARY KEY," +
		            		    " Member_Name TEXT NOT NULL ," +
		                     	" Personal_Number LONG UNIQUE )");
		        	tablesSt.close();
		            	           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }


		    protected void InsertData() { 
		        try {
		        	
		            conn.setAutoCommit(false);       
		          
		            //you can un-comment this and register members and boats manually
		         /* Statement memberSt =  conn.createStatement();
		 
		            memberSt.executeUpdate( "INSERT OR IGNORE INTO " + Member + " VALUES(500 , 'Jon', 8512057532)");
		           
		            
		            
		            Statement boatSt =  conn.createStatement();
		            
		           boatSt.executeUpdate("INSERT OR IGNORE INTO " + Boat + " VALUES(1000, 500, '23','Sailboat' )");*/
		            
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		    }
		    
		    protected void clearTables() {
		            

		        try {
		        
		        	Statement st = conn.createStatement();
		           
		            st.execute("DROP TABLE IF EXISTS " + Member);
		            
		            Statement st1 = conn.createStatement();
		            
		            st1.execute("DROP TABLE IF EXISTS " + Member);
		            	           
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
	}