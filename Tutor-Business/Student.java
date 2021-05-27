public class Student {

	private static int numStudents= 0;
	
	public final static int MAX_STUDENTS= 8;
	public final static double HOURLY_COST= 20;
	public final static double BASE_COST= 5;
	public final static int MAX_SUBJECTS= 6;
	public final static int MIN_TUTOR_HOURS= 1;
	public final static int MAX_TUTOR_HOURS= 5;
	
	
	private String studentName;
	private String schoolName;
	private String phoneNumber;
	private String[] subjects = new String[MAX_SUBJECTS];
	private int numSubjects= 0;
	private double numHoursTutored;
	
	public Student(){
		numStudents++;
	}
	
	public Student(String studentName, String schoolName, String phoneNumber){
		this.setStudentName(studentName);
		this.setSchoolName(schoolName);
		this.setPhoneNumber(phoneNumber);
	}
	
	public static int getNumStudents(){
		return Student.numStudents;
	}
	
	public static void setNumStudents(int numStudents){
		Student.numStudents= numStudents;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public boolean setStudentName(String studentName) {
		if(studentName.equals("")){
			return false;
		}
		else{
			this.studentName = studentName;
			return true;
		}
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public boolean setSchoolName(String schoolName) {
		if(!schoolName.equals("")){
			this.schoolName = schoolName;
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public boolean setPhoneNumber(String phoneNumber) {
		//phone number format (123) 456-7890
		if(phoneNumber.length()!=14){return false;}
		if(phoneNumber.charAt(0)=='('
				&& Character.isDigit(phoneNumber.charAt(1))
				&& Character.isDigit(phoneNumber.charAt(2))
				&& Character.isDigit(phoneNumber.charAt(3))
				&& phoneNumber.charAt(4)==')'
				&& phoneNumber.charAt(5)==' '
				&& Character.isDigit(phoneNumber.charAt(6))
				&& Character.isDigit(phoneNumber.charAt(7))
				&& Character.isDigit(phoneNumber.charAt(8))
				&& phoneNumber.charAt(9)=='-'
				&& Character.isDigit(phoneNumber.charAt(10))
				&& Character.isDigit(phoneNumber.charAt(11))
				&& Character.isDigit(phoneNumber.charAt(12))
				&& Character.isDigit(phoneNumber.charAt(13))
				){
			this.phoneNumber = phoneNumber;
			return true;
		}
		else{
			return false;
		}
	}
	
	public double getNumHoursTutored(){
		return numHoursTutored;
	}
	
	public boolean setNumHoursTutored(double numHoursTutored){
		if(numHoursTutored > MIN_TUTOR_HOURS && numHoursTutored < MAX_TUTOR_HOURS){
			this.numHoursTutored= numHoursTutored;
			return true;
		}
		else{
			return false;
		}
	}
	
	public double calculateBill(){
		double bill= BASE_COST * numSubjects;
		bill+= getNumHoursTutored() * HOURLY_COST;
		return bill;
	}

	//There is an error in here for validation. Otherwise it’s fine
	public boolean addSubject(String subject){
		if(this.numSubjects<MAX_SUBJECTS){
			
			//checks for numbers in the subject given
			for(int i= 0; i<subject.length(); i++){
				if(Character.isDigit(i)){
					return false;
				}
			}
			
			//checks for upper case letters after the first letter
			for(int i= 1; i<subject.length(); i++){
				if(Character.isUpperCase(i)){
					return false;
				}
			}
			//checks for lower case letter for the first letter
			if(Character.isLowerCase(subject.charAt(0))){
				return false;
			}
			
			subjects[numSubjects]= subject;
			numSubjects++;
			return true;
		}
		return false;
	}
	
	public int getNumSubject(){
		return numSubjects;
	}
	public String[] getSubjects(){
		return subjects;
	}
}