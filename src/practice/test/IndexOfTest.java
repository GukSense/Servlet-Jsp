package practice.test;

public class IndexOfTest {

	public static void main(String[] args) {
		/*
		문제 1.
		"안녕하세요, 엘컴#퓨터@@학원 입니다.!~%"
		위 문자열에서 ,@!~%# 문자를 제거한 뒤 출력하는 프로그램을 코딩하세요.
		문제 2.
		위 문자열에서 공백의 수를 카운팅하여 출력하세요.
		*/
		
		String t1 = "안녕하세요, 엘컴#퓨터@@학원 입니다.!~%";
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
