package practice.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetTest2 {

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
		
//		Cafeteria jajangmyeon = new Cafeteria();
//		jajangmyeon.setName("짜장면");
//		jajangmyeon.setPrice(4500);
//		Cafeteria jjamppong = new Cafeteria();
//		jjamppong.setName("짬뽕");
//		jjamppong.setPrice(6500);
//		Cafeteria doenjangStew = new Cafeteria();
//		doenjangStew.setName("된장찌개");
//		doenjangStew.setPrice(6000);
//		Cafeteria kimchiStew = new Cafeteria();
//		kimchiStew.setName("김치찌개");
//		kimchiStew.setPrice(6000);
//		Cafeteria SweetandSourPork = new Cafeteria();
//		SweetandSourPork.setName("탕수육");
//		SweetandSourPork.setPrice(10000);
	
		
//Cart<Cafeteria> cart1 = new Cart<>();
		User userA = new User();
		System.out.print("엘컴퓨터식당입니다.");
		System.out.println("원하시는 메뉴를 선택하여주십시오: -> 1: 짜장면 2: 짬뽕 3: 된장찌개 4: 김치찌개 5: 탕수육");
		
		
		
		
		
		
	}

}
class User2  implements OrderService {
	private int price;
	private String orderName;
	
	
	public String setOrderName(int menu) {
		switch(menu) {
			case 1:
				orderName = "짜장면";
				break;
			case 2:
				orderName = "짬뽕";
				break;
			case 3:
				orderName = "된장찌개";
				break;
			case 4:
				orderName = "김치찌개";
				break;
			case 5:
				orderName = "탕수육";
				break;		
		}
		return orderName;
	}
	
	public int setOrderPrice(int index) {		
		switch(index){
			case 1:
				price = 4500;
				break;
			case 2:
				price = 6500;
				break;
			case 3:
				price = 6000;
				break;
			case 4:
				price = 6000;
				break;
			case 5:
				price = 10000;
				break;	
		}
		return price;
	}
	
	@Override
	public String getOrderName() {
		return orderName;
	}
	
	@Override
	public int getOrderPrice() {
		return price;
	}
	
}

interface OrderService2 {
	public abstract String getOrderName();
	public abstract int getOrderPrice();
}

class Cart2 <T extends OrderService> {
	private List<T> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	
	public void add(T item) {
		items.add(item);
	}
		
	public T get(int index) {
		return items.get(index);
	}
}


class Cafeteria2 implements OrderService {
	private int price;
	private String name;
	
	
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
	
	@Override
	public String getOrderName() {
		return getName();
	}
	
	@Override
	public int getOrderPrice() {
		return getPrice();
	}
	
	
}