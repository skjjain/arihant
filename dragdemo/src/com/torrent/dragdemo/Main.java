package com.torrent.dragdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
 
public class Main extends Activity implements OnTouchListener {
	OurView v;
	Bitmap ball, blob;
	float x, y;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.football_ball);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		x = y = 0;
		setContentView(v);
	}
 
 
	@Override
	protected void onPause() {
		
		super.onPause();
		v.pause();
	}
 
	@Override
	protected void onResume() {		
		super.onResume();
		v.resume();
	}
 
	public class OurView extends SurfaceView implements Runnable {
		Thread t = null;
		SurfaceHolder holder;
		boolean isItOK = false;
 
		public OurView(Context context) {
			super(context);			
			holder = getHolder();
		}
 
		public void run() {			
			while (isItOK == true) {
				// perform canvas drawing
				if (!holder.getSurface().isValid()) {
					continue;
				}
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, 100, 100, 10);
				c.drawBitmap(ball, x, y, null);
				holder.unlockCanvasAndPost(c);
			}
		}
 
		protected void onDraw(Canvas canvas) {
			// sprite.onDraw(canvas);
		}
 
		public void pause() {
			isItOK = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
		}
 
		public void resume() {
			isItOK = true;
			t = new Thread(this);
			t.start();
		}
	}
 
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x = event.getX() - ball.getWidth()/2;
			y = event.getY() - ball.getHeight()/2;
 
			break;
		case MotionEvent.ACTION_UP:
			x = event.getX() - ball.getWidth()/2;
			y = event.getY() - ball.getHeight()/2;
 
			break;
		case MotionEvent.ACTION_MOVE:
			x = event.getX() - ball.getWidth()/2;
			y = event.getY() - ball.getHeight()/2;
 
			break;
		}
 
		return true;
	}
 
}