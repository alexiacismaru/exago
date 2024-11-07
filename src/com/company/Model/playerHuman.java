package com.company.Model;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class playerHuman extends participant {
    private final Scanner scanner = new Scanner(System.in);
    private String Color;

    @Override
    public String getColor() {
        return Color;
    }


    public void setColor(String colorCPU) {
        while (true) {
            System.out.println("choose a color: \n1) Black\n2) Red\n3) Blue\n4) Orange\n5) Green");
            String tempColor = scanner.nextLine();
            if (Objects.equals(tempColor, "1") && !colorCPU.toUpperCase(Locale.ROOT).equals("BLACK")) {
                this.Color = "Black";
                break;
            } else if (Objects.equals(tempColor, "2") && !colorCPU.toUpperCase(Locale.ROOT).equals("RED")) {
                this.Color = "Red";
                break;
            } else if (Objects.equals(tempColor, "3") && !colorCPU.toUpperCase(Locale.ROOT).equals("BLUE")) {
                this.Color = "Blue";
                break;
            } else if (Objects.equals(tempColor, "4") && !colorCPU.toUpperCase(Locale.ROOT).equals("ORANGE")) {
                this.Color = "Orange";
                break;
            } else if (Objects.equals(tempColor, "5") && !colorCPU.toUpperCase(Locale.ROOT).equals("GREEN")) {
                this.Color = "Green";
                break;
            } else {
                System.out.printf("This is not an option, re-choose your color by typing in a number " +
                        "(The color you chose for the CPU is not available to choose, don't choose %s)\n",colorCPU);
            }
        }
    }
}
