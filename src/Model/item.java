/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author samrit
 */
public class item {
    int itemId;
    String itemName;
    String unit;
    float qtyperunit;
    float begQty;
    String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
   

    public float getBegQty() {
        return begQty;
    }

    public void setBegQty(float begQty) {
        this.begQty = begQty;
    }
    


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getQtyperunit() {
        return qtyperunit;
    }

    public void setQtyperunit(float qtyperunit) {
        this.qtyperunit = qtyperunit;
    }

    public item(int itemId,String itemName, String unit, float qtyperunit) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.qtyperunit = qtyperunit;
       
    }
    
    
}
