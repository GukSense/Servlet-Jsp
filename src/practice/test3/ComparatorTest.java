package practice.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;





public class ComparatorTest {

	public static void main(String[] args) {
		/*
		���� 1.
		�л����� Comparator �� �̿��� �����Ͽ� ����ϼ���.
		��ȣ ��������, �̸� ������������ �����Ͽ� ����ϼ���.
		���� 2.
		��ȣ ��������, �̸� ������������ �����ϴ� Comparator �� �̿��� ����ϼ���.
		Comparator �� �͸�Ŭ������ �ۼ��ϼ���.
		���� 3.
		PriorityQueue�� å���� �Է��ϼ���.
		Queue���� å�� ������ ���� å ���� ���ŵǵ��� �ڵ��ϼ���.
		Comparable�� �̿��� ������ ���� å���� ���ŵǵ��� �ۼ��ϼ���. 
		Comparator�� �̿��� ������ ���� å���� ���ŵǵ��� �ڵ��ϼ���.
		*/
		List<Student3> sList = new ArrayList<>();
		Collections.addAll(sList, new Student3("����", 3),new Student3("����", 2),new Student3("����", 4),new Student3("SeGu", 1),new Student3("INE", 1));
		Collections.sort(sList, new DescendingTitle());
		System.out.println(sList);
		
		Collections.sort(sList, new Comparator<Student3>() {
			@Override
			public int compare(Student3 s1, Student3 s2) {
				int result = Integer.valueOf(s1.getNo()).compareTo(s2.getNo()) * -1;
					if(result ==  0)
						result = s1.getName().compareTo(s2.getName()) * -1;
					return result;
			}
		});
		System.out.println(sList);
		System.out.println();
		
		Queue<Book> books = new LinkedList<>();
		Collections.addAll(books, new Book("�ڹٹ���", 1000), new Book("���̽� ����", 1500), new Book("�ڹ� �÷���", 3000));
//		Collections.sort(books); // error
		
		
		PriorityQueue<Book> priorityQueueHighest = new PriorityQueue<>();
		Collections.addAll(priorityQueueHighest, new Book("�ڹٹ���", 1000), new Book("���̽� ����", 1500), new Book("�ڹ� �÷���", 3000));
		
		while (!priorityQueueHighest.isEmpty()) {	//��ó: https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
			Book b = priorityQueueHighest.poll();
            System.out.println("�� ���� : " + b.getPrice() + " �� ���� : " + b.getTitle());
        }
		System.out.println();

		PriorityQueue<Book> priorityQueueLowest = new PriorityQueue<>(new DescendingPrice());
		Collections.addAll(priorityQueueLowest, new Book("�ڹٹ���", 1000), new Book("���̽� ����", 1500), new Book("�ڹ� �÷���", 3000));
		while(!priorityQueueLowest.isEmpty()) {
			Book b = priorityQueueLowest.poll();
			System.out.println("�� ���� : " + b.getPrice() + " �� ���� : " + b.getTitle());
		}
		
	}

}
class AscendingNo implements Comparator<Student3> {
	@Override
	public int compare(Student3 s1, Student3 s2) {
		int result = Integer.valueOf(s1.getNo()).compareTo(s2.getNo()) * -1;
			if(result ==  0)
				result = s1.getName().compareTo(s2.getName());
			return result;
	}
}

class DescendingTitle implements Comparator<Student3> {
	@Override
	public int compare(Student3 s1, Student3 s2) {
		int result = Integer.valueOf(s1.getNo()).compareTo(s2.getNo())* -1;
			if(result ==  0)
				result = s1.getName().compareTo(s2.getName());
			return result;
	}
}

class DescendingPrice implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		int result = Integer.valueOf(b1.getPrice()).compareTo(b2.getPrice());					
			return result;
	}
} 
class Book implements Comparable<Book> {
	private String title;
	private int price;
	
	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}	
	public int getPrice() {
		return price;
	}
	@Override
	public int compareTo(Book b) {
		int result = Integer.valueOf(price).compareTo(b.getPrice()) * -1;
		
		return result;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	
	

	
}

class Student3 implements Comparable<Student3> {
	private String name;
	private int no;
	
	public Student3(String name, int no) {
		this.name = name;
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public int getNo() {
		return no;
	}
	
	@Override
	public int compareTo(Student3 s) {
		int result = Integer.valueOf(no).compareTo(s.getNo()) * -1;
			if(result == 0)
				name.compareTo(s.getName());
		return result;
	}
	@Override
	public String toString() {
		return "�̸�: " + name + " ��ȣ: " + no;
	}
}