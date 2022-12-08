package practice.test4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ExReductionTest {

	public static void main(String[] args) {
		/*
		문제 1.
		자동차 금액의 평균가를 출력하세요.
		문제 2.
		가장 높은 자동차의 금액을 출력하세요.
		문제 3.
		세금 10% 부가된 자동차 가격 총액을 출력하세요.
		힌트) reduce를 사용하세요.
		문제 4.
		두 개의 리스트를 생성 후 collect를 사용하여 병합하세요.
		병합된 리스트를 출력하세요.
		*/
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("sonata", 2900));
		cars.add(new Car("Genesis G80", 5500));
		cars.add(new Car("Grandeur", 3600));
		cars.add(new Car("Avante N", 3200));
		cars.add(new Car("Equus", 7000));
		cars.add(new Car("Avante N", 400));
		/*
		문제 1.
		자동차 금액의 평균가를 출력하세요.
		*/
		System.out.println("< 평균가 >");
		double average =
			cars  
				.stream()
				.mapToInt(Car::getPrice)
				.average()
				.getAsDouble();
		System.out.println(average);
		System.out.println();	
		/*
		문제 2.
		가장 높은 자동차의 금액을 출력하세요.
		*/
		System.out.println("< 가장높은금액 >");
		long theHighestPrice = 
				cars
					.stream()
					.mapToLong(Car::getPrice)
					.max()
					.getAsLong();
		System.out.println(theHighestPrice);
		System.out.println();
		/*
		문제 3.
		세금 10% 부가된 자동차 가격 총액을 출력하세요.
		힌트) reduce를 사용하세요.
		*/
		int sumPriceTax = 
				cars
					.stream()
					.mapToInt(Car::getPrice)
					.reduce(0, (a,b) -> a+(int)(b*1.1));	//Stream.reduce(init, accumulator) init = 초기값 accumulator = (total , n) -> total + n
															//Stream.reduce(accumulator) 함수는 Stream의 요소들을 하나의 데이터로 만드는 작업을 수행합니다.
		System.out.println(sumPriceTax);
		System.out.println();
		/*
		문제 4.
		두 개의 리스트를 생성 후 collect를 사용하여 병합하세요.
		병합된 리스트를 출력하세요.
		*/
		//collect()는 Stream의 데이터를 변형 등의 처리를 하고 원하는 자료형으로 변환해 줍니다
		//https://codechacha.com/ko/java8-stream-collect/
		System.out.println("< priceList >");
		List<Integer> priceList = 
				cars
					.stream()
					.map(Car::getPrice)
					.collect(
							() -> new ArrayList<Integer>(),
							(set, i) -> set.add(i),
							(set1, set2) -> set1.addAll(set2)
							);
		System.out.println(priceList);
		System.out.println();
		
		System.out.println("< priceList2 >");
		List<Integer> priceList2 = 
				cars
				.stream()
				.map(Car::getPrice)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(priceList2);
		System.out.println();
		
		System.out.println("< priceList3 >");
		List<Integer> priceList3 = 
				cars
					.stream()
					.map(Car::getPrice)
					.collect(Collectors.toList());
		System.out.println(priceList3);
		System.out.println();
		
		
	}

}
