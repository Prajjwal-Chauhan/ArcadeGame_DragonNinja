package com.tt.game.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.tt.game.utils.GameConstants;

public class Player extends Sprite implements GameConstants {

	private BufferedImage IdleImages[] = new BufferedImage[12];
	private BufferedImage walkImages[] = new BufferedImage[4];
	private BufferedImage kickImages[] = new BufferedImage[8];
	private BufferedImage punchImages[] = new BufferedImage[7];
	private BufferedImage jumpImages[] = new BufferedImage[1];
	private BufferedImage damageImages[] = new BufferedImage[7];
	private BufferedImage fallImages[] = new BufferedImage[11];
	private BufferedImage hadwokenImages[] = new BufferedImage[14];
	private BufferedImage deadImages[] = new BufferedImage[1];
	private BufferedImage winImages[] = new BufferedImage[1];

	private boolean isAttacking;

	public Player() throws IOException {
		x = 100;
		w = 100;
		h = 200;
		y = FLOOR - h;

		image = ImageIO.read(Player.class.getResource(PLAYER_IMG));
		currentMove = IDLE;
		loadIdleImages();
		loadWalkImages();
		loadkickImages();
		loadpunchImages();
		loadJumpImages();
		loadDamageImages();
		loadFallImages();
		loadHadwokenImages();
		loadDeadImages();
		loadWinImages();
	}

	public void jump() {
		if (!isJump) {
			isJump = true;
//			currentMove = JUMP;
			force = -26;
			y = y + force;
		}

	}

	public void fall() {
//		currentMove = ENTRY;
		if (y >= (FLOOR - h)) {
			isJump = false;
//			currentMove = IDLE;
			return;
		}
		y = y + force;
		force = force + GRAVITY;
		if (force == -10)
			currentMove = FALL;
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
		IdleImages[0] = image.getSubimage(165, 45, 28, 65);
		IdleImages[1] = image.getSubimage(165, 45, 28, 65);
		IdleImages[2] = image.getSubimage(165, 45, 28, 65);
		IdleImages[3] = image.getSubimage(165, 45, 28, 65);
		IdleImages[4] = image.getSubimage(165, 45, 28, 65);
		IdleImages[5] = image.getSubimage(165, 45, 28, 65);
		IdleImages[6] = image.getSubimage(197, 45, 28, 65);
		IdleImages[7] = image.getSubimage(197, 45, 28, 65);
		IdleImages[8] = image.getSubimage(197, 45, 28, 65);
		IdleImages[9] = image.getSubimage(197, 45, 28, 65);
		IdleImages[10] = image.getSubimage(197, 45, 28, 65);
		IdleImages[11] = image.getSubimage(197, 45, 28, 65);
	}

	private void loadHadwokenImages() {
		hadwokenImages[0] = image.getSubimage(6, 1247, 34, 65);
		hadwokenImages[1] = image.getSubimage(44, 1247, 34, 65);
		hadwokenImages[2] = image.getSubimage(81, 1247, 34, 65);
		hadwokenImages[3] = image.getSubimage(121, 1247, 34, 65);
		hadwokenImages[4] = image.getSubimage(159, 1247, 34, 65);
		hadwokenImages[5] = image.getSubimage(196, 1247, 34, 65);
		hadwokenImages[6] = image.getSubimage(235, 1247, 34, 65);
		hadwokenImages[7] = image.getSubimage(274, 1247, 34, 65);
		hadwokenImages[8] = image.getSubimage(313, 1247, 45, 65);
		hadwokenImages[9] = image.getSubimage(313, 1247, 93, 65);
		hadwokenImages[10] = image.getSubimage(313, 1247, 120, 65);
		hadwokenImages[11] = image.getSubimage(313, 1244, 152, 69);
		hadwokenImages[12] = image.getSubimage(313, 1243, 186, 70);
		hadwokenImages[13] = image.getSubimage(313, 1243, 222, 70);
	}

	private void loadWalkImages() {
		walkImages[0] = image.getSubimage(8, 45, 32, 70);
		walkImages[1] = image.getSubimage(46, 45, 25, 70);
		walkImages[2] = image.getSubimage(76, 45, 30, 70);
		walkImages[3] = image.getSubimage(111, 43, 25, 70);
	}

