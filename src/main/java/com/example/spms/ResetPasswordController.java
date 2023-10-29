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
import java.sql.*;

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

    @FXML
    private TextField newpassword;
    @FXML
    private TextField reEnterNewpassword;



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
                        userNIC=nic;
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

    public void submitButton(ActionEvent event)throws IOException{

        String getempid=userid.getText();
        String newpwd=newpassword.getText();
        String reEnternewpwd=reEnterNewpassword.getText();

        if(getempid.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("First Search the User ID");
            alert.showAndWait();
            
        }else if(newpwd.isEmpty() || reEnternewpwd.isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Enter New Password and Re Enter New Password");
            alert.showAndWait();

        } else if (newpwd.length()>8 || reEnternewpwd.length()>8) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Password Should Contain maximum 8 characters");
            alert.showAndWait();
            newpassword.setText("");
            reEnterNewpassword.setText("");

        } else if (!(newpwd.equals(reEnternewpwd))) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("New password and Re Enter Password are not matched");
            alert.showAndWait();
            newpassword.setText("");
            reEnterNewpassword.setText("");

        }else{
            //System.out.println(newpwd);
            //System.out.println(reEnternewpwd);

            Connection conn= DatabaseConnection.getConnection();
            String sqlupdate = "UPDATE employee SET password=?where employee_id =?";
            try{
                PreparedStatement statment= conn.prepareStatement(sqlupdate);
                statment.setString(1,newpwd);
                ((PreparedStatement) statment).setString(2,getempid);
                int rowsUpdated = statment.executeUpdate();
                if (rowsUpdated > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Look, an Information Dialog");
                    alert.setContentText("Update Successfully");

                    alert.showAndWait();
                    ResetPasswordController Return=new ResetPasswordController();
                    Return.gotoLogin(event);

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Update Not SuccessFully");
                    alert.showAndWait();
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}
