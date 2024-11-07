package com.company.view.GameStart.PlayGame.menu;

import com.company.Model.ModelName;
import com.company.Model.gameSession;
import com.company.view.GameStart.GameStartPresenter;
import com.company.view.GameStart.GameStartView;
import com.company.view.GameStart.PlayGame.PlayGameView;
import com.company.view.Leaderboard.LeaderboardPresenter;
import com.company.view.Leaderboard.LeaderboardView;
import com.company.view.Rules.RuleScreenPresenter;
import com.company.view.Rules.RuleScreenView;
import com.company.view.exagoView;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class menuPresenter {
    private final menuView view;
    private final gameSession modelName;
    private final PlayGameView playGameView;
   // private final Quarto model;

    public menuPresenter(menuView view, gameSession modelName, PlayGameView playGameView) {
        this.view = view;
        this.modelName = modelName;
        this.playGameView = playGameView;
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


        this.view.getLeaderboard().setOnAction(event -> {
            //model.getLeaderboard();
            setLeaderboard();
            updateView();
        });

        this.view.getRules().setOnAction(event -> {
            setRulesView();
            updateView();
        });


    }

    private void updateView() {
// fills the view with model data

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

    menuView getmenuView(){
        return view;
    }

}
