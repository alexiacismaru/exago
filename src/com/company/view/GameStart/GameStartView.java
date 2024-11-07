package com.company.view.GameStart;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GameStartView extends VBox {
    private ImageView image;
    private Label label;
    private TextArea textArea;
    private Button confirmButton;

    public GameStartView() {
        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        this.image = new ImageView("img.png");
        this.label = new Label("Before you start the game. Please enter your username below.");
        this.textArea = new TextArea();
        this.confirmButton = new Button("Confirm Username");

    }

    private void layoutNodes() {
        this.setPadding(new Insets(20));
        this.getChildren().addAll(image, label, textArea, confirmButton);
        this.setSpacing(60.0);
        label.setFont(new Font("Arial", 30));
        setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        textArea.setPrefHeight(20);
        textArea.setMaxWidth(300);

    }

    ImageView getImage() {
        return image;
    }

    Label getLabel() {
        return label;
    }

    TextArea getTextArea() {
        return textArea;
    }

    Button getConfirmButton() {
        return confirmButton;
    }
}
