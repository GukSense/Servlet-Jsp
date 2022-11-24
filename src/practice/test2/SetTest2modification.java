package practice.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest2modification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		엘컴퓨터식당에는 짜장면, 짬뽕, 된장찌개, 김치찌개, 탕수육 식사 메뉴가 있습니다.
		A는 짜장면, 짬뽕을 시켰습니다.
		B는 짜장면, 탕수육을 시켰습니다.
		C는 짜장면, 김치찌개를 시켰습니다. 
		
		
		문제 1.
		주문한 모든 메뉴를 중복 없이 정렬하여 출력하세요.
		문제 2.
		모든 사람이 주문한 메뉴를 출력하세요.
		문제 3.
		한 명도 시키지 않은 메뉴들을 출력하세요.
		*/
		
		Food f1 = new Food("짜장면", 5000);
		Food f2 = new Food("짬뽕", 6000);
		Food f3 = new Food("탕수육", 7000);
		Food f4 = new Food("김치찌개", 15000);
		
		List<Food> foods = new ArrayList();
		System.out.println(foods.contains(f1));
		foods.add(f1);
		foods.add(f2);
		foods.add(f3);
		foods.add(f4);
		System.out.println(foods.contains(f1));	
		System.out.println(foods.contains(f2));	
		System.out.println(foods.contains(f3));	
		System.out.println(foods.contains(f4));
		System.out.println(foods.get(0));
		
		
		Order a = new Order();
		Order b  = new Order();
		Order c = new Order();
		OrderService service = new OrderService();
		
		a.setOrder(f1,f2);//짜장,짬뽕
		System.out.println("a");
		a.pirnt();
		
		
		b.setOrder(f2, f3);
		System.out.println("b");
		b.pirnt();
		
		c.setOrder(f3, f4);
		System.out.println("c");
		c.pirnt();
		System.out.println();
		
		service.add(a,b,c);
		service.printAllOrder();
	
	}
}

class Food {
	private String name;
	private int price;
	
	public Food() {
		
	}
	
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
		return "메뉴명: " + name + " 가격: " + price;
	}
}


class Order {
	private String orderName;
	private int orderPrice;
	private List<Food> foods;
	
	public void setOrder(Food... f) {
		foods = new ArrayList<>();
		Collections.addAll(foods, f);
		
	}
	
	public void pirnt() {
		System.out.println(foods);
		
	}
	
	
	public String toString() {
		return foods.toString();
	}
	
	
	
} 

class OrderService {
	private List<Order> order;
	
	
	
	public void add(Order... o) {
		order = new ArrayList<>();
		Collections.addAll(order, o);
	}
	
	public void printAllOrder() {
		System.out.println("AllMenu");
		for(Order o : order) {
			System.out.println(o);
		}
	}
	
	public void printCommonOrder() {
		System.out.println("Common");
		Set<Order> o1 = null;
		Set<Order> o2 = null;
		
		
	}
	
}



