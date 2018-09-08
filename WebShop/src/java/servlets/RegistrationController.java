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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

@WebServlet(name = "registrationController", urlPatterns = {"/registrationController"})
public class RegistrationController extends HttpServlet {

    Session sesija = null;
    Transaction transaction = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
     
               String username = request.getParameter("username");
                String q = "from Client as client where client.username = '" + username + "'";
                
             Query query = sesija.createQuery(q);
             List<Client> list = query.list();
                if(!list.isEmpty()){
                    out.print("Username already exists.Enter another username");
                     transaction.commit();
                 sesija.flush();
                sesija.close();
                }  else {
               

            try {
                sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
                transaction = sesija.beginTransaction();
                Client registrationClient = new Client();
                registrationClient.setFirstName(request.getParameter("firstName"));
                registrationClient.setLastName(request.getParameter("lastName"));
                registrationClient.setUsername(request.getParameter("username"));
                registrationClient.setPersonalNumber(request.getParameter("personalNumber"));
                registrationClient.setAddres(request.getParameter("address"));
                registrationClient.setEmail(request.getParameter("email"));
                registrationClient.setCity(request.getParameter("city"));
                registrationClient.setAccountNumber(request.getParameter("accountNumber"));
                registrationClient.setPhone(request.getParameter("phone"));
                registrationClient.setPassword(request.getParameter("password"));
                
          
   
                sesija.save(registrationClient);

                transaction.commit();


            } catch (HibernateException ex) {
                if (transaction != null) {
                    transaction.rollback();
                }
            } finally {
                sesija.flush();
                sesija.close();
                request.getRequestDispatcher("CategoryController").forward(request, response);
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
