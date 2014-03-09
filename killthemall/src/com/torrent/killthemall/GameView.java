package com.torrent.killthemall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

	private static final int GOOD_CHAR_COUNT = 20;
	private static final int BAD_CHAR_COUNT = 20;
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
	private final String GOOD = "good";
	private final String BAD = "bad";
	Random rnd = new Random();
	private int asize = 0;

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
				createCharacters();
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

	protected void createCharacters() {
		for (int i = 0; i < GOOD_CHAR_COUNT; i++) {
			Sprite s = createGoodChar();
			sprites.add(s);
		}
		for (int i = 0; i < BAD_CHAR_COUNT; i++) {
			Sprite s = createBadChar();
			sprites.add(s);
		}
	}
	
	
	protected int getAnyBadCharacter(){
		int[] chars = {R.drawable.bad1, R.drawable.bad2, R.drawable.bad3, R.drawable.bad4, R.drawable.bad5, R.drawable.bad6};
		return chars[rnd.nextInt(chars.length - 1)];
	}
	
	protected int getAnyGoodCharacter() {
		int[] chars = {R.drawable.good1, R.drawable.good2, R.drawable.good3, R.drawable.good4, R.drawable.good5, R.drawable.good6};
		return chars[rnd.nextInt(chars.length - 1)];
	}

	protected Sprite createGoodChar() {
		int res = getAnyGoodCharacter();
		bmp = BitmapFactory.decodeResource(getResources(), res);
		return new Sprite(this, bmp, GOOD);
	}
	
	protected Sprite createBadChar() {
		int res = getAnyBadCharacter();
		bmp = BitmapFactory.decodeResource(getResources(), res);
		return new Sprite(this, bmp, BAD);
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
				asize = sprites.size();
				for (int i = sprites.size() - 1; i >= 0; i--) {
					Sprite sprite = sprites.get(i);
					if (sprite.isCollision(x, y)) {
						if(sprite.isGood()){
							sprites.add(createBadChar());
						}
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
