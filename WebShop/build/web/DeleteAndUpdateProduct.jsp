<%-- 
    Document   : deleteAndUpdate
    Created on : Aug 05, 2017, 7:47:24 PM
    Author     : Aleksandar Stosic
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="Stylesheet" type="text/css">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>DeleteAndUpdate</title>
    </head>
    <body>
        <div class="main">
	 <div class="top">
		 
		
	
		  <h1>EISBOOKS.COM</h1>
	 </div>
	 <div class="navigation">
		 <ul>
		 <li><a href="AddProduct.html">Adding </a></li>
		 <li><a href="DeleteAndUpdateProduct.jsp">Delete or update </a></li>
                  <li><a href="LogoutController">Exit</a></li>
		 </ul>
	 </div>
	  <div class="midle">
		
               <h3>Product List</h3>
 
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
           <th>Name</th>
           <th>Price</th>
          <th>Barcode</th>
          <th>Author</th>
          <th>Description</th>
          <th>Image</th>
          <th>Category</th>
         <th>Quantity</th>
           <th>Update</th>
          <th>Delete</th>
       </tr>

       <c:forEach items="${listProducts}" var="product" >
      <tr>
             <td>${product.id_product}</td>
               <td>${product.name}</td>
              <td>${product.price}</td>
            <td>${product.barcode}</td>
              <td>${product.author}</td>
             <td>${product.description}</td>
               <td>${product.image}</td>
             <td>${product.category.name}</td>
            <td>${product.quantity}</td>
              <td>
                <a href="GetProductForUpdateController?id_product=${product.id_product}">Update</a>
             </td>
             <td>
                <a href="DeleteProductController?id_product=${product.id_product}">Delete</a>
             </td>
          </tr>
       </c:forEach>

    </table>
		
	 </div>
	 <div class="bottom">
	 <p>Design by Aleksandar Stosic/ita16.aleksandarstosic</p>
	 </div>

</div>
     
    </body>
</html>
