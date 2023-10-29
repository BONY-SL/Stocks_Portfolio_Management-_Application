package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetPasswordController {

    @FXML
    private Stage stage;

    @FXML
    private Scene Loginpage;

    @FXML
    Parent root;

    @FXML
    private TextField NIC;

    @FXML
    private Label userid;
    private String userNIC=null;

    public void gotoLogin(ActionEvent event) throws IOException {

        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Loginpage=new Scene(root);
        stage.setScene(Loginpage);
        stage.setX(200);
        stage.setY(100);
    }

    public void searchUserID(ActionEvent event)throws IOException{

        userNIC=NIC.getText();
        //System.out.println(userNIC);


        if(userNIC.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Enter User NIC Number");
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
                    String nic = resalt1.getString(8);

                    if (userNIC.equals(nic)) {
                        String empid = resalt1.getString(1);
                        userid.setText(empid);
                        break;
                    }
                    ++count2;
                }
                if (count1 == count2) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Invalid NIC Number");
                    alert.showAndWait();
                    NIC.setText("");
                }else{
                    //System.out.println(userNIC);
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


}
