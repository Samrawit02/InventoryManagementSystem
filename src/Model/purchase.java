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
public class purchase {
    String tranId;

   
    String purId;
    int itemId;
    String itemName;
    String unit;
    float qty;
    String date;

    
     public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }
    public String getPurId() {
        return purId;
    }

    public void setPurId(String purId) {
        this.purId = purId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public purchase( String tranId,String purId,String date, int itemId, String itemName, String unit, float qty) {
        this.purId = purId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.unit = unit;
        this.qty = qty;
        this.date = date;
        this.tranId = tranId;
    }
    public purchase(){
        
    }
}
