package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController {

    @FXML
    private Stage stage;

    @FXML
    private Scene MainDashBoardSean;

    @FXML
    private Scene Resetpassword;
    @FXML
    Parent root;

    @FXML
    private TextField id;
    @FXML
    private PasswordField pwd;

    public void loginButton(){

    }

    public void gotoMainDashboard(ActionEvent event) throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        MainDashBoardSean=new Scene(root);
        stage.setScene(MainDashBoardSean);
    }

    public void clearText(){
        id.setText("");
        pwd.setText("");
    }

    public void gotoPasswordReset(ActionEvent event) throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("resetPassword.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Resetpassword=new Scene(root);
        stage.setScene(Resetpassword);
        stage.setX(450);
        stage.setY(150);
    }


}