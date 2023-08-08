package CardGame;

import javax.swing.SwingUtilities;

public class InitialisationMain {

	public static void main(String[] args) {
	   SwingUtilities.invokeLater(new Runnable() {
	       public void run() {
	    	   InitialisationTest cardGame = new InitialisationTest();
	           cardGame.playNextCard(); // Call updateCardLabels after the frame is visible
	       }
	   });
	}
}
