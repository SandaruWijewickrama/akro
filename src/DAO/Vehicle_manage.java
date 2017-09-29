/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DBConnManager;
import DTO.Vehicle_data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author Nuwan
 */
public class Vehicle_manage {
    
    public DBConnManager connection=new DBConnManager();
    boolean val=false;
    
    public boolean Insert_vehicle(Vehicle_data v1)
    {
        Connection c=connection.connect();
        
        String query="INSERT INTO vehicle VALUES ('"+v1.getVehicleNo()+"','"+v1.getVehicleType()+"','"+v1.getBrandName()+"','"+v1.getInsurace()+"');";
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            val =true;
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        finally
        {
            connection.con_close(c);
            return val;
        }
    
    }
    
    public boolean delete_vehicle(String vehicle_no)
    {
        Connection c=connection.connect();
        String query="DELETE FROM vehicle WHERE vehicle_no='"+vehicle_no+"'";
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            val=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return val;
        }
    }
    
    public Vehicle_data search_vehicle(String no)
    {
       ArrayList vehicle=null;
       
       String query="SELECT * FROM vehicle WHERE vehicle_no='"+no+"'";
       Connection c=connection.connect();
        Vehicle_data v1=new Vehicle_data();
       try
       {
           Statement st=c.createStatement();
           ResultSet rs=st.executeQuery(query);
           
          
           
           while(rs.next())
           {
               v1.setVehicleNo(rs.getString("vehicle_no"));
               v1.setVehicleType(rs.getString("type"));
               v1.setBrandName(rs.getString("brand_name"));
               v1.setInsurace(rs.getString("insurance_expiration_info"));
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
           connection.con_close(c);
           return v1;
       }
    }
    
    public boolean update_vehicle(Vehicle_data d1)
    {
        Connection c=connection.connect();
        String query="UPDATE vehicle SET type='"+d1.getVehicleType()+"',brand_name='"+d1.getBrandName()+"',insurance_expiration_info='"+d1.getInsurace()+"' WHERE vehicle_no='"+d1.getVehicleNo()+"'";
        
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            val=true;
        }
        
        catch(Exception e)
        {
           e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return val;
        }
    }
    
    public boolean Insert_vehicle_loan(Vehicle_data v2)
    {
        Connection c=connection.connect();
        String query="INSERT INTO `vehicle loan` VALUES('"+v2.getAccount_id()+"','"+v2.getBalance()+"','"+v2.getLoan_amount()+"','"+v2.getDue_date()+"','"+v2.getInstall_payment()+"','"+v2.getVehicleNo()+"','"+v2.getPaid_amount()+"','"+v2.getStatus()+"');";
        
        
        try
        {
        Statement st=c.createStatement();
        st.executeUpdate(query);
        val=true;
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        finally
        {
            connection.con_close(c);
            return val;
        }
    }
    
    public boolean delete_vehicle_loan(String id,String date)
    {
        Connection c=connection.connect();
        String query="DELETE FROM `vehicle loan` WHERE account_id='"+id+"' AND date='"+date+"'";
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            val=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return val;
        }
             
                
                
    }
    
    public Vehicle_data search_vehicle_loan(String no)
    {
        Connection c=connection.connect();
        String query="SELECT * FROM `vehicle loan` WHERE vehicle_no='"+no+"'";
        Vehicle_data vd=new Vehicle_data();
        
        try
        {
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                vd.setAccount_id(rs.getString("account_id"));
                vd.setBalance(Double.parseDouble(rs.getString("balance")));
                vd.setLoan_amount(Double.parseDouble(rs.getString("loan_amount")));
                vd.setDue_date(rs.getString("date"));
                vd.setInstall_payment(Double.parseDouble(rs.getString("POEM")));
                vd.setVehicleNo(rs.getString("vehicle_no"));
                vd.setPaid_amount(Double.parseDouble(rs.getString("paid_amount")));
                vd.setStatus(rs.getString("status"));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return vd;
        }
    }
    
    public boolean update_vehicle_loan(Vehicle_data d1)
    {
        Connection c=connection.connect();
        String query="UPDATE `vehicle loan` SET balance='"+d1.getBalance()+"',loan_amount='"+d1.getLoan_amount()+"',POEM='"+d1.getInstall_payment()+"',vehicle_no='"+d1.getVehicleNo()+"',paid_amount='"+d1.getPaid_amount()+"',status='"+d1.getStatus()+"' WHERE account_id='"+d1.getAccount_id()+"' AND date='"+d1.getDue_date()+"'";
        
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            val=true;
        }
        
        catch(Exception e)
        {
           e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return val;
        }
    }
    
    
     public Vector get_vehicle()
    {
      // ArrayList vehicle=null;
       
       String query="SELECT * FROM vehicle";
       Connection c=connection.connect();
       Vector big=null;
        Vehicle_data v1=new Vehicle_data();
       try
       {
           big=new Vector();
           Statement st=c.createStatement();
           ResultSet rs=st.executeQuery(query);
           
          
           
           while(rs.next())
           {
               Vector small=new Vector();
               small.add(rs.getString("vehicle_no"));
               small.add(rs.getString("type"));
               small.add(rs.getString("brand_name"));
              small.add(rs.getString("insurance_expiration_info"));
               big.add(small);
           }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
           connection.con_close(c);
           return big;
       }
    }
    
     
     
     public Vector get_vehicle_loan_id(String no)
    {
        Connection c=connection.connect();
        String query="SELECT * FROM `vehicle loan` WHERE vehicle_no='"+no+"'";
        Vehicle_data vd=new Vehicle_data();
        Vector big=null;
        try
        {
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery(query);
            big=new Vector();
            while(rs.next())
            {
                Vector small=new Vector();
                small.add(rs.getString("account_id"));
                small.add(Double.parseDouble(rs.getString("balance")));
                small.add(Double.parseDouble(rs.getString("loan_amount")));
                small.add(rs.getString("date"));
                small.add(Double.parseDouble(rs.getString("POEM")));
                small.add(rs.getString("vehicle_no"));
                small.add(Double.parseDouble(rs.getString("paid_amount")));
                small.add(rs.getString("status"));
                big.add(small);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return big;
        }
    }
    
    
     public Vector get_vehicle_loan()
    {
        Connection c=connection.connect();
        String query="SELECT * FROM `vehicle loan`";
        Vehicle_data vd=new Vehicle_data();
        Vector big=null;
        try
        {
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery(query);
            big=new Vector();
            while(rs.next())
            {
                Vector small=new Vector();
                small.add(rs.getString("account_id"));
                small.add(Double.parseDouble(rs.getString("balance")));
                small.add(Double.parseDouble(rs.getString("loan_amount")));
                small.add(rs.getString("date"));
                small.add(Double.parseDouble(rs.getString("POEM")));
                small.add(rs.getString("vehicle_no"));
                small.add(Double.parseDouble(rs.getString("paid_amount")));
                small.add(rs.getString("status"));
                big.add(small);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return big;
        }
    }
    
     
}
