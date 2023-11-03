package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SPM_Controller {

    private Stage stage;

    private Scene dashboard;

    public void backtoDashboard(ActionEvent event)throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        dashboard=new Scene(root);
        stage.setScene(dashboard);
        stage.setX(200);
        stage.setY(100);
    }

}
