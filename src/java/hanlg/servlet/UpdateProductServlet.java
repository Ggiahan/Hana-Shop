/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.tblProduct.tblProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class UpdateProductServlet extends HttpServlet {

    private final String UPDATE_PAGE = "updateProduct.jsp";

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
            throws ServletException, IOException, NamingException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = UPDATE_PAGE;
        try {
            HttpSession session = request.getSession();
            String productID = request.getParameter("productID");
            String productname = request.getParameter("productname");
            String category = request.getParameter("category");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");
            String Discription = request.getParameter("Discription");
            String Status = request.getParameter("Status");
            String image = request.getParameter("image");
            String action = request.getParameter("action");
            String admin = (String) session.getAttribute("Username");
            if (action.equals("SendInfor")) {
                request.setAttribute("productID", productID);
                request.setAttribute("productname", productname);
                request.setAttribute("category", category);
                request.setAttribute("price", price);
                request.setAttribute("quantity", quantity);
                request.setAttribute("Discription", Discription);
                request.setAttribute("Status", Status);
                request.setAttribute("image", image);
            } else if (action.equals("Update")) {
                tblProductDAO dao = new tblProductDAO();
                int categoryid = dao.getcategoryID(category);
                if (categoryid > 0) {
                    int statusId = dao.getStatusID(Status);
                    if (statusId > 0) {
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        int logid = dao.SelectMaxID();
                                             boolean result = dao.updateProduct(productname, categoryid, Float.parseFloat(price), Integer.parseInt(quantity), Discription, statusId, productID);

                       boolean log = dao.InsertLogUpdate(dao.SelectMaxID()+1, productID, admin, date);



                        if (result) {

                         //   if (logid > 0) {
                                // boolean log = dao.InsertLogUpdate(logid, productID, admin, date);
                                if (log) {
                                    url = "DispatchServlet"
                                            + "?btAction=managersearch"
                                            + "&category=All";
                               // }
                            }
                        }

                    }
                }

            }

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
