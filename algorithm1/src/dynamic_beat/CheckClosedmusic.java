package dynamic_beat;

public class CheckClosedmusic extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				if(Game.gameMusic.isClosed()) {
<<<<<<< HEAD
//					DynamicBeat.game.close2();
=======
					DynamicBeat.game.close2();
>>>>>>> branch 'main' of https://github.com/arbet2959/trashbin.git
				System.out.println("11111111111111111111111111111111111111111111");
					this.interrupt();
				}
				System.out.println("112");
					CheckClosedmusic.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}

