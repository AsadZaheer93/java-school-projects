public class HonorStudent extends Student {
	
	public final static double PREMIUM_RATE= Student.HOURLY_COST*(1.10);
	private boolean[] isHonorSubject = new boolean[Student.MAX_SUBJECTS];
	
	public HonorStudent(){
		Student.setNumStudents(Student.getNumStudents()+1);
	}
	
	public HonorStudent(String name, String schoolName, String phoneNumber) {
		super(name, schoolName, phoneNumber);
		Student.setNumStudents(Student.getNumStudents()+1);
	}
	
	public void setHonors(boolean isHonors){
		isHonorSubject[super.getNumSubject()]= isHonors;
	}
	
	public double calculateBill(){
		double bill = Student.BASE_COST * super.getNumSubject();
		int numHonors= 0;
		for(int i= 0; i<super.getNumSubject(); i++){
			if(isHonorSubject[i]){
				numHonors++;
			}
		}
		if(numHonors>=2){
			bill+= PREMIUM_RATE * super.getNumHoursTutored();
		}
		else{
			bill+= Student.HOURLY_COST* super.getNumHoursTutored();
		}
		return bill;
	}
	
}