	private void loadkickImages() {
		kickImages[0] = image.getSubimage(5, 142, 34, 66);
		kickImages[1] = image.getSubimage(6, 315, 34, 66);
		kickImages[2] = image.getSubimage(44, 315, 50, 66);
		kickImages[3] = image.getSubimage(46, 45, 25, 70);
		kickImages[4] = image.getSubimage(122, 313, 30, 68);
		kickImages[5] = image.getSubimage(156, 314, 49, 67);
		kickImages[6] = image.getSubimage(122, 313, 30, 68);
		kickImages[7] = image.getSubimage(5, 142, 34, 66);
	}

	private void loadDeadImages() {
		deadImages[0] = image.getSubimage(326, 873, 77, 55);
	}

	private void loadpunchImages() {
		punchImages[0] = image.getSubimage(5, 227, 33, 66);
		punchImages[1] = image.getSubimage(67, 227, 42, 66);
		punchImages[2] = image.getSubimage(67, 227, 42, 66);
		punchImages[3] = image.getSubimage(5, 142, 34, 66);
		punchImages[4] = image.getSubimage(137, 229, 43, 64);
		punchImages[5] = image.getSubimage(137, 229, 43, 64);
		punchImages[6] = image.getSubimage(5, 142, 34, 66);
	}

	private void loadJumpImages() {
		jumpImages[0] = image.getSubimage(280, 561, 34, 69);
	}

	private void loadWinImages() {
		winImages[0] = image.getSubimage(426, 846, 32, 83);
	}

	private void loadDamageImages() {
		damageImages[0] = image.getSubimage(6, 861, 34, 66);
		damageImages[1] = image.getSubimage(6, 861, 34, 66);
		damageImages[2] = image.getSubimage(6, 861, 34, 66);
		damageImages[3] = image.getSubimage(6, 861, 34, 66);
		damageImages[4] = image.getSubimage(6, 861, 34, 66);
		damageImages[5] = image.getSubimage(6, 861, 34, 66);
		damageImages[6] = image.getSubimage(6, 861, 34, 66);
	}

	private void loadFallImages() {
		fallImages[0] = image.getSubimage(318, 577, 34, 78);
		fallImages[1] = image.getSubimage(318, 577, 34, 78);
		fallImages[2] = image.getSubimage(358, 575, 30, 78);
		fallImages[3] = image.getSubimage(393, 590, 30, 78);
		fallImages[4] = image.getSubimage(428, 575, 31, 78);
		fallImages[5] = image.getSubimage(463, 576, 31, 78);
		fallImages[6] = image.getSubimage(358, 575, 30, 78);
		fallImages[7] = image.getSubimage(393, 590, 30, 78);
		fallImages[8] = image.getSubimage(428, 575, 31, 78);
		fallImages[9] = image.getSubimage(463, 576, 31, 78);
		fallImages[10] = image.getSubimage(498, 552, 34, 78);
	}

	private BufferedImage printIdle() {
		if (imageIndex > 11) {
			imageIndex = 0;
		}
		BufferedImage img = IdleImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printWalk() {
		if (imageIndex > 3) {
			imageIndex = 0;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printKick() {
		if (imageIndex > 7) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = kickImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printpunch() {
		if (imageIndex > 6) {
			imageIndex = 0;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = punchImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printhadwoken() {
		if (imageIndex > 8) {
			h = 220;
			y = FLOOR - h;
			w = 300;
		}
		if (imageIndex > 10) {
			h = 230;
			y = FLOOR - h;
			w = 400;
		}
		if (imageIndex > 12) {
			h = 250;
			y = FLOOR - h;
			w = 600;
		}
		if (imageIndex > 13) {
			imageIndex = 0;
			h = 200;
			y = FLOOR - h;
			w = 100;
			currentMove = IDLE;
			isAttacking = false;
		}
		BufferedImage img = hadwokenImages[imageIndex];
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

	private BufferedImage printJump() {
		if (imageIndex > 0) {
			imageIndex = 0;
		}
		BufferedImage img = jumpImages[imageIndex];
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

	private BufferedImage printDamage() {
		if (imageIndex > 6) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = damageImages[imageIndex];
		imageIndex++; // Change Image Frames
		return img;
	}

	private BufferedImage printFall() {
		if (imageIndex > 10) {
			return fallImages[10];
		}
		BufferedImage img = fallImages[imageIndex];
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
		if (currentMove == JUMP) {
			return printJump();
		}
		if (currentMove == DAMAGE) {
			return printDamage();
		}
		if (currentMove == FALL) {
			return printFall();
		}
		if (currentMove == HADWOKEN) {
			return printhadwoken();
		}
		if (currentMove == DEAD) {
			return printdead();
		}
		if (currentMove == WIN) {
			return printWin();
		} else
			return printIdle();
	}

}
