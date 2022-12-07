package practice.ch19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExStream {

	public static void main(String[] args) {
		System.out.println("< of >");
		Stream<String> stream = Stream.of("hi","hello","�ȳ��ϼ���");
		stream.forEach(str -> System.out.print(str + ", "));
		System.out.println("\n");
		
		System.out.println("< generate >");
		Stream<Integer> lottoStream = Stream.generate(() -> (int)(Math.random()*45) +1 ).limit(6);
		lottoStream.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< iterate >");
		Stream 
			.iterate(1, i -> i+1)
			.limit(45)
			.forEach(i -> System.out.print(i + ", "));
		System.out.println("\n");
		
		System.out.println("< IntStream >");
		IntStream intStream = new Random()
				.ints(1, 45)
				.limit(6);
		intStream.forEach(System.out::println);
		System.out.println();
		
		List<EBook> ebooks = new ArrayList<>();
		ebooks.add(new EBook("�ڹ� �⺻����", 50000, EBook.Category.LANG));
		ebooks.add(new EBook("�ڹ� �˰���", 30000, EBook.Category.APP));
		ebooks.add(new EBook("���̽� �⺻����", 35000, EBook.Category.LANG));
		ebooks.add(new EBook("���̽� �⺻����", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("���̽� �⺻����", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("������", 40000, EBook.Category.APP));
		//ebooks.add(new EBook("�����ͺ��̽�" , 50000, EBook.Category.APP));
		
		System.out.println("< forEach >");
		ebooks
			.stream()
			.forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("< filter >");
		// �������������� �������� ���ϰ� �������� �� ���͸� �� ��µ˴ϴ�.
		ebooks
			.stream()
			.filter(b-> b.getCategory().equals(EBook.Category.LANG))	// �߰����� (intermediate operation)
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< findFirst >");
		Optional<EBook> findFirstEB = 
				ebooks
					.stream()
					.filter(eb -> eb.getTitle().startsWith("�ڹ�"))
					.findFirst();
		System.out.println(findFirstEB);
		System.out.println(findFirstEB.get());
		System.out.println();
		
		System.out.println("< anyMatch >");
		boolean isMatched = 
				ebooks
					.stream()
					.anyMatch(eb -> eb.getTitle().startsWith("�ڹ�"));
		System.out.println(isMatched);
		System.out.println();
					
		System.out.println("< noneMatch >");
		boolean isMatched3 = 
				ebooks 
					.stream()
					.noneMatch(eb -> eb.getTitle().startsWith("��"));
		System.out.println(isMatched3);
		System.out.println();
		
		System.out.println("< limit >");
		// �������������� �������� ���ϰ� �������� �� ���͸� �� ��µ˴ϴ�.
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.limit(2)
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< distinct >");
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.distinct()
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println();
		
		System.out.println("< map >");
		ebooks 
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.map(EBook::getTitle)	//b -> b.getTitle()
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< peek >");
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.peek(b -> System.out.println("peek1 -> " + b))
			.map(EBook::getTitle)	//b-> b.getTitle()
			.peek(s -> System.out.println("peek2 -> " + s))
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< flatMap >");
		Stream<String> stream2 = Stream.of("A:90", "B:80", "C:100");
		stream2 
			.flatMap(s-> Arrays.asList(s.split(":")).stream())
			.forEach(System.out::println);
		System.out.println();
	}

}

class EBook implements Comparable<EBook> {
	public enum Category {
		LANG, APP
	}
	private String title;
	private int price;
	private Category category;
	
	public EBook(String title, int price, Category category) {
		this.title = title;
		this.price = price;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return "[title=" + title + ", price=" + price + ", category=" + category + "]";
	}
	@Override
	public int compareTo(EBook ebook) {
		return title.compareTo(ebook.getTitle());
	}
	@Override
	public int hashCode() {
		return Objects.hash(title, price, category);
	}
	@Override
	public boolean equals(Object o ) {
		if(!(o instanceof EBook))
			return false;
		EBook eb = (EBook)o;
		return title.equals(eb.getTitle())&&(price == eb.getPrice()) && category.equals(eb.getCategory());
	}
	
}