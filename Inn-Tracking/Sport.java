public class Sport extends ActivityPackage {
   //static variables
	public final static int MAX_EQUIPMENTS= 9;
	public final static int SPORT_BASE_FEE= 75;
	//instance variables
	private Equipment[] equipments = new Equipment[MAX_EQUIPMENTS];
	private int numEquipment= 0;
	/**
      default values if the user inputed in nothing
   */
	public Sport() {
		super.setActivityName("Sport");
	}
	/**
      get the number of equipments
      @return numEquipment return the number of equipments
   */
	public int getNumEquipment() {
      return numEquipment;
   }
	/*
      check to see if the equipment can be set and added
      @param equipment the equipment     
      @return true or false if the equipment can be set and added
   */
	public boolean addEquipment(Equipment equipment){
		if(numEquipment < MAX_EQUIPMENTS){
			equipments[numEquipment]= equipment;
			numEquipment++;
			return true;
		}
		else{
			return false;
		}
	}
   /*
      calculate fees for the 
      @return cost return the cost of the package
   */
	@Override
	public double calculateFee() {
		double cost= SPORT_BASE_FEE;
		for(int i= 0; i<equipments.length; i++){
			if(equipments[i]!=null){
				cost+= equipments[i].getCost();
			}
		}
		return cost;
	}
   /*
      a collection of outputs for the contact info
      @return a collection of outputs for the sports package
   */
	@Override
	public String toString() {
		String equipmentReport= "";
		for(int i= 0; i<equipments.length; i++){
			if(equipments[i]!=null){
				equipmentReport+= equipments[i].toString();
			}
		}
		return "\nActivity name: " + super.getActivityName()
		+ "\nNumber of Equipment: " + numEquipment
		+ "\n"
		+ equipmentReport;
	}

}
