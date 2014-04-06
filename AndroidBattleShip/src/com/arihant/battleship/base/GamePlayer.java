package com.arihant.battleship.base;

public class GamePlayer {

	private String name;
	private float regionX;
	private float regionY;
	private float regionWidth;
	private float regionHeight;
	
	

	public GamePlayer(String name, float regionX, float regionY,
			float regionWidth, float regionHeight) {
		this.name = name;
		this.regionX = regionX;
		this.regionY = regionY;
		this.regionWidth = regionWidth;
		this.regionHeight = regionHeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRegionX() {
		return regionX;
	}

	public void setRegionX(float regionX) {
		this.regionX = regionX;
	}

	public float getRegionY() {
		return regionY;
	}

	public void setRegionY(float regionY) {
		this.regionY = regionY;
	}

	public float getRegionWidth() {
		return regionWidth;
	}

	public void setRegionWidth(float regionWidth) {
		this.regionWidth = regionWidth;
	}

	public float getRegionHeight() {
		return regionHeight;
	}

	public void setRegionHeight(float regionHeight) {
		this.regionHeight = regionHeight;
	}

}
