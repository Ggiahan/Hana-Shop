/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblOrder;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class tblOrderDTO {
    int orderid;
    String CustomerID;
    int Phonenumber;
    String  Email;
    String Address;
    Date  orderDate;
    float total;

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(int Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public tblOrderDTO(int orderid, String CustomerID, int Phonenumber, String Email, String Address, Date orderDate, float total) {
        this.orderid = orderid;
        this.CustomerID = CustomerID;
        this.Phonenumber = Phonenumber;
        this.Email = Email;
        this.Address = Address;
        this.orderDate = orderDate;
        this.total = total;
    }

    public tblOrderDTO() {
    }
}
