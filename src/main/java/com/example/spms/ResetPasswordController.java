package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResetPasswordController {

    @FXML
    private Stage stage;

    @FXML
    private Scene Loginpage;

    @FXML
    Parent root;

    public void gotoLogin(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Loginpage=new Scene(root);
        stage.setScene(Loginpage);
        stage.setX(200);
        stage.setY(100);
    }
}
