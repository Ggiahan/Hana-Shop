/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblOrderDetail;

import hanlg.tblOrder.tblOrderDAO;
import hanlg.tblOrder.tblOrderDTO;
import hanlg.tblProduct.tblProductDAO;
import static hanlg.tblProduct.tblProductDAO.convertStringToDate;
import hanlg.tblProduct.tblProductDTO;
import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblOrderDetailDAO implements Serializable {

    public boolean InsertDB(String OrderDetailID, int OrderID, int Quantity, String productid)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;

        int result = 0;

        try {
            con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblOrderDetail(orderDetailid,orderid,productid,quantity) VALUES "
                    + "(? , ? , ? , ? )";

            pst = con.prepareStatement(sql);

            pst.setString(1, OrderDetailID);
            pst.setInt(2, OrderID);
            pst.setString(3, productid);
            pst.setInt(4, Quantity);
            result = pst.executeUpdate();
            if (result != 0) {
                return true;
            }

        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public String searchItemID(String name)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String ItemID = null;

        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sql = "Select ItemID "
                        + "from tblItem "
                        + "where Name = ' ? ' ";

                stm = con.prepareStatement(sql);
                stm.setString(1, name);

                rs = stm.executeQuery();

                while (rs.next()) {
                    ItemID = rs.getString("ItemID");
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
        return ItemID;
    }
    private List<tblOrderDTO> OrderList;
 private List<purchaseHistoryDTO> History;

    public List<purchaseHistoryDTO> getHistory() {
        return History;
    }
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
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sql = "SELECT orderDetailid AS MAXID  "
                        + "FROM tblOrderDetail "
                        + "WHERE orderDetailid >= ALL(SELECT orderDetailid FROM tblOrderDetail)";

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

    public void Searchhistorybydate( String username,String fromdate, String todate )
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productname, price, tblOrderDetail.quantity,orderDate,Address "
                    + "from tblOrderDetail "
                    + "left   JOIN tblOrder "
                    + "on tblOrder.orderid = tblOrderDetail.orderid "
                    + "left JOIN tblProduct "
                    + "on tblProduct.productid = tblOrderDetail.productid "
                    + "where tblOrder.CustomerID=?" 
                    + " and orderDate > ?"
                    + " and orderDate < ?"
                    + " ORDER BY orderDate";
            stm = con.prepareStatement(sqlStatement);
             stm.setString(1, username);
            stm.setString(2, fromdate);
            stm.setString(3, todate);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productname = rs.getString("productname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                Date createdate = rs.getDate("orderDate");
               
                String Address = rs.getString("Address");
                
             purchaseHistoryDTO P = new purchaseHistoryDTO(productname, quantity, price, Address, createdate);
                if (this.History == null) {
                    this.History = new ArrayList<>();
                }
                this.History.add(P);
            }

            //  }
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
    
      public void Searchhistorybyproductname( String username, String name )
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productname, price, tblOrderDetail.quantity,orderDate,Address "
                    + "from tblOrderDetail "
                    + "left   JOIN tblOrder "
                    + "on tblOrder.orderid = tblOrderDetail.orderid "
                    + "left JOIN tblProduct "
                    + "on tblProduct.productid = tblOrderDetail.productid "
                    + "where tblOrder.CustomerID = ?"
                    + " and productname like ? "
                    + "ORDER BY orderDate ";
            stm = con.prepareStatement(sqlStatement);
             stm.setString(1, username);
            stm.setString(2,"%"+ name+"%" );
           
            rs = stm.executeQuery();

            while (rs.next()) {
                String productname = rs.getString("productname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                Date createdate = rs.getDate("orderDate");
               
                String Address = rs.getString("Address");
                
             purchaseHistoryDTO P = new purchaseHistoryDTO(productname, quantity, price, Address, createdate);
                if (this.History == null) {
                    this.History = new ArrayList<>();
                }
                this.History.add(P);
            }

            //  }
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
      public void Searchallhistory( String username )
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productname, price, tblOrderDetail.quantity,orderDate,Address "
                    + "from tblOrderDetail "
                    + "left   JOIN tblOrder "
                    + "on tblOrder.orderid = tblOrderDetail.orderid "
                    + "left JOIN tblProduct "
                    + "on tblProduct.productid = tblOrderDetail.productid "
                    + " where tblOrder.CustomerID=?" 
                      + "ORDER BY orderDate";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, username);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productname = rs.getString("productname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                Date createdate = rs.getDate("orderDate");
               
                String Address = rs.getString("Address");
                
             purchaseHistoryDTO P = new purchaseHistoryDTO(productname, quantity, price, Address, createdate);
                if (this.History == null) {
                    this.History = new ArrayList<>();
                }
                this.History.add(P);
            }

            //  }
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
      
      public void SearchHistoryFullOption( String username,Date fromdate, Date todate, String name )
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productname, price, tblOrderDetail.quantity,orderDate,Address "
                    + "from tblOrderDetail "
                    + "left   JOIN tblOrder "
                    + "on tblOrder.orderid = tblOrderDetail.orderid "
                    + "left JOIN tblProduct "
                    + "on tblProduct.productid = tblOrderDetail.productid "
                    + "where tblOrder.CustomerID=? "
                    + "and productname like ? "
                    + "and orderDate>?" 
                    + "and orderDate<?" ;
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, username);
            stm.setString(2, name);
            stm.setDate(3, fromdate);
            stm.setDate(4, todate);
            
            rs = stm.executeQuery();

            while (rs.next()) {
                String productname = rs.getString("productname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                Date createdate = rs.getDate("orderDate");
               
                String Address = rs.getString("Address");
                
             purchaseHistoryDTO P = new purchaseHistoryDTO(productname, quantity, price, Address, createdate);
                if (this.History == null) {
                    this.History = new ArrayList<>();
                }
                this.History.add(P);
            }

            //  }
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
