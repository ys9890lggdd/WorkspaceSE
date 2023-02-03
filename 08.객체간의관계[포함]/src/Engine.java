
public class Engine {
	private String type;	//엔진타입
	private int cc;		//엔진 배기량
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	public Engine(String type, int cc) {
		this.type = type;
		this.cc = cc;
	}
	public void print() {
		System.out.println(this.type+"\t"+this.cc);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
}











