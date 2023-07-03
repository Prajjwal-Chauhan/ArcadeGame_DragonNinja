package com.tt.game.canvas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.tt.game.utils.GameConstants;

import jaco.mp3.player.MP3Player;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow implements GameConstants {

	private JLabel label = new JLabel();
	private MP3Player mp3player;

	@SuppressWarnings("unused")
	public SplashScreen() throws InterruptedException {
		setSize(1266, 692);
		Icon icon1 = new ImageIcon(SplashScreen.class.getResource(SPLASH_IMG));
		Icon icon2 = new ImageIcon(SplashScreen.class.getResource(INSTRUCTION_IMG));
		Icon icon3 = new ImageIcon(SplashScreen.class.getResource(CONTROLS_IMG));
		label.setIcon(icon1);
		setLocationRelativeTo(null);
		setVisible(true);

		this.add(label);
		setVisible(true);
		loadMusic();

		Thread.sleep(10000);
		label.setIcon(icon2);
		Thread.sleep(15000);
		label.setIcon(icon3);

		try {
			Thread.sleep(25000);
			setVisible(false);
			dispose();
			mp3player.stop();
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	private void loadMusic() {
		mp3player = new MP3Player(Board.class.getResource(SPLASH_MUSIC));
		mp3player.play();
	}

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("unused")
		SplashScreen screen = new SplashScreen();

	}

}