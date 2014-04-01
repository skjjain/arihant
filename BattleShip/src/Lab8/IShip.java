/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab8;

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
