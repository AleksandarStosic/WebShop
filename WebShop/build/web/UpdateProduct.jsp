<%-- 
    Document   : deleteAndUpdate
    Created on : Aug 05, 2017, 7:48:24 PM
    Author     : Aleksandar Stosic/ita16.aleksandarstosic
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/StyleUpdate.css" rel="Stylesheet" type="text/css">
        <title>Update</title>
    </head>
    <body>
        <div class="main">
	 <div class="top">
		 
		
	
		  <h1> EISBOOKS.COM</h1>
	 </div>
	 <div class="navigation">
		 <ul>
		 <li><a href="AddProduct.html">Adding </a></li>
		 <li><a href="DeleteAndUpdateProduct.jsp">Delete or update</a></li>
                  <li><a href="LogoutController">Exit</a></li>
		 </ul>
	 </div>
	  <div class="midle">
		
  
 
             <div class="reg">
		<h2 id="titleReg"> Product </h2>
                <form action="UpdateProduct" name="updateProduct" method="post"> 
                    <input type="hidden" name="id_product" value="${productForUpdate.id_product}"/><h3>Update Name</h3>
			<input type="text" name="name" placeholder="${productForUpdate.name}" size="30"/><h3>Update Price</h3>
			<input type="number" name="price" placeholder="${productForUpdate.price}" size="5"/><h3>Update Barcode</h3>
			<input type="number" name="barcode" placeholder="${productForUpdate.barcode}" size="3"/><h3>Update Author</h3>
			<input type="text" name="author" placeholder="${productForUpdate.author}" size="4"/><h3>Update Description</h3>
                        <input type="text" name="description" placeholder="${productForUpdate.description}" size="10"/><h3>Update Image</h3>
                          <input type="text" name="image" placeholder="${productForUpdate.image}" size="3"/>
			<span style="color:#CC6600; font-size:18px"> Category: </span>
                        <select name="category" >
                <option value="1"> Textbooks</option>
                <option value="2"> Kids' Books</option>
                <option value="3"> Teens' Books</option>
                <option value="4"> History Books</option>
                <option value="5"> Science Fiction & Fantasy Books</option>
				<option value="6"> Toys & Games</option>
				<option value="7"> Home & Gifts</option>
            </select><br>
			<br>
		<h3>Update Quantity</h3>
			<input type="number" name="quantity" placeholder="${productForUpdate.quantity}" size="2"/>
			<input type="submit" value="Update" style="height:30px; width:100px"/>
		</form>
		</div>
		
	 </div>
	 <div class="bottom">
	 <<p>Design by Aleksandar Stosic/ita16.aleksandarstosic</p>
	 </div>

</div>
     
    </body>
</html>
