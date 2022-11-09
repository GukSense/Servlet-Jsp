package practice.test;

import java.util.Arrays;

public class StringBufferTest {

	public static void main(String[] args) {
		/*
		문제 1.
		String str = "안 녕 하세 요, 자바 기본 문법 엘 컴퓨터 학원 입니다.";
		위 문자열을 char[] 타입으로 변환하세요.
		StringBuffer를 이용해 문자열로 만들어 출력하세요. 
		*/
		
		
		String str = "안 녕 하세 요, 자바 기본 문법 엘 컴퓨터 학원 입니다.";
		StringBuffer st = new StringBuffer();
		
		for (int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			st.append(ch);
					
		}

		System.out.println(st);
	}

}
