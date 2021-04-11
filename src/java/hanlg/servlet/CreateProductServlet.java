/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.tblProduct.tblProductDAO;
import hanlg.tblUser.TblUserDAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class CreateProductServlet extends HttpServlet {

    private final String CREATE_PAGE = "createProduct.jsp";
     private final String MANAGER_PAGE = "managerProduct.jsp";

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
        String url = CREATE_PAGE;
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
            String admin = (String) session.getAttribute("Username");
            tblProductDAO dao = new tblProductDAO();
            TblUserDAO userDAO = new TblUserDAO();
            String check = dao.CheckProductID(productID);
            if (check != null) {
                request.setAttribute("productID", productID);
                request.setAttribute("productname", productname);
                request.setAttribute("category", category);
                request.setAttribute("price", price);
                request.setAttribute("quantity", quantity);
                request.setAttribute("Discription", Discription);
                request.setAttribute("Status", Status);
                request.setAttribute("image", image);
                request.setAttribute("ERROR", "This username already exists");
            } else {

                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);

                boolean result = dao.InsertNewProduct(productID, productname, Integer.parseInt(category), Float.parseFloat(price), Integer.parseInt(quantity), image, Discription, Integer.parseInt(Status), date, admin);

           

                    url = "DispatchServlet"
                            + "?btAction=managersearch"
                            + "&category=All";
                

            }
        }catch (SQLException ex) {
            log("CreateProductServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("CreateProductServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("CreateProductServlet[ClassNotFoundException]=" + ex.getMessage());
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
