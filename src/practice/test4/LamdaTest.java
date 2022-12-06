package practice.test4;

import java.util.HashMap;
import java.util.Map;




public class LamdaTest {

	public static void main(String[] args) {
		/*
		���� 2.
		���� ���� �ð��� 5�ÿ��� 9�� ������ ������ ����ϴ� ���α׷��� �ڵ��ϼ���.
		�� ȸ�� �˻� ���α׷��� ���� �Լ��� �������̽��� �ۼ��ϰ� ���ٽ��� ����ؾ� �մϴ�.  
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
		return " Driver [�� �𵨸� = " + carModelName + ", �� ��ȣ�� = " + carPlateNumber + " ���Խð�: " + accessTime + "]";
	}
	
	
}

class AccessTimeService {
	private static Map<String, Driver> driversMap;
	
	static {
		driversMap = new HashMap<>();
		AccessTimeService.addDriver("admin", new Driver("admin", "52�� 3108", 10));
		AccessTimeService.addDriver("redraib05", new Driver("test1", "10�� 1234", 11));
		AccessTimeService.addDriver("restances", new Driver("test2", "38�� 4104", 9));
		AccessTimeService.addDriver("blacksheld95", new Driver("test3", "67�� 8016", 17));
		AccessTimeService.addDriver("ajc14859", new Driver("test4", "60�� 1733", 20));
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