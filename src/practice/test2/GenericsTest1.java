package practice.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GenericsTest1 {

	public static void main(String[] args) {
		/*
		문제 1.
		상자에 연필과 티비를 담는 프로그램을 코딩하세요.
		상자에는 연필, 티비 외에 어떠한 타입도 받을 수 있도록 타입 파라미터를 사용하세요. 
		*/
		
		Pencil[] arrPencil = {
				new Pencil("Monami", 2800),
				new Pencil("HighTech", 4000)
				
		};
		
		Tv[] arrTv = {
				new Tv("LG", 650000),
				new Tv("Samsung", 550000)
		};
		
		Box2<Pencil> box1 = new Box2<>(arrPencil); 
		Box2<Tv> box2 = new Box2<>(arrTv);
		
		box1.printItemsUseIterator();
		box1.printItemsUseForEach();
		System.out.println();
		box2.printItemsUseIterator();
		box2.printItemsUseForEach();
		
		
		
	}

}

class Pencil {
	private String title;
	private int price;

	public Pencil(String title, int price) {
		this.price = price;
		this.title = title;
	}
	
	public String toString() {
		return "Pencil [title=" + title + ", price=" + price + "]";
	}
}

class Tv {
	private String company;
	private int modelNum;

	public Tv(String company, int modelNum) {
		this.modelNum = modelNum;
		this.company = company;
	}
	public String toString() {
		return "Tv [company=" + company + ", modelNum=" + modelNum + "]";
	}
}

class Box2<T> {
	private List<T> items;
	
	public Box2(T[] arr) {
		items = new ArrayList<T>(Arrays.asList(arr));
	}
	
	public void printItemsUseIterator() {
		System.out.println("<Iterator>");
		for(Iterator<T> it = items.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}
	
	public void printItemsUseForEach() {
		System.out.println("<ForEach>");
		for(T item : items) {
			System.out.println(item);
		}
	}
	
	public void printItems() {
		
	}
}