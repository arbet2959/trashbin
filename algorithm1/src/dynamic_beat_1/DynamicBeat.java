package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	private Image screenImage;
	private Graphics screenGraphics;
	
	private ImageIcon exitButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/exitButtonBasic.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/exitButtonEntered.png"));
	private ImageIcon startButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/startButtonBasic.png"));
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/startButtonEntered.png"));
	private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/quitButtonBasic.png"));
	private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/quitButtonEntered.png"));
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/leftButtonBasic.png"));
	private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasic= new ImageIcon(Main.class.getClassLoader().getResource("./images/rightButtonBasic.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/rightButtonEntered.png"));
	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/easyButtonBasic.png"));
	private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/hardButtonBasic.png"));
	private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/hardButtonEntered.png"));
	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/backButtonBasic.png"));
	private ImageIcon backButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/backButtonEntered.png"));
	
	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("./images/introBackground.jpg")).getImage();
	private Image titleImage;
	private Image selectedImage;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("./images/menubar.png")));

	private JButton exitButton = new JButton(exitButtonBasic);
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton easyButton = new JButton(easyButtonBasic);
	private JButton hardButton = new JButton(hardButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);
	
	private Music introMusic = new Music("introMusic.mp3",true);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	List<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private int nowselected = 0;
	
	public static Game game;
	
	public DynamicBeat() {
		Track mightyLove = new Track("Mighty Love Title image.png", "Mighty Love Start image.png",
				"Mighty Love Game image.jpg", "Mighty Love Selected.mp3", "Joakim karud - Mighty Love.mp3", "Joakim karud - Mighty Love");
		Track wildFlower = new Track("Wild Flower Title image.png", "Wild Flower Start image.png",
				"Wild Flower Game image.jpg", "Wild Flower Selected.mp3", "Joakim karud - Wild Flower.mp3", "Joakim karud - Wild Flower");
		Track Energy = new Track("Energy Title image.png", "Energy Start image.png",
				"Energy Game image.png", "Energy Selected.mp3", "Bensound - Energy.mp3", "Bensound - Energy");
		trackList.add(mightyLove);
		trackList.add(wildFlower);
		trackList.add(Energy);
		
		setUndecorated(true); //타이틀바 비활성화
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // rgb+alpha(투명도)
		setLayout(null);
		addKeyListener(new KeyListener());
		
		introMusic.start();
		

		
		
		//EXit버튼
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);  // Jbutton기본형식해제
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEntered);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e ) {
				exitButton.setIcon(exitButtonBasic);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e2) {
					System.out.println(e2.toString());
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
	//시작버튼
			startButton.setBounds(40, 200, 400, 100);
			startButton.setBorderPainted(false);
			startButton.setContentAreaFilled(false);
			startButton.setFocusPainted(false);  // JButton기본형식해제
			startButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					startButton.setIcon(startButtonEntered);
					startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					startButton.setIcon(startButtonBasic);
					startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					introMusic.close();
					// start 이벤트를 넣어주자
					enterMain();
					
				}
			});
			add(startButton);
			
		//종료버튼
			quitButton.setBounds(40, 330, 400, 100);
			quitButton.setBorderPainted(false);
			quitButton.setContentAreaFilled(false);
			quitButton.setFocusPainted(false);  // JButton기본형식해제
			quitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					quitButton.setIcon(quitButtonEntered);
					quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					quitButton.setIcon(quitButtonBasic);
					quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e2) {
						System.out.println(e2.toString());
					}
					System.exit(0);
				}
			});
			add(quitButton);
			
			//left버튼
			leftButton.setVisible(false);
			leftButton.setBounds(140, 310, 60, 60);
			leftButton.setBorderPainted(false);
			leftButton.setContentAreaFilled(false);
			leftButton.setFocusPainted(false);  // Jbutton기본형식해제
			leftButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					leftButton.setIcon(leftButtonEntered);
					leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					leftButton.setIcon(leftButtonBasic);
					leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
				//왼쪽버튼이벤트
					selectLeft();
				}
			});
			add(leftButton);
			
			//right버튼
			rightButton.setVisible(false);
			rightButton.setBounds(1080, 310, 60, 60);
			rightButton.setBorderPainted(false);
			rightButton.setContentAreaFilled(false);
			rightButton.setFocusPainted(false);  // Jbutton기본형식해제
			rightButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					rightButton.setIcon(rightButtonEntered);
					rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					rightButton.setIcon(rightButtonBasic);
					rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
				//오른쪽버튼이벤트
					selectRight();
				}
			});
			add(rightButton);
			
			//easy버튼
			easyButton.setVisible(false);
			easyButton.setBounds(375, 580, 250, 67);
			easyButton.setBorderPainted(false);
			easyButton.setContentAreaFilled(false);
			easyButton.setFocusPainted(false);  // JButton기본형식해제
			easyButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					easyButton.setIcon(easyButtonEntered);
					easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					easyButton.setIcon(easyButtonBasic);
					easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					//난이도쉬움버튼이벤트
					gameStart(nowselected, "Easy");
					
				}
			});
			add(easyButton);
			
			//hard버튼
			hardButton.setVisible(false);
			hardButton.setBounds(655, 580, 250, 67);
			hardButton.setBorderPainted(false);
			hardButton.setContentAreaFilled(false);
			hardButton.setFocusPainted(false);  // Jbutton기본형식해제
			hardButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					hardButton.setIcon(hardButtonEntered);
					hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					hardButton.setIcon(hardButtonBasic);
					hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
				//난이도어려움버튼이벤트
					gameStart(nowselected, "Hard");
				}
			});
			add(hardButton);
			
			//back버튼
			backButton.setVisible(false);
			backButton.setBounds(20, 50, 60, 60);
			backButton.setBorderPainted(false);
			backButton.setContentAreaFilled(false);
			backButton.setFocusPainted(false);  // Jbutton기본형식해제
			backButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					backButton.setIcon(backButtonEntered);
					backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					backButton.setIcon(backButtonBasic);
					backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
				//back버튼이벤트
					backMain();
					
				}
			});
			add(backButton);
			
			
		
	//메뉴바
			menuBar.setBounds(0,0,1280,30);
			//메뉴바누른채로 마우스드래그할때 창이동
			menuBar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					mouseX = e.getX();
					mouseY = e.getY();
				}
			});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {	
			@Override
			public void mouseDragged(MouseEvent e) {
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		


	

	}	
	
	
	//JFrame실행시 updated(Graphics g) -> paint(Graphics g) 자동실행
	//더블버퍼링
	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); 
		screenGraphics = screenImage.getGraphics(); 
		screenDraw((Graphics2D)screenGraphics);
		g.drawImage(screenImage,0,0,null);
	}
	public void screenDraw(Graphics2D g) {
		g.drawImage(background,0,0,null); //단순한 이미지를 화면에출력
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340 , 70 , null);
		}
		if(isGameScreen){
			game.screenDraw(g);
		}
		paintComponents(g); //JFrame'안'에 추가된 '컴포넌트'를 그려줌
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/"+trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/"+trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowselected == 0)
			nowselected = trackList.size()-1;
		else
			nowselected--;
		selectTrack(nowselected);
	}
	public void selectRight() {
		if(nowselected == trackList.size()-1)
			nowselected = 0;
		else
			nowselected++;
		selectTrack(nowselected);
	}
	
	public void enterMain() {
		introMusic.close();
		selectTrack(0);
		startButton.setVisible(false);
		quitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getClassLoader().getResource("./images/mainBackground.jpg")).getImage(); //배경바꿔주기
		isMainScreen = true;
	}
	
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic !=null) {
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getClassLoader().getResource("./images/" +trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
		}
	}
	
	public void backMain() {
		setFocusable(false);
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		backButton.setVisible(false);
		background = new ImageIcon(Main.class.getClassLoader().getResource("./images/mainBackGround.jpg")).getImage();
		selectTrack(nowselected);
		isGameScreen = false;
		game.close();
	}

}

