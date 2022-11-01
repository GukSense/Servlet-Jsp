package practice.ch12;

import java.util.Scanner;

public class Ex07ReThrow {

	public static void main(String[] args) {
		while(true) {
			User3 user = null;
			
			user = LoginService3.form();
			
			try {
				LoginService3.login(user);
			} catch (IDMismatchException3 e) {
				System.out.println("���ǻ����� 000-1234-5678�� �����ּ���.\n");
			} catch (PasswordMismatchException3 e) {
				System.out.println("���ǻ����� 000-1234-5678 �� �����ּ���.\n");
			} 
		
			if(user.isLogin()) {
				LoginService3.success(user);
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

class LoginService3 {
	private static final String  DB_ID = "admin";
	private static final String  DB_PW = "1234";
	private static int count = 0;
	
	public static User3 form() {
		
		Scanner scanner = new Scanner(System.in);
		User3 user = new User3();
		
		System.out.println(" --- �α��� ȭ�� --- ");
		System.out.println("���̵� �Է��ϼ���: ");
		user.setId(scanner.nextLine());
		System.out.println("��й�ȣ�� �Է��ϼ���: ");
		user.setPassword(scanner.nextLine());
		
		
		return user;
	}
	
	public static void login(User3 user) throws IDMismatchException3, PasswordMismatchException3 {
		try {
			
			if (!DB_ID.equals(user.getId())) {
				throw new IDMismatchException3("���̵� �߸��Է��ϼ̽��ϴ�.");
				
			} else if (!DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException3("��й�ȣ�� �߸��Է��ϼ̽��ϴ�.");
			} else {
				user.setLogin(true);
			}
		} catch(IDMismatchException3 e) {
			System.out.println("���̵�ã�⸦ ���Ͻø� Ŭ�����ּ���.");
			throw e;
		} catch(PasswordMismatchException3 e) {
			System.out.println("��й�ȣã�⸦ ���Ͻø� Ŭ�����ּ���.");
			throw e;
		} finally {
			LoginService3.increaseCount();
		}
	}

	public static void success(User3 user) {
		System.out.println(user.getId() + " �� ȯ���մϴ�.\n");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("�α��νõ� " + count + "ȸ");
	}
}

class User3 {
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

class IDMismatchException3 extends Exception {
	IDMismatchException3(String message){
		super(message);
	}
}

class PasswordMismatchException3 extends Exception {
	PasswordMismatchException3(String message){
		super(message);
	}
}