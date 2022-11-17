package practice.ch17;

import java.util.ArrayList;
import java.util.List;

public class Ex02Generics {

	public static void main(String[] args) {
		BoardDefaultService service  = null;
		
		Board b1 = new Board();
		b1.setTitle("�ȳ��ϼ���.");
		b1.setContent("�� �����Դϴ�.");
		
		Board b2 = new Board();
		b2.setTitle("�ȳ��ϼ���");
		b2.setContent("�� �����Դϴ�.");
		
		List<Board> bList = new ArrayList<Board>();
		bList.add(b1);
		bList.add(b2);
		
		service = new BoardService();
		// service.printList(bList); 	// error
		service.printList2(bList);
		service.printList3(bList);
		
		System.out.println();
		
		Photo p1 = new Photo();
		p1.setTitle("����1 ����");
		p1.setContent("����1 ����");
		p1.setPhoto("a.jpg");
		
		Photo p2 = new Photo();
		p2.setTitle("����2 ����");
		p2.setContent("����2 ����");
		p2.setPhoto("b.jpg");
		
		List<Photo> pList = new ArrayList<Photo>();
		pList.add(p1);
		pList.add(p2);
		
		service = new PhotoService();
		// bs.printList(bList)	//error
		service.printList2(pList);
		service.printList3(pList);
		
	}
}

interface BoardDefaultService {
	
	public default void printList1(List<Object> boardList) {	// only List<Object>
		System.out.println("printList1");
		for (Object obj : boardList) {
			System.out.println(obj.toString());
			//	System.out.println(obj.getTitle());	//error
		}
		System.out.println();
	}
	
	public default void printList2(List<?> boardList) {
		System.out.println("printList2");
		for(Object obj : boardList) {
			System.out.println(obj.toString());
			//	System.out.println(obj.getTitle());
		}
		System.out.println();
	}	
	
	public abstract void printList3(List<?> boardList);
}

class BoardService implements BoardDefaultService {
	
	@Override
	public void printList3(List<?> boardList) {
		System.out.println("printList3");
		for(Object obj: boardList) {
			if(!(obj instanceof Board)) return;
			
			Board board = (Board)obj;
			
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println("-----");
		}
	}
}

class PhotoService implements BoardDefaultService {
	@Override
	public void printList3(List<?> boardList) {
		System.out.println("printList3");
		for(Object obj : boardList) {
			if(!(obj instanceof Photo)) return;
			
			Photo photo = (Photo)obj;
			
			System.out.println(photo.getTitle());
			System.out.println(photo.getContent());
			System.out.println(photo.getPhoto());
			System.out.println("-----");
		}
	}
}


class Board {
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + "]";
	}
		
}

class Photo extends Board {
	private String photo;
	
	public String getPhoto() {
		return photo;		
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Photo [title=" + getTitle() + ", content=" + getContent() + ", photo=" + photo + "]";
	}
	
}