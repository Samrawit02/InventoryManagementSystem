/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.AddItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.item;

/**
 *
 * @author samrit
 */
public class itemDb {
    
            Connection con ;
            PreparedStatement ps ;
            ResultSet rs;
            DefaultTableModel model ;
            static int itm = 0;
            float currentqty ;
            float purchaseQty;
            
public  void insert( String itemName, String unit , float qtyperUnit) {
        try {
             con = MyConnection.getConnection();
            
          
                  
            ps  = con.prepareStatement("INSERT INTO item ( itemName, unit, qtyperUnit) VALUES (?,?,?)");
            
            
            ps.setString(1,itemName);
            ps.setString(2,unit );
            ps.setFloat(3,qtyperUnit );
           
            ps.executeUpdate();
                    
            ps.addBatch();
           
               // if(ps.executeUpdate() > 0){ 
                    JOptionPane.showMessageDialog(null, "New Item is Registered Successfuly");
               // }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
public  void update( int id, String itemName, String unit , float qtyperUnit) {
   
        try {
             con = MyConnection.getConnection();
            
           
                  
            ps  = con.prepareStatement("UPDATE `item` SET `itemName`=?,`unit`=?,`qtyperUnit`=? WHERE `id`=?");
            
             
        
            ps.setString(1,itemName);
            ps.setString(2,unit );
            ps.setFloat(3,qtyperUnit );
            ps.setInt(4,id);
            ps.executeUpdate();
                    
            ps.addBatch();
           
//            
//                if(ps.executeUpdate() > 0){ 
//                    JOptionPane.showMessageDialog(null, " Item is Updated");
//                }
//              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
          
public static ArrayList<item> TableGenerator(){
        ArrayList<item> list = new ArrayList<>();
        try {
         
            Connection  con = MyConnection.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT `id`,`itemName`, `unit`, `qtyperUnit` FROM `item` ORDER BY itemName");
            
            item tm;
            
            while(rs.next()){
                
                tm = new item(rs.getInt("id"),rs.getString("itemName"), rs.getString("unit"), rs.getFloat("qtyperUnit"));
                
                list.add(tm);

            }
           
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
    
public void delete(String id){
          try{
              con = MyConnection.getConnection();
              ps = con.prepareStatement("DELETE FROM `item` WHERE itemName = ?");
              ps.setString(1, id);

              if(ps.executeUpdate() > 0){
//                 JOptionPane.showConfirmDialog(null, "do you really want to delete");
//                 JOptionPane.showConfirmDialog(null, "Do you want to proceed?", "Select an Option...",
//				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "item is Successfully Removed");
//                    String resetid = "ALTER TABLE tenant DROP id";
//                    String contnum = "ALTER TABLE tenant ADD id INT NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST";
//                    con.createStatement().execute(resetid);
//                    con.createStatement().execute(contnum);
//                  

              }
          } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
   
public boolean isTenantExist( String itemName){
       
       boolean isExist = false;
       try{
           con = MyConnection.getConnection();
           ps= con.prepareStatement("SELECT * FROM `item` WHERE `itemName` =?");
           ps.setString(1, itemName);
          
           rs = ps.executeQuery();
           if(rs.next()){
               isExist = true;
           }
           else{
               
               
           }
       } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       return isExist;
       
   }  

public boolean isItemid( int id){
       
       boolean isExist = false;
       try{
           con = MyConnection.getConnection();
           ps= con.prepareStatement("SELECT * FROM `item` WHERE `id` =?");
           ps.setInt(1, id);
          
           rs = ps.executeQuery();
           if(rs.next()){
               
               isExist = true;
           }
           else{
               JOptionPane.showMessageDialog(null, "Item did not exist");
               
           }
       } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       return isExist;
       
   }
            
public void autoId(){
       
          try{
               con = MyConnection.getConnection();
             
           String sql = "SELECT transactionDetalId FROM item ORDER by transactionDetalId DESC LIMIT 1 ";
            ps = con.prepareStatement(sql);
           
           rs = ps.executeQuery();
            if(rs.next()){
                String rnno = rs.getString("transactionDetalId");
                int co = rnno.length();
                String txt = rnno.substring(0,3);
                String num = rnno.substring(3,co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt +snum;
            //    AddItem.itemIdtransactionId.setText(ftxt);
                  }
            else{
            //   AddItem.itemIdtransactionId.setText("INV1000");;
            }
        }
        catch( SQLException ex){
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
          
public  void updateqty( int id,  float currentQty )         {
        try {
             con = MyConnection.getConnection();
             String queryup = "UPDATE `itemqtyreport` SET `endQuantity`=? WHERE `itemId`=?";
             ps = con.prepareStatement(queryup);
            
            ps.setFloat(1,currentQty);
            ps.setInt(2,id);
            ps.executeUpdate();
                    
            ps.addBatch();
           
//            
//                if(ps.executeUpdate() > 0){ 
//                    JOptionPane.showMessageDialog(null, " Item is Updated");
//                }
//              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
        public  void insertqty( int id,  float currentQty )         {
        try {
             con = MyConnection.getConnection();
             String queryup = "INSERT INTO `itemqtyreport`( `itemId`, `endQuantity`) VALUES (?,?)";
             ps = con.prepareStatement(queryup);
            
            ps.setFloat(2,currentQty);
            ps.setInt(1,id);
            ps.executeUpdate();
                    
            ps.addBatch();
           
//            
//                if(ps.executeUpdate() > 0){ 
//                    JOptionPane.showMessageDialog(null, " Item is Updated");
//                }
//              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
         public static ArrayList<item> SearchTableGenerator(){
        ArrayList<item> list = new ArrayList<>();
        String search = AddItem.txtSearch.getText().toUpperCase();
        try {
        
            Connection  con = MyConnection.getConnection();
            Statement stmt = (Statement)con.createStatement();
            String searchQuery = "SELECT * FROM `item`  WHERE itemName LIKE  '%"+search+"%'  ";
            ResultSet rs = stmt.executeQuery(searchQuery);

            item tm;
            
            while(rs.next()){
                
                

                
                tm = new item(rs.getInt("id"),rs.getString("itemName"), rs.getString("unit"), rs.getFloat("qtyperUnit"));
                
                list.add(tm);
 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
}
         
     public float getendQty(int itemId){
         
          try{
                con = MyConnection.getConnection();
             
                ps  = con.prepareStatement( "select endQuantity from itemqtyreport where itemId= '"+itemId+"'" );
             
                rs= ps.executeQuery(); 
            
            if(rs.next()){
                
                currentqty= rs.getInt("endQuantity");
            }
              
          }catch(SQLException ex){
               Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
              
          }
          
           return currentqty;
       }
     
     public boolean isItemidInItemQty( int id){
       
       boolean isExist = false;
       try{
           con = MyConnection.getConnection();
           ps= con.prepareStatement("SELECT * FROM `itemqtyreport` WHERE `itemId` =?");
           ps.setInt(1, id);
          
           rs = ps.executeQuery();
           if(rs.next()){
               
               isExist = true;
           }
           else{
              // JOptionPane.showMessageDialog(null, "Item did not exist");
               
           }
       } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       return isExist;
       
   }
     
      public float getStockBalance(int itemId){
         
          try{
                con = MyConnection.getConnection();
             
                ps  = con.prepareStatement( "select quantity from itemqtyreport where itemId= '"+itemId+"'" );
             
                rs= ps.executeQuery(); 
            
            if(rs.next()){
                
                currentqty= rs.getInt("endQuantity");
            }
              
          }catch(SQLException ex){
               Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
              
          }
          
           return currentqty;
       }
     
         
    
          public static ArrayList<item> NegativeStockTableGenerator(){
        ArrayList<item> list = new ArrayList<>();
        try {
         
            Connection  con = MyConnection.getConnection();
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT `itemId`,`itemName`, `Balance` FROM `stockreportdetail WHERE Balance <= 0` ORDER BY itemName");
            
            item tm;
            
            while(rs.next()){
                
                tm = new item(rs.getInt("itemId"),rs.getString("itemName"), rs.getString("Balance"), rs.getFloat("qtyperUnit"));
                
                list.add(tm);

            }
           
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}    
         
         
         
         
        
        
//         public  ArrayList<item> itemSearch(String model){
//             
//          
//          
//        ArrayList<item> list = new ArrayList<>();
//        
//        try {
//             con = MyConnection.getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM item WHERE itemName=? COLLATE NOCASE ");
//            ps.setString(1,model);
//            
//            ResultSet rs = ps.executeQuery();
//            
//             item tm;
//            
//            while(rs.next()){
//                
//                tm = new item(rs.getString("transactionDetalId"),rs.getInt("id"),rs.getString("itemName"), rs.getString("unit"), rs.getFloat("qtyperUnit"),rs.getFloat("quantity"));
//                
//                itm++;
//                
//                list.add(tm);
//
//            }
//            con.close();
//        
//          } catch (SQLException ex) {
//            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//         }
         
         
        
}
