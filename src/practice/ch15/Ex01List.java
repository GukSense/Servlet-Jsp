package practice.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex01List {

	public static void main(String[] args) {
		/*
		문제 1.
		Book 타입 인스턴스 10개를 생성하여 배열에 저장합니다.
		배열을 ArrayList로 변경합니다.
		foreach 문을 사용하여 리스트에 저장된 모든 책들을 출력합니다.
		Book의 저자가 엘컴퓨터학원인 것을 제외한 나머지 책은 모두 삭제합니다.
		리스트에 남아 있는 책들을 출력합니다.
		힌트) 삭제 시 foreach문은 예외가 발생될 수 있습니다.
		*/
	Book[] arrBook = {
			new Book("test1", 1000, "배강국"),
			new Book("test2", 1500, "안건주"),
			new Book("test3", 2000, "최대영"),
			new Book("test4", 2500, "류정훈"),
			new Book("test5", 3000, "권태호"),
			new Book("test6", 3500, "송현빈"),
			new Book("test7", 4000, "엘컴퓨터학원"),
			new Book("test8", 4500, "엘컴퓨터학원"),
			new Book("test9", 5000, "김영재"),
			new Book("test10", 6000, "이용빈"),
	};	
	
	List<Book> books = new ArrayList<>(Arrays.asList(arrBook));
	for(Book b: books) {
		System.out.println(b);
	}
	System.out.println();
	
	for(Iterator<Book> it = books.iterator(); it.hasNext();) {
		Book b = it.next();
		if((b.getAuthor()).equals("엘컴퓨터학원")) {
			it.remove();
			System.out.println("삭제: " + b); 
		}				
	}
	System.out.println();

	for(Book b: books) {
		System.out.println(b);
	}
	
 		

	}

}

class Book {
	private String title;
	private int price;
	private String author;
	
	public Book(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Title -> " + title + ", Price -> " + price + ", Author -> " + author;		
	}	
}