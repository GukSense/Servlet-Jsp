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
				System.out.println("�ܾ��� �����Ͻðڽ��ϱ�?");
				System.out.println("��������ī�� ���� ���ʽ� 10% �߰� ����");
			}
			
			System.out.println("���Ḧ �߰��� �����Ͻðڽ��ϱ�? " + "\n1->YES \n2->No" );
			
			user.setKeepGoing(scanner.nextInt());
			
			if(!user.isKeepGoing()) {
				break;
			}
		}
		
		System.out.println("�̿����ּż� �����մϴ�.");
	}
}

class VendingMachine2 {
	private User2 user;
	
	public static User2 putPrice(User2 user) {
		Scanner scanner = new Scanner(System.in);
		
		
			System.out.println(" ==== SamSung 'beverage vending machine' �Դϴ�. ====");
			System.out.println("���Ͻô� �ݾ��� �־��ּ���.");
			user.putPrice(scanner.nextInt());
			System.out.println("�����ܾ��� " + user.getBalance() + "�Դϴ�.");
		
			return user;
	}
	
	public static User2 form(User2 user) {
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("���Ͻô� ���Ḧ �����Ͽ��ּ��� 1: �ݶ� 2: ���̴� 3: �������꽺 4: �䷹Ÿ  5: ����");
		// Review the code
		user.setBeverage(Beverage2.of(scanner.nextInt())); 
		System.out.println("�����Ͻ� ������� ������ " + user.test() + "�Դϴ�. �����Ͻðڽ��ϱ�?");
		
		if(user.getPrice() <= user.getBalance()) {
			user.setBalance(user.getPrice());
			System.out.println("======= ������ =======");
		}	
		
		if(user.getBalance() > 0)
			System.out.println("���� �ܾ��� " + user.getBalance() + "�Դϴ�.");
		
		return user;
	}
	
	public static void filter(User2 user) throws BalanceMismatchException2 {
		try {
			if (user.getBalance() < user.getPrice()) 
				throw new BalanceMismatchException2("\n�ܾ��� �����մϴ�");
				
			} catch(BalanceMismatchException2 e) {
				System.out.println(e.getMessage());
				System.out.println("�ܾ��� �����Ͻðڽ��ϱ�?");
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
	
	
	//���⼭ try catch�� ����ؼ� �ڵ带 ¥���� 
	public static Beverage2 of(int index) {
		try {
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("���� �޴��Դϴ�. �޴��ǿ��ִ� ��ȣ�� �Է����ּ���");
		}
		
		return beverage[index-1];
	}
	
}

//�����Ǵ� ���� ���� ��ȣ �Է� �� �߻��Ǵ� ����� ���� ���� Ŭ������ �ۼ��� �ּ���.
class NumMismatchException2 extends Exception {
	public NumMismatchException2(String message){
		super(message);
	}
	
}



//�ܾ��� ������ ��� �߻��Ǵ� ����� ���� ���� Ŭ������ �ۼ��� �ּ���.
class BalanceMismatchException2 extends Exception {
	
	public BalanceMismatchException2(String message){
		super(message);
	}
}