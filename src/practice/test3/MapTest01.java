package practice.test3;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {

	public static void main(String[] args) {

		
		
		Map<String, Integer> classNum1 = new HashMap<>();
		classNum1.put("민수", 90);
		classNum1.put("동재", 88);
		classNum1.put("대영", 75);
		classNum1.put("정훈", 100);
		
		System.out.println("1반");
		for(Map.Entry<String, Integer> entry : classNum1.entrySet()) {
			System.out.println("이름: " + entry.getKey() + "\t 점수: " + entry.getValue());
		}
		System.out.println();
		Map<String, Integer> classNum2 = new HashMap<>();
		classNum2.put("강국", 99);
		classNum2.put("동민", 80);
		classNum2.put("현빈", 77);
		classNum2.put("건주", 55);
		
		System.out.println("2반");
		for(Map.Entry<String, Integer> entry : classNum2.entrySet()) {
			System.out.println("이름: " + entry.getKey() + "\t 점수: " + entry.getValue());
		}
		System.out.println();
//		문제 1.
//		1반 학생들의 이름, 점수가 저장된 맵과 2반 학생들의 이름, 점수가 저장된 맵을 만드세요.
//		두 반의 모든 학생들을 중복 없이 출력하세요.
		Map<String, Integer> wholeOfClass = new HashMap<>();
		wholeOfClass.putAll(classNum1);
		wholeOfClass.putAll(classNum2);
		System.out.println("모든 반 학생들");
		for(Map.Entry<String, Integer> entry : wholeOfClass.entrySet()) {
			System.out.println("이름: " + entry.getKey() + "\t 점수: " + entry.getValue());
		}
		System.out.println();
//		문제 2.
//		점수가 90점 이상인 학생들을 맵에서 삭제 후 출력하세요.
		Map<String, Integer> removeMorethan90 = new HashMap<>();
		removeMorethan90.putAll(wholeOfClass);
		removeMorethan90.values().removeIf(m -> m >= 90);
		System.out.println("90점 이상 학생 삭제 후 리스트");
		for(Map.Entry<String, Integer> entry : removeMorethan90.entrySet()) {
			System.out.println("이름: " + entry.getKey() + "\t 점수: " + entry.getValue());
		}
		System.out.println();
		
//		문제 3.
//		55점인 학생 모두 맵에서 삭제하세요.
		wholeOfClass.values().remove(55);
		for(Map.Entry<String, Integer> entry : wholeOfClass.entrySet()) {
			System.out.println("이름: " + entry.getKey() + "\t 점수: " + entry.getValue());
		}
		
		/*
		문제 4.
		100점인 학생이 존재하는 지 출력하세요.
		*/
		
		System.out.println(wholeOfClass.containsValue(100));
		
	}
	
	
	

}



