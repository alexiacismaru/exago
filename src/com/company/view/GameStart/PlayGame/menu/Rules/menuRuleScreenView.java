package com.company.view.GameStart.PlayGame.menu.Rules;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class menuRuleScreenView extends BorderPane {
    private Label label;
    private Button BacktoMenu;

    public menuRuleScreenView(){
        initialiseNudes();
        layoutNodes();
    }
    private void initialiseNudes(){
        this.label= new Label("\tThe main objective of the game is for the  players to align 6 \n\tof their tiles in a straight line." +
                "Each player can only place 1 \n\ttiles per move. New tiles must connect to at least one of\n\tthe tiles on the board.");
        this.BacktoMenu = new Button("Back to Menu");
    }
    private void layoutNodes(){

        this.setCenter(label);
        this.setBottom(BacktoMenu);
        BorderPane.setAlignment(BacktoMenu, Pos.BOTTOM_RIGHT);
        BorderPane.setMargin(BacktoMenu,new Insets(30.0));
        label.setFont(new Font("Arial", 30));
        this.setPadding(new Insets(10));


    }

     Button getBacktoMenu() {
        return BacktoMenu;
    }
}
