package com.arihant.battleship.scenes;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import com.arihant.battleship.ResourceManager;

public class GameScene extends BaseScene {

	private HUD gameHUD;
	private Sprite playerSprite;

	@Override
	public void createScene() {
		setBackground();
		createHUD();
		addPlayer();
		camera.setChaseEntity(playerSprite);
	}


	private void createHUD() {
		gameHUD = new HUD();
		createHUDElements();
		camera.setHUD(gameHUD);
	}
	
	private void createHUDElements(){

		Rectangle scoreArea = new Rectangle(0, camera.getHeight() - 60, camera.getWidth(), 60, vbom);
		scoreArea.setColor(.5f, .11f, 0, .5f);
		
		final Text player1 = new Text(-100, 10, ResourceManager.getInstance().mFont, "Saurabh", new TextOptions(HorizontalAlign.CENTER), vbom);
		float playerPosX = camera.getWidth()/4 - player1.getWidth()/2;
		player1.setX(playerPosX);
		
		final Text computer = new Text(-100, 10, ResourceManager.getInstance().mFont, "Computer", new TextOptions(HorizontalAlign.LEFT), vbom);

		float computerPosX = camera.getWidth()* 3/4 - computer.getWidth()/2;
		computer.setX(computerPosX);
		
		player1.setAlpha(.5f);
		computer.setAlpha(.5f);
		gameHUD.attachChild(player1);
		gameHUD.attachChild(computer);
		gameHUD.attachChild(scoreArea);
	}

	private void setBackground() {
		setBackground(new Background(Color.YELLOW));
	}
	
	
	private void addPlayer(){
		Sprite playerSpriteBlue = createDragableSprite(0, 0, ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteBlue.setColor(0, 0, 1);
		Sprite playerSpriteRed = createDragableSprite(100, 0, ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteRed.setColor(1, 0, 0);
		playerSpriteRed.setScale(0.75f);
		registerTouchArea(playerSpriteBlue);
		attachChild(playerSpriteBlue);
		registerTouchArea(playerSpriteRed);
		attachChild(playerSpriteRed);
	}
	

	@Override
	public void onBackPressed() {
		System.exit(0);
	}

	@Override
	public void disposeScene() {
		ResourceManager.getInstance().unloadGameResources();
	}
	

}
