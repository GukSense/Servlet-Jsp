package practice.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SertTest2modification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		����ǻ�ͽĴ翡�� ¥���, «��, �����, ��ġ�, ������ �Ļ� �޴��� �ֽ��ϴ�.
		A�� ¥���, «���� ���׽��ϴ�.
		B�� ¥���, �������� ���׽��ϴ�.
		C�� ¥���, ��ġ��� ���׽��ϴ�. 
		
		
		���� 1.
		�ֹ��� ��� �޴��� �ߺ� ���� �����Ͽ� ����ϼ���.
		���� 2.
		��� ����� �ֹ��� �޴��� ����ϼ���.
		���� 3.
		�� �� ��Ű�� ���� �޴����� ����ϼ���.
		*/
		Scanner scanner = new Scanner(System.in);
		
		Food[] arrFood = {
				new Food("¥���", 5000),
				new Food("«��", 6000),
				new Food("�����",6500),
				new Food("��ġ�",6500),
				new Food("������", 10000),
		};
		
	
		
		

	
	}
}

class Food {
	private String name;
	private int price;
	
	public Food(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "�޴���: " + name + " ����: " + price;
	}
}

class Cafeteria <T extends OrderItem> {
	private List<T> foods;
//	private Set<Food> SetFoods;
	
	
	public Cafeteria() {
		foods = new ArrayList<>();
	}
	
	public void setFoods(T[] food) {
		Collections.addAll(foods, food);
	}
	
	public List<T> getListFoods(){
		return foods;
	}
	

	
	
}


interface OrderItem {
	public abstract String getOrderItemName();
	public abstract  int getOrderItemPrice();
}