/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.DBConnManager;
import DTO.Other_expenses_data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
/**
 *
 * @author Nuwan
 */
public class Other_expense_management {
    
    public boolean result;
    DBConnManager connection=new DBConnManager();
    
    
    public String get_id()
    {
        String i="";
        String query="SELECT id FROM `other payments`";
        Connection c=connection.connect();
        
        try
        {
           Statement st=c.createStatement();
           ResultSet rs=st.executeQuery(query);
           while(rs.next())
           {
               i=rs.getString("id");
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return i;
        }
    }
    
    
    
    public boolean Insert_other_expenses(Other_expenses_data oe)
    {
        
        String query="INSERT INTO `other payments`(`id`, `type`, `amount`, `date`, `price`) VALUES ('"+oe.getId()+"','"+oe.getType()+"','"+oe.getAmount()+"','"+oe.getDate()+"','"+oe.getPrice()+"')";
        Connection c=connection.connect();
        try
        {
            Statement st=c.createStatement();
            
            st.executeUpdate(query);
            result=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            return result;
        }
             
    }
    
    
 public Other_expenses_data search_other_expense(String date)
   {
       Connection c=connection.connect();
       String query="SELECT * FROM `other payments` WHERE date='"+date+"'";
       Other_expenses_data oe=new Other_expenses_data();
       try
       {
           Statement st=c.createStatement();
           ResultSet rr=st.executeQuery(query);
           while(rr.next())
           {
               oe.setId(rr.getInt("id"));
               oe.setType(rr.getString("type"));
               oe.setAmount(rr.getDouble("amount"));
               oe.setDate(rr.getString("date"));
               oe.setPrice(rr.getDouble("price"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       finally
       {
           
           connection.con_close(c);
           return oe;
       }
   }                              

     
    public boolean delete_expense(String id,String date)
    {
        Connection c=connection.connect();
        String query="DELETE FROM `other payments` WHERE id='"+id+"' AND date='"+date+"'";
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            result=true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return result;
        }
             
                
                
    }
    
     public boolean update_expense(Other_expenses_data oe)
    {
        Connection c=connection.connect();
        String query="UPDATE `other payments` SET type='"+oe.getType()+"',amount='"+oe.getAmount()+"',date='"+oe.getDate()+"',price='"+oe.getPrice()+"' WHERE id='"+oe.getId()+"'";
        
        
        try
        {
            Statement st=c.createStatement();
            st.executeUpdate(query);
            result=true;
        }
        
        catch(Exception e)
        {
           e.printStackTrace();
        }
        finally
        {
            connection.con_close(c);
            return result;
        }
    }
    
     
   public Vector get_other_expense()
   {
       Connection c=connection.connect();
       Vector big=null;
       String query="SELECT * FROM `other payments`";
       Other_expenses_data oe=new Other_expenses_data();
       try
       {
           Statement st=c.createStatement();
           ResultSet rr=st.executeQuery(query);
           big=new Vector();
           while(rr.next())
           {
               Vector small=new Vector();
               small.add(rr.getInt("id"));
               small.add(rr.getString("type"));
               small.add(rr.getDouble("amount"));
               small.add(rr.getString("date"));
               small.add(rr.getDouble("price"));
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
        public Vector get_expense_date(String date)
   {
       Connection c=connection.connect();
       Vector big=null;
       String query="SELECT * FROM `other payments` WHERE date='"+date+"'";
       Other_expenses_data oe=new Other_expenses_data();
       try
       {
           Statement st=c.createStatement();
           ResultSet rr=st.executeQuery(query);
           big=new Vector();
           while(rr.next())
           {
               Vector small=new Vector();
               small.add(rr.getInt("id"));
               small.add(rr.getString("type"));
               small.add(rr.getDouble("amount"));
               small.add(rr.getString("date"));
               small.add(rr.getDouble("price"));
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
