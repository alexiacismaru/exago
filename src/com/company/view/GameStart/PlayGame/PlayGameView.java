package com.company.view.GameStart.PlayGame;


import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.Objects;


public class PlayGameView extends BorderPane {
    //----------------------------------------

    private final int tilesPerRow = 10;
    private final int Column = 13;
    private final static double r = 35; // the inner radius from hexagon center to outer corner
    private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
    private final static double TILE_HEIGHT = 2 * r;
    private final static double TILE_WIDTH = 2 * n;
    //--------------------------------------
    private Button menuButton;
    private AnchorPane AnchorPane;
    private Tile tile = new Tile();
    private Color color;
    private Tile[][] polygons = new Tile[tilesPerRow][Column];
    private final String[][] polygonsToString = new String[tilesPerRow][Column];

    public PlayGameView() {
        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        this.menuButton = new Button("Menu");

        this.AnchorPane = new AnchorPane();
        for (int i = 0; i < tilesPerRow; i++) {
            for (int j = 0; j < Column; j++) {
                polygons[i][j] = createBoard(i, j);
                polygonsToString[i][j] = polygons[i][j].toString();
               // System.out.println(i + "    " + j);
                if (!Objects.equals(polygons[i][j].getPoints().toString(), "[]")) {
                    AnchorPane.getChildren().add(polygons[i][j]);
                }
            }
        }
    }

    private void layoutNodes() {
        setTop(this.menuButton);
        setCenter(AnchorPane);
    }

    void FillAnchorPane(){
        this.AnchorPane.getChildren().clear();
        //System.out.println("---------------------------------------------------++++++++++++++++++++++++++--------------------");

        for (int i = 0; i < tilesPerRow; i++) {
            for (int j = 0; j < Column; j++) {
                //
                //polygons[i][j] = createBoard(i, j);
                //
                polygonsToString[i][j] = polygons[i][j].toString();
                if (polygons[i][j].getPoints().toString() != "[]") {
                    AnchorPane.getChildren().add(polygons[i][j]);
                  //     System.out.println(polygons[i][j].getFill() + " "  + i + "    " + j + " " + polygons[i][j].toString());
                }
            }
            System.out.println("\n");
        }
    }

    private Tile createBoard(int x, int y) {
        if ((y == 0 || y == 12) && x >= 3 && x < 7 ||
                (y == 1 || y == 11) && x >= 2 && x < 7 ||
                (y == 2 || y == 10) && x >= 2 && x < 8 ||
                (y == 3 || y == 9) && x >= 1 && x < 8 ||
                (y == 4 || y == 8) && x >= 1 && x < 9 ||
                (y == 5 || y == 7) && x < 9 || y == 6
        ) {
            // offsets the entire field to the right
            int xStartOffset = 45;
            double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
            // offsets the entire fiels downwards
            int yStartOffset = 45;
            double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
            tile = new Tile(xCoord, yCoord);

        } else {
            tile = new Tile();
        }
        return tile;
    }

    //needed getter and setter
    void setPolygonsColor(String color, int x, int y) {
        //System.out.println(color + "  "+ x + " " + y);
        if (Objects.equals(color, "BLUE")) {
           //             System.out.println("setPolygonsColor BLUE");
            this.color = Color.BLUE;
                        //-----------------
            int xStartOffset = 45;
            double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
                            // offsets the entire fiels downwards
            int yStartOffset = 45;
            double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
                        //-----------------
            polygons[x][y] = new Tile(xCoord, yCoord, this.color);
        } else if (Objects.equals(color, "RED")) {
            this.color = Color.RED;

                        //--------------
            int xStartOffset = 45;
            double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
                            // offsets the entire fiels downwards
            int yStartOffset = 45;
            double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
                        //-----------

          //              System.out.println("setPolygonsColor RED");
            polygons[x][y] = new Tile(xCoord, yCoord, this.color);
        }
    }
//-----------------------------------------------------------
    Button getMenuButton() {
        return menuButton;
    }

    Color getColor() {
        return color;
    }
    Tile[][] getPolygons() {
        return this.polygons;
    }

    String[][] getPolygonsToString() {
        return this.polygonsToString;
    }

    public AnchorPane getAnchorPane() {
        return AnchorPane;
    }

    public int getTilesPerRow() {
        return tilesPerRow;
    }

    public int getColumn() {
        return Column;
    }
}