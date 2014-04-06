/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GameEngine.java
 *
 * Created on May 1, 2010, 12:25:55 AM
 */

package Lab8;

import java.awt.Button;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author chhabara
 */
public class GameEngine extends javax.swing.JFrame {

    /** Creates new form GameEngine */
    public GameEngine() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lblTitle = new java.awt.Label();
        btnHelp = new java.awt.Button();
        lblPlayer = new java.awt.Label();
        lblChooseShip = new java.awt.Label();
        lblComputer = new java.awt.Label();
        panComp = new javax.swing.JPanel();
        panPlayer = new javax.swing.JPanel();
        btnRedShip = new java.awt.Button();
        btnGreenShip = new java.awt.Button();
        btnBlueShip = new java.awt.Button();
        btnBlackShip = new java.awt.Button();
        btnYellowSHip = new java.awt.Button();
        msgArea = new java.awt.TextArea();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        lblPlrHits = new java.awt.Label();
        lblCompHits = new java.awt.Label();
        lblPlrMiss = new java.awt.Label();
        lblCompMiss = new java.awt.Label();
        lblShipAlign = new java.awt.Label();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setOpaque(false);
        mainPanel.setRequestFocusEnabled(false);
        mainPanel.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblTitle.setName("lblTitle"); // NOI18N
        lblTitle.setText("War Of Ships");
        mainPanel.add(lblTitle);
        lblTitle.setBounds(140, 0, 149, 36);

