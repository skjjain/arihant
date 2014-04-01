/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arihant.battleship.base;

/**
 *
 * @author saurabh
 */
public class ShipPlacement extends AShipPlacementState {


    @Override
    public void placeShip(ShipHolder holder, Position position) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public boolean isBlackShipPlaced() {
        return blackShipPlaced;
    }

    public void setBlackShipPlaced(boolean blackShipPlaced) {
        this.blackShipPlaced = blackShipPlaced;
    }

    public boolean isBlueShipPlaced() {
        return blueShipPlaced;
    }

    public void setBlueShipPlaced(boolean blueShipPlaced) {
        this.blueShipPlaced = blueShipPlaced;
    }

    public boolean isGreenShipPlaced() {
        return greenShipPlaced;
    }

    public void setGreenShipPlaced(boolean greenShipPlaced) {
        this.greenShipPlaced = greenShipPlaced;
    }

    public boolean isRedShipPlaced() {
        return redShipPlaced;
    }

    public void setRedShipPlaced(boolean redShipPlaced) {
        this.redShipPlaced = redShipPlaced;
    }

    public boolean isYellowShipPlaced() {
        return yellowShipPlaced;
    }

    public void setYellowShipPlaced(boolean yellowShipPlaced) {
        this.yellowShipPlaced = yellowShipPlaced;
    }

    private boolean blueShipPlaced = false;
    private boolean greenShipPlaced = false;
    private boolean yellowShipPlaced = false;
    private boolean redShipPlaced = false;
    private boolean blackShipPlaced = false;
    
}
