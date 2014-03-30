package com.arihant.mytruckgame.scenes;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;

import android.hardware.SensorManager;

import com.arihant.mytruckgame.ResourceManager;
import com.arihant.mytruckgame.level.LevelManager;
import com.arihant.mytruckgame.physicsworld.MaxStepPhysicsWorld;
import com.arihant.mytruckgame.tiles.Tile;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class GameScene extends BaseScene {

	private HUD gameHUD;
	private PhysicsWorld physicsWorld;
	private Body playerBody;
	private Sprite playerSprite;
	private LevelManager levelManager;
	private boolean USE_LEVEL_MANAGER = false;

	@Override
	public void createScene() {
		levelManager = new LevelManager(activity.getAssets());
		setBackground();
		createHUD();
		createControls();
		createPhysics();
		addPlayer();
		createLevel();
		camera.setChaseEntity(playerSprite);
	}

	private void createPhysics() {
		physicsWorld = new MaxStepPhysicsWorld(60, new Vector2(0, SensorManager.GRAVITY_EARTH), false);
		registerUpdateHandler(physicsWorld);
	}

	private void createHUD() {
		gameHUD = new HUD();
		createJumpControls();
		camera.setHUD(gameHUD);
	}

	private void setBackground() {
		final AutoParallaxBackground autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 5);
		autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(0.0f, new Sprite(0, camera.getHeight() - ResourceManager.getInstance().mParallaxLayerBack.getHeight(), ResourceManager.getInstance().mParallaxLayerBack, vbom)));
		autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(-5.0f, new Sprite(0, 80, ResourceManager.getInstance().mParallaxLayerMid, vbom)));
		autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(-10.0f, new Sprite(0, camera.getHeight() - ResourceManager.getInstance().mParallaxLayerFront.getHeight(), ResourceManager.getInstance().mParallaxLayerFront, vbom)));
		setBackground(autoParallaxBackground);
	}
	
	
	private void addPlayer(){
		final FixtureDef playerFixtureDef = PhysicsFactory.createFixtureDef(0.9f,  0.01f, 0.75f);
		Sprite playerSprite = createSprite(0, 0, ResourceManager.getInstance().player_region, vbom);
		playerBody = PhysicsFactory.createBoxBody(physicsWorld, playerSprite, BodyType.DynamicBody, playerFixtureDef);
		physicsWorld.registerPhysicsConnector(new PhysicsConnector(playerSprite, playerBody, true, false));
		attachChild(playerSprite);
	}
	
	private void createLevel() {
		if (USE_LEVEL_MANAGER ) {
			levelManager.loadLevel(1, this, physicsWorld);
		} else {
			Tile tile = ResourceManager.getInstance().tileManager
					.getTileById(2);
			final float heigtOfTile = tile.getHeight();
			final float widthOfTile = tile.getHeight();

			float startingX = 0;
			while (startingX < camera.getWidth()) {
				tile.getInstance(startingX, camera.getHeight() - heigtOfTile)
						.createBodyAndAttach(this, physicsWorld);
				startingX += widthOfTile;
			}
		}
	}

	@Override
	public void onBackPressed() {
		System.exit(0);
	}

	@Override
	public void disposeScene() {
		ResourceManager.getInstance().unloadGameResources();
	}
	
	private void createControls(){
		final DigitalOnScreenControl control = new DigitalOnScreenControl(20, camera.getHeight() - ResourceManager.getInstance().control_base_region.getHeight() - 5, camera, ResourceManager.getInstance().control_base_region, ResourceManager.getInstance().control_knob_region, 0.1f, vbom, new IOnScreenControlListener(){
			@Override
			public void onControlChange(
					BaseOnScreenControl control, float x,
					float y) {
				if(playerBody.getLinearVelocity().x > -8 && playerBody.getLinearVelocity().x < 8){
					if(x > 0){
						playerBody.setLinearVelocity(8.0f, playerBody.getLinearVelocity().y);
					}else if(x < 0){
						playerBody.setLinearVelocity(-8.0f, playerBody.getLinearVelocity().y);
					}else {
						playerBody.setLinearVelocity(0, playerBody.getLinearVelocity().y);
					}
				}
				
			}});
		
		control.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		control.getControlBase().setAlpha(0.5f);
		control.getControlBase().setScaleCenter(0, 128);
		control.getControlBase().setScale(1.25f);
		control.getControlKnob().setScale(1.25f);
		control.refreshControlKnobPosition();
		setChildScene(control);

	}
	
	private void createJumpControls(){
		Sprite jump = new Sprite(camera.getWidth() -  175, camera.getHeight() - 125, ResourceManager.getInstance().control_jump_region, vbom){
			@Override
			public boolean onAreaTouched(final TouchEvent event, final float x, final float y){
				if(event.isActionUp()){
					playerBody.applyLinearImpulse(new Vector2(0, -200), playerBody.getPosition());
				}
				return true;
			}
			
			
			@Override
			protected void preDraw(GLState glState, Camera camera) {
				super.preDraw(glState, camera);
				glState.enableDither();
			}
			
		};
		gameHUD.registerTouchArea(jump);
		gameHUD.attachChild(jump);
	}

}
