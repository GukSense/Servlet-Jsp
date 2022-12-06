package practice.ch19;

import java.util.HashMap;
import java.util.Map;

/*
문제 1.
회원에 레벨 속성을 추가하고 레벨이 2이상인 회원만 출력하는 코드를 람다식을 사용하여 코딩하세요.
문제 2.
차량 출입 시간이 5시에서 9시 사이인 차량만 출력하는 프로그램을 코딩하세요.
위 회원 검색 프로그램과 같이 함수형 인터페이스를 작성하고 람다식을 사용해야 합니다.  
*/

public class ExLambda {

	public static void main(String[] args) {
		Map<String, User> allUsers = UserService.getUserMap();
		Map<String, User> condUsers = null;
		
		condUsers = UserService.search(allUsers, new Criteria() {
			@Override
			public boolean where(User user) {
				return user.getAge() < 30;
			}
		});
		UserService.printUsers(condUsers);
		System.out.println();
		
		condUsers = UserService.search(allUsers, u -> u.getAge() > 25);
		UserService.printUsers(condUsers);
		System.out.println();
		
		condUsers = UserService.search(allUsers, u -> u.getId().startsWith("test"));
		UserService.printUsers(condUsers);
		System.out.println();
		
		condUsers = UserService.search(allUsers, u -> u.getLevel() >= 2);
		UserService.printUsers(condUsers);
		System.out.println();
	}

}


@FunctionalInterface
interface Criteria {
	public abstract boolean where(User user);
}

class UserService {
	private static Map<String, User> userMap;
	
	static {
		userMap = new HashMap<>();
		UserService.add("admin", new User("admin", 27, 1));
		UserService.add("test1", new User("test1", 30, 2));
		UserService.add("test2", new User("test2", 22, 3));
		UserService.add("test3", new User("test3", 19, 4));
		UserService.add("test4", new User("test4", 35, 5));
	}
	public static Map<String, User> getUserMap(){
		return userMap;
	}
	public static void add(String id , User user) {
		userMap.put(id, user);
	}
	public static Map<String, User> search(Map<String, User> user, Criteria c) {
		Map<String, User> condUsers = new HashMap<>();
		
		for(Map.Entry<String, User> entry : user.entrySet()) {
			if(c.where(entry.getValue()))
				condUsers.put(entry.getKey(), entry.getValue());
		}
		
		return condUsers;
	}
	public static void printUsers(Map<String, User> user) {
		for(Map.Entry<String, User> entry : user.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
}
class User {
	private String id;
	private int age;
	private int level;
	
	public User(String id, int age, int level) {
		this.age = age;
		this.id = id;
		this.level = level;
	}

	public String getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public int getLevel() {
		return level;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", level=" + level + "]";
	}
	
	
	
}