package com.arihant.battleship.scenes;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.arihant.battleship.GameActivity;
import com.arihant.battleship.ResourceManager;

public abstract class BaseScene extends Scene{

	public Engine engine;
	public GameActivity activity;
	public Camera camera;
	public VertexBufferObjectManager vbom;

	public BaseScene() {
		engine = ResourceManager.getInstance().engine;
		activity = ResourceManager.getInstance().activity;
		camera = ResourceManager.getInstance().camera;
		vbom = ResourceManager.getInstance().vbom;
	}
	
	protected Sprite createSprite(float x, float y, ITextureRegion region, VertexBufferObjectManager vbom) {
		Sprite sprite = new  Sprite(x, y, region, vbom){
			@Override
			protected void preDraw(GLState glState, Camera camera){
				super.preDraw(glState, camera);
				glState.enableDither();
			}
			
		};
		return sprite;
	}
	
	protected Sprite createDragableSprite(float x, float y, ITextureRegion region, VertexBufferObjectManager vbom) {
		Sprite sprite = new  Sprite(x, y, region, vbom){
			@Override
			protected void preDraw(GLState glState, Camera camera){
				super.preDraw(glState, camera);
				glState.enableDither();
			}
			
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				
				switch (pSceneTouchEvent.getAction()) {
				case TouchEvent.ACTION_UP:
					this.setRotation(this.getRotation() + 45);
					break;
				case TouchEvent.ACTION_MOVE:
					this.setPosition(pSceneTouchEvent.getX() - this.getWidth()
							/ 2, pSceneTouchEvent.getY() - this.getHeight() / 2);
					break;
				}
				return true;
			}
			
		};
		return sprite;
	}
	
	

	public abstract void createScene();

	public abstract void onBackPressed();

	public abstract void disposeScene();

}
