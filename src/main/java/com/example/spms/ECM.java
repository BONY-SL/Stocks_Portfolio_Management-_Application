package com.example.spms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ECM extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ECM.class.getResource("ECM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 680);
        stage.setTitle("Every Company Manager");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    }

