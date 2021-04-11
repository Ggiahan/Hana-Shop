/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.tblCategory.tblCategoryDAO;
import hanlg.tblCategory.tblCategoryDTO;
import hanlg.tblOrderDetail.purchaseHistoryDTO;
import hanlg.tblOrderDetail.tblOrderDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class PurchaseHistoryServlet extends HttpServlet {

    private final String PurchaseHistory = "purchaseHistory.jsp";

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = PurchaseHistory;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("Username");
        String datefrom = (String) request.getParameter("datefrom");
        String dateto = (String) request.getParameter("dateto");
        String productname = request.getParameter("txtproductname");

        tblOrderDetailDAO dao = new tblOrderDetailDAO();
        try {
            if (username != null) {
                if (productname == null||productname =="") { // product null => date
                    if (datefrom != null && dateto != null&& datefrom != "" && dateto != "") {
                       
                        dao.Searchhistorybydate(username, datefrom, dateto);
                    } else {
                         dao.Searchallhistory(username);
                    }
                } else {
                    if (datefrom != "" && dateto != "") {
                        //search full
                        dao.SearchHistoryFullOption(username, Date.valueOf(datefrom), Date.valueOf(dateto), productname);

                    } else {
                        dao.Searchhistorybyproductname(username, productname);
                    }
                }
            }          
          List<purchaseHistoryDTO>historylist = dao.getHistory();
        request.setAttribute("HISTORYLIST", historylist);
        
        }catch (SQLException ex) {
            log("PurchaseHistoryServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("PurchaseHistoryServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("PurchaseHistoryServlet[ClassNotFoundException]=" + ex.getMessage());
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PurchaseHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PurchaseHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
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
