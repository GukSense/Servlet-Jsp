package practice.test4;

import java.util.HashMap;
import java.util.Map;




public class LamdaTest {

	public static void main(String[] args) {
		/*
		문제 2.
		차량 출입 시간이 5시에서 9시 사이인 차량만 출력하는 프로그램을 코딩하세요.
		위 회원 검색 프로그램과 같이 함수형 인터페이스를 작성하고 람다식을 사용해야 합니다.  
		*/
		
		Map<String, Driver> AllDrivers = AccessTimeService.getDriversMap();
		Map<String, Driver> condDrivers = null;
		
		condDrivers = AccessTimeService.searchDriver(AllDrivers, (t, t2) ->  (t.getAccessTime() >= 17)&(t2.getAccessTime() <= 21) );
		
		AccessTimeService.printDrivers(condDrivers);
	}

}

@FunctionalInterface
interface Criteria {
	public abstract boolean time(Driver d1, Driver d2);
}

class Driver {
	private String carModelName;
	private String carPlateNumber;
	private int accessTime;
	
	public Driver(String carModelName, String carPlateNumber, int accessTime) {
		this.carModelName = carModelName;
		this.carPlateNumber = carPlateNumber;
		this.accessTime = accessTime;
	}
	public String getCarModelName() {
		return carModelName;
	}
	public String getCarPlateNumber() {
		return carPlateNumber;
	}
	public int getAccessTime() {
		return accessTime;
	}
	@Override
	public String toString() {
		return " Driver [차 모델명 = " + carModelName + ", 차 번호판 = " + carPlateNumber + " 출입시간: " + accessTime + "]";
	}
	
	
}

class AccessTimeService {
	private static Map<String, Driver> driversMap;
	
	static {
		driversMap = new HashMap<>();
		AccessTimeService.addDriver("admin", new Driver("admin", "52주 3108", 10));
		AccessTimeService.addDriver("redraib05", new Driver("test1", "10가 1234", 11));
		AccessTimeService.addDriver("restances", new Driver("test2", "38육 4104", 9));
		AccessTimeService.addDriver("blacksheld95", new Driver("test3", "67나 8016", 17));
		AccessTimeService.addDriver("ajc14859", new Driver("test4", "60구 1733", 20));
	}
	
	public static void addDriver(String id, Driver d) {
		driversMap.put(id, d);
	}

	public static Map<String, Driver> getDriversMap() {
		return driversMap;
	}

	public static Map<String, Driver> searchDriver(Map<String, Driver> driver, Criteria c) {
		Map<String, Driver> condDriver = new HashMap<>();
			for(Map.Entry<String, Driver> entry : driver.entrySet()) {
				if(c.time(entry.getValue(), entry.getValue() ))
					condDriver.put(entry.getKey(), entry.getValue());
			}
		return condDriver;
	}
	public static void printDrivers(Map<String, Driver> driver) {
		for(Map.Entry<String, Driver> entry : driver.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
}