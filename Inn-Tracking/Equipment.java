public class Equipment {
   //static variables
	public final static int MIN_HOURS= 1;
	public final static int MAX_HOURS= 10;
	//instance variables
	private String name;
	private double hourlyCost;
	private int hoursRented;
	/**
      default values if the user inputed in nothing
   */
	public Equipment() {
   
   }
	/**
      get the name
      @return name return the name
   */
	public String getName() {
      return name;
   }
   /**
      get the hourly cost
      @return hourlyCost return the hourly cost
   */
	public double getHourlyCost() {
      return hourlyCost;
   }
   /**
      get the hours rented
      @return hoursRented return the hours rented
   */
	public int getHoursRented() {
      return hoursRented;
   }
	/*
      check to see if the name can be set
      @param name the name     
      @return true or false if the name can be set
   */
	public boolean setName(String name){
      //check if name is blank
		if(name.equals("")){
			return false;
		}
		else{
			this.name= name;
			return true;
		}
	}
	/*
      check to see if the hourly cost can be set
      @param hourlyCost the hourly cost     
      @return true or false if the hourly cost can be set
   */
	public boolean setHourlyCost(double hourlyCost){
      //check if cost is less than 0
		if(hourlyCost>=0){
			this.hourlyCost= hourlyCost;
			return true;
		}
		else{
			return false;
		}
	}
	/*
      check to see if the name can be set
      @param name the name     
      @return true or false if the name can be set
   */
	public boolean setHoursRented(int hoursRented){
      //check if the hours are within range
		if(hoursRented > MIN_HOURS && hoursRented < MAX_HOURS){
			this.hoursRented= hoursRented;
			return true;
		}
		else{
			return false;
		}
	}
	/*
      caclulate the cost 
      @return the calculated cost
   */
	public double getCost(){
		return hoursRented * hourlyCost;
	}
	/*
      a collection of outputs for the contact info
      @return a collection of outputs for the equipment
   */
	public String toString(){
		return  "\nName: " + name +
				"\nHourly Rate: " + hourlyCost +
				"\nHours Rented: " + hoursRented+
				"\nCost: " + getCost();
	}
}
