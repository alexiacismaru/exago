package com.company.view.GameStart.PlayGame;

import com.company.Model.gameSession;
import com.company.Model.hexagonTile;
import com.company.view.GameStart.PlayGame.menu.menuPresenter;
import com.company.view.GameStart.PlayGame.menu.menuView;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.util.Objects;

public class PlayGamePresenter {
    private final PlayGameView view;
    private final gameSession model;

    private hexagonTile[][] hexagonTiles;

    public PlayGamePresenter(PlayGameView view, gameSession model) {
        this.view = view;
        this.model = model;
        hexagonTiles = model.getHexagonTiles();
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // Add event handlers (inner classes or
        // lambdas) to view controls.
        // In the event handlers: call model methods
        // and updateView().
        view.getMenuButton().setOnAction(event -> {
            setSecondaryWindow();
            updateView();

        });



        for (int i = 0; i < view.getTilesPerRow(); i++) {
            for (int j = 0; j < view.getColumn(); j++) {
                int finalI = i;
                int finalJ = j;
                view.getPolygons()[i][j].setOnMouseClicked(event -> {
                    //System.out.println(view.getPolygons()[finalI][finalJ]);
                    model.playGame(view.getPolygonsToString(), finalI, finalJ);
                    this.setColor(finalI,finalJ);
                    if (model.getTurn() % 2 == 1) {
                        model.playGame(view.getPolygonsToString(), finalI, finalJ);
                        this.setColor(model.getTurnInstance().getX(),model.getTurnInstance().getY());
                    }
                    hexagonTiles = model.getHexagonTiles();

                    updateView();
                });
            }
        }

    }

    private void updateView() {
        // fills the view with model data
        //this.view.setCenter(model.getTileMap());
        // set up the visuals and a click listener for the tile
        view.FillAnchorPane();
        this.view.setCenter(view.getAnchorPane());
    }


    private void setSecondaryWindow() {
        menuView menuView = new menuView();
        menuPresenter menuPresenter = new menuPresenter(menuView, model, view);
        view.getScene().setRoot(menuView);
        menuView.getScene().getWindow().setWidth(1000);
        menuView.getScene().getWindow().setHeight(800);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        menuView.getScene().getWindow().setX((screenBounds.getWidth() - 1000) / 2);
        menuView.getScene().getWindow().setY((screenBounds.getHeight() - 650) / 2);
    }

    public void setColor(int x, int y) {
        // set up the visuals and a click listener for the tile
       // view.setStrokeWidth(2);
        //System.out.println(this.model.getTurn() + " this is turn in setColor");
        if (hexagonTiles[x][y].isFilled()) {
            //System.out.println("0101 " +hexagonTiles[x][y].getColor() + " 0101");
            if (Objects.equals(hexagonTiles[x][y].getColor(), "BLUE")) {
                    //------------------------------------------------------
                    //------------------------------------------------------
                hexagonTiles[x][y].setColor("BLUE");
                view.setPolygonsColor("BLUE",x,y);
                //System.out.println("0101 " + hexagonTile.getColor() + " 0101");
            } else {

                    //------------------------------------------------------
                    //------------------------------------------------------
                hexagonTiles[x][y].setColor("RED");
                view.setPolygonsColor("RED",x,y);
                //System.out.println("0101 " + hexagonTile.getColor() + " 0101");
            }
        } else {

            if (this.model.getTurn()%2 == 0 && this.model.getColorDescision() == 0) {
                    //------------------------------------------------------
                    //------------------------------------------------------
                hexagonTiles[x][y].setColor("BLUE");
                view.setPolygonsColor("BLUE",x,y);
                //System.out.println("0101 " + hexagonTile.getColor() + " 0101");
            } else if (this.model.getTurn()%2 == 1 && this.model.getColorDescision() == 1) {

                    //------------------------------------------------------
                    //------------------------------------------------------
                view.setPolygonsColor("RED",x,y);
                //System.out.println("0101 " + hexagonTile.getColor() + " 0101");
            }
        }
    }
}

