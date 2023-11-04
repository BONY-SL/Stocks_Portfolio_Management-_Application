package com.example.spms;

import com.example.spms.Tables.viweTableModeCustomer;
import com.example.spms.Tables.viweTableModeSupplier;
import com.example.spms.Validate.MailValidate;
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
import java.util.Optional;
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

    @FXML
    private TableColumn<viweTableModeSupplier,String> CompanyNameColumn;
    @FXML
    private TableColumn<viweTableModeSupplier,String> SupplierContactNumerColumn;
    @FXML
    private TableColumn<viweTableModeSupplier,String> SupplierIDColumn;
    @FXML
    private TableColumn<viweTableModeSupplier,String> SupplierMailCloumn;
    @FXML
    private TableView<viweTableModeSupplier> viweSupplierTable;

    ObservableList<viweTableModeSupplier> listview2= FXCollections.observableArrayList();

    ObservableList<viweTableModeCustomer> listview= FXCollections.observableArrayList();

    @FXML
    private TextField inputIDSupplier;

    @FXML
    private TextField inputCompanyNameSupplier;

    @FXML
    private TextField inputEmailSupplier;

    @FXML
    private TextField inputContactNumberSuplier;

    private String SupplierID;
    private String SupplierCompanyName;
    private String SupplierCompanyMail;
    private String SupplierContactNumber;

    @FXML
    private ComboBox<String> CustomerIDCombobox;

    @FXML
    private ComboBox<String> SupplierIDComboBox;

    @FXML
    private ComboBox<String> CustomerIDComboboxUpdate;

    @FXML
    private TextField getUpdateCustomerMail;

    @FXML
    private TextField getUpdateCustomerName;

    @FXML
    private TextField getUpdateCustomerShopeName;

    @FXML
    private TextField getUpdateCustomerType;

    @FXML
    private TextField getUpdateCustomerNumber;

    private String UpdateCus_Name;
    private String UpdateCus_Mail;
    private String UpdateCus_shop;
    private String UpdateCus_contact;
    private String UpdateCus_type;

    private String updatetoIDCustomer;

    @FXML
    void getCustomerData(ActionEvent event) {

        updatetoIDCustomer=CustomerIDComboboxUpdate.getValue();

        if(updatetoIDCustomer==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Please Select Customer ID");
            alert.showAndWait();
        }else {
            String getdata="select name,email,shopname,contact_number,type from customer where customer_id=?";

            Connection conn= DatabaseConnection.getConnection();


            try {
                PreparedStatement preparedStatement = conn.prepareStatement(getdata);
                preparedStatement.setString(1,updatetoIDCustomer);

                ResultSet re = preparedStatement.executeQuery();

                if(re.next()){
                    UpdateCus_Name=re.getString(1);
                    UpdateCus_Mail=re.getString(2);
                    UpdateCus_shop=re.getString(3);
                    UpdateCus_contact=re.getString(4);
                    UpdateCus_type=re.getString(5);

                    getUpdateCustomerName.setText(UpdateCus_Name);
                    getUpdateCustomerMail.setText(UpdateCus_Mail);
                    getUpdateCustomerShopeName.setText(UpdateCus_shop);
                    getUpdateCustomerNumber.setText(UpdateCus_contact);
                    getUpdateCustomerType.setText(UpdateCus_type);
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
    void updateCustomerData(ActionEvent event) {

        if(updatetoIDCustomer==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Please Search Customer Details");
            alert.showAndWait();
        }else {

            UpdateCus_Name=getUpdateCustomerName.getText();
            UpdateCus_Mail=getUpdateCustomerMail.getText();
            UpdateCus_shop=getUpdateCustomerShopeName.getText();
            UpdateCus_contact=getUpdateCustomerNumber.getText();
            UpdateCus_type=getUpdateCustomerType.getText();

            if(UpdateCus_Name.isEmpty() || UpdateCus_Mail.isEmpty() || UpdateCus_shop.isEmpty() || UpdateCus_contact.isEmpty() || UpdateCus_type.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Fill all Fields");
                alert.showAndWait();

            } else if (!MailValidate.isValidEmail(UpdateCus_Mail)) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Please Enter Valid Mail Address");
                alert.showAndWait();
            }else {
                //System.out.println(UpdateCus_Mail);

                Connection conn= DatabaseConnection.getConnection();

                String sqlupdate = "UPDATE customer SET name=?,email=?,shopname=?,contact_number=?,type=? where customer_id=?";
                try{
                    PreparedStatement statment= conn.prepareStatement(sqlupdate);

                    statment.setString(1,UpdateCus_Name);
                    statment.setString(2,UpdateCus_Mail);
                    statment.setString(3,UpdateCus_shop);
                    statment.setString(4,UpdateCus_contact);
                    statment.setString(5,UpdateCus_type);
                    statment.setString(6,updatetoIDCustomer);

                    int rowsUpdated = statment.executeUpdate();
                    if (rowsUpdated > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Look, an Information Dialog");
                        alert.setContentText("Update Successfully");
                        alert.showAndWait();
                        
                        getUpdateCustomerName.setText("");
                        getUpdateCustomerMail.setText("");
                        getUpdateCustomerShopeName.setText("");
                        getUpdateCustomerNumber.setText("");
                        getUpdateCustomerType.setText("");
                        CustomerIDComboboxUpdate.setValue(null);

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Update Not SuccessFully");
                        alert.showAndWait();
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    @FXML
    void setUpdateCustomerDataClear(ActionEvent event) {

        getUpdateCustomerName.setText("");
        getUpdateCustomerMail.setText("");
        getUpdateCustomerShopeName.setText("");
        getUpdateCustomerNumber.setText("");
        getUpdateCustomerType.setText("");
        CustomerIDComboboxUpdate.setValue(null);
    }


    public void getSupplierID_forComboBox(ActionEvent event)throws IOException{
        try {
            Connection conn= DatabaseConnection.getConnection();
            ObservableList<String> listacombo= FXCollections.observableArrayList();

            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT supplier_id  FROM supplier;");
            while (rs.next()) {
                //get string from db,whichever way
                listacombo.add(
                        rs.getString("supplier_id")
                );

                SupplierIDComboBox.setItems(listacombo);
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
    }

    //delete supplier in system
    @FXML
    void deleteSuppllierDetails(ActionEvent event) {

        String getid=SupplierIDComboBox.getValue();
        //System.out.println(getid);
        if(getid==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Select Supplier ID");
            alert.showAndWait();
        }else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Dou you want Delete "+getid+" "+"Supplier");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //System.out.println(getid);
                Connection conn= DatabaseConnection.getConnection();
                String deleterecod="Delete from supplier where supplier_id=?";
                try {
                    int rowsDeleted=0;
                    PreparedStatement stmt = conn.prepareStatement(deleterecod);
                    stmt.setString(1, getid);
                    rowsDeleted = stmt.executeUpdate();
                    if(rowsDeleted==1){

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Information Dialog");
                        alert2.setHeaderText(null);
                        alert2.setContentText("Delete Successfully");
                        alert2.showAndWait();

                    }else if(rowsDeleted==0){
                        Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                        alert3.setTitle("Information Dialog");
                        alert3.setHeaderText(null);
                        alert3.setContentText("Delete Not Successfully");

                        alert3.showAndWait();
                    }
                } catch (SQLException ex) {

                    Alert alert4 = new Alert(Alert.AlertType.WARNING);
                    alert4.setTitle("Warning Dialog");
                    alert4.setHeaderText("Look, a Warning Dialog");
                    alert4.setContentText(ex.getMessage());
                    alert4.showAndWait();

                    throw new RuntimeException(ex);
                }finally {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }

    }

    //delete Customer Details
    public void deletecustomerDetails(ActionEvent event)throws IOException{

        String getid=CustomerIDCombobox.getValue();
        //System.out.println(getid);

        if(getid==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Select Customer ID");
            alert.showAndWait();
        }else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Dou you want Delete "+getid+" "+"Customer");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                //System.out.println(getid);
                Connection conn= DatabaseConnection.getConnection();
                String deleterecod="Delete from customer where customer_id=?";
                try {
                    int rowsDeleted=0;
                    PreparedStatement stmt = conn.prepareStatement(deleterecod);
                    stmt.setString(1, getid);
                    rowsDeleted = stmt.executeUpdate();
                    if(rowsDeleted==1){

                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                        alert2.setTitle("Information Dialog");
                        alert2.setHeaderText(null);
                        alert2.setContentText("Delete Successfully");
                        alert2.showAndWait();

                    }else if(rowsDeleted==0){
                        Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
                        alert3.setTitle("Information Dialog");
                        alert3.setHeaderText(null);
                        alert3.setContentText("Delete Not Successfully");

                        alert3.showAndWait();
                    }
                } catch (SQLException ex) {

                    Alert alert4 = new Alert(Alert.AlertType.WARNING);
                    alert4.setTitle("Warning Dialog");
                    alert4.setHeaderText("Look, a Warning Dialog");
                    alert4.setContentText(ex.getMessage());
                    alert4.showAndWait();

                    throw new RuntimeException(ex);
                }finally {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }


    //get customer id to Customer Combo box
    public void getCustomerID_forComboBox(ActionEvent event)throws IOException{
        try {
            Connection conn= DatabaseConnection.getConnection();
            ObservableList<String> listacombo= FXCollections.observableArrayList();

            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT customer_id  FROM customer;");
            while (rs.next()) {
                //get string from db,whichever way
                listacombo.add(
                        rs.getString("customer_id")
                );

                CustomerIDCombobox.setItems(listacombo);
                CustomerIDComboboxUpdate.setItems(listacombo);
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
    }

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

    public void viweSupplierTable(ActionEvent event) throws SQLException,IOException {


        SupplierIDColumn.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
        CompanyNameColumn.setCellValueFactory(new PropertyValueFactory<>("supplierCompanyName"));
        SupplierMailCloumn.setCellValueFactory(new PropertyValueFactory<>("supplierCompanyMail"));
        SupplierContactNumerColumn.setCellValueFactory(new PropertyValueFactory<>("supplierContactNumber"));


        Connection conn= DatabaseConnection.getConnection();
        String view="select * from supplier";

        try{
            Statement sm=conn.createStatement();
            ResultSet r=sm.executeQuery(view);

            while(r.next()){
                listview2.add(new viweTableModeSupplier(
                        r.getString("supplier_id"),
                        r.getString("company_name"),
                        r.getString("company_mail"),
                        r.getString("contact_numer")));
            }
            viweSupplierTable.setItems(listview2);
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
    public void addNewSupplier(ActionEvent event)throws IOException{

        SupplierID=inputIDSupplier.getText();
        SupplierCompanyName=inputCompanyNameSupplier.getText();
        SupplierCompanyMail=inputEmailSupplier.getText();
        SupplierContactNumber=inputContactNumberSuplier.getText();


        if(SupplierID.equals("") || SupplierCompanyName.equals("") || SupplierCompanyMail.equals("") || SupplierContactNumber.equals("")){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Should Fill the all fields");
            alert.showAndWait();
        }else {
            Connection conn1= DatabaseConnection.getConnection();

            String insert="INSERT INTO supplier(supplier_id,company_name,company_mail,contact_numer) " +
                    "VALUES" +
                    "(?,?,?,?)";

            try (PreparedStatement insertst=conn1.prepareStatement(insert)){
                insertst.setString(1,SupplierID);
                insertst.setString(2,SupplierCompanyName);
                insertst.setString(3,SupplierCompanyMail);
                insertst.setString(4,SupplierContactNumber);

                int rowinsert=insertst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Row Insert Successfully");
                alert.showAndWait();

                inputIDSupplier.setText("");
                inputCompanyNameSupplier.setText("");
                inputEmailSupplier.setText("");
                inputContactNumberSuplier.setText("");

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

    @FXML
    void ClearAddDetailsSupplier(ActionEvent event) {

        inputIDSupplier.setText("");
        inputCompanyNameSupplier.setText("");
        inputEmailSupplier.setText("");
        inputContactNumberSuplier.setText("");
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
        CustomerInvoiceModule.setVisible(false);
    }
    public void setDeleteCustomerAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(true);

        getCustomerID_forComboBox(event);

        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setUpdateCustomerAnchorPane(ActionEvent event)throws IOException{

        addCustomerModule.setVisible(false);
        imageancher.setVisible(false);
        DeleteCustomerModule.setVisible(false);
        DeleteSupplierModule.setVisible(false);
        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(true);

        getCustomerID_forComboBox(event);

        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
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

        getSupplierID_forComboBox(event);

        SupplierInvoiceModule.setVisible(false);
        UpdateCustomerModule.setVisible(false);
        ViewCustomerDetailsModule.setVisible(false);
        addSupplierModule.setVisible(false);
        updateSupplierDetailsModule.setVisible(false);
        viewSupplierDetailsModule.setVisible(false);
        CustomerInvoiceModule.setVisible(false);
    }
    public void setUpdateSupplierAnchorPane(ActionEvent event) throws IOException, SQLException {

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
    public void setviewSupplierAnchorPane(ActionEvent event) throws IOException, SQLException {

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

        listview2.clear();
        viweSupplierTable(event);

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
