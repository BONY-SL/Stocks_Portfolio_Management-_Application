package com.example.spms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class UserSessionSaved {

    private static String employee_id;
    private static String password;
    private static String employee_name;
    private static String email;
    private static String contact_number;
    private static String dob;
    private static String NIC;
    private static String emptype;

    private static UserSessionSaved instance;

    private UserSessionSaved(String empid, String pwd) {

        this.employee_id=empid;
        this.password=pwd;


        //System.out.println(employee_id);
        //System.out.println(password);
        setEmployeeDetails(empid);

    }

    public static UserSessionSaved getInstance(String empid,String pwd) {
        if(instance == null) {
            instance = new UserSessionSaved( empid, pwd);
        }
        return instance;
    }

    public static String getEmployee_id(){
        return employee_id;
    }

    public static String getEmployee_password(){
        return password;
    }

    public static String getEmployee_name(){
        return employee_name;
    }
    public static String getEmployee_email(){
        return email;
    }
    public static String getEmployee_contact_number(){
        return contact_number;
    }
    public static String getEmployee_dob(){
        return dob;
    }
    public static String getEmployee_NIC(){
        return NIC;
    }

    public static String getEmployee_emptype(){
        return emptype;
    }

    public static void cleanUserSession() {
        employee_id = null;
        password = null;
        instance = null;
    }

    public void setEmployeeDetails(String emp){

        Connection conn= DatabaseConnection.getConnection();
        String Db_user = "select * from employee";
        try {
            Statement statment1 = null;
            try {
                statment1 = conn.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ResultSet resalt1 = statment1.executeQuery(Db_user);
            while (resalt1.next()) {
                String u = resalt1.getString(1);
                String p = resalt1.getString(7);

                if(u.equals(employee_id) && p.equals(password)){

                    employee_name=resalt1.getString(2);
                    email=resalt1.getString(3);
                    contact_number=resalt1.getString(4);
                    emptype=resalt1.getString(5);
                    dob=resalt1.getString(6);
                    NIC=resalt1.getString(8);
                    break;
                }
            }
            //System.out.println(employee_id);
            //System.out.println(employee_name);
            //System.out.println(email);
            //System.out.println(contact_number);
            //System.out.println(emptype);
            //System.out.println(dob);
            //System.out.println(password);
            //System.out.println(NIC);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
