package com.example.spms;

import com.example.spms.Validate.MailValidate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AcountDashboardController implements Initializable {

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
    private TextField usdid;

    @FXML
    private TextField usdid2;

    @FXML
    private TextField saleamount;

    @FXML
    private TextField saledate;

    @FXML
    private TextField saleid;

    @FXML
    private TextField cusid;

    @FXML
    private TextField salequantity;

    @FXML
    private Button salesresetbtn;
    @FXML
    private Button usdreset;

    @FXML
    private Button usdsearch;


    @FXML
    private Button supplyupdatebtn;
    @FXML
    private Button backid;


    @FXML
    private TextField itemid;

    @FXML
    private TextField supplyamount;

    @FXML
    private TextField supplydate;

    @FXML
    private TextField supplyid;

    @FXML
    private TextField supplyquantity;

    @FXML
    private Button supplyreset;
    @FXML
    private TextField incomedate;

    @FXML
    private TextField incomedescription;

    @FXML
    private TextField incomeamount;

    @FXML
    private TextField incomeid;

    @FXML
    private Button incomeresetbtn;

    private String SuppID;
    private String SuppID2;
    private String SuppComName;
    private String SuppComMail;
    private String SuppConNumber;

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

        {
            if (event.getSource() == backid) {
                CreateAccRe.setVisible(false);

            }
        }

    }

    @FXML
    public void reset(ActionEvent event) {

        usdid.setText(" ");
        usdid2.setText(" ");
        usdcn.setText(" ");
        usdcm.setText(" ");
        usdcNO.setText(" ");
    }


    @FXML
    public void search(ActionEvent event) {
        SuppID = usdid.getText();
        if (SuppID == " ") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please Select Customer ID");
            alert.showAndWait();
        } else {
            String getdata = "SELECT * FROM supplier where supplier_id=?";

            Connection conn = DatabaseConnection.getConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1, SuppID);

                ResultSet re = preparedStatement.executeQuery();

                if (re.next()) {
                    SuppID2 = re.getString(1);
                    SuppComName = re.getString(2);
                    SuppComMail = re.getString(3);
                    SuppConNumber = re.getString(4);

                    usdid2.setText(SuppID);
                    usdcn.setText(SuppComName);
                    usdcm.setText(SuppComMail);
                    usdcNO.setText(SuppConNumber);

                }
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void supplyreset(ActionEvent event) {
        itemid.setText(" ");
        supplyamount.setText("");
        supplyid.setText("");
        supplydate.setText("");
        supplyquantity.setText("");

    }

    @FXML
    void incomereset(ActionEvent event) {
        incomeid.setText(" ");
        incomedescription.setText(" ");
        incomedate.setText(" ");
        incomeamount.setText("");

    }

    @FXML
    void salesreset(ActionEvent event) {
        saleid.setText(" ");
        cusid.setText(" ");
        saledate.setText(" ");
        saleamount.setText(" ");
        salequantity.setText(" ");
    }

    @FXML
    public void supplydetailupdate(ActionEvent event) {
        try {
            SuppID=usdid.getText();
            SuppComName = usdcn.getText();
            SuppComMail = usdcm.getText();
            SuppConNumber = usdcNO.getText();

            Connection conn = DatabaseConnection.getConnection();

            String sqlupdate = "UPDATE supplier SET company_name=?,company_mail=?,contact_numer=? where supplier_id =?";

            PreparedStatement statment = conn.prepareStatement(sqlupdate);

            statment.setString(1, SuppComName);
            statment.setString(2, SuppComMail);
            statment.setString(3, SuppConNumber);
            statment.setString(4, SuppID);


            int rowsUpdated = statment.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){

        }
    }







