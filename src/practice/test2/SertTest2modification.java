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
		Scanner scanner = new Scanner(System.in);
		
		Food[] arrFood = {
				new Food("짜장면", 5000),
				new Food("짬뽕", 6000),
				new Food("된장찌개",6500),
				new Food("김치찌개",6500),
				new Food("탕수육", 10000),
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
		return "메뉴명: " + name + " 가격: " + price;
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