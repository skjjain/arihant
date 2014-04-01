package com.arihant.battleship.base;

/**
 * This is the abstract superclass for your states. You will need to make
 * subclasses of this class, but you will not need to change this class.
 * 
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 * 
 *         Created on: Mar 21, 2010
 * 
 */
abstract public class AShipPlacementState {

	protected GameEngine _gameEngine;

	public AShipPlacementState() {

	}

	public AShipPlacementState(GameEngine engine) {
		_gameEngine = engine;
	}

	abstract public void placeShip(ShipHolder holder, Position position);

}
