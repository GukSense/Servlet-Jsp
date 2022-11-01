package practice.test;

import java.util.Arrays;

public class StringUtilsTest {

	public static void main(String[] args) {
		
		/*
		문제 1.
		동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세
		위 문장에서 substring 을 사용하여 "하느님이" 부터 끝까지 출력하세요.
		문제 2.
		위 문장을 split을 사용하여 공백을 기준으로 배열로 만든 뒤 
		배열의 맨 뒤에서 앞으로 요소들을 출력하세요.
		문제 3.
		동해물
		백두산
		두 문자열 중 더 큰 문자열을 출력하세요.
		힌트) compareTo를 사용하세요.
		*/
		
		String t1 = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
		System.out.println(t1.indexOf("하느님이"));
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
		System.out.println("동해물".compareTo("백두산"));
		test.compareTo("동해물", "백두산");
		
		

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