 package Lab8;

/**
 * IGameEngine interface for Battleship.
 *
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Mar 21, 2010
 *
 */
public interface IGameEngine {
	/**
	 * Method that is called when the player clicks on their board (to place the ships).
	 * @param position The row/column position where the click occurred.
	 */
	public void playersBoardClicked(Position position);
	
	/**
	 * Method that is called when the player clicks on the opponents board (to fire shots).
	 * @param position The row/column position where the click occurred.
	 */
	public void opponentsBoardClicked(Position position);
	
	/**
	 * Add a ship to the game.
	 * @param ship The ship to add.
	 */
	public void addShip(AShip ship);
}
