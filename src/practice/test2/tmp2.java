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
			System.out.println("아이디 찾기를 원하시면 클릭해 주세요.");
		} catch(PassWordMissmatchException e) {			
			System.out.println(e.getMessage());
			System.out.println("비밀번호 찾기를 원하시면 클릭해 주세요.");
		}
		
		
		
	}

}

class VendingMachine {
	private final static String USER_ID = "redraib05";
	private final static String USER_PASSWORD = "1234";
	
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
			
			if (!(USER_ID.equals(u.getId()))) {
				throw new IDMissmatchException("아이디를 잘못 입력하셨습니다.");				
			} else if (!(USER_PASSWORD.equals(u.getPassword()) )) {
				throw new PassWordMissmatchException("비밀번호를 잘못 입력하셨습니다.");
			} else {
				System.out.println("- 로그인 성공 -");
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