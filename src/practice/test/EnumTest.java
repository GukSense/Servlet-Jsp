package practice.test;

public class EnumTest {
	public static void main(String[]args) {
		
	
	/*
	문제 1.
	책의 장르를 enum을 사용해 설정하고 출력하세요.
	*/
		
	Book2 b1 = new Book2();
	b1.setTitle("자바의정석 - 기초편");
	b1.setAuthor("남궁성");	
	b1.setPrice(25000);	
	b1.setBookGenre(BookGenre.EBOOK);
	Book2.print(b1);
	
	Book2 b2 = new Book2();
	b2.setTitle("자바의정석 - 기초편");
	b2.setAuthor("남궁성");	
	b2.setPrice(25000);	
	b2.setBookGenre(BookGenre.PAPER);
	Book2.print(b2);
	}
}

class Book2 {
	private String title;
	private String author;
	private int price;
	private BookGenre bookGenre;
	
	public String getTitle() {
		String newTitle;
		
		switch (bookGenre) {
		case EBOOK:
			newTitle = "[EBOOK]";
			break;
		case PAPER:
			newTitle = "[PAPER]";
			break;
		default:
			newTitle = "";
			
		}
		return newTitle + title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public BookGenre getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(BookGenre bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	public static void print(Book2 book) {
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println();
		
	}
	
	
}

enum BookGenre {
	EBOOK, PAPER
}