/*
   Name: Asad Zaheer
   Date: 11/22/2015
   Course/Section: IT 206-206
   Assignment: Assignment 8
   
   Description:
   This program asks the user what kind of server they would like to input from
   the menu consisting of file server, web server or quit. When entering quit
   the program will quit it out and show you a server report of what has been inputed.
   You can only input 206 servers. When choosing a server type you will be asked
   to input server name, operating system and hard drive capacity. These will all
   be validated to see if they can be set. Now for file servers you will also be
   asked to input the number of users and for the web server you will be asked to
   input the language that that server supports from 2 to 5 languages for each
   server. For every invalid output you will see an error message with a reprompt
   so that you may input again a valid input. This will keep on happening until
   the program receives a valid input. When the user has iputed 206 servers you will
   receive a messae saying that you have reached the max and that you must quit and
   see the server report. Each server will also automatically calculate the usage level.
*/
import javax.swing.JOptionPane;
public class NetworkEngineerJob {
   //variables and their initializaiton        
   public static void main(String[] args) {
		Server[] servers = new Server[Server.MAX_NUM_SERVER];
		int numServers= 0;
		String serverReport = "Server Report\n\n";
      //ask the user what they want to do
		String choice= getChoice();
		//check if the user inputed a 3
		while(!choice.equals("3")){
         //check if the user inputed a 1
			if(choice.equals("1")){
				if(numServers < Server.MAX_NUM_SERVER){
					addWebServer(numServers, servers);
					numServers++;
				}
				else{
               //maximum number of servers inputed have been reached message
					JOptionPane.showMessageDialog(null, "The maximum number of servers has been reached.");
				}
			}
			//check if the user inputed a 2
			else if(choice.equals("2")){
				if(numServers < Server.MAX_NUM_SERVER){
					addFileServer(numServers, servers);
					numServers++;
				}
				else{
               //maximum number of servers inputed have been reached message
					JOptionPane.showMessageDialog(null, "The maximum number of servers has been reached.");
				}
			}
			choice= getChoice();
		}
		//add up all of the servers and hard drives
		for(int i= 0; i<numServers; i++){
			serverReport+= servers[i].toString();
		}
		serverReport+="\nTotal Servers: " + Server.getNumServers();
		serverReport+="\nTotal Hard Drive Space (TBs): " + String.format("%.2f", Server.getTotalHardDriveCapacity());
		
		JOptionPane.showMessageDialog(null, serverReport);
	}
   /*
      get user inputed for what they want to do
      @return choice the input that the user has chosen
   */
	public static String getChoice(){
      //promt the user what they want to do
		String choice= JOptionPane.showInputDialog("Select a number choice:"
				+ "\n1: Add new web server"
				+ "\n2: Add new File server"
				+ "\n3: Quit"
				+ "\n\nNumber of Servers: " + Server.getNumServers()
            + "\nMaximum Servers: " + Server.MAX_NUM_SERVER);
		
		while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")){
         //error message and reprompt
			choice= JOptionPane.showInputDialog("Error. Select a valid number choice below:"
					+ "\n1: Add new web server"
					+ "\n2: Add new File server"
					+ "\n3: Quit"
					+ "\n\nNumber of Servers: " + Server.getNumServers()
					+ "\nMaximum Servers: " + Server.MAX_NUM_SERVER);
		}
		return choice;
	}
	/*
      add a web server to the servers
      @param numServers the number of servers, servers all of the servers inputed
   */
	public static void addWebServer(int numServers, Server[] servers){
      //create a web server object
		servers[numServers]= new WebServer();
		//ask the user for the server name
		String serverName= JOptionPane.showInputDialog("Please enter web server name: ");

		while(!servers[numServers].setServerName(serverName)){
         //error message and repromt
			serverName= JOptionPane.showInputDialog("Please re-enter web server name: ");
		}
      //set the server name
		servers[numServers].setServerName(serverName);
		//ask the user for the operating system
		String operatingSystem= JOptionPane.showInputDialog("Enter Operating System for " + servers[numServers].getServerName()
				+ "\nWindows"
				+ "\nLinux"
				+ "\nOS X");
		//error message reprompt
		while(!servers[numServers].setOperatingSystem(operatingSystem)){
			operatingSystem= JOptionPane.showInputDialog("Re-enter Operating System for " + servers[numServers].getServerName()
					+ "\nWindows"
					+ "\nLinux"
					+ "\nOS X");
		}
      //set the operating system
		servers[numServers].setOperatingSystem(operatingSystem);
		//ask the user for the hard drive capacity
		String s_hardDriveCapacity= JOptionPane.showInputDialog("Hard Drive Capacity (TBs): \n" + servers[numServers].getServerName());
		boolean valid= false;
		double hardDriveCapacity= 0;
		do{
			try{
				hardDriveCapacity= Double.parseDouble(s_hardDriveCapacity);
				valid= servers[numServers].setHardDriveCapacity(hardDriveCapacity);
				//set the hard drive capacity
				if(!valid){
					s_hardDriveCapacity= JOptionPane.showInputDialog("Hard Drive Capacity (TBs): \n" + servers[numServers].getServerName());
					hardDriveCapacity= Double.parseDouble(s_hardDriveCapacity);
					valid= servers[numServers].setHardDriveCapacity(hardDriveCapacity);
				}
			}
			catch(NumberFormatException e){
            //error message
				s_hardDriveCapacity= JOptionPane.showInputDialog("Error, numbers only. \nHard Drive Capacity (TBs): \n " + servers[numServers].getServerName());
			}
		}while(!valid);
      //set the hard drive capacity   
		servers[numServers].setHardDriveCapacity(hardDriveCapacity);
		
		int numLanguages= 0;
		String language= "";
		
		outerloop:
		do{
         //check if their is enough space
			if(numLanguages<WebServer.MIN_NUM_LANGUAGES){
            //enter language
				language= JOptionPane.showInputDialog("Enter supported language for " + servers[numServers].getServerName() + "\nMinimum: " + WebServer.MIN_NUM_LANGUAGES+"\nLanguages: " + numLanguages);
				//error message and reprompt
            while(!(((WebServer)servers[numServers]).setLanguage(language))){
					language= JOptionPane.showInputDialog("Re-enter supported language for " + servers[numServers].getServerName() + "\nMinimum: " + WebServer.MIN_NUM_LANGUAGES+"\nLanguages: " + numLanguages);
				}
				numLanguages++;
			}
			else{
            //ask the user for the language
				language= JOptionPane.showInputDialog("Enter supported language for " + servers[numServers].getServerName() + " or type 'DONE' to finish.\nMinimum: " + WebServer.MIN_NUM_LANGUAGES+"\nLanguages: " + numLanguages);
				if(language.equalsIgnoreCase("DONE")){
					break;
				}
				while(!(((WebServer)servers[numServers]).setLanguage(language))){
               //error message and reprompt
					language= JOptionPane.showInputDialog("Re-enter supported language for " + servers[numServers].getServerName() + " or type 'DONE' to finish.\nMinimum: " + WebServer.MIN_NUM_LANGUAGES+"\nLanguages: " + numLanguages);
					if(language.equalsIgnoreCase("DONE")){
						break outerloop;
					}
				}
				numLanguages++;
				if(numLanguages==WebServer.MAX_NUM_LANGUAGES){
					break;
				}
			}
		}
		while(!language.equalsIgnoreCase("DONE") || !(numLanguages>WebServer.MIN_NUM_LANGUAGES && numLanguages<WebServer.MAX_NUM_LANGUAGES));
	}
   /*
      add a file server to the servers
      @param numServers the number of servers, servers all of the servers inputed
   */
	public static void addFileServer(int numServers, Server[] servers){
      //create a web server object
		servers[numServers]= new FileServer();
		//ask the user for the server name
		String serverName= JOptionPane.showInputDialog("Please enter file server name: ");

		while(!servers[numServers].setServerName(serverName)){
         //error message and repromt
			serverName= JOptionPane.showInputDialog("Please re-enter file server name: ");
		}
      //set the server name
		servers[numServers].setServerName(serverName);
		//ask the user for the operating system
		String operatingSystem= JOptionPane.showInputDialog("Please enter operating system type from the choices below for " + servers[numServers].getServerName()
				+ "\nWindows"
				+ "\nLinux"
				+ "\nOS X");
		//error message reprompt
		while(!servers[numServers].setOperatingSystem(operatingSystem)){
			operatingSystem= JOptionPane.showInputDialog("Please re-enter operating system type from the choices below for " + servers[numServers].getServerName()
					+ "\nWindows"
					+ "\nLinux"
					+ "\nOS X");
		}
      //set the operating system
		servers[numServers].setOperatingSystem(operatingSystem);
		//ask the user for the hard drive capacity
		String s_hardDriveCapacity= JOptionPane.showInputDialog("Hard Drive Capacity (TBs): \n" + servers[numServers].getServerName());
		boolean valid= false;
		double hardDriveCapacity= 0;
		do{
			try{
				hardDriveCapacity= Double.parseDouble(s_hardDriveCapacity);
				valid= servers[numServers].setHardDriveCapacity(hardDriveCapacity);
				//set the hard drive capacity
				if(!valid){
					s_hardDriveCapacity= JOptionPane.showInputDialog("Hard Drive Capacity (TBs): \n" + servers[numServers].getServerName());
					hardDriveCapacity= Double.parseDouble(s_hardDriveCapacity);
					valid= servers[numServers].setHardDriveCapacity(hardDriveCapacity);
				}
			}
			catch(NumberFormatException e){
            //error message
				s_hardDriveCapacity= JOptionPane.showInputDialog("Error, numbers only. \nHard Drive Capacity (TBs): \n " + servers[numServers].getServerName());
			}
		}while(!valid);
      //set the hard drive capacity  
		servers[numServers].setHardDriveCapacity(hardDriveCapacity);
		//ask the user for the number of users
		String s_numUsers= JOptionPane.showInputDialog("Number of users: " + servers[numServers].getServerName()+": \nMinimum: 0\nMaximum: " + FileServer.MAX_NUM_USERS);
		boolean v_numUsers= false;
		int numUsers= 0;
		do{
			try{
				numUsers= Integer.parseInt(s_numUsers);
				v_numUsers= (((FileServer) servers[numServers]).setNumUsers(numUsers));
				
				if(!v_numUsers){
					s_numUsers= JOptionPane.showInputDialog("Number of users: " + servers[numServers].getServerName()+": \nMinimum: 0\nMaximum: " + FileServer.MAX_NUM_USERS);
				}
			}
			catch(NumberFormatException e){
            //error message and reprompt
				s_numUsers= JOptionPane.showInputDialog("Error, numbers only. \nNumber of users: " + servers[numServers].getServerName() +": \nMinimum: 0\nMaximum: " + FileServer.MAX_NUM_USERS);
			}
		}
		while(!v_numUsers);
	}
}