package practice.ch17;

public class ExSubType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	List <Content> musicList = new ArrayList<Music>();	//error
		
		List<Music> musicList = new ArrayList<Music>();
		musicList.add(new Music("�뷡1"));
		musicList.add(new Music("�뷡2"));
		
		// PECS: Producer Extends, Consumer super;
		Player.play(musicList);
		
		Player.addRecommendedContent(musicList);
		Player.play(musicList);
		
		List<Content> contents = new ArrayList<Content>();
		contents.add(new Music("�뷡3"));
		contetns.add(new Music("�뷡4"));
		
		Player.play(contents);
		
		Player.addRecommendedContent(contents);
		Player.play(contents);
		
		
		List<Movie> moviceList = new ArrayList<Movie>();
		movieList.add(new Movie("��ȭ1"));
		movieList.add(new Movie("��ȭ2"));
		
		Player.play(movieList);
		
		//Player.addRecommendedContent(movieList);	//error1(1)
		//Player.play(movieList);
		
		Player.<Music> play(new Music("����1"));
		player.play(new Movie("����1"));
	}

}

class Player {
	//���׸��� �����ε� �ȵ�

	/*
	 
	 * */
	
	
}

