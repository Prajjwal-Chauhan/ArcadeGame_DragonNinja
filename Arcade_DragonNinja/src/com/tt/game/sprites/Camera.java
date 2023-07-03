package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.tt.game.canvas.Board;

public class Camera extends Sprite {
	BufferedImage backgroundImage;
	BufferedImage partOfImage;

	public Camera() throws IOException {
		super();
		x = 5;
		y = 5;
		w = 450;
		h = 235;
		try {
			backgroundImage = ImageIO.read(Board.class.getResource(BG_IMG));
			partOfImage = backgroundImage.getSubimage(x, y, w, h);
		} catch (Exception ex) {
			System.out.println("Background Image Loading failed ...");
			System.exit(0);

		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		partOfImage = backgroundImage.getSubimage(x, y, w, h);
		return partOfImage;
	}
}
