package com.torrent.killthemall;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	private static final int BITMAP_COLUMN = 3;
	private static final int BITMAP_ROWS = 4;
	private int x = 0;
	private int y = 0;
	private int height = 0;
	private int width = 0;
	private int xSpeed = 5;
	GameView gameView;
	Bitmap bmp;
	private int currentRow = 1;
	private int currentCol = 0;
	
	public Sprite(GameView gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.bmp = bmp;
		this.width = bmp.getWidth() / BITMAP_COLUMN;
		this.height = bmp.getHeight() / BITMAP_ROWS;
	}
	
	public void update(){
		if(x > gameView.getWidth() - width - xSpeed){
			//currentRow = 1;
			xSpeed =  -5;
		}
		
		if(x + xSpeed < 0){
			//currentRow = 2;
			xSpeed =  5;
		}
		
		currentCol = ++currentCol % BITMAP_COLUMN;
		x += xSpeed;
	}
	
	public void onDraw(Canvas canvas){
		update();
		int srcY  = height * currentRow;
		int srcX = width * currentCol;
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canvas.drawBitmap(bmp, src, dst, null);
	}

}
