package com.tt.game.utils;

import java.awt.image.BufferedImage;

public interface EnemyTypes {
	public static final BufferedImage handAttackEnemy[] = new BufferedImage[11];
	BufferedImage batAttackEnemy[] = new BufferedImage[11];
	BufferedImage knifeAttackEnemy[] = new BufferedImage[11];

	static void loadHandAttackEnemy(BufferedImage spriteImage) {
		handAttackEnemy[0] = spriteImage.getSubimage(4, 551, 29, 53);
		handAttackEnemy[1] = spriteImage.getSubimage(35, 551, 29, 53);
		handAttackEnemy[2] = spriteImage.getSubimage(66, 551, 29, 53);
		handAttackEnemy[3] = spriteImage.getSubimage(95, 551, 29, 53);
		handAttackEnemy[4] = spriteImage.getSubimage(216, 551, 29, 53);
		handAttackEnemy[5] = spriteImage.getSubimage(248, 551, 35, 53);
		handAttackEnemy[6] = spriteImage.getSubimage(4, 482, 20, 53);
		handAttackEnemy[7] = spriteImage.getSubimage(24, 482, 27, 53);
		handAttackEnemy[8] = spriteImage.getSubimage(52, 482, 20, 53);
		handAttackEnemy[9] = spriteImage.getSubimage(75, 482, 20, 53);
		handAttackEnemy[10] = spriteImage.getSubimage(248, 551, 35, 53);
	}

	static void loadBatAttackEnemy(BufferedImage spriteImage) {
		batAttackEnemy[0] = spriteImage.getSubimage(4, 174, 29, 53);
		batAttackEnemy[1] = spriteImage.getSubimage(36, 174, 29, 53);
		batAttackEnemy[2] = spriteImage.getSubimage(68, 174, 29, 53);
		batAttackEnemy[3] = spriteImage.getSubimage(99, 174, 29, 53);
		batAttackEnemy[4] = spriteImage.getSubimage(4, 247, 29, 53);
		batAttackEnemy[5] = spriteImage.getSubimage(35, 247, 55, 53);
		batAttackEnemy[6] = spriteImage.getSubimage(146, 174, 24, 53);
		batAttackEnemy[7] = spriteImage.getSubimage(170, 174, 24, 53);
		batAttackEnemy[8] = spriteImage.getSubimage(197, 174, 24, 53);
		batAttackEnemy[8] = spriteImage.getSubimage(219, 174, 24, 53);
		batAttackEnemy[10] = spriteImage.getSubimage(35, 247, 55, 53);
	}

	static void loadKnifeAttackEnemy(BufferedImage spriteImage) {
		knifeAttackEnemy[0] = spriteImage.getSubimage(4, 34, 27, 52);
		knifeAttackEnemy[1] = spriteImage.getSubimage(34, 34, 27, 52);
		knifeAttackEnemy[2] = spriteImage.getSubimage(66, 34, 27, 52);
		knifeAttackEnemy[3] = spriteImage.getSubimage(96, 34, 27, 52);
		knifeAttackEnemy[4] = spriteImage.getSubimage(5, 107, 27, 52);
		knifeAttackEnemy[5] = spriteImage.getSubimage(36, 107, 42, 52);
		knifeAttackEnemy[6] = spriteImage.getSubimage(144, 33, 20, 53);
		knifeAttackEnemy[7] = spriteImage.getSubimage(166, 33, 25, 53);
		knifeAttackEnemy[8] = spriteImage.getSubimage(192, 33, 25, 53);
		knifeAttackEnemy[9] = spriteImage.getSubimage(216, 33, 25, 53);
		knifeAttackEnemy[10] = spriteImage.getSubimage(36, 107, 42, 52);
	}
}
