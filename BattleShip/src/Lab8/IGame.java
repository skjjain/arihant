package Lab8;

/**
 * IGame interface for Battleship.
 *
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Mar 21, 2010
 *
 */
public interface IGame {
	
	/**
	 * Set the text of the message panel.
	 * @param text The text to appear on the panel.
	 */
	public void setMessageText(String text);
	
	/**
	 * Get the text that appears on the message panel.
	 * @return The text that is currently in the message panel.
	 */
	public String getMessageText();

	/**
	 * Disable the ability for the user to select the five-shot ship
	 */
	public void disableFiveShots();
	
	/**
	 * Disable the ability for the user to select the four-shot ship
	 */
	public void disableFourShots();
	
	/**
	 * Disable the ability for the user to select the three-shot ship (1st kind)
	 */
	public void disableThreeShots1();
	
	/**
	 * Disable the ability for the user to select the three-shot ship (2nd kind)
	 */
	public void disableThreeShots2();
	
	/**
	 * Disable the ability for the user to select the two-shot ship
	 */
	public void disableTwoShots();

}
