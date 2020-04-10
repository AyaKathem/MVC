package Control;


import java.sql.SQLException;
import View.Console;
import View.DataViewer;
import View.ExportData;
import model.Boat;
import model.Member;
import model.Register;



public class Control {
	
	private Console view = new Console();
	private Register load = new Register();
	
	
	public void run() {
		DataViewer d_viewer = new DataViewer();
		try {
		switch (view.getEvent()) {
			case look_for_specific_member:
				d_viewer.lookForUser(view.getMemberIdView());
				 run();
			case LIST_MEMBERS_COMPACT:
				d_viewer.CompactList();
				 run();
			case LIST_MEMBERS_VERBOSE:
				d_viewer.verboseList();
				 run();
			case CREATE_MEMBER:	
				 addMemberView(view.getNameView(),view.getPersonalNumView());									
			case DELETE_MEMBER:
				d_viewer.CompactList();
				 deleteMemberView(view.getMemberIdView());	
			case UPDATE_MEMBER:
				d_viewer.CompactList();
				 editMemberView(view.getMemberIdView(),view.getNameView(),view.getPersonalNumView());
			case Export:
			    	 ExportData export = new ExportData();
					 export.saveToFile();
				     run();
			case CREATE_BOAT:
				d_viewer.verboseList();
				 addBoat(view.getMemberIdView(), view.getBoatTypeView(), view.getBoatLengthView());	
			case DELETE_BOAT:
				d_viewer.verboseList();
				 deleteBoat(view.getBoatIdView());
			case UPDATE_BOAT:
				d_viewer.verboseList();
				 editBoat(view.getBoatIdView(), view.getBoatTypeView(), view.getBoatLengthView());
			case QUIT:
				 System.exit(0);	
			default:
				 run();
			}
			
		} catch (Exception e) {
			System.err.println("Error ");
			run();
		}
		
		
	}
	
  private void  addMemberView(String name, long m_pN  ) {
	  //Check if the member exist
	  if (load.PersonalNumberExist(m_pN)) {
		  try {
			     load.insertUser(new Member(name,m_pN));
		  	  } catch (SQLException e) {
		  		 System.err.println("Error 1");
		  	  }
		    	 run();
		 }
	  else {
		  System.err.println("The member is already exist exist");
		  run();
	  }
	}
  
  private void  editMemberView(int id ,String name, long personalNum) {

	  try {
			load.updateUser(new Member(id,name,personalNum));
	  		} catch (ClassNotFoundException | SQLException e) {
	  			System.err.println("Error, Please check the personal number you add, it can be already exist");
		}
	  run();
	
  }
  
  private void  deleteMemberView(int id ) { 
	try {
		load.deleteUser(id);
	} catch (SQLException e) {
	    System.err.println("Error 2");
	}
	    run();
  }
  
 private void addBoat(int memberId ,String b_type, int b_size  ) {
	
		try {
			load.insertBoat(load.getUser(memberId).getId(),b_type, b_size);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Error 3");	
	   }
	
      run();
}
  
 private void editBoat(int boatId ,String b_type, int b_size ) throws SQLException {
	 try {
			load.updateBoat(new Boat (boatId,b_type,b_size));
		} catch (ClassNotFoundException e) {
			System.err.println("Error 4"); 
		}
	 run();
 }
 
 private void deleteBoat(int boatId ) {
	   try {
		load.deleteBoat(boatId);
	} catch (SQLException e) {
		System.err.println("Error 5"); 
	}
	   run();
	 }
 

}
