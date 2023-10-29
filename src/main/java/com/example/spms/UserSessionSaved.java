package com.example.spms;

public final class UserSessionSaved {

    private static String employee_id;
    private static String password;
    private static String employee_name;
    private static String email;
    private static String contact_number;
    private static String dob;
    private static String NIC;

    private static UserSessionSaved instance;

    UserSessionSaved(String empid, String pwd) {

        this.employee_id=empid;
        this.password=pwd;
        System.out.println(employee_id);
        System.out.println(password);

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

    public static void cleanUserSession() {
        employee_id = null;
        password = null;
        instance = null;
    }

}
