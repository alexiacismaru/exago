import Exago.Board;
import Exago.gameSession;
import Exago.hexagonTile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        gameSession gameSession = new gameSession();//new game

        gameSession.initialiseGame();
        while (true) {//while the next statements are true
            gameSession.playGame();
        }
       /* while (true) {
            System.out.println("fill in a tile give a color, x value and y value");
            String color;
            color = scanner.nextLine();
            int x;
            int y;
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

            board.fillInTilePlayer(color,x,y);
            for (int i = 0; i < hexagonTiles.length; i++) {
                for (int j = 0; j < hexagonTiles.length; j++) {
                    System.out.printf("%s\t", hexagonTiles[i][j].getColor());
                    if (j == 6) {
                        System.out.println();
                    }
                }
            }
        }*/
    }
}
