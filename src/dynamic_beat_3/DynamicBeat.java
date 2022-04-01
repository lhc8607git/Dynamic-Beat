package dynamic_beat_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);
		setResizable(false); //창크기를 못바꾸게 한다
		setLocationRelativeTo(null);//★가장 기본으로 사용하게 될 텐데 윈도우 창을 화면의 정가운데에 띄우는 역할을 한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을때 프로그램 전체가 종료된다!! 하지만 이걸 안넣어준다면 게임창이 끄더라도 컴퓨터 내부에서는 돌아가고 있다....
		setVisible(true);//화면에 뜨게 해주는거
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
	
		Music introMusic = new Music("introMusic.mp3",true);  //true이므로 직접 종료할때까지 무한 반복이다
		introMusic.start();
	
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
}
 



