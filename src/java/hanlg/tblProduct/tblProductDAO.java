/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblProduct;

import hanlg.tblCategory.tblCategoryDTO;
import hanlg.tblUser.TblUserDTO;
import hanlg.utilities.DBhelpers;
import java.io.Serializable;
import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.naming.NamingException;

/**
 *
 * @author DELL
 */
public class tblProductDAO implements Serializable {

    private List<tblProductDTO> productList;

    public List<tblProductDTO> getProductList() {
        return productList;
    }

    public void LoadProductBaseCategory(int pageNumber, String category)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =   ?  "
                    + "and statusname ='Active' "
                    + "and quantity >0 "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public void LoadProductBaseCategorymanager(int pageNumber, String category)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =   ?  "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseCategoryandproduct(String category, String product) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + "and quantity >0"
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ?"
                        + " and tblProduct.productname LIKE ? "
                        + " )";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, category);
                stm.setString(2, product);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseCategoryandproduct(int pageNumber, String category, String product)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =   ?  "
                    + "and statusname ='Active' "
                    + "and quantity >0 "
                    + " and tblProduct.productname LIKE ? "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);
            stm.setString(2, "%" + product + "%");
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseCategoryandPrice(String category, float fromprice, float toprice) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + " and quantity >0 "
                        + "and price>? "
                        + "and price<?"
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ?"
                        + " )";
                stm = con.prepareStatement(sqlStatement);
                stm.setFloat(1, fromprice);
                stm.setFloat(2, toprice);
                stm.setString(3, category);

                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseCategoryandPrice(int pageNumber, String category, float fromprice, float toprice)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =   ?  "
                    + "and statusname ='Active' "
                    + " and quantity >0 "
                    + "and price>? "
                    + "and price<?"
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);
            stm.setFloat(2, fromprice);
            stm.setFloat(3, toprice);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseproduct(String product) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + "and quantity >0 "
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + " where tblProduct.productname LIKE ? "
                        + " )";
                stm = con.prepareStatement(sqlStatement);

                stm.setString(1, product);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseproduct(int pageNumber, String product)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where statusname ='Active' "
                    + "and quantity >0 "
                    + " and tblProduct.productname LIKE ? "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);

            stm.setString(1, "%" + product + "%");
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBasePrice(float fromprice, float toprice) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status =1 "
                        + "and quantity >0 "
                        + " and price >= ? "
                        + " and price <= ?";

                stm = con.prepareStatement(sqlStatement);
                stm.setFloat(1, fromprice);
                stm.setFloat(2, toprice);

                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseCategoryandPrice(int pageNumber, float fromprice, float toprice)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where status =1 "
                    + " and quantity >0 "
                    + " and price >= ? "
                    + " and price <= ? "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setFloat(1, fromprice);
            stm.setFloat(2, toprice);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseCategoryandproductandPrice(String category, float fromprice, float toprice, String product) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + "and price>? "
                        + "and price<?"
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ?"
                        + " and tblProduct.productname LIKE ? "
                        + " )";
                stm = con.prepareStatement(sqlStatement);
                stm.setFloat(1, fromprice);
                stm.setFloat(2, toprice);
                stm.setString(3, category);
                stm.setString(4, product);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseCategoryandPriceandproduct(int pageNumber, float fromprice, float toprice, String category, String product)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =?  "
                    + "and statusname ='Active'"
                    + "and price>? "
                    + "and price<?"
                    + " and tblProduct.productname LIKE ? "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);

            stm.setFloat(2, fromprice);
            stm.setFloat(3, toprice);
            stm.setString(4, product);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseCategoryandstatus(String category, int status) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status =? "
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ?"
                        + " )";
                stm = con.prepareStatement(sqlStatement);

                stm.setInt(1, status);
                stm.setString(2, category);

                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadProductBaseCategoryandstatus(int pageNumber, String name, String Status, String category)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where tblCategory.categoryname =   ?  "
                    + "and statusname =?"
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);
            stm.setString(1, category);

            stm.setString(2, Status);
            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countProductBaseCategory(String category) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + " and quantity >0 "
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ? )";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, category);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public int countProductBaseCategorynostatus(String category) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where categoryid in "
                        + "(select categoryid "
                        + "from tblCategory "
                        + "where categoryname =  ? )";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, category);
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public int countProductBaseName(String name) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where productname LIKE ? "
                        + "and status = 1 ";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadAllProduct(int pageNumber)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "where statusname ='Active' "
                    + " and quantity >0 "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);

            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countAllProduct() throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where status ='1' "
                        + "and quantity >0 "
                        + "and categoryid in "
                        + "(select categoryid "
                        + "from tblCategory )";
                stm = con.prepareStatement(sqlStatement);

                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public void LoadAllProductnostatus(int pageNumber)
            throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        if (pageNumber - 1 < 0) {
            pageNumber = 1;
        }
        int p = (20 * (pageNumber - 1));
        DateFormat fortmat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            con = DBhelpers.makeConnection();
            // if (con != null) {
            String sqlStatement = "select productid, "
                    + "productname, categoryname,price,quantity,"
                    + "image,description,createdate,statusname "
                    + "from tblProduct "
                    + "left  JOIN tblCategory "
                    + "on tblProduct.categoryid = tblCategory.categoryid "
                    + "left JOIN tblStatus "
                    + "on tblProduct.status = tblStatus.statusid "
                    + "ORDER BY createdate, productid OFFSET " + p
                    + "ROWS FETCH NEXT 20 ROWS ONLY";
            stm = con.prepareStatement(sqlStatement);

            rs = stm.executeQuery();

            while (rs.next()) {
                String productid = rs.getString("productid");
                String productname = rs.getString("productname");
                String categoryname = rs.getString("categoryname");
                Float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                String description = rs.getString("description");
                String createdatestr = rs.getString("createdate");
                Date createdate = convertStringToDate(createdatestr);
                String status = rs.getString("statusname");
                tblProductDTO P = new tblProductDTO(productid, productname, categoryname, price, quantity, image, description, status, createdate, 0);
                if (this.productList == null) {
                    this.productList = new ArrayList<>();
                }
                this.productList.add(P);
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

    public int countAllProductnostatus() throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int count = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select count(productid) as count "
                        + "from tblProduct "
                        + "where categoryid in "
                        + "(select categoryid "
                        + "from tblCategory )";
                stm = con.prepareStatement(sqlStatement);

                rs = stm.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("count");
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
        return count;
    }

    public int getcategoryID(String category) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int categoryid = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select categoryid "
                        + "from tblCategory "
                        + "where categoryname = ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, category);
                rs = stm.executeQuery();
                while (rs.next()) {
                    categoryid = rs.getInt("categoryid");
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
        return categoryid;
    }

    public int getStatusID(String Status) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        int statusid = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select statusid "
                        + "from tblStatus "
                        + "where statusname = ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, Status);
                rs = stm.executeQuery();
                while (rs.next()) {
                    statusid = rs.getInt("statusid");
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
        return statusid;
    }

    public int Checkquantity(String name) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = true;
        int quantity = 0;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select quantity "
                        + "from tblProduct "
                        + "where productid = ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, name);
                rs = stm.executeQuery();
                while (rs.next()) {
                    quantity = rs.getInt("quantity");

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

        return quantity;
    }

    public String CheckProductID(String productID) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String productid = null;

        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select productname "
                        + "from tblProduct "
                        + "where productid = ?";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productid = rs.getString("productname");

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

        return productid;
    }

    public String CheckProductisActive(String productID) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String productid = null;

        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sqlStatement = "select productname "
                        + "from tblProduct "
                        + "where productid = ?"
                        + "and status =1 and quantity >0";
                stm = con.prepareStatement(sqlStatement);
                stm.setString(1, productID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    productid = rs.getString("productname");

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

        return productid;
    }

    public int SelectMaxID()
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int logid = 1;
        try {
            con = DBhelpers.makeConnection();
            if (con != null) {
                String sql = "SELECT logid AS MAXID  "
                        + "FROM tblLogUpdate "
                        + "WHERE logid >= ALL(SELECT logid FROM tblLogUpdate)";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                if (rs.next()) {
                    logid = rs.getInt("MAXID");

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
        return logid;
    }

    public boolean InsertNewProduct(String productid, String productname, int categoryid, float price, int quantity, String image, String description, int status, Date createdate, String Username)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblProduct(productid ,productname ,categoryid ,price ,quantity ,image ,description ,status ,createdate, discount,Creator ) VALUES "
                    + "(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

            stm = con.prepareStatement(sql);
            stm.setString(1, productid);
            stm.setString(2, productname);
            stm.setInt(3, categoryid);
            stm.setFloat(4, price);
            stm.setInt(5, quantity);
            stm.setString(6, image);
            stm.setString(7, description);
            stm.setInt(8, status);
            stm.setDate(9, (java.sql.Date) createdate);
            stm.setInt(10, 1);
            stm.setString(11, Username);

            result = stm.executeUpdate();
            if (result != 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean InsertLogUpdate(int logID, String productID, String Creator, Date updatedate)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int result = 0;
        try {
            con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblLogUpdate(logid, productid ,creator , updatedate) VALUES "
                    + "(? , ? , ? , ? )";

            stm = con.prepareStatement(sql);

            stm.setInt(1, logID);
            stm.setString(2, productID);
            stm.setString(3, Creator);
            stm.setDate(4, (java.sql.Date) updatedate);
            result = stm.executeUpdate();
            if (result != 0) {
                return true;
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean updateProduct(String productname, int categoryid, float price, int quantity, String description, int status, String productid)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            // 1. connection to db
            con = DBhelpers.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Update tblProduct "
                        + " Set productname =?,"
                        + " categoryid = ?, "
                        + " price =? , "
                        + " quantity =? , "
                        + " status=? , "
                        + " description=? "
                        + " WHERE productid= ?";
                //3. create statement
                stm = con.prepareStatement(sql);

                stm.setString(1, productname);
                stm.setInt(2, categoryid);
                stm.setFloat(3, price);
                stm.setInt(4, quantity);
                stm.setInt(5, status);
                stm.setString(6, description);
                stm.setString(7, productid);

                //4. excute query
                int row = stm.executeUpdate();
                //5. process result
                if (row > 0) {
                    return true;
                }//end while rs
            }//end 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updatestatus(String productID)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            // 1. connection to db
            con = DBhelpers.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Update tblProduct "
                        + " Set status=2 "
                        + " Where productid = ?";
                //3. create statement
                stm = con.prepareStatement(sql);
                stm.setString(1, productID);
                int row = stm.executeUpdate();
                //5. process result
                if (row > 0) {
                    return true;
                }//end while rs
            }//end 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updatequantity(String productID, int quantity, int buy)
            throws SQLException, ClassNotFoundException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            // 1. connection to db
            con = DBhelpers.makeConnection();
            if (con != null) {
                //2. create sql string
                String sql = "Update tblProduct "
                        + " Set quantity =?"
                        + " Where productid= ?";
                //3. create statement
                stm = con.prepareStatement(sql);
                stm.setInt(1, quantity);
                stm.setString(2, productID);
                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }//end while rs
            }//end 
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static Date convertStringToDate(String dateOfBirth) {
        Date result = null;
        try {
            result = new SimpleDateFormat("yyyy-mm-dd").parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String convertDateToString(Date DOB) {
        return new SimpleDateFormat("dd-mm-yyyy").format(DOB);
    }
}
