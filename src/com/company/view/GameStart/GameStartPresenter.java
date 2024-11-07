package com.company.view.GameStart;


import com.company.Model.ModelName;
import com.company.Model.gameSession;
import com.company.view.GameStart.PlayGame.PlayGamePresenter;
import com.company.view.GameStart.PlayGame.PlayGameView;

public class GameStartPresenter {
    private final GameStartView view;
    private final gameSession modelName;

    public GameStartPresenter(GameStartView view, gameSession modelName) {
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
        this.view.getConfirmButton().setOnAction(event -> {
            //setting username works!!!
            modelName.initialiseGame(view.getTextArea().getText());
            this.setGameWindow();
            updateView();
        });

    }

    private void updateView() {
        // fills the view with model data
    }


    private void setGameWindow() {

        PlayGameView playGameView = new PlayGameView();
        PlayGamePresenter PlayGamePresenter = new PlayGamePresenter(playGameView, modelName);
        view.getScene().setRoot(playGameView);
        playGameView.getScene().getWindow().setHeight(800);
        playGameView.getScene().getWindow().setWidth(1000);
    }
}

