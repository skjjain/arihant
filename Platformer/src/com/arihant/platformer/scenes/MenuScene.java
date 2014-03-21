package com.arihant.platformer.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;


public class MenuScene extends BaseScene {

	@Override
	public void createScene() {
		setBackground(new Background(Color.BLUE));
	}

	@Override
	public void onBackPressed() {

	}

	@Override
	public void disposeScene() {

	}

}
