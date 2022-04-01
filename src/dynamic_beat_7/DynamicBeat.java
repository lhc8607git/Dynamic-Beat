package dynamic_beat_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	
	private int mouseX, mouseY;  //그냥 마우스 자표
	
	private boolean isMainScreen = false;    //처음에는 메인화면이 아닌 시작화면이기때문에  false 값을 갖는다  ,,,,그리고 메인화면으로 이동했을 때에는 true 값으로 변화게 된다
	
	ArrayList<Track> trackList = new ArrayList<Track>();  //ArrayList는 어떤 변수들을 담을 수 있는 하나의 이미 만들어진 배열이라고 할 수 있겠다.     // 이젠 이걸로 만들어 주어서 각각의 곡(Track)을 담을 수 있는 리스트를 만들어 주었다고 할 수 있다
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;   //밑에 selectTrack함수 정의 한거 같이보기!!  
	private int nowSelected = 0;   //nowSelected는 현재 선택된 곡의 번호를 의미하는 거다 //값이 0인 이유는 인덱스가 0부터 시작이니깐 0을 써준거다
	
	public DynamicBeat() {
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
		
		Music introMusic = new Music("introMusic.mp3", true);      //시작하자마자 음악 나오게 설정을 했다
		introMusic.start();
		
		trackList.add(new Track("Mighty Love Title Image.png", "Mighty Love Start Image.png",    //이렇게 함으로써 변수를 한번에 초기화해주고  그다음에 trackList에 add해서 넣어주면 됨.(그리고 이렇게 해주므로 곡들을 관리 할 수 있게 된다)
				"Mighty Love Game Image.png", "Mighty Love Selected.mp3", "Joakim Karud - Mighty Love.mp3"));   //이건 인덱스 0
		trackList.add(new Track("Wild Flower Ttile Image.png", "Wild Flower Start Image.png",
				"Wild Flower Game Image.png", "Wild Flower Selected.mp3", "Wild Flower - Joakim Karud.mp3"));   //이건 인덱스 1
		trackList.add(new Track("Energy Title Image.png", "Energy Start Image.png",
				"Energy Game Image.png", "Energy Selected.mp3", "Bensound - Energy.mp3"));   //이건 인덱스 2
		
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
		//--------버튼 2번째꺼---startButton---------------------------------------------------------------------------------------------
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
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3",false);    //버튼 누르면 소리나옴( 이것도 소리 안들림..)
				buttonEnteredMusic.start();                                               //소리 시작
				introMusic.close();    //main음악인 introMusic.mp3를 종료시킨다 그런다음에 밑에 있는 음악을 튼다
				/*   ArrayList<Track> trackList = new ArrayList<Track>(); 이 코드 때문에 이젠 노래 트는거 다 지워줘도 괜찮다
				Music selectedMusic = new Music("Mighty Love Selected.mp3",true);    //★이 노래로 바뀐다
				selectedMusic.start();
				*/
				//게임 시작 이벤트 만들어야됨!! 아직 안만듬....
				//게임 시작 이벤트 이거임 
				selectTrack(0);   //이건 맨처음에 프로그램을 실행하면 시작버튼 누르면 맨 처음인 첫번째 곡인 "Mighty Love"곡이 ★선택이 되므로★ 이렇게 selectTrack을 0번째껄 실행 해줘야한다.!!(Mighty Love곡을 맨처음에 기본 설정으로 하기 싫으면 위에 trackList.add()함수를 바꿔주면 됩니다!!
				startButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.   (아!!! 이거 그냥 안 보이게 할려고 쓴거야!!)
				quitButton.setVisible(false);   //즉,,시작버튼이 보이지 않게 된다.
				leftButton.setVisible(true);     //왼쪽 버튼 보이게
				rightButton.setVisible(true);	//오른쪽 버튼 보이게
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
						.getImage();
				isMainScreen = true;    //시작버튼이 눌렸을 때   isMainScreen의 값을 true로 바꿔주면 된다
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
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {     //그림을 그려  줄 때
		g.drawImage(background, 0, 0, null);     //★♣◆중요!! 대박,!! g.drawImage()라는 것은 paintComponents()처럼 add()가 된게 아니라 단순히 이미지를 그냥 화면에 출력해줄 때 쓰는거다!! 차이점잘알기!!
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);  //★♣◆개중요!! 대박,!!  paintComponents()는 ★main프레임에다가★ 추가된 요소인 것들을 보여주는 것이다 !! 예를들어 추가가 된다는 것들은 코드에 add();가 써져 있는 부분이 paintComponents에 의해서 그려지는 것이다!! 
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
}