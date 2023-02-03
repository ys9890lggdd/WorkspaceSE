
public class CarEncapsulationMain {

	public static void main(String[] args) {
		
		Car car1=new Car();
		car1.setIpChaData("1234", 12);
		
		car1.setOutTime(16);
		car1.calculateFee();
		car1.print();
		
		/*
		 * car1객체의 주차요금 get
		 */
		//System.out.println(car1.fee);
		int car1Fee=car1.getFee();
		System.out.println("car1의 주차요금:"+car1Fee);
		/*
		 * car1객체의 주차요금 대입 set
		 */
		car1.setFee(0);
		car1.print();

	}

}
