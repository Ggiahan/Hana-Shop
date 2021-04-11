/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblOrderDetail;

/**
 *
 * @author DELL
 */
public class tblOrderDetailDTO {
    String orderDetailid;
    int orderid;
    String  productid;
    int quantity;

    public tblOrderDetailDTO(String orderDetailid, int orderid, String productid, int quantity) {
        this.orderDetailid = orderDetailid;
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
    }

    public tblOrderDetailDTO() {
    }

    public String getOrderDetailid() {
        return orderDetailid;
    }

    public void setOrderDetailid(String orderDetailid) {
        this.orderDetailid = orderDetailid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
