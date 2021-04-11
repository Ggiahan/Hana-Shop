/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblCategory;

/**
 *
 * @author DELL
 */
public class tblCategoryDTO {
    private int categoryid;
    private String categoryname;

    public tblCategoryDTO() {
    }

    public tblCategoryDTO(int categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

   
    
}
