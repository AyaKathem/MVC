import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Control.Control;
import model.LoadDatabase;

public class main1dv607 {
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException, IOException {		
		
		       Connection connection = LoadDatabase.getConnection();
		       System.out.println("Welcome to Yacht club! \n");
		       Control start = new Control();
		       start.run();
		       connection.close();
		       
		  }
}