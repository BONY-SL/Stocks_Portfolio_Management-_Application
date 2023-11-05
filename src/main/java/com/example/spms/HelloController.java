package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    private String userid=null;
    private String userpwd=null;

    public void loginButton(ActionEvent event) throws IOException {

        userid=id.getText();
        userpwd=pwd.getText();

        //System.out.println(userid);
        //System.out.println(userpwd);

        if(userid.isEmpty() || userpwd.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Enter User Id and Password");
            alert.showAndWait();

        }else {
            Connection conn= DatabaseConnection.getConnection();
            int count1 = 0;
            String Db_user = "select * from employee";

            String coutemployee = "SELECT COUNT(*) FROM employee";
            try {

                Statement stmtcount = conn.createStatement();
                ResultSet resaltcount = stmtcount.executeQuery(coutemployee);

                while (resaltcount.next()) {
                    count1 = resaltcount.getInt(1);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                int count2 = 0;
                Statement statment1 = conn.createStatement();
                ResultSet resalt1 = statment1.executeQuery(Db_user);
                while (resalt1.next()) {
                    String username = resalt1.getString(1);
                    String password = resalt1.getString(7);
                    if (userid.equals(username) && userpwd.equals(password)) {
                        UserSessionSaved.getInstance(username,password);
                        break;
                    }
                    ++count2;
                }
                if (count1 == count2) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Invalid Employee ID or Password");
                    alert.showAndWait();
                    clearText();
                }else{
                    HelloController h=new HelloController();
                    h.gotoMainDashboard(event);

                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }

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