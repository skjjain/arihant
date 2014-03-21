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
		SCENE_MENU,
		SCENE_GAME
	};
	
	public void setMenuScene(OnCreateSceneCallback cb){
		ResourceManager.getInstance().loadMenuResources();
		menuScene = new MenuScene();
		setScene(menuScene);
		currentScene.createScene();
		cb.onCreateSceneFinished(currentScene);
	}
	
	public void setScene(BaseScene scene){
		engine.setScene(scene);
		currentScene = scene;
	}
	
	public void setScene(SceneType type){
		switch (type) {
		case SCENE_MENU:
			
			break;
		case SCENE_GAME:
			
			break;
		}
	}
	
	public BaseScene getCurrentScene(){
		return currentScene;
	}
	
	public static SceneManager getInstance() {
		return INSTANCE;
	}

}
