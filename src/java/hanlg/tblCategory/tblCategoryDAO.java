/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblCategory;

import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblCategoryDAO implements Serializable{
    private List<tblCategoryDTO> categoryList;

    public List<tblCategoryDTO> getCategoryList() {
        return categoryList;
    }
    
    public void GetAllItem()
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        // String Name = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "Select categoryid, categoryname "
                        + "from tblCategory";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement luôn tạo ra 
                //object rỗng

                //4.Execute query
                rs = stm.executeQuery(); //là con trỏ trỏ tới 1 vùng nhớ của
                //mảng ==> không bao giờ = null
                while (rs.next()) {                    
                    int categoryid = rs.getInt("categoryid");
                    String categoryname = rs.getString("categoryname");
                    tblCategoryDTO dto = new tblCategoryDTO(categoryid, categoryname);
                 
                    if(this.categoryList == null){
                        this.categoryList= new ArrayList<>();
                    }
                    this.categoryList.add(dto);
                }
            }//end if connection is connected
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
