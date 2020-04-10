package model;

public class Boat {
	
		private int id;
	    private String type;
	    private int length;
	
	    public Boat() {
	    }
	    
	    public Boat(String type, int length) {
	        this.type = type;
	        this.length = length;
	    }
	    
	    public Boat(int id, String type, int length) {
	        this.id = id;
	        this.type = type;
	        this.length = length; 
	    }
	 
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getName() {
	        return type;
	    }
	    public void setName(String type) {
	        this.type = type;
	    }
	    public int getSize() {
	        return length;
	    }
	    public void setSize(int length) {
	        this.length = length;
	    }
	    
}
