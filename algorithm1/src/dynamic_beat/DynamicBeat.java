package dynamic_beat;

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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private ImageIcon signUpButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpButtonBasic.png"));
	private ImageIcon signUpButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpButtonEntered.png"));
	private ImageIcon loginButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/loginButtonBasic.png"));
	private ImageIcon loginButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/loginButtonEntered.png"));
	private ImageIcon rankingButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/rankingButtonBasic.png"));
	private ImageIcon rankingButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/rankingButtonEntered.png"));
	
	private ImageIcon signUpInsertButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpInsertButtonBasic.png"));
	private ImageIcon signUpInsertButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpInsertButtonEntered.png"));
	private ImageIcon signUpCancleButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpCancleButtonBasic.png"));
	private ImageIcon signUpCancleButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/signUpCancleButtonEntered.png"));
	
	private ImageIcon insertSearchButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/InsertSearchButtonBasic.png"));
	private ImageIcon insertSearchButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/InsertSearchButtonEntered.png"));
	private ImageIcon rankingCancleButtonBasic = new ImageIcon(Main.class.getClassLoader().getResource("./images/rankingCancleButtonBasic.png"));
	private ImageIcon rankingCancleButtonEntered = new ImageIcon(Main.class.getClassLoader().getResource("./images/rankingCancleButtonEntered.png"));
	
	
	private Image background = new ImageIcon(Main.class.getClassLoader().getResource("./images/introBackground.jpg")).getImage();
	private Image rankingBackGround = new ImageIcon(Main.class.getClassLoader().getResource("./images/rankingBackGround.jpg")).getImage();
	
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
	private JButton signUpButton = new JButton(signUpButtonBasic);
	private JButton signUpInsertButton = new JButton(signUpInsertButtonBasic);
	private JButton signUpCancleButton = new JButton(signUpCancleButtonBasic);
	private JButton loginButton = new JButton(loginButtonBasic);
	private JButton rankingButton = new JButton(rankingButtonBasic);
	private JButton insertSearchButton = new JButton(insertSearchButtonBasic);
	private JButton rankingCancleButton = new JButton(rankingCancleButtonBasic);
	
	private Music introMusic = new Music("introMusic.mp3",true);
	
	private JLabel lbID,lbPassword,lbAge,lbEmail,lbLoginID, lbLoginPassword;
	private JTextField txtId, txtAge, txtEmail,txtLoginId;
	private JPasswordField txtPassword,txtLoginPassword;
	private JComboBox cbTitle;
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	private boolean isLoginScreen = false;
	private boolean isRanking = false;
	List<Track> trackList = new ArrayList<Track>();
	private Music selectedMusic;
	private int nowselected = 0;
	
	private DAO dao;
	private IdDTO idDTO;
	private String rankTitle;
	private PlayRecordDTO prDTO;
	List<PlayRecordDTO> prDTOs;
	private DynamicService dService;
	public static Game game;
	public static String loginID="anonymousUser";
	
	public DynamicBeat() {
		Track mightyLove = new Track("Mighty Love Title image.png", "Mighty Love Start image.png",
				"Mighty Love Game image.jpg", "Mighty Love Selected.mp3", "Joakim karud - Mighty Love.mp3", "Joakim karud - Mighty Love",200000);
		Track wildFlower = new Track("Wild Flower Title image.png", "Wild Flower Start image.png",
				"Wild Flower Game image.jpg", "Wild Flower Selected.mp3", "Joakim karud - Wild Flower.mp3", "Joakim karud - Wild Flower",205000);
		Track Energy = new Track("Energy Title image.png", "Energy Start image.png",
				"Energy Game image.png", "Energy Selected.mp3", "Bensound - Energy.mp3", "Bensound - Energy",180000);
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
		getContentPane().setLayout(null);
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
		getContentPane().add(exitButton);
		
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
			getContentPane().add(startButton);
			
		//종료버튼
			quitButton.setBounds(40, 325, 400, 100);
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
			getContentPane().add(quitButton);
			
			//회원가입버튼
			signUpButton.setBounds(40, 450, 400, 100);
			signUpButton.setBorderPainted(false);
			signUpButton.setContentAreaFilled(false);
			signUpButton.setFocusPainted(false);  // Jbutton기본형식해제
			signUpButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					signUpButton.setIcon(signUpButtonEntered);
					signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					signUpButton.setIcon(signUpButtonBasic);
					signUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					
					//회원가입창 구현해서 넣기
					SelectSignUp();
				}	
			});
			getContentPane().add(signUpButton);
			
			lbID = new JLabel("아이디");
			lbID.setHorizontalAlignment(SwingConstants.CENTER);
			lbID.setOpaque(true); 
			lbID.setBackground(Color.black);
			lbID.setForeground(Color.WHITE);
			lbID.setFont(new Font("굴림", Font.BOLD, 20));
			lbID.setBounds(200, 200, 150, 40);
			lbID.setVisible(false);
			getContentPane().add(lbID);
			
			lbPassword = new JLabel("비밀번호");
			lbPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lbPassword.setFont(new Font("굴림", Font.BOLD, 20));
			lbPassword.setOpaque(true); 
			lbPassword.setBackground(Color.black);
			lbPassword.setForeground(Color.WHITE);
			lbPassword.setBounds(200, 300, 150, 40);
			lbPassword.setVisible(false);
			getContentPane().add(lbPassword);
			
			lbAge = new JLabel("나 이");
			lbAge.setHorizontalAlignment(SwingConstants.CENTER);
			lbAge.setFont(new Font("굴림", Font.BOLD, 20));
			lbAge.setOpaque(true); 
			lbAge.setBackground(Color.black);
			lbAge.setForeground(Color.WHITE);
			lbAge.setBounds(200, 400, 150, 40);
			lbAge.setVisible(false);
			getContentPane().add(lbAge);
				
			lbEmail = new JLabel("이메일");
			lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmail.setFont(new Font("굴림", Font.BOLD, 20));
			lbEmail.setOpaque(true); 
			lbEmail.setBackground(Color.black);
			lbEmail.setForeground(Color.WHITE);
			lbEmail.setBounds(200, 500, 150, 40);
			lbEmail.setVisible(false);
			getContentPane().add(lbEmail);
			
			
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(600, 200, 200, 40);
			txtId.setVisible(false);
			getContentPane().add(txtId);
			
			txtPassword = new JPasswordField();
			txtPassword.setColumns(10);
			txtPassword.setBounds(600, 300, 200, 40);
			txtPassword.setVisible(false);
			getContentPane().add(txtPassword);
			
			txtAge = new JTextField();
			txtAge.setColumns(10);
			txtAge.setBounds(600, 400, 200, 40);
			txtAge.setVisible(false);
			getContentPane().add(txtAge);
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(600, 500, 200, 40);
			txtEmail.setVisible(false);
			getContentPane().add(txtEmail);
			
			//회원가입신청버튼
			signUpInsertButton.setVisible(false);
			signUpInsertButton.setBounds(200, 600, 400, 100);
			signUpInsertButton.setBorderPainted(false);
			signUpInsertButton.setContentAreaFilled(false);
			signUpInsertButton.setFocusPainted(false);  // Jbutton기본형식해제
			signUpInsertButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					signUpInsertButton.setIcon(signUpInsertButtonEntered);
					signUpInsertButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					signUpInsertButton.setIcon(signUpInsertButtonBasic);
					signUpInsertButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					
					//가입신청 구현해서 넣기
					insertSignUp();
				}
			});
			getContentPane().add(signUpInsertButton);
			
			
			//회원가입취소          +로그인취소
			signUpCancleButton.setVisible(false);
			signUpCancleButton.setBounds(700, 600, 400, 100);
			signUpCancleButton.setBorderPainted(false);
			signUpCancleButton.setContentAreaFilled(false);
			signUpCancleButton.setFocusPainted(false);  // Jbutton기본형식해제
			signUpCancleButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					signUpCancleButton.setIcon(signUpCancleButtonEntered);
					signUpCancleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					signUpCancleButton.setIcon(signUpCancleButtonBasic);
					signUpCancleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					
					//취소 구현해서 넣기
					cancleSignUp();
				}
			});
			getContentPane().add(signUpCancleButton);
			
			
			
			
			
			
		//로그인버튼
			loginButton.setBounds(40, 575, 400, 100);
			loginButton.setBorderPainted(false);
			loginButton.setContentAreaFilled(false);
			loginButton.setFocusPainted(false);  // Jbutton기본형식해제
			loginButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					loginButton.setIcon(loginButtonEntered);
					loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					loginButton.setIcon(loginButtonBasic);
					loginButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					
					//로그인창 구현해서 넣기
					if(!isLoginScreen) {
						insertLoginScreen();
						isLoginScreen=true;
					}else	if(isLoginScreen) {
						String id ="";
						String password="";
						dService = new DynamicService();
						id = txtLoginId.getText();
						password =new String(txtLoginPassword.getPassword());
						if(id.equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
						}else if(password.equals("")) {
							JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
						}else {
							int res = dService.insertLogin(id,password);
							if(res == 1) {
								JOptionPane.showMessageDialog(null, "없는 아이디 입니다.");
							}
							if(res == 2) {
								JOptionPane.showMessageDialog(null, "비밀번호 오류입니다.");
							}
							if(res == 3) {
								cancleSignUp();
								JOptionPane.showMessageDialog(null, id+"님 로그인했습니다");
								isLoginScreen=false;
							}
						}
					}
					
				}

			});
			getContentPane().add(loginButton);
			
			lbLoginID = new JLabel("아이디");
			lbLoginID.setHorizontalAlignment(SwingConstants.CENTER);
			lbLoginID.setOpaque(true); 
			lbLoginID.setBackground(Color.black);
			lbLoginID.setForeground(Color.WHITE);
			lbLoginID.setFont(new Font("굴림", Font.BOLD, 20));
			lbLoginID.setBounds(400, 300, 150, 40);
			lbLoginID.setVisible(false);
			getContentPane().add(lbLoginID);
			
			lbLoginPassword = new JLabel("비밀번호");
			lbLoginPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lbLoginPassword.setFont(new Font("굴림", Font.BOLD, 20));
			lbLoginPassword.setOpaque(true); 
			lbLoginPassword.setBackground(Color.black);
			lbLoginPassword.setForeground(Color.WHITE);
			lbLoginPassword.setBounds(400, 400, 150, 40);
			lbLoginPassword.setVisible(false);
			getContentPane().add(lbLoginPassword);
	

			
			txtLoginId = new JTextField();
			txtLoginId.setColumns(10);
			txtLoginId.setBounds(650, 300, 200, 40);
			txtLoginId.setVisible(false);
			getContentPane().add(txtLoginId);
			
			txtLoginPassword = new JPasswordField();
			txtLoginPassword.setColumns(10);
			txtLoginPassword.setBounds(650, 400, 200, 40);
			txtLoginPassword.setVisible(false);
			getContentPane().add(txtLoginPassword);
			
			
			
			
		//랭킹버튼
			rankingButton.setBounds(700, 575, 400, 100);
			rankingButton.setBorderPainted(false);
			rankingButton.setContentAreaFilled(false);
			rankingButton.setFocusPainted(false);  // Jbutton기본형식해제
			rankingButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					rankingButton.setIcon(rankingButtonEntered);
					rankingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					rankingButton.setIcon(rankingButtonBasic);
					rankingButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					//랭킹창 구현해서 넣기
					rankingScreenOn();
				}
			});
			getContentPane().add(rankingButton);
			
			String[] trackListTitle = new String[trackList.size()];
			for(int i=0;i<trackList.size();i++)
				trackListTitle[i] = trackList.get(i).getTitleName();
			
			cbTitle = new JComboBox();
			cbTitle.setModel(new DefaultComboBoxModel(trackListTitle));
			cbTitle.setBounds(900, 100, 250, 60);
			cbTitle.setVisible(false);
			getContentPane().add(cbTitle);
			
			insertSearchButton.setVisible(false);
			insertSearchButton.setBounds(100, 600, 400, 100);
			insertSearchButton.setBorderPainted(false);
			insertSearchButton.setContentAreaFilled(false);
			insertSearchButton.setFocusPainted(false);  // Jbutton기본형식해제
			insertSearchButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					insertSearchButton.setIcon(insertSearchButtonEntered);
					insertSearchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					insertSearchButton.setIcon(insertSearchButtonBasic);
					insertSearchButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					insertRankSearch();
					
				}
			});
			getContentPane().add(insertSearchButton);
			
			rankingCancleButton.setVisible(false);
			rankingCancleButton.setBounds(700, 600, 400, 100);
			rankingCancleButton.setBorderPainted(false);
			rankingCancleButton.setContentAreaFilled(false);
			rankingCancleButton.setFocusPainted(false);  // Jbutton기본형식해제
			rankingCancleButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					rankingCancleButton.setIcon(rankingCancleButtonEntered);
					rankingCancleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
					Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3",false);
					buttonEnteredMusic.start();
				}
				@Override
				public void mouseExited(MouseEvent e ) {
					rankingCancleButton.setIcon(rankingCancleButtonBasic);
					rankingCancleButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
					buttonPressedMusic.start();
					
					//취소 구현해서 넣기
					rankingScreenOff();
				}
			});
			getContentPane().add(rankingCancleButton);
			
			
			
			
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
			getContentPane().add(leftButton);
			
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
			getContentPane().add(rightButton);
			
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
					Timer timer = new Timer();
					TimerTask timerTask = new TimerTask() {
						@Override
						public void run() {
							int res = game.setInsertScore();
							game.close();
							backMain();
							if(res==1)JOptionPane.showMessageDialog(null, "점수를 저장했습니다");
							if(res==0)JOptionPane.showMessageDialog(null, "점수를 저장하지 않았습니다");
						}
					};
					timer.schedule(timerTask, trackList.get(nowselected).getPlayTime()+3000);
				}
			});
			getContentPane().add(easyButton);
			
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
					Timer timer = new Timer();
					TimerTask timerTask = new TimerTask() {
						@Override
						public void run() {
							int res = game.setInsertScore();
							game.close();
							backMain();
							if(res==1)JOptionPane.showMessageDialog(null, "점수를 저장했습니다");
							if(res==0)JOptionPane.showMessageDialog(null, "점수를 저장하지 않았습니다");
						}
					};
					timer.schedule(timerTask, trackList.get(nowselected).getPlayTime()+3000);
				}
			});
			getContentPane().add(hardButton);
			
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
					game.close();
				}
			});
			getContentPane().add(backButton);
			
			
		
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
		getContentPane().add(menuBar);
		

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
		g.drawImage(background,0,0,null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340 , 70 , null);
		}
		if(isGameScreen){
			game.screenDraw(g);
		}
		if(isRanking) {
			g.drawImage(rankingBackGround,150,200,null);
		g.setColor(Color.WHITE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD , 35));
		g.drawString(rankTitle, 400, 150);
		g.setFont(new Font("Arial", Font.BOLD , 25));
		g.drawString("Rank",200,250);
		g.drawString("ID",400,250);
		g.drawString("DIFFICULT",600,250);
		g.drawString("SCORE",800,250);
		g.setFont(new Font("Arial", Font.BOLD , 20));
		g.setColor(Color.WHITE);
		for(int i=0;i<prDTOs.size();i++) {
			g.drawString(prDTOs.get(i).getIdx()+"", 200, 350+50*i);
			g.drawString(prDTOs.get(i).getID(), 400, 350+50*i);
			g.drawString(prDTOs.get(i).getDifficulty(), 600, 350+50*i);
			g.drawString(prDTOs.get(i).getScore()+"", 800, 350+50*i);
		}
		
	}
		paintComponents(g);
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
		signUpButton.setVisible(false);
		loginButton.setVisible(false);
		rankingButton.setVisible(false);
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
			game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic(),loginID);
			game.start();
			setFocusable(true);
			requestFocus();
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
	}
	
	private void SelectSignUp() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		signUpButton.setVisible(false);
		loginButton.setVisible(false);
		rankingButton.setVisible(false);
		signUpScreenOn();
		


		
	}
	
	private void insertSignUp() {
		String id = txtId.getText(); 
		String password = new String(txtPassword.getPassword());
		String email = txtEmail.getText();
		String age = txtAge.getText();
		//service 연결해서 정규식체크하고
		dService = new DynamicService();
		if(!dService.checkID(id)) {
			JOptionPane.showMessageDialog(null, "id중복");
			signUpScreenOn();
		}else if(!dService.checkPwd(password)) {
			JOptionPane.showMessageDialog(null, "비밀번호는 6~20글자만가능합니다");
			signUpScreenOn();
		}else if(Integer.parseInt(age)<15) {
			JOptionPane.showMessageDialog(null, "15세이상만가입가능합니다");
			signUpScreenOn();
		}else if(!dService.checkAge(Integer.parseInt(age))) {
			JOptionPane.showMessageDialog(null, "나이를 다시 입력해 주세요");
			signUpScreenOn();
		}else if(!dService.checkEmail(email)) {
			JOptionPane.showMessageDialog(null, "이메일주소를 다시 입력해 주세요");
			signUpScreenOn();
		}else	{
			int res=0;
			idDTO = new IdDTO();
			idDTO.setId(id);
			idDTO.setPassword(password);
			idDTO.setAge(Integer.parseInt(age));
			idDTO.setEmail(email);
		//service에서 dao연결해서 회원가입 ㄱ
			res = dService.setSignUp(idDTO);
			if(res==0) JOptionPane.showMessageDialog(null, "가입실패했습니다."); cancleSignUp();
			if(res==1) JOptionPane.showMessageDialog(null, "가입성공 로그인하세요"); cancleSignUp();
		}	
	}
		
	
	private void cancleSignUp() {
		signUpScreenOff();
	
		
		lbLoginID.setVisible(false);
		lbLoginPassword.setVisible(false);
		txtLoginId.setVisible(false);
		txtLoginPassword.setVisible(false);
		isLoginScreen=false;
		
		startButton.setVisible(true);
		quitButton.setVisible(true);
		signUpButton.setVisible(true);
		loginButton.setVisible(true);
		rankingButton.setVisible(true);
	}
	
	private void signUpScreenOff() {
		lbID.setVisible(false);
		lbAge.setVisible(false);
		lbPassword.setVisible(false);
		lbEmail.setVisible(false);
		txtId.setVisible(false);
		txtPassword.setVisible(false);
		txtAge.setVisible(false);
		txtEmail.setVisible(false);
		signUpInsertButton.setVisible(false);
		signUpCancleButton.setVisible(false);
	}
	
	private void signUpScreenOn() {
		lbID.setVisible(true);
		lbAge.setVisible(true);
		lbPassword.setVisible(true);
		lbEmail.setVisible(true);
		txtId.setVisible(true);
		txtPassword.setVisible(true);
		txtAge.setVisible(true);
		txtEmail.setVisible(true);
		signUpInsertButton.setVisible(true);
		signUpCancleButton.setVisible(true);
	}
	
	private void insertLoginScreen() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		signUpButton.setVisible(false);
		lbLoginID.setVisible(true);
		lbLoginPassword.setVisible(true);
		txtLoginId.setVisible(true);
		txtLoginPassword.setVisible(true);
		signUpCancleButton.setVisible(true);
		rankingButton.setVisible(false);
	}
	
	private void rankingScreenOn() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		signUpButton.setVisible(false);
		loginButton.setVisible(false);
		rankingButton.setVisible(false);
		insertSearchButton.setVisible(true);
		rankingCancleButton.setVisible(true);
		cbTitle.setVisible(true);
		
	}
	
	private void rankingScreenOff() {
		startButton.setVisible(true);
		quitButton.setVisible(true);
		signUpButton.setVisible(true);
		loginButton.setVisible(true);
		rankingButton.setVisible(true);
		insertSearchButton.setVisible(false);
		rankingCancleButton.setVisible(false);
		cbTitle.setVisible(false);
		isRanking = false;
	}
	
	private void insertRankSearch() {
		prDTOs = new ArrayList<PlayRecordDTO>();
		dao = DAO.getInstance();
		rankTitle=cbTitle.getSelectedItem().toString();
		prDTOs=dao.getSearchRank(rankTitle);
		isRanking = true;
		
	}
	
}
