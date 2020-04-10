package View;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLException;
import model.Register;
public class ExportData {


	/*This method print database to a text file  
	 **/
	public void saveToFile() throws SQLException, ClassNotFoundException {
		
		Register load = new Register();
		
		try {
			 PrintWriter out = new PrintWriter("ExportedData.txt");
				
				out.println("ID|  Name  | Personal number | Number of Boats");	
				
				for(int i =0; i< load.ListMember().size() ; i++) {
					
				out.println(load.getUser(load.ListMember().get(i)).getId() +" | "+ load.getUser(load.ListMember().get(i)).getName() + " | " + 
							load.getUser(load.ListMember().get(i)).getPersonalNum() + " | "+ load.getUser(load.ListMember().get(i)).getBoat());
					
				out.println("Boats List:");
					for (int j = 0; j<load.getUser(load.ListMember().get(i)).getRegisteredBoats().size(); j++){
						
						out.println("  ID: "+ load.getUser(load.ListMember().get(i)).getRegisteredBoats().get(j).getId()+" , Type: "+
									load.getUser(load.ListMember().get(i)).getRegisteredBoats().get(j).getName() +" , Length: "+
									load.getUser(load.ListMember().get(i)).getRegisteredBoats().get(j).getSize());
					}
						out.println("\n");
				
				}	
				
				System.out.println("Data successfully exported to the text file \n");	
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File is not found.");
			
		}
	}
	}
		
	

