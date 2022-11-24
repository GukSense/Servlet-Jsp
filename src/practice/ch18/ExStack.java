package practice.ch18;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ExStack {

	public static void main(String[] args) {
		Book book = new Book("�ڹ� �÷���");
		book.addPage(new Page(0, "ǥ��"));
		book.addPage(new Page(1, "����"));
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
		pageStack.push(pageList.get(currentPageNo++));	// push(E item) stack ���� �ֻ��� ������� item �� �ø��� (���� �켱������)
	}
	public void prevPage() {
		Page page = pageStack.pop();	// pop() �� ������ �� ���� �ִ� ��ü�� �����ϰ� �ش� ��ü�� �� �Լ��� ������ ��ȯ�մϴ�.
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
		return no + "������ - " + contents; 
	}
	
}