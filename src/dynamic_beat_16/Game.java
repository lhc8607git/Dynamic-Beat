package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Game extends Thread{    //하나의 게임이 시작이 되면 이 Game클래스에서 만들어진 인스턴스 변수를 이용해서 하나의 게임에 대한 컨트롤을 할 수 있도록 작업할려고 할꺼다
	
	/*   이 코드는 노트클래스에서 구현 할 거다    -    1번째꺼
	private Image  noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();     //노트 이미지  ( 떨어지는거 )
	*/
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
	private Image  blueFlareImage; //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  judgeImage;
	private Image  keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();
	private Image  keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png"))
			.getImage();

	private String titleName;       //즉 현재 실행 할 곡의 이름을 입력하는 거다
	private String difficulty;      //난이도에 대한 설정이다
	private String musicTitle;      //음악타이틀
	private Music gameMusic;       //음악을 담으 수 있는 변수 라네...??    //★이거 Music클래스 사용함
	
	ArrayList<Note> noteList = new ArrayList<Note>();   //각각의  노트들을 생성되는 순간마다 관리해주는 그러한 배열을 하나 만들거다
	
	public Game(String titleName, String difficulty, String musicTitle) {     //이런게 ★생성자 형태★ 이다
		this.titleName =titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);      //false라 한번만 실행된다
		
		
	}
	
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
		g.drawImage(judgementLineImage, 0, 580, null);     //노트판정라인은 y축으로 580에 위치하고 있다
		/*   이 코드들은 노트클래스에서  구현 할 거다     -    2번째꺼        //그리고 이코드는  밑에 있는 dropNotes메소드에 사용할 것이다   //그런데 이코드는 그냥 쓴 거고 밑에서 사용 한것은 Note클래스에 메소드를 사용해서 넣어주었다
		g.drawImage(noteBasicImage, 228, 120,null);    //노트( 떨어지는거 ) 이미지
		g.drawImage(noteBasicImage, 332, 500,null);
		g.drawImage(noteBasicImage, 436, 500,null);
		g.drawImage(noteBasicImage, 540, 340,null);
		g.drawImage(noteBasicImage, 640, 340,null);
		g.drawImage(noteBasicImage, 744, 325,null);
		g.drawImage(noteBasicImage, 848, 305,null);
		g.drawImage(noteBasicImage, 952, 305,null);
		*/
		
		for(int i=0; i < noteList.size(); i++)    //있는  노트들을 전부 하나씩 그려주는거   //그리고 노트가 judgementLineImage(판정라인)보다 위에 표시해야 함으로 judgementLineImage아래에 코드를 작성해주어야한다
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) { // 현재 노트가 작동하지 않는 상태라고 한다면 지우면 됨.
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);                           //여기서부터 3줄 밑에는 게임시작하면 아래에 제목을 표시하게 하는 코드이다 -1
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);     //이렇게 하면 정상적으로 안티에일리어씽이 적용되어서 텍스트가 깨짐이 없이 매끄럽게 출력이 된다 //이거 별루 안중요한거 같아서 정리 안함....
		g.setFont(new Font("Arial", Font.BOLD,30)); 													 //-2
		g.drawString(titleName, 20, 702);     // 월래는 이런 형태 였는데 g.drawString("Joakim Karud - Mighty Love", 20, 702); 제목가져오는 생성자를 만들어 주어서 바꾸어 주웠음  //-3
		g.drawString(difficulty, 1190, 702);      // 월래는 이런 형태 였는데 g.drawString("Easy", 1190, 702);    난이도 가져오는 생성자를 만들어 주어서 바꾸어 주웠음  //난이도를 화면에 표시할려고 만듬
		
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
	
		g.drawImage(blueFlareImage, 320, 430, null);
		g.drawImage(judgeImage, 460, 420, null);
		
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);

	}
	//--------------------------------------키눌렀을 때의 이벤트 처리들--------------------------------------------
	public void pressS() { //S를 눌렀을 때하는 이벤트 쳐리
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();   //★★★눌렀을 때 소리 나는거  ★한번 눌렀을 때  ☆반복되지 않아야 함으로☆ ●false를● 준거다★
	}
	
	public void releaseS() { //S를 땠을 때하는 이벤트 쳐리
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressD() { //D를 눌렀을 때하는 이벤트 쳐리
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();     //★★★눌렀을 때 소리 나는거  ★한번 눌렀을 때  ☆반복되지 않아야 함으로☆ ●false를● 준거다★
	}
	
	public void releaseD() { //D를 땠을 때하는 이벤트 쳐리
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressF() { //F를 눌렀을 때하는 이벤트 쳐리
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseF() { //F를 땠을 때하는 이벤트 쳐리
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressSpace() { //Space를 눌렀을 때하는 이벤트 쳐리    ★이건 왜 두개 넣었냐며 Space는 2개 부분을 찾지하니깐★
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumBig1.mp3",false).start();
	}
	
	public void releaseSpace() { //Space를 땠을 때하는 이벤트 쳐리
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressJ() { //J를 눌렀을 때하는 이벤트 쳐리
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseJ() { //J를 땠을 때하는 이벤트 쳐리
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressK() { //K를 눌렀을 때하는 이벤트 쳐리
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseK() { //K를 땠을 때하는 이벤트 쳐리
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
	public void pressL() { //L를 눌렀을 때하는 이벤트 쳐리
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keypadPressed.png")).getImage();
		new Music("drumSmall1.mp3",false).start();
	}
	
	public void releaseL() { //L를 땠을 때하는 이벤트 쳐리
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keypadBasic.png")).getImage();
	}
   //------------------------------------------------------------------------------------------------------
	@Override     //Thread라는 것은 사실 상, 하나의 프로그램 안에서 실행되는 작은 프로그램이라고 할 수있다. 즉,,전반적인 게임틀 안에서 하나의 게임이 하나의 단위로서 동작을 하기 때문에 이런식으로 Thread라는 것을 이용해 주어야 한다,,이런식으로!
				 //★ 그래서 Thread를 상속한 Game이라고 하는 인스턴스는 run()메소드 안에 있는 것을 실행하게 된다 ★
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();      //이건 Game하는 창이 꺼지면 실행하는 Game의 곡도 종료되는 코드 이다
		this.interrupt();       //즉,지금 실행되고 있는 하나의 게임(Game.java)이라는 쓰레드를 종료시키는 거다
	}
	
	public void dropNotes(String titleName) {   //각각의 노트들이 ★떨어질 수 있도록★ 만들어 주는 거다
		/*  첫번째 -  이 코드가 바로 밑에 코드랑 똑같은데 밑에는 Note클래스를 사용하여서 작성한거다
		g.drawImage(noteBasicImage, 228, 120,null);    //노트( 떨어지는거 ) 이미지
		g.drawImage(noteBasicImage, 332, 500,null);
		g.drawImage(noteBasicImage, 436, 500,null);
		g.drawImage(noteBasicImage, 540, 340,null);
		g.drawImage(noteBasicImage, 640, 340,null);
		g.drawImage(noteBasicImage, 744, 325,null);
		g.drawImage(noteBasicImage, 848, 305,null);
		g.drawImage(noteBasicImage, 952, 305,null);
		*/
		
		/*  두번째 -  
		noteList.add(new Note(228, 120, "short"));
		noteList.add(new Note(332, 580, "short"));
		noteList.add(new Note(436, 500, "short"));
		noteList.add(new Note(540, 340, "long"));
		noteList.add(new Note(744, 325, "short"));
		noteList.add(new Note(848, 305, "short"));
		noteList.add(new Note(952, 305, "short"));
		*/
		

		
//		// 세번째 사용한 코드     -   이건 예시 임 (하나만 떨어지는거)
//		Note note = new Note(228, "short");    //s노트가 하나 떨어지게 만들어 준거다
//		note.start();
//		noteList.add(note);   // 2줄 위에 있는 note를      noteList에     추가해서     정삭적으로     출력 될 수 있도록 한다.
		
		// 들어갈 비트 배열로 나열해줌
//		Beat[] beats = {
//				// 하나의 곡에 대한 모든 비트를 적어 주면 된다.. 하...
//				new Beat(1000,"S"),
//				new Beat(2000,"D"),
//				new Beat(3000,"F")
//		};
		
		Beat[] beats = null;
		if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;   // 노트에 도달하는 시간에 구애 받지 않고 항상 똑같은 첫번째 노트가 판정바에 접중하는 그박자 타이밍을 유지할 수 있다. 
			int gap = 125; // 간격
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "J"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 24, "K"),
					new Beat(startTime + gap * 26, "J"),
					new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "D"),
					new Beat(startTime + gap * 40, "S"),
					new Beat(startTime + gap * 42, "D"),
					new Beat(startTime + gap * 44, "S"),
					new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "J"),
					new Beat(startTime + gap * 49, "K"),
					new Beat(startTime + gap * 50, "L"),
					new Beat(startTime + gap * 52, "F"),
					new Beat(startTime + gap * 52, "Space"),
					new Beat(startTime + gap * 52, "J")
			};
		}
		else if(titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard")){
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Easy")){
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Bendsound - Energy") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Bendsound - Energy") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("Bendsound - Energy") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()){
			// 해당 노드를 떨어트리는 방법
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			// 노트가 떨어지지 않는 경우에는 무한정 반복하는 것이 아니라, 텀을 두면서 노트를 떨어 트릴 수 있게 한다.
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void judge(String input){
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlate.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}		
	}
	
	
	
}
