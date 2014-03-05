package com.torrent.killthemall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

@SuppressLint("WrongCall")
public class GameView extends SurfaceView {

	private Bitmap bmp;
	private SurfaceHolder holder;
	private GameLoopThread gameLoopThread;
//	private int x = 0;
//	private int y = 0;
//	private int xSpeed = 10;
//	private int ySpeed = 20;
	private Sprite sprite;

	public GameView(Context context) {
		super(context);
		gameLoopThread = new GameLoopThread(this);
		holder = getHolder();
		holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				
				
			}
			
			@SuppressLint("WrongCall")
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				gameLoopThread.setRunning(true);
				gameLoopThread.start();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
				
			}
		});
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bad1);
		sprite = new Sprite(this, bmp);
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		sprite.onDraw(canvas);
	}

}
