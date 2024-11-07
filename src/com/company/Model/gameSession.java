package com.company.Model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Objects;


public class gameSession {
    private final Board board = new Board();
    private hexagonTile[][] hexagonTiles;
    private final playerCPU participantCPU = new playerCPU();
    private final playerHuman participantPlayer = new playerHuman();
    private final Turn turn = new Turn(this.getBoard(), this.getHexagonTiles());
    private final ModelName modelName = new ModelName();
    private String[][] polygonsToString;


    public hexagonTile[][] getHexagonTiles() {
        return hexagonTiles;
    }

    public void initialiseGame(String name) {
        hexagonTiles = board.initialiseBoard();
        modelName.setUsername(name);

    }

    public Board getBoard() {
        return board;
    }


    public void playGame(String[][] PolyGonsToString, int x, int y) {
        this.polygonsToString = PolyGonsToString;
        board.setPolygonsString(this.polygonsToString);
        //System.out.println(turn.getTurn() + " ----------------------------------+++--------");
        //------------------------
        System.out.println(turn.getTurn());
        if (turn.getTurn() % 2 == 0) {
            board.fillInTilePlayer(this.polygonsToString[x][y], turn.getTurn() % 2, x, y);
            turn.incrementTurn();
            /*if (this.winOrLoss(this.hexagonTiles, participantPlayer.getColor())) {
                //return "The player won!";
            }*/
        } else if (turn.getTurn() % 2 != 0) {
            turn.calculateXYValue();
            board.fillInTileCPU(turn.getX(), turn.getY(), this.polygonsToString[turn.getX()][turn.getY()], turn.getTurn() % 2);
            /*if (this.winOrLoss(this.hexagonTiles, participantCPU.getColor())) {
                //return "The CPU won!\n GAME OVER";
            }*/
            turn.incrementTurn();
        }

    }

    public boolean winOrLoss(hexagonTile[][] hexagonTiles1, String color) {
        // horizontalCheck
        for (int i = 0; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getTilesPerRow(); j++) {
                if (!(j + 1 >= board.getTilesPerRow() || j + 2 >= board.getTilesPerRow() || j + 3 >= board.getTilesPerRow())) {
                    if (Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)
                            && Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)) {
                        return true;
                    }
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < board.getRowCount() - 3; i++) {
            for (int j = 0; j < board.getTilesPerRow(); j++) {
                if (!(i >= board.getTilesPerRow() || j >= board.getRowCount())) {
                    if (Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)
                            && Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)) {
                        return true;
                    }
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 3; i < board.getRowCount(); i++) {
            for (int j = 0; j < board.getTilesPerRow() - 3; j++) {
                if (!(i >= board.getTilesPerRow() || j >= board.getRowCount())) {
                    if (Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)
                            && Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)) {
                        return true;
                    }
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < board.getRowCount(); i++) {
            for (int j = 3; j < board.getTilesPerRow(); j++) {
                if (!(i >= board.getTilesPerRow() || j >= board.getRowCount())) {
                    if (Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)
                            && Objects.equals(hexagonTile.getColor(), color) && Objects.equals(hexagonTile.getColor(), color)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getTurn() {
        return turn.getTurn();
    }

    public int getColorDescision() {
        return hexagonTile.getColorDescision();
    }

    public Turn getTurnInstance(){
        return this.turn;
    }
}