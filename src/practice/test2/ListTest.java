package practice.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

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
		Box box = new Box();
		Book[] arrBook = {
				new Book("���������", "����"),
				new Book("�׶��̼�", "10cm"),
				new Book("Friends", "Lilboi")
		};
		
		List<Book> books = new ArrayList<Book>(Arrays.asList(arrBook));
		Box.printAllListWithForEach(books);
		

	}

}

class Book {
	private String title;
	private String singer;
	
	public Book(String title, String singer){
		this.title = title;
		this.singer = singer;		
	}
	
	public String toString() {
		return "[Ÿ��Ʋ: " + title + " ����: " + singer + "]";
	}
}

class Box {
	private List<Book> books;
	
	public Box(){
		books = new ArrayList<Book>(9);
	}
	public static void printAllListWithForEach(List<Book> books) {
		System.out.println("=== For Each ===");
		for (Book book : books) {
			System.out.println(books);
		}
			
	}
	

}