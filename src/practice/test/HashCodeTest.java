package practice.test;

import java.util.Objects;

public class HashCodeTest {

	public static void main(String[] args) {
		
		
		/*
		���� 1.
		���ϴ� Ŭ������ ���弼��.
		�ν��Ͻ� �� ���� �����ϼ���.
		hashCode �޼ҵ带 �������̵��Ͽ� �ν��Ͻ� �������� ���� ��� ���� �� ���� �ؽ��ڵ带 ��ȯ�ϵ��� �ڵ��ϼ���. 
		*/
		Nba n1 = new Nba("��� �Ź�����", "��ī ��ġġ");
		Nba n2 = new Nba("��� �Ź�����", "��ī ��ġġ");
		Nba n3 = new Nba("���� �ʰ���", "���ݶ� ��Űġ");
		System.out.println(n1.hashCode());
		System.out.println(n2.hashCode());
		System.out.println(n3.hashCode());
		
		System.out.println(System.identityHashCode(n1));
		System.out.println(System.identityHashCode(n2));
		System.out.println(System.identityHashCode(n3));
		
	}

}


class Nba {
	private String teamName;
	private String player;
	
	public Nba(String teamName, String player) {
		this.teamName = teamName;
		this.player = player;
	}
	
	public int hashCode() {
		return Objects.hash(teamName, player);
		
	}
	
}