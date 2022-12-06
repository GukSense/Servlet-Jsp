package practice.test4;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

// JS �⺻ ����
// https://opentutorials.org/course/3332/21030

public class FunctionExam {

	private static List<Student> list = Arrays.asList(
			new Student("ȫ�浿", 90, 96),
			new Student("�ſ��", 95, 93));
	
	public static void printString( Function<Student, String> function ) {
		for (Student student : list) { // list�� ����� �׸�ŭ ���ν�Ŵ
			System.out.print(function.apply(student) + " "); // ���ٽ� ����
		}
		
		System.out.println();
	}
	
	public static void printInt( ToIntFunction<Student> function ) {
		for (Student student : list) { // List�� ����� �׸� ����ŭ ����
			System.out.print(function.applyAsInt(student) + " "); // ���ٽ� ����
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("[�л� �̸�]");
		printString( t -> t.getName() );
		
		System.out.println("[���� ����]");
		printInt(t -> t.getEngScore());
		
		System.out.println("[���� ����]");
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