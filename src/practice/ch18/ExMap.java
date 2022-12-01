package practice.ch18;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExMap {

	public static void main(String[] args) {
		System.out.println("< ��A >");
		Map<String, String> teamA = new HashMap<>();
		teamA.put("A", "�ڹ�");
		teamA.put("B", "C");
		teamA.put("C", "���̽�");
		teamA.put("D", "�ڹ�");
		teamA.put("E", "�ڹ�");
		teamA.put("E", "DB");	// Ű �ߺ� �Ұ�
		for (Map.Entry<String, String> e : teamA.entrySet()) {
			System.out.println("�̸�: " + e.getKey() + "\t��ų: " + e.getValue());
		}
		System.out.println();
		
		System.out.println("< ��B >");
		Map<String, String> teamB = new HashMap<>();
		teamB.put("A","�ڹ�");
		teamB.put("C","���̽�");
		teamB.put("F","�ڹ�");
		teamB.put("G","�ȵ���̵�");
		teamB.put("H","IOS");
		teamB.put("I","�ȵ���̵�");
		for(Iterator<String> it = teamB.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			System.out.println("�̸�: " + key + "\t��ų: " + teamB.get(key));
		}
		System.out.println();
		
		System.out.println("< A + B ���� ��>");
		Map<String, String> employee = new HashMap<>();
		employee.putAll(teamA);
		employee.putAll(teamB);
		for(Map.Entry<String, String> e : employee.entrySet()) {
			System.out.println("�̸�: " + e.getKey() + "\t��ų: " + e.getValue());
		}
		System.out.println();
		
			
		System.out.println(" <�ȵ���̵� ������ �μ� �̵� �� ���� ��� >");
		Set<String> skill = Collections.singleton("�ȵ���̵�");	//�����Ұ���
		employee.values().removeAll(skill);
		System.out.println(employee.keySet());
		
		System.out.println("< C,F PL�� �Ҽӵ� �ִ� �� Ȯ�� >");
		Map<String, String> pl = new HashMap<>();
		pl.put("C", "���̽�");
		pl.put("F", "�ڹ�");
		System.out.println(employee.entrySet().containsAll(pl.entrySet()));
		System.out.println();
		
		System.out.println("< ��A�� B�� ������ ��� ���� �� Ȯ�� >");
		System.out.println(teamA.keySet().equals(teamB.keySet()));
		
		System.out.println("< ������ �ڹ�, �ڹٽ�ũ��Ʈ ��ų ���� ���� >");
		System.out.println(employee.containsValue("�ڹ�"));
		System.out.println(employee.containsValue("�ڹٽ�ũ��Ʈ"));
		
		//LinkedHashMap, TreeMap
	}

}
