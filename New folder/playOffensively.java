package com.company.Model;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Make straight lines", description = "After the game started keep the placed tiles in a straight line, either horizontal line or vertical.")
public class playOffensively {
        private Board board;
        private final int tilesPerRow = 10;
        private final int rowCount = 13;
        private final hexagonTile[][] hexagonTiles = new hexagonTile[tilesPerRow][rowCount];
        private int turn;

        @Condition
        public boolean fillInTileHuman(@Fact("the player already made their move") boolean fillInTilePlayer) {
                return true;
        }

        public boolean checkStraightLine(hexagonTile[][] hexagonTiles) {
                double slope = calculate(hexagonTiles[0], hexagonTiles[1]);
                for (int index = 2; index < hexagonTiles.length; index++) {
                        if (slope != calculate(hexagonTiles[0], hexagonTiles[index])) {
                                return false;
                        }
                }
                return true;
        }

        private double calculate(hexagonTile[] x, hexagonTile[] y) {
                return ((rowCount) * 1.0) / ((tilesPerRow) * 1.0);
        }

        @Action
        public void fillInTileCPU(int x, int y, String tileClicked, int turn) {
                if (this.hexagonTiles[x][y].isTileOrNot()) {
                        if (this.hexagonTiles[x][y].getPolygon().toString().equals(tileClicked) && !this.hexagonTiles[x][y].isFilled()) {
                                board.changePlayedOnBoard(this.hexagonTiles[x][y].getPolygon().toString(), hexagonTiles[x][y], turn);
                        }
                }
        }

        /*public boolean fillInTileCPU() {
                vertical line
                for (int i = 0; i < board.getRowCount() - 3; i++) {
                        for (int j = 0; j < board.getTilesPerRow(); j++) {
                                if (!(i >= board.getTilesPerRow() || j >= board.getRowCount())) {
                                        if (!this.hexagonTiles[i][j].isFilled()) {
                                                board.changePlayedOnBoard(this.hexagonTiles[i][j].getPolygon().toString(), hexagonTiles[i][j], turn);
                                        }
                                }
                        }
                }
                //horizontal line
                for (int i = 0; i < board.getRowCount(); i++) {
                        for (int j = 0; j < board.getTilesPerRow(); j++) {
                                if (!(j + 1 >= board.getTilesPerRow() || j + 2 >= board.getTilesPerRow() || j + 3 >= board.getTilesPerRow())) {
                                        if (!this.hexagonTiles[i][j].isFilled()) {
                                                board.changePlayedOnBoard(this.hexagonTiles[i][j].getPolygon().toString(), hexagonTiles[i][j], turn);
                                        }
                                }
                        }
                }
        return false;
        }*/
}