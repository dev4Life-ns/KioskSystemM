package com.kmodern.kiosksystemm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import model.Hotelrooms;
import model.Reservations;

public class CheckInSummaryController {
    Reservations reservations;


   @FXML  private Label infoHeaderLabel, info1Label, info2Label, info3Label, info4Label,info5Label;
   @FXML private Label roomChargeTotalLabel,nightly_rateLabel,taxLabel,depositLabel,cCardLabel,
          termslabel;
    CheckinQrController qrController;
    CheckInSummaryController controller;
    FXMLLoader loader = new FXMLLoader();
        //hibernate data extraction
    @FXML private void displaySummaryDetails(Reservations reservation){
       roomChargeTotalLabel.setText(String.valueOf(reservations.getTotalRoomCharge()));
       nightly_rateLabel.setText (String.valueOf(reservations.getNightlyRate()));
       cCardLabel.setText(String.valueOf(reservations.getCreditCard()));
       taxLabel.setText("35%");
       depositLabel.setText("$600.00");
    }


            public CheckInSummaryController CheckInSummaryController(){

            controller = loader.getController();
            controller.infoHeaderLabel.setText("Things To Know");
            controller.info1Label.setText("By clicking authorize stay you agree to hotel" +
                    "terms and conditions");
            controller.info2Label.setText("A hold for the amount of your stay will be" +
                    "placed on payment method upon check in completion");

             controller. info3Label.setText("guest services is available if you require additional help");
             controller.info4Label.setText("For security purposes kiosk cannot change your payment method");
             controller.info5Label.setText("Have questions about stay details please head over to guest services");
             return controller;
        }
    private void Terms(){
        controller.termslabel.setText("By pressing authorize you digitally accept all hotels" +
                "terms and conditions. After room inspections security deposits are" +
                "refunded to original payment method within 48 hours after check out." +
                " If rom sustains any damages or missing items those fees will" +
                "be deducted from original payment method on file. Guest services" +
                "is unable to handle any discrepancies regarding all or partial" +
                " deduction of our security deposit");
    }


    public void setInfo1Label(Label info1Label) {
        this.info1Label = info1Label;
    }
}
