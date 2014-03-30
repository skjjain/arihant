package com.arihant.movingplatformexample;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import com.arihant.movingplatformexample.entities.Platform;
import com.arihant.movingplatformexample.framework.GameUpdateHandler;

/**
 * Main class to create the instantiate the engine. This is also
 * single ton class that will create only one instance.
 * @author Yogesh Meshram
 *
 */
public class MovingPlatformExampleActivity extends SimpleBaseGameActivity {

	/**
	 * Set the camera height and width
	 */
	public static final int CAMERA_WIDTH = 800;
	public static final int CAMERA_HEIGHT = 480;
	
	/**
	 * Constants for assets
	 */
	private final String PLATFORM_GFX = "platform.jpg";
	
	/**
	 * Texture Region for the game graphics
	 */
	private BitmapTextureAtlas mPlatformBitmapTextureAtlas;
	private ITextureRegion mPlatformTextureRegion;
	
	/**
	 * Game Variables
	 */
	private Scene mScene;
	private VertexBufferObjectManager vbo;
	private static MovingPlatformExampleActivity instance;
	
	/**
	 * Game Entities
	 */
	private Platform mPlatform;

	@Override
	public EngineOptions onCreateEngineOptions() {
		
		instance = this;
		final Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, 
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), camera);

	}

	@Override
	protected void onCreateResources() {
		
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		this.mPlatformBitmapTextureAtlas = new BitmapTextureAtlas(this.getTextureManager(), 128, 128, 
											TextureOptions.BILINEAR);
		this.mPlatformTextureRegion = BitmapTextureAtlasTextureRegionFactory
				.createFromAsset(mPlatformBitmapTextureAtlas, this.getAssets(),PLATFORM_GFX, 0, 0);
		
		this.mPlatformBitmapTextureAtlas.load();
		
	}

	@Override
	protected Scene onCreateScene() {
		
		this.mScene = new Scene();
		this.mScene.setBackground(new Background(1, 1, 1));
		this.vbo = this.getVertexBufferObjectManager();
		
		float xPos, yPos;
		xPos = CAMERA_WIDTH/2;
		yPos = CAMERA_HEIGHT/2;
		
		this.mPlatform = new Platform(xPos, yPos, mPlatformTextureRegion, vbo);		
		this.mScene.attachChild(mPlatform);	
		this.mScene.registerUpdateHandler(new GameUpdateHandler());
		return this.mScene;
	}
	
	/**
	 * Simple Wrapper to get instance. 
	 * @return instance of MovingPlatformExampleActivity
	 */
	public static MovingPlatformExampleActivity getInstance(){
		return instance;
	}
	
	/**
	 * Simple wrapper to call the movePlatform method of Platform
	 */
	public void movePlatform(){
		mPlatform.movePlatform();
	} 
	
}
