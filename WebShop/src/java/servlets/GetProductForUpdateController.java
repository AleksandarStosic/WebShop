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
import model.Product;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

public class GetProductForUpdateController extends HttpServlet {

   Product productForUpdate = null;
    Session sesija = null;
    Transaction transaction = null;
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                try {
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
        
                Query query = sesija.createQuery("from Product as product where product.id_product=" + Integer.parseInt(request.getParameter("id_product")));
             
                   productForUpdate = (Product)query.uniqueResult();
      
              request.setAttribute("productForUpdate", productForUpdate);
                transaction.commit();
                 
            } catch (HibernateException ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                sesija.flush();
                sesija.close();
               request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
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
