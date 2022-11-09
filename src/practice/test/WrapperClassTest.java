package practice.test;

public class WrapperClassTest {

	public static void main(String[] args) {
		/*
		���� 1.
		int a = 3;
		int b = 7;
		Integer intgA;
		Integer intgB;
		a�� b�� ���� ���� intgA, intgB�� �ڵ��ϼ���.
		���� 2.
		intgA�� intgB�� ���� ���� �� int�� ��ȯ�Ͽ� ����ϼ���.
		���� 3.
		intgA�� intgB�� ���� compareTo�� �̿��Ͽ� ���ϰ� �� ū ���� ����ϼ���.
		���� 4.
		intgA �� intgB�� �ּҰ��� �ִ밪�� ���ϼ���.
		��Ʈ) max, min�� ����ϼ���.
		*/
		
	//����1
		int a = 3;
		int b = 7;
		Integer intgA = Integer.valueOf(a);
		Integer intgB = Integer.valueOf(b);
	//����2
		Integer sumA_B = intgA + intgB;
		System.out.println(sumA_B.intValue());
	//����3
		System.out.println(intgA.compareTo(intgB));
		Test12 t1 = new Test12();
		Test12.compareTo(intgA, intgB);
	//����4
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
				System.out.println("����");
		}
	}
}