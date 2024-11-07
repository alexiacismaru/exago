package com.company.view.GameStart.PlayGame.menu;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class menuView extends GridPane{
    // private Node attributes (controls)
    private final int numColums = 6;
    private final int numRows = 8;

    private ImageView title;
    private Button play;
    private Button leaderboard;
    private Button load;
    private Button exit;
    private Button rules;

    public menuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        // create and configure controls
        // button = new Button("...")
        // label = new Label("...")
        leaderboard = new Button("Leaderboard");
        load = new Button("LOAD");
        title = new ImageView("/img.png");
        rules = new Button("RULES");
    }

    private void layoutNodes() {
        // add/set … methodes
        // Insets, padding, alignment, …

        this.setPadding(new Insets(10));

        for (int i = 0; i < numColums; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numColums);
            this.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            this.getRowConstraints().add(rowConst);
        }

        this.setGridLinesVisible(false);
        this.setHgap(6);
        this.setVgap(6);

        ImageView title = this.title;
        //this.title.setImage(Image.loadImage((title)));
        this.add(this.title, 1, 1, 3, 1);
        setHalignment(this.title, HPos.CENTER);
        this.title.setStyle("-fx-font-weight: BOLD;" +
                "-fx-font-size: 45;");
        addButton(leaderboard, 1, 4, 3, 1);
        addButton(load, 1, 5, 3, 1);
        addButton(rules, 1, 6, 3, 1);

    }

    private void addButton(Button button, int i1, int i2, int i3, int i4) {
        this.add(button, i1, i2, i3, i4);
        button.setPrefHeight(25);
        button.setPrefWidth(200);
        button.setAlignment(Pos.CENTER);
        setHalignment(button, HPos.CENTER);
        button.setStyle("-fx-font-weight: BOLD");
    }

    // package-private Getters
    // for controls used by Presenter
    ImageView getTitle() {
        return title;
    }

    Button getLeaderboard() { return leaderboard; }

    Button getLoad() {
        return load;
    }

    Button getRules(){return rules; }

}
