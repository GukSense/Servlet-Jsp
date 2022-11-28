package practice.test;

import java.util.Scanner;

public class ThrowTest {

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		User user = new User();

		VendingMachine.putPrice(user);

		while(true) {

			VendingMachine.form(user);
			VendingMachine.filter(user);


			System.out.println("음료를 추가로 구매하시겠습니까? " + "\n1->YES \n2->No" );

			user.setKeepGoing(scanner.nextInt());

			if(!user.isKeepGoing()) {
				break;
			}
		}

		System.out.println("이용해주셔서 감사합니다.");
	}
}

class VendingMachine {
	private User user;

	public static User putPrice(User user) {
		Scanner scanner = new Scanner(System.in);				
			System.out.println(" ==== SamSung 'beverage vending machine' 입니다. ====");
			System.out.println("원하시는 금액을 넣어주세요.");
			user.putPrice(scanner.nextInt());
			System.out.println("현재잔액은 " + user.getBalance() + "입니다.");

			return user;
	}

	public static User form(User user) {
		Scanner scanner = new Scanner(System.in);


		System.out.println("원하시는 음료를 선택하여주세요 1: 콜라 2: 사이다 3: 오렌지쥬스 4: 토레타  5: 식혜");
		// Review the code
		while (scanner.hasNext()) {
			try {
				user.setBeverage(Beverage.of(scanner.nextInt()));
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				//e.printStackTrace();
				System.out.print("없는 메뉴입니다. 메뉴판에있는 번호만 입력해주세요: ");
			}
		}

		System.out.println("선택하신 음료수의 가격은 " + user.test() + "입니다. 구매하시겠습니까?");

		if(user.getPrice() <= user.getBalance()) {
			user.setBalance(user.getPrice());
			System.out.println("======= 구매중 =======");
		}	

		if(user.getBalance() > 0)
			System.out.println("현재 잔액은 " + user.getBalance() + "입니다.");

		return user;
	}

	public static void filter(User user) {
		try {

			if (user.getBalance() < user.getPrice()) 
				throw new BalanceMismatchException("\n잔액이 부족합니다");

			} catch(BalanceMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("잔액을 충전하시겠습니까?");	
			}

	}
}



class User {

	private Beverage beverage;
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
	public Beverage getBeverage() {
		return beverage;
	}

	public void setBeverage(Beverage beverage) {
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
enum Beverage  {
	COKE, SPRITE, ORANGEJUICE, SIKHYE ,TOLETA; 
	private static Beverage[] beverage = Beverage.values();
	static User user;

	//여기서 try catch를 사용해서 코드를 짜보자 
	public static Beverage of(int index) throws ArrayIndexOutOfBoundsException {
		return beverage[index-1];
	}

}

//제공되는 음료 외의 번호 입력 시 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
class NumMismatchException extends Exception {
	public NumMismatchException(String message){
		super(message);
	}

}



//잔액이 부족할 경우 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
class BalanceMismatchException extends Exception {

	public BalanceMismatchException(String message){
		super(message);
	}
}