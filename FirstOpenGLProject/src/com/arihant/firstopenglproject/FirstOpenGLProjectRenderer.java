package com.arihant.firstopenglproject;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.SystemClock;

public class FirstOpenGLProjectRenderer implements Renderer {

	private FirstOpenGLTriangle tri;
	private float eyeX = 0;

	public FirstOpenGLProjectRenderer() {
		tri = new FirstOpenGLTriangle();
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
		gl.glDisable(GL10.GL_DITHER);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		gl.glClearColor(.8f, 0f, .2f, 1f);
		gl.glClearDepthf(1f);
	}

	public void onDrawFrame(GL10 gl) {
		gl.glDisable(GL10.GL_DITHER);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		eyeX += .001;
		GLU.gluLookAt(gl, eyeX, 0, -5, 0, 0, 0, 20, 30, 20);
		long time = SystemClock.uptimeMillis() % 4000L;
		float angle = .090f * ((int) time);
		gl.glRotatef(angle, 0, 0, 1);
		tri.draw(gl);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 250);
	}
}
