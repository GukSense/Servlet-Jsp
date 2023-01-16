package practice.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02Generics {

	public static void main(String[] args) {
		/*
		���� 1.
		���ڿ� ���ʰ� Ƽ�� ��� ���α׷��� �ڵ��ϼ���.
		���ڿ��� ����, Ƽ�� �ܿ� ��� Ÿ�Ե� ���� �� �ֵ��� Ÿ�� �Ķ���͸� ����ϼ���. 
		*/
		
		Pencil p = new Pencil("�𳪹�", 2000);
		Pencil p2 = new Pencil("������ũ", 3000);
		Pencil p3 = new Pencil("������", 4000);
		
		Box<Pencil> box1 = new Box<>();
		box1.add(p);
		box1.add(p2);
		box1.add(p3);
		
		box1.printAllItems();
		System.out.println();
		
		Tv[] tvArr = {
				new Tv("�Ｚ", 2300),
				new Tv("����", 2030),
				new Tv("����", 4080),
		};
		Box<Tv> box2 = new Box<>(tvArr);
		box2.printAllItems();
		System.out.println();
	}

}

class Box<T> {	// <T> Ÿ�� �Ķ����
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
		for (T item : items) {		// ����Ʈ �ڵ� ��ȯ �� ���Ϸ� �÷���Ʈ �ּ�ȭ
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
