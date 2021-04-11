/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import hanlg.tblProduct.tblProductDAO;
import hanlg.tblProduct.tblProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SearchProductManagerServlet extends HttpServlet {
 private final String SHOW_PRODUCT = "shop.jsp";
    private final String MANAGER_PRODUCT = "managerProduct.jsp";
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
        String url = MANAGER_PRODUCT;
        HttpSession session = request.getSession();
        int page;
        //  HttpSession session = request.getSession();

        String category = request.getParameter("category");
        String currentpagestr = request.getParameter("page");
       
       
        int currentpage;
        if(currentpagestr == null) 
        {currentpage =1;}
        else{currentpage= Integer.parseInt(currentpagestr);}
        
        //String password = request.getParameter("txtPassword");
        try {
            tblProductDAO dao = new tblProductDAO();
            if(category.equals("All")){
                
                 request.setAttribute("CATEGORY", "All");
                  
                 int count = dao.countAllProductnostatus();               
                  if(count%20==0 ){
                page = count/20;
            }
            else page = count/20+1;
              
            request.setAttribute("COUNT", page);
            if (count > 0) {
                 
                dao.LoadAllProductnostatus(currentpage);

            }}
            
            else{
            request.setAttribute("CATEGORY", category);
            int count = dao.countProductBaseCategorynostatus(category);
            
            if(count%20==0 ){
                page = count/20;
            }
            else page = count/20+1;
            request.setAttribute("COUNT", page);
           //request.setAttribute("txtSearch", null);
            if (count > 0) {
                 
                dao.LoadProductBaseCategorymanager(currentpage, category);
 }
            }
                List<tblProductDTO> listProduct = dao.getProductList();
                
                    request.setAttribute("LISTPRODUCT", listProduct);
                session.setAttribute("LISTPRODUCT", listProduct);

                
           
     
        } catch (SQLException ex) {
            log("SearchProductManagerServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("SearchProductManagerServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("SearchProductManagerServlet[ClassNotFoundException]=" + ex.getMessage());
        }finally {
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
         Logger.getLogger(SearchProductManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
         Logger.getLogger(SearchProductManagerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
