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
		���� 1.
		�� ���� ���� �����忡 �����ϴ� �ڵ带 �ۼ��ϼ���.
		������ �ν��Ͻ��� ���Ͽ� �� �� �ٽ� �о� �� �������� ���¸� ����ϼ���.
		*/
		try (
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/com/java/practice/test5/out-ojbectoutputstream.txt"
						))) 
		){
			Car c1 = new Car("18�� 1234", "14:25", "�ҳ�Ÿ");
			Car c2 = new Car("8�� 5678", "15:55", "��Ÿ��");
			
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
			System.out.println("<���������>");
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
