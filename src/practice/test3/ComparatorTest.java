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
		문제 1.
		학생들을 Comparator 를 이용해 정렬하여 출력하세요.
		번호 내림차순, 이름 오름차순으로 정렬하여 출력하세요.
		문제 2.
		번호 내림차순, 이름 내림차순으로 정렬하는 Comparator 를 이용해 출력하세요.
		Comparator 는 익명클래스로 작성하세요.
		문제 3.
		PriorityQueue에 책들을 입력하세요.
		Queue에서 책의 가격이 높은 책 부터 제거되도록 코딩하세요.
		Comparable을 이용해 가격이 높은 책부터 제거되도록 작성하세요. 
		Comparator를 이용해 가격이 낮은 책부터 제거되도록 코딩하세요.
		*/
		List<Student3> sList = new ArrayList<>();
		Collections.addAll(sList, new Student3("강국", 3),new Student3("동민", 2),new Student3("현빈", 4),new Student3("SeGu", 1),new Student3("INE", 1));
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
		Collections.addAll(books, new Book("자바문법", 1000), new Book("파이썬 문법", 1500), new Book("자바 컬렉션", 3000));
//		Collections.sort(books); // error
		
		
		PriorityQueue<Book> priorityQueueHighest = new PriorityQueue<>();
		Collections.addAll(priorityQueueHighest, new Book("자바문법", 1000), new Book("파이썬 문법", 1500), new Book("자바 컬렉션", 3000));
		
		while (!priorityQueueHighest.isEmpty()) {	//출처: https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
			Book b = priorityQueueHighest.poll();
            System.out.println("글 가격 : " + b.getPrice() + " 글 내용 : " + b.getTitle());
        }
		System.out.println();

		PriorityQueue<Book> priorityQueueLowest = new PriorityQueue<>(new DescendingPrice());
		Collections.addAll(priorityQueueLowest, new Book("자바문법", 1000), new Book("파이썬 문법", 1500), new Book("자바 컬렉션", 3000));
		while(!priorityQueueLowest.isEmpty()) {
			Book b = priorityQueueLowest.poll();
			System.out.println("글 가격 : " + b.getPrice() + " 글 내용 : " + b.getTitle());
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
		return "이름: " + name + " 번호: " + no;
	}
}