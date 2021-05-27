/*
   Name: Asad Zaheer
   Date: 12/12/2015
   Course/Section: IT 206-206
   Assignment: Assignment 10
   
   Description:
   Ask the guest what type of package they want for the hotel room in George
   Maosn University. They can choose from a sports package, academic package and 
   theatre package. For the sports package you must tells us how many equipment
   items you want for how many hours. They may choose to get between 0 to 9
   equipments. The guest may also choose academic for which they may choose to
   their lecture materials printed. For the theatre package the guest may choose to 
   get premium seatings. Before all of this the guest must provide their name,
   contact information, how long they are staying and if they are a smoker or not.
   While the program is executing the program will validate all of the information.
   In the end the report will show up to 555 guest information and their details.
*/
import javax.swing.JOptionPane;

public class MasonInn {
	public static void main(String[] args) {
		int guestCounter= 0;
		Guest[] guests = new Guest[Guest.MAX_GUESTS];
		String selection = getSelection(guestCounter);
		String guestReport= "";
		
		while(!selection.equals("2")){
			if(guestCounter < Guest.MAX_GUESTS){
				guests[guestCounter] = getGuest(guestCounter);
				guests[guestCounter].setCost();
				guestReport= guests[guestCounter].toString();
				guestCounter++;
				JOptionPane.showMessageDialog(null, guestReport);
			}
			else{
            //error message
				JOptionPane.showMessageDialog(null, "The maximum number of guests has been reached.");
			}
			selection = getSelection(guestCounter);
		}
		printFinalReport(guests);
	}
	/*
      print out the final report of all guests and their packages
      @param guests the collection of guests
   */
	public static void printFinalReport(Guest[] guests){
		int numGuests= 0;
		double totalRevenue= 0;
		double averageRevenue= 0;
		int academicLectureMaterial= 0;
		int rentedEquipment= 0;
		int theaterPremiumSeats= 0;
		
		for(int i= 0; i<guests.length; i++){
			if(guests[i]!=null){
				numGuests++;
				totalRevenue+= guests[i].getCost();
				if(guests[i].getActivityPackage() instanceof Academic){
					if(((Academic)guests[i].getActivityPackage()).getWantsAdditional()){
						academicLectureMaterial++;
					}
				}
				if(guests[i].getActivityPackage() instanceof Sport){
					rentedEquipment+= ((Sport)guests[i].getActivityPackage()).getNumEquipment();
				}
				if(guests[i].getActivityPackage() instanceof Theater){
					if(((Theater)guests[i].getActivityPackage()).getIsPremium()){
						theaterPremiumSeats++;
					}
				}
			}
		}
		averageRevenue= totalRevenue/numGuests;
		//print out the report
		String print= 
				"Number of guests: " + numGuests
				+ "\nTotal Revenue: " + String.format("%.2f", totalRevenue)
				+ "\nAverage Revenue: " + String.format("%.2f", averageRevenue)
				+ "\nAcademic Lecture Material printed: " + academicLectureMaterial
				+ "\nSports Equipment Rented: " + rentedEquipment
				+ "\nPremium Seats Reserved: " + theaterPremiumSeats;
		JOptionPane.showMessageDialog(null, print);
	}
	/*
      add a guest to the system
      @param guestCounter the number of guests inputed into the system    
      @return selection the selected inputed
   */
	public static String getSelection(int guestCounter){
      //ask if the user wants to add a guest or exit the program
		String selection= JOptionPane.showInputDialog("Please select a menu option.\n"
				+ "1: Add guest\n"
				+ "2: Exit\n"
				+ "Number of Guests: " + guestCounter);
      //error message and reprompt
		while(!selection.equals("1") && !selection.equals("2")){
			selection= JOptionPane.showInputDialog("Error! choice not found."
					+ "\nPlease a valid select a menu option.\n"
					+ "1: Add guest\n"
					+ "2: Exit\n"
					+ "Number of Guests: " + guestCounter);
		}
		return selection;
	}
	/*
      get what the guest chose  
      @return activity the selected activity package chosen
   */
	public static String getActivityChoice(){
      //ask what package the guest wants
		String activityChoice= JOptionPane.showInputDialog(
				"Please Select an Activity: "
				+ "\n1: Academic"
				+ "\n2: Theater"
				+ "\n3: Sport");
		//error message and reprompt
      while(!activityChoice.equals("1") && !activityChoice.equals("2") && !activityChoice.equals("3")){
			activityChoice= JOptionPane.showInputDialog(
					"Error. Choice not found."
					+ "\nPlease Select a valid Activity: "
					+ "\n1: Academic"
					+ "\n2: Theater"
					+ "\n3: Sport");
		}
		
		return activityChoice;
	}
	/*
      get the guest information
      @param guestCounter the number of guests inputed into the system    
      @return guest the guest information
   */
	public static Guest getGuest(int guestCounter){
		Guest guest = new Guest();
		//ask the guest their name
		String name= JOptionPane.showInputDialog("Enter guest name: ");
		while(!guest.setName(name)){
         //error message
			name= JOptionPane.showInputDialog("Error. Names can only have alphabet character. Re-enter.");
		}
		//ask if they guest is a smoker or not
		String s_isSmoker= JOptionPane.showInputDialog("Is the guest a smoker?\nType 'YES' or 'NO'.");
		while(!guest.setIsSmoker(s_isSmoker)){
         //error message
			s_isSmoker= JOptionPane.showInputDialog("Error. Invalid answer.\nIs the guest a smoker?\nType 'YES' or 'NO'.");
		}
		
		guest.setNumDays(getNumDays());
		guest.setEmergencyContact(getEmergencyContact());
		
		String activityChoice= getActivityChoice();
		if(activityChoice.equalsIgnoreCase("1")){
			guest.setActivityPackage(getAcademic());
		}
		else if(activityChoice.equalsIgnoreCase("2")){
			guest.setActivityPackage(getTheater());
		}
		else if(activityChoice.equalsIgnoreCase("3")){
			guest.setActivityPackage(getSport());
		}
		
		return guest;
	}
	/*
      set the academic package information
      @return academic the academic package information
   */
	public static ActivityPackage getAcademic(){
		ActivityPackage academic = new Academic();
      //ask the guest if they want additional lecture materials
		String wantsAdditional= JOptionPane.showInputDialog("Would the guest like additional lecture material?");
		while(!((Academic)academic).setWantsAdditional(wantsAdditional)){
         //error message
			wantsAdditional= JOptionPane.showInputDialog("Error. Type yes or no only.\nWould the guest like additional lecture material?");
		}
		academic.setFee(((Academic)academic).calculateFee());
		return academic;
	}
	/*
      set the theatre package information
      @return theatre the theatre package information
   */
	public static ActivityPackage getTheater(){
		ActivityPackage theater = new Theater();
      //ask the guest how many shows they want to watch
		String s_numShows= JOptionPane.showInputDialog("Please enter the number of shows:\nMaximum of 5");
		int numShows= 0;
		boolean isValid= false;
		do{
			try{
				numShows= Integer.parseInt(s_numShows);
				while(numShows > 5 || numShows < 0){
               //error message
					s_numShows= JOptionPane.showInputDialog("Shows must be less than 5." + "."
							+ "\nEach show after 3 is charged $25 per show." );
					numShows= Integer.parseInt(s_numShows);
				}
				isValid= true;
			}
			catch(NumberFormatException e){
            //error message
				s_numShows= JOptionPane.showInputDialog("Error enter a valid number for number of shows. ");
				isValid= false;
			}
		}
		while(!isValid);
		((Theater)theater).setNumShows(numShows);
      //ask the user if they want premium seating
		String s_isPremium= JOptionPane.showInputDialog("Premium seating? Type 'yes' or 'no'. ");
		while(!((Theater)theater).setIsPremium(s_isPremium)){
         //error message
			s_isPremium= JOptionPane.showInputDialog("Error. Type 'yes' or 'no' only.\nIs premium seating requested?");
		}
		((Theater)theater).setNumShows(numShows);
		theater.setFee(((Theater)theater).calculateFee());
		return theater;
	}
	/*
      set the sports package information
      @return sport the sports package information
   */
	public static ActivityPackage getSport(){
		ActivityPackage sport = new Sport();
      //ask if the guest want equipment
		String addEquipment= JOptionPane.showInputDialog("Would the guest like to check out equipment?");
		while(!addEquipment.equalsIgnoreCase("YES") && !addEquipment.equalsIgnoreCase("NO")){
         //error message
			addEquipment= JOptionPane.showInputDialog("Error. Type 'yes' or 'no' only. Would the guest like to check out equipment?");
		}
		int numEquipment= 0;
		while(addEquipment.equalsIgnoreCase("YES")){
			if(numEquipment <= Sport.MAX_EQUIPMENTS ){
				Equipment equipment = new Equipment();
				String equipmentName= JOptionPane.showInputDialog("Enter equipment name: "+ "\nEquipment number: " + numEquipment);
				
				while(!equipment.setName(equipmentName)){
               //error message
					equipmentName= JOptionPane.showInputDialog("Enter valid equipment name: "
							+ "\nEquipment number: " + numEquipment);
				}
				double hourlyCost= 0;
            //ask the guest how long they want the eqiupment rented
				do{
					String s_hourlyCost= JOptionPane.showInputDialog("Enter hourly cost for equipment: "+ "\nEquipment number: " + numEquipment);
					try{
						hourlyCost= Double.parseDouble(s_hourlyCost);
					}
					catch(NumberFormatException e){
                  //error message
						s_hourlyCost= JOptionPane.showInputDialog("Enter a valid cost for equipment: "+ "\nEquipment number: " + numEquipment);
					}
				}
				while(hourlyCost<0);
				
				int hoursRented= 0;
				//ask the guest the equipment info
				do{
					String s_hoursRented= JOptionPane.showInputDialog("Enter hours rented for equipment: "+ "\nEquipment number: " + numEquipment);
					try{
						hoursRented= Integer.parseInt(s_hoursRented);
					}
					catch(NumberFormatException e){
                  //error message and reprompt
						s_hoursRented= JOptionPane.showInputDialog("Enter a valid number of hours: "
								+ "\nMaximum hours: " + Equipment.MAX_HOURS
								+ "\nMinimum hours: " + Equipment.MIN_HOURS+ "\nEquipment number: " + numEquipment);
					}
				}
				while(hoursRented < Equipment.MIN_HOURS || hoursRented > Equipment.MAX_HOURS);
				numEquipment++;
			}
			else{
            //error message
				JOptionPane.showInputDialog("The maximum number of equipments has been reached."+ "\nEquipment number: " + numEquipment);
			}
         //ask if the guest wants to put another equipment
			addEquipment= JOptionPane.showInputDialog("Would the user like to rent more equipment?"+ "\nEquipment number: " + numEquipment);
		}
		sport.setFee(((Sport)sport).calculateFee());
		return sport;
	}
	/*
      get the number of days the guest wants to stay
      @return numDays the number of days the guests wants to stay   
   */
	public static int getNumDays(){
		int numDays= 0;
		String s_numDays= JOptionPane.showInputDialog("Enter number of booked days: ");
		do{
			try{
				numDays= Integer.parseInt(s_numDays);
			}
			catch(NumberFormatException e){
				numDays= -1;
            //error message
				s_numDays= JOptionPane.showInputDialog("Error. enter a valid number of days for number of booked days.");
			}
		}
		while(numDays<0);
		return numDays;
	}
	/*
      set the emergency contact information
      @return emergencyContact the emergency contact information
   */
	public static EmergencyContact getEmergencyContact(){
		EmergencyContact emergencyContact = new EmergencyContact();
		
		String name= JOptionPane.showInputDialog("Enter emergency contact name: ");
		while(!emergencyContact.setName(name)){
         //error message
			name= JOptionPane.showInputDialog("Error. Names can only have alphabet character. Re-enter.");
		}
		
		String phoneNumber= JOptionPane.showInputDialog("Enter emergency contact phone number: ");
		while(!emergencyContact.setPhoneNumber(phoneNumber)){
         //error message
			phoneNumber= JOptionPane.showInputDialog("Error. Enter a valid phone number.\nEnter emergency contact phone number: "
					+ "\nFormat: (703) 555-5555");
		}
		
		String email= JOptionPane.showInputDialog("Enter emergency contact email: ");
		while(!emergencyContact.setEmail(email)){
         //error message
			email= JOptionPane.showInputDialog("Error. Enter in the valid email format: ");
		}
		
		return emergencyContact;
	}
	
}
