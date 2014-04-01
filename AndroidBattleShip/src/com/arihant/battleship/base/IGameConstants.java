package com.arihant.battleship.base;

/**
 * Make these constants more meaningful.
 *
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Mar 19, 2010
 *
 */
public interface IGameConstants {
	/**
	 * The size of the squares or cells on the board.
	 */
	public static final Integer SQUARE_SIZE = 1;

  
    

	/**
	 * The number of rows on the board.
	 */
	public static final Integer NUM_ROWS = 10;
	
	/**
	 * The number of columns on the board.
	 */
	public static final Integer NUM_COLS = 10;
	
	/**
	 * A java.awt.Dimension that represents the size of the board.
	 */
	public static final java.awt.Dimension BOARD_DIMENSION = new java.awt.Dimension(NUM_COLS * SQUARE_SIZE, NUM_ROWS * SQUARE_SIZE);
}
