import javax.swing.JOptionPane;
public class FileServer extends Server {
	//instance and staic variables of a file server object
	public final static int MAX_NUM_USERS= 5000;
	public final static double USAGE_CONSTANT= 0.05;
	private int numUsers;
	/**
      default values if the user inputed in nothing
   */
	public FileServer() {
		Server.setNumServers(getNumServers()+1);
	}
   /**
      default values if the server name, operating system and hard drive capacity is already valided
   */
	public FileServer(String serverName, String operatingSystem, double hardDriveCapacity) {
		super(serverName, operatingSystem, hardDriveCapacity);
		setUsageLevel(calculateUsageLevel());
		Server.setNumServers(getNumServers()+1);
	}
	/**
      get the number of users
      @return the number of users
   */
	public int getNumUsers(){return numUsers;}
	/**
      check to see if the number of users can be set
      @param numUsers number of users
      @return true or false if the number of users can be set
   */
	public boolean setNumUsers(int numUsers){
      //check if number of users is within range
		if(numUsers>=0 && numUsers < MAX_NUM_USERS){
			this.numUsers= numUsers;
			return true;
		}
		else{
         //error message
			JOptionPane.showMessageDialog(null, "Number of users must be greater than or equal to 0 and less than " + FileServer.MAX_NUM_USERS);
			return false;
		}
	}
   /**
      calculate the usage level
      @return usageLevel the usage level
   */
	public double calculateUsageLevel() {
		double usageLevel= USAGE_CONSTANT*numUsers;	
		if(usageLevel>Server.MAX_USAGE_LEVEL){
			usageLevel= Server.MAX_USAGE_LEVEL;
		}
		return usageLevel;
	}
	/*
      get the server name, operating system, hard drive capacity, usage level and number of users
      @return the server name, operating system, hard drive capacity, usage level and number of users
   */
	public String toString(){
		return "Server Type: File Server"
				+ "\nServer Name: " + super.getServerName()
				+ "\nOperating System: " + super.getOperatingSystem()
				+ "\nHard Drive Space: " + super.getHardDriveCapacity()
				+ "\nUsage Level: " + super.getUsageLevel()
				+ "\nNumber of Users: " + numUsers + "\n";

	}
}
