/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblOrder;

import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblOrderDAO implements Serializable{
     public boolean InsertDB(int OrderID, String customername, int phonenunber, String Email,String Address, Date orderdate, float total)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;
        int result = 0;
        // String ID = searchItemID(name);
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String

            String sql = "INSERT INTO "
                    + "tblOrder(orderid,CustomerID,Phonenumber,Email,Address,orderDate,total) VALUES "
                    + "( ? , ? , ? , ? , ? , ? , ? )";
            //3.Create statement
            pst = con.prepareStatement(sql); //prepareStatement luôn tạo ra 
            pst.setInt(1, OrderID);
            pst.setString(2, customername);
             pst.setInt(3, phonenunber);
            pst.setString(4, Email);
             pst.setString(5, Address);
              pst.setDate(6, orderdate);
               pst.setFloat(7, total);
               
            //4.Execute query
            result = pst.executeUpdate(); //là con trỏ trỏ tới 1 vùng nhớ của
            if (result != 0) {
                return true;
            }//mảng ==> không bao giờ = null

            //end if connection is connected
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        //biến là object phải khởi tại = null
        //sử dụng xong phải đóng lại
        return false;
    }

  
    private List<tblOrderDTO> OrderList;

    public List<tblOrderDTO> getOrderList() {
        return OrderList;
    }

    public int SelectMaxID()
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int maxID = 1;
        try {
            //1.Make connection
           con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "SELECT orderid AS MAXID  "
                        + "FROM tblOrder "
                        + "WHERE orderid >= ALL(SELECT orderid FROM tblOrder)";
                
                stm = con.prepareStatement(sql); 
                

                
                rs = stm.executeQuery(); 
                if (rs.next()) {
                    maxID = rs.getInt("MAXID");
                    return maxID;
                }
            }
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
       
        return maxID;
    }
}
