package com.company.Model;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Zugzwang", description = "Place tile next to the other when the board is almost filled")
public class Zugzwang {
    private int turn;
    private Board board;
    private final int tilesPerRow = 10;
    private final int rowCount = 13;
    private final hexagonTile[][] hexagonTiles = new hexagonTile[tilesPerRow][rowCount];
    private int x;
    private int y;
    private String tileClicked;

    @Condition
    public boolean isFilled(@Fact("board is almost full") boolean isFilled) {
        for (int i = 0; i < tilesPerRow; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (i == tilesPerRow - 1 && j == rowCount - 1){ //reached the last tile on the board
                    return fillInTileCPU();
                }
            }
        }
        return true;
    }
    @Action
    public boolean fillInTileCPU() { //make a move by placing the tile next to another tile
        if (this.hexagonTiles[x][y].isTileOrNot()) {
            if (this.hexagonTiles[x][y].getPolygon().toString().equals(tileClicked) && !this.hexagonTiles[x][y].isFilled()) {
                board.changePlayedOnBoard(this.hexagonTiles[x][y].getPolygon().toString(), hexagonTiles[x][y], turn);
            }
        }
        return true;
    }
}

