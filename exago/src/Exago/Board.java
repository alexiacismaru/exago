package Exago;

import java.util.Objects;
import java.util.Scanner;

public class Board {
    private final int MAX_AMOUNT = 7;//set final int as 7
    private final hexagonTile[][] hexagonTiles = new hexagonTile[MAX_AMOUNT][MAX_AMOUNT];//create array
    private final Scanner scanner = new Scanner(System.in);

    public hexagonTile[][] initialiseBoard() {//initialiseBoard() method
        for (int i = 0; i < hexagonTiles.length; i++) {//increase the value of i
            for (int j = 0; j < hexagonTiles.length; j++) {//increase the value of j
                if (//if
                        ((i == 0 || i == 6) && j < 4)//as long as i is 0 OR 6 AND j is smaller than 4
                                || ((i == 1 || i == 5) && j < 5)//OR i is 1 OR 5 AND i is smaller than 5
                                || ((i == 2 || i == 4) && j < 6)//OR i is 2 OR 4 AND i is smaller than 6
                                || (i == 3)//i is 3
                ) {//method that prints the hexagonal shape for the console game
                    hexagonTiles[i][j] = new hexagonTile(true, "White", false);//if any of the previous statements are true, then
                                                                                                    //print the word white as an infilled space and set it as a tile
                } else {
                    hexagonTiles[i][j] = new hexagonTile(false);//otherwise, set the tile value to false, meaning this isn't a space you can play on
                }

            }
        }
        return hexagonTiles;//return statement
    }

    public hexagonTile[][] getHexagonTiles() {//getter from the hexagonTile class
        return hexagonTiles;
    }

    public void fillInTilePlayer(String color) {//constructor


        while (true) {//while the following statements are true
            int y;
            int x;
            System.out.println("give an X value");
            x = scanner.nextInt() - 1;
            System.out.println("give an Y value");
            y = scanner.nextInt() - 1;
                if ((x < 7 && y < 7) && (x >= 0 && y >= 0)) {//if BOTH values are smaller than 7 AND bigger or equal to 0
                if (Objects.equals(hexagonTiles[x][y].getColor(), "White")) {//set the colour of the tiles to white
                    hexagonTiles[x][y].setColor(color);//set the colour to white
                    hexagonTiles[x][y].setFilled(true);//set the value of the tile to true
                    break;//end loop
                } else if (Objects.equals(hexagonTiles[x][y].getColor(), null)) {//otherwise, the colour is not available
                    System.out.println("THIS IS NOT A TILE");//error message
                } else {
                    System.out.println("this tile is already filled in");//the values were inserted before
                }
            } else if ((x < 0 || 7 < x) && (y > 0 && 7 > y)) {//if x is smaller than 0 OR 7 AND y is bigger than 0 AND smaller than 7
                System.out.printf("%d is not in bounds\n", x + 1);//specify the values are out of range
            } else if ((y < 0 || 7 < y) && (x > 0 && 7 > x)) {//otherwise, if y is bigger than 0 OR than 7 AND x is bigger than 0 AND smaller than 7
                System.out.printf("%d is not in bounds\n", x + 1);//state that the values are out of range
            } else {//otherwise
                System.out.printf("%d, %d is not in bounds\n", x + 1, y + 1);//the numbers that you selected are out of range
            }
        }
    }

    public void fillInTileCPU(String color, int i, int j) {//constructor
        i -= 1;
        j -= 1;
        System.out.println(i + "   " + j);//print the values of the integers i and j
        if (Objects.equals(hexagonTiles[i][j].getColor(), "White") && hexagonTiles[i][j].isTileOrNot()) {//if the tile is white AND the tile value is true
            hexagonTiles[i][j].setColor(color);//set the colour of the tile
            hexagonTiles[i][j].setFilled(true);//set it as an available tile
        }
    }
}
