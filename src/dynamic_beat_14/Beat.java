package dynamic_beat_14;

// 박자 타이밍과 노트에 대한 정보를 담을 수 있는 Beat클래스 입니다.
public class Beat {
	
	private int time;
	private String noteName;
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	
}
