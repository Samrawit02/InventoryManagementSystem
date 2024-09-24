/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.Sales;
import Interface.SalesDetail;
import Model.sales;
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

/**
 *
 * @author samrit
 */
public class salesDb  {
    
            Connection con;
            PreparedStatement ps ;
            ResultSet rs;
            DefaultTableModel model ;
            float salesQty;
            
             
      public  void insert(  String salesId, String date, double amount, double vat, double totalAmount){
   
        try {
             con = MyConnection.getConnection();
            
            
                  
            ps  = con.prepareStatement("INSERT INTO `sales`( `date`, `salesId`, `amount`, `vat`, `totalAmount`) VALUES (?,?,?,?,?)");
           
            ps.setString(1,date);
            ps.setString(2,salesId);
            ps.setDouble(3,amount);
            ps.setDouble(4, vat);
            ps.setDouble(5, totalAmount);
                    
            
           
                if(ps.executeUpdate() > 0){ 
                //    JOptionPane.showMessageDialog(null, "Sales is Added Successfuly");
                }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
      
      public  void insertSalesItem(String transactionId ,String salesId, String date, String customerName, int itemId, float quantity, float price, float total ) {
   
        try {
             con = MyConnection.getConnection();
            
            String query = "INSERT INTO `salesitem`(`transactionDetalId`, `salesId`, `date`, `customerName`, `itemId`, `quantiy`, `price`, `total`) VALUES (?,?,?,?,?,?,?,?)";
           // ps  = con.prepareStatement( "INSERT INTO `salesitem`(`salesId`, `date`, `customerName`, `itemId`, `quantiy`, `price`, `total`) VALUES(?,?,?,?,?,?,?)");
            ps = con.prepareStatement(query);
            
            ps.setString(1,transactionId);
            ps.setString(2,salesId);
            ps.setString(3,date);
            ps.setString(4,customerName);
            ps.setInt(5,itemId);
            ps.setFloat(6,quantity);
            ps.setFloat(7,price);
            ps.setFloat(8,total);
            //rs = ps.getGeneratedKeys();
            ps.executeUpdate();
                    
            ps.addBatch();
               // if(rs.next()){ 
               //     JOptionPane.showMessageDialog(null, " Sales is Saved");
               // }
//                else{
//                   JOptionPane.showMessageDialog(null, "can not update");
//                }
//            
        } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
       public  void insertVat( String date, float pur, float sales ) {
   
        try {
             con = MyConnection.getConnection();
            
         
            ps  = con.prepareStatement( "INSERT INTO `vatreport`( `date`, `fromPur`, `fromSales`) VALUES (?,?,?) ");
            
           
            ps.setString(1,date);
            ps.setFloat(2, pur);
            ps.setFloat(3, sales);
           
            
          
                if(ps.executeUpdate() > 0){ 
                    JOptionPane.showMessageDialog(null, " vat is add");
                }
                else{
                   JOptionPane.showMessageDialog(null, "can not update");
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public void autoId(){
       
          try{
               con = MyConnection.getConnection();
             
           String sql = "SELECT transactionDetalId FROM salesitem ORDER by transactionDetalId DESC LIMIT 1 ";
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
                Sales.transal.setText(ftxt);
                  }
            else{
               Sales.transal.setText("sal1000");;
            }
        }
        catch( SQLException ex){
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
      
       public boolean isSalesExist(String salesId){
       
       boolean isExist = false;
       
       try{
           
           ps= con.prepareStatement("SELECT * FROM `salesitem` WHERE `salesId` =?");
           ps.setString(1, salesId);
           rs = ps.executeQuery();
           if(rs.next()){
               isExist = true;
               
           }
           
          
       } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       return isExist;
       
     
       }
       
       public void FillComboFullNames() throws SQLException{
     try{
           con = MyConnection.getConnection();
           String sql = "SELECT * FROM item ORDER BY itemName";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               String itemName = rs.getString("itemName");
              Sales.cmbItemName.addItem(itemName);
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
           }
       
    public void CompoItemName() throws SQLException{
     try{
         String itemName = Sales.cmbItemName.getSelectedItem().toString();
         
         
           con = MyConnection.getConnection();
 
           //String sql = "SELECT * FROM item WHERE date = (SELECT date FROM contract WHERE date =(SELECT max(date) from contract where fullName = '"+fullname+"' AND roomno = '"+roomNo+"' )) LIMIT 1;  ";
           String sql = "SELECT * FROM item where itemName = '"+itemName+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           if(rs.next()){
               String itemId = rs.getString("id");
               String unit = rs.getString("unit");
               Sales.itemId.setText(itemId);
               Sales.iunt.setSelectedItem(unit);
           }
           else{
             //  JOptionPane.showMessageDialog(null, "Data is not found! Please Check Name or Room No.");
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
        }
        
        
    public static ArrayList<sales> TableGenerator(){
        ArrayList<sales> list = new ArrayList<>();
        try {
        
            Connection  con = MyConnection.getConnection();
           PreparedStatement  ps = con.prepareStatement("SELECT  salesitem.* , item.itemName, item.unit FROM salesitem  INNER JOIN item ON "
                     + "salesitem.itemId = item.id WHERE salesitem.salesId = ? ");
             
             ps.setString(1, String.valueOf(SalesDetail.txtSearch.getText()));
           
             ResultSet rs = ps.executeQuery();
            
            sales sal;
            
            while(rs.next()){
                
                
//public sales(String trans, String salesId, String date, String customerName, int itemId  , String itemName, String unit , int qty, float price, float total, float vat, float totalAmount)                
                
                sal = new sales( rs.getString("transactionDetalId"), rs.getString("salesId"), rs.getString("date"), rs.getString("customerName"),rs.getInt("itemId"),
                        rs.getString("itemName"),rs.getString("unit"), rs.getFloat("quantiy"),rs.getFloat("price"), rs.getFloat("total"));
                
                list.add(sal);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
 
        
         public  void updateSalesitem(String transactionId ,String salesId, String date, String customerName, int itemId, float quantity, float price, float total ) {
   
        try {
             con = MyConnection.getConnection();
            
           
                  
            ps  = con.prepareStatement("UPDATE `salesitem` SET `salesId`=?,`date`= ?,`customerName`= ?,`itemId`=? ,`quantiy`=?,`price`=?,`total`=? WHERE `transactionDetalId`= ?");
            
            ps.setString(1,salesId);
            ps.setString(2,date);
            ps.setString(3,customerName);
            ps.setInt(4,itemId);
            ps.setFloat(5,quantity);
            ps.setFloat(6,price);
            ps.setFloat(7,total);
            ps.setString(8,transactionId);
            ps.executeUpdate();
                    
            ps.addBatch();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         public  void updateSales( String trans_id,  String date,  String salesId, double amount, double vat, double totalAmount ) {
   
        try {
             con = MyConnection.getConnection();
            
           
                  
            ps  = con.prepareStatement("UPDATE `sales` SET `date`=? ,`salesId`=?,`amount`=?,`vat`=?,`totalAmount`=? WHERE `transaction_id`= ?");
            
            
            ps.setString(1,date);
            ps.setString(2,salesId);
            ps.setDouble(3,amount);
            ps.setDouble(4, vat);
            ps.setDouble(5, totalAmount);
            ps.setString(6,trans_id);
            ps.executeUpdate();
                    
            ps.addBatch();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
         public void deleteSalesItem(String transId){
             
                      try{
              con = MyConnection.getConnection();
              
              ps = con.prepareStatement("DELETE  FROM `salesitem` WHERE `transactionDetalId` = ?");
              ps.setString(1, transId);

              if(ps.executeUpdate() > 0){
              
                JOptionPane.showMessageDialog(null, "Sales item is Successfully Removed");
            

              }
          } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }      

         } 
         
           public void deleteSales(String salesId){
             
                      try{
              con = MyConnection.getConnection();
              
              ps = con.prepareStatement("DELETE  FROM `sales` WHERE `salesId` = ?");
              ps.setString(1, salesId);

              if(ps.executeUpdate() > 0){
              
                JOptionPane.showMessageDialog(null, "Sales is Successfully Removed");
            

              }
          } catch (SQLException ex) {
            Logger.getLogger(itemDb.class.getName()).log(Level.SEVERE, null, ex);
        }      

         }
           
            public void autoIdDetail(){
       
          try{
               con = MyConnection.getConnection();
             
           String sql = "SELECT transactionDetalId FROM salesitem ORDER by transactionDetalId DESC LIMIT 1 ";
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
                SalesDetail.transal.setText(ftxt);
                  }
            else{
               SalesDetail.transal.setText("sal1000");;
            }
        }
        catch( SQLException ex){
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
     public void CompoItemNameDetail() throws SQLException{
     try{
         String itemName = SalesDetail.cmbItemN.getSelectedItem().toString();
         
         
           con = MyConnection.getConnection();
 
           //String sql = "SELECT * FROM item WHERE date = (SELECT date FROM contract WHERE date =(SELECT max(date) from contract where fullName = '"+fullname+"' AND roomno = '"+roomNo+"' )) LIMIT 1;  ";
           String sql = "SELECT * FROM item where itemName = '"+itemName+"'";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           if(rs.next()){
               String itemId = rs.getString("id");
               String unit = rs.getString("unit");
               SalesDetail.itemId.setText(itemId);
               SalesDetail.iunt.setSelectedItem(unit);
           }
           else{
             //  JOptionPane.showMessageDialog(null, "Data is not found! Please Check Name or Room No.");
           }
           
       }catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    
        }
     
       public boolean isTransactionExist(String transId){
       
       boolean isExist = false;
       
       try{
           
           ps= con.prepareStatement("SELECT * FROM `salesitem` WHERE `transactionDetalId` =?");
           ps.setString(1, transId);
           rs = ps.executeQuery();
           if(rs.next()){
               isExist = true;
               
           }
           
          
       } catch (SQLException ex) {
            Logger.getLogger(salesDb.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
       return isExist;
       
     
       }

    public float getSalQty(String transId) {
        
        try{
                con = MyConnection.getConnection();
             
                ps  = con.prepareStatement( "select quantiy from salesitem where transactionDetalId = '"+transId+"'" );
             
                rs= ps.executeQuery(); 
            
            if(rs.next()){
                
                salesQty= rs.getInt("quantiy");
            }
              
          }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, ex);
               Logger.getLogger(purchaseDb.class.getName()).log(Level.SEVERE, null, ex);
              
          }
          
           return salesQty;
       
    }
     
           
           
        
}

