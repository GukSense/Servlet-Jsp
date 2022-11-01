package practice.test;

import java.util.Arrays;

public class StringUtilsTest {

	public static void main(String[] args) {
		
		/*
		���� 1.
		���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮���� ����
		�� ���忡�� substring �� ����Ͽ� "�ϴ�����" ���� ������ ����ϼ���.
		���� 2.
		�� ������ split�� ����Ͽ� ������ �������� �迭�� ���� �� 
		�迭�� �� �ڿ��� ������ ��ҵ��� ����ϼ���.
		���� 3.
		���ع�
		��λ�
		�� ���ڿ� �� �� ū ���ڿ��� ����ϼ���.
		��Ʈ) compareTo�� ����ϼ���.
		*/
		
		String t1 = "���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮���� ����";
		System.out.println(t1.indexOf("�ϴ�����"));
		System.out.println(t1.substring(18));
		
		
		String[] arrStr = t1.split(" +");
		System.out.println(Arrays.toString(arrStr));
		
		for (int i=0; i<arrStr.length/2; i++) {
			String tmp = arrStr[i];
			arrStr[i] = arrStr[arrStr.length-i-1];
			arrStr[arrStr.length-i-1] = tmp;
		}
	
		System.out.println(Arrays.toString(arrStr));
	
		Test11 test = new Test11();
		System.out.println("���ع�".compareTo("��λ�"));
		test.compareTo("���ع�", "��λ�");
		
		

	}

}

class Test11 {
	public void compareTo(String a, String b) {
		int result = a.compareTo(b);
		if (result > 0)
			System.out.println(a);
		else if (result < 0)
			System.out.println(b);
	}
}