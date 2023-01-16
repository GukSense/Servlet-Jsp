package practice.ch09;

public class Ex01Upcasting {

	public static void main(String[] args) {
		Book book = null; 
		book = new Book();
		book.setTitle("�ڹ� �⺻����");
		System.out.println(book.getTitle());
		
		book = new EBook();			// ��ĳ����
		book.setFontColor("��");
		System.out.println(book.getFontColor());
		book.setTitle("�ڹ� �ڷᱸ��");
		System.out.println(book.getTitle());
		
		book = new AudioBook();
		book.setTitle("���̳�");
		System.out.println(book.getTitle());
	}

}

class Book {
	private String title;
	private String fontColor;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	public String getFontColor() {
		return fontColor;
	}
}

class EBook extends Book{
	private String fontColor;
	
	@Override
	public String getFontColor() {
		return fontColor;
	}
	@Override
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
	@Override
	public void setTitle(String title) {
		title = "[EBOOK]" + title;
		super.setTitle(title);
	}
}
class AudioBook extends Book {
	
	@Override
	public void setTitle(String title) {
		title = "[Audio]" + title;
		super.setTitle(title);
	}
}

/*
���� 1.
book.setFontColor("��") �ڵ忡�� ������ ������ ���� �ʵ��� ������ �ּ���.
���� 2.
Book�� �ڽ� Ŭ������ AudioBook Ŭ������ �߰��� �ּ���.
��ĳ������ �̿��� AudioBook Ŭ������ Ư�� �޼ҵ带 ȣ���ϴ� �ڵ带 �ۼ��ϼ���. 
*/