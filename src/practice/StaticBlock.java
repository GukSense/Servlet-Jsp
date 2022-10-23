package practice;

public class StaticBlock {

	public static void main(String[] args) {
		Cart.print();
		
		Book3 b1 = new Book3();
		Book3 b2 = new Book3("�ڹ��ʱ�ȭ ��");
		Book3 b3 = new Book3("�ڹ� static�� ���Ͽ�," + "����ǻ���п�");

		Cart.add(b1);
		Cart.add(b2);
		Cart.add(b3);
		
		Cart.print();
	}

}


class Cart {
	public static Book3[] books  = new Book3[5];
	private static int index;

	static {
		Book3 book = new Book3();
		book.setTitle("�������");
		book.setAuthor("�������");
		
		for (int i=0; i<books.length; i++) {
			books[i] = book;
		}
		System.out.println();
	}

	public static void print() {
		for(int i=0; i<books.length; i++) {
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
	private static int sequence  = 0;
	private int bookNo;
	
	{
		bookNo = sequence++;
		
	}
	
	Book3(){
		this("�������", "�������");
		//bookNo = ++sequence;
	}
	Book3(String title){
		this(title, "���ڹ̻�");
		//bookNo = ++sequence;
	}
	
	Book3(String title, String author){
		this.title = title;
		this.author = author;
		//bookNo = ++sequence;
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