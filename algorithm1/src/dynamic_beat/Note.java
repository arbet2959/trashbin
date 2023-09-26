package dynamic_beat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage= new ImageIcon(Main.class.getClassLoader().getResource("./images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000/Main.SLEEP_TIME * Main.NOTE_SPEED) *Main.REACH_TIME; //	1초에스레드가돌아가는횟수 * 횟수당움직이는픽셀
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) this.x = 228;
		if(noteType.equals("D")) this.x = 332;
		if(noteType.equals("F")) this.x = 436;
		if(noteType.equals("Space")) this.x = 540;
		if(noteType.equals("J")) this.x = 744;
		if(noteType.equals("K")) this.x = 848;
		if(noteType.equals("L")) this.x = 952;
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space")) 
			g.drawImage(noteBasicImage, x, y, null);
		else{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);
		}
	 }
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y>620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String judge() { // 580기준
		if(y>=610) {
			close();
			return "Late";
		}else if(y>=600) {
			close();
			return "Good";
		}else if(y>=587) {
			close();
			return "Great";
		}else if(y>=573) {
			close();
			return "Perpect";
		}else if(y>=565) {
			close();
			return "Great";
		}else if(y>=550) {
			close();
			return "Good";	
		}else if(y>=535) {
			close();
			return "Early";
		}else return "None";
		
	}
	
	public int getY() {
		return y;
	}
	public boolean isProceeded() {
		return proceeded;
	}
}
