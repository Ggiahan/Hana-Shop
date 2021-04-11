/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.cart.CartObject;
import hanlg.tblOrder.tblOrderDAO;
import hanlg.tblOrderDetail.tblOrderDetailDAO;
import hanlg.tblProduct.tblProductDAO;
import hanlg.tblProduct.tblProductDTO;
import hanlg.tblUser.TblUserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class CheckOutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String Email = request.getParameter("txtEmail");
        String fullname = request.getParameter("txtCustomername");
        String phonestr = request.getParameter("txtPhonenumber");
        String address = request.getParameter("txtAddress");
        String total = request.getParameter("totalOrder");
        String errorstr = null;
        int phoneNumber = Integer.parseInt(phonestr);
        String URL = "checkout.jsp";
        TblUserDAO userDAO = new TblUserDAO();
        try {boolean result = true;
            HttpSession session = request.getSession(false);
            if (session != null) {
                String islogin = (String) session.getAttribute("Fullname");
                if (islogin == null) {
                    String username = request.getParameter("txtUsername");
                    String password = request.getParameter("txtPassword");

                    String name = userDAO.Checknameisactive(username);
                    if (name == null) {
                        boolean insert = userDAO.InsertDB(username, fullname, password, Email);
                        session.setAttribute("Username", username);
                        session.setAttribute("Fullname", fullname);
                    }
                }
            }
            CartObject cart = (CartObject) session.getAttribute("CUSTCART");

            if (cart != null) {
                Map<String, Integer> items = cart.getProducts();

                if (items != null) {
                    long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    String Username = (String) session.getAttribute("Username");

                    tblOrderDAO Orderdao = new tblOrderDAO();
                    tblProductDAO Productdao = new tblProductDAO();
                    int nextIDOrder = Orderdao.SelectMaxID() + 1;
                    boolean AddOrder = Orderdao.InsertDB(nextIDOrder, Username, phoneNumber, Email, address, date, Float.valueOf(total));

                    if (AddOrder) {
                        tblOrderDetailDAO detailDao = new tblOrderDetailDAO();
                        
                        int count = 0;
                        List<tblProductDTO> DTOProduct = (List<tblProductDTO>) session.getAttribute("LISTPRODUCT");

                        for (String title : items.keySet()) {
                            for (tblProductDTO dto : DTOProduct) {
                                if (dto.getProductname().equals(title)) {
                                    int buy =items.get(title);
                                    
                                  int  quantitypro = Productdao. Checkquantity(dto.getProductid());
                                  
                                  if(quantitypro>buy){
                                         quantitypro= quantitypro-buy;
                                    count++;
                                    int nextIDDetailO = 0;
                                   String checkisactive = Productdao.CheckProductID(dto.getProductid());
                                   if(checkisactive!=null){
                                    String nextIDDetailOstr = "Order" + nextIDOrder + "-" + count;
                                   boolean setquantity = Productdao.updatequantity(dto.getProductid(), quantitypro, items.get(title));
                                    boolean subResult = detailDao.InsertDB(nextIDDetailOstr, nextIDOrder, items.get(title), dto.getProductid());
                                   
                                   }else{
                                       errorstr="The product is deactivated";
                                       result = false;
                                   }
                                  } else{ errorstr="quantity of products in stock is not enough";
                                  
                                      result = false;
                                  }
                                }
                            }
                        }
                        
                        if (result) {
                            session.removeAttribute("CUSTCART");
                            URL = "DispatchServlet"
                                    + "?btAction=LoadAllproduct";
                        }
                    }
                    request.setAttribute("ERROR", errorstr);

                }
            }//end if cart is not exited
        } catch (SQLException ex) {
            log("CheckOutServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("CheckOutServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("CheckOutServlet[ClassNotFoundException]=" + ex.getMessage());
        } finally {
            response.sendRedirect(URL);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
