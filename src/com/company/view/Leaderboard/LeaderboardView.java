package com.company.view.Leaderboard;

import com.company.view.player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Date;


public class LeaderboardView extends GridPane {
    //setting up the columns
    TableColumn<player, String> colname = new TableColumn<>("NAME");

    TableColumn<player, Integer> colwins = new TableColumn<>("WINS");

    TableColumn<player, Integer> colloss = new TableColumn<>("LOSS");

    TableColumn<player, Date> coldate = new TableColumn<>("DATE");
    Stage windows;
    TableView<player> table;

    ///////////////////////////////////////////////////



    private Text title;
    private TableColumn column;
    private TableView row;

   /* private Label p1;
    private Label p2;
    private Label p3;
    private Label p4;
    private Label p5;*/
    private Button exit;

    public LeaderboardView() {
        initialiseNodes();
        layoutNodes();

    }

    private void initialiseNodes() {
        table = new TableView<>();
        /// to fill out the table
        table.setItems(getproduct());

        table.getColumns().addAll(colname, colwins, colloss, coldate);
        // create and configure controls
        // button = new Button("...");
        // label = new Label("...")
        title = new Text("");
        // TODO: these labels won't initialise if there's not 5 entries in the table ( ARRAYOUTOFBOUNDS )
        /*p1 = new Label();
        p2 = new Label();
        p3 = new Label();
        p4 = new Label();
        p5 = new Label();*/
        exit = new Button("Back");
    }

    private void layoutNodes() {
        // add/set … methods
        // Insets, padding, alignment, …
        colname.setMaxWidth(300);
        //to connect the data with the table
        colname.setCellValueFactory(new PropertyValueFactory<player, String>("name"));

        colwins.setMaxWidth(300);
        colwins.setCellValueFactory(new PropertyValueFactory<player, Integer>("Wins"));

        colloss.setMaxWidth(300);
        colloss.setCellValueFactory(new PropertyValueFactory<player, Integer>("loss"));

        coldate.setMaxWidth(300);
        coldate.setCellValueFactory(new PropertyValueFactory<player, Date>("date"));

        this.setPadding(new Insets(10));

        //for (int i = 0; i < numColumns; i++) {
        //    ColumnConstraints colConst = new ColumnConstraints();
        //    colConst.setPercentWidth(100.0 / numColumns);
        //    this.getColumnConstraints().add(colConst);
        //}


        //*for (int i = 0; i < numRows; i++) {
        //    RowConstraints rowConst = new RowConstraints();
          //  rowConst.setPercentHeight(100.0 / numRows);
            //this.getRowConstraints().add(rowConst);
        //}

        this.setHgap(8);
        this.setVgap(8);

        title.textAlignmentProperty();
        this.add(title, 1, 1, 3, 1);
        setHalignment(title, HPos.CENTER);
        title.setStyle("-fx-font-weight: BOLD;" +
                "-fx-font-size: 33;");

        addButton(exit, 1, 7, 3, 1);
        this.getChildren().add(table);
    }

    private void addButton(Button button, int i1, int i2, int i3, int i4) {
        this.add(button, i1, i2, i3, i4);
        button.setPrefHeight(25);
        button.setPrefWidth(200);
        button.setAlignment(Pos.CENTER);
        setHalignment(button, HPos.CENTER);
        button.setStyle("-fx-font-weight: BOLD");
    }


    private void addLabel(Label label, int i1) {
        this.add(label, 1, i1, 3, 1);
        label.setAlignment(Pos.CENTER);
        setHalignment(label, HPos.CENTER);
        label.setStyle("-fx-font-size: 17;");
    }

    // package-private Getters
    // for controls used by Presenter
    Button getExit() {
        return exit;
    }

    ///to get the data
    public ObservableList<player> getproduct() {
        ObservableList<player> player = FXCollections.observableArrayList();
        Date e = new Date();
        player.add(new player("iyas", 1,1, e  ));
        return player;
    }
}

