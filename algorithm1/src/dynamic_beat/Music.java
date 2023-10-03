package dynamic_beat;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	 public Music(String name, boolean isLoop) {
		 try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	 
	 public int gettime() {
		 if(player == null)
			 return -1;
		 return player.getPosition();
	 }
	 
	 public void close() {
		 isLoop = false;
		 player.close();
		 this.interrupt();
	 }
	 
	 public boolean isClosed() {
		  return player.isComplete();
	 }
	 
	 @Override
	 public void run() {
		 try {
			 do {
					player.play();
					if(player.isComplete()) {
						fis = new FileInputStream(file);
						bis = new BufferedInputStream(fis);
						player = new Player(bis);
					}
			 } while(isLoop);
		} catch (Exception e) {
			System.out.println(e.toString());
		}	
		 
	 }
}
