/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;


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
public class LoginServlet extends HttpServlet {

    private final String LOAD_MAIN_PAGE = "LoadProductServlet";
    private final String INVALID_PAGE = "login.jsp";

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
        String url = INVALID_PAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        HttpSession session = request.getSession();
        TblUserDAO dao = new TblUserDAO();
        try {

            String result = dao.checkLogin(username, password);

            if (result != null) {
                String isadmin = dao.checkAdmin(username);
                if (isadmin.contains("ADMIN")) {
                
                    url = "DispatchServlet"
                            + "?btAction=managersearch"
                            + "&category=All"
                           ;
                    session.setAttribute("Fullname", result);
                    session.setAttribute("Username", username);
                    session.setAttribute("role", "ADMIN");

                }
                if (isadmin.contains("USER")) {
                    url = "DispatchServlet"
                            + "?btAction=LoadAllproduct"
                             + "&category=All";
                   
                    session.setAttribute("Fullname", result);
                     session.setAttribute("Username", username);
                    session.setAttribute("role", "USER");
                }
            }else{
                request.setAttribute("ERROR", "wrong username or wrong password!!!");
            }

        } catch (SQLException ex) {
            log("LoginServlet[SQLException]=" + ex.getMessage());
        } catch (NamingException ex) {
             log("LoginServlet[NamingException]=" + ex.getMessage());
            
        } catch (ClassNotFoundException ex) {
            log("LoginServlet[ClassNotFoundException]=" + ex.getMessage());
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
