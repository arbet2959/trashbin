package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
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
	
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/exitButtonBasic.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/exitButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/quitButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/rightButtonEntered.png"));
	
	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("./images/introBackground.jpg")).getImage();
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getClassLoader().getResource("./images/menubar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	
	List<Track> trackList = new ArrayList<Track>(); 
	private Music selectedMusic;
	private Image titleImage;
	private Image selectedImage;
	private int nowselected = 0;
	
	public DynamicBeat() {
		setUndecorated(true); //pointComponenet 비활성화
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // rgb+alpha(투명도)
		setLayout(null);
		
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
		
		Track mightyLove = new Track("Mighty Love Title image.png", "Mighty Love Start image.png",
				"Mighty Love Game image.png", "Mighty Love Seleted.mp3", "Joakim karud - Mighty Love.mp3");
		Track wildFlower = new Track("Wild Flower Title image.png", "Wild Flower Start image.png",
				"Wild Flower Game image.png", "Wild Flower Seleted.mp3", "Joakim karud - Wild Flower.mp3");
		Track Energy = new Track("Energy Title image.png", "Energy Start image.png",
				"Energy Game image.png", "Energy Seleted.mp3", "Bensound - Energy.mp3");
		trackList.add(mightyLove);
		trackList.add(wildFlower);
		trackList.add(Energy);
		
		
		//EXit버튼
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);  // Jbutton기본형식해제
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e ) {
				exitButton.setIcon(exitButtonBasicImage);
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
			startButton.setFocusPainted(false);  // Jbutton기본형식해제
			startButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					startButton.setIcon(startButtonEnteredImage);
					startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					startButton.setIcon(startButtonBasicImage);
					startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					introMusic.close();
					selectTrack(0);
					selectedMusic.start();
					// start 이벤트를 넣어주자
					startButton.setVisible(false);
					quitButton.setVisible(false);
					leftButton.setVisible(true);
					rightButton.setVisible(true);
					background = new ImageIcon(Main.class.getClassLoader().getResource("./images/mainBackground.jpg")).getImage(); //배경바꿔주기
					isMainScreen = true;
				}
			});
			add(startButton);
			
		//종료버튼
			quitButton.setBounds(40, 330, 400, 100);
			quitButton.setBorderPainted(false);
			quitButton.setContentAreaFilled(false);
			quitButton.setFocusPainted(false);  // Jbutton기본형식해제
			quitButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					quitButton.setIcon(quitButtonEnteredImage);
					quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					quitButton.setIcon(quitButtonBasicImage);
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
					leftButton.setIcon(leftButtonEnteredImage);
					leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					leftButton.setIcon(leftButtonBasicImage);
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
					rightButton.setIcon(rightButtonEnteredImage);
					rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					rightButton.setIcon(rightButtonBasicImage);
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
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT); //보이는화면
		screenGraphics = screenImage.getGraphics(); //뒤에서준비
		screenDraw(screenGraphics);
		g.drawImage(screenImage,0,0,null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(background,0,0,null); //단순한 이미지를 화면에출력(동적인것에 사용)
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340 , 70 , null);
		}
		paintComponents(g); //JFrame'안'에 추가된 '컴포넌트'를 그려줌(정적인것에 사용)
		
		this.repaint();
	}
	
	public void selectTrack(int nowselected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/"+trackList.get(nowselected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/"+trackList.get(nowselected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowselected).getStartMusic(), true);
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
	
	
}