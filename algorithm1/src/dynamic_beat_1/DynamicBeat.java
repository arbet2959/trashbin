package dynamic_beat_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame{
	private Image screenImage;
	private Graphics screenGraphics;
	
	private Image introBackground;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

//		introBackground = new ImageIcon(Main.class.getResource("./images/introBackground.jpg")).getImage();
		introBackground = new ImageIcon(Main.class.getClassLoader().getResource("./images/introBackground.jpg")).getImage();
	
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}	
	 //JFrame실행시 updated(Graphics g) -> paint(Graphics g) 자동실행
	@Override
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(introBackground,0,0,null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground,0,0,null);
		this.repaint();
	}
}