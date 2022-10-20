package practice;

//이너클래스(내부클래스)
/*
		문제 1.
		이너 클래스를 사용한 예제를 작성하세요.
		문제 2.
		아우터 클래스의 인스턴스 변수, 이너 클래스의 인스턴스 변수, 
		이너 클래스의 메소드내 지역 변수 모두 이름을 같게 설정하고 
		각각의 값을 출력하는 코드를 작성하세요.  
 */


class CafeDavinci {
	private String title;
	private int price;
	private float tax;
	private int caffeine;
	private int menu;
	private String intro;
	
	CafeDavinci(){
		tax = 1.2f;
	}
	
	class SelectMenu {
		
		private String title;
		private int price;
		private float tax;
		private int caffeine;

		public static final int AMERICANO = 1;
		public static final int CAFELATTE = 2;
		public static final int ICEDTEA = 3;
		
		public void menuCaffeine() {
			
			switch (menu) {
				case AMERICANO:
					caffeine = 114;
					break;
				case CAFELATTE:
					caffeine  =	75;
					break;
				case ICEDTEA:	
					caffeine = 20;
					break;
				default:
					caffeine = 100;
					
			}	 
			CafeDavinci.this.caffeine = caffeine;
			
		}
	
		public void menuTitle() {
			String introTitle;
			switch (menu) {
				
				case AMERICANO:
					introTitle = "[가장많이선택하는]";
					break;
				case CAFELATTE:
					introTitle = "[우유향이나는]";
					break;
				case ICEDTEA:	
					introTitle = "[카페인이 적게먹고싶을땐]";
					break;
				default:
					introTitle =	"";
			}	
			
			CafeDavinci.this.intro = introTitle;
		}
		
		
	}
	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIntro() {
		CafeDavinci.SelectMenu intro1 = this.new SelectMenu();
		intro1.menuTitle();
		return intro;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		price = (int)(price * tax);
		this.price = price;
		
	}
	
	public int getCaffeine() {
		CafeDavinci.SelectMenu caffe = this.new SelectMenu();
		caffe.menuCaffeine();
		return caffeine;
	}

	
	
	public int getMenu() {
		return menu;
	}


	public void setMenu(int menu) {
		this.menu = menu;
	}


	public void print() {
		System.out.println("이름: " + this.getIntro() + title);
		System.out.println("(세금포함)가격: " + this.price);
		System.out.println("카페인함량: " +this.getCaffeine());	
	}
	
	
}





public class InnerClassTest1 {
	public static void main(String[]args) {
		
		CafeDavinci davinci = new CafeDavinci();
		davinci.setTitle("아메리카노");
		davinci.setPrice(3800);
		davinci.setMenu(CafeDavinci.SelectMenu.AMERICANO);
		davinci.print();
	
	}
}