package Exago;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class gameSession {
    private Board board = new Board();//new board
    private hexagonTile[][] hexagonTiles;//new array
    private playerCPU participantCPU = new playerCPU();//new playerCPU
    private playerHuman participantPlayer = new playerHuman();//new playerHuman
    private final Scanner scanner = new Scanner(System.in);
    private Turn turn = new Turn(this.getBoard(), this.getHexagonTiles());//new turn consisting of a new board and new tiles


    public hexagonTile[][] getHexagonTiles() {
        return hexagonTiles;
    }//getter

    public void initialiseGame() {
        hexagonTiles = board.initialiseBoard();
        participantPlayer.setColor(participantCPU.setColor());
        this.displayGame();
    }

    public Board getBoard() {
        return board;
    }//getter

    public void displayGame() {//method that displays the actual game

        for (int i = 0; i < hexagonTiles.length; i++) {//increase the value of i
            for (int j = 0; j < hexagonTiles.length; j++) {//increase the value of j
                if (hexagonTiles[i][j].getColor() != null) {//if the colour of the tile is not null
                    System.out.printf("%5s\t", hexagonTiles[i][j].getColor());//get the colour of the tile
                }
                if (j == 6) {//if the value of j is 6
                    System.out.println();//print everything out
                }
            }
        }
        System.out.println();//print everything out
    }

    public void playGame() {

        if (turn.getTurn() % 2 == 0) {//if the turn is divisible by 2
            board.fillInTilePlayer(participantPlayer.getColor());
            turn.incrementTurn();
            this.displayGame();
        } else if (turn.getTurn() % 2 != 0) {//if the turn is not divisible by 2
            turn.calculateXYValue();
            board.fillInTileCPU(participantCPU.getColor(), turn.getX(), turn.getY());
            turn.incrementTurn();
            this.displayGame();
        }//see whose turn it is
    }

    public boolean winOrLoss(hexagonTile[][] hexagonTiles1, String color) {
        // horizontalCheck
        for (int j = 0; j < hexagonTiles1.length - 3; j++) {
            for (int i = 0; i < hexagonTiles1.length; i++) {
                if (hexagonTiles1[i][j].getColor() == color && hexagonTiles1[i][j + 1].getColor() == color
                        && hexagonTiles1[i][j + 2].getColor() == color && hexagonTiles1[i][j + 3].getColor() == color) {
                    return true;
                }
            }
        }
        // verticalCheck
        for (int i = 0; i < hexagonTiles1.length - 3; i++) {
            for (int j = 0; j < hexagonTiles1.length; j++) {
                if (hexagonTiles1[i][j].getColor() == color && hexagonTiles1[i + 1][j].getColor() == color
                        && hexagonTiles1[i + 2][j].getColor() == color && hexagonTiles1[i + 3][j].getColor() == color) {
                    return true;
                }
            }
        }
        // ascendingDiagonalCheck
        for (int i = 3; i < hexagonTiles1.length; i++) {
            for (int j = 0; j < hexagonTiles1.length - 3; j++) {
                if (hexagonTiles1[i][j].getColor() == color && hexagonTiles1[i - 1][j + 1].getColor() == color
                        && hexagonTiles1[i - 2][j + 2].getColor() == color && hexagonTiles1[i - 3][j + 3].getColor() == color) {
                    return true;
                }
            }
        }
        // descendingDiagonalCheck
        for (int i = 3; i < hexagonTiles1.length; i++) {
            for (int j = 3; j < hexagonTiles1.length; j++) {
                if (hexagonTiles1[i][j].getColor() == color && hexagonTiles1[i - 1][j - 1].getColor() == color
                        && hexagonTiles1[i - 2][j - 2].getColor() == color && hexagonTiles1[i - 3][j - 3].getColor() == color) {
                    return true;
                }
            }
        }
        return false;
    }//method that decides what makes you win or lose a game
}