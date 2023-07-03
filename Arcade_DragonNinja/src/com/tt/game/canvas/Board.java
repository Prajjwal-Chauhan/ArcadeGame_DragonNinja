package com.tt.game.canvas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.tt.game.sprites.Boss;
import com.tt.game.sprites.BossHadWoken;
import com.tt.game.sprites.Camera;
import com.tt.game.sprites.Enemy;
import com.tt.game.sprites.EnemySprite;
import com.tt.game.sprites.Player;
import com.tt.game.sprites.Power;
import com.tt.game.utils.EnemyTypes;
import com.tt.game.utils.GameConstants;

import jaco.mp3.player.MP3Player;

@SuppressWarnings("serial")
public class Board extends JPanel implements GameConstants {
	private MP3Player mp3player;
	private MP3Player mp3playerH;
	private Camera camera;
	private Player player;
	private Boss boss;
	private BossHadWoken bosshadwoken;
	private EnemySprite enemysp;
	private Enemy enemies[];
	private Power playerFullPower;
	private Power bossFullPower;
	private boolean gameOver;

	private Timer timer;

	private void gameLoop() {
		timer = new Timer(GAME_LOOP, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
				if (gameOver) {
					mp3player.stop();
					if (bossFullPower.getHealth() <= 0) {
						loadClearMusic();
						boss.setCurrentMove(DEAD);
						player.setCurrentMove(WIN);
					}
					if (playerFullPower.getHealth() <= 0) {
						loadGameOverMusic();
						player.setCurrentMove(DEAD);
						boss.setCurrentMove(WIN);
					}
					try {
						Thread.sleep(2000);
						mp3player.stop();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					timer.stop();
				}
				player.fall();
				boss.fall();
				collision();
				isGameOver();
			}

		});
		timer.start();
	}

	private void loadInGameMusic() {
		mp3player = new MP3Player(Board.class.getResource(INGAME_MUSIC));
		mp3player.play();
	}

	private void loadHurtPMusic() {
		mp3playerH = new MP3Player(Board.class.getResource(HURTP));
		mp3playerH.play();
	}

	private void loadHurtBMusic() {
		mp3playerH = new MP3Player(Board.class.getResource(HURTB));
		mp3playerH.play();
	}

	private void loadHurtEMusic() {
		mp3playerH = new MP3Player(Board.class.getResource(HURTE));
		mp3playerH.play();
	}

	private void loadClearMusic() {
		mp3player = new MP3Player(Board.class.getResource(CLEAR));
		mp3player.play();
	}

	private void loadGameOverMusic() {
		mp3player = new MP3Player(Board.class.getResource(GAME_OVER));
		mp3player.play();
	}

	private void loadHadwokenPMusic() {
		mp3playerH = new MP3Player(Board.class.getResource(HADWOKEN_P));
		mp3playerH.play();
	}

	private void loadHadwokenBMusic() {
		mp3playerH = new MP3Player(Board.class.getResource(HADWOKEN_B));
		mp3playerH.play();
	}

	private void loadPower() throws IOException {
		playerFullPower = new Power(100, POWERP_TITLE);
		bossFullPower = new Power(GWIDTH - 450, POWERB_TITLE);
	}

	private void printPower(Graphics g) {
		playerFullPower.printRectangle(g);
		bossFullPower.printRectangle(g);
	}

	private void isGameOver() {
		if (bossFullPower.getHealth() <= 0 || playerFullPower.getHealth() <= 0) {
			gameOver = true;
		}
	}

	private void printGameOver(Graphics pen) {
		if (gameOver) {
			pen.setColor(Color.RED);
			pen.setFont(new Font("times", Font.BOLD, 40));
			pen.drawString("GAME OVER", GWIDTH / 2 - 100, GHEIGHT / 2 - 100);
		}
	}

	public Board() throws Exception {
		player = new Player();
		boss = new Boss();
		bosshadwoken = new BossHadWoken(boss.getX());
		bosshadwoken.setAlive(false);
		enemysp = new EnemySprite();
		EnemyTypes.loadBatAttackEnemy(enemysp.getImage());
		EnemyTypes.loadHandAttackEnemy(enemysp.getImage());
		EnemyTypes.loadKnifeAttackEnemy(enemysp.getImage());
		enemies = new Enemy[MAX_ENEMIES];

		loadInGameMusic();
		loadEnemies();
		loadBackgroundImage();
		setFocusable(true);
		bindEvents();
		gameLoop();
		loadPower();
	}

	private void loadEnemies() throws Exception {
		int gap = 0;
		for (int i = 0; i < enemies.length; i++) {
			if (i % 2 == 0) {
				enemies[i] = new Enemy(EnemyTypes.handAttackEnemy, gap);
			} else if (i % 3 == 0) {
				enemies[i] = new Enemy(EnemyTypes.knifeAttackEnemy, gap);
			} else {
				enemies[i] = new Enemy(EnemyTypes.batAttackEnemy, gap);
			}

			gap = gap + 800 - i * 17;
		}
	}

	private void loadHadwoken() throws Exception {
		bosshadwoken = new BossHadWoken(boss.getX());
	}

	private void bindEvents() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setCurrentMove(IDLE);
				}
				if (e.getKeyCode() == KeyEvent.VK_K || e.getKeyCode() == KeyEvent.VK_P) {
					player.setAttacking(false);
				}
				if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
					boss.setCurrentMove(IDLE);
				}
				if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_F) {
					boss.setAttacking(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setCurrentMove(WALK);
					if (player.getX() >= 50) {
						player.setSpeed(-SPEED);
						boss.setCurrentMove(IDLE);
						player.move();
					} else {
						if (camera.getX() >= 50) {
							camera.setSpeed(-SPEED);
							camera.move();
							boss.setSpeed(SPEED);
							boss.setCurrentMove(WALK);
							boss.move();
						} else {
							camera.setSpeed(0);
						}
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.setCurrentMove(JUMP);
					player.jump();
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setCurrentMove(WALK);
					if (player.getX() <= 1000) {
						player.setSpeed(SPEED);
						boss.setCurrentMove(IDLE);
						player.move();
					} else {
						if (camera.getX() <= 2850) {
							camera.setSpeed(SPEED);
							camera.move();
							boss.setSpeed(-SPEED);
							boss.setCurrentMove(WALK);
							boss.move();
						} else {
							camera.setSpeed(0);
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_K) {
					player.setAttacking(true);
					player.setCurrentMove(KICK);
				}
				if (e.getKeyCode() == KeyEvent.VK_P) {
					player.setAttacking(true);
					player.setCurrentMove(PUNCH);
				}
				if (e.getKeyCode() == KeyEvent.VK_H) {
					loadHadwokenPMusic();
					player.setAttacking(true);
					player.setCurrentMove(HADWOKEN);
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {
					boss.setSpeed(-SPEED);
					boss.setCurrentMove(WALK);
					boss.move();
				}

				if (e.getKeyCode() == KeyEvent.VK_W) {
					boss.setCurrentMove(JUMP);
					boss.jump();
				}

				if (e.getKeyCode() == KeyEvent.VK_Z) {
					boss.setAttacking(true);
					boss.setCurrentMove(KICK);
				}

				if (e.getKeyCode() == KeyEvent.VK_F) {
					boss.setAttacking(true);
					boss.setCurrentMove(PUNCH);
				}
				if (e.getKeyCode() == KeyEvent.VK_C) {
					loadHadwokenBMusic();
					boss.setAttacking(true);
					boss.setCurrentMove(HADWOKEN);
					bosshadwoken.setAlive(true);
					try {
						loadHadwoken();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					boss.setCurrentMove(WALK);
					boss.setSpeed(SPEED);
					boss.move();
				}
			}
		});
	}

	private boolean isCollide() {
		int xDistance = Math.abs(player.getX() - boss.getX());
		int yDistance = Math.abs(player.getY() - boss.getY());
		int maxH = Math.max(player.getH(), boss.getH());
		int maxW = Math.max(player.getW(), boss.getW());
		return xDistance <= maxW - 50 && yDistance <= maxH - 40;
	}

	private boolean isCollideH() {
		int xDistance = Math.abs(player.getX() - bosshadwoken.getX());
		int yDistance = Math.abs(player.getY() - bosshadwoken.getY());
		int maxH = Math.max(player.getH(), bosshadwoken.getH());
		int maxW = Math.max(player.getW(), bosshadwoken.getW());
		return xDistance <= maxW - 200 && yDistance <= maxH - 200;
	}

	private boolean isCollide(Enemy currentEnemy) {
		int xDistance = Math.abs(player.getX() - currentEnemy.getX());
		int yDistance = Math.abs(player.getY() - currentEnemy.getY());
		int maxWidth = Math.max(player.getW(), currentEnemy.getW());
		int maxHeight = Math.max(player.getH(), currentEnemy.getH());
		return xDistance <= maxWidth - 50 && yDistance <= maxHeight - 40;
	}

	public void collision() {
		for (Enemy enemy : enemies) {
			if (!enemy.isCollide() && isCollide(enemy)) {
				player.setCollide(true);
				if (!player.isAttacking()) {
					loadHurtPMusic();
					System.out.println("Not Attacking......");
					player.setCurrentMove(DAMAGE);
					playerFullPower.setHealth(0.1);
				} else {
					System.out.println("Attacking......");

					loadHurtEMusic();
					enemy.setAlive(false);
				}
				enemy.setCollide(true);
				System.out.println("Collide......");
			}
		}

		if (isCollideH()) {
			player.setCollide(true);
			loadHurtPMusic();
			player.setCurrentMove(DAMAGE);
			playerFullPower.setHealth(0.01);
			player.setSpeed(0);
		} else {
			player.setCollide(false);
			player.setSpeed(SPEED);
		}

		if (isCollide()) {
			player.setCollide(true);
			if (player.isAttacking()) {
				loadHurtBMusic();
				boss.setCurrentMove(DAMAGE);
				bossFullPower.setHealth(0.01);

			} else if (boss.isAttacking()) {
				loadHurtPMusic();
				player.setCurrentMove(DAMAGE);
				playerFullPower.setHealth(0.1);
			} else if (player.isAttacking() && boss.isAttacking()) {
				loadHurtPMusic();
				loadHurtBMusic();
				boss.setCurrentMove(DAMAGE);
				bossFullPower.setHealth(0.01);
				player.setCurrentMove(DAMAGE);
				playerFullPower.setHealth(0.1);
			} else {

			}
			player.setSpeed(0);
		} else {
			player.setCollide(false);
			player.setSpeed(SPEED);
		}

	}

	@Override
	public void paintComponent(Graphics pen) {
//		rendering
		super.paintComponent(pen);
		camera.printSprite(pen);
		boss.printPlayer(pen);
		player.printPlayer(pen);
		printHadwokes(pen);
		printEnemies(pen);
		printPower(pen);
		printGameOver(pen);
	}

	private void printHadwokes(Graphics pen) {
		if (bosshadwoken.isAlive())
			bosshadwoken.printPlayer(pen);
	}

	private void printEnemies(Graphics pen) {
		for (Enemy en : enemies) {
			if (en.isAlive()) {
				en.printPlayer(pen);
			}
		}
	}

	private void loadBackgroundImage() throws IOException {
		camera = new Camera();
	}
}
