package dynamic_beat_11_copy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;


public class Game extends Thread{    //하나의 게임이 시작이 되면 이 Game클래스에서 만들어진 인스턴스 변수를 이용해서 하나의 게임에 대한 컨트롤을 할 수 있도록 작업할려고 할꺼다
	
	private Image  noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();     //노트 이미지  ( 떨어지는거 )
	private Image  noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();     //이게 노트를 하나하나 만들면 옆에 들어가는 라인( 옆선 )이다
	private Image  judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();  
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();   //이거 게임할 때 아래에 있는 바..
/*	private Image  noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )     // ★월래 이 코드만 있었는데★ 이젠 각 누를 키마다 다 작성하는 걸로 바꿈      */
	private Image  noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )   //space는 왜 이미지가 2개냐면 기니깐 2개얔ㅋㅋㅋ
	private Image  noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )


	
	public void screenDraw(Graphics2D g) {
		/* 이것도 다시 바로 밑에다가 작성함
		g.drawImage(noteRouteImage, 228, 30, null);   //  ( 노트라인 이미지 )
		g.drawImage(noteRouteImage, 332, 30, null);
		g.drawImage(noteRouteImage, 436, 30, null);
		g.drawImage(noteRouteImage, 540, 30, null);
		g.drawImage(noteRouteImage, 640, 30, null);
		g.drawImage(noteRouteImage, 744, 30, null);
		g.drawImage(noteRouteImage, 848, 30, null);
		g.drawImage(noteRouteImage, 952, 30, null);
		*/
		g.drawImage(noteRouteSImage, 228, 30, null);   //  ( 노트라인 이미지 )
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);    //노트 이미지 옆에 구분하기위해 필요한 라인선 이미지   ( 옆선 )
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(noteBasicImage, 228, 120,null);    //노트( 떨어지는거 ) 이미지
		g.drawImage(noteBasicImage, 332, 500,null);
		g.drawImage(noteBasicImage, 436, 500,null);
		g.drawImage(noteBasicImage, 540, 340,null);
		g.drawImage(noteBasicImage, 640, 340,null);
		g.drawImage(noteBasicImage, 744, 325,null);
		g.drawImage(noteBasicImage, 848, 305,null);
		g.drawImage(noteBasicImage, 952, 305,null);
		g.setColor(Color.white);                           //여기서부터 3줄 밑에는 게임시작하면 아래에 제목을 표시하게 하는 코드이다 -1
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);     //이렇게 하면 정상적으로 안티에일리어씽이 적용되어서 텍스트가 깨짐이 없이 매끄럽게 출력이 된다 //이거 별루 안중요한거 같아서 정리 안함....
		g.setFont(new Font("Arial", Font.BOLD,30)); 													 //-2
		g.drawString("Joakim Karud - Mighty Love", 20, 702);										     //-3
		g.drawString("Easy", 1190, 702);   //난이도를 화면에 표시할려고 만듬
		
		g.setFont(new Font("Arial", Font.PLAIN,26));    //여기서 부터 9줄은 게임 할때 사용할 키를 그려준다(표시한다)     -1
		g.setColor(Color.DARK_GRAY);																//-2
		g.drawString("S", 270, 609);																//-3
		g.drawString("D", 374, 609);																//-4
		g.drawString("F", 478, 609);																//-5
		g.drawString("Space Bar", 580, 609);														//-6
		g.drawString("J", 784, 609);																//-7
		g.drawString("K", 889, 609);																//-8
		g.drawString("L", 993, 609);																//-9
		
		g.setColor(Color.LIGHT_GRAY);               //여기서부터3줄은 점수 표시하는 코드이다      -1
		g.setFont(new Font("Elephant",Font.BOLD,30));                          //-2
		g.drawString("000000", 565, 702);									   //-3
		
	}
	//--------------------------------------키눌렀을 때의 이벤트 처리들--------------------------------------------
	public void pressS() { //S를 눌렀을 때하는 이벤트 쳐리
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();   //★★★눌렀을 때 소리 나는거  ★한번 눌렀을 때  ☆반복되지 않아야 함으로☆ ●false를● 준거다★
	}
	
	public void releaseS() { //S를 땠을 때하는 이벤트 쳐리
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressD() { //D를 눌렀을 때하는 이벤트 쳐리
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();     //★★★눌렀을 때 소리 나는거  ★한번 눌렀을 때  ☆반복되지 않아야 함으로☆ ●false를● 준거다★
	}
	
	public void releaseD() { //D를 땠을 때하는 이벤트 쳐리
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressF() { //F를 눌렀을 때하는 이벤트 쳐리
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseF() { //F를 땠을 때하는 이벤트 쳐리
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressSpace() { //Space를 눌렀을 때하는 이벤트 쳐리    ★이건 왜 두개 넣었냐며 Space는 2개 부분을 찾지하니깐★
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
	}
	
	public void releaseSpace() { //Space를 땠을 때하는 이벤트 쳐리
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressJ() { //J를 눌렀을 때하는 이벤트 쳐리
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseJ() { //J를 땠을 때하는 이벤트 쳐리
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressK() { //K를 눌렀을 때하는 이벤트 쳐리
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseK() { //K를 땠을 때하는 이벤트 쳐리
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	public void pressL() { //L를 눌렀을 때하는 이벤트 쳐리
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseL() { //L를 땠을 때하는 이벤트 쳐리
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
   //------------------------------------------------------------------------------------------------------
	@Override     //Thread라는 것은 사실 상, 하나의 프로그램 안에서 실행되는 작은 프로그램이라고 할 수있다. 즉,,전반적인 게임틀 안에서 하나의 게임이 하나의 단위로서 동작을 하기 때문에 이런식으로 Thread라는 것을 이용해 주어야 한다,,이런식으로!
				 //★ 그래서 Thread를 상속한 Game이라고 하는 인스턴스는 run()메소드 안에 있는 것을 실행하게 된다 ★
	public void run() {
		
	}
}
