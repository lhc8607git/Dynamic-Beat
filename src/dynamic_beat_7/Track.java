package dynamic_beat_7;

public class Track {      //Track클래스는  하나의 곡에 대한 정보들을 담는 클래스이다!!
	
	private String titleImage; //제목 부분 이미지
	private String startImage; //게임 선택 창 표지 이미지
	private String gameImage; //해당 곡을 실행했을 때 표지 이미지
	private String startMusic; //게임 선택 창 음악
	private String gameMusic; //해당 곡을 실행했을 때 음악
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	//밑에 있는 것이 생성자 만든거           그리고  DynamicBeat.java 에서 Track함수를 사용 할때 5개의 매개변수를 각각 써주고 쓰면 됨..그냥 쓴거 
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
	}
	
	
	
}
