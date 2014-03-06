package com.torrent.killthemall;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

@SuppressLint("WrongCall")
public class GameView extends SurfaceView {

	private Bitmap bmp;
	private SurfaceHolder holder;
	private GameLoopThread gameLoopThread;
	private List<Sprite> sprites = new ArrayList<Sprite>();

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
				createSprites();
				gameLoopThread.setRunning(true);
				gameLoopThread.start();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
				
			}
		});
		

		
	}
	
	protected void createSprites(){
		sprites.add(createSprite(R.drawable.bad1));
		sprites.add(createSprite(R.drawable.bad2));
		sprites.add(createSprite(R.drawable.bad3));
		sprites.add(createSprite(R.drawable.bad4));
		sprites.add(createSprite(R.drawable.bad5));
		sprites.add(createSprite(R.drawable.bad6));
		sprites.add(createSprite(R.drawable.good1));
		sprites.add(createSprite(R.drawable.good2));
		sprites.add(createSprite(R.drawable.good3));
		sprites.add(createSprite(R.drawable.good4));
		sprites.add(createSprite(R.drawable.good5));
		sprites.add(createSprite(R.drawable.good6));
	}
	
	protected Sprite createSprite(int res){
		bmp = BitmapFactory.decodeResource(getResources(), res);
		return new Sprite(this, bmp);
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.MAGENTA);
		for (Sprite sprite : sprites) {
			sprite.onDraw(canvas);
		}
	}
	
	public boolean onTouchEvent(MotionEvent event){
		for(int i = sprites.size() - 1; i > 0; i --){
			Sprite sprite = sprites.get(i);
			if(sprite.isCollision(event.getX(), event.getY())){
				sprites.remove(sprite);
			}
		}
		return true;
	}

}
