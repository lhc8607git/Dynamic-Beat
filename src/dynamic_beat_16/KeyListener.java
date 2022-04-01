package dynamic_beat_16;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {  //KeyEvent를 받아서 사용할 수 있도록 합니다!!
		if(DynamicBeat.game == null) {    //즉, 현재 게임이 진행되고 있지 않다면!! 그냥 return!!!
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {   //★현재 누른 키가 S라는 키라면(단축키에서 S를 눌렀다면)★이라는 코드임
			DynamicBeat.game.pressS();				//★★눌렀을 때 ★DynamicBeat.java★파일에 있는 ★game객체(Game.JAVA 사용함)★에서 ★pressS()★메소드를 사용한다는 거다
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.pressD();			    //★★눌렀을 때 ★DynamicBeat.java★파일에 있는 ★game객체(Game.JAVA 사용함)★에서 ★pressD()★메소드를 사용한다는 거다
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.pressF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.pressSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.pressJ();              //★★눌렀을 때 ★DynamicBeat.java★파일에 있는 ★game객체(Game.JAVA 사용함)★에서 ★pressJ()★메소드를 사용한다는 거다
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.pressK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {    //키를 땠을때
		if(DynamicBeat.game == null) {    //즉, 현재 게임이 진행되고 있지 않다면!! 그냥 return!!!
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {   //★현재 누른 키가 S라는 키라면(단축키에서 S를 눌렀다면)★이라는 코드임
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releaseD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releaseF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DynamicBeat.game.releaseSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releaseJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releaseK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releaseL();
		}
	}
	
}
