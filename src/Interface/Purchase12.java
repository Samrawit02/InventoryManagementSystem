/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import controller.purchaseDb;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controller.MyConnection;
import controller.salesDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import javax.swing.table.TableModel;
/**
 *
 * @author samrit
 */
public class Purchase12 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Purchase12
     */
    String purId;
    String pdate;
    int itemid;
    String itemName;
    String iUnit;
    int quantity;
    Connection con;
    PreparedStatement ps ;
    ResultSet rs;
    PreparedStatement ps1;
    ResultSet rs1;
    
    purchaseDb purDb = new purchaseDb();
  
    public Purchase12()  {
        initComponents();
        
        try {
            purDb.FillComboItemName();
        } catch (SQLException ex) {
            Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        puId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        puDate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        itemId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbItemName = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        puQty = new javax.swing.JTextField();
        purlAdd = new javax.swing.JButton();
        purUpdate = new javax.swing.JButton();
        purDelet = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        iUnt = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        puVat = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1120, 670));

        jPanel1.setBackground(new java.awt.Color(0, 138, 207));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 670));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchase Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel8.setText("Purchase Id");

        puId.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel9.setText("Date");

        jLabel11.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel11.setText("Item Id");

        itemId.setEditable(false);
        itemId.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel12.setText("Item Name");

        cmbItemName.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        cmbItemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Name" }));
        cmbItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbItemNameActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel14.setText("Quantity");

        puQty.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        puQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                puQtyKeyTyped(evt);
            }
        });

        purlAdd.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        purlAdd.setText("Add");
        purlAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purlAddActionPerformed(evt);
            }
        });

        purUpdate.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        purUpdate.setText("Update");
        purUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purUpdateActionPerformed(evt);
            }
        });

        purDelet.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        purDelet.setText("Delete");
        purDelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purDeletActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel13.setText("Unit");

        iUnt.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        iUnt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Unit", "PCS", "Package", "Kg" }));

        jLabel15.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        jLabel15.setText("VAT");

        puVat.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(puDate, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(puId))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemId)
                    .addComponent(cmbItemName, 0, 179, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(puQty, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(iUnt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(purlAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(purUpdate)
                .addGap(97, 97, 97)
                .addComponent(purDelet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(puVat, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbItemName, itemId, puDate, puId, puQty});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(puId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addComponent(puDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(iUnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(puQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(itemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(purlAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(purUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(purDelet, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(puVat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14, jLabel8, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbItemName, iUnt, itemId, puDate, puId, puQty});

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1080, 170));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        purchaseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Purchase Id", "Date","Item Id","Item Name","Unit", "Qty/Unit"
            }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.String.class, javax.swing.Icon.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }

        });
        purchaseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1080, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public boolean verifText(){
            if( puId.getText().equals("")|| puDate.getDate()==null ||itemId.getText().equals("")
                 || cmbItemName.getSelectedIndex()==0  || iUnt.getSelectedIndex()==0 || puQty.getText().equals(""))
                 
            {                  
                JOptionPane.showMessageDialog(null, "One or More Empty Field");

                
                 return false; 
        
            }
          
            
         return true;
     
    }     
    private void purlAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purlAddActionPerformed
          
       if(verifText()){
       purId =  puId.getText();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       pdate = dateFormat.format(puDate.getDate());
       itemid =Integer.parseInt( itemId.getText());
       itemName = cmbItemName.getSelectedItem().toString();
       iUnit = iUnt.getSelectedItem().toString();
       quantity = Integer.parseInt(puQty.getText());
           if(!purDb.isPurchaseIdExist(purId)){
           
           try {
          
             
               con = MyConnection.getConnection();
              
               ps  = con.prepareStatement( "select * from vatreport where id =(SELECT MAX(id) from vatreport)");

                        rs= ps.executeQuery();

                        while(rs.next()){

                            float currentvat;
                            currentvat= rs.getFloat("balance");
                            if (!puVat.getText().isEmpty()){
                                float qtyNew = Float.parseFloat(puVat.getText());
                                float newvat = currentvat + qtyNew;
                                salesDb salDb = new salesDb();

                             //   salDb.insertVat(pdate,qtyNew,0, newvat);
                            }


                        }
                        
        
            ps  = con.prepareStatement( "select quantity from item where id= "+itemId.getText() );
             
            rs= ps.executeQuery(); 
            int updatQty =0;
            if(rs.next()){
                int currentqty ;
                currentqty= rs.getInt("quantity");
                int qtyNew = Integer.parseInt(puQty.getText());
                updatQty = currentqty + qtyNew;
                
//                purDb.updateItemQty( itemid, updatQty);
                

            }
                
//           
//            ArrayList<purchase> list = purchaseDb.TableGenerator();
//            Object rowData[] = new Object[6];
//            //DefaultTableModel  model =  new DefaultTableModel (null, new Object[]{ "Full Name","Tin No", "Company Name"," Contact Person Name","Telephone No"," Address "});
//            DefaultTableModel model =  (DefaultTableModel) purchaseTable.getModel();
//            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//            purchaseTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
//            purchaseTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//            purchaseTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
//            purchaseTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
//            purchaseTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
//            purchaseTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
//
//
//            model.setRowCount(0); //To clear mobileTable
//
//            for(int i=0; i<list.size(); i++){
//          
//            rowData[0] = list.get(i).getPurId();
//            rowData[1] = list.get(i).getDate();
//            rowData[2] = list.get(i).getItemId();
//            rowData[3] = list.get(i).getItemName();
//            rowData[4] = list.get(i).getUnit();
//            rowData[5] = list.get(i).getQty();
//
//            model.addRow(rowData);
//            }
//            
            } catch (SQLException ex) {
                           Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
                       }        
            }else{
               JOptionPane.showMessageDialog(rootPane, "Purchase Id already Exist");
           }
            puId.setText("");
            puDate.setDate(new Date());
            itemId.setText("");
            cmbItemName.setSelectedIndex(0);
            iUnt.setSelectedIndex(0);
            puQty.setText("");
                       
           
           
       }
       
    }//GEN-LAST:event_purlAddActionPerformed

    private void purUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purUpdateActionPerformed
       
       purId =  puId.getText();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       pdate = dateFormat.format(puDate.getDate());
       itemid =Integer.parseInt( itemId.getText());
       itemName = cmbItemName.getSelectedItem().toString();
       iUnit = iUnt.getSelectedItem().toString();
       quantity = Integer.parseInt(puQty.getText());
       
   //      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
       try{
           con = MyConnection.getConnection();
       
            ps  = con.prepareStatement( "select quantity from item where id= "+itemid );
           // "SELECT * FROM javabase.user WHERE username = '"+ user +"' and password = '"+pw+"';
            ps1=  con.prepareStatement( "select quantity from purchase where purId = '"+purId+"'");
            rs = ps.executeQuery(); 
            rs1 = ps1.executeQuery();
            int updatQty =0;
            if(rs.next() && rs1.next()){
                int currentqty ;
                int purqty;
                currentqty= rs.getInt("quantity");
                System.out.println(currentqty);
                purqty = rs1.getInt("quantity");
                System.out.println(purqty);
              // int qtyNew = Integer.parseInt(puQty.getText());
                System.out.println(quantity);
                updatQty = (currentqty - purqty)+ quantity;
                System.out.println(updatQty);
//                purDb.updateItemQty( itemid, updatQty);
             

            }else{
               JOptionPane.showMessageDialog(this, "Can not update");
            }
            
                
       }catch(SQLException ex) {
            Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
       
       }
//         purDb.update(purId, pdate, itemid, quantity);
//   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
           puId.setText("");
           puDate.setDate(new Date());
           cmbItemName.setSelectedIndex(0);
           itemId.setText("");
           
           iUnt.setSelectedIndex(0);
           puQty.setText("");
       
//       
//        ArrayList<purchase> list = purchaseDb.TableGenerator();
//        Object rowData[] = new Object[6];
//     //DefaultTableModel  model =  new DefaultTableModel (null, new Object[]{ "Full Name","Tin No", "Company Name"," Contact Person Name","Telephone No"," Address "});
//        DefaultTableModel model =  (DefaultTableModel) purchaseTable.getModel();
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//        purchaseTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
//        
//       
//        model.setRowCount(0); //To clear mobileTable
//        
//        for(int i=0; i<list.size(); i++){
////            rowData[0] = list.get(i).getId();
//            rowData[0] = list.get(i).getPurId();
//            rowData[1] = list.get(i).getDate();
//            rowData[2] = list.get(i).getItemId();
//            rowData[3] = list.get(i).getItemName();
//            rowData[4] = list.get(i).getUnit();
//            rowData[5] = list.get(i).getQty();
//           
//            model.addRow(rowData);
//        }
//           

    }//GEN-LAST:event_purUpdateActionPerformed

    private void cmbItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbItemNameActionPerformed
         try {
            purDb.CompoItemName();
        } catch (SQLException ex) {
            Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbItemNameActionPerformed

    private void purchaseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseTableMouseClicked
        try {
            int selectedRow = purchaseTable.getSelectedRow();
            TableModel tm = purchaseTable.getModel();
            puId.setText(tm.getValueAt(selectedRow, 0).toString());
            Date cadate;
            
            cadate = new SimpleDateFormat("yyyy-MM-dd").parse(tm.getValueAt(selectedRow, 1).toString());
            puDate.setDate(cadate);
            
            iUnt.setSelectedItem(tm.getValueAt(selectedRow, 4).toString());
            itemId.setText(tm.getValueAt(selectedRow,2).toString());
            cmbItemName.setSelectedItem(tm.getValueAt(selectedRow, 3).toString());
            puQty.setText(tm.getValueAt(selectedRow, 5).toString());
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_purchaseTableMouseClicked

    private void purDeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purDeletActionPerformed
         purId =  puId.getText();
         quantity = Integer.parseInt(puQty.getText());
         itemid =Integer.parseInt( itemId.getText());
        System.out.println(quantity);
         
         try{
           con = MyConnection.getConnection();
       
            ps  = con.prepareStatement( "select quantity from item where id= "+itemId.getText() );
          
            rs= ps.executeQuery(); 
          
            int updatQty =0;
            if(rs.next() ){
                int currentqty ;
             
                currentqty= rs.getInt("quantity");
//                System.out.println(currentqty);
              
//                System.out.println(quantity);
                updatQty = currentqty - quantity;
//                System.out.println(updatQty);
//                purDb.updateItemQty( itemid, updatQty);
             

            }
            
                
       }catch(SQLException ex) {
            Logger.getLogger(Purchase12.class.getName()).log(Level.SEVERE, null, ex);
       
       }
         
//          purDb.delete(purId);
         
//          purDb.delete(purId);
         
         
         
           puId.setText("");
           puDate.setDate(new Date());
           cmbItemName.setSelectedIndex(0);
           itemId.setText("");
          
           iUnt.setSelectedIndex(0);
           puQty.setText("");
//         
//          ArrayList<purchase> list = purchaseDb.TableGenerator();
//        Object rowData[] = new Object[6];
//     //DefaultTableModel  model =  new DefaultTableModel (null, new Object[]{ "Full Name","Tin No", "Company Name"," Contact Person Name","Telephone No"," Address "});
//        DefaultTableModel model =  (DefaultTableModel) purchaseTable.getModel();
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//        purchaseTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
//        purchaseTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
//        
//       
//        model.setRowCount(0); //To clear mobileTable
//        
//        for(int i=0; i<list.size(); i++){
////            rowData[0] = list.get(i).getId();
//            rowData[0] = list.get(i).getPurId();
//            rowData[1] = list.get(i).getDate();
//            rowData[2] = list.get(i).getItemId();
//            rowData[3] = list.get(i).getItemName();
//            rowData[4] = list.get(i).getUnit();
//            rowData[5] = list.get(i).getQty();
//           
//            model.addRow(rowData);
//        }
//        
    }//GEN-LAST:event_purDeletActionPerformed

    private void puQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_puQtyKeyTyped
         char c = evt.getKeyChar();
        if(Character.isLetter(c)&&!evt.isAltDown()){
            evt.consume();
    }                
    }//GEN-LAST:event_puQtyKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cmbItemName;
    public static javax.swing.JComboBox<String> iUnt;
    public static javax.swing.JTextField itemId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser puDate;
    private javax.swing.JTextField puId;
    public static javax.swing.JTextField puQty;
    private javax.swing.JTextField puVat;
    private javax.swing.JButton purDelet;
    private javax.swing.JButton purUpdate;
    private javax.swing.JTable purchaseTable;
    private javax.swing.JButton purlAdd;
    // End of variables declaration//GEN-END:variables
}
