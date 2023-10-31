package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class editprofilecontroller {
    @FXML
    private  String employee_id;
    @FXML
    private  String password;
    @FXML
    private  String employee_name;
    @FXML
    private  String email;
    @FXML
    private  String contact_number;
    @FXML
    private  String dob;
    @FXML
    private  String NIC;
    @FXML
    private  String emptype;
    private Stage stage;
    private Scene editProfile;
    private Scene dashboard;

    public void loadUserData(){

    }
    
    public void backtoDashboard(ActionEvent event)throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        dashboard=new Scene(root);
        stage.setScene(dashboard);
        stage.setX(200);
        stage.setY(100);
    }
}
