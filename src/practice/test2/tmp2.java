package practice.test2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class tmp2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		shoppingMall sm = new shoppingMall();
		Cart cart = new Cart();
		User u = shoppingMall.form();		
		try {
			shoppingMall.Login(u);
		} catch(IDMissmatchException e) {
			System.out.println(e.getMessage());
			System.out.println("���̵� ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
		} catch(PassWordMissmatchException e) {			
			System.out.println(e.getMessage());
			System.out.println("��й�ȣ ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
		}
		
		System.out.println("L-shoppingMall - Kiosk �Դϴ�. ���Ͻô� �޴��� �����Ͽ��ּ���. 0: �ݶ� 1: ��������Ʈ : 2: ������ �꽺 3: ���� 4: �䷹Ÿ 5: �����ϱ�" );
		
		
		switch (Beverage.values()[scanner.nextInt()]) {
			case COKE:
				System.out.println("---- �̹��� ��� ----");
				System.out.println(Beverage.COKE.getOrderTitle() + "\n" + Beverage.COKE.getOrderPrice() +"��");
				cart.addOrders(Beverage.COKE);
				System.out.println();
				break;
			case SPRITE:
				System.out.println("---- �̹��� ��� ----");
				System.out.println(Beverage.SPRITE.getOrderTitle() + "\n" + Beverage.SPRITE.getOrderPrice() +"��");
				cart.addOrders(Beverage.SPRITE);
				System.out.println();
				break;
			case ORANGEJUICE:
				System.out.println("---- �̹��� ��� ----");
				System.out.println(Beverage.ORANGEJUICE.getOrderTitle() + "\n" + Beverage.ORANGEJUICE.getOrderPrice() +"��");
				cart.addOrders(Beverage.ORANGEJUICE);
				System.out.println();
				break;
			case SIKHYE:
				System.out.println("---- �̹��� ��� ----");
				System.out.println(Beverage.SIKHYE.getOrderTitle() + "\n" + Beverage.SIKHYE.getOrderPrice() +"��");
				cart.addOrders(Beverage.SIKHYE);
				System.out.println();
				break;
			case TOLETA:
				System.out.println("---- �̹��� ��� ----");
				System.out.println(Beverage.TOLETA.getOrderTitle() + "\n" + Beverage.TOLETA.getOrderPrice() +"��");
				cart.addOrders(Beverage.TOLETA);
				System.out.println();
				break;			
		}
		
		cart.printAllOrders();
		
		
	}

}

class shoppingMall {
	private final static String DB_ID = "redraib05";
	private final static String DB_PASSWORD = "1234";
	
	public static User form() {
		Scanner s  = new Scanner(System.in);
		User u = new User();
		System.out.print("ID�� �Է��Ͻʽÿ�\nID: ");
		u.setId(s.nextLine());
		System.out.print("PassWord�� �Է��Ͻʽÿ�\nPassWord: ");
		u.setPassword(s.nextLine());
		
		return u;
		
	}
	
	public static void Login(User u) throws IDMissmatchException, PassWordMissmatchException {
			
			if (!(DB_ID.equals(u.getId()))) {
				throw new IDMissmatchException("���̵� �߸� �Է��ϼ̽��ϴ�.");				
			} else if (!(DB_PASSWORD.equals(u.getPassword()) )) {
				throw new PassWordMissmatchException("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			} else {
				System.out.println("- �α��� ���� -");
			}	
	}
	
}
class Cart {
	Deque<Order2> orders;
	
	public Cart() {
		orders = new LinkedList<>();
	}
	
	public void addOrders(Order2 o) {
		orders.offer(o);
	}
	public void printAllOrders() {
		System.out.println();
		for(Order2 o : orders) {
			System.out.println("��ǰ��: " + o.getOrderTitle() + "����: " + o.getOrderPrice());
		}
	}
}
interface Order2 {
	public abstract String getOrderTitle();
	public abstract int getOrderPrice();
}

class User {
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private boolean login;
	
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
	
	
	
}

class IDMissmatchException extends Exception {
	public IDMissmatchException(String message) {
		super(message);
	}
}
class PassWordMissmatchException extends Exception {
	public PassWordMissmatchException(String message) {
		super(message);
	}
}

enum Beverage implements Order2 {
	COKE("�ݶ�", 1800), SPRITE("��������Ʈ", 1500), ORANGEJUICE("������ �꽺", 2000), SIKHYE("����", 1500), TOLETA("�䷹Ÿ", 1700);
	
	private final String title;
	private final int price;
	
	Beverage(String title, int price) {
		this.title = title;
		this.price = price;
	}
	@Override
	public int getOrderPrice() {
		return price;
	}
	@Override
	public String getOrderTitle() {
		return title;
	}
	@Override
	public String toString() {
		return title + price + "��";
	}
	
	
}