package View;

import java.util.Scanner;


public class Console implements ViewYatchClub  {
	
	private int IntInput ;
	private long longInput ;
	
	public Event getEvent() {
		 Scanner sc = new Scanner(System.in);
	    System.out.println("\n ");
		System.out.println("0- Look for specific member");
		System.out.println("1- Compact list. ");
		System.out.println("2- Verbose list. ");
        System.out.println("3- Add new member. ");
		System.out.println("4- Delete member. ");
		System.out.println("5- Edit member. ");	
		System.out.println("6- Export data to a file. ");
		System.out.println("7- Add new boat. ");
		System.out.println("8- Delete boat. ");
		System.out.println("9- Edit boat. ");
		System.out.println("q- Close program. ");
		return Event.getEnum(sc.next());
	}
	
	
	public int getMemberIdView() {
		 System.out.println("Enter Member ID: ");
		 Scanner sc1 = new Scanner(System.in);	
		 if (sc1.hasNextInt() ) {
			 IntInput= sc1.nextInt(); 
			 
		 }else {
				System.err.println("The input must be integer ");
				 getMemberIdView();
		 }
		return IntInput;
	}

	public String getNameView() {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println("Enter your name: ");
		 String name= sc1.next();
		
		return name;
	}
	
	public long getPersonalNumView() {
	 System.out.println("Enter your personal number (yymmddxxxx): ");
	 Scanner sc = new Scanner(System.in);
	 if (sc.hasNextLong()) {
		 
		 longInput= sc.nextLong() ;
		 
	 }else {
			System.err.println("The input must be integer");
			 getPersonalNumView();
	 }
	
		return longInput;
	}
	
	public int getBoatIdView() {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println(" Enter boat id: ");
		 if (sc1.hasNextInt() ) {
			 IntInput= sc1.nextInt(); 
		 }else {
				System.err.println("The input must be integer ");
				getBoatIdView() ;
		 }
			return IntInput;
	}
	public String getBoatTypeView() {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println(" Enter boat type  (Sailboat, Motorsailer, kayak/Canoe, Other): ");
		 String boatType= sc1.next();
		
		return boatType;
	}
	public int getBoatLengthView() {
		Scanner sc1 = new Scanner(System.in);
		 System.out.println(" Enter boat length: ");
	
		 if (sc1.hasNextInt() ) { 
			 IntInput= sc1.nextInt(); 
		 }else {
				System.err.println("The input must be integer ");
				getBoatLengthView();
		 }
			return IntInput;
	}
	
	
}


