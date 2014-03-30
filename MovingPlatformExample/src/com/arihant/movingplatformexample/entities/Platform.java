package com.arihant.movingplatformexample.entities;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.arihant.movingplatformexample.framework.DynamicEntity;
import com.arihant.movingplatformexample.MovingPlatformExampleActivity;

/**
 * This class will create instance of the Platform
 * @author Yogesh Meshram
 *
 */
public class Platform extends DynamicEntity{
	
	private float VELOCITY_X = 100;
	private final ITextureRegion mPlatformTextureRegion;

	/**
	 * Constructor to create the platform instance	
	 * @param pX
	 * @param pY
	 * @param pPlatformTextureRegion
	 * @param pVertexBufferObjectManager
	 */	
	public Platform(float pX, float pY, ITextureRegion pPlatformTextureRegion,
						VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pPlatformTextureRegion, pVertexBufferObjectManager);
		this.mPlatformTextureRegion = pPlatformTextureRegion;
		
	}
		
	
	/**
	 * Method to move the platform from left to right and
	 * right to left.
	 */
	public void movePlatform(){
		
		this.mPhysicsHandler.setVelocityX(VELOCITY_X);
		
		/**
		 * Logic to prevent the platform from moving out of the screen.
		 * We set the velocity on the x-axis to -ve to move the 
		 * platform from right to left and again set the velocity 
		 * on the x-axis to +ve to move the platform from left to right. 
		 */
		
		if(mX > MovingPlatformExampleActivity.CAMERA_WIDTH - mPlatformTextureRegion.getWidth()/2) {
			VELOCITY_X = -100;
		}
		else if(mX < - mPlatformTextureRegion.getWidth()/2){
			VELOCITY_X = 100;
		}

	}
	
}
