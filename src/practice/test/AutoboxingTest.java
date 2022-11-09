package practice.test;

public class AutoboxingTest {

	public static void main(String[] args) {
		/*
		문제 1.
		Integer intgA = 3;
		Integer intgB = 7;
		int sum = intgA + intgB;
		위 내용을 오토박싱과 오토언박싱이 필요 없는 코드로 수정하세요.
		*/
		
		Integer intgA = 3;
		Integer intgB = 7;
		
		int sum = intgA + intgB;
		// (int)(intgA.intValue() + intgB.intValue());
		System.out.println(sum);
		Integer intgA_B = intgA + intgB;
		System.out.println(intgA_B);
		intgA_B = Integer.valueOf(intgA.intValue() + intgB.intValue());
		System.out.println(intgA_B);
	}

}
