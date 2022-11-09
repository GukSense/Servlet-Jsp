package practice.test;

public class WrapperClassTest {

	public static void main(String[] args) {
		/*
		문제 1.
		int a = 3;
		int b = 7;
		Integer intgA;
		Integer intgB;
		a와 b의 값을 갖는 intgA, intgB를 코딩하세요.
		문제 2.
		intgA와 intgB의 값을 더한 뒤 int로 변환하여 출력하세요.
		문제 3.
		intgA와 intgB의 값을 compareTo를 이용하여 비교하고 더 큰 값을 출력하세요.
		문제 4.
		intgA 와 intgB의 최소값과 최대값을 구하세요.
		힌트) max, min을 사용하세요.
		*/
		
	//문제1
		int a = 3;
		int b = 7;
		Integer intgA = Integer.valueOf(a);
		Integer intgB = Integer.valueOf(b);
	//문제2
		Integer sumA_B = intgA + intgB;
		System.out.println(sumA_B.intValue());
	//문제3
		System.out.println(intgA.compareTo(intgB));
		Test12 t1 = new Test12();
		Test12.compareTo(intgA, intgB);
	//문제4
		System.out.println(Integer.max(intgA, intgB));
		System.out.println(Integer.min(intgA, intgB));
	}

}

class Test12 {
	public static void compareTo(Integer a, Integer b) {
		int	result = a.compareTo(b);
		switch (result) {
		
			case 1:
				System.out.println("IntgA > IntgB");
				break;
			case -1:
				System.out.println("IntgA < IntgB");
				break;
			case 0:
				System.out.println("IntgA == IntgB");
				break;
			default:
				System.out.println("오류");
		}
	}
}