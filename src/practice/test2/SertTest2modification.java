package practice.test2;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		Cafeteria jajangmyeon = new Cafeteria();
		jajangmyeon.setName("¥���");
		jajangmyeon.setPrice(4500);
		Cafeteria jjamppong = new Cafeteria();
		jjamppong.setName("«��");
		jjamppong.setPrice(6500);
		Cafeteria doenjangStew = new Cafeteria();
		doenjangStew.setName("�����");
		doenjangStew.setPrice(6000);
		Cafeteria kimchiStew = new Cafeteria();
		kimchiStew.setName("��ġ�");
		kimchiStew.setPrice(6000);
		Cafeteria SweetandSourPork = new Cafeteria();
		SweetandSourPork.setName("������");
		SweetandSourPork.setPrice(10000);
		
		
		List<Cafeteria> menus = new ArrayList<>();
		menus.add(SweetandSourPork);
		menus.add(kimchiStew);
		menus.add(doenjangStew);
		menus.add(jajangmyeon);
		menus.add(jjamppong);
		
	
		
		
		User userA = new User();
		System.out.print("����ǻ�ͽĴ��Դϴ�.");
		System.out.println("���Ͻô� �޴��� �����Ͽ��ֽʽÿ�: -> 1: ¥��� 2: «�� 3: ����� 4: ��ġ� 5: ������");
		try {
			userA.setOrderName(scanner.nextInt());
		} catch(NullPointerException e) {
			System.out.println("�󰪿���");
		};
		try {
		userA.setOrderPrice(scanner.nextInt());
		} catch(NullPointerException e) {
			System.out.println("�󰪿���");
		};
		
		
		
		
		
	}

}
class User  extends Cafeteria implements OrderService {
	private int price;
	private String orderName;
	List<Cafeteria> menus;
	
	public String setOrderName(int menu) {
		if ()
			return;
		switch(menu) {
			case 0:
				getMenu(menu).getName();
				break;
			case 1:
				getMenu(menu).getName();
				break;
			case 2:
				getMenu(menu).getName();
				break;
			case 3:
				getMenu(menu).getName();
				break;
			case 4:
				getMenu(menu).getName();
				break;
		}
			
		orderName = getMenu(menu).getName();
		return orderName ;
	}
	
	public int setOrderPrice(int menu) {		
		switch(menu) {
		case 0:
			getMenu(menu).getPrice();
			break;
		case 1:
			getMenu(menu).getPrice();
			break;
		case 2:
			getMenu(menu).getPrice();
			break;
		case 3:
			getMenu(menu).getPrice();
			break;
		case 4:
			getMenu(menu).getPrice();
			break;
		}
		price = getMenu(menu).getPrice();
		return price;
	}
	public Cafeteria getMenu(int index){
		return menus.get(index);
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

interface OrderService {
	public abstract String getOrderName();
	public abstract int getOrderPrice();
}

class Cart <T extends OrderService> {
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


class Cafeteria {	
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
	
	
	public String toString() {
		return "�޴���: " + name + " ����: " + price;
	}
	
	
}