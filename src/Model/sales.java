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
public class sales {
    String salesId;
    String date;
    String customerName;
    int itemId;
    float qty;
    float price;
    float total;
    float amount;
    float vat;
    float totalAmount;
    String itemName;
    String unit;
    String trans;

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
  

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public float getQty() {
        return qty;
    }

    public void setQty(float qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
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
    
     public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
//    SELECT `salesId`, `date`, `customerName`, `itemId`, `quantiy`, `price`, `total`, `vat`, `totalAmount`, `itemName`, `unit` 

    public sales(String trans, String salesId, String date, String customerName, int itemId  , String itemName, String unit , float qty, float price, float total) {
         this.trans = trans;
        this.salesId = salesId;
        this.date = date;
        this.customerName = customerName;
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.itemName = itemName;
        this.unit = unit;
       
    }
    public sales(String salesId, String date, String customerName, int itemId, float qty, float price, float total, float amount,float vat, float totalAmount) {
        this.salesId = salesId;
        this.date = date;
        this.customerName = customerName;
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.vat = vat;
        this.totalAmount = totalAmount;
        this.amount= amount;
    }

    public sales(String salesId, String date, String customerName, int itemId , String itemName, String unit, float qty, float price, float total) {
        this.salesId = salesId;
        this.date = date;
        this.customerName = customerName;
        this.itemId = itemId;
        this.qty = qty;
        this.price = price;
        this.total = total;
                this.itemName = itemName;
        this.unit = unit;
    }
    
}
