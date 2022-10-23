package practice;

public class Enum2 {
	public static void main(String[]args) {
		Book2 b1 = new Book2();
		b1.setCountry(Country2.KOREA);
		b1.setTitle("자바의정석 -기본편");
		b1.setAuthor("남궁성");
		b1.setPrice(25000);
		Book2.print(b1);
		
		Book2 b2 = new Book2();
		b2.setCountry(Country2.USA);
		b2.setTitle("Basic of Java");
		b2.setAuthor("남궁성");
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
문제 1.
장르 enum에 getString 메소드를 추가하세요.
메소드 호출 시 해당 장르를 한글로 리턴 하도록 코딩하고 출력하세요.
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
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println();
	}
	
}