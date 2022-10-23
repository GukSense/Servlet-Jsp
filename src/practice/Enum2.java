package practice;

public class Enum2 {
	public static void main(String[]args) {
		Book2 b1 = new Book2();
		b1.setCountry(Country2.KOREA);
		b1.setTitle("�ڹ������� -�⺻��");
		b1.setAuthor("���ü�");
		b1.setPrice(25000);
		Book2.print(b1);
		
		Book2 b2 = new Book2();
		b2.setCountry(Country2.USA);
		b2.setTitle("Basic of Java");
		b2.setAuthor("���ü�");
		b2.setPrice(25000);
		Book2.print(b2);
		
		Book2 b3 = new Book2();
		b3.setCountry(Country2.ETC);
		b3.setTitle("Java Enum");
		b3.setAuthor("lcomputer");
		b3.setPrice(25000);
		Book2.print(b3);
	}
}

/*
���� 1.
�帣 enum�� getString �޼ҵ带 �߰��ϼ���.
�޼ҵ� ȣ�� �� �ش� �帣�� �ѱ۷� ���� �ϵ��� �ڵ��ϰ� ����ϼ���.
*/

class Book2{
	
	private String title;
	private String author;
	private int price;
	private Country2 country;
	
	//setter & getter Title
	public String getTitle() {
		
		return country.getString() + title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//setter & getter Author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// setter & getter Price
	public int getPrice() {
		return (int)(price * country.getRefundTax());
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// setter & getter Country
	public Country2 getCountry() {
		return country;
	}
	public void setCountry(Country2 country) {
		
		this.country = country;
	}
	
	
	public static void print(Book2 book) {
		System.out.println("����: " + book.getTitle());
		System.out.println("����: " + book.getAuthor());
		System.out.println("����: " + book.getPrice());
		System.out.println();
	}
	
}