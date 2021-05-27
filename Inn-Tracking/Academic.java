public class Academic extends ActivityPackage {
   //static variables
	public static final double ACADEMIC_BASE_COST= 206;
	public static final double ADDITIONAL_MATERIAL_COST= 50;
	//instance variables
	private boolean wantsAdditional;
	/**
      default values if the user inputed in nothing
   */
	public Academic() {
		super.setActivityName("Academic");
	}
	/**
      get if they want additional materials
      @return wantsAdditional return if they want additional materials
   */
	public boolean getWantsAdditional() {
      return wantsAdditional;
   }
	/*
      check to see if the addtional materials can be set
      @param s_wantsAdditional wants additional materials
      @return true or false if the additoinal materials can be set
   */
	public boolean setWantsAdditional(String s_wantsAdditional){
      //check if they inputed neither yes or no
		if(!s_wantsAdditional.equalsIgnoreCase("YES") && !s_wantsAdditional.equalsIgnoreCase("NO")){
			return false;
		}
      //check if they inputed yes
		if(s_wantsAdditional.equalsIgnoreCase("YES")){
			wantsAdditional= true;
			return true;
		}
      //could not be set
		else{
			wantsAdditional= false;
			return true;
		}
	}
	/*
      calculate fees for the 
      @return cost return the cost of the package
   */
	@Override
	public double calculateFee() {
		double cost= ACADEMIC_BASE_COST;
      //adding the additional materials
		if(wantsAdditional){
			cost+= ADDITIONAL_MATERIAL_COST;
		}
		return cost;
	}
   /*
      a collection of outputs for the package
      @return a collection of outputs for the package
   */
	@Override
	public String toString() {
		return "\nActivity name: " + super.getActivityName()
		+ "\nAdditional Material Requested: " + wantsAdditional;
	}

}
