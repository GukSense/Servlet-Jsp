package practice.ch17;

public class ExSubType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	List <Content> musicList = new ArrayList<Music>();	//error
		
		List<Music> musicList = new ArrayList<Music>();
		musicList.add(new Music("노래1"));
		musicList.add(new Music("노래2"));
		
		// PECS: Producer Extends, Consumer super;
		Player.play(musicList);
		
		Player.addRecommendedContent(musicList);
		Player.play(musicList);
		
		List<Content> contents = new ArrayList<Content>();
		contents.add(new Music("노래3"));
		contetns.add(new Music("노래4"));
		
		Player.play(contents);
		
		Player.addRecommendedContent(contents);
		Player.play(contents);
		
		
		List<Movie> moviceList = new ArrayList<Movie>();
		movieList.add(new Movie("영화1"));
		movieList.add(new Movie("영화2"));
		
		Player.play(movieList);
		
		//Player.addRecommendedContent(movieList);	//error1(1)
		//Player.play(movieList);
		
		Player.<Music> play(new Music("음악1"));
		player.play(new Movie("무비1"));
	}

}

class Player {
	//제네릭스 오버로딩 안됨

	/*
	 
	 * */
	
	
}

