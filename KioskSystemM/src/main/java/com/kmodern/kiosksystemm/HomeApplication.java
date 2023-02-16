package com.kmodern.kiosksystemm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeApplication extends Application {
    private static Stage primaryStage;
    private void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
  
    @Override
    public void start(Stage stage) throws IOException {
        setPrimaryStage(primaryStage);
        FXMLLoader fxmlLoader = new FXMLLoader(HomeApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 700);
        stage.setResizable(false);
        stage.setMinHeight(700);
        stage.setMinWidth(1080);
        stage.setMaxWidth(1080);
        stage.setMaxHeight(700);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}