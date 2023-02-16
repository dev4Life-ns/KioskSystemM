package com.kmodern.kiosksystemm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent rootPane;

    /*@FXML
    public void navigateToCheckInView(ActionEvent ae) throws IOException {
        Parent rootPane = FXMLLoader.load(getClass().getResource("com.kmodern.kiosksystemm/checkin-qr-viewfxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(rootPane);
        stage.show();
    }*/

    @FXML void navigateToCheckInView(ActionEvent ae) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("com.kmodern.kiosksystemm/checkin-qr-viewfxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navigateToCheckoutView(ActionEvent ae) throws IOException {
        Parent checkoutRoot;
        Stage outStage;
        Scene outScene;
        checkoutRoot = load(getClass().getResource("checkout-view.fxml"));
        outStage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        outScene = new Scene(checkoutRoot);
        outStage.setResizable(false);
        outStage.setMinWidth(1080);
        outStage.setMinHeight(700);
        outStage.setMaxWidth(1080);
        outStage.setMaxHeight(700);
        outStage.setScene(outScene);
        outStage.show();
    }

    public void navigateToHomeView(ActionEvent ae) throws IOException {
        Parent rootPane = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        stage = (Stage) ((Node) ae.getSource()).getScene().getWindow();
        scene = new Scene(rootPane);
        stage.show();

    }
}