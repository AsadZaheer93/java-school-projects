import javax.swing.JOptionPane;

public class TutorImplementation {

	public static String getChoice() {
		String menu = "Choose a menu option.\n\n" + "1- Add Student\n"
				+ "2- Print Itemized Weekly Bill\n" + "3- Quit";
		String errorMenu = "Error! Select a valid menu option.\n\n"
				+ "Choose a menu option.\n" + "1- Add Student\n"
				+ "2- Print Itemized Weekly Bill\n" + "3- Quit";
		String choice = JOptionPane.showInputDialog(menu);

		while (!choice.equals("1") && !choice.equals("2")
				&& !choice.equals("3")) {
			choice = JOptionPane.showInputDialog(errorMenu);
		}
		return choice;
	}

	public static boolean getHonors() {
		String isHonors = JOptionPane
				.showInputDialog("Is the student honors?\n"
						+ "Type 'Y' or 'N'. ");
		while (!isHonors.equalsIgnoreCase("Y") && !isHonors.equalsIgnoreCase("N")) {
			isHonors = JOptionPane
					.showInputDialog("Rrror! type Y or N only!\n\n"
							+ "Is the student honors?\n" + "Type 'Y' or 'N'. ");
		}

		if (isHonors.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean addSubjects(Student s1) {
		String addSubject = JOptionPane
				.showInputDialog("Would you like to add subjects for "
						+ s1.getStudentName() + "? \n\nType 'Y' or 'N'. ");
		while (addSubject.equalsIgnoreCase("Y")
				&& addSubject.equalsIgnoreCase("N")) {
			addSubject = JOptionPane
					.showInputDialog("Error. Type 'Y' or 'N' only!"
							+ "\n\nWould you like to add subjects for "
							+ s1.getStudentName() + "?");
		}
		if (addSubject.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}

	}

	public static void addStudent(Student[] studentRoster, int studentNumber) {
		// determines whether to create an honor/regular student
		if (getHonors()) {
			studentRoster[studentNumber] = new HonorStudent();
		} else {
			studentRoster[studentNumber] = new Student();
		}

		// captures/validates student name
		String studentName= JOptionPane.showInputDialog("Enter student name for student "+ (studentNumber+1));
		studentRoster[studentNumber].setStudentName(studentName);
		while (!studentRoster[studentNumber].setStudentName(studentName)) {
			studentName= JOptionPane.showInputDialog("Error! Student name can not be blank. \n\nEnter student name for student "+ (studentNumber+1));
			studentRoster[studentNumber].setStudentName(studentName);
		}
		
		// captures/validates school name
		String schoolName = JOptionPane.showInputDialog("Enter student's school name for student "+ studentRoster[studentNumber].getStudentName());
		studentRoster[studentNumber].setSchoolName(schoolName);
		while (!studentRoster[studentNumber].setSchoolName(schoolName)) {
			schoolName = JOptionPane.showInputDialog("Error! School name can not be blank. \n\nEnter student's school name for student "+ (studentNumber+1));
			studentRoster[studentNumber].setSchoolName(schoolName);

		}

		// captures/validates student's phone number
		String phoneNumber = JOptionPane.showInputDialog("Enter phone number for student  "+ studentRoster[studentNumber].getStudentName()
						+ ". Format (xxx) xxx-xxxx. \n\n"
						+ "ex. (703) 555-5555");
		studentRoster[studentNumber].setPhoneNumber(phoneNumber);
		while (!studentRoster[studentNumber].setPhoneNumber(phoneNumber)) {
			phoneNumber = JOptionPane.showInputDialog("Error! Follow format exactly including the parenthesis.\n"
							+ "Enter phone number for student  "
							+ studentRoster[studentNumber].getStudentName()
							+ ". Format (xxx) xxx-xxxx. \n\n"
							+ "ex. (703) 555-5555"
							+ "\nHint: Notice the space between ')' and the next following number.");
			studentRoster[studentNumber].setPhoneNumber(phoneNumber);
		}

		boolean addSubjects = addSubjects(studentRoster[studentNumber]);
		
		while (addSubjects&& studentRoster[studentNumber].getNumSubject() < Student.MAX_SUBJECTS) {
			if (studentRoster[studentNumber] instanceof HonorStudent) {
				String isHonor = JOptionPane.showInputDialog("Will this subject be an honor course? Type 'Y' or 'N'. ");
				while (!isHonor.equalsIgnoreCase("Y")&& !isHonor.equalsIgnoreCase("N")) {
					isHonor = JOptionPane.showInputDialog("Error. Type 'Y' or 'N' only!.\n\n"+ "Will this subject be an honor course?");
				}
				if (isHonor.equalsIgnoreCase("Y")) {
					((HonorStudent) studentRoster[studentNumber]).setHonors(true);
				} else {
					((HonorStudent) studentRoster[studentNumber]).setHonors(false);
				}
			}
			
			String subjectList= "";
			for(int i= 0; i<studentRoster[studentNumber].getSubjects().length; i++){
				String[] subjects= studentRoster[studentNumber].getSubjects();
				subjectList+= subjects[i] + ", ";
			}
			String subject = JOptionPane.showInputDialog("Enter subject for "
					+ studentRoster[studentNumber].getStudentName()
					+ "\n\n" + "Format" + "\n1- No numbers"
					+ "\n2- First character must be upper case"
					+ "\n3- remaining characters must be lower case"
					+ "\nNumber of subjects: " + studentRoster[studentNumber].getNumSubject()
					+ "\n\nSubject List: " + subjectList);
			
			while (!studentRoster[studentNumber].addSubject(subject)) {
				subject = JOptionPane.showInputDialog("Error. Please follow the format below.\n\n"
						+ "Enter subject for "
						+ studentRoster[studentNumber].getStudentName() + "\n\n" + "Format"
						+ "\n1- No numbers"
						+ "\n2- First character must be upper case"
						+ "\n3- remaining characters must be lower case"
						+ "\nNumber of subjects: " + studentRoster[studentNumber].getNumSubject()
						+ "\n\nSubject List: " + subjectList);
			}
			
			addSubjects = addSubjects(studentRoster[studentNumber]);
		}
		String s_numHoursTutored= JOptionPane.showInputDialog("How many hours will " + studentRoster[studentNumber].getStudentName() + " like to be tutored?"
				+ "\nMaximum hours: " + Student.MAX_TUTOR_HOURS
				+ "\nMinimum hours: " + Student.MIN_TUTOR_HOURS);
		boolean valid= false;
		do{
			try{
				double hours= Double.parseDouble(s_numHoursTutored);
				valid= studentRoster[studentNumber].setNumHoursTutored(hours);
			}
			catch(NumberFormatException e){
				valid= false;
				s_numHoursTutored= JOptionPane.showInputDialog("Error, numbers only!"
						+ "\n\nHow many hours will " + studentRoster[studentNumber].getStudentName() + " like to be tutored?"
						+ "\nMaximum hours: " + Student.MAX_TUTOR_HOURS
						+ "\nMinimum hours: " + Student.MIN_TUTOR_HOURS);
			}
		}
		while(!valid);
	}

	public static void main(String[] args) {
		String choice = getChoice();
		Student[] studentRoster = new Student[Student.MAX_STUDENTS];
		int studentNumber= 0;
		do {
			if (choice.equals("1")) {
				if (Student.getNumStudents() < Student.MAX_STUDENTS) {
					addStudent(studentRoster, studentNumber);
					studentNumber++;
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Error. The maximum student number of students has been reached.");
				}
			} else if (choice.equals("2")) {
			} else if (choice.equals("3")) {
				JOptionPane.showMessageDialog(null, "The program is finished.");
			}
			choice = getChoice();
		} while (!choice.equals("3"));

	}

}