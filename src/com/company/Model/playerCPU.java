package com.company.Model;

import java.util.Objects;
import java.util.Scanner;

public class playerCPU extends participant {
    private final Scanner scanner = new Scanner(System.in);
    private String color;

    @Override
    public String getColor() {
        return this.color;
    }

    public String setColor() {
        while (true) {
            System.out.println("choose a color for the CPU: \n1) Black\n2) Red\n3) Blue\n4)Orange\n5)Green");
            String tempColor = scanner.nextLine();
            if (Objects.equals(tempColor, "1")) {
                this.color = "Black";
                break;
            } else if (Objects.equals(tempColor, "2")) {
                this.color = "Red";
                break;
            } else if (Objects.equals(tempColor, "3")) {
                this.color = "Blue";
                break;
            } else if (Objects.equals(tempColor, "4")) {
                this.color = "Orange";
                break;
            } else if (Objects.equals(tempColor, "5")) {
                this.color = "Green";
                break;
            } else {
                System.out.println("This is not an option, re-choose your color by typing in a number");
            }
        }
        return this.getColor();
    }
}
