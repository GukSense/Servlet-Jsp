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
			
			
			System.out.println("���Ḧ �߰��� �����Ͻðڽ��ϱ�? " + "\n1->YES \n2->No" );
			
			user.setKeepGoing(scanner.nextInt());
			
			if(!user.isKeepGoing()) {
				break;
			}
		}
		
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}

class VendingMachine {
	private User user;
	
	public static User putPrice(User user) {
		Scanner scanner = new Scanner(System.in);
		
		
			System.out.println(" ==== SamSung 'beverage vending machine' �Դϴ�. ====");
			System.out.println("���Ͻô� �ݾ��� �־��ּ���.");
			user.putPrice(scanner.nextInt());
			System.out.println("�����ܾ��� " + user.getBalance() + "�Դϴ�.");
		
			return user;
	}
	
	public static User form(User user) {
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("���Ͻô� ���Ḧ �����Ͽ��ּ��� 1: �ݶ� 2: ���̴� 3: �������꽺 4: �䷹Ÿ  5: ����");
		// Review the code
		try {
			
			user.setBeverage(Beverage.of(scanner.nextInt())); 			
		} catch(ArrayIndexOutOfBoundsException e)  {
			System.out.println("���� �޴��Դϴ�. �޴��ǿ��ִ� ��ȣ�� �Է����ּ���");
		}
		System.out.println("�����Ͻ� ������� ������ " + user.test() + "�Դϴ�. �����Ͻðڽ��ϱ�?");
		
		if(user.getPrice() <= user.getBalance()) {
			user.setBalance(user.getPrice());
			System.out.println("======= ������ =======");
		}	
		
		if(user.getBalance() > 0)
			System.out.println("���� �ܾ��� " + user.getBalance() + "�Դϴ�.");
		
		return user;
	}
	
	public static void filter(User user) {
		try {
			
//			switch (user.getBeverage()) {
//				case COKE:
//					break;
//				case SPRITE:
//					break;
//				case ORANGEJUICE:
//					break;
//				case SIKHYE:
//					break;
//				case TOLETA:
//					break;
//				default:
//					throw new NumMismatchException("���� �޴��Դϴ�. �޴��ǿ��ִ� ��ȣ�� �Է����ּ���");	
			if (user.getBalance() < user.getPrice()) 
				throw new BalanceMismatchException("\n�ܾ��� �����մϴ�");
				
			} catch(BalanceMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("�ܾ��� �����Ͻðڽ��ϱ�?");
				
				
			}
		 
//			if(user.getBeverage() == Beverage.TOLETA) {
//				throw new NumMismatchException("���� �޴��Դϴ�. �޴��ǿ��ִ� ��ȣ�� �Է����ּ���");				
//			} else if (user.getBalance() < user.getPrice()) {
//				throw new BalanceMismatchException("�ܾ��� �����մϴ�");
//			}
//		} catch(NumMismatchException e) {
//			System.out.println(e.getMessage());
//			System.out.println("�޴����� ����� ���Ͻø� Ŭ�����ּ���");
		 
			
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
				System.out.println("�߸������ϼ̽��ϴ�.");
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
	
	//���⼭ try catch�� ����ؼ� �ڵ带 ¥���� 
	public static Beverage of(int index) {
//		try {
//		
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//			System.out.println("���� �޴��Դϴ�. �޴��ǿ��ִ� ��ȣ�� �Է����ּ���");
//		}
		
		return beverage[index-1];
	}
	
}

//�����Ǵ� ���� ���� ��ȣ �Է� �� �߻��Ǵ� ����� ���� ���� Ŭ������ �ۼ��� �ּ���.
class NumMismatchException extends Exception {
	public NumMismatchException(String message){
		super(message);
	}
	
}



//�ܾ��� ������ ��� �߻��Ǵ� ����� ���� ���� Ŭ������ �ۼ��� �ּ���.
class BalanceMismatchException extends Exception {
	
	public BalanceMismatchException(String message){
		super(message);
	}
}