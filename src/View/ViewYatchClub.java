package View;
public interface ViewYatchClub {
	public enum Event {
		look_for_specific_member ("0"),
		LIST_MEMBERS_COMPACT("1"),
		LIST_MEMBERS_VERBOSE("2"),
		CREATE_MEMBER("3"),
		DELETE_MEMBER("4"),
		UPDATE_MEMBER("5"),
		Export("6"),
		CREATE_BOAT("7"),
		DELETE_BOAT("8"),
		UPDATE_BOAT("9"),
		QUIT("q");
		
		private String value;
		
		private Event(String value) {
			this.value = value;
		}
		
	    public static Event getEnum(String value) {
	        for(Event event : values())
	            if(event.value.equals(value))
	            	return event;
	        
	        throw new IllegalArgumentException("\"" + value + "\" is invalid.");
	    }

	}
}