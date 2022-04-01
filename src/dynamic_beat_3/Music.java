package dynamic_beat_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music  extends Thread{
	private Player player;  //★Player는 javazoom사이트에서 받은 라이브러리 중 하나를 사용한거다 .. 
	private boolean isLoop;  //isLoop는 현재 곡이 무한 반복인지 아니면 한번만 재생하고 꺼지는지 설정하는거
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {    //곡의 제목과 해당 곡이 무한 반복인지? 여부를 입력받는거
		try {
			this.isLoop= isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());  //파일을 가져 올 수 있도록 한다음에 해당 파일의 이름(name)을 실행시키는거 !!!!..toURI()로 해당 파일의 위치를 가져 올 수 있도록 합니다!
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis); //해당 파일을 버퍼에 담아서 읽어 올 수 있도록 하는 거다
			player = new Player(bis);   //player는 해당 파일을 담을 수 있도록 해줍니다
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {           //getTime()은 현재 실행되고 있는 음악이 현재 어떤 위치에서 실행되고 있는지 알려준다
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {     //close()는 음악이 언제 실행되고 있던간에 항상 종료될 수 있도록 해준다..(예를들어, Player가 어떤 곡으로 게임하다가 재미가 없어서 다른 곡으로 바꿀 때에 뒤로가기 버튼을 누룰 수 있는데..그 때 close함수를 실행 시키므로써 해당 곡이 안정적으로 종료 될 수 있게 해줍니다.
		isLoop = false;
		player.close();
		this.interrupt();    //interrupt라는 것은 해당 스레드를 중지상태로 만드는거다 (즉, 곡이 실행하는 프로그램을 종료해주는 것이다)
	}
	
	@Override
	public void run() {
		try {
			do {   //isLoop가 true이면 해당 곡은 무한반복으로 실행이 됩니다
				player.play();         //곡을 실행 시킨다
				fis = new FileInputStream(file);    
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while (isLoop);
		}catch(Exception e){
			System.out.println(e.getMessage());	 //오류 발생시 해당 오류 메세지를 보여준다
		}
	}
}





