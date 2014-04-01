package Lab8;

/**
 * An object that models a row/column position - same as in utilities.Position, but 
 * modified for use in this project.
 *
 * @author <a href="mailto:adrienne@buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Nov 4, 2008
 *
 */

public class Position implements IGameConstants {

	/** The row value of the position **/
	private Integer _row;
	
	/** The column value of the position **/
	private Integer _col;

    private boolean occupied = false;
    private boolean bombed = false;

    private AShip ship = new AShip();

    public AShip getShip() {
        return ship;
    }

    public void setShip(AShip ship) {
        this.ship = ship;
    }


    public boolean isBombed() {
        return bombed;
    }

    public void setBombed(boolean bombed) {
        this.bombed = bombed;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

	/**
	 * Creates a Position object
	 * 
	 * @param row
	 *            the index of the row, assumes counting starting at 0
	 * @param col
	 *            the index of the column, assumes counting starting at 0
	 */
	public Position(Integer row, Integer col) {
		_row = row;
		_col = col;
	}
     public Position(String text) {
        String[] arr = new String[2];
        arr = text.split(",");
        int[] iArr = new int[2];
        this._row = Integer.parseInt(arr[0]);
        this._col = Integer.parseInt(arr[1]);

    }

	/**
	 * Creates a Position object based on a given Point
	 * 
	 * @param pt
	 *            a Point to be translated to a row/column position
	 */
	public Position(java.awt.Point pt) {
		_row = pt.y / SQUARE_SIZE;
		_col = pt.x / SQUARE_SIZE;
	}

	/**
	 * Returns the row of this position
	 * 
	 * @return the row index for this position
	 */
	public Integer getRow() {
		return _row;
	}

	/**
	 * Returns the column of this position
	 * 
	 * @return the column index for this position
	 */
	public Integer getCol() {
		return _col;
	}

	/**
	 * Returns a string representation of this Position
	 * @see java.lang.Object#toString()
	 * @return This position as a string
	 */
	@Override
	public String toString() {
		return "[" + _row + "," + _col + "]";
	}

	/**
	 * Coverts Position to a Point
	 * 
	 * @return the Point that corresponds to this position (upper-left hand
	 *         corner of bounding box)
	 */
	public java.awt.Point toPoint() {
		return new java.awt.Point(_col * SQUARE_SIZE, _row * SQUARE_SIZE);
	}

	/**
	 * Coverts Position to a Point
	 * 
	 * @return the Point that corresponds to this position (upper-left hand
	 *         corner of bounding box)
	 */
	public java.awt.Point getCenterLocation() {
		return new java.awt.Point(_col * SQUARE_SIZE + SQUARE_SIZE/2,
								  _row * SQUARE_SIZE + SQUARE_SIZE/2);
	}

	/**
	 * Generates a hashcode so that two position objects with the same 
	 * row and column values will have the same hashcode
	 * 
	 * @see java.lang.Object#hashCode()
	 * @return the hashcode of the position
	 */
	@Override
	public int hashCode() {
		return this.toPoint().hashCode();
	}

	/**
	 * Tests to see if the given object has the same row and column
	 * values as this position
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param obj the object to test for equivalence
	 * @return true if this object is equal to the object that's passed in
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		} // end of if ()
		Position other = (Position) obj;
		return ((_row == other._row) && (_col == other._col));
	}

    void initPosition() {
        this._row = -1;
        this._col = -1;
    }
}// Position

