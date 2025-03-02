package Exago;

import java.util.Objects;
import java.util.Scanner;

public class playerCPU extends participant {
    private final Scanner scanner = new Scanner(System.in);
    private String color;

    @Override
    public String getColor() {
        return this.color;
    }//getter

    public String setColor() {//setter
        while (true) {//while the next statements are true
            System.out.println("choose a color for the CPU: \n1) Black\n2) Red\n3) Blue\n4)Orange\n5)Green");//make the user choose a colour to play with
            String tempColor = scanner.nextLine();//insert the number of the chosen colour
            if (Objects.equals(tempColor, "1")) {//if they chose the number 1
                this.color = "Black";//set the colour to black
                break;//end loop
            } else if (Objects.equals(tempColor, "2")) {//if they chose the number 2
                this.color = "Red";//set the colour to red
                break;//end loop
            } else if (Objects.equals(tempColor, "3")) {//if they chose the number 3
                this.color = "Blue";//set the colour to blue
                break;//end loop
            } else if (Objects.equals(tempColor, "4")) {//if they chose the number 4
                this.color = "Orange";//set the colour to orange
                break;//end loop
            } else if (Objects.equals(tempColor, "5")) {//if they chose the number 5
                this.color = "Green";//set the colour to green
                break;//end loop
            } else {
                System.out.println("This is not an option, re-choose your color by typing in a number");//if the user chose any other number, display an error message
            }
        }
        return this.getColor();//otherwise, return the colour the user chose
    }
}

