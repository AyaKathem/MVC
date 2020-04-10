package View;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Boat;
import model.Register;

public class DataViewer {
	
public void CompactList() throws SQLException, ClassNotFoundException {
		
		Register load = new Register();
		System.out.println("ID|  Name  | Personal number | Number of Boats");	
		for(int i =0; i< load.ListMember().size() ; i++) {
			
			System.out.println(load.getUser(load.ListMember().get(i)).getId() +" | "+ load.getUser(load.ListMember().get(i)).getName() + " | " + 
							   load.getUser(load.ListMember().get(i)).getPersonalNum() + " | "+ load.getUser(load.ListMember().get(i)).getBoat());
			
		}
	}
	
	public void verboseList() throws SQLException, ClassNotFoundException {
		
		Register load = new Register();
		System.out.println("ID|  Name  | Personal number | Number of Boats");	
		for(int i =0; i< load.ListMember().size() ; i++) {
			
			System.out.println(load.getUser(load.ListMember().get(i)).getId() +" | "+ load.getUser(load.ListMember().get(i)).getName() + " | " +
											load.getUser(load.ListMember().get(i)).getPersonalNum() + " | "+ load.getUser(load.ListMember().get(i)).getBoat());
								
			printBoatList(load.getUser(load.ListMember().get(i)).getRegisteredBoats());
		}
	}

	public void lookForUser(int memberId ) throws ClassNotFoundException, SQLException {
		
	    Register load = new Register();
		System.out.println("ID : "+load.getUser(memberId).getId() +" | Name : "+load.getUser(memberId).getName()+ " | Personal Number : " +
								   load.getUser(memberId).getPersonalNum() );
							
		printBoatList(load.getUser(memberId).getRegisteredBoats());
	}
	
	private void printBoatList (ArrayList<Boat> BoatList) {
		for (int j = 0; j< BoatList.size(); j++){
			
			System.out.println("  ID: "+ BoatList.get(j).getId()+" , Type: "+BoatList.get(j).getName() +" , Length: "+ BoatList.get(j).getSize());
		}
		System.out.println("\n");
	}
	
	
}
