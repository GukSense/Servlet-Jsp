package practice.test;

import java.util.Arrays;

public class StringBufferTest {

	public static void main(String[] args) {
		/*
		���� 1.
		String str = "�� �� �ϼ� ��, �ڹ� �⺻ ���� �� ��ǻ�� �п� �Դϴ�.";
		�� ���ڿ��� char[] Ÿ������ ��ȯ�ϼ���.
		StringBuffer�� �̿��� ���ڿ��� ����� ����ϼ���. 
		*/
		
		
		String str = "�� �� �ϼ� ��, �ڹ� �⺻ ���� �� ��ǻ�� �п� �Դϴ�.";
		StringBuffer st = new StringBuffer();
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			st.append(ch);
					
		}

		System.out.println(st);
	}

}
