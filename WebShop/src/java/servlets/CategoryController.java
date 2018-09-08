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
public class CategoryController extends HttpServlet {

    List<Product> listProducts = null;
    Session sesija = null;
    Transaction transaction = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();

                if (request.getParameter("category") == null || request.getParameter("category").equalsIgnoreCase("all")) {
                    Query query = sesija.createQuery("from Product as product");
                    listProducts = query.list();

                } else {
                    Query query = sesija.createQuery("from Product as product where product.category.id_category=" + Integer.parseInt(request.getParameter("category")));
                    listProducts = query.list();
                }

                int numberOfItems = listProducts.size();
                int numberOfPages = 1;
                if (numberOfItems > 8) {
                    numberOfPages = numberOfItems / 8 + 1;
                }

                int pageNumX = 0;
                if ((request.getParameter("pageNum")) == null && numberOfItems > 8) {
                  listProducts = listProducts.subList(0, 8);
               
                } else  if (!((request.getParameter("pageNum")) == null && numberOfItems <= 8)) {       
                    pageNumX = Integer.parseInt(request.getParameter("pageNum"));
                    if (pageNumX == 1) {
                       listProducts =  listProducts.subList(0, 8);
                    } else {
                        if(numberOfItems/pageNumX < 8){
                              listProducts =  listProducts.subList(pageNumX * 8 - 8, numberOfItems);
                        } else {
                       listProducts =  listProducts.subList(pageNumX * 8 - 8, pageNumX * 8 );
                        }
                    }
                }
                request.setAttribute("numberOfPages", numberOfPages);
                request.setAttribute("listProduct", listProducts);
                transaction.commit();
            } catch (HibernateException ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                sesija.flush();
                sesija.close();
                request.getRequestDispatcher("Index.jsp").forward(request, response);
            }
        }
    }

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
