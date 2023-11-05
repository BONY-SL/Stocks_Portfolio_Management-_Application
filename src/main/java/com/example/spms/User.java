package com.example.spms;

public class User {

    private String Date;
    private String Description;
    private String Income;
    private String Expenses;
    private String Profit;

    public User(String date, String description, String income, String expenses, String profit) {
        Date = date;
        Description = description;
        Income = income;
        Expenses = expenses;
        Profit = profit;
    }

    public String getDate() {
        return Date;
    }

    public String getDescription() {
        return Description;
    }

    public String getIncome() {
        return Income;
    }

    public String getExpenses() {
        return Expenses;
    }

    public String getProfit() {
        return Profit;
    }
}
