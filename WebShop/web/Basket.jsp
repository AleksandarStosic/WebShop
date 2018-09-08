<%-- 
    Document   : details
    Created on : Aug 06, 2017, 13:12:27 AM
    Author     : Aleksandar Stosic/ita16.aleksandarstosic
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title> Details </title>
<link href="css/styleBook.css" rel="Stylesheet" type="text/css">
</head>
<body>
<div class="main">
	 <div class="top">
	
	
		  <h1>EISBOOKS.COM</h1>
	
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
             <br/>
	    <h2> Basket:</h2>
	   <br/>
	  
	 <div class="data"> 
              <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Product</th>
           <th>Quantity</th>
        
       </tr>

                 <c:forEach items="${basketList}" var="item" >
      <tr>
             <td>${item.product.name} </td>
               <td>${item.quantity}</td>
              
             <td>
                <a href="DeleteFromBasketController?id_product=${item.product.id_product}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
     <br/>
     <a href="BuyController">BUY</a> 
	 </div>
	 </div>
	<div class="bottom">
		<p>Design by Aleksandar Stosic/ita16.aleksandarstosic</p>
	</div>
</div>
  
</body>
</html>

