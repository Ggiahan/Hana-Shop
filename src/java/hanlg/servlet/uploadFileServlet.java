/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanlg.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author DELL
 */
public class uploadFileServlet extends HttpServlet {

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
        try  {
             
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if(!isMultiPart){
            } else{
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try{
                    items = upload.parseRequest((RequestContext) request);
                    
                }catch(FileUploadException e){
                    e.printStackTrace();
                }
                Iterator iter = items.iterator();
                 Hashtable params = new Hashtable();
                 String fileName = null;
                 while(iter.hasNext()){
                     FileItem item = (FileItem) iter.next();
                     if(item.isFormField()){
                         params.put(item.getFieldName(), item.getString());
                     }else{
                         try{
                             String itemName = item.getName();
                             fileName = itemName.substring(itemName.lastIndexOf("\\")+1);
                             System.out.println("path" +fileName);
                             String RealPath = getServletContext().getRealPath("/")+"images\\"+fileName;
                             System.out.println("Rpath"+RealPath);
                             File savefile = new File(RealPath);
                             item.write(savefile);
            
                         }catch(Exception e){
                             e.printStackTrace();
                     }
                 }
                 
                        
          
           // request.setAttribute("productID", productID);
              
                 
                 
            }
               request.setAttribute("productID", productID);
                request.setAttribute("productname", productname);
                request.setAttribute("category", category);
                request.setAttribute("price", price);
                request.setAttribute("quantity", quantity);
                request.setAttribute("Discription", Discription);
                request.setAttribute("Status", Status);
              
                request.setAttribute("image", fileName);
     
            }
        }
        catch(Exception e){
                
                
        }
        finally{
             RequestDispatcher rd = request.getRequestDispatcher("createProduct.jsp");
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