        btnHelp.setFont(btnHelp.getFont());
        btnHelp.setLabel("Help");
        btnHelp.setName("btnHelp"); // NOI18N
        btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHelphelpClicked(evt);
            }
        });
        mainPanel.add(btnHelp);
        btnHelp.setBounds(530, 10, 42, 24);

        lblPlayer.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        lblPlayer.setName("lblPlayer"); // NOI18N
        lblPlayer.setText("Player War Zone");
        mainPanel.add(lblPlayer);
        lblPlayer.setBounds(20, 110, 98, 20);

        lblChooseShip.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        lblChooseShip.setName("lblChooseShip"); // NOI18N
        lblChooseShip.setText("ChooseShip");
        mainPanel.add(lblChooseShip);
        lblChooseShip.setBounds(10, 50, 72, 20);

        lblComputer.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        lblComputer.setName("lblComputer"); // NOI18N
        lblComputer.setText("Computer War Zone");
        mainPanel.add(lblComputer);
        lblComputer.setBounds(300, 110, 118, 20);

        panComp.setName("panComp"); // NOI18N

        for(int j=1; j< 11; j++)
        {
            for(int i=1; i< 11; i++)
            {
                computerButtons[i][j] = new Button();
                computerButtons[i][j].setName(i+","+j);
                computerButtons[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        computerGridClicked(evt);
                    }
                });
                computerButtons[i][j].setEnabled(false);
                panComp.add(computerButtons[i][j]);
            }
        }
        panComp.setLayout(new java.awt.GridLayout(10, 10));
        mainPanel.add(panComp);
        panComp.setBounds(300, 140, 250, 250);

        panPlayer.setName("panPlayer"); // NOI18N

        for(int j=1; j< 11; j++)
        {
            for(int i=1; i< 11; i++)
            {
                playerButtons[i][j] = new Button();
                playerButtons[i][j].setName(i+","+j);
                playerButtons[i][j].setBackground(Color.white);
                //butt[i][j].setText(i+","+j);
                playerButtons[i][j].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        playerGridEntered(evt);
                    }

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        playerGridClicked(evt);
                    }

                });

                panPlayer.add(playerButtons[i][j]);
            }
        }
        panPlayer.setLayout(new java.awt.GridLayout(10, 10));
        mainPanel.add(panPlayer);
        panPlayer.setBounds(20, 140, 250, 250);

        btnRedShip.setBackground(new java.awt.Color(255, 51, 51));
        btnRedShip.setFont(btnRedShip.getFont());
        btnRedShip.setForeground(new java.awt.Color(255, 255, 255));
        btnRedShip.setLabel("Red Ship(3)");
        btnRedShip.setName("red"); // NOI18N
        btnRedShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRedShipshipClicked(evt);
            }
        });
        mainPanel.add(btnRedShip);
        btnRedShip.setBounds(340, 80, 82, 24);

        btnGreenShip.setBackground(new java.awt.Color(0, 204, 51));
        btnGreenShip.setFont(btnGreenShip.getFont());
        btnGreenShip.setForeground(new java.awt.Color(255, 255, 255));
        btnGreenShip.setLabel("Green Ship(4)");
        btnGreenShip.setName("green"); // NOI18N
        btnGreenShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGreenShipshipClicked(evt);
            }
        });
        mainPanel.add(btnGreenShip);
        btnGreenShip.setBounds(120, 80, 93, 24);

        btnBlueShip.setBackground(new java.awt.Color(0, 51, 255));
        btnBlueShip.setFont(btnBlueShip.getFont());
        btnBlueShip.setForeground(new java.awt.Color(255, 255, 255));
        btnBlueShip.setLabel("Blue Ship(5)");
        btnBlueShip.setName("blue"); // NOI18N
        btnBlueShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBlueShipshipClicked(evt);
            }
        });
        mainPanel.add(btnBlueShip);
        btnBlueShip.setBounds(20, 80, 84, 24);

        btnBlackShip.setBackground(new java.awt.Color(0, 0, 0));
        btnBlackShip.setFont(btnBlackShip.getFont());
        btnBlackShip.setForeground(new java.awt.Color(255, 255, 255));
        btnBlackShip.setLabel("Black Ship(2)");
        btnBlackShip.setName("black"); // NOI18N
        btnBlackShip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBlackShipshipClicked(evt);
            }
        });
        mainPanel.add(btnBlackShip);
        btnBlackShip.setBounds(440, 80, 89, 24);

        btnYellowSHip.setBackground(new java.awt.Color(255, 255, 0));
        btnYellowSHip.setFont(btnYellowSHip.getFont());
        btnYellowSHip.setForeground(new java.awt.Color(102, 102, 102));
        btnYellowSHip.setLabel("Yellow Ship(3)");
        btnYellowSHip.setName("yellow"); // NOI18N
        btnYellowSHip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnYellowSHipshipClicked(evt);
            }
        });
        mainPanel.add(btnYellowSHip);
        btnYellowSHip.setBounds(230, 80, 95, 24);

        msgArea.setEditable(false);
        msgArea.setName("msgArea"); // NOI18N
        printMessageArea("1. Place your Ships on the Player War Zone.\n2. Use Right Mouse Click on Player War Zone to toggle Ship Alignment. ");
        mainPanel.add(msgArea);
        msgArea.setBounds(20, 440, 530, 80);

        label6.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        label6.setName("label6"); // NOI18N
        label6.setText("Hits");
        mainPanel.add(label6);
        label6.setBounds(30, 410, 26, 20);

        label7.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        label7.setName("label7"); // NOI18N
        label7.setText("Miss");
        mainPanel.add(label7);
        label7.setBounds(130, 410, 31, 20);

        label8.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        label8.setName("label8"); // NOI18N
        label8.setText("Hits");
        mainPanel.add(label8);
        label8.setBounds(310, 410, 26, 20);

        label9.setFont(new java.awt.Font("Dialog 14", 1, 12)); // NOI18N
        label9.setName("label9"); // NOI18N
        label9.setText("Miss");
        mainPanel.add(label9);
        label9.setBounds(420, 410, 31, 20);

        lblPlrHits.setName("lblPlrHits"); // NOI18N
        lblPlrHits.setText("0");
        mainPanel.add(lblPlrHits);
        lblPlrHits.setBounds(350, 410, 20, 20);

        lblCompHits.setName("lblCompHits"); // NOI18N
        lblCompHits.setText("0");
        mainPanel.add(lblCompHits);
        lblCompHits.setBounds(70, 410, 20, 20);

        lblPlrMiss.setName("lblPlrMiss"); // NOI18N
        lblPlrMiss.setText("0");
        mainPanel.add(lblPlrMiss);
        lblPlrMiss.setBounds(460, 410, 30, 20);

        lblCompMiss.setName("lblCompMiss"); // NOI18N
        lblCompMiss.setText("0");
        mainPanel.add(lblCompMiss);
        lblCompMiss.setBounds(180, 410, 20, 20);

        lblShipAlign.setName("lblShipAlign"); // NOI18N
        lblShipAlign.setText("Horizontal");
        mainPanel.add(lblShipAlign);
        lblShipAlign.setBounds(160, 390, 59, 20);

        label1.setName("label1"); // NOI18N
        label1.setText("Ship Alignment :");
        mainPanel.add(label1);
        label1.setBounds(50, 390, 93, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHelphelpClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelphelpClicked
        printMessageArea("1. Place your Ships on the Player War Zone.\n2. Use Right Mouse Click on Player War Zone to toggle Ship Alignment. ");
}//GEN-LAST:event_btnHelphelpClicked

    private void btnRedShipshipClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRedShipshipClicked

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());

    }//GEN-LAST:event_btnRedShipshipClicked

    private void btnGreenShipshipClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGreenShipshipClicked

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());

    }//GEN-LAST:event_btnGreenShipshipClicked

    private void btnBlueShipshipClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBlueShipshipClicked

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());

    }//GEN-LAST:event_btnBlueShipshipClicked

    private void btnBlackShipshipClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBlackShipshipClicked

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());

    }//GEN-LAST:event_btnBlackShipshipClicked

    private void btnYellowSHipshipClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnYellowSHipshipClicked

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());

    }//GEN-LAST:event_btnYellowSHipshipClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameEngine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnBlackShip;
    private java.awt.Button btnBlueShip;
    private java.awt.Button btnGreenShip;
    private java.awt.Button btnHelp;
    private java.awt.Button btnRedShip;
    private java.awt.Button btnYellowSHip;
    private java.awt.Label label1;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label lblChooseShip;
    private java.awt.Label lblCompHits;
    private java.awt.Label lblCompMiss;
    private java.awt.Label lblComputer;
    private java.awt.Label lblPlayer;
    private java.awt.Label lblPlrHits;
    private java.awt.Label lblPlrMiss;
    private java.awt.Label lblShipAlign;
    private java.awt.Label lblTitle;
    private javax.swing.JPanel mainPanel;
    private java.awt.TextArea msgArea;
    private javax.swing.JPanel panComp;
    private javax.swing.JPanel panPlayer;
    // End of variables declaration//GEN-END:variables


    private ShipHolder holder = new ShipHolder();
    private Game game = new Game();
    private AShip currentShip = new AShip();
    private boolean isShipPlaceable;
    Button[][] playerButtons = new Button[11][11];
    Button[][] computerButtons = new Button[11][11];
    private Color currentShipColor;


    private void disablePlayerGrid() {

        for (int j = 1; j < 11; j++) {
            for (int i = 1; i < 11; i++) {
                this.playerButtons[i][j].setEnabled(false);
            }
        }
    }


    private void shipClicked(java.awt.event.MouseEvent evt) {

        this.holder.setShipType(evt.getComponent().getName());
        this.holder.setHolderState(true);
        this.currentShip = this.createShip(this.holder.getShipType());


}

    private void helpClicked(java.awt.event.MouseEvent evt) {
        printMessageArea("1. Place your Ships on the Player War Zone.\n2. Use Right Mouse Click on Player War Zone to toggle Ship Alignment. ");
    }

    private void printMessageArea(String str) {
        msgArea.setText(str);
    }

    private void computerGridClicked(java.awt.event.MouseEvent evt) {

        if (!game.isCurrentBomberComp() && !game.isGameCompleteStatus()) {
            Position pos = this.game.computerMapPosition(evt.getComponent().getName());
            pos.setBombed(true);
            game.isGameCompleteStatus();
            Button b = new Button();
            b = (Button) evt.getComponent();
            b.setBackground(Color.LIGHT_GRAY);

            if (pos.isBombed() && pos.isOccupied()) {
                b.setLabel("X");
                b.setBackground(Color.red);
                b.setEnabled(false);
                game.setCurrentBomberComp(false);
                game.setPlayerHitIncrease();
                pos.getShip().increaseDestruction();
                lblPlrHits.setText(game.getPlayerHit() + "");
                if (pos.getShip().isFullyDestroyed()) {
                    printMessageArea("Computer's " + pos.getShip().getShipName() + " ship is fully destroyed");
                }
                if (game.getWinningStatus(game.getPlayerHit())) {
                    printMessageArea("Player Won");
                }
            } else if (pos.isBombed() && !pos.isOccupied()) {

                game.setPlayerMissIncrease();
                lblPlrMiss.setText(game.getPlayerMiss() + "");
                b.setEnabled(false);
                game.setCurrentBomberComp(true);

                compBombs();
            } else {
                game.setCurrentBomberComp(true);
            }

        }
    }

    private void compBombs() {
        if (!game.isGameCompleteStatus()) {
            Position posX = this.computerBomber();

            if (posX.isBombed() && posX.isOccupied()) {
                playerButtons[posX.getRow()][posX.getCol()].setForeground(Color.white);
                playerButtons[posX.getRow()][posX.getCol()].setLabel("X");

                game.setCompHitIncrease();
                lblCompHits.setText(game.getCompHit() + "");
                posX.getShip().increaseDestruction();

                if (posX.getShip().isFullyDestroyed()) {
                    printMessageArea("Your " + posX.getShip().getShipName() + " ship is fully destroyed");
                    this.setCurrentMaxShipSize(posX.getShip().getShipSize());
                }
                if (game.getWinningStatus(game.getCompHit())) {
                    printMessageArea("Computer Won");
                }
                compBombs();
            } else if (posX.isBombed() && !posX.isOccupied()) {
                playerButtons[posX.getRow()][posX.getCol()].setBackground(Color.lightGray);
                game.setCurrentBomberComp(false);
                game.setCompMissIncrease();
                lblCompMiss.setText(game.getCompMiss() + "");
            } else {
                game.setCurrentBomberComp(false);
            }

        }
    }

    private void playerGridEntered(java.awt.event.MouseEvent evt) {

        if (this.holder.isHolderOn()) {
            this.isShipPlaceable = this.isPlayerShipPlaceable(evt.getComponent().getName(), this.currentShip.getShipSize(), this.currentShip.getShipAlignment());

        }
    }

    private void playerGridClicked(java.awt.event.MouseEvent evt) {


        if (this.holder.isHolderOn()) {

            if (this.isShipPlaceable && evt.getButton() == 1) {

                boolean isShipPlaced = false;
                if (this.currentShip.getShipName().equalsIgnoreCase("blue")) {
                    isShipPlaced = this.game.placement.isBlueShipPlaced();
                    this.game.disableFiveShots();
                    btnBlueShip.setEnabled(false);

                } else if (this.currentShip.getShipName().equalsIgnoreCase("green")) {
                    isShipPlaced = this.game.placement.isGreenShipPlaced();
                    this.game.disableFourShots();
                    btnGreenShip.setEnabled(false);
                } else if (this.currentShip.getShipName().equalsIgnoreCase("yellow")) {
                    isShipPlaced = this.game.placement.isYellowShipPlaced();
                    this.game.disableThreeShots1();
                    btnYellowSHip.setEnabled(false);
                } else if (this.currentShip.getShipName().equalsIgnoreCase("red")) {
                    isShipPlaced = this.game.placement.isRedShipPlaced();
                    this.game.disableThreeShots2();
                    btnRedShip.setEnabled(false);
                } else {
                    isShipPlaced = this.game.placement.isBlackShipPlaced();
                    this.game.disableTwoShots();
                    btnBlackShip.setEnabled(false);
                }

                if (!isShipPlaced) {
                    this.addShip(this.currentShip);
                    this.colorGrid(this.game.getStartPosition(), this.game.getEndPosition());
                    printMessageArea(this.currentShip.getShipName() + " ship is placed");
                    if (this.checkAllPlayerShipPlaced()) {
                        printMessageArea("All Ships are placed. \nStart Bombing ships in Computer War Zone");
                        disablePlayerGrid();
                        enableComputerGrid();
                    }
                }

                this.holder.setHolderState(false);
                lblShipAlign.setText("Horizontal");



            } else if (evt.getButton() == 3) {
                if (this.currentShip.getShipAlignment()) {
                    this.currentShip.setShipAlignment(false);
                    lblShipAlign.setText("Vertical");
                } else {
                    this.currentShip.setShipAlignment(true);
                    lblShipAlign.setText("Horizontal");
                }
                this.isShipPlaceable = this.isPlayerShipPlaceable(evt.getComponent().getName(), this.currentShip.getShipSize(), this.currentShip.getShipAlignment());
            }

        }
    }

    private void colorGrid(Position start, Position end) {


        if (start.getCol() == end.getCol()) {
            for (int i = start.getRow(); i <= end.getRow(); i++) {
                this.playerButtons[i][start.getCol()].setBackground(this.currentShip.getShipColor());
            }
        } else {
            for (int i = start.getCol(); i <= end.getCol(); i++) {
                this.playerButtons[start.getRow()][i].setBackground(this.currentShip.getShipColor());
            }
        }
    }


    private void enableComputerGrid() {
        for (int j = 1; j < 11; j++) {
            for (int i = 1; i < 11; i++) {
                this.computerButtons[i][j].setEnabled(true);
                this.computerButtons[i][j].setBackground(Color.white);
            }
        }
    }

    public void playersBoardClicked(Position position) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void opponentsBoardClicked(Position position) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see GameEngine.IGameEngine#addShip(GameEngine.AShip)
     * @param ship
     */
    public void addShip(AShip ship) {
        Position start = game.getStartPosition();
        Position end = game.getEndPosition();
        Position pos = new Position(0, 0);
        if (start.getCol() == end.getCol()) {
            for (int i = start.getRow(); i <= end.getRow(); i++) {
                pos = new Position(i, start.getCol());
                pos.setOccupied(true);
                game.setPlayerShipPosition(ship, pos);
            }
        } else {
            for (int i = start.getCol(); i <= end.getCol(); i++) {
                pos = new Position(start.getRow(), i);
                pos.setOccupied(true);
                game.setPlayerShipPosition(ship, pos);
            }
        }



    }

    public Position getNextRandomPosition() {
        Position pos = game.playerMap.get(getRandomCords());
        game.shipCenter = null;
        while (pos.isBombed()) {
            pos = game.playerMap.get(getRandomCords());
        }
        if (isViscinitySufficientForMaxShipSize(pos)) {
            return pos;
        } else {
            return getNextRandomPosition();
        }
    }

    private boolean isViscinitySufficientForMaxShipSize(Position pos) {

        if (isViscinitySufficientForMaxShipSizeX(pos)) {
            return true;
        } else if (isViscinitySufficientForMaxShipSizeY(pos)) {
            return true;
        }
        return false;
    }

    public boolean isPlayerShipPlaceable(String cords, int shipSize, boolean shipAlignment) {
        game.startPos.initPosition();
        game.endPos.initPosition();
        Position pos = new Position(cords);
        int minX = pos.getRow();
        int minY = pos.getCol();
        int maxX;
        int maxY;

        if (shipAlignment) {
            maxX = minX + shipSize - 1;
            maxY = minY;
        } else {
            maxY = minY + shipSize - 1;
            maxX = minX;
        }


        if (maxX <= game.maxGridX && maxY <= game.maxGridY) {
            if (shipAlignment) {
                for (int i = minX; i <= maxX; i++) {
                    if (isPlayerGridPreOccupied(i, minY)) {

                        return false;
                    }

                }

            } else {
                for (int i = minY; i <= maxY; i++) {
                    if (isPlayerGridPreOccupied(minX, i)) {
                        return false;
                    }
                }


            }

        } else {

            return false;

        }
        game.startPos = new Position(minX, minY);
        game.endPos = new Position(maxX, maxY);
        return true;
    }

    private boolean isPlayerGridPreOccupied(int x, int y) {

        Position pos = game.playerMap.get(x + "," + y);
        return pos.isOccupied();
    }

    public void setCurrentMaxShipSize(int curMaxShipSize) {

        if (game.currentMaxShipSize == curMaxShipSize) {
            if (curMaxShipSize == 3) {
                game.shipSize3Bombed += 1;
            }
            if (curMaxShipSize == 3) {
                if (game.shipSize3Bombed == 2) {
                    game.currentMaxShipSize = curMaxShipSize - 1;
                }
            } else {
                game.currentMaxShipSize = curMaxShipSize - 1;
            }


        }
    }

    private boolean isViscinitySufficientForMaxShipSizeX(Position pos) {
        int maxShipSize = game.currentMaxShipSize;
        int viscinitySize = 1;
        int x = pos.getRow();
        int y = pos.getCol();
        Position initpos = pos;
        boolean isEndMet = false;
        if ((x + 1) < 11) {
            pos = game.playerMap.get((x + 1) + "," + y);
            while ((!pos.isBombed() || (pos.isOccupied() && !pos.getShip().isFullyDestroyed())) && !isEndMet) {
                viscinitySize += 1;
                //System.out.println("Position chose " + pos.toString() + " ViscinityX " + viscinitySize);
                x += 1;
                if ((x + 1) < 11) {
                    pos = game.playerMap.get((x + 1) + "," + y);
                } else {
                    isEndMet = true;
                }

            }
        }
        pos = initpos;
        x = pos.getRow();
        y = pos.getCol();
        isEndMet = false;
        if ((x - 1) > 0) {
            pos = game.playerMap.get((x - 1) + "," + y);
            while ((!pos.isBombed() || (pos.isOccupied() && !pos.getShip().isFullyDestroyed())) && !isEndMet) {
                viscinitySize += 1;
                //System.out.println("Position chose " + pos.toString() + " ViscinityX " + viscinitySize);
                x -= 1;
                if ((x - 1) > 0) {
                    pos = game.playerMap.get((x - 1) + "," + y);
                } else {
                    isEndMet = true;
                }

            }
        }

        if (viscinitySize >= maxShipSize) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isViscinitySufficientForMaxShipSizeY(Position pos) {
        int maxShipSize = game.currentMaxShipSize;
        int viscinitySize = 1;
        int x = pos.getRow();
        int y = pos.getCol();
        Position initpos = pos;
        boolean isEndMet = false;
        if ((y + 1) < 11) {
            pos = game.playerMap.get(x + "," + (y + 1));
            while ((!pos.isBombed() || (pos.isOccupied() && !pos.getShip().isFullyDestroyed())) && !isEndMet) {
                viscinitySize += 1;
                //System.out.println("Position chose " + pos.toString() + " ViscinityY " + viscinitySize);
                y += 1;
                if ((y + 1) < 11) {
                    pos = game.playerMap.get(x + "," + (y + 1));
                } else {
                    isEndMet = true;
                }

            }
        }
        pos = initpos;
        x = pos.getRow();
        y = pos.getCol();
        isEndMet = false;
        if ((y - 1) > 0) {
            pos = game.playerMap.get(x + "," + (y - 1));
            while ((!pos.isBombed() || (pos.isOccupied() && !pos.getShip().isFullyDestroyed())) && !isEndMet) {
                viscinitySize += 1;
                //System.out.println("Position chose " + pos.toString() + " ViscinityY " + viscinitySize);
                y -= 1;
                if ((y - 1) > 0) {
                    pos = game.playerMap.get(x + "," + (y - 1));
                } else {
                    isEndMet = true;
                }

            }
        }

        if (viscinitySize >= maxShipSize) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkAllPlayerShipPlaced() {
        if (game.placement.isBlackShipPlaced() && game.placement.isBlueShipPlaced() && game.placement.isGreenShipPlaced() && game.placement.isYellowShipPlaced() && game.placement.isRedShipPlaced()) {
            placeComputerShips();
            return true;
        }
        return false;
    }

    private void placeComputerShips() {

        this.addComputerShip(createShip("blue"));
        this.addComputerShip(createShip("green"));
        this.addComputerShip(createShip("yellow"));
        this.addComputerShip(createShip("red"));
        this.addComputerShip(createShip("black"));

    }

    public Position computerBomber() {
        Position pos = new Position(0, 0);

        if (game.shipCenter != null && !game.shipCenter.getShip().isFullyDestroyed()) {
            pos = getAdjusantUnbombedPosition(game.shipCenter.getRow(), game.shipCenter.getCol());
        } else {
            pos = getNextRandomPosition();

        }
        
        pos.setBombed(true);
        if (pos.isOccupied()) {
            game.shipCenter = pos;
        }

        return pos;
    }

    private Position getAdjusantUnbombedPosition(int x, int y) {

        Random randomGenerator = new Random();
        Position pos = null;
        Position finalPos = null;
        for (int i = 0; i < 16; i++) {
            int tmp = randomGenerator.nextInt(100);
            if ((x + 1) < 11 && tmp % 3 == 0) {
                pos = game.playerMap.get((x + 1) + "," + y);

                if (!pos.isBombed()) {
                    finalPos = pos;
                }
            }
            if ((x - 1) > 0 && tmp % 5 == 0) {

                pos = game.playerMap.get((x - 1) + "," + y);
                if (!pos.isBombed()) {
                    finalPos = pos;
                }

            }
            if ((y + 1) < 11 && tmp % 7 == 0) {

                pos = game.playerMap.get(x + "," + (y + 1));
                if (!pos.isBombed()) {
                    finalPos = pos;
                }

            }
            if ((y - 1) > 0 && tmp % 2 == 0) {

                pos = game.playerMap.get(x + "," + (y - 1));
                if (!pos.isBombed()) {
                    finalPos = pos;
                }
            }
        }

        if (finalPos == null) {
            finalPos = getNextRandomPosition();
        }

        return finalPos;
    }

    private void addComputerShip(AShip ship) {
        Random randomGenerator = new Random();
        boolean flag = true;
        int randomInt = randomGenerator.nextInt(10);
        boolean shipAlignment;
        while (flag) {
            String cords = getRandomCords();
            if (randomInt % 2 == 0) {
                shipAlignment = true;
            } else {
                shipAlignment = false;
            }

            flag = !this.isComputerShipPlaceable(cords, ship.getShipSize(), shipAlignment);
        }

        this.addComputerShipToMap(ship);
    }

    private boolean isComputerShipPlaceable(String cords, int shipSize, boolean shipAlignment) {
        game.startPos.initPosition();
        game.endPos.initPosition();
        Position pos = new Position(cords);
        int minX = pos.getRow();
        int minY = pos.getCol();
        int maxX;
        int maxY;

        if (shipAlignment) {
            maxX = minX + shipSize - 1;
            maxY = minY;
        } else {
            maxY = minY + shipSize - 1;
            maxX = minX;
        }


        if (maxX <= game.maxGridX && maxY <= game.maxGridY) {

            if (shipAlignment) {
                for (int i = minX; i <= maxX; i++) {
                    if (isComputerGridPreOccupied(i, minY)) {

                        return false;
                    }

                }

            } else {
                for (int i = minY; i <= maxY; i++) {
                    if (isComputerGridPreOccupied(minX, i)) {

                        return false;
                    }
                }


            }

        } else {

            return false;

        }
        game.startPos = new Position(minX, minY);
        game.endPos = new Position(maxX, maxY);
        return true;
    }

    private boolean isComputerGridPreOccupied(int x, int y) {
        Position pos = game.computerMap.get(x + "," + y);
        return pos.isOccupied();
    }

    public AShip createShip(String color) {
        if (color.equalsIgnoreCase("blue")) {
            return new AShip(5, "blue");
        } else if (color.equalsIgnoreCase("green")) {
            return new AShip(4, "green");
        } else if (color.equalsIgnoreCase("yellow")) {
            return new AShip(3, "yellow");
        } else if (color.equalsIgnoreCase("red")) {
            return new AShip(3, "red");
        } else {
            return new AShip(2, "black");
        }

    }

    private String getRandomCords() {
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(10) + 1;
        int y = randomGenerator.nextInt(10) + 1;
        //System.out.println("Random X,Y" + x + " " + y);
        return x + "," + y;
    }

    public void addComputerShipToMap(AShip ship) {
        Position start = game.getStartPosition();
        Position end = game.getEndPosition();
        Position pos = new Position(0, 0);
        if (start.getCol() == end.getCol()) {
            for (int i = start.getRow(); i <= end.getRow(); i++) {
                pos = new Position(i, start.getCol());
                pos.setOccupied(true);
                game.setComputerShipPosition(ship, pos);
            }
        } else {
            for (int i = start.getCol(); i <= end.getCol(); i++) {
                pos = new Position(start.getRow(), i);
                pos.setOccupied(true);
                game.setComputerShipPosition(ship, pos);
            }
        }

    }












}