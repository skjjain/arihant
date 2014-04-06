package com.arihant.battleship.base;

public class GameModel {

	public enum gameStates {
		INIT, PLAYER_POSITION_SHIP, COMPUTER_POSITION_SHIP, 
	};
	
	public enum currentPlayer {
		PLAYER, COMPUTER, 
	};
	
	private GamePlayer player;
	private GamePlayer computer;
	
	public GamePlayer getPlayer() {
		return player;
	}
	public void setPlayer(String name, float regionX, float regionY, float regionWidth, float regionHeight) {
		this.player = new GamePlayer(name, regionX, regionY, regionWidth, regionHeight);
	}
	
	public GamePlayer getComputer() {
		return computer;
	}
	public void setComputer(String name, float regionX, float regionY, float regionWidth, float regionHeight) {
		this.computer = new GamePlayer(name, regionX, regionY, regionWidth, regionHeight);
	}
	
	
}
