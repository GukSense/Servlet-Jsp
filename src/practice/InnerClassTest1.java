package practice;

//�̳�Ŭ����(����Ŭ����)
/*
		���� 1.
		�̳� Ŭ������ ����� ������ �ۼ��ϼ���.
		���� 2.
		�ƿ��� Ŭ������ �ν��Ͻ� ����, �̳� Ŭ������ �ν��Ͻ� ����, 
		�̳� Ŭ������ �޼ҵ峻 ���� ���� ��� �̸��� ���� �����ϰ� 
		������ ���� ����ϴ� �ڵ带 �ۼ��ϼ���.  
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
					introTitle = "[���帹�̼����ϴ�]";
					break;
				case CAFELATTE:
					introTitle = "[�������̳���]";
					break;
				case ICEDTEA:	
					introTitle = "[ī������ ���Ը԰������]";
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
		System.out.println("�̸�: " + this.getIntro() + title);
		System.out.println("(��������)����: " + this.price);
		System.out.println("ī�����Է�: " +this.getCaffeine());	
	}
	
	
}





public class InnerClassTest1 {
	public static void main(String[]args) {
		
		CafeDavinci davinci = new CafeDavinci();
		davinci.setTitle("�Ƹ޸�ī��");
		davinci.setPrice(3800);
		davinci.setMenu(CafeDavinci.SelectMenu.AMERICANO);
		davinci.print();
	
	}
}