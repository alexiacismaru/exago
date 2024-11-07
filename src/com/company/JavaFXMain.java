package com.company;

import com.company.Model.ModelName;
import com.company.Model.gameSession;
import com.company.view.exagoPresenter;
import com.company.view.exagoView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class JavaFXMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        exagoView view = new exagoView();
        gameSession modelName = new gameSession();
        exagoPresenter presenter = new exagoPresenter(view, modelName);
        stage.setScene(new Scene(view));
        stage.setWidth(1000);
        stage.setHeight(650);
        // stage.setTitle("com.company.EXAGO");
        Image icon = new Image("/img.png");
        stage.getIcons().add(icon);
        stage.show();

    }
}
