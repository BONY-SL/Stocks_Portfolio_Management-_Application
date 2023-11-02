package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editprofilecontroller implements Initializable {
    private  String employee_id;

    private  String password;

    private  String employee_name;

    private  String email;

    private  String contact_number;

    private  String dob;

    private  String NIC;

    private  String emptype;

    @FXML
    private Stage stage;
    @FXML
    private Scene editProfile;
    @FXML
    private Scene dashboard;

    @FXML
    private Label EmployeeID;

    public void loadUserData(){

        employee_id=UserSessionSaved.getEmployee_id();
        EmployeeID.setText(employee_id);
        //System.out.println(EmployeeID.getText());
    }
    
    public void backtoDashboard(ActionEvent event)throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        dashboard=new Scene(root);
        stage.setScene(dashboard);
        stage.setX(200);
        stage.setY(100);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserData();
    }
}
