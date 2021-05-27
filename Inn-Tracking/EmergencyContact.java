public class EmergencyContact {
   //instance variables
	private String name;
	private String phoneNumber;
	private String email;
	/**
      get the name
      @return name return the name
   */
	public String getName() {
      return name;
   }
   /**
      get the phone number
      @return phoneNumber return the phone number
   */
	public String getPhoneNumber() {
      return phoneNumber;
   }
   /**
      get the email
      @return email return the email
   */
	public String getEmail() {
      return email;
   }
	/*
      check to see if the name can be set
      @param name the name     
      @return true or false if the name can be set
   */
	public boolean setName(String name){
      //check if blank
		if(name.equals("")){
			return false;
		}
		else{
			for(int i= 0; i<name.length(); i++){
				if(Character.isDigit(name.charAt(i))){
					return false;
				}
			}
			this.name= name;
			return true;
		}
	}
	/*
      check to see if the phone number can be set
      @param phoneNumber the phone number      
      @return true or false if the phone number can be set
   */
	public boolean setPhoneNumber(String phoneNumber) {
		//phone number format (123) 456-7890
		if(phoneNumber.length()!=14){return false;}
		if(phoneNumber.charAt(0)=='('
				&& Character.isDigit(phoneNumber.charAt(1))
				&& Character.isDigit(phoneNumber.charAt(2))
				&& Character.isDigit(phoneNumber.charAt(3))
				&& phoneNumber.charAt(4)==')'
				&& phoneNumber.charAt(5)==' '
				&& Character.isDigit(phoneNumber.charAt(6))
				&& Character.isDigit(phoneNumber.charAt(7))
				&& Character.isDigit(phoneNumber.charAt(8))
				&& phoneNumber.charAt(9)=='-'
				&& Character.isDigit(phoneNumber.charAt(10))
				&& Character.isDigit(phoneNumber.charAt(11))
				&& Character.isDigit(phoneNumber.charAt(12))
				&& Character.isDigit(phoneNumber.charAt(13))
				){
			this.phoneNumber = phoneNumber;
			return true;
		}
		else{
			return false;
		}
	}
	/*
      check to see if the email can be set
      @param email the email     
      @return true or false if the email can be set
   */
	public boolean setEmail(String email){
		//first check the number of '@'s and '.'s. 
		int numAts= 0;
		int numDots= 0;
		int atPosition= 0;
		int dotPosition= 0;
		
		for(int i= 0; i<email.length(); i++){
			if(email.charAt(i)=='@'){
				numAts++;
				atPosition= i;
			}
			if(email.charAt(i)=='.'){
				numDots++;
				dotPosition= i;
			}
		}
		//ensures exactly 1 '.', exactly 1 '@'. Since the at position can not be the first in the email as captured
		//above in the for loop, it validates at least one character is before the @ sign and one character after the
		//'.'. 
		if(numAts!= 1 || numDots!=1||atPosition==0||dotPosition==email.length()){return false;}
		
		this.email= email;
		return true;
	}
	/*
      a collection of outputs for the contact info
      @return a collection of outputs for the contact info
   */
	public String toString(){
		return "\nEmergency Contact Name:"  + name +
				"\nEmergency Phone Number: " + phoneNumber+
				"\nEmergency Email: " + email;
	}
}
