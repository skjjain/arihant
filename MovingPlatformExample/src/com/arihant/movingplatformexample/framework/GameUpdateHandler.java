package com.arihant.movingplatformexample.framework;

import org.andengine.engine.handler.IUpdateHandler;

import com.arihant.movingplatformexample.MovingPlatformExampleActivity;
/**
 * Class to govern the movement of the platform
 * @author Yogesh Meshram
 *
 */
public class GameUpdateHandler implements IUpdateHandler{

	@Override
	public void onUpdate(float pSecondsElapsed) {		
		MovingPlatformExampleActivity.getInstance().movePlatform();
	}

	@Override
	public void reset() {
		// Do nothing
	}

}
