package practice.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetTest2 {

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
		
//		Cafeteria jajangmyeon = new Cafeteria();
//		jajangmyeon.setName("¥���");
//		jajangmyeon.setPrice(4500);
//		Cafeteria jjamppong = new Cafeteria();
//		jjamppong.setName("«��");
//		jjamppong.setPrice(6500);
//		Cafeteria doenjangStew = new Cafeteria();
//		doenjangStew.setName("�����");
//		doenjangStew.setPrice(6000);
//		Cafeteria kimchiStew = new Cafeteria();
//		kimchiStew.setName("��ġ�");
//		kimchiStew.setPrice(6000);
//		Cafeteria SweetandSourPork = new Cafeteria();
//		SweetandSourPork.setName("������");
//		SweetandSourPork.setPrice(10000);
	
		
//Cart<Cafeteria> cart1 = new Cart<>();
		User userA = new User();
		System.out.print("����ǻ�ͽĴ��Դϴ�.");
		System.out.println("���Ͻô� �޴��� �����Ͽ��ֽʽÿ�: -> 1: ¥��� 2: «�� 3: ����� 4: ��ġ� 5: ������");
		
		
		
		
		
		
	}

}
class User2  implements OrderService {
	private int price;
	private String orderName;
	
	
	public String setOrderName(int menu) {
		switch(menu) {
			case 1:
				orderName = "¥���";
				break;
			case 2:
				orderName = "«��";
				break;
			case 3:
				orderName = "�����";
				break;
			case 4:
				orderName = "��ġ�";
				break;
			case 5:
				orderName = "������";
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