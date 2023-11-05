package com.example.spms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AcountDashboard extends Application
{
    @Override
    public void start(Stage Stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AcountDashboard.class.getResource("AcountDashboardUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage.setTitle("Accountant");
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
