package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tt.game.utils.GameConstants;

public class Boss extends Sprite implements GameConstants {
	private BufferedImage IdleImages[] = new BufferedImage[1];
	private BufferedImage walkImages[] = new BufferedImage[3];
	private BufferedImage kickImages[] = new BufferedImage[4];
	private BufferedImage punchImages[] = new BufferedImage[3];
	private BufferedImage HadWokenImages[] = new BufferedImage[6];
	private BufferedImage damageImages[] = new BufferedImage[3];
	private BufferedImage jumpImages[] = new BufferedImage[1];
	private BufferedImage deadImages[] = new BufferedImage[1];
	private BufferedImage winImages[] = new BufferedImage[1];
	private boolean isAttacking;

	public Boss() throws IOException {
		x = 4000;
		w = 150;
		h = 250;
		y = FLOOR - h;

		image = ImageIO.read(Boss.class.getResource(BOSS_IMG));
		currentMove = IDLE;
		loadIdleImages();
		loadWalkImages();
		loadkickImages();
		loadpunchImages();
		loadHadWokenImages();
		loadJumpImages();
		loadDeadImages();
		loadDamageImages();
		loadWinImages();
	}

	public void jump() {
		if (!isJump) {
			isJump = true;
			force = -26;
			y = y + force;
		}

	}

	public void fall() {
		if (y >= (FLOOR - h)) {
			isJump = false;
			return;
		}
		y = y + force;
		force = force + GRAVITY;
		if (force == 26)
			currentMove = IDLE;
	}

	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	private void loadIdleImages() {
		IdleImages[0] = image.getSubimage(6, 40, 44, 62);
	}

	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(6, 40, 44, 62);
		walkImages[1] = image.getSubimage(53, 40, 44, 62);
		walkImages[2] = image.getSubimage(102, 40, 44, 62);
	}

	private void loadDeadImages() {
		deadImages[0] = image.getSubimage(148, 413, 69, 63);
	}

	private void loadDamageImages() {
		damageImages[0] = image.getSubimage(72, 412, 48, 63);
		damageImages[1] = image.getSubimage(72, 412, 48, 63);
		damageImages[2] = image.getSubimage(72, 412, 48, 63);
	}

	private void loadkickImages() {
		kickImages[0] = image.getSubimage(6, 319, 44, 62);
		kickImages[1] = image.getSubimage(53, 304, 45, 77);
		kickImages[2] = image.getSubimage(99, 318, 45, 63);
		kickImages[3] = image.getSubimage(266, 320, 47, 62);
	}

	private void loadpunchImages() {
		punchImages[0] = image.getSubimage(6, 123, 44, 60);
		punchImages[1] = image.getSubimage(54, 123, 57, 60);
		punchImages[2] = image.getSubimage(113, 123, 57, 60);
	}

	private void loadHadWokenImages() {
		HadWokenImages[0] = image.getSubimage(4, 591, 43, 62);
		HadWokenImages[1] = image.getSubimage(50, 591, 55, 62);
		HadWokenImages[2] = image.getSubimage(108, 591, 69, 63);
		HadWokenImages[3] = image.getSubimage(179, 591, 74, 63);
		HadWokenImages[4] = image.getSubimage(256, 591, 74, 63);
		HadWokenImages[5] = image.getSubimage(331, 591, 44, 63);
	}

	private void loadJumpImages() {
		jumpImages[0] = image.getSubimage(6, 400, 41, 75);
	}

	private void loadWinImages() {
		winImages[0] = image.getSubimage(53, 304, 45, 77);
	}

	private BufferedImage printIdle() {
		if (imageIndex > 0) {
			imageIndex = 0;
		}
		BufferedImage img = IdleImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printWalk() {
		if (imageIndex > 2) {
			imageIndex = 0;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printKick() {
		if (imageIndex == 2) {
			x = x - 200;
		}
		if (imageIndex > 3) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printpunch() {
		if (imageIndex > 2) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printhadwoken() {
		if (imageIndex > 1) {
			w = 200;
		}
		if (imageIndex > 2) {
			x -= 20;
			w = 225;
			printHadWoken2();
		}
		if (imageIndex > 4) {
			imageIndex = 0;
			x += 70;
			w = 150;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = HadWokenImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printHadWoken2() {
		x -= 20;
		BufferedImage img = image.getSubimage(136, 511, 207, 64);
		;
		return img;
	}

	private BufferedImage printJump() {
		if (imageIndex > 0) {
			imageIndex = 0;
		}
		BufferedImage img = jumpImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printDamage() {
		if (imageIndex > 2) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = damageImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printWin() {
		if (imageIndex > 0) {
			imageIndex = 0;
		}
		BufferedImage img = winImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printdead() {
		if (imageIndex > 0) {
			imageIndex = 0;
			w = 200;
		}
		BufferedImage img = deadImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	@Override
	public BufferedImage defaultImg() {
		// TODO Auto-generated method stub
		if (currentMove == WALK) {
			return printWalk();
		}
		if (currentMove == KICK) {
			return printKick();
		}
		if (currentMove == PUNCH) {
			return printpunch();
		}
		if (currentMove == HADWOKEN) {
			return printhadwoken();
		}
		if (currentMove == JUMP) {
			return printJump();
		}
		if (currentMove == DEAD) {
			return printdead();
		}
		if (currentMove == DAMAGE) {
			return printDamage();
		}
		if (currentMove == WIN) {
			return printWin();
		} else
			return printIdle();
	}
}
