package com.tt.game.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import com.tt.game.utils.GameConstants;

public abstract class Sprite implements GameConstants {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int imageIndex;
	protected int currentMove;
	protected int speed;
	protected int force;
	protected boolean isJump;
	protected boolean isAlive;
	protected boolean isCollide;
	protected int health;

	public int getHealth() {
		return health;
	}

	public void setHealth(double val) {
		this.health = (int) (this.health - MAX_HEALTH * val);
	}

	public boolean isCollide() {
		return isCollide;
	}

	public void setCollide(boolean isCollide) {
		this.isCollide = isCollide;
	}

	public int getImageIndex() {
		return imageIndex;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}

	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public boolean isJump() {
		return isJump;
	}

	public void setJump(boolean isJump) {
		this.isJump = isJump;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	protected BufferedImage image;

	public abstract BufferedImage defaultImg();

	public Sprite() throws IOException {
		health = MAX_HEALTH;
		image = ImageIO.read(EnemySprite.class.getResource(ENEMY_IMG));
		h = 200;

		w = 100;
		y = FLOOR - h;
		isAlive = true;
	}

	public void printSprite(Graphics pen) {
		pen.drawImage(defaultImg(), 0, 0, GWIDTH, GHEIGHT, null);
	}

	public void printPlayer(Graphics pen) {
		pen.drawImage(defaultImg(), x, y, w, h, null);
	}

	public void move() {
		x = x + speed;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
