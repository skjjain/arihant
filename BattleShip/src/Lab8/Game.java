package Lab8;

import java.util.HashMap;

/**
 * This is a placeholder class - you should copy your Game class from Lab 6
 * and overwrite this class file.
 *
 * @author <a href="mailto:adrienne@cse.buffalo.edu">Adrienne M Decker</a>
 *
 * Created on: Mar 19, 2010
 *
 */
public class Game implements IGame, IGameConstants {

    public Position shipCenter;

    public Game() {
        for (int i = 1; i <= maxGridX; i++) {
            for (int j = 1; j <= maxGridY; j++) {
                this.playerMap.put(i + "," + j, new Position(i, j));
                this.computerMap.put(i + "," + j, new Position(i, j));
            }
        }

    }

    public void setPlayerShipPosition(AShip ship, Position pos) {
        pos.setShip(ship);
        this.playerMap.put(pos.getRow() + "," + pos.getCol(), pos);
    }

    public void setMessageText(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getMessageText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void disableFiveShots() {
        this.placement.setBlueShipPlaced(true);
    }

    public void disableFourShots() {
        this.placement.setGreenShipPlaced(true);
    }

    public void disableThreeShots1() {
        this.placement.setYellowShipPlaced(true);
    }

    public void disableThreeShots2() {
        this.placement.setRedShipPlaced(true);
    }

    public void disableTwoShots() {
       this.placement.setBlackShipPlaced(true);
    }


    public final int maxGridX = 10;
    public final int maxGridY = 10;
    public Position startPos = new Position(-1, -1);
    public Position endPos = new Position(-1, -1);
    public ShipPlacement placement = new ShipPlacement();
    public int currentMaxShipSize = 5;

    public int getCurrentMaxShipSize() {
        return currentMaxShipSize;
    }
    public int shipSize3Bombed = 0;

    

    public Position getStartPosition() {
        return this.startPos;
    }

    public Position getEndPosition() {
        return this.endPos;
    }

    void setComputerShipPosition(AShip ship, Position pos) {
        pos.setShip(ship);
        this.computerMap.put(pos.getRow() + "," + pos.getCol(), pos);
    }

 
    public HashMap<String, Position> playerMap = new HashMap();
    public HashMap<String, Position> computerMap = new HashMap();
    private boolean currentBomberComp = false;

    public boolean isCurrentBomberComp() {
        return currentBomberComp;
    }

    public void setCurrentBomberComp(boolean currentBomberComp) {
        this.currentBomberComp = currentBomberComp;
    }

    Position computerMapPosition(String name) {
        Position pos = computerMap.get(name);
        return pos;
    }
    private int playerHit = 0;
    private int compHit = 0;
    private final int hitsToWin = 17;

    public int getCompHit() {
        return compHit;
    }

    public void setCompHitIncrease() {
        this.compHit += 1;
    }

    public int getPlayerHit() {
        return playerHit;
    }

    public void setPlayerHitIncrease() {
        this.playerHit += 1;
    }

    public boolean getWinningStatus(int hits) {
        if (hitsToWin == hits) {
            setGameCompleteStatus(true);
            return true;
        } else {
            return false;
        }
    }
    private int playerMiss = 0;

    public int getPlayerMiss() {
        return playerMiss;
    }

    public void setPlayerMissIncrease() {
        this.playerMiss += 1;
    }
    private boolean gameCompleteStatus = false;

    public boolean isGameCompleteStatus() {
        return gameCompleteStatus;
    }

    public void setGameCompleteStatus(boolean gameCompleteStatus) {
        this.gameCompleteStatus = gameCompleteStatus;
    }
    private int compMiss = 0;

    public int getCompMiss() {
        return compMiss;
    }

    public void setCompMissIncrease() {
        this.compMiss += 1;
    }

    
}


