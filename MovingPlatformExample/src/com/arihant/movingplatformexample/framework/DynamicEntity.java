package com.arihant.movingplatformexample.framework;

import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * This is super class that will extended by different entities that
 * will move.
 * @author Yogesh Meshram
 *
 */
public class DynamicEntity extends Sprite{

	public PhysicsHandler mPhysicsHandler; 
	
	public DynamicEntity(float pX, float pY, ITextureRegion pTextureRegion,
			VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pX, pY, pTextureRegion, pVertexBufferObjectManager);
		this.mPhysicsHandler = new PhysicsHandler(this);
		this.registerUpdateHandler(this.mPhysicsHandler);
	}
	
}
