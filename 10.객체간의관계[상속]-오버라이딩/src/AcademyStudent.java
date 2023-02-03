public class AcademyStudent extends AcademyMember {
	public String ban;//반
	
	public AcademyStudent() {
	}
	public AcademyStudent(int no,String name,String ban) {
		this.no=no;
		this.name=name;
		this.ban=ban;
	}
	/*
	public void print() {
		System.out.print(this.no+"\t"+this.name);
	}
	 */
	@Override
	public void print() {
		//System.out.println(this.ban+"\t"+this.name+"\t"+this.ban);
		super.print();
		System.out.println(this.ban);
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
	
}
