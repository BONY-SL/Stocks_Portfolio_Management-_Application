package com.example.spms.Tables;

public class viweTableModeSupplier {

    private String SupplierID;
    private String SupplierCompanyName;
    private String SupplierCompanyMail;
    private String SupplierContactNumber;

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
    }

    public void setSupplierCompanyName(String supplierCompanyName) {
        SupplierCompanyName = supplierCompanyName;
    }

    public void setSupplierCompanyMail(String supplierCompanyMail) {
        SupplierCompanyMail = supplierCompanyMail;
    }

    public void setSupplierContactNumber(String supplierContactNumber) {
        SupplierContactNumber = supplierContactNumber;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public String getSupplierCompanyName() {
        return SupplierCompanyName;
    }

    public String getSupplierCompanyMail() {
        return SupplierCompanyMail;
    }

    public String getSupplierContactNumber() {
        return SupplierContactNumber;
    }

    public viweTableModeSupplier(String supplierID, String supplierCompanyName, String supplierCompanyMail, String supplierContactNumber) {

        this.SupplierID = supplierID;
        this.SupplierCompanyName = supplierCompanyName;
        this.SupplierCompanyMail = supplierCompanyMail;
        this.SupplierContactNumber = supplierContactNumber;
    }
}
