package com.company.Model;


import javafx.scene.paint.Color;

public class Board {
    //---------------------------------------------------------------------------------------
    private final int xStartOffset = 45; // offsets the entire field to the right
    private final int yStartOffset = 45; // offsets the entire fiels downwards

    private final static double r = 35; // the inner radius from hexagon center to outer corner
    private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
    private final static double TILE_HEIGHT = 2 * r;
    private final static double TILE_WIDTH = 2 * n;

    private String[][] polygonsToString;

    public Board() {
    }

//---------------------------------------------------------------------------------------

    private final int tilesPerRow = 10;
    private final int rowCount = 13;

    public int getTilesPerRow() {
        return rowCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    private final hexagonTile[][] hexagonTiles = new hexagonTile[tilesPerRow][rowCount];

    public hexagonTile[][] initialiseBoard() {
        for (int x = 0; x < tilesPerRow; x++) {
            for (int y = 0; y < rowCount; y++) {
                if ((y == 0 || y == 12) && x >= 3 && x < 7 ||
                        (y == 1 || y == 11) && x >= 2 && x < 7 ||
                        (y == 2 || y == 10) && x >= 2 && x < 8 ||
                        (y == 3 || y == 9) && x >= 1 && x < 8 ||
                        (y == 4 || y == 8) && x >= 1 && x < 9 ||
                        (y == 5 || y == 7) && x < 9 || y == 6
                ) {
                    hexagonTiles[x][y] = new hexagonTile(true, "WHITE", false, -1,-1);
                } else {
                    hexagonTiles[x][y] = new hexagonTile(false);
                }
            }
        }
        return hexagonTiles;
    }

    public void changePlayedOnBoardCPU(hexagonTile hexagonTile, int turn, int xPassedThrough, int yPassedThrough) {
        // tileMap.getChildren().clear();
        System.out.println(turn + "---------------");
        int colorDescision;
        for (int x = 0; x < tilesPerRow; x++) {
            for (int y = 0; y < rowCount; y++) {
                if ((y == 0 || y == 12) && x >= 3 && x < 7 ||
                        (y == 1 || y == 11) && x >= 2 && x < 7 ||
                        (y == 2 || y == 10) && x >= 2 && x < 8 ||
                        (y == 3 || y == 9) && x >= 1 && x < 8 ||
                        (y == 4 || y == 8) && x >= 1 && x < 9 ||
                        (y == 5 || y == 7) && x < 9 || y == 6
                ) {
                    if ((x != xPassedThrough && y != yPassedThrough) && turn == 0) {
                        colorDescision = -1;
                        hexagonTiles[x][y] = new hexagonTile(true, "WHITE", false, -1,colorDescision);
                        // } else if (hexagonTile.getColor1() != "RED" && turn%2 == 0) {
                    }  else if ((x == xPassedThrough && y == yPassedThrough) && turn == 1) {
                        //System.out.println(x + " == " + xPassedThrough + " && " + y + " == " + yPassedThrough + ") && " + turn % 2 + " == " + 1);
                        System.out.println("RED player");
                        colorDescision = 1;
                        //System.out.println(this.hexagonTiles[xPassedThrough][yPassedThrough].toString() +  "\n----------------------------------------------------------------------------------------------------------------------");
                        hexagonTiles[x][y] = new hexagonTile(true, "RED", true, 1,colorDescision);
                      //  System.out.println(this.hexagonTiles[xPassedThrough][yPassedThrough].toString() + "\n----------------------------------------------------------------------------------------------------------------------");

                    }
                   // System.out.println(hexagonTiles[x][y].toString() + " " + x + " " + y);

                }
            }
        }
    }

    public void changePlayedOnBoardPlayer(hexagonTile hexagonTile, int turn, int xPassedThrough, int yPassedThrough) {
        // tileMap.getChildren().clear();
        System.out.println(turn + "---------------");
        int colorDescision;
        for (int x = 0; x < tilesPerRow; x++) {
            for (int y = 0; y < rowCount; y++) {
                if ((y == 0 || y == 12) && x >= 3 && x < 7 ||
                        (y == 1 || y == 11) && x >= 2 && x < 7 ||
                        (y == 2 || y == 10) && x >= 2 && x < 8 ||
                        (y == 3 || y == 9) && x >= 1 && x < 8 ||
                        (y == 4 || y == 8) && x >= 1 && x < 9 ||
                        (y == 5 || y == 7) && x < 9 || y == 6
                ) {
                    if ((x != xPassedThrough && y != yPassedThrough) && turn == 0) {
                        colorDescision = -1;
                        hexagonTiles[x][y] = new hexagonTile(true, "WHITE", false, -1,colorDescision);
                        // } else if (hexagonTile.getColor1() != "RED" && turn%2 == 0) {
                    } else if ((x == xPassedThrough && y == yPassedThrough) && turn  == 0) {
                        //System.out.println(x + " == " + xPassedThrough + " && " + y + " == " + yPassedThrough + ") && " + turn % 2 + " == " + 0);
                        System.out.println("BLUE player");
                        colorDescision = 0;

                        //System.out.println(this.hexagonTiles[xPassedThrough][yPassedThrough].toString() + "\n----------------------------------------------------------------------------------------------------------------------");
                        hexagonTiles[x][y] = new hexagonTile(true, "BLUE", true, 0,colorDescision);
                        System.out.println(hexagonTiles[x][y].toString());
                        //System.out.println(this.hexagonTiles[xPassedThrough][yPassedThrough].toString() + "\n----------------------------------------------------------------------------------------------------------------------");
                    }
                    // System.out.println(hexagonTiles[x][y].toString() + " " + x + " " + y);
                }
            }
        }
    }

    public hexagonTile[][] getHexagonTiles() {
        return hexagonTiles;
    }

    public void fillInTilePlayer(String tileClicked, int turn, int x, int y) {


        for (int i = 0; i < tilesPerRow; i++) {
            for (int j = 0; j < rowCount; j++) {
                if (this.hexagonTiles[i][j].isTileOrNot()) {
                    if (polygonsToString[i][j].equals(tileClicked) && !this.hexagonTiles[i][j].isFilled()) {
                        //System.out.println("works");
                        changePlayedOnBoardPlayer(hexagonTiles[i][j], turn, x, y);
                        break;

                    } else if (this.hexagonTiles[i][j].isFilled()) {

                    }
                } else {
                    // System.out.println("null");
                }
            }
        }
    }

    public void fillInTileCPU(int x, int y, String tileClicked, int turn) {

        if (this.hexagonTiles[x][y].isTileOrNot()) {
            if (this.polygonsToString[x][y].equals(tileClicked) && !this.hexagonTiles[x][y].isFilled()) {
                //System.out.println("works");
                //System.out.println("------------------------------\n" + this.hexagonTiles[i][j].getPolygon().toString() + "------------------------------");
                changePlayedOnBoardCPU(hexagonTiles[x][y], turn, x, y);
                //System.out.println(this.hexagonTiles[i][j].toString());
            } else if (this.hexagonTiles[x][y].isFilled()) {

            }
        } else {
            // System.out.println("null");
        }

    }

    public void setPolygonsString(String[][] polygonsToString) {
        this.polygonsToString = polygonsToString;
    }
}

