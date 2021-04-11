/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblProduct;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class tblProductDTO {
    private String productid;
    private String productname;
    private String categoryname;
    private Float price;
    private int quantity;
    private String image;
    private String description;
    private String status;
    private Date Createdate;
    private int discount;
 

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return Createdate;
    }

    public void setCreatedate(Date Createdate) {
        this.Createdate = Createdate;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public tblProductDTO(String productid, String productname, String categoryname, Float price, int quantity, String image, String description, String status, Date Createdate, int discount) {
        this.productid = productid;
        this.productname = productname;
        this.categoryname = categoryname;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
        this.status = status;
        this.Createdate = Createdate;
        this.discount = discount;
    }
 public tblProductDTO( String productname, Float price, int quantity, String image, int discount) {
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.discount = discount;
    }
    public tblProductDTO() {
    }
    
    
}
