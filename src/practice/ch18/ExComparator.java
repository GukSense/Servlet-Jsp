package practice.ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExComparator {

	public static void main(String[] args) {
		List<Book4> books = new ArrayList<>();
		Collections.addAll(books, new Book4("�ڹٹ���", 1), new Book4("���̽� ����", 1), new Book4("�ڹ� �÷���", 3));

		System.out.println("< ��ȣ �������� ����, ���� �������� ����");
		Collections.sort(books, new AscendingNo());
		System.out.println(books);
		System.out.println();
		
		System.out.println("< ��ȣ �������� ����, ���� �������� ���� >");
		Collections.sort(books, new Comparator<Book4>() {
			public int compare(Book4 b1, Book4 b2) {
				int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo()) *-1;
					if(result == 0)
						result = b1.getTitle().compareTo(b2.getTitle()) *-1;
				return result;
			}
		});
		System.out.println(books);
		System.out.println();
		
		System.out.println("< Comparator.reverseOrder >");
		Collections.sort(books, Collections.reverseOrder());
		System.out.println(books);
		System.out.println();
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Z", "e", "a", "c", "b", "D");
		
		System.out.println("< ���Ĺ� �������� ���� >");
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);
		System.out.println();
		
		System.out.println("< ��ҹ��� ������� ���Ĺ� �������� ���� >");
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(list);
	
	}

}
class AscendingNo implements Comparator<Book4> {
	@Override
	public int compare(Book4 b1, Book4 b2) {
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
			if(result == 0)
			result = b1.getTitle().compareTo(b2.getTitle());
		return result;
	}
}

class DescendingTitle implements Comparator<Book4> {
	@Override
	public int compare(Book4 b1, Book4 b2) {
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
			if(result == 0)
			result = b1.getTitle().compareTo(b2.getTitle());
		return result;
	}
}

class Book4 implements Comparable<Book4>{
	private String title;
	private int no;
	
	public Book4(String title, int no) {
		this.no = no;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public int getNo() {
		return no;
	}
	@Override
	public int compareTo(Book4 b) {
		int result = Integer.valueOf(no).compareTo(b.getNo());
		if(result == 0)
		result = title.compareTo(b.getTitle());
	return result;
	}
	@Override
	public String toString() {
		return  "(" + no + ", " + title + ")";
	}
}