/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arihant.battleship.base;

/**
 *
 * @author chhabara
 */
public interface IShip {

    public void setShipName (String name);

    public String getShipName ();

    public void setShipSize(int size);

    public void setShipAlignment(boolean align);

    public int getShipSize();

    public boolean getShipAlignment();


}
