package practice.test;

import java.util.Objects;

public class HashCodeTest {

	public static void main(String[] args) {
		
		
		/*
		문제 1.
		원하는 클래스를 만드세요.
		인스턴스 두 개를 생성하세요.
		hashCode 메소드를 오버라이딩하여 인스턴스 변수들의 값이 모두 같을 시 같은 해시코드를 반환하도록 코딩하세요. 
		*/
		Nba n1 = new Nba("댈러스 매버릭스", "루카 돈치치");
		Nba n2 = new Nba("댈러스 매버릭스", "루카 돈치치");
		Nba n3 = new Nba("덴버 너겟츠", "니콜라 요키치");
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