/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblOrderDetail;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class purchaseHistoryDTO {
    private String productname;
     private int  quantity;
      private float price;
     private String Address;
      private Date orderDate;

    public String getProductname() {
        return productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getAddress() {
        return Address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public purchaseHistoryDTO(String productname, int quantity, float price, String Address, Date orderDate) {
        this.productname = productname;
        this.quantity = quantity;
        this.price = price;
        this.Address = Address;
        this.orderDate = orderDate;
    }

    public purchaseHistoryDTO() {
    }
    
}
