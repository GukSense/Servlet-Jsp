package practice.test;

import java.util.Scanner;

public class ThrowsTest {
	
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		User2 user = new User2();
		
		VendingMachine2.putPrice(user);
		
		
		while(true) {
		
			VendingMachine2.form(user);
			try {
			VendingMachine2.filter(user);
			} catch (BalanceMismatchException2 e) {
				System.out.println("잔액을 충전하시겠습니까?");
				System.out.println("국민은행카드 사용시 보너스 10% 추가 적립");
			}
			
			System.out.println("음료를 추가로 구매하시겠습니까? " + "\n1->YES \n2->No" );
			
			user.setKeepGoing(scanner.nextInt());
			
			if(!user.isKeepGoing()) {
				break;
			}
		}
		
		System.out.println("이용해주셔서 감사합니다.");
	}
}

class VendingMachine2 {
	private User2 user;
	
	public static User2 putPrice(User2 user) {
		Scanner scanner = new Scanner(System.in);
		
		
			System.out.println(" ==== SamSung 'beverage vending machine' 입니다. ====");
			System.out.println("원하시는 금액을 넣어주세요.");
			user.putPrice(scanner.nextInt());
			System.out.println("현재잔액은 " + user.getBalance() + "입니다.");
		
			return user;
	}
	
	public static User2 form(User2 user) {
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("원하시는 음료를 선택하여주세요 1: 콜라 2: 사이다 3: 오렌지쥬스 4: 토레타  5: 식혜");
		// Review the code
		user.setBeverage(Beverage2.of(scanner.nextInt())); 
		System.out.println("선택하신 음료수의 가격은 " + user.test() + "입니다. 구매하시겠습니까?");
		
		if(user.getPrice() <= user.getBalance()) {
			user.setBalance(user.getPrice());
			System.out.println("======= 구매중 =======");
		}	
		
		if(user.getBalance() > 0)
			System.out.println("현재 잔액은 " + user.getBalance() + "입니다.");
		
		return user;
	}
	
	public static void filter(User2 user) throws BalanceMismatchException2 {
		try {
			if (user.getBalance() < user.getPrice()) 
				throw new BalanceMismatchException2("\n잔액이 부족합니다");
				
			} catch(BalanceMismatchException2 e) {
				System.out.println(e.getMessage());
				System.out.println("잔액을 충전하시겠습니까?");
			}
			
	}
}
	


class User2 {
	
	private Beverage2 beverage;
	private int price;
	private int balance;
	private boolean keepGoing;
	
	
	
	public boolean isKeepGoing() {
		
		return keepGoing;
	}

	public void setKeepGoing(int select) {
		
		boolean selectYesOrNot = true;
		switch(select) {
			case 1:
				selectYesOrNot = true;
				break;
			case 2:
				selectYesOrNot = false;
				break;
			default:
				System.out.println("잘못선택하셨습니다.");
		}
		keepGoing = selectYesOrNot;
		
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int price) {
		balance -= price;
		
	}

	//setter & getter beverage;
	public Beverage2 getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage2 beverage) {
		this.beverage = beverage;
	}
	
	public int test() {
		int beveragePrice = 0; 
		
		switch(beverage) {
			case COKE:
				beveragePrice = 800;
				break;
			case SPRITE:
				beveragePrice= 800;
				break;
			case ORANGEJUICE:
				beveragePrice = 1000;
				break;
			case SIKHYE:
				beveragePrice = 1000;
				break;
			case TOLETA:
				beveragePrice = 900;
				break;
		}
		price = beveragePrice;
		return price;
	}
	
	public void putPrice(int price) {
		balance = price;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	
}


//Enum
enum Beverage2  {
	COKE, SPRITE, ORANGEJUICE, SIKHYE ,TOLETA; 
	private static Beverage2[] beverage = Beverage2.values();
	
	
	//여기서 try catch를 사용해서 코드를 짜보자 
	public static Beverage2 of(int index) {
		try {
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("없는 메뉴입니다. 메뉴판에있는 번호만 입력해주세요");
		}
		
		return beverage[index-1];
	}
	
}

//제공되는 음료 외의 번호 입력 시 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
class NumMismatchException2 extends Exception {
	public NumMismatchException2(String message){
		super(message);
	}
	
}



//잔액이 부족할 경우 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
class BalanceMismatchException2 extends Exception {
	
	public BalanceMismatchException2(String message){
		super(message);
	}
}