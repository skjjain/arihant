package com.arihant.battleship.base;

import java.util.HashMap;
import java.util.Map;

import org.andengine.entity.sprite.Sprite;

public class GamePlayer {

	private String name;
	private float regionX;
	private float regionY;
	private float regionWidth;
	private float regionHeight;
	
	private Sprite currentShip;
	private Map<String, Sprite> ships = new HashMap<String, Sprite>();
	

	public Sprite getCurrentShip() {
		return currentShip;
	}

	public void setCurrentShip(Sprite currentShip) {
		this.currentShip = currentShip;
	}

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

	public void addShip(String name , Sprite playerSprite) {
		this.ships.put(name, playerSprite);
	}

	public Map<String, Sprite> getShips() {
		return this.ships;
	}

}
