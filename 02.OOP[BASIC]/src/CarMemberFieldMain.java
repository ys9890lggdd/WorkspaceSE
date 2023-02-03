
public class CarMemberFieldMain {

	public static void main(String[] args) {
		/*
		 * 주차관리 프로그램시작
		 */
		/*
		1.차량번호 1234차량 12시입차
		 */
		Car car1;			//차객체의 주소값을 저장할 Car타입 참조(주소)변수 선언
		car1 = new Car();	//Car클래스를 사용해서 차객체를 힙메모리에 생성후 
							//차객체의 주소값이 car1참조(주소)변수대입
		
		car1.no="1234"; 	//차객체(car1)의 멤버필드no에 		"1234"값대입
		car1.inTime=12; 	//차객체(car1)의 멤버필드inTime에 	12 값대입
		/*
		2.car1차량 16시 출차
		*/
		/*
		 * 2-1.출차시간대입
		 */
		car1.outTime=16;	//차객체(car1)의 멤버필드 outTime에 16대입
		
		/*
		 * 2-2.주차요금계산
		 */
		car1.fee = (car1.outTime-car1.inTime)*1000;
		//차객체(car1)의 멤버필드 fee에 
		//차객체의 outTime,inTime멤버필드를 사용해서 주차요금계산후 대입
		
		/*
		 *2-3.주차요금영수증출력
		*/
		System.out.println("-----------------------------------");
		System.out.printf("%s %s %s %s\n","차량번호","입차시간","출차시간","주차요금");
		System.out.println("-----------------------------------");
		System.out.printf("%7s %7d %7d %8d",car1.no,car1.inTime,car1.outTime,car1.fee);
		
		
		

	}

}
