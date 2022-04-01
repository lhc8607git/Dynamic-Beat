package dynamic_beat_15;

public class Main {
	public static final int SCREEN_WIDTH=1280; //public static 하면 모든 프로젝트 내부에서 공유 할 수있는 변수라는 거다.
	public static final int SCREEN_HIGHT=720;
	public static final int NOTE_SPEED = 3;    //노트가 떨어지는 속도가 7이라는 것이다
	public static final int SLEEP_TIME = 10;   //노트가 무한정 막 떨어지는 것이 아니라 얼마만의 시간 주기로 떨어지는지 설정을 해주는 거다   //이러한 SLEEP_TIME이 없다면 아무리 속도가 7이라고해도 내부적으로 빠르게 무한정 반복되기때문에 우리 눈에는 엄청나게 빠르게 떨어지는 것처럼 보이게 될껍니다  //그래서 이런식으로 SLEEP_TIME을 만들어 주는 거다
	public static final int REACH_TIME = 2;   //노트가 생성되고 나서, 판정바에 도달하기까지의 시간.
	
	public static void main(String[] args) {
		
		new DynamicBeat();
		
	}

}
