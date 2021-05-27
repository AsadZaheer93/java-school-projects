public class Theater extends ActivityPackage {
   //static variables
	public static final int MAX_SHOWS = 5;
	public static final int BASE_NUM_SHOWS = 3;
	public static final int THEATER_BASE_COST = 150;
	public static final int ADDITIONAL_SHOW_COST = 25;
	public static final double PREMIUM_SEAT_COST = 100;
	//instance variables
	private int numShows = 0;
	private boolean isPremium;
   /**
      default values if the user inputed in nothing
   */
	public Theater() {
		super.setActivityName("Theater");
	}
	/**
      get the number of shows
      @return numShows return the number of shows
   */
	public int getNumShows() {
      return numShows;
   }
   /**
      get the premium seatings
      @return isPremium return the premium seatings
   */
	public boolean getIsPremium() {
      return isPremium;
   }
   /*
      check to see if the number of shows can be set
      @param numShows the number of shows     
      @return true or false if the number of shows can be set
   */
	public boolean setNumShows(int numShows) {
      //see if the number of shows in within range
		if (numShows > 0 && numShows < MAX_SHOWS) {
			this.numShows= numShows;
			return true;
		} else {
			return false;
		}
	}
	/*
      check to see if the premium seatings can be set
      @param s_isPremium the premium seating     
      @return true or false if the premium seating can be set
   */
	public boolean setIsPremium(String s_isPremium){
      //check if the guest wants premium seatings
		if(!s_isPremium.equalsIgnoreCase("YES") && !s_isPremium.equalsIgnoreCase("NO")){
			return false;
		}
		if(s_isPremium.equalsIgnoreCase("YES")){
			isPremium= true;
			return true;
		}
		else{
			isPremium= false;
			return true;
		}
	}
	/*
      calculate fees for the 
      @return cost return the cost of the package
   */
	@Override
	public double calculateFee() {
		double cost = THEATER_BASE_COST;
		if (numShows > BASE_NUM_SHOWS) {
			cost += ADDITIONAL_SHOW_COST * (numShows - BASE_NUM_SHOWS);
		}
		if (isPremium) {
			cost += PREMIUM_SEAT_COST;
		}
		return cost;
	}
   /*
      a collection of outputs for the contact info
      @return a collection of outputs for the sports package
   */
	@Override
	public String toString() {
		return "Activity Name:" + super.getActivityName()+ 
					"\nPremium Seating: " + isPremium +
					"\nNumber of Shows: " + numShows;
	}

}
