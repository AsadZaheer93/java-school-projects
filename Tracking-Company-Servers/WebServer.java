import javax.swing.JOptionPane;
public class WebServer extends Server {
	//instance and staic variables of a server object
	public final static int MIN_NUM_LANGUAGES= 2;
	public final static int MAX_NUM_LANGUAGES= 5;
	public final static int USAGE_CONSTANT= 20;
	private String[] languages= new String[MAX_NUM_LANGUAGES];
	private int numLanguages= 0;
	/**
      default values if the user inputed in nothing
   */
	public WebServer() {
		Server.setNumServers(getNumServers()+1);
	}
   /**
      default values if the server name, operating system and hard drive capacity is already valided
   */
	public WebServer(String serverName, String operatingSystem, double hardDriveCapacity) {
		super(serverName, operatingSystem, hardDriveCapacity);
		setUsageLevel(calculateUsageLevel());
		Server.setNumServers(getNumServers()+1);
	}
   /**
      get the language
      @return languages return the language
   */
	public String[] getLanguages(){return languages;}
	/*
      check to see if the language can be set
      @param language name of the language
      @return true or false if the language can be set
   */
	public boolean setLanguage(String language){
		if(!language.equals("")){
			languages[numLanguages]= language;
			numLanguages++;
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "Error. Language can not be blank.");
			return false;
		}
	}
	/*
      calculate the usage level
      @return the calculated usage level
   */
	public double calculateUsageLevel() {
		return USAGE_CONSTANT*numLanguages;
	}
   /*
      get the server name, operating system, hard drive capacity, usage level, programming languages, and number of languages
      @return the server name, operating system, hard drive capacity, usage level, programming languages, and number of languages
   */
	public String toString(){
		String programmingLangugages= "";
		for(int i= 0; i<numLanguages; i++){
			programmingLangugages+= "   "+ languages[i] + "\n";
		}
		return "Server Type: Web Server"
				+ "\nServer Name: " + super.getServerName()
				+ "\nOperating System: " + super.getOperatingSystem()
				+ "\nHard Drive Space: " + super.getHardDriveCapacity()
				+ "\nUsage Level: " + super.getUsageLevel()
				+ "\nLanguages: \n" + programmingLangugages
				+ "\nNumber of Languages: " + numLanguages + "\n";

	}
}
