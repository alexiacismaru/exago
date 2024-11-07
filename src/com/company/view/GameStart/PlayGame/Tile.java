package com.company.view.GameStart.PlayGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

class Tile extends Polygon {

    //---------------------------------------------------------------------------------------

    private final static double r = 35; // the inner radius from hexagon center to outer corner
    private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
    private final static double TILE_WIDTH = 2 * n;

    //---------------------------------------------------------------------------------------


    public Tile(double x, double y) {
        getPoints().addAll(
                x, y,
                x, y + r,
                x + n, y + r * 1.5,
                x + TILE_WIDTH, y + r,
                x + TILE_WIDTH, y,
                x + n, y - r * 0.5
        );


        setFill(Color.FLORALWHITE);
        setStroke(Color.BLACK);
    }

    public Tile(double x, double y, Color color) {
        getPoints().addAll(
                x, y,
                x, y + r,
                x + n, y + r * 1.5,
                x + TILE_WIDTH, y + r,
                x + TILE_WIDTH, y,
                x + n, y - r * 0.5
        );


        setFill(color);
        setStroke(Color.BLACK);
    }


    public Tile() {
    }


}

//needed getter and setter
