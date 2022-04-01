package dynamic_beat_1;

import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HIGHT); //★Main클래스에서 가져다 쓰는법 이다!!
		setResizable(false); //창크기를 못바꾸게 한다
		setLocationRelativeTo(null);//★가장 기본으로 사용하게 될 텐데 윈도우 창을 화면의 정가운데에 띄우는 역할을 한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을때 프로그램 전체가 종료된다!! 하지만 이걸 안넣어준다면 게임창이 끄더라도 컴퓨터 내부에서는 돌아가고 있다....
		setVisible(true);//화면에 뜨게 해주는거
	}
}
 