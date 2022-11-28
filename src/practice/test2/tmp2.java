package practice.test2;

import java.util.Scanner;

public class tmp2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VendingMachine vm = new VendingMachine();
		User u = VendingMachine.form();		
		try {
			VendingMachine.Login(u);
		} catch(IDMissmatchException e) {
			System.out.println(e.getMessage());
			System.out.println("���̵� ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
		} catch(PassWordMissmatchException e) {			
			System.out.println(e.getMessage());
			System.out.println("��й�ȣ ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
		}
		
		
		
	}

}

class VendingMachine {
	private final static String USER_ID = "redraib05";
	private final static String USER_PASSWORD = "1234";
	
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
			
			if (!(USER_ID.equals(u.getId()))) {
				throw new IDMissmatchException("���̵� �߸� �Է��ϼ̽��ϴ�.");				
			} else if (!(USER_PASSWORD.equals(u.getPassword()) )) {
				throw new PassWordMissmatchException("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			} else {
				System.out.println("- �α��� ���� -");
			}	
		
	}
	
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

enum Beverage {
	COKE, SPRITE, ORANGEJUICE, SIKHYE, TOLETA 
}