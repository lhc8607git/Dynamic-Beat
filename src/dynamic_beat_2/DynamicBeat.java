package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;            //이미지 받는거
	private Graphics screenGraphic;         //이미지 받는거
	
	private Image introBackground;           //이미지 받는거
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);
		setResizable(false); //창크기를 못바꾸게 한다
		setLocationRelativeTo(null);//★가장 기본으로 사용하게 될 텐데 윈도우 창을 화면의 정가운데에 띄우는 역할을 한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을때 프로그램 전체가 종료된다!! 하지만 이걸 안넣어준다면 게임창이 끄더라도 컴퓨터 내부에서는 돌아가고 있다....
		setVisible(true);//화면에 뜨게 해주는거
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();  //1.ImageIcon(??)안에 지정된 파일로 부터 ImageIcon 객체를 생성한다!!! 2.그 다음에 객체를 생성하고 getImage로 introBackgound에다가 반환을 해준다 라는 뜻이다!!
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT); //그냥 단순히  createImage함수는 그냥  x,y크기의 만큼의 이미지를 만들어 준다는 거고 이걸 screenImage에다가 넣는 다는거다 
		screenGraphic = screenImage.getGraphics(); //이 것도 단순히 그냥 바로 위에 써져있는 screenImage를 이용해서 Graphic객체를 얻어 온다는 거다
		screenDraw(screenGraphic);  //screenDraw를 이용해서 screenGraphic에 어떠한 그림을 그려주는 거다 ..하지만 아직 screenDraw함수를 아직 안 만들어 주었고!!! screenGraphic에 어떠한 그림을 그려주는 것이다...!!밑에 함수 만들어 졌음!!
		g.drawImage(screenImage, 0, 0, null); //drawImage는 screenImage를 (0,0)에 위치해서 그려주는 거다
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); //introBackground 이미지를 (0,0)에가다 그려준다
		this.repaint();   //★★repaint()함수★★를 사용해서 다시 paint()함수를  불러오는 거다
	}
}
 














