package practice.ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex01List {

	public static void main(String[] args) {
		/*
		���� 1.
		Book Ÿ�� �ν��Ͻ� 10���� �����Ͽ� �迭�� �����մϴ�.
		�迭�� ArrayList�� �����մϴ�.
		foreach ���� ����Ͽ� ����Ʈ�� ����� ��� å���� ����մϴ�.
		Book�� ���ڰ� ����ǻ���п��� ���� ������ ������ å�� ��� �����մϴ�.
		����Ʈ�� ���� �ִ� å���� ����մϴ�.
		��Ʈ) ���� �� foreach���� ���ܰ� �߻��� �� �ֽ��ϴ�.
		*/
	Book[] arrBook = {
			new Book("test1", 1000, "�谭��"),
			new Book("test2", 1500, "�Ȱ���"),
			new Book("test3", 2000, "�ִ뿵"),
			new Book("test4", 2500, "������"),
			new Book("test5", 3000, "����ȣ"),
			new Book("test6", 3500, "������"),
			new Book("test7", 4000, "����ǻ���п�"),
			new Book("test8", 4500, "����ǻ���п�"),
			new Book("test9", 5000, "�迵��"),
			new Book("test10", 6000, "�̿��"),
	};	
	
	List<Book> books = new ArrayList<>(Arrays.asList(arrBook));
	for(Book b: books) {
		System.out.println(b);
	}
	System.out.println();
	
	for(Iterator<Book> it = books.iterator(); it.hasNext();) {
		Book b = it.next();
		if((b.getAuthor()).equals("����ǻ���п�")) {
			it.remove();
			System.out.println("����: " + b); 
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