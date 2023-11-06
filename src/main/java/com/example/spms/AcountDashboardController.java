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
import javafx.scene.control.Alert.AlertType;

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
    private TextField CusID;
    @FXML
    private  TextField CusName;
     @FXML
     private TextField CusEmail;
      @FXML
      private  TextField CusContact;
      @FXML
      private TextField ItemId;
      @FXML
      private TextField Quantity;
      @FXML
      private TextField ReturnQuantity;


    @FXML
    private TextField supid;

    @FXML
    private TextField supitemid;

    @FXML
    private TextField supmail;

    @FXML
    private TextField supname;

    @FXML
    private TextField supqunt;

    @FXML
    private TextField supretuenqunt;

    @FXML
    private Button supview;

    @FXML
    private TextField salereportid;
    @FXML
    private TextField salecusit;
    @FXML
    private TextField saleitemname;
    @FXML
    private TextField salequnt;
    @FXML
    private TextField salereturnquantity;


    @FXML
    private  TextField supplyreid;
    @FXML
    private TextField suppresupid;
    @FXML
    private TextField supreitemname;
    @FXML
    private TextField supretitmqunt;
    @FXML
    private TextField supreretunqunt;





    public void showAlert(String msg){
        Alert alert=new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();

    }
    public void SupplyReset(){
        usdid.setText(" ");
        usdid2.setText(" ");
        usdcn.setText(" ");
        usdcm.setText(" ");
        usdcNO.setText(" ");
    }
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
        if (SuppID.isEmpty()) {
            showAlert("Please Enter Supplier ID");
        }

         else {
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
            showAlert("Update Successfully");
            SupplyReset();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    public void customerclear(ActionEvent event)
    {
        CusID.setText("");
        CusName.setText(" ");
        CusEmail.setText("");
        CusContact.setText(" ");
        ItemId.setText(" ");
        Quantity.setText(" ");
        ReturnQuantity.setText(" ");

    }

    private String customerID;
    private String customername;
    private String customermail;
    private String customerno;
    private String itemidno;
    private String takequantity;
    private String returnquantity;

    @FXML
    public void viewcustomer(ActionEvent event) {
        customerID = CusID.getText();
        itemidno=ItemId.getText();
        if (customerID.isEmpty() ||itemidno.isEmpty() ) {
            showAlert("Please Enter customer ID and Item ID");
        }

        else {
            String getdata = "SELECT customer.name, customer.email, customer.contact_number,  item_sale.countity, sales_return.countity FROM customer JOIN item_sale ON customer.customer_id = item_sale.customer_id  JOIN sales_return ON customer.customer_id = sales_return.customer_id WHERE customer.customer_id = ? && sales_return.item_id=? ";

            Connection conn = DatabaseConnection.getConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1, customerID);
                preparedStatement.setString(2, itemidno);

                ResultSet re = preparedStatement.executeQuery();

                if (re.next()) {
                    customername = re.getString(1);
                    customermail = re.getString(2);
                    customerno = re.getString(3);
                    takequantity = re.getString(4);
                    returnquantity = re.getString(5);

                    CusName.setText(customername);
                    CusEmail.setText(customermail);
                    CusContact.setText(customerno);
                    Quantity.setText(takequantity);
                    ReturnQuantity.setText(returnquantity);

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

    private String suppid;
    private String supplyname;
    private String supplymail;
    private String supplyitem;
    private String supplytakequantity;
    private String supplyreturnquantity;
    @FXML
    public void viewsupply(ActionEvent event) {
        suppid = supid.getText();
        supplyitem=supitemid.getText();

        if (suppid.isEmpty() || supplyitem.isEmpty()) {
            showAlert("Please Enter Supplier ID and item ID");
        }

        else {
            String getdata = "SELECT supplier.company_name, supplier.company_mail, item_supply.countity, purchase_return.countity FROM supplier JOIN item_supply ON supplier.supplier_id=item_supply.supplier_id JOIN purchase_return ON supplier.supplier_id=purchase_return.supplier_id WHERE supplier.supplier_id=? && item_supply.item_id=?";

            Connection conn = DatabaseConnection.getConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1, suppid);
                preparedStatement.setString(2, supplyitem);


                ResultSet re = preparedStatement.executeQuery();

                if (re.next()) {
                    supplyname = re.getString(1);
                    supplymail = re.getString(2);
                    supplytakequantity = re.getString(3);
                    supplyreturnquantity = re.getString(4);

                    supname.setText(supplyname);
                    supmail.setText(supplymail);
                    supqunt.setText(supplytakequantity);
                    supretuenqunt.setText(supplyreturnquantity);

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
    void supplyreportreset(ActionEvent event)
    {
        supid.setText("");
        supname.setText("");
        supmail.setText("");
        supitemid.setText(" ");
        supqunt.setText("");
        supretuenqunt.setText("");
    }

    private String saleitemID;
    private String salecustomerID;
    private String saleitemName;
    private String saleitemquantity;
    private String saleitemreturnquantity;
    @FXML
    void viewsales(ActionEvent event)
    {
        saleitemID = salereportid.getText();
        salecustomerID=salecusit.getText();

        if (saleitemID.isEmpty() || salecustomerID.isEmpty()) {
            showAlert("Please Enter Supplier ID and item ID");
        }

        else {
            String getdata = "SELECT item.name, item_sale.countity, sales_return.countity FROM item JOIN item_sale ON item.item_id=item_sale.item_id JOIN sales_return ON item.item_id=sales_return.item_id WHERE item.item_id =? && sales_return.customer_id= ?";

            Connection conn = DatabaseConnection.getConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1,saleitemID );
                preparedStatement.setString(2, salecustomerID);


                ResultSet re = preparedStatement.executeQuery();

                if (re.next()) {
                    saleitemName = re.getString(1);
                    saleitemquantity = re.getString(2);
                    saleitemreturnquantity = re.getString(3);

                    saleitemname.setText(saleitemName);
                    salequnt.setText(saleitemquantity);
                    salereturnquantity.setText(saleitemreturnquantity);

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
    void salesreportreset(ActionEvent event)
    {
        salereportid.setText(" ");
        salecusit.setText("");
        saleitemname.setText(" ");
        salequnt.setText(" " );
        salereturnquantity.setText(" ");

    }

    private String supplyreprtitemid;
    private String supplyreportsupplyid;
    private String supplyreportitemname;
    private String supplyreportitemtakequantity;
    private String supplyreportreturnquantity;

    @FXML
    void viewsupplyreport(ActionEvent event)
    {
        supplyreprtitemid = supplyreid.getText();
        supplyreportsupplyid=suppresupid.getText();

        if (supplyreprtitemid.isEmpty() || supplyreportsupplyid.isEmpty()) {
            showAlert("Please Enter Supplier ID and item ID");
        }

        else {
            String getdata = "SELECT item.name, item_supply.countity,purchase_return.countity FROM item JOIN item_supply ON item.item_id=item_supply.item_id JOIN purchase_return ON item.item_id=purchase_return.item_id WHERE item.item_id = ? && purchase_return.supplier_id= ?";

            Connection conn = DatabaseConnection.getConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1,supplyreprtitemid );
                preparedStatement.setString(2, supplyreportsupplyid);


                ResultSet re = preparedStatement.executeQuery();

                if (re.next()) {
                    supplyreportitemname = re.getString(1);
                    supplyreportitemtakequantity = re.getString(2);
                    supplyreportreturnquantity = re.getString(3);

                    supreitemname.setText(supplyreportitemname);
                    supretitmqunt.setText(supplyreportitemtakequantity);
                    supreretunqunt.setText(supplyreportreturnquantity);

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
    void resetsupplyreport(ActionEvent event)
    {
        supplyreid.setText(" ");
        suppresupid.setText("");
        supreitemname.setText(" ");
        supretitmqunt.setText(" " );
        supreretunqunt.setText(" ");

    }
    @Override
        public void initialize (URL url, ResourceBundle resourceBundle){

        }
    }







