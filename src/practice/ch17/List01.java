package practice.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//List�� ������ �����ϴ� �������� �����̴�. �������� �ߺ��� ���Ǹ� Vector, LinkedList, ArrayList ���� �ִ�.

public class List01 {

	public static void main(String[] args) {
		Book b1 = new Book("�ڹ� �⺻����", "����ǻ���п�");
		Book b2 = new Book("�ڹ� �ڷᱸ��", "����ǻ���п�");
		Book b3 = new Book("�ڹ� �˰���", "���ڵ�������");
		
		Cart cart = new Cart();
		cart.add(b1);
		cart.add(b2);
		cart.add(2, b2);
		
		System.out.println(cart.checkForDuplicateBook(b1));
		Book b4 = new Book("���̽� �⺻����", "����ǻ���п�");
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
				new Book("���̽� �˰���", "����ǻ���п�"),
				new Book("���̽� ũ�Ѹ�", "����ǻ���п�")
		};
		
		//List<Book> books2 = Arrays.asList(arrBook);	//UnsupportedOperationException
		List<Book> books2 = new ArrayList(Arrays.asList(arrBook));
		System.out.println(books2.toString());
		books2.addAll(books);//<Book> �� ��� ��� �߰�?
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
		return books.contains(book);	// contains() = > ��Ͽ� ������ ��Ұ������� true �� return 
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
	Iterator�� ����
	1. �÷��ǿ��� ��Ҹ� �����ϴ� ���
	2. next() �� previous()�� �Ἥ �յڷ� �̵��ϴ� ���
	3. hasNext()�� �Ἥ �� ���� ��Ұ� �ִ��� Ȯ���ϴ� ���
	*/
	public static void printAllBooksWithIterator(List<Book> books) {
		System.out.println("Iterator");
		for (Iterator<Book> it = books.iterator(); it.hasNext();) {	//hasNext() => �о�� ��Ұ� ���������� true  ������ false
			System.out.println(it.next());	// next() ���� ��Ҹ� ��ȯ
			
		}
	}
	//����Ʈ�� ���� ��������� �ݺ��� �� �ִ� iterator�� �����Ѵ�. for-each �ݺ����� ó������ �������� �ݺ��ȴ�
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
		for (Book book : books) {	// ����Ʈ �ڵ� ��ȯ �� ���Ϸ� �÷���Ʈ �ּ�ȭ
			System.out.println(books);
		}
	}
	
	public static void removeWithForEach(List<Book> books) {
		try {
			for(Book book : books) {	// Iterable
				books.remove(book);
				System.out.println("���� : " + book);			
			}
		} catch(ConcurrentModificationException e) {
			System.out.println("Iterable�� ���� ����� �������� �ʽ��ϴ�.\n");
		}
		
		System.out.println(books.toString());
	}
	
	public static void removeWithIterator(List<Book> books) {	 //iterator�� �����ϴ� ��� �ݺ��ϴ� ���� ��Ҹ� ������ �� �ִ�
		for (Iterator<Book> it = books.iterator(); it.hasNext();) {
			Book book = it.next();
			it.remove();
			System.out.println("����: " + book);
		}
		
		System.out.println(books.toString());
	}
}