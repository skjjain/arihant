package com.torrent.killthemall;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
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
	private long lastClickTime;
	private Bitmap bmpBlood;
	private List<TempSprite> temps = new ArrayList<TempSprite>();
	private Bitmap bmpBgGrass;
	private SoundPool sounds;
	private int sExplosion;

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
			public void surfaceChanged(SurfaceHolder holder, int arg1,
					int arg2, int arg3) {

			}
		});

		bmpBlood = BitmapFactory.decodeResource(getResources(),
				R.drawable.blood1);
		bmpBgGrass = BitmapFactory.decodeResource(getResources(),
				R.drawable.grass_texture);

		sounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		sExplosion = sounds.load(context, R.raw.hit_hurt, 1);
	}

	protected void createSprites() {
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

	protected Sprite createSprite(int res) {
		bmp = BitmapFactory.decodeResource(getResources(), res);
		return new Sprite(this, bmp);
	}

	protected void onDraw(Canvas canvas) {
		Rect src = new Rect(0, 0, this.getWidth(), this.getHeight());
		Rect dst = new Rect(0, 0, this.getWidth(), this.getHeight());
		canvas.drawBitmap(bmpBgGrass, src, dst, null);
		for (int i = temps.size() - 1; i >= 0; i--) {
			temps.get(i).onDraw(canvas);
		}
		for (Sprite sprite : sprites) {
			sprite.onDraw(canvas);
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (System.currentTimeMillis() - lastClickTime > 300) {
			lastClickTime = System.currentTimeMillis();
			float x = event.getX();
			float y = event.getY();
			synchronized (getHolder()) {
				for (int i = sprites.size() - 1; i >= 0; i--) {
					Sprite sprite = sprites.get(i);
					if (sprite.isCollision(x, y)) {
						sprites.remove(sprite);
						sounds.play(sExplosion, 1.0f, 1.0f, 0, 0, 1.5f);
						temps.add(new TempSprite(temps, this, x, y, bmpBlood));
					}
				}
			}
		}
		return true;
	}

}
