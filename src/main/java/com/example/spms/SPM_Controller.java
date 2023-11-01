package com.example.spms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SPM_Controller {

    @FXML
    private AnchorPane addCustomer;
    @FXML
    private Button addC;

    @FXML
    public void gotoaddCustomer(ActionEvent event)throws IOException{

        if(event.getSource()==addC){
            addCustomer.setVisible(true);
        }
    }

}
