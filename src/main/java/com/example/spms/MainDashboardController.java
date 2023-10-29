package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashboardController {

    @FXML
    private Label name;

    @FXML
    private Label Position;

    @FXML
    private Stage stage;

    @FXML
    private Scene Loginpage;

    @FXML
    Parent root;

    public void loginButton(){

    }

    public void gotoLogin(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Loginpage=new Scene(root);
        stage.setScene(Loginpage);
    }
}
