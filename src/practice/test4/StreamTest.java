package practice.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		/*
		���� 1.
		��Ʈ���� '��', '��', '��' �� �߰��ϴ� �ڵ带 �ۼ��ϼ���.
		 */
		System.out.println("<��,��,�� �߰�>");
		Stream<String> stream = Stream.of("��","��","��");
		stream.forEach(System.out::println);
		System.out.println();
		/*
		���� 2.
		��Ʈ���� ����Ͽ� 1~100 ������ ���� �� ���� 10���� ����ϼ���.
		*/
		System.out.println("< 1~100 ������ ���� �� ���� 10���� ��� >");
		Stream<Integer> lottoStream = Stream.generate(()-> (int)(Math.random()*100)).limit(10);
		lottoStream.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		/*
		���� 3.
		�ڵ��� �ν��Ͻ� 5���� ���� �迭�� ����� ��Ʈ������ ��ȯ�ϼ���.
		500�� ���� ��� �������� ����ϼ���.
		*/
		System.out.println("< Remove more than 500 >");
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("sonata", 2900));
		cars.add(new Car("Genesis G80", 5500));
		cars.add(new Car("Grandeur", 3600));
		cars.add(new Car("Avante N", 3200));
		cars.add(new Car("Equus", 7000));
		cars.add(new Car("Avante N", 400));
		
		cars  
			.stream()
			.filter(c -> c.getPrice() > 500)
			.forEach(System.out::println);
		System.out.println();
		/*
		���� 4.
		�ڵ��� �̸��� �ߺ� ���� �� ����ϼ���.
		 */
		System.out.println("< �ߺ����� >");
		cars
			.stream()
			.distinct()
			.forEach(System.out::println);
		System.out.println();
		/*
		���� 5.
		�ڵ��� �ν��Ͻ��� �̷��� ��Ʈ���� �ڵ��� �ݾ׵�θ� �̏��� ��Ʈ������ ��ȯ �� 3���� ����ϼ���.
		*/
		System.out.println("");
		cars
			.stream()
			.map(Car::getPrice)
			.limit(3)
			.forEach(System.out::println);
		System.out.println();
		
		/*
		���� 6.
		��Ʈ���� ����� �ڵ������� ��� ���ڸ� ������ �� ���ھ� ����ϵ� ������������ �����Ͽ� ����ϼ���.
		��Ʈ) flatMap, sorted �� ����ϼ���.
		 */
		System.out.println("< �� ���ھ� ��� && �������� >");
		cars
			.stream()
			.flatMap(c -> c.getTitle().chars().mapToObj(i-> (char)i))
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		/*
		���� 7.
		��Ʈ������ Ư�� �����̸��� �˻��Ͽ� ����ϼ���.
		*/
		cars
			.stream()
			.filter(c -> c.getTitle().startsWith("G"))
			.forEach(System.out::println);
		System.out.println();
	}

}

class Car {
	private String title;
	private int price;
	
	public Car(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "�� �̸�: " + title + " �� ����: " + price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Car))
			return false;
		Car car = (Car)o;
		
		return title.equals(car.getTitle());
	}

}