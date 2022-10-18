package practice;

public class InnerClassTest2 {

	public static void main(String[] args) {
//		���� 2.
//		�ƿ��� Ŭ������ �ν��Ͻ� ����, �̳� Ŭ������ �ν��Ͻ� ����, 
//		�̳� Ŭ������ �޼ҵ峻 ���� ���� ��� �̸��� ���� �����ϰ� 
//		������ ���� ����ϴ� �ڵ带 �ۼ��ϼ���.  
		
		OuterClass outer = new OuterClass();
		outer.setCaffeine(126);
		outer.setPrice(4300);
		outer.setTitle("ī���");
		outer.print();
		
		OuterClass.InnerClass test = outer.new InnerClass();
		test.setTitle("�Ƹ޸�ī��");
		test.setPrice(3800);
		test.setCaffeine(114);
		test.print();
	
	}

}

class OuterClass {
	private String title;
	private int caffeine;
	private int price;
	
	class InnerClass {
		private String title;
		private int caffeine;
		private int price;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

		public int getCaffeine() {
			return caffeine;
		}
		public void setCaffeine(int caffeine) {
			this.caffeine = caffeine;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
		public void print() {
			System.out.println();
			System.out.println("�̸�: " + title);
			System.out.println("����: " + price);
			System.out.println("ī�����Է�: " + caffeine);
		} 
		
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCaffeine() {
		return caffeine;
	}
	public void setCaffeine(int caffeine) {
		this.caffeine = caffeine;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void print() {
		System.out.println("�̸�: " + title);
		System.out.println("����: " + price);
		System.out.println("ī�����Է�: " + caffeine);
	} 
	
}