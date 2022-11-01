package practice.ch12;

import java.util.Scanner;

public class ChainedException {

	public static void main(String[] args) {
		
		while(true) {
			User4 user = null;
			
			user = LoginService4.form();
			
			try {
				LoginService4.login(user);
			} catch(LoginException e) {
				System.out.println("���ǻ����� 0000-1234-5678�� �����ּ���.");
				e.printStackTrace();
			}
			
			if(user.isLogin()) {
				LoginService4.success(user);
				break;
			}
			
			System.out.println("�α��ν���\n");
		}
		
		System.out.println("1. ȸ������");
		System.out.println("2. Ŀ�´�Ƽ");
		System.out.println("3. ����");
		System.out.println("4. �α׾ƿ�");
	}

}

class LoginService4 {
	private static final String DB_ID = "admin";
	private static final String DB_PW = "1234";
	private static int count = 0;
	
	public static User4 form() {
		Scanner scanner = new Scanner(System.in);
		User4 user = new User4();
		
		System.out.println("���̵� �Է��ϼ���: ");
		user.setId(scanner.nextLine());
		System.out.println("��й�ȣ�� �Է��ϼ���: ");
		user.setPassword(scanner.nextLine());
		
		return user;
		
	}
	
	public static void login(User4 user) throws LoginException {
		
		try {
			
			if(DB_ID.equals(user.getId())) {
				throw new IDMismatchException4("�߸��� ���̵� �Է��Ͽ����ϴ�.");
			} else if(DB_PW.equals(user.getPassword())) {
				throw new PasswordMismatchException4("�߸��� �н����带 �Է��Ͽ����ϴ�.");
			} else {
				user.setLogin(true);
			}
			
		} catch(IDMismatchException4 e) {
			System.out.println("���̵� ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
			throw new LoginException("�α��� ���ܰ� �߻��Ͽ����ϴ�.", e);
			
		} catch(PasswordMismatchException4 e) {
			System.out.println("��й�ȣ ã�⸦ ���Ͻø� Ŭ���� �ּ���.");
			throw new LoginException("�α��� ���ܰ� �߻��Ͽ����ϴ�.", e);
		} finally {
			increaseCount();
		}
		
		
	}
	public static void success(User4 user) {
		System.out.println(user.getId() + " �� ȯ���մϴ�.\n");
	} 
	
	public static void increaseCount() {
		count++;
		System.out.println("�α��� �õ� " + count + "ȸ");
	}
	
}

class User4 {
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

class LoginException extends Exception {
	public LoginException(String message,Exception e) {
		super(message , e);
	}
}

class IDMismatchException4 extends Exception {
	IDMismatchException4(String message){
		super(message);
	}
}

class PasswordMismatchException4 extends Exception {
	PasswordMismatchException4(String message){
		super(message);
	}
}