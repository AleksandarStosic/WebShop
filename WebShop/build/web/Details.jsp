<%-- 
    Document   : details
    Created on : Aug 06, 2017, 13:12:27 AM
    Author     : Aleksandar Stosic/ita16.aleksandarstosic
--%>

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
	 
	   <h2> ${productForDetails.name}</h2>
	   
	   <div class="left">
	   <img src="images/${productForDetails.image}" alt="image" />
	  
	   </div>
	   <div class="right">
	   <h3> Description:</h3>
	   <p>  ${productForDetails.description}</p>
	   </div>
	 <div class="data"> 
	 <p>Author: ${productForDetails.author}</p><br>
	 <p>Price: ${productForDetails.price} EUR</p><br>
	 <p>In stock: ${productForDetails.quantity} pcs.</p><br>
           <% if((request.getSession().getAttribute("username")!=null)){
                      %>
         <form action="PutInBasketController" name="buy" onSubmit="return check(event);">
	  <input type="number" name="quantity"  placeholder="Quantity" />
           <input type="hidden" name="id_product" value="${productForDetails.id_product}"/>
          <button type="submit"> Put in basket </button>
         </form>
	 <%   }
                            %>
	 </div>
	 </div>
	<div class="bottom">
		<p>Design by Aleksandar Stosic/ita16.aleksandarstosic</p>
	</div>
</div>
    <script type="text/javascript">
function check(event){
 event.preventDefault();
  if(document.buy.quantity.value==="" || document.buy.quantity.value<1){
  alert("Enter correct quantity!!!");
	} else {
	document.buy.submit();
	}
}


</script>
</body>
</html>

