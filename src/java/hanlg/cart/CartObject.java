/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.cart;

import hanlg.tblProduct.tblProductDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class CartObject implements Serializable {

    Map<String, Integer> Products;
   List<tblProductDTO> productList;

    public List<tblProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(String ProductName ,Float Price, Integer Quantity, String Image, int discount ) {
      tblProductDTO product = new tblProductDTO(ProductName, Price, Quantity, Image, discount);
        this.productList.add((tblProductDTO) product);
    }

    public Map<String, Integer> getProducts() {
        return Products;
    }
 
    public void AddItemToCart(String title) {
        if (this.Products == null) {
            this.Products = new HashMap<>();
        }
        int quantity = 1;
        if (this.Products.containsKey(title)) {
            quantity = this.Products.get(title) + 1;
        }
        this.Products.put(title, quantity);
    }

    public void EditQuantityOfItem(String title, int quantity) {
        if (quantity == 0) {
            RemoveItemFromCart(title);
        } //int quantity = 1;
        else if (this.Products.containsKey(title)) {
            this.Products.remove(title);
            this.Products.put(title, quantity);
        }
//            //quantity = this.items.get(title) + 1;
//        }

    }

    public void RemoveItemFromCart(String title) {
        if (this.Products == null) {
            return;
        }
        if (this.Products.containsKey(title)) {
            this.Products.remove(title);
            if (this.Products.isEmpty()) {
                this.Products = null;
            }
        }
    }
}
