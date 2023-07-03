package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tt.game.utils.GameConstants;

public class EnemySprite extends Sprite implements GameConstants {

	public EnemySprite() throws IOException {
		// TODO Auto-generated constructor stub
		image = ImageIO.read(EnemySprite.class.getResource(ENEMY_IMG));
		h = 200;
		w = 100;
		y = FLOOR - h;
		isAlive = true;

	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		return image;
	}

}
