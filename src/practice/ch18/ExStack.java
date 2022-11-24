package practice.ch18;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ExStack {

	public static void main(String[] args) {
		Book book = new Book("자바 컬렉션");
		book.addPage(new Page(0, "표지"));
		book.addPage(new Page(1, "목차"));
		book.addPage(new Page(2, "ArrayList"));
		book.addPage(new Page(3, "LinkedList"));
		book.addPage(new Page(4, "Queue"));
		book.addPage(new Page(5, "Stack"));
		
		book.view();
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

class Book {
	private String title;
	private Stack<Page> pageStack;
	private List<Page> pageList;
	private int currentPageNo;
	
	public Book(String title) {
		this.title = title;
		this.pageStack = new Stack<>();
		this.pageList = new LinkedList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Page> getPageList() {
		return pageList;
	}

	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}
	
	public void addPage(Page page) {
		pageList.add(page);
	}
	public void nextPage() {
		pageStack.push(pageList.get(currentPageNo++));	// push(E item) stack 제일 최상위 상단으로 item 을 올린다 (제일 우선순위로)
	}
	public void prevPage() {
		Page page = pageStack.pop();	// pop() 이 스택의 맨 위에 있는 개체를 제거하고 해당 개체를 이 함수의 값으로 반환합니다.
		currentPageNo = page.getNo();
	}
	public void view() {
		System.out.println(pageList.get(currentPageNo));
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
}

class Page {
	private int no;
	private String contents;
	
	public Page(int no, String contents) {
		this.no = no;
		this.contents = contents;
	}
	public int getNo() {
		return no;
	}
	public String getContent() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return no + "페이지 - " + contents; 
	}
	
}