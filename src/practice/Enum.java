package practice;

public class Enum {

	public static void main(String[] args) {
		Book1 b1 = new Book1();
		b1.setTitle("�ڹ� ������");
		b1.setAuthor("����ǻ���п�");
		b1.setPrice(30000);
		b1.setCountry(Country.KOREA);
		Book1.print(b1);
		
		Book1 b2 = new Book1();
		b2.setTitle("Java Enum");
		b2.setAuthor("lcomputerstudy");
		b2.setPrice(30000);
		b2.setCountry(Country.USA);
		Book1.print(b2);
		
		Country[] countries = Country.values(); //  values ->  enum�� ��ҵ��� ������� enumŸ���� �迭�� ����.  
		for(int i=0; i<countries.length; i++) {
			System.out.println("name: " + countries[i].name() + ", \tindex: " + countries[i].ordinal());	/*ordinal() ->  ���ҿ� ���ŵ� ������ ���� ������ ����
																											 *name() ->		ȣ��� ���� �̸��� String���� ����	*/
		}
	
	}

}


class Book1 {
	private String title;
	private String author;
	private int price;
	private Country  country;
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
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

	public int getPrice() {
		float tax =0f;
		int taxPrice = 0;
		
		switch(country) {
			
			case KOREA:
				tax = 1.1f;
				break;
			case USA:
				tax = 1.2f;		
				break;
			case UK:
				tax = 1.3f;
				break;
			default:
				tax = 1.5f;
		}
		taxPrice = (int)(price * tax);
		return taxPrice;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void print(Book1 book) {
		System.out.println("����: " + book.getTitle());
		System.out.println("����: " + book.getAuthor());
		System.out.println("����: " + book.getPrice());
		System.out.println();
	}

}


enum Country {
	KOREA, USA, UK
}