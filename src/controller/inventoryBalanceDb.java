/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samrit
 */
public class inventoryBalanceDb {
    
    
    Connection con;
    PreparedStatement ps ;
    ResultSet rs;
    DefaultTableModel model ;    

    
    
     public  void insertInventory( String transactionDetailId, String date,  int itemId, float purqty, float salqty ) 
    {
   
        try {
  
             con = MyConnection.getConnection();
            
            ps  = con.prepareStatement("INSERT INTO `inventorybalance`( `transactionDetalId`, `date`, `itemId`, `purqty`, `salqty`) VALUES (?,?,?,?,?)");
        
            ps.setString(1,transactionDetailId);
            ps.setString(2,date);
            ps.setInt(3,itemId);
            ps.setFloat(4,purqty);
            ps.setFloat(5,salqty);
            
           if(ps.executeUpdate() > 0){ 
                    JOptionPane.showMessageDialog(null, "New Inventory is add Successfuly");
                }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           public  void inventoryUpdate(  String transactionDetailId, String date,  int itemId, float purqty, float salqty )
    {
   
        try {
             con = MyConnection.getConnection();
            
         
            ps  = con.prepareStatement("UPDATE `inventorybalance` SET `date`=?,`itemId`=?,`purqty`=? ,`salqty`= ? WHERE `transactionDetalId`=?");
            
             
            
            ps.setString(1,date);
            ps.setInt(2,itemId);
            ps.setFloat(3,purqty);
            ps.setFloat(4,salqty);
            ps.setString(5,transactionDetailId);
            
                if(ps.executeUpdate() > 0){ 
                    JOptionPane.showMessageDialog(null, " Item is Updated");
                }
                
              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
           
    public void delete(String id){
          try{
              con = MyConnection.getConnection();
              ps = con.prepareStatement("DELETE FROM `inventorybalance` WHERE transactionDetalId =?");
              ps.setString(1, id);

              if(ps.executeUpdate() > 0){
                
                JOptionPane.showMessageDialog(null, "Sales is removed from inventoryReport Successfully ");
                  

              }
          } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
      public  void insertPurInventory( String transactionDetailId, String date,  int itemId, float purqty, float salqty ) 
    {
   
        try {
              // int last = 0;
             con = MyConnection.getConnection();
            String query = "INSERT INTO `inventorybalance`( `transactionDetalId`, `date`, `itemId`, `purqty`, `salqty`) VALUES (?,?,?,?,?)";
            //ps  = con.prepareStatement("INSERT INTO `inventorybalance`( `transactionDetalId`, `date`, `itemId`, `purqty`, `salqty`) VALUES (?,?,?,?,?)");
            
            ps = con.prepareStatement(query);
            ps.setString(1,transactionDetailId);
            ps.setString(2,date);
            ps.setInt(3,itemId);
            ps.setFloat(4,purqty);
            ps.setFloat(5,salqty);
            
            
             ps.executeUpdate();
                    
            ps.addBatch();
               // if(rs.next()){ 
//                    JOptionPane.showMessageDialog(null, " Purchase is add to inventory");
            
            
            
//           if(ps.executeUpdate() > 0){ 
//                    JOptionPane.showMessageDialog(null, "New Inventory is add Successfuly");
//                }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}