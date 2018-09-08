/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Client;
import model.ItemInBasket;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

public class LoginController extends HttpServlet {

    HttpSession jsession = null;
    Client clientLogin = null;
    Session sesija = null;
    Transaction transaction = null;
List<ItemInBasket> itemsInBasket = new ArrayList<ItemInBasket>();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            try {
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
                Query query = sesija.createQuery("from Client as client where client.username='" + request.getParameter("username") + "'");
                if (!query.list().isEmpty()) {
                    clientLogin = (Client) query.uniqueResult();

                    if ((clientLogin.getPassword()).equalsIgnoreCase(request.getParameter("password"))) {
                        jsession = request.getSession();
                        jsession.setAttribute("username", clientLogin.getUsername());
if((clientLogin.getUsername()).equalsIgnoreCase("Admin")){
    request.getRequestDispatcher("AdminPage.html").forward(request, response);
}

                        jsession.setAttribute("basketList", itemsInBasket);
                        request.getRequestDispatcher("CategoryController").forward(request, response);

                    } else {
                        out.print("Wrong username or password...");
                    }
                    transaction.commit();
                } else {
                    out.print("Wrong username or password...");
                }
            } catch (HibernateException ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
                out.print("Wrong username or password...");
            } finally {
                sesija.flush();
                sesija.close();

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
