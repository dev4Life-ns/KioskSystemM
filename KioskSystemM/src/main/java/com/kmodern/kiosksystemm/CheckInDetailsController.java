package com.kmodern.kiosksystemm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static javafx.fxml.FXMLLoader.load;

public class CheckInDetailsController {
    @FXML
    public Label guest_nameLabel,check_inLabel,check_outLabel,
          noNightsLabel,noGuestLabel,roomTypeLabel,
          roomNumberLabel, cCardLabel,nightlyRateLabel;
    @FXML
   private CheckBox cbox;
    @FXML
   private JFXButton continueBtn;

    CheckinQrController qrController;

    @FXML private void guestViewedReservationDetails(ActionEvent ae){

               if(!cbox.isSelected()){
               continueBtn.isDisable();
                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                   alert.setHeaderText("Details Not Validated!");
                   alert.setContentText("Please verify your reservation details before" +
                                        "trying to continue!");
                   Optional<ButtonType> result = alert.showAndWait();
                   if (result.get() == ButtonType.OK);
           }else{
               continueBtn.setOnAction(event -> {
                   Parent rootParent;
                   Stage stage;
                   Scene scene;
                   try {
                       rootParent = load(getClass().getResource("checkin-summary.fxml"));
                   } catch (IOException e) {
                       throw new RuntimeException(e);
                   }
                   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                   scene = new Scene(rootParent);
                   stage.setScene(scene);
                   stage.show();

               } );
    }
    }


}
