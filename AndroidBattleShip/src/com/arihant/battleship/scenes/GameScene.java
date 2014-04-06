package com.arihant.battleship.scenes;

import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.SpriteBackground;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import com.arihant.battleship.ResourceManager;

public class GameScene extends BaseScene {

	private HUD gameHUD;
	private Sprite playerSprite;
	private float scoreAreaHeight = 60;

	@Override
	public void createScene() {
		setBackground();
		createHUD();
		initModel();
		addPlayer();
		addComputer();
		camera.setChaseEntity(playerSprite);
	}

	private void initModel() {
		float paddingSky = 169;
		ResourceManager.getInstance().model.setPlayer("Player", 0, 169, camera.getWidth() / 2, camera.getHeight()
				- scoreAreaHeight - paddingSky);
		ResourceManager.getInstance().model.setComputer("Player", camera.getWidth() / 2, 169, camera.getWidth() / 2, camera.getHeight()
				- scoreAreaHeight - paddingSky);
	}

	private void createHUD() {
		gameHUD = new HUD();
		createHUDElements();
		camera.setHUD(gameHUD);
	}

	private void createHUDElements() {

		Rectangle scoreArea = new Rectangle(0, camera.getHeight()
				- scoreAreaHeight, camera.getWidth(), scoreAreaHeight, vbom);
		scoreArea.setColor(0, 0, 0);
//
//		final Text player1 = new Text(-100, 10,
//				ResourceManager.getInstance().mFont, "Saurabh",
//				new TextOptions(HorizontalAlign.CENTER), vbom);
//		float playerPosX = camera.getWidth() / 4 - player1.getWidth() / 2;
//		player1.setX(playerPosX);
//
//		final Text computer = new Text(-100, 10,
//				ResourceManager.getInstance().mFont, "Computer",
//				new TextOptions(HorizontalAlign.LEFT), vbom);
//
//		float computerPosX = camera.getWidth() * 3 / 4 - computer.getWidth()
//				/ 2;
//		computer.setX(computerPosX);
//
//		player1.setAlpha(.5f);
//		computer.setAlpha(.5f);
//		gameHUD.attachChild(player1);
//		gameHUD.attachChild(computer);
		gameHUD.attachChild(scoreArea);
	}

	private void setBackground() {
		SpriteBackground background = new SpriteBackground(createSprite(0, 0,
				ResourceManager.getInstance().backgroundRegion, vbom));
		setBackground(background);
	}

	private void addPlayer() {
		
		float playerRegionY = ResourceManager.getInstance().model.getPlayer().getRegionY();
//		float playerRegionHeight = ResourceManager.getInstance().model.getPlayer().getRegionHeight();
		
		float shipSpacing = 40;
		
		Sprite playerSpriteBlue = createDragableSprite(0, playerRegionY + shipSpacing * 1,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteBlue.setColor(new Color(Color.BLUE));
		registerTouchArea(playerSpriteBlue);
		attachChild(playerSpriteBlue);

		Sprite playerSpriteRed = createDragableSprite(0, playerRegionY + shipSpacing * 2,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteRed.setColor(new Color(Color.RED));
		playerSpriteRed.setScale(0.75f);
		registerTouchArea(playerSpriteRed);
		attachChild(playerSpriteRed);
		
		Sprite playerSpriteYellow = createDragableSprite(0, playerRegionY + shipSpacing * 3,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteYellow.setColor(new Color(Color.YELLOW));
		playerSpriteYellow.setScale(0.55f);
		registerTouchArea(playerSpriteYellow);
		attachChild(playerSpriteYellow);
		
		Sprite playerSpriteGreen = createDragableSprite(0, playerRegionY + shipSpacing * 4,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteGreen.setColor(new Color(Color.GREEN));
		playerSpriteGreen.setScale(0.55f);
		registerTouchArea(playerSpriteGreen);
		attachChild(playerSpriteGreen);
		
		Sprite playerSpriteWhite = createDragableSprite(0, playerRegionY + shipSpacing * 5,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteWhite.setColor(new Color(Color.WHITE));
		playerSpriteWhite.setScale(0.45f);
		registerTouchArea(playerSpriteWhite);
		attachChild(playerSpriteWhite);
	}
	
	private void addComputer() {
		
		float playerRegionY = ResourceManager.getInstance().model.getPlayer().getRegionY();
//		float playerRegionHeight = ResourceManager.getInstance().model.getPlayer().getRegionHeight();
		
		float shipSpacing = 40;
		
		Sprite playerSpriteBlue = createDragableSprite(0, playerRegionY + shipSpacing * 1,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteBlue.setColor(new Color(Color.BLUE));
		registerTouchArea(playerSpriteBlue);
		attachChild(playerSpriteBlue);

		Sprite playerSpriteRed = createDragableSprite(0, playerRegionY + shipSpacing * 2,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteRed.setColor(new Color(Color.RED));
		playerSpriteRed.setScale(0.75f);
		registerTouchArea(playerSpriteRed);
		attachChild(playerSpriteRed);
		
		Sprite playerSpriteYellow = createDragableSprite(0, playerRegionY + shipSpacing * 3,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteYellow.setColor(new Color(Color.YELLOW));
		playerSpriteYellow.setScale(0.55f);
		registerTouchArea(playerSpriteYellow);
		attachChild(playerSpriteYellow);
		
		Sprite playerSpriteGreen = createDragableSprite(0, playerRegionY + shipSpacing * 4,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteGreen.setColor(new Color(Color.GREEN));
		playerSpriteGreen.setScale(0.55f);
		registerTouchArea(playerSpriteGreen);
		attachChild(playerSpriteGreen);
		
		Sprite playerSpriteWhite = createDragableSprite(0, playerRegionY + shipSpacing * 5,
				ResourceManager.getInstance().shipRegion, vbom);
		playerSpriteWhite.setColor(new Color(Color.WHITE));
		playerSpriteWhite.setScale(0.45f);
		registerTouchArea(playerSpriteWhite);
		attachChild(playerSpriteWhite);
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
