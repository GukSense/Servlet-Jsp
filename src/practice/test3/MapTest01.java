package practice.test3;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {

	public static void main(String[] args) {

		
		
		Map<String, Integer> classNum1 = new HashMap<>();
		classNum1.put("�μ�", 90);
		classNum1.put("����", 88);
		classNum1.put("�뿵", 75);
		classNum1.put("����", 100);
		
		System.out.println("1��");
		for(Map.Entry<String, Integer> entry : classNum1.entrySet()) {
			System.out.println("�̸�: " + entry.getKey() + "\t ����: " + entry.getValue());
		}
		System.out.println();
		Map<String, Integer> classNum2 = new HashMap<>();
		classNum2.put("����", 99);
		classNum2.put("����", 80);
		classNum2.put("����", 77);
		classNum2.put("����", 55);
		
		System.out.println("2��");
		for(Map.Entry<String, Integer> entry : classNum2.entrySet()) {
			System.out.println("�̸�: " + entry.getKey() + "\t ����: " + entry.getValue());
		}
		System.out.println();
//		���� 1.
//		1�� �л����� �̸�, ������ ����� �ʰ� 2�� �л����� �̸�, ������ ����� ���� ���弼��.
//		�� ���� ��� �л����� �ߺ� ���� ����ϼ���.
		Map<String, Integer> wholeOfClass = new HashMap<>();
		wholeOfClass.putAll(classNum1);
		wholeOfClass.putAll(classNum2);
		System.out.println("��� �� �л���");
		for(Map.Entry<String, Integer> entry : wholeOfClass.entrySet()) {
			System.out.println("�̸�: " + entry.getKey() + "\t ����: " + entry.getValue());
		}
		System.out.println();
//		���� 2.
//		������ 90�� �̻��� �л����� �ʿ��� ���� �� ����ϼ���.
		Map<String, Integer> removeMorethan90 = new HashMap<>();
		removeMorethan90.putAll(wholeOfClass);
		removeMorethan90.values().removeIf(m -> m >= 90);
		System.out.println("90�� �̻� �л� ���� �� ����Ʈ");
		for(Map.Entry<String, Integer> entry : removeMorethan90.entrySet()) {
			System.out.println("�̸�: " + entry.getKey() + "\t ����: " + entry.getValue());
		}
		System.out.println();
		
//		���� 3.
//		55���� �л� ��� �ʿ��� �����ϼ���.
		wholeOfClass.values().remove(55);
		for(Map.Entry<String, Integer> entry : wholeOfClass.entrySet()) {
			System.out.println("�̸�: " + entry.getKey() + "\t ����: " + entry.getValue());
		}
		
		/*
		���� 4.
		100���� �л��� �����ϴ� �� ����ϼ���.
		*/
		
		System.out.println(wholeOfClass.containsValue(100));
		
	}
	
	
	

}



