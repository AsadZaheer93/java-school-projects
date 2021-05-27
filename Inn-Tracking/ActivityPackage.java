public abstract class ActivityPackage {
	//instance variables
   private String activityName;
	private double fee;
	/**
      get the activity name
      @return activityName return the name of the activity
   */
	public String getActivityName() {
      return activityName;
   }
   /**
      get the fee
      @return fee return the fee
   */
	public double getFee(){
		return fee;
   }
	/*
      check to see if the activity name can be set
      @param activityName the name of the activity package      
      @return true or false if the activity name can be set
   */
	public void setActivityName(String activityName){
		this.activityName= activityName;
	}
	/*
      check to see if the fee can be set
      @param fee the fee
   */
	public void setFee(double fee){
		this.fee= fee;
	}
	/*
      calculate the fee
   */
	public abstract double calculateFee();
   /*
      get all of the outputs for each package
   */
	public abstract String toString();
}
