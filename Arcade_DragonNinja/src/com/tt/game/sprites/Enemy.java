package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

//import javax.imageio.ImageIO;

import com.tt.game.utils.GameConstants;

public class Enemy extends Sprite implements GameConstants {

	private BufferedImage[] enemyImages;

	public Enemy(BufferedImage[] enemyImages, int gap) throws IOException {
		this.enemyImages = enemyImages;
		x = GWIDTH + gap;
		currentMove = WALK;
		imageIndex = 0;
		speed = -SPEED * 3;

	}

	public void outOfScreen() {

		if (x <= 0) {
			isAlive = false;
		}
	}

	private BufferedImage printEnemy() {
		if (imageIndex > 10) {
			imageIndex = 0;
		}
		BufferedImage img = enemyImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		move();
		outOfScreen();
		return printEnemy();
	}

}
