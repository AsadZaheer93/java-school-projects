/*
   Name: Asad Zaheer
   Date: 11/08/2015
   Course/Section: IT 206-206
   Assignment: Assignment 6
   
   Description:
   This program will help a tutor organize their students to see if they can 
   tutor or not and see how much the costs of tutoring is. First the
   program will the user if they want to add a student, print a summary of the 
   report or quit out of the program. If the user want to add a student the program 
   will then ask the student's name, school's name, and phone number. For each of 
   these values the program will check to see if these values are valid. For student 
   name it will check if there are no symbols and digits in it and this logic is the 
   same for thenschool's name also. For the phone number it will check to see if it 
   is in the format of (XXX) XXX-XXXX. Once the program gets these values it will 
   ask what subjects the students would like to get tutored in with a maximum of 6. 
   The program will also check for the same validations student name and school 
   but this time will include digits. Everytime a subject is entered the program 
   will ask if the user would like to input another subject yes or no. If no the 
   program will go back to the menu screen else if they pick yes it would ask you the 
   next subject again. Behind all of this work the program is calcualting the total 
   cost for each student. This program can only take a maximum of 8 students. If the
   user choses to print a summary it will show each student's name, school name, phone 
   number, all subjects, and total fees and if you have no students then you will get 
   an error message saying that there are no records in the data.
*/
import javax.swing.JOptionPane;

public class TutorBusiness {
   public static void main(String[] args) {
      int MAX_STUDENTS = 8;
      Student[] collection = new Student[MAX_STUDENTS];
      int menuChoice = getMenuOption();
      //ask the user what they want to do
      while(menuChoice != 3) {
         switch(menuChoice) {
            case 1:
               addStudent(collection);
               break;
            case 2:
               print(collection);
               break;
            default:
               // Program should never reach this condition if logic is correct
               JOptionPane.showMessageDialog(null, "Unknown Error");
               break;
         }
         menuChoice = getMenuOption();
      }
   }
   /**
      ask the user what they want to do
      @return menuChoice an int value to see what they have chosen
   */
   public static int getMenuOption(){
      int menuChoice;
      //ask the user what they want to do
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "Enter your selection:"
               + "\n(1) Add Student"
               + "\n(2) Print Itemized Weekly Bill"
               + "\n(3) Quit Application"
            ));
         }
         catch(NumberFormatException e) {
            menuChoice = 0;
         }
         if(menuChoice < 1 || menuChoice > 3) {
            //error message
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while(menuChoice < 1 || menuChoice > 3);
      return menuChoice;
   }
   /**
      Add a student to the collection
      @param collection all of the students in the colleciton
   */
   public static void addStudent(Student[] collection) {
      //get the number of students
      int position = Student.getNumOfStudents();
      //check to see if there is enought room in the collection
      if(position < collection.length) {
         //add a student
         collection[position] = new Student();
         //initialize variables
         String studentName = "";
         String schoolName = "";
         String phoneNum = "";
         //get the name of the student
         do {
            collection[position].setStudentName(studentName = JOptionPane.showInputDialog("What is the name of student " + (position + 1)));
            if(!collection[position].setStudentName(studentName)) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please enter a valid student name.");
            }
         }while(!collection[position].setStudentName(studentName));
         //get the name of school
         do {
            collection[position].setSchoolName(schoolName = JOptionPane.showInputDialog("What is the name of the school for student " + (position + 1)));
            if(!collection[position].setSchoolName(schoolName)) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please enter a valid school name.");
            }
         }while(!collection[position].setSchoolName(schoolName));
         //get the phone number
         do {
            collection[position].setPhoneNum(phoneNum = JOptionPane.showInputDialog("What is the phone number for student " + (position + 1)));
            if(!collection[position].setPhoneNum(phoneNum)) {
               //error message
               JOptionPane.showMessageDialog(null, "ERROR! Please enter a valid phone number.");
            }
         }while(!collection[position].setPhoneNum(phoneNum));
         //initialize variables
         String moreSubjects = "";
         int x = 0;
         final int MAX_SUBJECTS = 6;
         String[] subjects =  new String[MAX_SUBJECTS];
         //get all of the subjects
         do{
            do{
               //get the name of the subject
               subjects[x] = JOptionPane.showInputDialog("What is the name of subject " + (x + 1));
               do{
                  //ask if they would like to add subject
                  moreSubjects = JOptionPane.showInputDialog("Would you like to enter another subject? YES or NO");
                  if(!moreSubjects.equalsIgnoreCase("YES") && !moreSubjects.equalsIgnoreCase("NO")) {
                     //error message
                     JOptionPane.showMessageDialog(null, "ERROR! Please enter yes or no.");  
                  }
                  x++;
               }while(!moreSubjects.equalsIgnoreCase("YES") && !moreSubjects.equalsIgnoreCase("NO"));
            }while(moreSubjects.equalsIgnoreCase("YES") && (x < MAX_SUBJECTS));
         }while(!collection[position].setSubjects(subjects));
         
         collection[position].calculateTotalFee();
      }
      else {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! There is no space left to add another student.");
      }
   }
   /**
      print out the current listing of students in the collection
      @param collection all of the students in the collection
   */
   public static void print(Student[] collection) {
      String output = "";
      if(Student.getNumOfStudents() > 0) {
         //output all of students and their values
         for(int x = 0; x < Student.getNumOfStudents(); x++) {
            output += collection[x].toString() + "\nTutoring Subjects: " + collection[x].getSubjects() + "\nTotal Fee: " + collection[x].getTotalFee();
         }
         JOptionPane.showMessageDialog(null, output);
      }
      else {
         //error message
         JOptionPane.showMessageDialog(null, "ERROR! There are no records of students.");
      }
   }
}