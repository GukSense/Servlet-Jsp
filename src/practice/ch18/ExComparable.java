package practice.ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExComparable {
	public static void main(String[]args) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Z","b","a","g","E");
		Collections.sort(list);
		System.out.println(list);
		
		List<Book3> books = new ArrayList<>();
		Collections.addAll(books, new Book3(1, "자바 문법"), new Book3(1, "파이썬 문법"), new Book3(3, "자바 컬렉션"));
		Collections.sort(books);
		System.out.println(books);
	}
}

class Book3 implements Comparable<Book3> {
	private int no;
	private String title;
	
	public Book3(int no, String title) {
		this.no = no;
		this.title = title;
	}
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public int compareTo(Book3 book) {
		int result = Integer.valueOf(no).compareTo(book.no) * -1;
			if(result == 0)
				title.compareTo(getTitle());
		return result;
	}
	@Override
	public String toString() {
		return "(" + no + ", " + title + ")";
	}
}