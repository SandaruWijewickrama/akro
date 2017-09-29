/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.logging.Logger;

/**
 *
 * @author Nuwan
 */
public class Other_expenses_data {
    
    private String type;
    private double amount;
    private String date;
    private double price;
    private int id;

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Other_expenses_data(String type, double amount, String date, double price,int id) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.price = price;
        this.id=id;
    }

    public Other_expenses_data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
   
    
    
    
    
    
}
