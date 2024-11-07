package com.company.view.GameStart.PlayGame.menu.Rules;

import com.company.Model.ModelName;
import com.company.Model.gameSession;
import com.company.view.Rules.RuleScreenView;
import com.company.view.exagoPresenter;
import com.company.view.exagoView;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;


public class menuRuleScreenPresenter {
    private final menuRuleScreenView view;
    private final gameSession modelName;


    public menuRuleScreenPresenter(menuRuleScreenView view, gameSession modelName) {
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

        this.view.getBacktoMenu().setOnAction(event -> {
            setMainWindow();
            updateView();
        });

    }

    private void updateView() {
        // fills the view with model data
    }


    private void setMainWindow() {
        exagoView exagoView = new exagoView();
        exagoPresenter exagoPresenter = new exagoPresenter(exagoView, modelName);
        view.getScene().setRoot(exagoView);
        exagoView.getScene().getWindow().setWidth(1000);
        exagoView.getScene().getWindow().setHeight(650);
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        exagoView.getScene().getWindow().setX((screenBounds.getWidth() - 1000) / 2);
        exagoView.getScene().getWindow().setY((screenBounds.getHeight() - 650) / 2);
    }
}
