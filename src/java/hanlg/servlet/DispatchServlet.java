/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class DispatchServlet extends HttpServlet {
private final String LOGIN_PAGE = "Login.jsp";
private final String LOGIN_COTROLLER ="LoginServlet";
private final String LOAD_MAIN_PAGE ="LoadProductServlet";
private final String LOGOUT_COTROLLER = "LogOutServlet";
private final String SHOW_PRODUCT = "ShowProductServlet";
private final String ADD_PRODUCT_TO_CART = "AddProducttoCartServlet";
private final String UPDATE_PRODUCT = "UpdateProductServlet";
private final String CREATE_PRODUCT = "CreateProductServlet";
private final String DELETE_PRODUCT = "RemoveProductServlet";
private final String REMOVE_OUT_OF_CART  = "DeleteProductoutofCartServlet";
private final String CHECK_OUT  = "CheckOutCartServlet";
private final String PURCHASE_HISTORY  = "PurchaseHistoryServlet";
private final String MANAGER_SEARCH  = "SearchProductManagerServlet";
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
       String url = LOGIN_PAGE;
       String button = request.getParameter("btAction");
        try  {
         if(button==null){
             
         }
         else if(button.equals("Login")){
             url = LOGIN_COTROLLER;
         }
           else if(button.equals("LoadAllproduct")){
             url = LOAD_MAIN_PAGE;
         }      
          else if(button.equals("Sign Out")){
             url = LOGOUT_COTROLLER;
         }      
        else if(button.equals("ShowProductOfCategory")){
             url = SHOW_PRODUCT;
         }  
          else if(button.equals("AddItemtoCart")){
             url = ADD_PRODUCT_TO_CART;
         }  
          else if(button.equals("Update")){
             url = UPDATE_PRODUCT;
         }  
           else if(button.equals("Create")){
             url = CREATE_PRODUCT;
         }  
         else if(button.equals("DeleteProduct")){
             url = DELETE_PRODUCT;
         }  
         else if(button.equals("RemoveProduct")){
             url = REMOVE_OUT_OF_CART;
         }  
         else if(button.equals("CheckOut")){
             url = CHECK_OUT;
         }  
         else if(button.equals("PurchaseHistory")){
             url = PURCHASE_HISTORY;
         }  
          else if(button.equals("managersearch")){
             url = MANAGER_SEARCH;
         }  
        }
        finally{
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
