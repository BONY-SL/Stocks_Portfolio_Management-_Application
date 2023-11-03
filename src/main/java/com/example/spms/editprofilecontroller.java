package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class editprofilecontroller implements Initializable {
    private  String employee_id;

    private  String password;

    private  String employee_name;

    private  String email;

    private  String contact_number;

    private  String dob;

    private  String NIC;

    private  String emptype;



    @FXML
    private Stage stage;
    @FXML
    private Scene editProfile;
    @FXML
    private Scene dashboard;

    @FXML
    private Label BOD;

    @FXML
    private TextField Contact;

    @FXML
    private PasswordField CurrentPassword;

    @FXML
    private TextField Email;

    @FXML
    private Label EmployeeID;

    @FXML
    private Label NICnumber;

    @FXML
    private TextField Name;

    @FXML
    private PasswordField NewPassword;

    @FXML
    private PasswordField ReEnterNewPassword;

    @FXML
    private Label Type;

    @FXML
    private CheckBox showPasswordCheckBox1;

    @FXML
    private CheckBox showPasswordCheckBox2;

    @FXML
    private CheckBox showPasswordCheckBox3;

    @FXML
    private TextField show1;

    @FXML
    private TextField show2;

    @FXML
    private TextField show3;


    //this method use edit profile details
    public void UpdateProfileDetails(ActionEvent event)throws IOException{

        String Newpwd=NewPassword.getText();
        String ReNewpwd=ReEnterNewPassword.getText();

        if(Newpwd.isEmpty() && ReNewpwd.isEmpty()){

            UserSessionSaved.setNewpassword(CurrentPassword.getText());
            UserSessionSaved.setEmployee_name(Name.getText());
            UserSessionSaved.setEmail(Email.getText());
            UserSessionSaved.setContactNumber(Contact.getText());

            employee_name=UserSessionSaved.getEmployee_name();
            email=UserSessionSaved.getEmployee_email();
            contact_number=UserSessionSaved.getEmployee_contact_number();
            password=UserSessionSaved.getEmployee_password();

            Connection conn= DatabaseConnection.getConnection();

            String sqlupdate = "UPDATE employee SET name=?,email=?,contact_number=?,password=? where employee_id =?";
            try{
                PreparedStatement statment= conn.prepareStatement(sqlupdate);

                statment.setString(1,employee_name);
                statment.setString(2,email);
                statment.setString(3,contact_number);
                statment.setString(4,password);
                statment.setString(5,employee_id);

                int rowsUpdated = statment.executeUpdate();
                if (rowsUpdated > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText("Look, an Information Dialog");
                    alert.setContentText("Update Successfully");
                    alert.showAndWait();

                    backtoDashboard(event);

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
        }else{
            if(Newpwd.isEmpty() || ReNewpwd.isEmpty()){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Enter New Password and Re Enter New Password");
                alert.showAndWait();
                NewPassword.setText("");
                ReEnterNewPassword.setText("");
                show2.setText("");
                show3.setText("");

            } else if (Newpwd.length()>8 || ReNewpwd.length()>8) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Password Should Contain maximum 8 characters");
                alert.showAndWait();
                NewPassword.setText("");
                ReEnterNewPassword.setText("");
                show2.setText("");
                show3.setText("");

            } else if (!(Newpwd.equals(ReNewpwd))) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("New password and Re Enter Password are not matched");
                alert.showAndWait();
                NewPassword.setText("");
                ReEnterNewPassword.setText("");
                show2.setText("");
                show3.setText("");

            }else {
                UserSessionSaved.setEmployee_name(Name.getText());
                UserSessionSaved.setEmail(Email.getText());
                UserSessionSaved.setContactNumber(Contact.getText());
                UserSessionSaved.setNewpassword(ReEnterNewPassword.getText());

                employee_name=UserSessionSaved.getEmployee_name();
                email=UserSessionSaved.getEmployee_email();
                contact_number=UserSessionSaved.getEmployee_contact_number();
                password=UserSessionSaved.getEmployee_password();

                Connection conn= DatabaseConnection.getConnection();

                String sqlupdate = "UPDATE employee SET name=?,email=?,contact_number=?,password=? where employee_id =?";
                try{
                    PreparedStatement statment= conn.prepareStatement(sqlupdate);

                    statment.setString(1,employee_name);
                    statment.setString(2,email);
                    statment.setString(3,contact_number);
                    statment.setString(4,password);
                    statment.setString(5,employee_id);

                    int rowsUpdated = statment.executeUpdate();
                    if (rowsUpdated > 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Look, an Information Dialog");
                        alert.setContentText("Update Successfully");
                        alert.showAndWait();

                        backtoDashboard(event);

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

    public void MouseEvent(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Channot Change Current Password");
        alert.showAndWait();
    }

    public void loadUserData(){

        employee_id=UserSessionSaved.getEmployee_id();
        EmployeeID.setText(employee_id);

        employee_name=UserSessionSaved.getEmployee_name();
        Name.setText(employee_name);

        email=UserSessionSaved.getEmployee_email();
        Email.setText(email);

        contact_number=UserSessionSaved.getEmployee_contact_number();
        Contact.setText(contact_number);

        emptype=UserSessionSaved.getEmployee_emptype();
        Type.setText(emptype);

        dob=UserSessionSaved.getEmployee_dob();
        BOD.setText(dob);

        NIC=UserSessionSaved.getEmployee_NIC();
        NICnumber.setText(NIC);

        password=UserSessionSaved.getEmployee_password();
        CurrentPassword.setText(password);

    }
    
    public void backtoDashboard(ActionEvent event)throws IOException{

        Parent root= FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        dashboard=new Scene(root);
        stage.setScene(dashboard);
        stage.setX(200);
        stage.setY(100);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadUserData();
    }


    //chlick the check box show the password
    public void showCurrentPassword(ActionEvent event)throws IOException{

        if(showPasswordCheckBox1.isSelected()){
            show1.setText(CurrentPassword.getText());
            show1.setVisible(true);
            CurrentPassword.setVisible(false);
            return;
        }else{
            CurrentPassword.setText(show1.getText());
            CurrentPassword.setVisible(true);
            show1.setVisible(false);
        }
    }
    public void showNewPassword(ActionEvent event)throws IOException{

        if(showPasswordCheckBox2.isSelected()){
            show2.setText(NewPassword.getText());
            show2.setVisible(true);
            NewPassword.setVisible(false);
            return;
        }else{
            NewPassword.setText(show2.getText());
            NewPassword.setVisible(true);
            show2.setVisible(false);
        }

    }
    public void showReEnterNewPassword(ActionEvent event)throws IOException{

        if(showPasswordCheckBox3.isSelected()){
            show3.setText(ReEnterNewPassword.getText());
            show3.setVisible(true);
            ReEnterNewPassword.setVisible(false);
            return;
        }else{
            ReEnterNewPassword.setText(show3.getText());
            ReEnterNewPassword.setVisible(true);
            show3.setVisible(false);
        }

    }

}
