package practice.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest02 {

	public static void main(String[] args) {
		/*
		반별 학생 목록을 저장하는 맵을 작성하세요.
		학생들은 자신의 모의고사 점수들을 리스트로 갖습니다. 
		학생마다 치른 모의고사 횟수는 다를 수 있습니다.
		모든 반의 학생과 각 학생이 치른 모의고사들의 점수를 출력하세요.
		위의 예제와 같이 클래스를 사용하여 코딩하세요.
		*/
		
		Student s1 = new Student("주영");
		s1.addMockTest(new mockTest(75, "2회차"));
		
		Student s2 = new Student("경우");
		s2.addMockTest(new mockTest(60, "1회차"));
		
		Student s3 = new Student("왕자");
		s3.addMockTest(new mockTest(80, "3회차"));
		
		
		List<Student> one = new ArrayList<>();
		one.add(s1);
		one.add(s3);
		List<Student> two = new ArrayList<>();
		two.add(s2);
		
		Grade className = new Grade();
		className.add("이삼정보고 사이버학과", one);
		className.add("이삼정보고 과학반", two);
		
		className.printAllClass();
		
		
		
	}

}
class Grade {
	private Map<String, List<Student>> mapClass;
	
	public Grade() {
		 mapClass = new HashMap<>();
	}
	
	public void add(String className, List<Student> s) {
		mapClass.put(className, s);
	}
	
	public void printAllClass() {
		System.out.println(" <이삼정보고 학과 학생별 점수 및 회차> ");
		for(Map.Entry<String, List<Student>> entry : mapClass.entrySet() ) {
			for(Student s : entry.getValue()) {
				System.out.print(entry.getKey() +"\n"+ s.getName());
				for(mockTest m : s.getMockTest()) {
					System.out.print(" =>" + m);
				}
				System.out.println("------");
			}
		}
	
	}
	
}
class Student {
	private String name;
	private List<mockTest> mockTest;
	
	public Student(String name) {
		this.name = name;
		mockTest = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public List<mockTest> getMockTest() {
		return mockTest;
	}

	public void addMockTest(mockTest mockTest) {
		this.mockTest.add(mockTest);
	}
	
	
}

class mockTest {
	private int score;
	private String num;
	
	public mockTest(int score, String num) {
		this.score = score;
		this.num = num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	public String toString() {
		return "점수 : " + score + "횟수: " + num; 
	}
	
}

