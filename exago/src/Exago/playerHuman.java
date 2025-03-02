package Exago;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class playerHuman extends participant {
    private final Scanner scanner = new Scanner(System.in);
    private String Color;

    @Override
    public String getColor() {
        return Color;
    }//getter


    public void setColor(String colorCPU) {
        while (true) {
            System.out.println("choose a color: \n1) Black\n2) Red\n3) Blue\n4) Orange\n5) Green");//make the user choose a colour to play with
            String tempColor = scanner.nextLine();//insert the number of the chosen colour
            if (Objects.equals(tempColor, "1") && !colorCPU.toUpperCase(Locale.ROOT).equals("BLACK")) {//if the number is 1 AND the colour is BLACK
                this.Color = "Black";//set the colour to Black
                break;//end loop
            } else if (Objects.equals(tempColor, "2") && !colorCPU.toUpperCase(Locale.ROOT).equals("RED")) {//if the number is 2 AND the colour is RED
                this.Color = "Red";//set the colour to Red
                break;//end loop
            } else if (Objects.equals(tempColor, "3") && !colorCPU.toUpperCase(Locale.ROOT).equals("BLUE")) {//if the number is 3 AND the colour is BLUE
                this.Color = "Blue";//set the colour to Blue
                break;//end loop
            } else if (Objects.equals(tempColor, "4") && !colorCPU.toUpperCase(Locale.ROOT).equals("ORANGE")) {//if the number is 4 AND the colour is ORANGE
                this.Color = "Orange";//set the colour to Orange
                break;//end loop
            } else if (Objects.equals(tempColor, "5") && !colorCPU.toUpperCase(Locale.ROOT).equals("GREEN")) {//if the number is 5 AND the colour is GREEN
                this.Color = "Green";//set the colour to Green
                break;//end loop
            } else {
                System.out.printf("This is not an option, re-choose your color by typing in a number " +
                        "(The color you chose for the CPU is not available to choose, don't choose %s)\n",colorCPU);//error message
            }
        }
    }
}

