package practice.ch12;

import java.util.Scanner;

public class Throws {

	public static void main(String[] args) {
		while(true) {
			User2 user = null;
			
			user = LoginService2.form();
		
			try {
				LoginService2.login(user);
			} catch(IDMismatchException2 e) {
				System.out.println(e.getMessage());
				System.out.println("���̵� ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
				System.out.println("���ǻ����� 000-1234-5678�� �����ּ���.\n");
			} catch(PasswordMismatchException2  e) {
				System.out.println(e.getMessage());
				System.out.println("��й�ȣ ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
				System.out.println("���ǻ����� 000-1234-5678 �� �����ּ���.\n");
			} finally {
				LoginService2.increaseCount();
			}
			
			if(user.isLogin()) {
				LoginService2.success(user);
				break;
			}
			
			System.out.println("�α��ο� �����Ͽ����ϴ�.\n");
			
		}
		
		System.out.println("1. ȸ������");
		System.out.println("2. Ŀ�´�Ƽ");
		System.out.println("3. ����");
		System.out.println("4. �α׾ƿ�");
	}

}

class LoginService2 {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User2 user) throws IDMismatchException2, PasswordMismatchException2  {
		if (!DB_ID.equals(user.getId())) {
			throw new PasswordMismatchException2("�߸��� ���̵� �Է��Ͽ����ϴ�."); 	
		} else if(!DB_PW.equals(user.getPassword())) {
			throw new PasswordMismatchException2("�߸��� �н����带 �Է��Ͽ����ϴ�.");
		} else {
			user.setLogin(true);
		}
	}
	
	public static User2 form() {
		Scanner scanner = new Scanner(System.in);
		User2 user = new User2();
		
		System.out.println("- �α��� ȭ�� -");
		System.out.print("���̵� �Է��ϼ���.");
		user.setId(scanner.nextLine());
		System.out.println("�н����带 �Է��ϼ���.");
		user.setPassword(scanner.nextLine());
		
		return user;
		
	}
	
	public static void success(User2 user) {
		System.out.println(user.getId() + "�� ȯ���մϴ�.");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("�α��� �õ�" + count + "ȸ");
	}
}

class User2 {
	private String id;
	private String password;
	private boolean login;
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
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
	
}


class IDMismatchException2 extends Exception {
	
	public IDMismatchException2(String message) {
		super(message);
	}
}

class PasswordMismatchException2  extends Exception {
	
	public PasswordMismatchException2(String message) {
		super(message);
	}
}

/*
���� 1.
���Ǳ� ���α׷��� throws �� ����� �ڵ�� �����ϼ���.
*/