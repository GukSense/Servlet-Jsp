package com.java.practice.test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ex03ObjectStreamsTest {

	public static void main(String[] args) {
		/*
		문제 1.
		두 대의 차를 주차장에 주차하는 코드를 작성하세요.
		주차장 인스턴스를 파일에 쓴 뒤 다시 읽어 와 주차장의 상태를 출력하세요.
		*/
		try (
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/java/practice/test5/out-ojbectoutputstream.txt"
						))) 
		){
			Car c1 = new Car("18허 1234", "14:25", "소나타");
			Car c2 = new Car("8가 5678", "15:55", "산타페");
			
			ParkingLot parkingLot = new ParkingLot();
			parkingLot.add(c1);
			parkingLot.add(c2);
			
			out.writeObject(parkingLot);
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
		try (
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(
						"src/com/java/practice/test5/out-ojbectoutputstream.txt")));
		){	
			ParkingLot parkingLot = (ParkingLot)in.readObject();
			System.out.println("<주차장상태>");
			for (Car c : parkingLot.getCars()) {
				System.out.println(c);
				
			}
				
			
		} catch (IOException  e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}

class Car implements Serializable {
	private final static long serialVersionUID  = 1L;
	private String plateNumebr;
	private String accessTime;
	private String model;
	
	public Car(String plateNumebr, String accessTime, String model) {
		this.plateNumebr = plateNumebr;
		this.accessTime = accessTime;
		this.model = model;
	}
	public String getPlateNumebr() {
		return plateNumebr;
	}
	public void setPlateNumebr(String plateNumebr) {
		this.plateNumebr = plateNumebr;
	}
	public String getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "[plateNumebr = " + plateNumebr + ", accessTime = " + accessTime + ", model = " + model + "]";
	}
	
	
	
}

class ParkingLot implements Serializable {
	private final static long serialVersionUID = 1L;
	private List<Car> cars;
	
	public ParkingLot() {
		cars = new ArrayList<>();
	}
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public void add(Car c) {
		cars.add(c);
	}
	
}
