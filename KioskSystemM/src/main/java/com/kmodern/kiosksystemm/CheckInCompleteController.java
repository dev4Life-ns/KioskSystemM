package com.kmodern.kiosksystemm;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class CheckInCompleteController {
   Parent rootParent;
   Scene scene;
   Stage stage;


 @FXML private void checkInComplete(ActionEvent ae) {
     try {
         rootParent = load(getClass().getResource("checkin-complete.fxml"));
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
     stage = (Stage) ((javafx.scene.Node) ae.getSource()).getScene().getWindow();
     scene = new Scene(rootParent);
     stage.setScene(scene);
     stage.show();
 }
}
