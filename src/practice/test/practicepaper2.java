package practice.test;

public class practicepaper2 {
	
	public static void main(String[]args) {
		EBook2 book = new EBook2();
		book.setTitle("�ڹ� �˰���");
		book.setAuthor("����ǻ���п�");
		book.setTax(1.1f);
		book.setPrice(50000);
		book.setCountry(EBook2.TaxCalculator.USA);
		book.print();
		
		System.out.println();
		
		//EBook2.TaxCalculator clac = new TaxCalculaotr();
		EBook2.TaxCalculator calc1 = book.new TaxCalculator();
		EBook2.TaxCalculator calc2 = book.new TaxCalculator();
		calc1.calcName = "����1";
		calc2.calcName = "����2";
		System.out.println(calc1.calcName);
		System.out.println(calc2.calcName);
		
		
	}

}

class EBook2 {
	private String title;
	private String author;
	private int price;
	private float tax;
	private int country;
	private int amount;
	
	class TaxCalculator {
		public String calcName;
		private float tax;
		public static final int KOREA = 1;
		public static final int USA = 2;
		public static final int UK = 3;
		
		void setTotalPrice() {
			
			switch (country) {
				case KOREA:
					tax = 0f;
					break;
				case USA:
					tax = 0.1f;
					break;
				case UK:
					tax = 0.2f;
					break;
				default:
					tax = 0.3f;
			
			}
			
			EBook2.this.amount = (int)(price * (EBook2.this.tax + tax));
				
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(int price) {
		this.price = price;
		EBook2.TaxCalculator calc = this.new TaxCalculator();
		calc.setTotalPrice();
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public int getCountry() {
		return country;
	}

	public String getCountryString() {
		String str;
		
		switch(country) {
			case TaxCalculator.KOREA:
				str = "KOREA";
				break;
			case TaxCalculator.USA:
				str = "USA";
				break;
			case TaxCalculator.UK:
				str = "UK";
				break;
			default:
				str = "��Ÿ";
		}
		
		return str;
	}
	
	public void setCountry(int country) {
		this.country = country;
	}

	public int getAmount() {
		return amount;
	}

	public void print() {
		System.out.println("å�̸�: " + title);
		System.out.println("����: " + author);
		System.out.println("����: " + amount);
		System.out.println("�Ǹű���: " + getCountryString());
	}

}