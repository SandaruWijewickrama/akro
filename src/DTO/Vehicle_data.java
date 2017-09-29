/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nuwan
 */
public class Vehicle_data {
    private String vehicleNo;
    private String vehicleType;
    private String brandName;
    private String Insurace;
    
    
    private String account_id;
    private double balance;
    private double loan_amount;
    private String due_date;
    private double install_payment;
    private double paid_amount;
    private String status;

    public Vehicle_data(String vehicleNo, String vehicleType, String brandName, String Insurace) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.brandName = brandName;
        this.Insurace = Insurace;
    }

    public Vehicle_data() {
    }

    public Vehicle_data(String vehicleNo, String account_id, double balance, double loan_amount, String due_date, double install_payment, double paid_amount,String status) {
        this.vehicleNo = vehicleNo;
        this.account_id = account_id;
        this.balance = balance;
        this.loan_amount = loan_amount;
        this.due_date = due_date;
        this.install_payment = install_payment;
        this.paid_amount = paid_amount;
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public String getAccount_id() {
        return account_id;
    }

    public double getBalance() {
        return balance;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public String getDue_date() {
        return due_date;
    }

    public double getInstall_payment() {
        return install_payment;
    }

    public double getPaid_amount() {
        return paid_amount;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setInstall_payment(double install_payment) {
        this.install_payment = install_payment;
    }

    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }
    
    

    
    
    
    
    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getInsurace() {
        return Insurace;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setInsurace(String Insurace) {
        this.Insurace = Insurace;
    }
    
    
    
}
