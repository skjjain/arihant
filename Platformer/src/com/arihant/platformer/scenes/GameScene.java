package com.arihant.platformer.scenes;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.color.Color;

import android.hardware.SensorManager;

import com.arihant.platformer.ResourceManager;
import com.arihant.platformer.physicsworld.MaxStepPhysicsWorld;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class GameScene extends BaseScene {

	private HUD gameHUD;
	private PhysicsWorld physicsWorld;
	private Body playerBody;
	private Sprite playerSprite;

	@Override
	public void createScene() {
		setBackground();
		createHUD();
		createControls();
		createPhysics();
		addPlayer();
		createTiles();
		camera.setChaseEntity(playerSprite);
	}

	private void createPhysics() {
		physicsWorld = new MaxStepPhysicsWorld(60, new Vector2(0, SensorManager.GRAVITY_EARTH), false);
		registerUpdateHandler(physicsWorld);
	}

	private void createHUD() {
		gameHUD = new HUD();
		camera.setHUD(gameHUD);
	}

	private void setBackground() {
		setBackground(new Background(Color.WHITE));
	}
	
	
	private void addPlayer(){
		final FixtureDef playerFixtureDef = PhysicsFactory.createFixtureDef(0.5f,  0.0f, 0.75f);
		Sprite playerSprite = createSprite(0, -100, ResourceManager.getInstance().player_region, vbom);
		playerBody = PhysicsFactory.createBoxBody(physicsWorld, playerSprite, BodyType.DynamicBody, playerFixtureDef);
		physicsWorld.registerPhysicsConnector(new PhysicsConnector(playerSprite, playerBody, true, false));
		attachChild(playerSprite);
	}
	
	private void createTiles(){
		ResourceManager.getInstance().tileManager.getTileById(1).getInstance(-50, 100).createBodyAndAttach(this, physicsWorld);
		ResourceManager.getInstance().tileManager.getTileById(1).getInstance(50, 100).createBodyAndAttach(this, physicsWorld);
		ResourceManager.getInstance().tileManager.getTileById(2).getInstance(100, -50).createBodyAndAttach(this, physicsWorld);
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

}
