package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tt.game.utils.GameConstants;

public class BossHadWoken extends Sprite implements GameConstants {
	public BossHadWoken(int X) throws IOException {
		x = X - 250;
		w = 450;
		h = 240;
		y = FLOOR - h;
		speed = -SPEED * 15;

		image = ImageIO.read(Boss.class.getResource(BOSS_IMG));
	}

	public void outOfScreen() {

		if (x <= -400) {
			isAlive = false;
		}
	}

	private BufferedImage printHadWoken2() {
		BufferedImage img = image.getSubimage(136, 511, 207, 64);
		;
		return img;
	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		move();
		outOfScreen();
		return printHadWoken2();

	}
}
