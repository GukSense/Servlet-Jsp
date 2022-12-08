package practice.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		/*
		문제 1.
		스트림에 '가', '나', '다' 를 추가하는 코드를 작성하세요.
		 */
		System.out.println("<가,나,다 추가>");
		Stream<String> stream = Stream.of("가","나","다");
		stream.forEach(System.out::println);
		System.out.println();
		/*
		문제 2.
		스트림을 사용하여 1~100 사이의 숫자 중 난수 10개를 출력하세요.
		*/
		System.out.println("< 1~100 사이의 숫자 중 난수 10개를 출력 >");
		Stream<Integer> lottoStream = Stream.generate(()-> (int)(Math.random()*100)).limit(10);
		lottoStream.forEach(i -> System.out.print(i + ", "));
		System.out.println();
		/*
		문제 3.
		자동차 인스턴스 5개를 가진 배열을 만들고 스트림으로 변환하세요.
		500원 보다 비싼 차량들을 출력하세요.
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
		문제 4.
		자동차 이름을 중복 제거 후 출력하세요.
		 */
		System.out.println("< 중복제거 >");
		cars
			.stream()
			.distinct()
			.forEach(System.out::println);
		System.out.println();
		/*
		문제 5.
		자동차 인스턴스로 이뤄진 스트림을 자동차 금액들로만 이뤈진 스트림으로 변환 후 3개만 출력하세요.
		*/
		System.out.println("");
		cars
			.stream()
			.map(Car::getPrice)
			.limit(3)
			.forEach(System.out::println);
		System.out.println();
		
		/*
		문제 6.
		스트림에 저장된 자동차명의 모든 글자를 나누어 한 글자씩 출력하되 오름차순으로 정렬하여 출력하세요.
		힌트) flatMap, sorted 를 사용하세요.
		 */
		System.out.println("< 한 글자씩 출력 && 오름차순 >");
		cars
			.stream()
			.flatMap(c -> c.getTitle().chars().mapToObj(i-> (char)i))
			.sorted()
			.forEach(System.out::println);
		System.out.println();
		/*
		문제 7.
		스트림에서 특정 차량이름을 검색하여 출력하세요.
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
		return "차 이름: " + title + " 차 가격: " + price;
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