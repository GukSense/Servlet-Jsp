package practice;

public class AnonymousClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book();
		b1.setTitle("�ڹ� �͸�Ŭ����");
		b1.setAuthor("����ǻ���п�");
		
		
		PrintService ps = new PrintServiceForPrinter();
		b1.printInfo(ps);
		
		b1.printInfo(new PrintService() {
			
			@Override
			public void print() {
				System.out.println("- FAX�� ���� -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}
			@Override
			public String print(Book book) {
				return "";
			}
		});
		
		b1.printInfo(new PrintService() {
			
			@Override
			public void print() {
				System.out.println("- �� �˸����� ���� -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}
			@Override
			public String print(Book book) {
				return "";
			}
		});
	}

}

/*
���� 1.
(1)�� å ������ ��µ� �� �ֵ��� �ڵ��ϼ���.
��Ʈ) �������̽��� print(Book book) �޼ҵ� �����ε��� �ʿ� �մϴ�.


���� 2.
Book Ŭ������ createBook �޼ҵ带 �߰��ϼ���.
Device �������̽��� �ۼ��ϼ���.
Device �������̽��� create �߻� �޼ҵ带 �����ϼ���. 
main �޼ҵ忡�� �͸�Ŭ������ ����Ͽ� "�̺� ����", "����å ����"�� ����ϼ���.
*/


interface PrintService {
	public abstract void print();
	public abstract String print(Book book);
}

class PrintServiceForPrinter implements PrintService {
	@Override
	public void print() {
		System.out.println("- �����ͷ� ��� -");
		// (1)
		System.out.println();
		System.out.println("å �ν��Ͻ��� �ʿ��մϴ�.");	
		System.out.println();
	}
	
	@Override
	public String print(Book book) {
		return book.title;
	}
}

class Book implements PrintService {
	String title;
	String author;
	
	
	
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



	public void printInfo(PrintService ps) {
		ps.print();
	}
	
	@Override
	public void print() {}
	@Override
	public String print(Book book) {
		return "����: " + book.title +  "����: " + book.author;
	}
	
}