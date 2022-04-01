package dynamic_beat_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Title Image.png")).getImage();
	
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Start Image.png"))
			.getImage();    //현재 선택된 이미지 즉 ,, 시작이미지를 말한다
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
				
				//게임 시작 이벤트 만들어야됨!! 아직 안만듬....
				//게임 시작 이벤트 이거임 
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
					//왼쪽버튼 이벤트 작성해야됨!!
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
				//오른쪽버튼 이벤트 작성해야됨!!
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


		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {     //그림을 그려  줄 때
		g.drawImage(background, 0, 0, null);     //★♣◆개중요!! 대박,!! g.drawImage()라는 것은 paintComponents()처럼 add()가 된게 아니라 단순히 이미지를 그냥 화면에 출력해줄 때 쓰는거다!! 차이점잘알기!!
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);  //★♣◆개중요!! 대박,!!  paintComponents()는 ★main프레임에다가★ 추가된 요소인 것들을 보여주는 것이다 !! 예를들어 추가가 된다는 것들은 코드에 add();가 써져 있는 부분이 paintComponents에 의해서 그려지는 것이다!! 
		this.repaint();
	}
}
