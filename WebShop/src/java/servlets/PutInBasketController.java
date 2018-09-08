/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ItemInBasket;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class PutInBasketController extends HttpServlet {

 Session sesija = null;
  Transaction transaction = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             int id_product = Integer.parseInt(request.getParameter("id_product"));
          int quantity =  Integer.parseInt(request.getParameter("quantity"));
try{
          sesija = hibernate.HibernateUtil.getSessionFactory().openSession();
          transaction = sesija.beginTransaction();
        Product productForBuy = (Product) sesija.get(Product.class, id_product);
        int quantityOfProductInStore = productForBuy.getQuantity();
        if(quantity > productForBuy.getQuantity()){
            out.print("There is no enough of product in our store!!!");
        } else {
            ItemInBasket itemInBasket = new ItemInBasket();
            itemInBasket.setProduct(productForBuy);
            itemInBasket.setQuantity(quantity);
        HttpSession session = request.getSession();
       List<ItemInBasket> itemsInBasket = (List<ItemInBasket>) session.getAttribute("basketList");
       itemsInBasket.add(itemInBasket);
       session.setAttribute("basketList", itemsInBasket);
       request.setAttribute("basketList", itemsInBasket);
       request.getRequestDispatcher("CategoryController").forward(request, response);
        }
          
           transaction.commit();
} catch(HibernateException ex){
    if(transaction!=null){
        transaction.rollback();
    }
}      finally {
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
