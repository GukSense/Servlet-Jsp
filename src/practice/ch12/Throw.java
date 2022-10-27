package practice.ch12;

import java.util.Scanner;

public class Throw {
	
	public static void main(String[]args) {
	
		while(true) {
			User user = null;
			
			user = LoginService.form();
			LoginService.login(user);
			
			if(user.isLogin()) {
				LoginService.success(user);
				break;
			}
			
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		}
		
		System.out.println("1. ȸ������");
		System.out.println("2. Ŀ�´�Ƽ");
		System.out.println("3. ����");
		System.out.println("4. �α׾ƿ�");
		
	}
}

class LoginService {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static void login(User user) {
		//try catch
		try {
			if(!DB_ID.equals(user.getId())) {
				throw new IDMismatchException("�߸��� ���̵� �Է��Ͽ����ϴ�.");
				
			} else if(!DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException("�߸��� �н����带 �Է��Ͽ����ϴ�.");
			} else {
				user.setLogin(true);
			}
		} catch(IDMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("���̵�ã�⸦ ���Ͻø� Ŭ�����ּ���.");
		} catch(PasswordMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("��й�ȣ ã�⸦ ���Ͻø� Ŭ���� �ּ���");
		} catch(Exception e) {
			System.out.println("�ý��� ���");			
		} finally {
			increaseCount();
		}

	
		
	}
	
	//put the login
	public static User form() {
		
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		
		System.out.println(" -�α��� ȭ��- ");
		System.out.print("���̵� �Է��ϼ���: ");
		user.setId(scanner.nextLine());
		System.out.println("�н����带 �Է��ϼ���: ");
		user.setPassword(scanner.nextLine());
		
		return user;
	}
	
	public static void success(User user) {
		System.out.println(user.getId() + "�� ȯ���մϴ�.");
	}
	
	public static void increaseCount() {
		count++;
		System.out.println("�α��� �õ� " + count + "ȸ");
	}
	
}

class User {
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

class IDMismatchException extends Exception {
	public IDMismatchException(String message) {
		super(message);
	}
}

class PasswordMismatchException extends Exception {
	public PasswordMismatchException(String message) {
		super(message);
	}
}
