package practice.test4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ExReductionTest {

	public static void main(String[] args) {
		/*
		���� 1.
		�ڵ��� �ݾ��� ��հ��� ����ϼ���.
		���� 2.
		���� ���� �ڵ����� �ݾ��� ����ϼ���.
		���� 3.
		���� 10% �ΰ��� �ڵ��� ���� �Ѿ��� ����ϼ���.
		��Ʈ) reduce�� ����ϼ���.
		���� 4.
		�� ���� ����Ʈ�� ���� �� collect�� ����Ͽ� �����ϼ���.
		���յ� ����Ʈ�� ����ϼ���.
		*/
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("sonata", 2900));
		cars.add(new Car("Genesis G80", 5500));
		cars.add(new Car("Grandeur", 3600));
		cars.add(new Car("Avante N", 3200));
		cars.add(new Car("Equus", 7000));
		cars.add(new Car("Avante N", 400));
		/*
		���� 1.
		�ڵ��� �ݾ��� ��հ��� ����ϼ���.
		*/
		System.out.println("< ��հ� >");
		double average =
			cars  
				.stream()
				.mapToInt(Car::getPrice)
				.average()
				.getAsDouble();
		System.out.println(average);
		System.out.println();	
		/*
		���� 2.
		���� ���� �ڵ����� �ݾ��� ����ϼ���.
		*/
		System.out.println("< ��������ݾ� >");
		long theHighestPrice = 
				cars
					.stream()
					.mapToLong(Car::getPrice)
					.max()
					.getAsLong();
		System.out.println(theHighestPrice);
		System.out.println();
		/*
		���� 3.
		���� 10% �ΰ��� �ڵ��� ���� �Ѿ��� ����ϼ���.
		��Ʈ) reduce�� ����ϼ���.
		*/
		int sumPriceTax = 
				cars
					.stream()
					.mapToInt(Car::getPrice)
					.reduce(0, (a,b) -> a+(int)(b*1.1));	//Stream.reduce(init, accumulator) init = �ʱⰪ accumulator = (total , n) -> total + n
															//Stream.reduce(accumulator) �Լ��� Stream�� ��ҵ��� �ϳ��� �����ͷ� ����� �۾��� �����մϴ�.
		System.out.println(sumPriceTax);
		System.out.println();
		/*
		���� 4.
		�� ���� ����Ʈ�� ���� �� collect�� ����Ͽ� �����ϼ���.
		���յ� ����Ʈ�� ����ϼ���.
		*/
		//collect()�� Stream�� �����͸� ���� ���� ó���� �ϰ� ���ϴ� �ڷ������� ��ȯ�� �ݴϴ�
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
