package com.example.spms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/every";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection;

    private static void RegisterMyConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("Connected to the database.");
    }

    public static Connection getConnection() {
        RegisterMyConnection();

        try {
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {

        DatabaseConnection my=new DatabaseConnection();
        my.getConnection();
    }
}
