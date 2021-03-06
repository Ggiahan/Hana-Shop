/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.tblUser;

import hanlg.tblProduct.tblProductDAO;
import hanlg.tblProduct.tblProductDTO;
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
 * @author hanlg
 */
public class TblUserDAO implements Serializable {
    private List<TblUserDTO> User;
 public boolean InsertDB(String username, String fullname, String password, String email)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pst = null;
int role =2;
        int result = 0;
       
        try {
          con = DBhelpers.makeConnection();
            String sql = "INSERT INTO "
                    + "tblUser(username,fullname,password,email,role) VALUES "
                    + "(? , ? , ? , ? , ? )";

            pst = con.prepareStatement(sql);
             pst.setString(1, username);
            pst.setString(2, fullname);
             pst.setString(3, password);
            pst.setString(4, email);
            pst.setInt(5, role);
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
    public String checkLogin(String username, String password)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String fullname = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "SELECT fullname "
                        + "FROM tblUser "
                        + "WHERE username = ? AND password = ?";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement lu??n t???o ra 
                //object r???ng
                stm.setString(1, username);
                stm.setString(2, password);
                //4.Execute query
                rs = stm.executeQuery(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
                //m???ng ==> kh??ng bao gi??? = null
                if (rs.next()) {
                     fullname = rs.getString("fullname");
                    
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
        //bi???n l?? object ph???i kh???i t???i = null
        //s??? d???ng xong ph???i ????ng l???i
        return fullname;
    }

    public String checkUsername(String username)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String fullname = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "SELECT fullname "
                        + "FROM tblUser "
                        + "WHERE username = ? ";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement lu??n t???o ra 
                //object r???ng
                stm.setString(1, username);

                //4.Execute query
                rs = stm.executeQuery(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
                //m???ng ==> kh??ng bao gi??? = null
                if (rs.next()) {
                fullname = rs.getString("fullname");
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
        //bi???n l?? object ph???i kh???i t???i = null
        //s??? d???ng xong ph???i ????ng l???i
        return fullname;
    }
     public String selectUsername(String fullname)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String username = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "SELECT username "
                        + "FROM tblUser "
                        + "WHERE fullname = ?";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement lu??n t???o ra 
                //object r???ng
                stm.setString(1, fullname);

                //4.Execute query
                rs = stm.executeQuery(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
                //m???ng ==> kh??ng bao gi??? = null
                if (rs.next()) {
                username = rs.getString("username");
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
        //bi???n l?? object ph???i kh???i t???i = null
        //s??? d???ng xong ph???i ????ng l???i
        return username;
    }

     public String Checknameisactive(String fullname)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String username = null;
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "SELECT fullname "
                        + "FROM tblUser "
                        + "WHERE username =?";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement lu??n t???o ra 
                //object r???ng
                stm.setString(1, fullname);

                //4.Execute query
                rs = stm.executeQuery(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
                //m???ng ==> kh??ng bao gi??? = null
                if (rs.next()) {
                username = rs.getString("fullname");
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
        //bi???n l?? object ph???i kh???i t???i = null
        //s??? d???ng xong ph???i ????ng l???i
        return username;
    }

    public String checkAdmin(String username)
            throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String role = "FAILED";
        try {
            //1.Make connection
            con = DBhelpers.makeConnection();
            //2.Create SQL String
            if (con != null) {
                String sql = "select rolename "
                        + "from tblRole "
                        + "where roleid in "
                        + " (select role from tblUser where username = ? )";
                //3.Create statement
                stm = con.prepareStatement(sql); //prepareStatement lu??n t???o ra 
                //object r???ng
                stm.setString(1, username);

                //4.Execute query
                rs = stm.executeQuery(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
                //m???ng ==> kh??ng bao gi??? = null
                if (rs.next()) {
                    String admin = rs.getString("rolename");
                    if (admin.equals("Admin")) {
                        role = "ADMIN";
                    } else {
                        role = "USER";
                    }
                    return role;
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
        //bi???n l?? object ph???i kh???i t???i = null
        //s??? d???ng xong ph???i ????ng l???i
        return role;
    }

//    public boolean InsertDB(String username, String password, String fullname, boolean isAdmin)
//            throws SQLException, NamingException, ClassNotFoundException {
//        Connection cn = null;
//        PreparedStatement pst = null;
//        int result = 0;
//        // String ID = searchItemID(name);
//        try {
//            //1.Make connection
//            cn = DBhelpers.makeConnection();
//            //2.Create SQL String
//
//            String sql = "INSERT INTO "
//                    + "tblUsers(username ,password ,lastname, isAdmin ) VALUES "
//                    + "( ? , ? , ? , ? )";
//            //3.Create statement
//            pst = cn.prepareStatement(sql); //prepareStatement lu??n t???o ra 
//            pst.setString(1, username);
//            pst.setString(2, password);
//            pst.setString(3, fullname);
//            pst.setBoolean(4, isAdmin);
//            //4.Execute query
//            result = pst.executeUpdate(); //l?? con tr??? tr??? t???i 1 v??ng nh??? c???a
//            if (result != 0) {
//                return true;
//            }//m???ng ==> kh??ng bao gi??? = null
//
//            //end if connection is connected
//        } finally {
//            if (pst != null) {
//                pst.close();
//            }
//            if (cn != null) {
//                cn.close();
//            }
//        }
//        //bi???n l?? object ph???i kh???i t???i = null
//        //s??? d???ng xong ph???i ????ng l???i
//        return false;
//    }
}
