package com.tt.game.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Power extends Sprite {

	String playerName;

	public Power(int x, String playerName) throws IOException {
		super();
		this.x = x;
		this.playerName = playerName;
		y = 100;
		h = 20;
		w = 350;
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printRectangle(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(x, y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x, y, health, h);
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("times", Font.BOLD, 20));
		pen.drawString(playerName, x + 5, y + 40);
	}

}
