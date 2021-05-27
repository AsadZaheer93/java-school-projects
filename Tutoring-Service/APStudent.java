public class APStudent extends Student{
   //instance and staic variables of an AP Student object
   private String[] apSubjects;
   private static int numOfAPStudents = 0;
   public static final double PREMIUM_FEE = 1.1;
   /**
      default values if the user inputed in nothing
   */
   public APStudent() {
      //need a default constructor
      ++numOfAPStudents;
   }
   /**
      get the names of the ap subjects
      @return an array of ap subjects
   */
   public String[] getAPSubjects() {
      String[] tempArray = new String[this.apSubjects.length];
      for(int x = 0; x < this.apSubjects.length; x++) {
         tempArray[x] = this.apSubjects[x];
      }
      return tempArray;
   }
   /**
      check to see if there are only letters, spaces, and digits for each subject
      @param subjects an array of ap subjects
      @return true or false if the ap subjects can be set
   */
   public boolean setAPSubjects(String[] subjects) {
      boolean validateAPSubjects = true;
      for(int i = 0; i < apSubjects.length; i++) {
         for(int x = 0; x < apSubjects[i].length(); x++) {
            if(!Character.isLetterOrDigit(apSubjects[x].charAt(x)) && !Character.isWhitespace(apSubjects[x].charAt(x))) {
               validateAPSubjects = false;
               break;
            }
         }
      }
      if(validateAPSubjects) {
         this.apSubjects = apSubjects;
         return true;
      }
      else {
         return false;
      }
   }
   /**
      calculate the total fee for an ap student
      @return the total fee for an ap student
   */
   public double calcuateTotalFee() {
      double totalFee = 0;
      if(this.apSubjects.length >= 2) {
         return totalFee = super.getNumOfHours() * super.getSubjects().length * PREMIUM_FEE;
      }
      else {
         return totalFee = super.getNumOfHours() * super.getSubjects().length;
      }
   }
   /*
      get the student name, school name, and phone number of the student
      @return the student name, school name, and phone number of the student
   */
   public String toString() {
      return super.toString();
   }
}