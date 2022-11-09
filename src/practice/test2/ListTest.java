package practice.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		/*
		문제 1.
		Book 타입 인스턴스 10개를 생성하여 배열에 저장합니다.
		배열을 ArrayList로 변경합니다.
		foreach 문을 사용하여 리스트에 저장된 모든 책들을 출력합니다.
		Book의 저자가 엘컴퓨터학원인 것을 제외한 나머지 책은 모두 삭제합니다.
		리스트에 남아 있는 책들을 출력합니다.
		힌트) 삭제 시 foreach문은 예외가 발생될 수 있습니다.
		*/
		Box box = new Box();
		Book[] arrBook = {
				new Book("사건의지평선", "윤하"),
				new Book("그라데이션", "10cm"),
				new Book("Friends", "Lilboi")
		};
		
		List<Book> books = new ArrayList<Book>(Arrays.asList(arrBook));
		Box.printAllListWithForEach(books);
		

	}

}

class Book {
	private String title;
	private String singer;
	
	public Book(String title, String singer){
		this.title = title;
		this.singer = singer;		
	}
	
	public String toString() {
		return "[타이틀: " + title + " 저자: " + singer + "]";
	}
}

class Box {
	private List<Book> books;
	
	public Box(){
		books = new ArrayList<Book>(9);
	}
	public static void printAllListWithForEach(List<Book> books) {
		System.out.println("=== For Each ===");
		for (Book book : books) {
			System.out.println(books);
		}
			
	}
	

}