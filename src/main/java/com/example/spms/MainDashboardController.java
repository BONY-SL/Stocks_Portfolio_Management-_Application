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
    private  static Label name;

    @FXML
    private  static Label Position;
    @FXML
    private Stage stage;

    @FXML
    private Scene Loginpage;
    @FXML
    Parent root;
    private Scene editProfile;


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

    public void setName_Type(String name,String tp){

        //System.out.println(name);
        //System.out.println(tp);

        try{
            this.name.setText(name);
            this.Position.setText(tp);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
}
