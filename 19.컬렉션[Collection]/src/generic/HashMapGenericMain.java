package generic;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapGenericMain {

	public static void main(String[] args) {
		HashMap<String, Car> carMap=
				new HashMap<String, Car>();
		System.out.println("-------1.put(key,value)----");
		carMap.put("1111",new Car("1111", 12));
		carMap.put("2222",new Car("2222", 13));
		carMap.put("3333",new Car("3333", 14));
		carMap.put("4444",new Car("4444", 15));
		carMap.put("5555",new Car("5555", 16));
		System.out.println("# map size:"+carMap.size());
		System.out.println(carMap);
		carMap.put("3333", new Car("삼삼삼", 19));
		System.out.println("---------2.get(key)-------");
		Car getCar = carMap.get("3333");
		getCar.print();
		carMap.get("5555").print();
		if(carMap.containsKey("1111")) {
			getCar=carMap.get("1111");
			getCar.print();
		}else {
			System.out.println("1111키존재안함");
		}
		System.out.println("---------3.remove(key)-----------");
		Car removeCar = carMap.remove("3333");
		removeCar.print();
		System.out.println("# map size:"+carMap.size());
		System.out.println(carMap);
		
		System.out.println("%%%%%%%%%%% 업무실행 %%%%%%%%%%%");
		System.out.println("1.--------전체차량출력-------");
		Set<Entry<String,Car>>  entrySet = carMap.entrySet();
		for(Entry<String,Car> entry:entrySet){
			String key=entry.getKey();
			Car car=entry.getValue();
			System.out.println(key);
			car.print();
		}
		System.out.println("keySet==>"+carMap.keySet());
		System.out.println("2.입차");
		
		Car newCar=new Car("2356",21);
		if(!carMap.containsKey("2356")) {
			carMap.put(newCar.getNo(), newCar);
		}
		System.out.println("3.차량번호 2356번 차량한대찾기");
		Car findCar=carMap.get("2356");
		findCar.print();
		
		System.out.println("4.입차시간 15시이후의 차량 여러대찾가");
		for(Entry<String,Car> entry:carMap.entrySet()) {
			if(entry.getValue().getInTime()>=15) {
				entry.getValue().print();
			}
		}
		System.out.println("5.2356번차량 24시출차");
		
		Car outCar=carMap.get("2356");
		outCar.setOutTime(24);
		outCar.calculateFee();
		Car.headerPrint();
		outCar.print();
		carMap.remove("2356");
		
		
		System.out.println("6.--------전체차량출력-------");
	    Car.headerPrint();
		entrySet = carMap.entrySet();
		for(Entry<String,Car> entry:entrySet){
			String key=entry.getKey();
			Car car=entry.getValue();
			System.out.println(key);
			car.print();
		}
		
		
		
	}

}
