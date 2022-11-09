package practice.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//List는 순서를 유지하는 데이터의 집합이다. 데이터의 중복이 허용되며 Vector, LinkedList, ArrayList 등이 있다.

public class List01 {

	public static void main(String[] args) {
		Book b1 = new Book("자바 기본문법", "엘컴퓨터학원");
		Book b2 = new Book("자바 자료구조", "엘컴퓨터학원");
		Book b3 = new Book("자바 알고리즘", "엘코딩연구소");
		
		Cart cart = new Cart();
		cart.add(b1);
		cart.add(b2);
		cart.add(2, b2);
		
		System.out.println(cart.checkForDuplicateBook(b1));
		Book b4 = new Book("파이썬 기본문법", "엘컴퓨터학원");
		System.out.println(cart.checkForDuplicateBook(b4));
		System.out.println();
		
		System.out.println(cart.getBook(1));
		System.out.println();
		
		List<Book> books = cart.getAllBooks();
		System.out.println(books.toString());
		System.out.println();
		
		Cart.printAllBooksWithFor(books);
		System.out.println();
		
		Cart.printAllBooksWithForEach(books);
		System.out.println();
		
		Cart.printAllBooksWithIterator(books);
		System.out.println();
		
		Cart.printAllBooksWithListIterator(books);
		System.out.println();
		
		Book[] arrBook = {
				new Book("파이썬 알고리즘", "엘컴퓨터학원"),
				new Book("파이썬 크롤링", "엘컴퓨터학원")
		};
		
		//List<Book> books2 = Arrays.asList(arrBook);	//UnsupportedOperationException
		List<Book> books2 = new ArrayList(Arrays.asList(arrBook));
		System.out.println(books2.toString());
		books2.addAll(books);//<Book> 의 모든 요소 추가?
		System.out.println(books);
		System.out.println();
		
		Cart.removeWithForEach(books2);
		Cart.removeWithIterator(books2);
	
	}

}

class Book {
	private String title;
	private String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author =  author;
	}

	public String getTitle() {
		return title;
	}
	

	public String getAuthor() {
		return author;
	}
	
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]"; 
	}
	
}

class Cart {
	private List<Book> books;
	
	public Cart() {
		books = new ArrayList<Book>(2);
	}
	
	public void add(Book book) {
		books.add(book);		
	}
	
	public void add(int index, Book book) {
		books.add(index, book);
	}
	
	public boolean checkForDuplicateBook(Book book) {
		return books.contains(book);	// contains() = > 목록에 지정된 요소가있으면 true 를 return 
	}
	
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	public Book getBook(int index) {
		return books.get(index);
	}
	
	public static void printAllBooksWithFor(List<Book> books) {
		System.out.println("for");
		for(int i=0; i<books.size(); i++) {
			Book book = books.get(i);
			System.out.println(book);
			
		}
	}
	/*
	Iterator의 장점
	1. 컬렉션에서 요소를 제어하는 기능
	2. next() 및 previous()를 써서 앞뒤로 이동하는 기능
	3. hasNext()를 써서 더 많은 요소가 있는지 확인하는 기능
	*/
	public static void printAllBooksWithIterator(List<Book> books) {
		System.out.println("Iterator");
		for (Iterator<Book> it = books.iterator(); it.hasNext();) {	//hasNext() => 읽어올 요소가 남아있으면 true  없으면 false
			System.out.println(it.next());	// next() 다음 요소를 반환
			
		}
	}
	//리스트는 또한 양방향으로 반복할 수 있는 iterator를 제공한다. for-each 반복문은 처음부터 끝까지만 반복된다
	public static void printAllBooksWithListIterator(List<Book> books) {
		System.out.println("ListIterator");
		System.out.println("next");
		ListIterator<Book> it = books.listIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
			}
		
		System.out.println("previous");
		
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}
	
	public static void printAllBooksWithForEach(List<Book> books) {
		System.out.println("ForEach");
		for (Book book : books) {	// 바이트 코드 변환 시 보일러 플레이트 최소화
			System.out.println(books);
		}
	}
	
	public static void removeWithForEach(List<Book> books) {
		try {
			for(Book book : books) {	// Iterable
				books.remove(book);
				System.out.println("삭제 : " + book);			
			}
		} catch(ConcurrentModificationException e) {
			System.out.println("Iterable은 삭제 기능을 지원하지 않습니다.\n");
		}
		
		System.out.println(books.toString());
	}
	
	public static void removeWithIterator(List<Book> books) {	 //iterator가 지원하는 경우 반복하는 동안 요소를 제거할 수 있다
		for (Iterator<Book> it = books.iterator(); it.hasNext();) {
			Book book = it.next();
			it.remove();
			System.out.println("삭제: " + book);
		}
		
		System.out.println(books.toString());
	}
}