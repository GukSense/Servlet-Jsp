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
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
		} catch(PassWordMissmatchException e) {			
			System.out.println(e.getMessage());
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
		}
		
		System.out.println("L-shoppingMall - Kiosk 입니다. 원하시는 메뉴를 선택하여주세요. 0: 콜라 1: 스프라이트 : 2: 오렌지 쥬스 3: 식혜 4: 토레타 5: 결제하기" );
		
		
		switch (Beverage.values()[scanner.nextInt()]) {
			case COKE:
				System.out.println("---- 이미지 출력 ----");
				System.out.println(Beverage.COKE.getOrderTitle() + "\n" + Beverage.COKE.getOrderPrice() +"원");
				cart.addOrders(Beverage.COKE);
				System.out.println();
				break;
			case SPRITE:
				System.out.println("---- 이미지 출력 ----");
				System.out.println(Beverage.SPRITE.getOrderTitle() + "\n" + Beverage.SPRITE.getOrderPrice() +"원");
				cart.addOrders(Beverage.SPRITE);
				System.out.println();
				break;
			case ORANGEJUICE:
				System.out.println("---- 이미지 출력 ----");
				System.out.println(Beverage.ORANGEJUICE.getOrderTitle() + "\n" + Beverage.ORANGEJUICE.getOrderPrice() +"원");
				cart.addOrders(Beverage.ORANGEJUICE);
				System.out.println();
				break;
			case SIKHYE:
				System.out.println("---- 이미지 출력 ----");
				System.out.println(Beverage.SIKHYE.getOrderTitle() + "\n" + Beverage.SIKHYE.getOrderPrice() +"원");
				cart.addOrders(Beverage.SIKHYE);
				System.out.println();
				break;
			case TOLETA:
				System.out.println("---- 이미지 출력 ----");
				System.out.println(Beverage.TOLETA.getOrderTitle() + "\n" + Beverage.TOLETA.getOrderPrice() +"원");
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
		System.out.print("ID를 입력하십시오\nID: ");
		u.setId(s.nextLine());
		System.out.print("PassWord를 입력하십시오\nPassWord: ");
		u.setPassword(s.nextLine());
		
		return u;
		
	}
	
	public static void Login(User u) throws IDMissmatchException, PassWordMissmatchException {
			
			if (!(DB_ID.equals(u.getId()))) {
				throw new IDMissmatchException("아이디를 잘못 입력하셨습니다.");				
			} else if (!(DB_PASSWORD.equals(u.getPassword()) )) {
				throw new PassWordMissmatchException("비밀번호를 잘못 입력하셨습니다.");
			} else {
				System.out.println("- 로그인 성공 -");
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
			System.out.println("상품명: " + o.getOrderTitle() + "가격: " + o.getOrderPrice());
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
	COKE("콜라", 1800), SPRITE("스프라이트", 1500), ORANGEJUICE("오렌지 쥬스", 2000), SIKHYE("식혜", 1500), TOLETA("토레타", 1700);
	
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
		return title + price + "원";
	}
	
	
}