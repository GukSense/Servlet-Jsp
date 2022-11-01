package practice.test;

public class IndexOfTest {

	public static void main(String[] args) {
		/*
		���� 1.
		"�ȳ��ϼ���, ����#ǻ��@@�п� �Դϴ�.!~%"
		�� ���ڿ����� ,@!~%# ���ڸ� ������ �� ����ϴ� ���α׷��� �ڵ��ϼ���.
		���� 2.
		�� ���ڿ����� ������ ���� ī�����Ͽ� ����ϼ���.
		*/
		
		String t1 = "�ȳ��ϼ���, ����#ǻ��@@�п� �Դϴ�.!~%";
		String filter = ",@!~%#";
		String result = "";
		String target = " ";
		int pos = 0;
		int count = 0;
		
		for(int i=0; i<t1.length(); i++) {
			
			char ch = t1.charAt(i);
			
			if (filter.indexOf(ch) == -1) {
				result += String.valueOf(ch);
			}
			
		}
	
		while((pos = t1.indexOf(target, pos)) != -1) {
			pos += target.length(); 
			count++;
		}
			
		System.out.println(result);
		System.out.println(count);
	}

}
