/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */


public class UpdateProduct extends HttpServlet {

    Session sesija = null;
    Transaction transaction = null;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            try{
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
                int id = Integer.parseInt(request.getParameter("id_product"));
                Product updateProduct = (Product) sesija.get(Product.class, id);
                if(!request.getParameter("name").equalsIgnoreCase("")){
                    updateProduct.setName(request.getParameter("name"));
                }
                 if(!request.getParameter("price").equalsIgnoreCase("")){
                    updateProduct.setPrice(Integer.parseInt(request.getParameter("price")));
                }
                  if(!request.getParameter("barcode").equalsIgnoreCase("")){
                    updateProduct.setBarcode(Integer.parseInt(request.getParameter("barcode")));
                }
                   if(!request.getParameter("author").equalsIgnoreCase("")){
                    updateProduct.setAuthor(request.getParameter("author"));
                }
                    if(!request.getParameter("description").equalsIgnoreCase("")){
                    updateProduct.setDescription(request.getParameter("description"));
                }
                        if(!request.getParameter("category").equalsIgnoreCase("")){
                            Category categoryForUpdate = (Category) sesija.get(Category.class, Integer.parseInt(request.getParameter("category")));
                    updateProduct.setCategory(categoryForUpdate);
                }
                        if(!request.getParameter("image").equalsIgnoreCase("")){
                    updateProduct.setImage(request.getParameter("image"));
                }
        
                                if(!request.getParameter("quantity").equalsIgnoreCase("")){
                    updateProduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                }
                
               sesija.update(updateProduct);
                
                transaction.commit();
            }catch(HibernateException ex){
                if(transaction!=null){
                    transaction.rollback();
                }
            }finally{
                sesija.flush();
                sesija.close();
                response.sendRedirect("GetProductController");
            }
          
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
