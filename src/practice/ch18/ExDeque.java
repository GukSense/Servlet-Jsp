package practice.ch18;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExDeque {

	public static void main(String[] args) {
		Book2 book = new Book2("자바 컬렉션");
		book.addPage(new Page2(0, "표지"));
		book.addPage(new Page2(1, "목차"));
		book.addPage(new Page2(2, "ArrayList"));
		book.addPage(new Page2(3, "LinkedList"));
		book.addPage(new Page2(4, "Queue"));
		book.addPage(new Page2(5, "Stack"));
		
		book.nextPage();
		book.view();
		book.nextPage();
		book.view();
		book.nextPage();
		book.view();
		
		System.out.println();
		
		book.prevPage();
		book.view();
		book.prevPage();
		book.view();
		book.prevPage();
		book.view();
	}

}

class Book2 {
	
	private String title;
	private Deque<Page2> pageStack;
	private List<Page2> pageList;
	private int currentPageNo;
	
	public Book2(String title) {
		this.title = title;
		pageStack = new ArrayDeque<>();
		pageList = new LinkedList<>();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addPage(Page2 page) {
		pageList.add(page);
	}
	public void view() {
		System.out.println(pageList.get(currentPageNo));
	}
	public void nextPage() {
		pageStack.push(pageList.get(currentPageNo++));
	}
	public void prevPage() {
		Page2 p = pageStack.pop();
		currentPageNo = p.getNo();
	}
	
}

class Page2 {
	private String contents;
	private int no;
	
	public Page2(int no, String contents) {
		this.no = no;
		this.contents = contents;
	}

	public String getTitle() {
		return contents;
	}

	public void setTitle(String title) {
		this.contents = contents;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return no + "페이지" + "목차: " + contents;
	}
	
}