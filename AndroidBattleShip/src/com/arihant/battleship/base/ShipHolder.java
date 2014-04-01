package com.arihant.battleship.base;

/**
 * This is a placeholder class - you should copy your holder class from Lab 6
 * and overwrite this class file.
 *
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Mar 28, 2010
 *
 */
public class ShipHolder {


    private boolean isHolderOn;
    private String shipType;
    //iHolderon
    public boolean isHolderOn()
    {
        return this.isHolderOn;
    }

    public void setHolderState(boolean state)
    {
        this.isHolderOn = state;
    }

    public void setShipType(String color)
    {
        this.shipType = color;
    }

    public String getShipType()
    {
        return this.shipType;
    }


}
