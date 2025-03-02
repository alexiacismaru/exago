package Exago;

import java.util.Random;

public class Turn {
    private int turn = 0;
    private Board board;
    private int x;
    private int y;
    private final Random random = new Random();//new random number
    private hexagonTile[][] hexagonTiles;//new array

    public Turn(Board board, hexagonTile[][] hexagonTiles) {
        this.board = board;
        this.hexagonTiles = hexagonTiles;
    }//constructor

    public void incrementTurn() {
        turn += 1;
        this.hexagonTiles = board.getHexagonTiles();
    }//method that increases the number of turns the user took and that returns the hexagon tiles

    public int getTurn() {
        return turn;
    }//getter

    public int getX() {
        return x;
    }//getter

    public void setX(int x) {
        this.x = x;
    }//setter

    public int getY() {
        return y;
    }//getter

    public void setY(int y) {
        this.y = y;
    }//setter

    public void setTurn(int turn) {
        this.turn = turn;
    }//method that returns the number of turns

    public void calculateXYValue() {
        while (true) {//while the next statements are true
            this.setX(random.nextInt(1, 8));//random x value from 1 to 7
            this.setY(random.nextInt(1, 8));//random y value from 1 to 7
            if (hexagonTiles[this.getX() -1][this.getY()-1].isTileOrNot()) {// the value of x and y
                if (!hexagonTiles[this.getX() - 1][this.getY() - 1].isFilled()) {
                    break;//end loop
                }
            }
        }
    }//method that calculates the value of x and y
}
