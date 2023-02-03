public class AcademyStaff extends AcademyMember {
	private String depart;//부서
	public AcademyStaff() {
		super();
	}
	public AcademyStaff(int no,String name,String depart) {
		super(no, name);
		this.depart=depart;
	}
	/*
	 * 재정의
	 */
	@Override
	public void print() {
		super.print();
		//System.out.print(this.no+"\t"+this.name+"\t");
		System.out.println(this.depart);
	}
	
	
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	
	
}
