package practice.test2;

public class superTest {

	public static void main(String[] args) {
		EBook2 eb = new EBook2();
		System.out.println("å�� ������ [" + eb.title +  "]�̰� ������ ���� [" + eb.fontColor + "]�Դϴ�.");
		
	}

}

class Book3 {
	 String title;
	 String author;
	 int price;
	
	public Book3(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	Book3() {
		
	}
	
}

class EBook2 extends Book3 {
	 String fontColor;
	
	
	public EBook2() {
		super("��� ����", "����ǻ����");
		this.fontColor = "��";
	}
}

/*
���� 1.
���� �������� �ۼ��� �θ� Ŭ������ �⺻ �����ڸ� ���ָ� ������ ������ �߻��մϴ�. 
super�� ����Ͽ� ������ ������ ���� �ʵ��� �����ϼ���. 
*/