/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
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

public class AddProductController extends HttpServlet {

     Session sesija = null;
    Transaction transaction = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
            
              String barcode = request.getParameter("barcode");
                String q = "from Product as product where product.barcode = '" + barcode + "'";
                
             Query query = sesija.createQuery(q);
             List<Product> list = query.list();
                if(!list.isEmpty()){
                    out.print("You already have product with this barcode, update it.");
                     transaction.commit();
                 sesija.flush();
                sesija.close();
                }  else {
            
            
         try {
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
                Product p = new Product();
                p.setName(request.getParameter("name"));
                p.setPrice(Integer.parseInt(request.getParameter("price")));
                p.setBarcode(Integer.parseInt(request.getParameter("barcode")));
                p.setAuthor(request.getParameter("author"));
                p.setDescription(request.getParameter("description"));
                p.setImage(request.getParameter("image"));
                int id = Integer.parseInt(request.getParameter("category"));
                Category c = (Category) sesija.get(Category.class, id);
                p.setCategory(c);
                p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                
                sesija.save(p);

                transaction.commit();


            } catch (HibernateException ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                sesija.flush();
                sesija.close();
                request.getRequestDispatcher("AdminPage.html").forward(request, response);
            }
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
