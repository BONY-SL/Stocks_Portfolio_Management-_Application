package com.example.spms;

import com.example.spms.Tables.viweTableModeCustomer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SPM_Controller implements Initializable {

    private Stage stage;

    private Scene dashboard;

    @FXML
    private MenuItem AddCustomer;

    @FXML
    private MenuItem AddSupplier;

    @FXML
    private AnchorPane CustomerInvoiceModule;

    @FXML
    private MenuItem DeleteCustomer;

    @FXML
    private AnchorPane DeleteCustomerModule;

    @FXML
    private MenuItem DeleteSupplier;

    @FXML
    private AnchorPane DeleteSupplierModule;

    @FXML
    private MenuItem ManageCustomerInvoice;

    @FXML
    private MenuItem ManageSupplierInvoice;

    @FXML
    private AnchorPane SupplierInvoiceModule;

    @FXML
    private MenuItem UpdateCustomerDetails;

    @FXML
    private AnchorPane UpdateCustomerModule;

    @FXML
    private MenuItem UpdateSupplierDetails;

    @FXML
    private MenuItem ViewCustomerDetails;

    @FXML
    private AnchorPane ViewCustomerDetailsModule;

    @FXML
    private MenuItem ViewSupplierDetails;

    @FXML
    private AnchorPane addCustomerModule;

    @FXML
    private AnchorPane addSupplierModule;

    @FXML
    private AnchorPane updateSupplierDetailsModule;

    @FXML
    private AnchorPane viewSupplierDetailsModule;

    @FXML
    private MenuButton menubutton;

    @FXML
    private AnchorPane imageancher;

    @FXML
    private TextField inputContactNumber;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputID;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputShopName;

    @FXML
    private TextField inputdob;

    @FXML
    private TextField InputType;

    private String CustomerName;
    private String CustomerID;
    private String CustomerEmail;
    private String CustomerShopeName;
    private String CoustomerContactNumber;
    private String Customertype;
    private String CoustomerDOB;

    @FXML
    private TableColumn<viweTableModeCustomer,String> CustomerContactColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> CustomerMailColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> CustomerNameColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> CustomerTypeColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> CustomerdobColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> ShopNameColumn;
    @FXML
    private TableColumn<viweTableModeCustomer,String> customerIDColumn;
    @FXML
    private TableView<viweTableModeCustomer> viweCustomerTable;

    ObservableList<viweTableModeCustomer> listview= FXCollections.observableArrayList();

    public void viweCustomerTable(ActionEvent event) throws SQLException,IOException {


        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("CustomerID"));
        CustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        CustomerMailColumn.setCellValueFactory(new PropertyValueFactory<>("customerEmail"));
        CustomerContactColumn.setCellValueFactory(new PropertyValueFactory<>("coustomerContactNumber"));
        ShopNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerShopeName"));
        CustomerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("customertype"));
        CustomerdobColumn.setCellValueFactory(new PropertyValueFactory<>("coustomerDOB"));



        Connection conn= DatabaseConnection.getConnection();
        String view="select * from customer";

        try{
            Statement sm=conn.createStatement();
            ResultSet r=sm.executeQuery(view);

            while(r.next()){
                listview.add(new viweTableModeCustomer(
                        r.getString("customer_id"),
                        r.getString("name"),
                        r.getString("email"),
                        r.getString("shopname"),
                        r.getString("contact_number"),
                        r.getString("type"),
                        r.getString("date_of_birthday")));
            }
            viweCustomerTable.setItems(listview);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            conn.close();
        }
    }


    //add Customer to system
    public void addNewCustomer(ActionEvent event)throws IOException{

        CustomerName=inputName.getText();
        CustomerID=inputID.getText();
        CustomerEmail=inputEmail.getText();
        CustomerShopeName=inputShopName.getText();
        CoustomerContactNumber=inputContactNumber.getText();
        Customertype=InputType.getText();
        CoustomerDOB=inputdob.getText();

        if(CustomerName.equals("") || CustomerID.equals("") || CustomerEmail.equals("") || CustomerShopeName.equals("") || CoustomerContactNumber.equals("") || Customertype.equals("") || CoustomerDOB.equals("")){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Should Fill the all fields");
            alert.showAndWait();
        }else {
            Connection conn1= DatabaseConnection.getConnection();

            String insert="INSERT INTO customer(customer_id,name,email,shopname,contact_number,type,date_of_birthday) " +
                    "VALUES" +
                    "(?,?,?,?,?,?,?)";

            try (PreparedStatement insertst=conn1.prepareStatement(insert)){
                insertst.setString(1,CustomerID);
                insertst.setString(2,CustomerName);
                insertst.setString(3,CustomerEmail);
                insertst.setString(4,CustomerShopeName);
                insertst.setString(5,CoustomerContactNumber);
                insertst.setString(6,Customertype);
                insertst.setString(7,CoustomerDOB);

                int rowinsert=insertst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Row Insert Successfully");
                alert.showAndWait();

                inputContactNumber.setText("");
                inputEmail.setText("");
                inputID.setText("");
                inputName.setText("");
                inputShopName.setText("");
                inputdob.setText("");
                InputType.setText("");

            }catch (SQLException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
                throw new RuntimeException(ex);

            } finally {
                try {
                    conn1.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

    }

    //add Supplier to system
    public void addNewCSupplier(ActionEvent event)throws IOException{

        CustomerName=inputName.getText();
        CustomerID=inputID.getText();
        CustomerEmail=inputEmail.getText();
        CustomerShopeName=inputShopName.getText();
        CoustomerContactNumber=inputContactNumber.getText();
        Customertype=InputType.getText();
        CoustomerDOB=inputdob.getText();

        if(CustomerName.equals("") || CustomerID.equals("") || CustomerEmail.equals("") || CustomerShopeName.equals("") || CoustomerContactNumber.equals("") || Customertype.equals("") || CoustomerDOB.equals("")){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Should Fill the all fields");
            alert.showAndWait();
        }else {
            Connection conn1= DatabaseConnection.getConnection();

            String insert="INSERT INTO customer(customer_id,name,email,shopname,contact_number,type,date_of_birthday) " +
                    "VALUES" +
                    "(?,?,?,?,?,?,?)";

            try (PreparedStatement insertst=conn1.prepareStatement(insert)){
                insertst.setString(1,CustomerID);
                insertst.setString(2,CustomerName);
                insertst.setString(3,CustomerEmail);
                insertst.setString(4,CustomerShopeName);
                insertst.setString(5,CoustomerContactNumber);
                insertst.setString(6,Customertype);
                insertst.setString(7,CoustomerDOB);

                int rowinsert=insertst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Row Insert Successfully");
                alert.showAndWait();

                inputContactNumber.setText("");
                inputEmail.setText("");
                inputID.setText("");
                inputName.setText("");
                inputShopName.setText("");
                inputdob.setText("");
                InputType.setText("");

            }catch (SQLException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText(ex.getMessage());

                alert.showAndWait();
                throw new RuntimeException(ex);

            } finally {
                try {
                    conn1.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

    }


    public void ClearAddDetails(ActionEvent event)throws IOException{

        inputContactNumber.setText("");
        inputEmail.setText("");
        inputID.setText("");
        inputName.setText("");
        inputShopName.setText("");
        inputdob.setText("");
        InputType.setText("");

    }


    public void backtoDashboard(ActionEvent event)throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        dashboard=new Scene(root);
        stage.setScene(dashboard);
        stage.setX(200);
        stage.setY(100);
    }


    public void setAddCustomerAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(true);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
    }
    public void setDeleteCustomerAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(true);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
    }
    public void setUpdateCustomerAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(true);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
    }
    public void setviewCustomerAnchorPane(ActionEvent event) throws IOException, SQLException {

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(true);

        listview.clear();

        viweCustomerTable(event);

        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
    }
    public void setAddSupplierAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(true);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setDeleteSupplierAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(true);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setUpdateSupplierAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(true);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setviewSupplierAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(true);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setCustomerInvoiceAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(true);
    }
    public void setSupplierInvoiceAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(true);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }

    public void closeModule(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(true);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        


    }
}
