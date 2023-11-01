package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainDashboardController implements Initializable {

    @FXML
    private  Label name;

    @FXML
    private  Label Position;
    @FXML
    private Stage stage;

    @FXML
    private Scene Loginpage;
    @FXML
    Parent root;
    @FXML
    private Scene editProfile;

    @FXML
    private Button ManageEmployee;
    @FXML
    private Button ManageCustomer;
    @FXML
    private Button ManageSupplier;
    @FXML
    private Button ManageStock;
    @FXML
    private Button ManageFinancial;
    @FXML
    private Button ManageReport;

    public void gotoLogin(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Dou you want logout?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
            Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Loginpage=new Scene(root);
            stage.setScene(Loginpage);
            UserSessionSaved.cleanUserSession();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

    public void gotoEditProfile(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("editprofile.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        editProfile=new Scene(root);
        stage.setScene(editProfile);
        stage.setX(425);
        stage.setY(50);

        editprofilecontroller edit=new editprofilecontroller();
        edit.loadUserData();
    }

    /*public void setName_Type(){

        String Name=UserSessionSaved.getEmployee_name();
        String type=UserSessionSaved.getEmployee_emptype();

        System.out.println(Name);
        System.out.println(type);

        try{
            name=new Label();
            Position=new Label();
            name.setText(Name);
            Position.setText(type);

            System.out.println(name.getText());
            System.out.println(Position.getText());

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // This is the JavaFX initialize method that is called automatically when FXML components are loaded.
        // You should not call this manually.
    }

    public void customInitialization() {
        // Your custom initialization code goes here.
        String Name = UserSessionSaved.getEmployee_name();
        String type = UserSessionSaved.getEmployee_emptype();

        System.out.println(Name);
        System.out.println(type);

        try {
            name.setText(Name);
            Position.setText(type);

            System.out.println(name.getText());
            System.out.println(Position.getText());

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void gotoUserModule(ActionEvent event)throws IOException{

        String type=UserSessionSaved.getEmployee_emptype();

        if(type.equals("SPM")){
            ManageEmployee.setDisable(true);
            ManageStock.setDisable(true);
            ManageFinancial.setDisable(true);
            ManageReport.setDisable(true);
        }
    }
}
