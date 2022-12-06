package practice.test4;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

// JS 기본 문법
// https://opentutorials.org/course/3332/21030

public class FunctionExam {

	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93));
	
	public static void printString( Function<Student, String> function ) {
		for (Student student : list) { // list에 저장된 항목만큼 루핑시킴
			System.out.print(function.apply(student) + " "); // 람다식 실행
		}
		
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<Student> function ) {
		for (Student student : list) { // List에 저장된 항목 수만큼 루핑
			System.out.print(function.applyAsInt(student) + " "); // 람다식 실행
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[학생 이름]");
		printString( t -> t.getName() );
		
		System.out.println("[영어 점수]");
		printInt(t -> t.getEngScore());
		
		System.out.println("[수학 점수]");
		printInt(t -> t.getMathScore());
	}
}

class Student {

	private String name;
	private int engScore;
	private int mathScore;

	public Student(String name, int engScore, int mathScore) {
		this.name = name;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEngScore() {
		return engScore;
	}

	public int getMathScore() {
		return mathScore;
	}
}