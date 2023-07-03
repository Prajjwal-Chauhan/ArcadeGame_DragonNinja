package com.tt.game.canvas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tt.game.utils.GameConstants;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements GameConstants {

	public GameFrame() throws Exception {
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		JOptionPane.showMessageDialog(null, "Waves are Approaching : " + "Be READY NINJA XD");
		add(board); // board added in frame
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
