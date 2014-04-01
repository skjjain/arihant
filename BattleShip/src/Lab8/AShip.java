package Lab8;

import java.awt.Color;

/**
 * This is a placeholder class - you should copy your Ship class from Lab 6 and
 * overwrite this class file.
 * 
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 * 
 *         Created on: Mar 28, 2010
 * 
 */
public class AShip implements IShip {

	private Color shipColor;
	private int destroyed = 0;

	public int getDestroyed() {
		return destroyed;
	}

	public void setDestroyed(int destroyed) {
		this.destroyed = destroyed;
	}

	public Color getShipColor() {
		return shipColor;
	}

	public AShip() {
	}

	public AShip(int size, String name) {
		this.shipSize = size;
		this.shipName = name;
		this.isHorizontal = true;

		if (name.equalsIgnoreCase("blue")) {
			this.shipColor = Color.blue;
		} else if (name.equalsIgnoreCase("green")) {
			this.shipColor = Color.green;
		} else if (name.equalsIgnoreCase("yellow")) {
			this.shipColor = Color.yellow;
		} else if (name.equalsIgnoreCase("red")) {
			this.shipColor = Color.red;
		} else {
			this.shipColor = Color.black;
		}
	}

	public void setShipName(String name) {
		this.shipName = name;
	}

	public String getShipName() {
		return this.shipName;
	}

	public void setShipSize(int size) {
		this.shipSize = size;
	}

	public void setShipAlignment(boolean align) {
		this.isHorizontal = align;
	}

	public int getShipSize() {
		return (this.shipSize);
	}

	public boolean getShipAlignment() {
		return (this.isHorizontal);
	}

	private String shipName = "";
	private int shipSize = 0;
	private int shipSizeDestroyed = 0;
	private boolean isHorizontal = false;

	boolean isFullyDestroyed() {
		if (shipSize == shipSizeDestroyed) {
			return true;
		}
		return false;
	}

	public void increaseDestruction() {
		if (!isFullyDestroyed()) {
			shipSizeDestroyed += 1;
		}
	}

}
