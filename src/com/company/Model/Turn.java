package com.company.Model;
import java.util.Random;

public class Turn {
    private int turn = 0;
    private final Board board;
    private int x;
    private int y;
    private final Random random = new Random();
    private hexagonTile[][] hexagonTiles;

    public Turn(Board board, hexagonTile[][] hexagonTiles) {
        this.board = board;
        this.hexagonTiles = hexagonTiles;
    }

    public void incrementTurn() {
        turn += 1;
        this.hexagonTiles = board.getHexagonTiles();
    }

    public int getTurn() {
        return turn;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void calculateXYValue() {
        while (true) {
            this.setX(random.nextInt(1, 10)-1);
            this.setY(random.nextInt(1, 13)-1);
            if (hexagonTiles[this.getX()][this.getY()].isTileOrNot()) {
                if (!hexagonTiles[this.getX()][this.getY()].isFilled()) {
                    break;
                }
            }
        }
    }
}

