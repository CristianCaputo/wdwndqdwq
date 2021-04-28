import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class Mp3 {

	private Player player;
	private FileInputStream FIS;
	private BufferedInputStream BIS;
	private boolean canResume;
	private String filename;
	private int total;
	private int stopped;
	private boolean valid;

	public Mp3(String filename) {
		player = null;
		FIS = null;
		valid = false;
		BIS = null;
		this.filename = filename;
		total = 0;
		stopped = 0;
		canResume = false;
	}
	
	public void close() {
		if (player != null)
			player.close();
	}
	
	public boolean canResume() {
		return canResume;
	}

	public void pause() {
		try {
			stopped = FIS.available();
			player.close();
			FIS = null;
			BIS = null;
			player = null;
			if (valid)
				canResume = true;
		} catch (Exception e) {

		}
	}

	public void resume() {
		if (!canResume){
		
			return;}
		if (play(total - stopped))
			canResume = false;
	}

	public boolean play(int pos) {
		
		valid = true;
		canResume = false;
		try {
			FIS = new FileInputStream(filename);
			total = FIS.available();
			if (pos > -1)
				FIS.skip(pos);
			BIS = new BufferedInputStream(FIS);
			player = new Player(BIS);
			new Thread(new Runnable() {
				public void run() {
					try {
						player.play();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error playing mp3 file"+e);
						valid = false;
					}
				}
			}).start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error playing mp3 file");
			valid = false;
		}
		return valid;
	}
public static void main(String[] args) {
	Mp3 br=new Mp3("note/re.mp3");
	br.play(0);
}

}