package practice.ch15;

import java.util.ArrayList;
import java.util.List;



public class Ex03SubType {

	public static void main(String[] args) {
		//List<Content> musicList = new ArrayList<Music>();	// error
		List<Music> musicList = new ArrayList<Music>();
		musicList.add(new Music("�뷡1"));
		musicList.add(new Music("�뷡2"));
		
		//PECS: Producer Extend, Consumer super
		Player.play(musicList);
		
		Player.addRecommendedContent(musicList);
		Player.play(musicList);
		
		List<Content> contents = new ArrayList<>();
		contents.add(new Music("�뷡3"));
		contents.add(new Music("�뷡4"));

		Player.play(contents);
		
		List<Movie> movieList = new ArrayList<Movie>();
		System.out.println("test-----------");
		movieList.add(new Movie("��ȭ1"));
		movieList.add(new Movie("��ȭ2"));
		movieList.add(new Movie("��ȭ3"));
		Player.removeLastContents(movieList);
		Player.play(movieList);
		
		//Player.addRecommendedContent(movieList);	//error(1)
		//Player.play(movieList);
		
		Player.<Music>play(new Music("����1"));
		Player.play(new Movie("����1"));
	}

}

class Music implements Content {
	private String songTitle;
	private String songWriter;
	private String lyricist;
	
	
	public Music(String songTitle){
		this.songTitle = songTitle;
	}
	@Override
	public String getTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongWriter() {
		return songWriter;
	}
	public void setSongWriter(String songWriter) {
		this.songWriter = songWriter;
	}

	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
}
class Movie implements Content {
	private String title;
	private String writer;
	private String director;
	
	
	
	public Movie(String title) {
		this.title = title;
	}
	@Override
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
}
interface Content {
	public abstract String getTitle();
}
class Player {
	// ���׸��� �����ε� �ȵ�
	/*
	public static void play(List<Content> playList) {
		for (Content c : playList) {
			System.out.println("���: " + c.getTitle());
		}
	}
	
	public static void play(List<Music> playList) {
		for (Content c : playList) {
			System.out.println("���: " + c.getTitle());
		}
	}
	*/
	
	//Producer Extends (read)
	public static void play(List<? extends Content> playList) {
		for (Content c : playList) {
			System.out.println("���: " + c.getTitle());
		}
		System.out.println();
	}
	// playList.add(new Music("�뷡"));		// error
	// playList.add(new Movie("��ȭ"));		// error
	// ���׸����� ������ Ÿ�ӿ� ������ ���� �� �ֵ��� ���ݴϴ�.
	// Music Ÿ������ Movie Ÿ�������� ��Ÿ���� �ż��� �� �� �ֱ� ������ ���׸����� �̸� ������� �ʽ��ϴ�.
	
	// Consumer Super (write)
	public static void addRecommendedContent(List<? super Music> playList) {
		Music music = new Music("�ΰ�������õ����1");
		playList.add(music);
			
		// playList.add(new Movie("��ȭ1"));		// �����Ϸ��� ������ ��Ƴ� �� �ֽ��ϴ�.
			
	}
	// ���ѵ� Ÿ�� �Ķ����
		/*
		public static <T> void play(T content) {
			System.out.println(content.getTitle());	// error
		}
		*/
		public static <T extends Content> void play(T content) {
			System.out.println(content.getTitle());
			System.out.println();
		}
		
		public static void removeLastContents(List<? super Movie> contents) {
			contents.remove(contents.size()-1);
		}
}