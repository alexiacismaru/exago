package com.company.Model;

public class hexagonTile {
    private final boolean tileOrNot;
    private static String Color;

    private boolean filled;
    private int playerOrCPU;
    private static int colorDescision;
    public hexagonTile(boolean tileOrNot, String color, boolean filled,int playerOrCPU,int colorDescision) {
        this.tileOrNot = tileOrNot;
        Color = color;
        this.filled = filled;
        this.playerOrCPU = playerOrCPU;
        hexagonTile.colorDescision = colorDescision;
    }
    public hexagonTile(boolean tileOrNot) {
        this.tileOrNot = tileOrNot;
    }
    public boolean isTileOrNot() {
        return tileOrNot;
    }
    public static String getColor() {
        return Color;
    }
    public String getColor1(){
        return Color;
    }
    public void setColor(String color) {
        Color = color;
    }

    public boolean isFilled() {
        return filled;
    }
    public static int getColorDescision() {
        return colorDescision;
    }

    @Override
    public String toString() {
        return "hexagonTile{" +
                "Color= " + this.getColor1()+
                "tileOrNot=" + tileOrNot +
                ", filled=" + filled +
                ", playerOrCPU=" + playerOrCPU +
                '}';
    }
}
