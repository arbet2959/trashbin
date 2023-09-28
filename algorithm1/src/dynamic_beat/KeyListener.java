package dynamic_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(DynamicBeat.game == null) {
			System.out.println("123123");
			return;
		}
		switch (e.getKeyCode()) {
			case KeyEvent.VK_S:
				DynamicBeat.game.pressS();
				new Music("drumSmall1.mp3",false).start();
				break;
			case KeyEvent.VK_D:
				DynamicBeat.game.pressD();
				new Music("drumSmall1.mp3",false).start();
				break;
			case KeyEvent.VK_F:
				DynamicBeat.game.pressF();
				new Music("drumSmall1.mp3",false).start();
				break;
			case KeyEvent.VK_SPACE:
				DynamicBeat.game.pressSpace();
				new Music("drumBig1.mp3",false).start();
				break;
			case KeyEvent.VK_J:
				DynamicBeat.game.pressJ();
				new Music("drumSmall1.mp3",false).start();
				break;
			case KeyEvent.VK_K:
				DynamicBeat.game.pressK();
				new Music("drumSmall1.mp3",false).start();
				break;
			case KeyEvent.VK_L:
				DynamicBeat.game.pressL();
				new Music("drumSmall1.mp3",false).start();
				break;
		}
	}
		
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_S:
				DynamicBeat.game.releaseS();
				break;
			case KeyEvent.VK_D:
				DynamicBeat.game.releaseD();
				break;
			case KeyEvent.VK_F:
				DynamicBeat.game.releaseF();
				break;
			case KeyEvent.VK_SPACE:
				DynamicBeat.game.releaseSpace();
				break;
			case KeyEvent.VK_J:
				DynamicBeat.game.releaseJ();
				break;
			case KeyEvent.VK_K:
				DynamicBeat.game.releaseK();
				break;
			case KeyEvent.VK_L:
				DynamicBeat.game.releaseL();
				break;
		}		
	}


}
