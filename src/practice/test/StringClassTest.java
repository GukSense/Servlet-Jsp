package practice.test;

public class StringClassTest {

	public static void main(String[] args) {
		/*
		���� 1.
		== �� equals �� ���̸� ������ �� �ִ� ������ �ۼ��ϼ���.
		*/
		
		//== �ּҸ� ��
		//equals �� ���ͷ����� ��

		String s1 = "Angel In-us";
		String s2 = "Angel In-us";
		
		System.out.println("===== <s1 & s2 > =====");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		String s3 = new String("Angel In-us");
		String s4 = new String("Angel In-us");
		
		System.out.println("===== <s3 & s4 > =====");
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
	}

}

