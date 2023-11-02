package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
