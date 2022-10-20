package practice;

//�������̽�

public class Interface {
	/*
	���� 1.
	��ǰ���� â�� �����ϰ� â�� ����� ��ǰ���� ����ϼ���.
	��� ��ǰ�� â�� ������ ���� �����ϴ�.
	â�� ����� ����� ������ ��ǰ��, ����, �԰�����(String), �������(String)
	��Ʈ) â�� Ŭ����, ��� �������̽�, 
	��� �������̽��� ����� ��ǰ Ŭ������, ������ ����� �迭, instanceof �����ڸ� ���� â�� ���尡���� ��ǰ���� �ƴ����� ������ �� �ֽ��ϴ�. 
	
	���� 2.
	��� ����� �ڵ��ϼ���.
	��� �޼ҵ�� �迭�� ��� �ִ� �ش� ��� �����ϴ� ������� �ۼ��ϼ���.
	����� â�� �����ִ� ����� ������ ����ϼ���.
	*/
	public static void main(String[] args) {
		BookTest2 b1 = new BookTest2();
		b1.setTitle("DB�������ΰ�?");
		b1.setAuthor("L.Academy");
		b1.setPrice(19800);
		b1.setReceivingDate("2022.10.17");
		b1.setForwardingDate("2022.10.22");
		
		EBookTest2 e1 = new EBookTest2();
		e1.setTitle("DB�������ΰ�?");
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
			System.out.println(	//���
							  "��ǰ��: " + items[i].getOrderTitle() + "\n"
							+ "��ǰ����: " + items[i].getOrderPrice() + "\n"
							+ "�԰���: " + items[i].getOrderReceivingDate() + "\n"
							+ "�����: " + items[i].getOrderForwardingDate() + "\n"
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

