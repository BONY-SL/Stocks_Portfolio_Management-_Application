package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AcountDashboardController {

    @FXML
    private AnchorPane All;

    @FXML
    private Button CrAcRe;

    @FXML
    private AnchorPane CreateAccRe;

    @FXML
    private Button CreateCusRe;

    @FXML
    private Button CreateSupRe;

    @FXML
    private AnchorPane CtCusRe;

    @FXML
    private AnchorPane CtSalRe;

    @FXML
    private AnchorPane CtSupRep;

    @FXML
    private Button ItemSalRe;

    @FXML
    private Button ItemSupRe;

    @FXML
    private AnchorPane ItmSupRe;

    @FXML
    private AnchorPane ManEmpSal;

    @FXML
    private Button ManEx;

    @FXML
    private Button ManIn;

    @FXML
    private Button ManageEmpSal;

    @FXML
    private AnchorPane ManageExpences;

    @FXML
    private AnchorPane ManageIncome;

    @FXML
    private Button UpdateSupRe;

    @FXML
    private AnchorPane UpdteSupDet;

    @FXML
    private Button usdadd;

    @FXML
    private TextField usdcNO;

    @FXML
    private TextField usdcm;

    @FXML
    private TextField usdcn;

    @FXML
    private Button usdreset;

    @FXML
    private Button usdsearch;

    @FXML
    private TextField usdsid;

    @FXML
    private Button usdupdate;

    @FXML
    public void ButtonClicked(ActionEvent event) {
        if (event.getSource() == CrAcRe) {
            CreateAccRe.setVisible(true);
            CtCusRe.setVisible(false);
            CtSupRep.setVisible(false);
            CtSalRe.setVisible(false);
            ItmSupRe.setVisible(false);
            UpdteSupDet.setVisible(false);
            ManageExpences.setVisible(false);
            ManageIncome.setVisible(false);
            ManEmpSal.setVisible(false);

        }


        {
            if (event.getSource() == CreateCusRe) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(true);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }


        }


        {
            if (event.getSource() == CreateSupRe) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(true);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }
        }

        {
            if (event.getSource() == ItemSalRe) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(true);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }

        }
        {
            if (event.getSource() == ItemSupRe) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(true);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }

        }
        {
            if (event.getSource() == ManageEmpSal) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(true);
            }

        }
        {
            if (event.getSource() == UpdateSupRe) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(true);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }
        }
        {
            if (event.getSource() == ManEx) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(true);
                ManageIncome.setVisible(false);
                ManEmpSal.setVisible(false);
            }
        }
        {
            if (event.getSource() == ManIn) {
                CreateAccRe.setVisible(false);
                CtCusRe.setVisible(false);
                CtSupRep.setVisible(false);
                CtSalRe.setVisible(false);
                ItmSupRe.setVisible(false);
                UpdteSupDet.setVisible(false);
                ManageExpences.setVisible(false);
                ManageIncome.setVisible(true);
                ManEmpSal.setVisible(false);
            }
        }

    }
}
