package com.arihant.platformer.scenes;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import com.arihant.platformer.ResourceManager;

public class SceneManager {

	private BaseScene menuScene;
	private BaseScene gameScene;

	private static final SceneManager INSTANCE = new SceneManager();

	private BaseScene currentScene;
	private Engine engine = ResourceManager.getInstance().engine;

	public enum SceneType {
		SCENE_MENU, SCENE_GAME
	};
	
	public void setGameScene(){
		ResourceManager.getInstance().loadGameResources();
		ResourceManager.getInstance().loadTileResources();
		gameScene = new GameScene();
		setScene(gameScene);
		currentScene.createScene();
	}

	public void setMenuScene(OnCreateSceneCallback cb) {
		ResourceManager.getInstance().loadMenuResources();
		menuScene = new MainMenuScene();
		setScene(menuScene);
		currentScene.createScene();
		cb.onCreateSceneFinished(currentScene);
	}

	public void setScene(BaseScene scene) {
		if (currentScene != null) {
			currentScene.disposeScene();
		}
		engine.setScene(scene);
		currentScene = scene;
	}

	public void setScene(SceneType type) {
		switch (type) {
		case SCENE_MENU:

			break;
		case SCENE_GAME:

			break;
		}
	}

	public BaseScene getCurrentScene() {
		return currentScene;
	}

	public static SceneManager getInstance() {
		return INSTANCE;
	}

}
