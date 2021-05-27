public class Student {
   //instance and staic variables of a Student object
   private String studentName;
   private String schoolName;
   private String phoneNum;
   private String[] subjects;
   private double numOfHours;
   private double totalFee;
   public static final int TOTAL_SUBJECTS = 6;
   public static final double MAX_NUM_OF_HOURS = 5;
   public static final double MIN_NUM_OF_HOURS = 1;
   public static final double BASE_FEE = 5.00;
   private static int numOfStudents = 0;
   /**
      default values if the user inputed in nothing
   */
   public Student() {
      //need a default constructor
      ++numOfStudents;
   }
   /**
      get the name of the student
      @return a student name
   */
   public String getStudentName() {
      return this.studentName;
   }
   /**
      get the name of the school
      @return a school name
   */
   public String getSchoolName() {
      return this.studentName;
   }
   /**
      get the phone number
      @return a phone number
   */
   public String getPhoneNum() {
      return this.phoneNum;
   }
   /**
      get the names of the subjects
      @return an array of subjects
   */
   public String[] getSubjects() {
      String[] tempArray = new String[this.subjects.length];
      for(int x = 0; x < this.subjects.length; x++) {
         tempArray[x] = this.subjects[x];
      }
      return tempArray;
   }
   /**
      get the number of hours
      @return the number of hours
   */
   public double getNumOfHours() {
      return this.numOfHours;
   }
   /**
      get the total fee
      @return the total fee
   */
   public double getTotalFee() {
      return this.totalFee;
   }
   /**
      get the total number of students
      @return the total number of students
   */
   public static int getNumOfStudents() {
      return numOfStudents;
   }
   /**
      check to see if the student name can be set
      @param studentName name of the student
      @return true or false if the student name can be set
   */
   public boolean setStudentName(String studentName) {
      boolean validateStudentName = true;
      //check to see if all of the characters have either a letter or space in the whole value
      for(int x = 0; x < studentName.length(); x++) {
         if(!Character.isLetter(studentName.charAt(x)) && !Character.isWhitespace(studentName.charAt(x))) {
            validateStudentName = false;
            break;
         }
      }
      if(validateStudentName) {
         this.studentName = studentName;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the school name can be set
      @param schoolName name of the school
      @return true or false if the school name can be set
   */
   public boolean setSchoolName(String schoolName) {
      boolean validateSchoolName = true;
      //check to see if all of the characters have either a letter or space in the whole value
      for(int x = 0; x < schoolName.length(); x++) {
         if(!Character.isLetter(schoolName.charAt(x)) && !Character.isWhitespace(schoolName.charAt(x))) {
            validateSchoolName = false;
            break;
         }
      }
      if(validateSchoolName) {
         this.schoolName = schoolName;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the phone number is in the right format
      @param phoneNum the phone number
      @return true or false if the phone number can be set
   */
   public boolean setPhoneNum(String phoneNum) {
      boolean validatePhoneNum = true;
      //replace certain characters
      phoneNum.replace("-","");
      phoneNum.replace(" ","");
      phoneNum.replace("(","");
      phoneNum.replace(")","");
      //check to see if all the characters are digits
      for(int x = 0; x < phoneNum.length(); x++) {
         if(!Character.isDigit(phoneNum.charAt(x))) {
            validatePhoneNum = false;
            break;
         }
      }
      if(validatePhoneNum) {
         //put back the space, (, ), and - characters back to the correct format
         this.phoneNum = "(" + phoneNum.substring(0,3) + ") " + phoneNum.substring(3,6) + "-" + phoneNum.substring(6,9);
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the array of subjects can be set
      @param subjects an array of subjects
      @return true or false if the subjects array can be set
   */
   public boolean setSubjects(String[] subjects) {
      boolean validateSubjects = true;
      for(int i = 0; i < subjects.length; i++) {
         for(int x = 0; x < subjects[i].length(); x++) {
            if(!Character.isLetterOrDigit(subjects[i].charAt(x)) && !Character.isWhitespace(subjects[i].charAt(x))) {
               validateSubjects = false;
               break;
            }
         }
      }
      if(validateSubjects) {
         this.subjects = subjects;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      check to see if the number of hours is between 1 and 5
      @param numOfHour the number of hours
      @return true or false if the numOfHours can be set
   */
   public boolean setNumOfHours(double numOfHours) {
      //check if the number of hours is between 1 and 5
      if(numOfHours >= MIN_NUM_OF_HOURS && numOfHours <= MAX_NUM_OF_HOURS) {
         this.numOfHours = numOfHours;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      calculate the total fee for a student
      @return the total fee for a student
   */
   public void calculateTotalFee() {
      this.totalFee = BASE_FEE + numOfHours * subjects.length;
   }
   /*
      get the student name, school name, and phone number of the student
      @return the student name, school name, and phone number of the student
   */
   public String toString() {
      return "Student Name: " + this.studentName + "\nSchool Name: " + this.schoolName
         + "\nPhone Number: " + this.phoneNum;
   }  
}