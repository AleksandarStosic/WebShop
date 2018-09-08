<%-- 
    Document   : index
    Created on : Aug 05, 2017, 6:15:25 PM
    Author     : Aleksandar Stosic/ita16.aleksandarstosic
--%>

<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title> Home </title>
        <link href="css/style.css" rel="Stylesheet" type="text/css">
        <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib  prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
    </head>
    <body>


        <div class="main">
            <div class="top">
                <div id="basket"> <% if ((request.getSession().getAttribute("username") != null)) {
                        %>
                    <a href="Basket.jsp"> <img src="images/basket.jpg" alt="image" /> </a>
                    
                    <%   }
                        %>
                </div>
                <div class="reg">
                    <form name="login" method="post" action="LoginController" onSubmit="return check(event);">
                        <% if ((request.getSession().getAttribute("username") == null)) {
                        %>
                        username: <input type="text" name="username"> <br>
                        password: <input type="password" name="password"><br>
                        <input type="submit" value="Login" style="width:100px">
                        <%   }
                        %>
                    </form>
                    <form name="logout" method="post" action="LogoutController">
                        <% if ((request.getSession().getAttribute("username") != null)) {
                        %>
                        <input type="submit" value="Logout" style="width:100px">
                        <%   }
                        %>
                    </form>
                    <% if ((request.getSession().getAttribute("username") == null)) {
                    %>
                    <a id="registration" href="Registration.html">Registration </a>
                    <%   }
                    %>
                </div>

                <h1> EISBOOKS.COM</h1>


            </div>
            <div class="navigation">
                <ul>
                    <li><a href="CategoryController">HOME</a></li>
                    <li><a href="AboutUs.html">ABOUT US</a></li>
                    <li><a href="Questions.html">QUESTIONS</a></li>
                    <li><a href="Contact.html">CONTACT</a></li>
                </ul>
            </div>
            <div class="midle">
                <div class="left"> 
                    <table class="categorys">
                        <th>Categories </th>
                        <db:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"  url="jdbc:mysql://localhost:3306/eisbooks"
    user="root" password="radiografija4" />
                        <db:query var="categoryResults" dataSource="${myDS}" sql="select * from category" />
                          <tr><td> <a href="CategoryController?category=all">Products</a> </td></tr>
                          <c:forEach items="${categoryResults.rows}" var="category" >
                               <tr><td> <a href="CategoryController?category=${category.id_category}"> ${category.name} </a> </td></tr>
                          </c:forEach>
                       
                 
                    </table>
                </div>

                <div class="right"> 

                    <c:forEach items="${listProduct}" var="product">
                        <div class="product">
                            <div class="image">
                                <img src="images/${product.image}" alt="pictures"/>
                            </div>
                            <p>Name: ${product.name} </p>
                            <p><a href="GetProductForDetailsController?id_product=${product.id_product}">Details</a></p>
                        </div>

                    </c:forEach> 

                </div>
            <div class="bottom">
                <c:forEach begin="1" end="${numberOfPages}" var="num">
                    <a href="CategoryController?pageNum=${num}"> | ${num} |</a> 
                </c:forEach>
              
                <p>Design by Aleksandar Stosic/ita16.aleksandarstosic</p>
            </div>

                </div>
              

            

        </div>

        <script type="text/javascript">
            function check(event) {
                event.preventDefault();
                if (document.login.username.value === "" || document.login.password.value === "") {
                    alert("Enter username and password!!!");
                } else {
                    document.login.submit();
                }
            }


        </script>
    </body>
</html>


