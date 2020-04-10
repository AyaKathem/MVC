package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Register {
	private Member member= new Member();

	/*Get user info by Id
	 */
	public Member getUser(int m_Id) throws ClassNotFoundException, SQLException {
	   
	     ResultSet rs = LoadDatabase.conn.createStatement().executeQuery("SELECT * FROM Member WHERE Member_ID=" + m_Id);
	        if(rs.next()) {
	       	return extractUserFromResultSet(rs); 
           }   
	        
	    return null;
	}
	
	
	private Member extractUserFromResultSet(ResultSet rs) throws SQLException, ClassNotFoundException { 
		Member user = new Member();
		
	    user.setId( rs.getInt("Member_ID") );
	    user.setName( rs.getString("Member_Name") );
	    user.setPersonalNum( rs.getLong("Personal_Number") );
	    
	    ResultSet rs2 = LoadDatabase.conn.createStatement().executeQuery("SELECT * FROM Boat WHERE Boat.Member_ID = "+rs.getInt("Member_ID") );
	  
	    while(rs2.next()) {
	    user.addBoat(rs2.getInt("Boat_ID"),rs2.getString("Type"), rs2.getInt("Size"));
	    	}
	    return user;
	}
	
	
	//This method check if the personalNumber already exist to avoid duplicate register members 
	public boolean PersonalNumberExist(long personalNumber)  {
		boolean cheackIfExist;
		try {
		    ResultSet ex = LoadDatabase.conn.createStatement().executeQuery("SELECT * FROM Member WHERE Personal_Number=" + personalNumber);	
		    	ex.getBoolean("Personal_Number"); //if the member exist it return true
					cheackIfExist= false;
				} catch (SQLException e) {
					//the member is not exist
					cheackIfExist= true;
				}
		return cheackIfExist;
	}
	
	public boolean insertUser(Member member) throws SQLException  {
		 	try {
	    		ResultSet rc=   LoadDatabase.conn.createStatement().executeQuery("SELECT * FROM Member ORDER BY Member_ID DESC LIMIT 1");
		
				 Statement MemberSt =  LoadDatabase.conn.createStatement();
				 MemberSt.executeUpdate("INSERT OR IGNORE INTO Member VALUES("+(rc.getInt("Member_ID")+1)+" , '"+ member.getName()+"', "+member.getPersonalNum()+")");
				 LoadDatabase.conn.commit();
				 LoadDatabase.conn.setAutoCommit(false);
			
			} catch (SQLException e) {
				
				 Statement MemberSt =  LoadDatabase.conn.createStatement();
				 MemberSt.executeUpdate("INSERT OR IGNORE INTO Member VALUES("+500+" , '"+ member.getName()+"', "+member.getPersonalNum()+")");
				 LoadDatabase.conn.commit();
				 LoadDatabase.conn.setAutoCommit(false);
			}
	    
	    return false;
	}
	
	public boolean updateUser(Member member) throws ClassNotFoundException, SQLException {
		
	    	Statement updateP =  LoadDatabase.conn.createStatement();
            updateP.executeUpdate(" UPDATE Member SET Member_Name = '"+member.getName()+"', Personal_Number = "+member.getPersonalNum()+" WHERE Member_ID = " +member.getId());      
            LoadDatabase.conn.commit();
            LoadDatabase.conn.setAutoCommit(false); 
          	
	    return true;
	}
	
	
	public boolean deleteUser(int m_Id) throws SQLException {
	    
	    	Statement updateP =  LoadDatabase.conn.createStatement();
            updateP.executeUpdate("DELETE FROM Member WHERE Member_ID =" +m_Id );
            LoadDatabase.conn.commit();
            LoadDatabase.conn.setAutoCommit(false); 
           
		   
	    return true;
	}
	
	public void insertBoat(int m_id, String b_Type, int b_length) throws SQLException {
		
		
		try {
			//check the last ID in the list and increment by 1 to get unique Id 
			ResultSet rc = LoadDatabase.conn.createStatement().executeQuery("SELECT * FROM Boat ORDER BY Boat_ID DESC LIMIT 1");
		   Statement MemberSt = LoadDatabase.conn.createStatement();
    	             MemberSt.executeUpdate("INSERT OR IGNORE INTO Boat VALUES("+(rc.getInt("Boat_ID")+1)+" , "+m_id+" , "+b_length+" , '"+b_Type+"')");
    	             LoadDatabase.conn.commit();
    	             LoadDatabase.conn.setAutoCommit(false);
    	             
    	             member.addBoat((rc.getInt("Boat_ID")+1),b_Type, b_length);      
			
	   
		} catch (SQLException e1) { // otherwise if the list is empty start from 1000 
			int startId = 1000;
			Statement MemberSt = LoadDatabase.conn.createStatement();
			          MemberSt.executeUpdate("INSERT OR IGNORE INTO Boat VALUES("+startId+" , "+m_id+" , "+b_length+" , '"+b_Type+"')");
			          LoadDatabase.conn.commit();
			          LoadDatabase.conn.setAutoCommit(false);
			            
			          member.addBoat(startId,b_Type, b_length);   
			}
	}

	public boolean updateBoat(Boat boat) throws ClassNotFoundException, SQLException {
	
	    	Statement updateBoat =  LoadDatabase.conn.createStatement();
	    	updateBoat.executeUpdate(" UPDATE Boat SET Type = '"+boat.getName()+"', Size = '"+boat.getSize()+"' WHERE Boat_ID = " +boat.getId());
            LoadDatabase.conn.commit();
            LoadDatabase.conn.setAutoCommit(false); 
     	
		    
	    return true;
	}
	
	public boolean deleteBoat(int b_Id) throws SQLException {
	    
	    	Statement DeleteBoat =  LoadDatabase.conn.createStatement();
	    	DeleteBoat.executeUpdate("DELETE FROM Boat WHERE Boat_ID=" +b_Id );
            LoadDatabase.conn.commit();
            LoadDatabase.conn.setAutoCommit(false);

	    return true;
	}
	
	
	public  ArrayList<Integer> ListMember () throws SQLException {
		
	    ResultSet rs2 = LoadDatabase.conn.createStatement().executeQuery(" SELECT  Member.*  FROM  Member ");
	    ArrayList<Integer> m_List = new ArrayList<Integer>(); 
	    while(rs2.next()) {
	    	m_List.add(rs2.getInt("Member_ID"));
			}
		
		return m_List;
     }
	
}
