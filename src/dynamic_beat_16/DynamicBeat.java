package dynamic_beat_16;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));      //1-
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));         //1-
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));    //2-시작하기버튼 ★이미지★ 생성
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));      //2-시작하기버튼 ★이미지★ 생성
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));      //2-종료하기버튼 ★이미지★ 생성
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));           //2-종료하기버튼 ★이미지★ 생성
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));    //3-왼쪽버튼 ★이미지★ 생성
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));      //3-왼쪽버튼 ★이미지★ 생성
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));      //3-오른쪽버튼 ★이미지★ 생성
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));           //3-오른쪽버튼 ★이미지★ 생성
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));    //4-easy버튼 ★이미지★ 생성
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));      //4-easy버튼 ★이미지★ 생성
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));      //4-hard버튼 ★이미지★ 생성
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));           //4-hard버튼 ★이미지★ 생성
	
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));      //5-back버튼 ★이미지★ 생성
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));           //5-back버튼 ★이미지★ 생성
	
	/* 이거 Game클래스에 옴겼음
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage();   //이거 게임할 때 아래에 있는 바..
	private Image  judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage();  
	private Image  noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();    //이거 노트가 떨어질 이미지 이다..  ( 노트라인 이미지 )
	private Image  noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage();     //이게 노트를 하나하나 만들면 옆에 들어가는 라인( 옆선 )이다
	private Image  noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png"))
			.getImage();     //노트 이미지  ( 떨어지는거 )
	*/
	
	/*   밑에 다가 위치 조정함(정리함)
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Title Image.png")).getImage();
	
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Start Image.png"))
			.getImage();    //현재 선택된 이미지 즉 ,, 시작이미지를 말한다
	*/
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);     //1-
	private JButton startButton = new JButton(startButtonBasicImage);     //2-시작하기버튼 ★버튼★ 생성
	private JButton quitButton = new JButton(quitButtonBasicImage);     //2-시작하기버튼 ★버튼★ 생성
	private JButton leftButton = new JButton(leftButtonBasicImage);     //3-왼쪽버튼 ★버튼★ 생성
	private JButton rightButton = new JButton(rightButtonBasicImage);     //3-오른쪽버튼 ★버튼★ 생성
	private JButton easyButton = new JButton(easyButtonBasicImage);     //4-easy버튼 ★버튼★ 생성
	private JButton hardButton = new JButton(hardButtonBasicImage);     //4-hard버튼 ★버튼★ 생성
	private JButton backButton = new JButton(backButtonBasicImage);     //5-back버튼 ★버튼★ 생성
	
	private int mouseX, mouseY;  //그냥 마우스 자표
	
	private boolean isMainScreen = false;    //처음에는 메인화면이 아닌 시작화면이기때문에  false 값을 갖는다  ,,,,그리고 메인화면으로 이동했을 때에는 true 값으로 변화게 된다
	private boolean isGameScreen = false;  //즉,게임스크린 즉,현재 게임 화면으로 넘어 왔는지에 대한 변수이다
	
	ArrayList<Track> trackList = new ArrayList<Track>();  //ArrayList는 어떤 변수들을 담을 수 있는 하나의 이미 만들어진 배열이라고 할 수 있겠다.     // 이젠 이걸로 만들어 주어서 각각의 곡(Track)을 담을 수 있는 리스트를 만들어 주었다고 할 수 있다
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;   //밑에 selectTrack함수 정의 한거 같이보기!!  
	private Music introMusic = new Music("introMusic.mp3", true);      //시작하자마자 음악 나오게 설정을 했다
	private int nowSelected = 0;   //nowSelected는 현재 선택된 곡의 번호를 의미하는 거다 //값이 0인 이유는 인덱스가 0부터 시작이니깐 0을 써준거다
	
	public static Game game;  //public static 사용하면 지금 현재 프로젝트 전체에서 사용되는 하나의 변수가 되는 거다    //월래 이거 였는데 public static Game game = new Game(); 객체생성만 지웠음. 왜냐하면 Game.java에다가 생성자를 만들어 주었기 때문에는 아니고 다시 밑에 gameStart메소드에서 객체생성을 해줄려고 지웠음!!! 
	
	public DynamicBeat() {
		
		trackList.add(new Track("Mighty Love Title Image.png", "Mighty Love Start Image.png",    //이렇게 함으로써 변수를 한번에 초기화해주고  그다음에 trackList에 add해서 넣어주면 됨.(그리고 이렇게 해주므로 곡들을 관리 할 수 있게 된다)
				"Mighty Love Game Image.png", "Mighty Love Selected.mp3", "Joakim Karud - Mighty Love.mp3","Joakim Karud - Mighty Love"));   //이건 인덱스 0
		trackList.add(new Track("Wild Flower Ttile Image.png", "Wild Flower Start Image.png",
				"Wild Flower Game Image.png", "Wild Flower Selected.mp3", "Joakim Karud - Wild Flower.mp3","Joakim Karud - Wild Flower"));   //이건 인덱스 1
		trackList.add(new Track("Energy Title Image.png", "Energy Start Image.png",
				"Energy Game Image.png", "Energy Selected.mp3", "Bensound - Energy.mp3","Bensound - Energy"));   //이건 인덱스 2
		
		setUndecorated(true); // 실행을 했을 때 기본적으로 존재하는 메뉴바가 보이지 않게 됩니다.
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		setResizable(false); // 창크기를 못바꾸게 한다
		setLocationRelativeTo(null);// ★가장 기본으로 사용하게 될 텐데 윈도우 창을 화면의 정가운데에 띄우는 역할을 한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 게임창을 종료했을때 프로그램 전체가 종료된다!! 하지만 이걸 안넣어준다면 게임창이 끄더라도 컴퓨터 내부에서는
														// 돌아가고 있다....
		setVisible(true);// 화면에 뜨게 해주는거
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); // 위치를 지정안함
		/* 이거 밖에 다가 놔둠
		Music introMusic = new Music("introMusic.mp3", true);      //시작하자마자 음악 나오게 설정을 했다
		*/
		
		addKeyListener(new KeyListener());     //게임에 적용됨 
		
		introMusic.start();
		
		
		//---------버튼 1번째꺼-----exitButton-----------------------------------------------------------------------------------------
		exitButton.setBounds(1245, 0, 30, 30);  // 맨 오른쪽에 위치한다
		exitButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		exitButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		exitButton.setFocusPainted(false);  //포커스 표시 설정      3
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				exitButton.setIcon(exitButtonEnteredImage);	
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);                 //★★★프로그램 자체가 종료가 된다!!!    
			}
			
			
		});
		
		add(exitButton);
		///////////////버튼 2번째꺼---startButton////////새로운 화면////////////////////////////////////////////////////////////////////////////
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		startButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		startButton.setFocusPainted(false);  //포커스 표시 설정      3
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				startButton.setIcon(startButtonEnteredImage);	
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {       //이부분이 '시작하기'버튼을 눌러서 Main화면으로 이동하는 부분이다
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				enterMain(); //Main()함수로 들어간다라는거
				/*   ArrayList<Track> trackList = new ArrayList<Track>(); 이 코드 때문에 이젠 노래 트는거 다 지워줘도 괜찮다
				Music selectedMusic = new Music("Mighty Love Selected.mp3",true);    //★이 노래로 바뀐다
				selectedMusic.start();
				*/
				//게임 시작 이벤트 만들어야됨!! 아직 안만듬....
				//게임 시작 이벤트 이거임 
				/* 이 부분은 아래쪽에 enterMain()함수에다가 넣어 주었다
				selectTrack(0);   //이건 맨처음에 프로그램을 실행하면 시작버튼 누르면 맨 처음인 첫번째 곡인 "Mighty Love"곡이 ★선택이 되므로★ 이렇게 selectTrack을 0번째껄 실행 해줘야한다.!!(Mighty Love곡을 맨처음에 기본 설정으로 하기 싫으면 위에 trackList.add()함수를 바꿔주면 됩니다!!
				startButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.   (아!!! 이거 그냥 안 보이게 할려고 쓴거야!!)
				quitButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.
				leftButton.setVisible(true);     //왼쪽 버튼 보이게
				rightButton.setVisible(true);	//오른쪽 버튼 보이게
				easyButton.setVisible(true);     //easy 버튼 보이게
				hardButton.setVisible(true);	//hard 버튼 보이게
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
						.getImage();
				isMainScreen = true;    //시작버튼이 눌렸을 때   isMainScreen의 값을 true로 바꿔주면 된다
				*/
			}
			
			
		});
		
		add(startButton);
		//----------버튼 3번째꺼--quitButton--------------------------------------------------------------------------------------------
		quitButton.setBounds(40, 330, 400, 100); 
		quitButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		quitButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		quitButton.setFocusPainted(false);  //포커스 표시 설정      3
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				quitButton.setIcon(quitButtonEnteredImage);	
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);               //여긴 그냥 이거 넣어주면 꺼짐  //★★★프로그램 자체가 종료가 된다!!!    
			}
			
			
		});
		
		add(quitButton);
		//-----------leftButton---------------------------------------------------------------------------------------------		
		leftButton.setVisible(false);   //left버튼 ,right버튼을 처음에 보이지 않도록!!
		leftButton.setBounds(140, 310, 60, 60); 
		leftButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		leftButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		leftButton.setFocusPainted(false);  //포커스 표시 설정      3
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				leftButton.setIcon(leftButtonEnteredImage);	
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
					//왼쪽버튼 이벤트 작성해야됨!! 밑에 작성함
					//왼쪽버튼 누르면 selectLeft()가 실행되고
				selectLeft();
				
			}
			
			
		});
		
		add(leftButton);
		//-----------rightButton---------------------------------------------------------------------------------------------
		rightButton.setVisible(false);  //left버튼 ,right버튼을 처음에 보이지 않도록!!
		rightButton.setBounds(1080, 310, 60, 60); 
		rightButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		rightButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		rightButton.setFocusPainted(false);  //포커스 표시 설정      3
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				rightButton.setIcon(rightButtonEnteredImage);	
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				//오른쪽버튼 이벤트 작성해야됨!! 밑에 작성함
				//오른쪽버튼 눌렀을 때 selectRight()가 실행된다
				selectRight();
			}
			
			
		});
		
		add(rightButton);
		//---------easyButton   난이도 쉬움버튼-----------------------------------------------------------------------------------------------
		easyButton.setVisible(false);  //left버튼 ,right버튼을 처음에 보이지 않도록!!
		easyButton.setBounds(375, 580, 250, 67); 
		easyButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		easyButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		easyButton.setFocusPainted(false);  //포커스 표시 설정      3
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				easyButton.setIcon(easyButtonEnteredImage);	
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				//난이도 쉬움 이벤트를 작성해줘야함(밑에 작성함)
				gameStart(nowSelected, "Easy");
			}
			
			
		});
		
		add(easyButton);
		//---------hardButton   난이도 어려움버튼-----------------------------------------------------------------------------------------------
		hardButton.setVisible(false);  //left버튼 ,right버튼을 처음에 보이지 않도록!!
		hardButton.setBounds(655, 580, 250, 67); 
		hardButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		hardButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		hardButton.setFocusPainted(false);  //포커스 표시 설정      3
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				hardButton.setIcon(hardButtonEnteredImage);	
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				//난이도 어려운 이벤트를 작성해줘야함 (밑에 씀)
				gameStart(nowSelected, "Hard");
			}
			
			
		});
		
		add(hardButton);
		
		//---------backButton  뒤로가기버튼-----------------------------------------------------------------------------------------------
		backButton.setVisible(false);  //left버튼 ,right버튼을 처음에 보이지 않도록!!
		backButton.setBounds(20, 50, 60, 60); 
		backButton.setBorderPainted(false); //버튼 테두리 설정     1      이것들은 그냥 JButton 외관에 대한 거 
		backButton.setContentAreaFilled(false); //버튼 영역 배경 표시 설정      2
		backButton.setFocusPainted(false);  //포커스 표시 설정      3
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {   //마우스가 버튼 위에 올라 가있을 때
				backButton.setIcon(backButtonEnteredImage);	
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));   //닫기 버튼 위에 있으면 마우스(커서)모양이 손가락모양으로 바뀐다
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);    //버튼 위에 있으면 소리나옴(근데 소리가 안들림...)
				buttonEnteredMusic.start();                                            //소리 시작
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));    //닫기버튼 밖에 있으면 월래 모양으로 되도라 온다 
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				// 메인 화면으로 돌아가는 이벤트를 작성 해야한다(아래에 작성했음)
				backMain(); //backMain()이벤트 아래에 만들어 났음
			}
			
			
		});
		
		add(backButton);
		//--------------------------------------------------------------------------------------------------------
		
		menuBar.setBounds(0, 0, 1280, 30); // setBounds는 (배치관리자가 NULL일때 !!)사용해서 위치와 크기를 설정하는 것이다
		menuBar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				mouseX=e.getX();
				mouseY=e.getY();
			}
			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
			
			
		});
		add(menuBar);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);     //Graphics2D로 형변환했다
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {     //그림을 그려  줄 때                       //이것도 Graphics2D로 바꾸어 주었다
		g.drawImage(background, 0, 0, null);     //★♣◆개중요!! 대박,!! g.drawImage()라는 것은 paintComponents()처럼 add()가 된게 아니라 단순히 이미지를 그냥 화면에 출력해줄 때 쓰는거다!! 차이점잘알기!!
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if(isGameScreen)
		{
			game.screenDraw(g);
			//밑에 있는 주석단 코드들을 Game클래스에 넣어주었기 때문에 위에서 Game클래스 객체 하나 만들어주고 여기다가  game.sceenDraw(g); 를 넣어주어서 그림을 그려주면 된다..!!
			/*    이 코드를 Game클래스에다가 옴겼음
			g.drawImage(noteRouteImage, 228, 30, null);   //  ( 노트라인 이미지 )
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
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
			*/
			
		}
		paintComponents(g);  //★♣◆개중요!! 대박,!!  paintComponents()는 ★main프레임에다가★ 추가된 요소인 것들을 보여주는 것이다 !! 예를들어 추가가 된다는 것들은 코드에 add();가 써져 있는 부분이 paintComponents에 의해서 그려지는 것이다!! 
		try {
			Thread.sleep(5);
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {   //현재 선택된 곡의 번호(nowSelected)를 넣어 준다
		if(selectedMusic != null)
			selectedMusic.close();  //어떤 곡이  실행 되고 있다면 바로 종료되도록 해주는 거다
		titleImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getTitleImage())).getImage();
		//바로위에 있는코드 설명 ->  현재 선택된 Track,,즉, 현재 선택된 곡이 갖이고 있는   TitleImage 값을 이렇게 가져와서 넣겠다는 거다
		selectedImage = new ImageIcon(Main.class.getResource("../images/"+ trackList.get(nowSelected).getStartImage())).getImage();
		//바로 위에 있는 코드 설명 ->  즉 선택된 곡의 이미지를 그 트랙의 이미지로 바꿔 주고
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(),true);
		selectedMusic.start();
	}
	
	public void selectLeft() {         //왼쪽 버튼 누르면
		if(nowSelected == 0)     //0번째 곡일때는,
			nowSelected = trackList.size() -1;     //즉,0번째 곡일때 왼쪽을 누르게 되며는 가장 오른쪽에 있는 곡이 선택이 되야 하므로  이렇게 작성 한거다
		else
			nowSelected--;     //가장 왼쪽이 아니면 그냥 1뺀다
		selectTrack(nowSelected);    //그리고 다시 바로 위에  메소드에 있는 selectTrack메소드를 다시 실행 시켜주는 코드다!
		
	}
	
	public void selectRight() {         //오른쪽 버튼 누르면
		if(nowSelected == trackList.size()-1)     //가장 오른쪽에 있는 곡일때는 ,,즉 마지막 곡일때는!!
			nowSelected = 0;     // 첫번째 곡으로 이동해준다
		else
			nowSelected++;     //그렇지 않으면 오른쪽으로 한 칸 플러스!!해준다
		selectTrack(nowSelected);    //그리고 다시 바로 위위에  메소드에 있는 selectTrack메소드를 다시 실행 시켜주는 코드다!
		
	}
	
	///////////////////여기는 이젠 게임 하는 부분//////////새로운 화면/////////////////////////////////////////////////////////////////////////////
	public void gameStart(int nowSelected, String difficulty) {   //매개변수는 (현재 선택된 곡, 난이도 정보)이다.   // 그리고 이젠 이화면은 main화면이 아니고 새로운 게임화면임!!!
		if(selectedMusic != null) 		//어떤 음악이 현재 실행 중이라면 
			selectedMusic.close();      //꺼준다
		isMainScreen = false;  //★이젠 main화면이 아니라는 것을 알려줘야한다<-(이코드설명)  . . 그리고  이게 false값이면 screenDraw(Graphics g)함수에서 if(isMainScreen){~}이 실행이 안될 것이다!!
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/"+trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;   //게임을 시작하는 부분이기때문에 이 단면이 필요한 것이다 ..그래서 true이다 
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);   //게임창 ,즉 main프레임에 키보드 포커스가 맟추어 지는 것이다
	}
	
	//---------backMain()함수는 Main()함수로 돌아 간다는 거다-----------------------------------------------------------------------------------------------
	public void backMain() {
		isMainScreen = true;     //★다시 Main()함수로 돌아 왔으니깐 true값으로 바꿔줘야한다 
		leftButton.setVisible(true);    //다시 Main()함수에 있는 각종 컴포넌트들이 다시 보이도록 바꿔줘야 합니다!!!★다시 돌아 왔으니깐 !!!!
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))  //이것도 다시 돌아왔으니깐 다시 설정 해줘야한다,,다시 바꿔줘야한다
				.getImage();
		backButton.setVisible(false);   //뒤로가기버튼은 이젠 다시 Main()함수로 돌아 왔기 때문에 더 이상 보여지면 안된다!!그래서 false
		selectTrack(nowSelected);  //즉,현재 선택된 Track을 보여주고 하이라이트부분을 재생시켜라
		isGameScreen = false;//즉, main화면으로 돌아 왔을 때는 반대로 false를 해주면 된다
		game.close();   //즉,현재 실행되고 있는 game을 종료하고 음악도 종료 하는 거다
	}
	//--------------------------------------------------------------------------------------------------------------------
	public void enterMain() {

		startButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.   (아!!! 이거 그냥 안 보이게 할려고 쓴거야!!)
		quitButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
				.getImage();
		isMainScreen = true;    //시작버튼이 눌렸을 때   isMainScreen의 값을 true로 바꿔주면 된다
		leftButton.setVisible(true);     //왼쪽 버튼 보이게
		rightButton.setVisible(true);	//오른쪽 버튼 보이게
		easyButton.setVisible(true);     //easy 버튼 보이게
		hardButton.setVisible(true);	//hard 버튼 보이게
		introMusic.close();
		selectTrack(0);   //이건 맨처음에 프로그램을 실행하면 시작버튼 누르면 맨 처음인 첫번째 곡인 "Mighty Love"곡이 ★선택이 되므로★ 이렇게 selectTrack을 0번째껄 실행 해줘야한다.!!(Mighty Love곡을 맨처음에 기본 설정으로 하기 싫으면 위에 trackList.add()함수를 바꿔주면 됩니다!!
	}
}
