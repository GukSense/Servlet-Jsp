package practice;

//인터페이스

public class Interface {
	/*
	문제 1.
	상품들을 창고에 저장하고 창고에 저장된 상품들을 출력하세요.
	모든 상품을 창고에 저장할 수는 없습니다.
	창고에 저장될 재고의 정보는 상품명, 가격, 입고일자(String), 출고일자(String)
	힌트) 창고 클래스, 재고 인터페이스, 
	재고 인터페이스가 적용된 상품 클래스들, 재고들이 저장될 배열, instanceof 연산자를 통해 창고에 저장가능한 상품인지 아닌지를 구분할 수 있습니다. 
	
	문제 2.
	출고 기능을 코딩하세요.
	출고 메소드는 배열에 담겨 있는 해당 재고를 제거하는 방식으로 작성하세요.
	출고후 창고에 남아있는 재고의 정보를 출력하세요.
	*/
	public static void main(String[] args) {
		BookTest2 b1 = new BookTest2();
		b1.setTitle("DB란무엇인가?");
		b1.setAuthor("L.Academy");
		b1.setPrice(19800);
		b1.setReceivingDate("2022.10.17");
		b1.setForwardingDate("2022.10.22");
		
		EBookTest2 e1 = new EBookTest2();
		e1.setTitle("DB란무엇인가?");
		e1.setAuthor("L.Academy");
		e1.setPrice(19800);
		e1.setReceivingDate("2022.10.18");
		e1.setForwardingDate("2022.10.20");
		
		Music m1 = new Music();
		m1.setMusicTitle("dlwlrma");
		m1.setSinger("IU");
		m1.setMusicPrice(35000);
		m1.setReceivingDate("2022.10.19");
		m1.setForwardingDate("2022.10.24");
	
		Storage storage = new Storage();
		storage.add(b1);
		storage.add(e1);
		storage.add(m1);
		//System.out.println(storage.get());
		
		OrderService orderService = new OrderService();
		orderService.order(storage);
	
	}
}
//BookTest2 Object
class BookTest2 implements OrderItem {
	
	protected String title;
	protected String author;
	protected int price;
	protected String receivingDate;
	protected String forwardingDate;
	
	
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
		return price;
	}
	public void setPrice(int price) {
		if((price < 0 || price > 60000))
			return;
		this.price = price;
	}
	
	public String getReceivingDate() {
		return receivingDate;
	}
	public void setReceivingDate(String receivingDate) {
		this.receivingDate = receivingDate;
	}
	
	public String getForwardingDate() {
		return forwardingDate;
	}
	public void setForwardingDate(String forwardingDate) {
		this.forwardingDate = forwardingDate;
	}
	// implements OrderItem
	@Override
	public String getOrderTitle() {
		return getTitle();
	}
	@Override
	public int getOrderPrice() {
		return getPrice();
	}
	@Override
	public String getOrderReceivingDate() {
		return getReceivingDate();
	}
	@Override
	public String getOrderForwardingDate() {
		return getForwardingDate();
	}
}
//EBookTest2 Object
class EBookTest2 extends BookTest2 {
	private String fontColor;
	
	public void setPrice(int price) {
		price =(int)(price - (price * 0.2f));
		this.price = price;
	}
	public String getTitle() {
		return "[EBookTest2]" + title;
	}
	
	public String getFontColor() {
		return "[EBookTest2]" + fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
}

class Music implements OrderItem {
	
	private String musicTitle;
	private int musicPrice;
	private String singer;
	private String receivingDate;
	private String forwardingDate;
	
	
	
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	
	public int getMusicPrice() {
		return musicPrice;
	}
	public void setMusicPrice(int musicPrice) {
		this.musicPrice = musicPrice;
	}
	
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	public String getReceivingDate() {
		return receivingDate;
	}
	public void setReceivingDate(String receivingDate) {
		this.receivingDate = receivingDate;
	}
	
	public String getForwardingDate() {
		return forwardingDate;
	}
	public void setForwardingDate(String forwardingDate) {
		this.forwardingDate = forwardingDate;
	}
	// implements OrderItem
	@Override
	public String getOrderTitle() {
		return getMusicTitle();
	}
	@Override
	public int getOrderPrice() {
		return getMusicPrice();
	}
	@Override
	public String getOrderReceivingDate() {
		return getReceivingDate();
	}
	@Override
	public String getOrderForwardingDate() {
		return getForwardingDate();
	}

}

class Storage {
	OrderItem[] items;
	int index;
	
	public Storage() {
		items = new OrderItem[10];
		index = 0;
	}
	
	public void add(OrderItem item) {
		if (!(item instanceof OrderItem))
			return;
		items[index] = item;
		index++;
	}
	public OrderItem[] get() {
		return items; 
	}

}
class OrderService {
	public void order(Storage storage) {
		OrderItem[] items = storage.get();
		for (int i=0; i<items.length; i++) {
			if(items[i] == null)
				break;
			System.out.println(	//출고
							  "상품명: " + items[i].getOrderTitle() + "\n"
							+ "상품가격: " + items[i].getOrderPrice() + "\n"
							+ "입고일: " + items[i].getOrderReceivingDate() + "\n"
							+ "출고일: " + items[i].getOrderForwardingDate() + "\n"
					);
		}
	}
}

// interface OrderItem
interface OrderItem {
	public abstract String getOrderTitle();
	public abstract int getOrderPrice();
	public abstract String getOrderReceivingDate();
	public abstract String getOrderForwardingDate();
}

