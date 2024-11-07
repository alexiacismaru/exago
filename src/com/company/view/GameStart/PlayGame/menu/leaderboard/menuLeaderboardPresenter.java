package com.company.view.GameStart.PlayGame.menu.leaderboard;

import com.company.Model.ModelName;
import com.company.view.GameStart.PlayGame.PlayGameView;
import com.company.view.GameStart.PlayGame.menu.menuPresenter;
import com.company.view.Leaderboard.LeaderboardView;
import com.company.view.exagoPresenter;
import com.company.view.exagoView;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Window;

public class menuLeaderboardPresenter {
    private final menuLeaderboardView view;
    private final ModelName modelName;

    public menuLeaderboardPresenter(menuLeaderboardView view, ModelName modelName) {
        this.view = view;
        this.modelName = modelName;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // Add event handlers (inner classes or
        // lambdas) to view controls.
        // In the event handlers: call model methods
        // and updateView().

        this.view.getExit().setOnAction(event -> {
            setMainWindow();
            updateView();
        });

        //TODO: Can this be made more streamlined?




    }

    private void updateView() {
        // fills the view with model data
    }

    public void addWindowEventHandlers() {
        Window window = view.getScene().getWindow();
        // Add event handlers to window
    }

    private void setMainWindow() {
        /*menuPresenter menuPresenter = new menuPresenter(this.view,modelName,new PlayGameView()) ;
        exagoPresenter exagoPresenter = new exagoPresenter(exagoView, modelName);
        view.getScene().setRoot(exagoView);
        exagoView.getScene().getWindow().setWidth(1000);
        exagoView.getScene().getWindow().setHeight(650);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        exagoView.getScene().getWindow().setX((screenBounds.getWidth() - 1000) / 2);
        exagoView.getScene().getWindow().setY((screenBounds.getHeight() - 650) / 2);*/
    }

}
