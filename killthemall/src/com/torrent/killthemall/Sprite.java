package com.torrent.killthemall;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	private static final int BITMAP_COLUMN = 3;
	private static final int BITMAP_ROWS = 4;
	private int x;
	private int y;
	private int height = 0;
	private int width = 0;
	private int xSpeed;
	private int ySpeed;
	GameView gameView;
	Bitmap bmp;
	private int currentRow = 1;
	private int currentCol = 0;
	
	private int UP = 3;
	private int DOWN = 0;
	private int LEFT = 1;
	private int RIGHT = 2;

	public Sprite(GameView gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.bmp = bmp;
		this.width = bmp.getWidth() / BITMAP_COLUMN;
		this.height = bmp.getHeight() / BITMAP_ROWS;
		Random rnd = new Random();
		x = rnd.nextInt(gameView.getWidth() - width);
		y = rnd.nextInt(gameView.getHeight() - height);
		ySpeed = rnd.nextInt(20) - 10;
		xSpeed = rnd.nextInt(20) - 10;
	}

	public void update() {
		if (x > gameView.getWidth() - width - xSpeed || x + xSpeed < 0) {
			xSpeed = -xSpeed;
		}
		x += xSpeed;

		if (y > gameView.getHeight() - height - ySpeed || y + ySpeed < 0) {
			ySpeed = -ySpeed;
		}
		y += ySpeed;

		currentCol = ++currentCol % BITMAP_COLUMN;
		updateCurrentRow();

	}
	
	public void updateCurrentRow() {
		double angel = Math.toDegrees(Math.atan2(ySpeed, xSpeed)) + 180;

		if (angel > 315 || angel <= 45) {
			currentRow = LEFT;
			// println("go right when " +angel);
		} else if (angel > 45 && angel <= 135) {
			currentRow = UP;
			// println("go up when " +angel);

		} else if (angel > 135 && angel <= 225) {
			currentRow = RIGHT;
			// println("go left when " +angel);

		} else if (angel > 225 && angel <= 315) {
			currentRow = DOWN;
			// println("go down when " +angel);

		}
	}

	public void onDraw(Canvas canvas) {
		update();
		int srcY = height * currentRow;
		int srcX = width * currentCol;
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(bmp, src, dst, null);
	}

	public boolean isCollision(float x2, float y2) {
		return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
	}
	


}
