/*
 * AcademyMember들이가져야할 공통멤버를 가짐
 */
public class AcademyMember {
    public int no;		//번호
    public String name;	//이름
    
    public AcademyMember() {
	}
	public AcademyMember(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public void print() {
		System.out.print(this.no+"\t"+this.name+"\t");
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    

}
