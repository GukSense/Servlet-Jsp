package practice.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02Generics {

	public static void main(String[] args) {
		/*
		문제 1.
		상자에 연필과 티비를 담는 프로그램을 코딩하세요.
		상자에는 연필, 티비 외에 어떠한 타입도 받을 수 있도록 타입 파라미터를 사용하세요. 
		*/
		
		Pencil p = new Pencil("모나미", 2000);
		Pencil p2 = new Pencil("하이테크", 3000);
		Pencil p3 = new Pencil("국세이", 4000);
		
		Box<Pencil> box1 = new Box<>();
		box1.add(p);
		box1.add(p2);
		box1.add(p3);
		
		box1.printAllItems();
		System.out.println();
		
		Tv[] tvArr = {
				new Tv("삼성", 2300),
				new Tv("현대", 2030),
				new Tv("엘지", 4080),
		};
		Box<Tv> box2 = new Box<>(tvArr);
		box2.printAllItems();
		System.out.println();
	}

}

class Box<T> {	// <T> 타입 파라미터
	private List<T> items;
	
	public Box() {
		items = new ArrayList<>();
	}
	public Box(T[] arr) {
		items = new ArrayList<T>(Arrays.asList(arr));
	}
	public void add(T item) {
		items.add(item);
	}
	public T get(int index){
		return items.get(index);
	}
	public void printAllItems() {
		for (T item : items) {		// 바이트 코드 변환 시 보일러 플레이트 최소화
			System.out.println(item);
		}
	}
}

class Pencil {
	private String title;
	private int price;
	
	public Pencil(String title, int price) {
		this.price = price;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Pencil-> [title => " + title + ", price => " + price + "]";
	}
	
}
class Tv {
	private String title;
	private int price;

	public Tv(String title, int price) {
		this.price = price;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Tv-> [title => " + title + ", price => " + price + "]";
	}
}
