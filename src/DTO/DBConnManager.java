package DTO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DBConnManager {
    String sourceURL;
   
    //constructor 
    public DBConnManager()
    {
    try 
        {
        // Load JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        // Connection URL.
        sourceURL = new String("jdbc:mysql://127.0.0.1:3306/akro");
        }
    catch (ClassNotFoundException classNotFoundException) 
        {
    System.out.println(classNotFoundException + "-----------Unable to load database driver classes");
        }
    }
    
public Connection connect()
    {
    Connection dbConn = null;
        try 
        {
        dbConn = DriverManager.getConnection(sourceURL, "root", "");
        } 
        catch (SQLException sQLException) 
        {
        System.out.println(sQLException + "-----------DB connection failure");
        }
    return dbConn;
    }

public void con_close(Connection dbConn) {
    try 
    {
    dbConn.close();
    } 
    catch (SQLException sQLException) 
    {
    System.out.println(sQLException + "-----------DB connection closing failure");
    }
    
}

}