package com.example.spms.Tables;

public class viweTableModeCustomer {
    private String CustomerName;
    private String CustomerID;
    private String CustomerEmail;
    private String CustomerShopeName;
    private String CoustomerContactNumber;
    private String Customertype;
    private String CoustomerDOB;

    public viweTableModeCustomer(String customerId, String customerName, String customerEmail, String customerShopeName, String coustomerContactNumber, String customertype, String coustomerDOB) {


        this.CustomerID = customerId;
        this.CustomerName = customerName;
        this.CustomerEmail = customerEmail;
        this.CustomerShopeName = customerShopeName;
        this.CoustomerContactNumber = coustomerContactNumber;
        this.Customertype = customertype;
        this.CoustomerDOB = coustomerDOB;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public void setCustomerID(String customerId) {
        this.CustomerID = customerId;
    }

    public void setCustomerEmail(String customerEmail) {
        this.CustomerEmail = customerEmail;
    }

    public void setCustomerShopeName(String customerShopeName) {
        this.CustomerShopeName = customerShopeName;
    }

    public void setCoustomerContactNumber(String coustomerContactNumber) {
        this.CoustomerContactNumber = coustomerContactNumber;
    }

    public void setCustomertype(String customertype) {
        this.Customertype = customertype;
    }

    public void setCoustomerDOB(String coustomerDOB) {
        CoustomerDOB = coustomerDOB;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public String getCustomerShopeName() {
        return CustomerShopeName;
    }

    public String getCoustomerContactNumber() {
        return CoustomerContactNumber;
    }

    public String getCustomertype() {
        return Customertype;
    }

    public String getCoustomerDOB() {
        return CoustomerDOB;
    }
}
