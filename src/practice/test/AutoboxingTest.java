package practice.test;

public class AutoboxingTest {

	public static void main(String[] args) {
		/*
		���� 1.
		Integer intgA = 3;
		Integer intgB = 7;
		int sum = intgA + intgB;
		�� ������ ����ڽ̰� �����ڽ��� �ʿ� ���� �ڵ�� �����ϼ���.
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
