package com.arihant.platformer.scenes;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.arihant.platformer.GameActivity;
import com.arihant.platformer.ResourceManager;

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

	public abstract void createScene();

	public abstract void onBackPressed();

	public abstract void disposeScene();

}
