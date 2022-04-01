package dynamic_beat_5;

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
	
	
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg"))
			.getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);     //1-
	private JButton startButton = new JButton(startButtonBasicImage);     //2-시작하기버튼 ★버튼★ 생성
	private JButton quitButton = new JButton(quitButtonBasicImage);     //2-시작하기버튼 ★버튼★ 생성
	
	private int mouseX, mouseY;  //그냥 마우스 자표
	
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
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg"))
						.getImage();
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

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
}
