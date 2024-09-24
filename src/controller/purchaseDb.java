    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import Interface.Purchase;
import Interface.PurchaseDetail;
import Model.purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author samrit
 */
public class purchaseDb {
    
     Connection con ;
     PreparedStatement ps ;
     ResultSet rs;
     DefaultTableModel model ;
     float currentqty;
     float purchaseQty;
            
    public  void insertPur(  String id , String purId, String date , int itemId, float qty  )
    {
        try {
             con = MyConnection.getConnection();
            
          
                  
           String query = "INSERT INTO `purchase`(`id`, `purId`, `date`, `itemId`, `quantity`) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(query); 
            
            ps.setString(1,id);
            ps.setString(2,purId);
            ps.setString(3,date );
            ps.setInt(4,itemId );
            ps.setFloat(5,qty);
            
            ps.executeUpdate();
                    
            ps.addBatch();
           
               
                 //   JOptionPane.showMessageDialog(null, "New Purchase is Posted Successfuly");
                
             
            
        } catch (SQLException ex) {
            Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
     public boolean isPurchaseIdExist( String id){
       
       boolean isExist = false;
       try{
           con = MyConnection.getConnection();
           ps= con.prepareStatement("SELECT * FROM `purchase` WHERE `purId` =?");
           ps.setString(1, id);
          
           rs = ps.executeQuery();
           if(rs.next()){
               isExist = true;
           }
           
           
       } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
       
       
       
       return isExist;
       
   }
      
       public void FillComboItemName() throws SQLException{
     try{
           con = MyConnection.getConnection();
           
           String sql = " SELECT * FROM `item` ORDER BY `itemName` ASC";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               String itemName = rs.getString("itemName");
           
              //Purchase.cmbItemName.addItem(itemName);
              Purchase.cmbItemName.addItem(itemName);
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
           }
     
      
       public void CompoItemName() throws SQLException{
     try{
         //String itemName = Purchase12.cmbItsemName.getSelectedItem().toString();
         String itemName = Purchase.cmbItemName.getSelectedItem().toString();
         
           con = MyConnection.getConnection();
 
           //String sql = "SELECT * FROM item WHERE date = (SELECT date FROM contract WHERE date =(SELECT max(date) from contract where fullName = '"+fullname+"' AND roomno = '"+roomNo+"' )) LIMIT 1;  ";
           String sql = "SELECT * FROM item where itemName = '"+itemName+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           if(rs.next()){
               String itemId = rs.getString("id");
               String unit = rs.getString("unit");
               Purchase.itemId.setText(itemId);
               Purchase.iUnt.setSelectedItem(unit);
           }
           else{
             //  JOptionPane.showMessageDialog(null, "Data is not found! Please Check Name or Room No.");
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
           }
       
       
        public void autoId(){
       
          try{
               con = MyConnection.getConnection();
             
           String sql = "SELECT id FROM purchase ORDER by id DESC LIMIT 1 ";
            ps = con.prepareStatement(sql);
           
            rs = ps.executeQuery();
            if(rs.next()){
                String rnno = rs.getString("id");
                int co = rnno.length();
                String txt = rnno.substring(0,3);
                String num = rnno.substring(3,co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt +snum;
                
                Purchase.tranIdpur.setText(ftxt);
                  }
            else{
               Purchase.tranIdpur.setText("PUR1000");
            }
        }
        catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }
    
   public static ArrayList<purchase> TableGenerator(){
        ArrayList<purchase> list = new ArrayList<>();
        try {
        
            Connection  con = MyConnection.getConnection();
           PreparedStatement  ps = con.prepareStatement("SELECT  purchase.* , item.itemName, item.unit FROM purchase  INNER JOIN item ON "
                     + "purchase.itemId = item.id WHERE purchase.purId = ? ");
             
             ps.setString(1, String.valueOf(PurchaseDetail.txtSearch.getText()));
           
             ResultSet rs = ps.executeQuery();
            
            purchase pur;
            
            while(rs.next()){
                
                
//public sales(String trans, String salesId, String date, String customerName, int itemId  , String itemName, String unit , int qty, float price, float total, float vat, float totalAmount)                
                
                pur = new purchase(rs.getString("id"),rs.getString("purId"), rs.getString("date"),rs.getInt("itemId"),rs.getString("itemName"), rs.getString("unit"), rs.getFloat("quantity"));
                
                list.add(pur);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
   
    public  void updatePurchase( String id , String purId, String date , int itemId, float qty) {
   
        try {
             con = MyConnection.getConnection();
            
           
                  
            ps  = con.prepareStatement("UPDATE `purchase` SET `purId`=?,`date`=?,`itemId`=?,`quantity`=? WHERE `id`=? ");
            
            
            ps.setString(1,purId);
            ps.setString(2,date );
            ps.setInt(3,itemId );
            ps.setFloat(4,qty);
            ps.setString(5,id);
            
            ps.executeUpdate();
                    
            ps.addBatch();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }
    
        public void autoIdDetail(){
       
          try{
               con = MyConnection.getConnection();
             
           String sql = "SELECT id FROM purchase ORDER by id DESC LIMIT 1  ";
            ps = con.prepareStatement(sql);
           
           rs = ps.executeQuery();
            if(rs.next()){
                String rnno = rs.getString("id");
                int co = rnno.length();
                String txt = rnno.substring(0,3);
                String num = rnno.substring(3,co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt +snum;
                PurchaseDetail.tranIdpur.setText(ftxt);
                  }
            else{
               PurchaseDetail.tranIdpur.setText("PUR1000");
            }
        }
        catch( SQLException ex){
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        
         public void CompoItemNameDetail() throws SQLException{
     try{
         //String itemName = Purchase12.cmbItsemName.getSelectedItem().toString();
         String itemName = PurchaseDetail.cmbItemName.getSelectedItem().toString();
         
           con = MyConnection.getConnection();
 
           //String sql = "SELECT * FROM item WHERE date = (SELECT date FROM contract WHERE date =(SELECT max(date) from contract where fullName = '"+fullname+"' AND roomno = '"+roomNo+"' )) LIMIT 1;  ";
           String sql = "SELECT * FROM item where itemName = '"+itemName+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           if(rs.next()){
               String itemId = rs.getString("id");
               String unit = rs.getString("unit");
               PurchaseDetail.itemId.setText(itemId);
               PurchaseDetail.iUnt.setSelectedItem(unit);
           }
           else{
             //  JOptionPane.showMessageDialog(null, "Data is not found! Please Check Name or Room No.");
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
           }
        
     
     public void delete(String id){
          try{
              con = MyConnection.getConnection();
              ps = con.prepareStatement("DELETE FROM `purchase` WHERE id =?");
              ps.setString(1, id);

              if(ps.executeUpdate() > 0){
           // JOptionPane.showMessageDialog(null, "Purchase is Successfully Removed");
                 

              }
          } catch (SQLException ex) {
            Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     
       public boolean isTransactionIdExist( String transId){
       
       boolean isExist = false;
       try{
           con = MyConnection.getConnection();
           ps= con.prepareStatement("SELECT * FROM `purchase` WHERE `id` =?");
           ps.setString(1, transId);
          
           rs = ps.executeQuery();
           if(rs.next()){
               isExist = true;
           }
           
           
       } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
       
       
       
       return isExist;
       
   }
     
     public float getPurQty(String transId){
         
          try{
                con = MyConnection.getConnection();
             
                ps  = con.prepareStatement( "select quantity from purchase where id = '"+transId+"'" );
             
                rs= ps.executeQuery(); 
            
            if(rs.next()){
                
                purchaseQty= rs.getInt("quantity");
            }
              
          }catch(SQLException ex){
               Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
              
          }
          
           return purchaseQty;
       }
     
         
       
}
