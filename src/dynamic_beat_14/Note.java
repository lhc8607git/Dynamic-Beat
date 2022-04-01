package dynamic_beat_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note  extends Thread{    //각각의 노트 또한  하나의 부분적인 기능으로서 떨어지는 어떤한 역할을 수행하기때문에 Thread로 만들어 주어야 한다
	
	private Image noteBasicImage= new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x , y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;  //현재 노트가 어느 위치에 있는지 보여주는거    //정확하게 노트가 생성되고 1초뒤에 판정라인에 다다르게 되는 거다
	private String noteType; 

	public Note(String noteType) {   //생성자 만듬 //현재 노트가 만들어질 위치를 만들어주고 
		if(noteType.equals("S")) {
			x = 228;
		}else if(noteType.equals("D")) {
			x = 332;
		}else if(noteType.equals("F")) {
			x = 436;
		}else if(noteType.equals("Space")) {
			x = 540;
		}else if(noteType.equals("J")) {
			x = 744;
		}else if(noteType.equals("K")) {
			x = 848;
		}else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {     //★하나의 노트의 이미지★를 ★그릴 수 있도록★  ★screenDraw()★를 만들어 줄 필요가 있다
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage, x, y, null);   //즉 ,현재 자신이 위치한 공간에 그려주는 거다
		}
		else
		{
			g.drawImage(noteBasicImage, x, y, null);     //이 코드랑 바로 아래코드는 (스페이스바) 누를 때 그려주는 이미지이다
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	public void drop() {  //즉, 노트가 떨어지는 함수를 의미하는거다
		y += Main.NOTE_SPEED;      //즉, 현재 7로 설정되어있으니깐 7만큼 y의 좌표가 증가해서 아래쪽으로 7만큼 떨어지는 거다
	}
	
	@Override
	public void run() {            //★하..이거 개중요★★  Note클래스가  Thread를 상속 받고 있으니깐 ★Thread가 실행되는 함수를 만들어 줄려고★ ★run()메소드를 작성하였다★!!!!!
		try {
			while(true) {
				drop();     //계속해서 떨어트리는거
				Thread.sleep(Main.SLEEP_TIME);   //즉, 한번 노트를 떨어트리고 0.001초 동안 쉬게 해주었다가 다시 떨어 트리고 이런식으로 무한정 반복되서 실행 할 수 있도록 하는 것이다.
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
