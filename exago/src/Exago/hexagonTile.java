package Exago;

public class hexagonTile {
    private boolean tileOrNot;
    private String Color;
    private boolean filled;

    public hexagonTile(boolean tileOrNot, String color, boolean filled) {
        this.tileOrNot = tileOrNot;
        this.Color = color;
        this.filled = filled;
    }//constructor

    public hexagonTile(String color, boolean filled) {
        Color = color;
        this.filled = filled;
    }//constructor

    public hexagonTile(boolean tileOrNot) {
        this.tileOrNot = tileOrNot;
    }//constructor

    public boolean isTileOrNot() {
        return tileOrNot;
    }//method that checks if the tile is true or not

    public void setTileOrNot(boolean tileOrNot) {
        this.tileOrNot = tileOrNot;
    }//method that returns the state of the tile

    public String getColor() {
        return Color;
    }//getter

    public void setColor(String color) {
        Color = color;
    }//setter

    public boolean isFilled() {
        return filled;
    }//method that checks if the tile has been used before or not(using true or false)

    public void setFilled(boolean filled) {
        this.filled = filled;
    }//method that returns whether the tile is in use or not
}