public class Guest {
   //static variables
	public static final int MAX_GUESTS= 3;
	public static final double SMOKER_SURCHAGE_PERCENT= 0.10;
	public static final int BASE_FEE= 45;
	private static int guestNumber= 100000;
	private static String guestID= "G"+guestNumber;
   //instance variables
	private String name;
	private EmergencyContact emergencyContact;
	private ActivityPackage activityPackage;
	private int numDays;
	private boolean isSmoker;
	private double cost;
	/**
      default values if the user inputed in nothing
   */
	public Guest(){
		guestNumber++;
	}
	/**
      get the guest ID
      @return guestID return the guest ID
   */
	public String getGuestID() {
      return guestID;
   }
   /**
      get the name
      @return name return the name
   */
	public String getName() {
      return name;
   }
   /**
      get the emergency contact
      @return emergencyContact return the emergency contact   
   */
	public EmergencyContact getEmergencyContact() {
      return emergencyContact;
   }
   /**
      get the activity package
      @return activityPackage return the activity package
   */
	public ActivityPackage getActivityPackage() {
      return activityPackage;
   }
   /**
      get the number of days
      @return numDays return the number of days
   */
	public int getNumDays() {
      return numDays;
   }
   /**
      get the if the guest is a smoker
      @return isSmoker return the if the guest is a smoker
   */
	public boolean getIsSmoker() {
      return isSmoker;
   }
   /**
      get the cost
      @return cost return the cost
   */
	public double getCost() {
      return cost;
   }
	/*
      check to see if the name can be set
      @param name the name     
      @return true or false if the name can be set
   */
	public boolean setName(String name){
      //check if the name is blank
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
      check to see if the numeber of days can be set
      @param numDays the number of days     
      @return true or false if the number of days can be set
   */
	public void setNumDays(int numDays){
		this.numDays= numDays;
	}
	/*
      check to see if the conatct info can be set
      @param emergencyContact the contact info     
      @return true or false if the contact info can be set
   */
	public void setEmergencyContact(EmergencyContact emergencyContact){
		this.emergencyContact= emergencyContact;
	}
	/*
      check to see if the activity package can be set
      @param activityPackage the activity package     
      @return true or false if the activity package can be set
   */
	public void setActivityPackage(ActivityPackage activityPackage){
		this.activityPackage= activityPackage;
	}
	/*
      check to see if the guest is a smoker can be set
      @param isSmoker if the guest is a smoker     
      @return true or false if the guest is a smoker can be set
   */
	public boolean setIsSmoker(String s_isSmoker){
      //see if the guest inputed in neither yes or no
		if(!s_isSmoker.equalsIgnoreCase("YES") && !s_isSmoker.equalsIgnoreCase("NO")){
			return false;
		}
      //see if the guest inputed in yes
		if(s_isSmoker.equalsIgnoreCase("YES")){
			this.isSmoker= true;
			return true;
		}
		else{
			this.isSmoker= false;
			return true;
		}
	}
	/*
      check to see if the cost can be set
      @param cost the cost     
      @return true or false if the cost can be set
   */
	public void setCost(){
      //calculate the cost
		cost= BASE_FEE + activityPackage.getFee();
		if(isSmoker){
			cost+= cost*SMOKER_SURCHAGE_PERCENT;
		}
	}
	/*
      a collection of outputs for the contact info
      @return a collection of outputs for the guest
   */
	public String toString(){
		return 
				"\nGuest ID: " + guestID +
				"\nName: " + name +
				"\nDays Stayed: " + numDays+
				"\nSmoker: " + isSmoker +
				"\nCost: " + String.format("%.2f", cost)+
				emergencyContact.toString()+
				activityPackage.toString();
	}
}
