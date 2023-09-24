package dynamic_beat_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Game extends Thread{
	

	private Image noteRouteLineImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRouteLine.png")).getImage();
	private Image judgementLineImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/judgementLine.png")).getImage();
	private Image gameInfoImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/gameInfo.png")).getImage();
	private Image noteRouteSImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteDImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteFImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteJImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteKImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	private Image noteRouteLImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	List<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		
	}
	
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		g.drawImage(judgementLineImage, 0, 580, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		
		for(Note note : noteList)
			note.screenDraw(g);

		g.setColor(Color.WHITE);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD , 30));
		g.drawString(titleName,20,702);
		g.drawString(difficulty, 1190, 702);
		
		g.setFont(new Font("Arial", Font.PLAIN , 26));
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		 
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.PLAIN , 26));
		g.drawString("000000", 565, 702);
		
		
	}
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressF() {
		noteRouteFImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoutePressed.png")).getImage();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getClassLoader().getResource("./images/noteRoute.png")).getImage();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
		Beat[] beats = null;
		if(titleName.equals("Joakim karud - Mighty Love")) {
			int startTime = 4460 - Main.REACH_TIME*1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime,"S"),
					new Beat(startTime+gap*2,"D"),
					new Beat(startTime+gap*4,"S"),
					new Beat(startTime+gap*6,"D"),
					new Beat(startTime+gap*8,"D"),
					new Beat(startTime+gap*10,"Space"),
					new Beat(startTime+gap*12,"J"),
					new Beat(startTime+gap*14,"L"),
					
			};
		}else if(titleName.equals("Joakim Karud - Wild Flower")) {
			int startTime = 4000;
			beats = new Beat[] {
					new Beat(startTime,"Space")
			};
		}else if(titleName.equals("Bendsound - Energy")) {
			int startTime = 4000;
			beats = new Beat[] {
					new Beat(startTime,"Space")
			};
		}
		int i =0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.gettime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
