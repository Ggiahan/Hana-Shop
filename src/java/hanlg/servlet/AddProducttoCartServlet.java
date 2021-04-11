/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;


import hanlg.cart.CartObject;
import hanlg.tblProduct.tblProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class AddProducttoCartServlet extends HttpServlet {

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
      String url = "DispatchServlet"
                + "?btAction=ShowProductOfCategory"
                + "&category=All";
        try {  HttpSession session = request.getSession();
            //cust take cart
            CartObject cart = (CartObject) session.getAttribute("CUSTCART");
            if (cart == null) {
                cart = new CartObject();
            }//end if cart null
         
            String ProductName = request.getParameter("ProductName");
            String Price = request.getParameter("Price");
            String Quantity = request.getParameter("Quantity");
            String Image = request.getParameter("Image");
            String Discount = request.getParameter("Discount");           
            String category = request.getParameter("category");
           
            cart.AddItemToCart(ProductName);
             session.setAttribute("CUSTCART", cart);
            
           cart.setProductList(ProductName, Float.valueOf(Price), Integer.parseInt(Quantity), Image, 0);
            String currentpagestr = request.getParameter("page");  
  String txtSearch = request.getParameter("txtSearch"); 
 
          
     url = "DispatchServlet"
                + "?btAction=ShowProductOfCategory"
                + "&txtSearch=" +txtSearch
                + "&category="+ category
                + "&page=" +currentpagestr;

          
        } finally {
           // response.sendRedirect(url);
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
