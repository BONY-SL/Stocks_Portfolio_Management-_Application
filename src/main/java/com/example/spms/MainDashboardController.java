package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }
}
