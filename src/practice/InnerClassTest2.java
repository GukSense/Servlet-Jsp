package practice;

public class InnerClassTest2 {

	public static void main(String[] args) {
//		문제 2.
//		아우터 클래스의 인스턴스 변수, 이너 클래스의 인스턴스 변수, 
//		이너 클래스의 메소드내 지역 변수 모두 이름을 같게 설정하고 
//		각각의 값을 출력하는 코드를 작성하세요.  
		
		OuterClass outer = new OuterClass();
		outer.setCaffeine(126);
		outer.setPrice(4300);
		outer.setTitle("카페라떼");
		outer.print();
		
		OuterClass.InnerClass test = outer.new InnerClass();
		test.setTitle("아메리카노");
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
			System.out.println("이름: " + title);
			System.out.println("가격: " + price);
			System.out.println("카페인함량: " + caffeine);
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
		System.out.println("이름: " + title);
		System.out.println("가격: " + price);
		System.out.println("카페인함량: " + caffeine);
	} 
	
}