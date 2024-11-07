package com.company.view;

import com.company.Model.ModelName;
import com.company.Model.gameSession;
import com.company.view.GameStart.GameStartPresenter;
import com.company.view.GameStart.GameStartView;
import com.company.view.Leaderboard.LeaderboardPresenter;
import com.company.view.Leaderboard.LeaderboardView;
import com.company.view.Rules.RuleScreenPresenter;
import com.company.view.Rules.RuleScreenView;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class exagoPresenter {
    private final exagoView view;
    private final gameSession modelName;
   // private final Quarto model;

    public exagoPresenter(exagoView view, gameSession modelName) {
        this.view = view;
        this.modelName = modelName;
        addEventHandlers();
        updateView();
    }

   /* public void addWindowEventHandlers() {
        // Add event handlers to window
        view.getScene().getWindow().setOnCloseRequest(this::closingAlert);
    }*/

    private void addEventHandlers() {
        // Adds event handlers (inner classes or lambdas)
        // to view controls
        // Event handlers: call model methods and
        // update the view.

        this.view.getPlay().setOnAction(event -> {
            setPlayView();
            updateView();
        });

        this.view.getLeaderboard().setOnAction(event -> {
            //model.getLeaderboard();
            setLeaderboard();
            updateView();
        });

        this.view.getRules().setOnAction(event -> {
            setRulesView();
            updateView();
        });

        this.view.getExit().setOnAction(event -> {
            closingAlert(event);
            updateView();
        });

    }

    private void updateView() {
// fills the view with model data

    }
    private void setPlayView() {
        GameStartView gameStartView = new GameStartView();
        GameStartPresenter gameStartPresenter = new GameStartPresenter(gameStartView, modelName);
        view.getScene().setRoot(gameStartView);
        gameStartView.getScene().getWindow().setHeight(625);
        gameStartView.getScene().getWindow().setWidth(1000);
    }

    private void setRulesView() {
        RuleScreenView ruleScreenView = new RuleScreenView();
        RuleScreenPresenter ruleScreenPresenter = new RuleScreenPresenter(ruleScreenView, modelName);
        view.getScene().setRoot(ruleScreenView);
        ruleScreenView.getScene().getWindow().setHeight(625);
        ruleScreenView.getScene().getWindow().setWidth(1000);
    }

    private void setLeaderboard() {
        LeaderboardView leaderboardView = new LeaderboardView();
        LeaderboardPresenter leaderboardPresenter = new LeaderboardPresenter(leaderboardView, modelName);
        view.getScene().setRoot(leaderboardView);
        leaderboardView.getScene().getWindow();
    }


    private void closingAlert(Event event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("You are about to quit the game!");
        alert.setContentText("Are you sure you want to quit the game!");
        alert.setTitle("Closing alert!");
        alert.getButtonTypes().clear();
        ButtonType no = new ButtonType("NO");
        ButtonType yes = new ButtonType("YES");
        alert.getButtonTypes().addAll(yes, no);
        alert.showAndWait();
        if (alert.getResult() == null || alert.getResult().equals(no)) {
            event.consume();
        } else {
            Platform.exit();
        }
    }
}
