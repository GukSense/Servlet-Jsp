package practice.test2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		BookService bs = new BookService();
		bs.addPage(new Page(0, "표지"));
		bs.addPage(new Page(1, "목차"));
		bs.addPage(new Page(2,"ArrayList"));
		bs.addPage(new Page(3,"LinkedList"));
		bs.addPage(new Page(4,"Queue"));
		bs.addPage(new Page(5,"Stack"));
	
		bs.viewPage();
		bs.move(3);
		bs.viewPage();
		bs.nextPage();
		bs.viewPage();
		bs.nextPage();
		bs.viewPage();
		
		bs.prevPage();
		bs.viewPage();
		bs.move(1);
		bs.viewPage();
		bs.prevPage();
		bs.viewPage();
		
	}

}

class BookService {
	private Stack<Page> stackPage;
	private List<Page> listPage;
	private int currentPageNo;
	
	public BookService() {
		stackPage = new Stack<>();
		listPage = new LinkedList<>();
	}
	public void addPage(Page p) {
		listPage.add(p);
	}
	public void viewPage() {
		System.out.println(listPage.get(currentPageNo));
	}
	public void move(int num) {
		stackPage.push(listPage.get(currentPageNo));
		currentPageNo = num;
	}
	public void prevPage() {
		Page p = stackPage.pop();
		currentPageNo = p.getNo();
	}
	public void nextPage() {
		stackPage.push(listPage.get(currentPageNo++));
	}
	
}

class Page {
	private int no;
	private String title;
	
	public Page(int no, String title) {
		this.no = no;
		this.title = title;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return no + "페이지 - " + title; 
	}
	
}