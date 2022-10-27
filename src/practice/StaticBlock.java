package practice;

public class StaticBlock {

	public static void main(String[] args) {
		
		Cart.print();
		
		Book3 b1 = new Book3();
		Book3 b2 = new Book3("자바 초기화 블럭");
		Book3 b3 = new Book3("자바 static에 대하여", "엘컴퓨터학원");
	
		Cart.add(b1);
		Cart.add(b2);
		Cart.add(b3);
		
		Cart.print();
		
	}

}

class Cart {
	private static Book3[] books = new Book3[5];
	private static int index = 0;
	
	static {
		Book3 b1 = new Book3();
		b1.setTitle("비어있음");
		b1.setAuthor("비어있음");
		
		for(int i=0; i<books.length; i++) {
			books[i] = b1;
		}

	}
	
	public static void print() {
		for (int i=0; i<books.length; i++) {
			books[i].print();
		}
		System.out.println();
	}
	
	public static void add(Book3 book) {
		books[index] = book;
		index++;
	}

}
class Book3 {
	private String title;
	private String author;
	private static int sequence;
	private int bookNo;
	{
		bookNo = ++sequence;
	}

	Book3(){
		this("null", "null");
	}
	
	Book3(String title){
		this(title, "null");
	}
	
	Book3(String title, String author){
		this.title = title;
		this.author = author;
	}
//setter getter Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//setter getter Author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void print() {
		System.out.println(bookNo + ", " + title + ", " + author);
	}
	
}

