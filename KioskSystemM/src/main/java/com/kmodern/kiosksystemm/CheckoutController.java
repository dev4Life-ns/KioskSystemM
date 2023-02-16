package com.kmodern.kiosksystemm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Hotelrooms;


import java.io.IOException;

public class CheckoutController {
       @FXML private TextField roomNumberInputTextField;

       private  boolean start = true;




     @FXML  void clearInputDisplay(){roomNumberInputTextField.setText("");}

      @FXML protected void onScreenKeyboard (ActionEvent ae){
           if (start) {
               roomNumberInputTextField.setText("");
               start = false;
           }

           String value = ((JFXButton) ae.getSource()).getText();
           roomNumberInputTextField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
               String newText = change.getControlNewText();
               if (newText.length() > 3) {
                   return null;
               } else {
                   return change;
               }
           }));
           roomNumberInputTextField.setText(roomNumberInputTextField.getText() + value);
       }
       

       //---------------code for checking guest out of system

       public void checkoutAction (ActionEvent ae) throws IOException {
           if ("".equals(roomNumberInputTextField.getText())) {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
               alert.setContentText("You must enter a room number to complete the check out process !");
               alert.setHeaderText("Invalid Input Error !");
               ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("images/wrong-pin.png"));
               alert.showAndWait();
           } else {

               int flag = -1;
               try {
                   flag = Hotelrooms.CheckOut(Integer.parseInt(roomNumberInputTextField.getText()));
               } catch (Exception e) {
                   System.out.println(e.getMessage());
                   Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                   alert.setHeaderText("Error, You Cannot Access This Room !");
                   alert.setContentText(e.getMessage());
                   alert.setTitle("Error");
                   alert.show();
                   return;
               }
               switch (flag) {
                   case 1: {
                       Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                       alert.setHeaderText("You Have Successfully Checked Out ");
                       alert.show();
                       new com.kmodern.kiosksystemm.HomeController().navigateToHomeView(ae);
                       break;
                   }
                   case 0: {
                       Alert alert = new Alert(Alert.AlertType.WARNING, null, ButtonType.OK);
                       alert.setHeaderText("Guest Already Checked Out Of Room !");
                       alert.setTitle("info");
                       alert.show();
                       break;
                   }
                   default: {
                       Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                       alert.setHeaderText("Invalid room  number.. ...");
                       alert.setContentText("Error , room: " + roomNumberInputTextField.getText() + " no not valid !");
                       alert.setTitle("Error");
                       alert.show();
                       break;
                   }
               }
           }
       }
   }



