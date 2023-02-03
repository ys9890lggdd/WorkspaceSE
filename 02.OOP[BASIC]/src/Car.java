/*
 * 1. 주차장에서 차객체를 생성할클래스(틀)
 * 2. Car객체의 주소를 저장할수있는 타입 
 */
public class Car {
	/*
	 * 클래스의 구성요소
	 * 	1.멤버필드(변수)[속성]: 차객체의 속성데이타를 저장할변수
	 *  2.멤버메쏘드[기능]    : 차객체가 외부에제공하는기능
	 */
	/*
	 * 멤버필드[속성]
	 */
	String no;	//차량번호
	int inTime;	//입차시간
	int outTime;//출차시간
	int fee;	//주차요금
	/*
	 * 멤버메쏘드[기능]
	 */
	/*
	 * 입차시데이타(번호,시간)대입
	 */
	void setIpChaData(String no,int inTime) {
		this.no=no;
		this.inTime=inTime;
	}
	
	/*
	 * 출차시간 멤버필드outTime에 출차시간데이타 대입(set)
	 */
	void setOutTime(int outTime) {
		this.outTime=outTime;
	}
	/*
	 *  주차요금계산
	 */
	void calculateFee() {
		this.fee=(this.outTime-this.inTime)*1000;
	}
	/*
	 * 차량정보출력
	 */
	void print() {
		System.out.println("-----------------------------------");
		System.out.printf("%s %s %s %s\n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-----------------------------------");
		System.out.printf("%7s %7d %7d %8d",this.no,this.inTime,this.outTime,this.fee);
	}
	
	
}









