package com.company.Model.Rules;

import com.company.Model.Board;
import com.company.Model.hexagonTile;
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
    private String[][] polygonsToString;

    @Condition
    public boolean isFilled(@Fact("board is almost full") boolean isFilled) {
        for (int i = 0; i < tilesPerRow; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (i == tilesPerRow - 1 && j == rowCount - 1) { //reached the last tile on the board
                    return true;
                }
            }
        }
        return true;
    }

    @Action
    public boolean fillInTileCPU(int x, int y, String tileClicked, int turn) {
        if (this.hexagonTiles[x][y].isTileOrNot()) {
            if (this.polygonsToString[x][y].equals(tileClicked) && !this.hexagonTiles[x][y].isFilled()) {
                board.changePlayedOnBoardCPU(hexagonTiles[x][y], turn, x, y);
            }
        }
        return true;
    }
}
