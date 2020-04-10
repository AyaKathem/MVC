package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Member {
	    private Integer id;
	    private String name;
	    private long personlNum;
	    private int boat;
	    private ArrayList<Boat> registeredBoats = new ArrayList<Boat>();
	 
	    public Member() {
	    }
	    public Member(int id ) {
	    	 this.id = id;
	    }
	    public Member(String name, long personlNum) {
	    	
	        this.name = name;
	        this.personlNum = personlNum;
	       
	    }
	    public Member(Integer id, String name, long personlNum) {
	        this.id = id;
	        this.name = name;
	        this.personlNum = personlNum;   
	    }
		
	    public Integer getId() {
	        return id;
	    }
	    public void setId(Integer id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public long getPersonalNum() {
	        return personlNum;
	    }
	    public void setPersonalNum(long personlNum) {
	        this.personlNum = personlNum;
	    }  
	    
	    public void setBoat(int b){
			this.boat = b;
		}
		public int getBoat(){
			return this.boat;
		}
		public ArrayList<Boat> getRegisteredBoats(){
			return this.registeredBoats;
		}
		
		public void addBoat(int id, String t, int l) throws SQLException{
			registeredBoats.add(new Boat(id,t,l));
			this.boat++;		
		}
}
