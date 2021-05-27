import javax.swing.JOptionPane;
public abstract class Server {
	//instance and staic variables of a server object
	public static final int MAX_NUM_SERVER= 206;
	public static final int MIN_USAGE_LEVEL= 0;
	public static final int MAX_USAGE_LEVEL= 100;
	private static String[] serverNames = new String[MAX_NUM_SERVER];
	private static int numServers= 0;
	private static double totalHardDriveCapacity= 0;
	private String serverName;
	private String operatingSystem;
	private double hardDriveCapacity;
	private double usageLevel;
	/**
      default values if the user inputed in nothing
   */
	public Server(){
		
	}
	/**
      default values if the server name, operating system and hard drive capacity is already valided
   */
	public Server(String serverName, String operatingSystem, double hardDriveCapacity){
		setServerName(serverName);
		setOperatingSystem(operatingSystem);
		setHardDriveCapacity(hardDriveCapacity);
	}
   /*
      calculate the usage level
   */
	public abstract double calculateUsageLevel();
	/**
      get the number of servers
      @return numServers return the number of servers
   */
	public static int getNumServers(){return Server.numServers;}
   /*
      get the total hard drive capacity
      @return totalHardDriveCapacity return the total hard drive capcity
   */
	public static double getTotalHardDriveCapacity(){return Server.totalHardDriveCapacity;}
	/*
      get the server name
      @return serverName the server name
   */
	public String getServerName(){return this.serverName;}
   /*
      get the oeprating system
      @return operatingSystem the operating system
   */
	public String getOperatingSystem(){return this.operatingSystem;}
    /*
      get the hard drive capacity
      @return hardDriveCapacity the hard drive capacity
   */
	public double getHardDriveCapacity(){return this.hardDriveCapacity;}
   /*
      get the usage level
      @return usageLevel the usage level
   */
	public double getUsageLevel(){return this.usageLevel;}	
	/*
      check to see if the server name can be set
      @param serverName name of the server
      @return true or false if the server name can be set
   */
	public boolean setServerName(String serverName){
		if(!serverName.equals("")){
			for(int i= 0; i<numServers; i++){
				if(serverNames[i]!=null){
					if(serverNames[i].equalsIgnoreCase(serverName)){
                  //error message
						JOptionPane.showMessageDialog(null, "Error. Name has already been used.\n"
								+ "\nGiven Name: " + serverName
								+"\nTaken Name: " + serverNames[i]);
						return false;
					}
				}
			}
			serverNames[numServers]= serverName;
			this.serverName= serverName;
			return true;
		}
		else{
         //error message
			JOptionPane.showMessageDialog(null, "Error. Name can not be blank.");
			return false;
		}
	}
	/*
      check to see if the operating system can be set
      @param operatingSystem name of the operating system
      @return true or false if the operating system can be set
   */
	public boolean setOperatingSystem(String operatingSystem){
		if(operatingSystem.equalsIgnoreCase("Windows") || operatingSystem.equalsIgnoreCase("Linux") || operatingSystem.equalsIgnoreCase("OS X")){
			this.operatingSystem= operatingSystem;
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Error. \"" + operatingSystem + "\" is not a valid option.");
			return false;
		}
	}
	/*
      check to see if the hard drive capacity can be set
      @param hardDriveCapacity capacity of the hard drive capacity
      @return true or false if the hard drive capacity can be set
   */
	public boolean setHardDriveCapacity(double hardDriveCapacity){
		if(hardDriveCapacity>=0){
			this.hardDriveCapacity= hardDriveCapacity;
			Server.totalHardDriveCapacity+= hardDriveCapacity;
			return true;
		}
		else{
         //error
			JOptionPane.showMessageDialog(null, "Error. Hard Drive Capacity may not be less than 0.");
			return false;
		}
	}
	/*
      check to see if the usage level can be set
      @param usageLevel usage level
      @return true or false if the usage level can be set
   */
	public boolean setUsageLevel(double usageLevel){
		if(usageLevel > Server.MIN_USAGE_LEVEL && usageLevel > Server.MAX_USAGE_LEVEL){
			this.usageLevel= usageLevel;
			return true;
		}
		else{
			return false;
		}
	}
   /*
      check to see if the number of servers can be set
      @param numServers number of servers
      @return true or false if the number of servers can be set
   */
	public static void setNumServers(int numServers){
		Server.numServers= numServers;
	}
	
}
