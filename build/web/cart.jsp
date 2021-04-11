<%@page import="hanlg.tblProduct.tblProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="hanlg.cart.CartObject"%>
<%@page import="hanlg.cart.CartObject"%>
<!DOCTYPE html>
<html lang="en">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Hana Shop - Cart </title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/logo2.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

<script>
function myFunction() {
  var r = confirm("Are you want to remove this product from your cart?");
  if (r == true) {
    return true;
  } else {
   return false;
  }
  document.getElementById("demo").innerHTML = txt;
}
</script>

    <body>
        <c:if test= "${sessionScope.role=='ADMIN'}">
             <c:redirect url="DispatchServlet?btAction=managersearch&category=All"/>
        </c:if>
        <!-- Start Main Top -->
        <div class="main-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="our-link">
                            <ul>
                                <li>
                                    <%
                                        if (session.getAttribute("Fullname") != null) {
                                            String fullname = session.getAttribute("Fullname").toString();
                                    %>
                                    <a style="color: white"><i class="fa fa-user " ></i> WELCOME <%out.print(fullname);%></a>
                                    <%} else if (session.getAttribute("email") != null) {
                                            String email = session.getAttribute("email").toString();

                                    %>
                                    <a style="color: white"><i class="fa fa-user " ></i> WELCOME <%out.print(email);%></a>
                                    <%}else {%>
                                    <a href="login.jsp"><i class="fa fa-user s_color"></i> My Account</a>
                                    <%}%>
                                    
                                    
                                    
                                   
                                </li>
                                <!--
    <li><a href="#"><i class="fas fa-location-arrow"></i> Our location</a></li>
    <li><a href="#"><i class="fas fa-headset"></i> Contact Us</a></li>
                                -->
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="login-box">
                              <%
                                            if (session.getAttribute("Fullname") != null) {
                                        %>
                            <form action="DispatchServlet">
                                <button class="btn-danger" type="submit" value="Sign Out" name="btAction">Sign Out  </button>
                            </form>
                            <% }else if (session.getAttribute("email") != null) {
                                        %>
                            <form action="DispatchServlet">
                                <button class="btn-danger" type="submit" value="Sign Out" name="btAction">Sign Out  </button>
                            </form>
                            <%}%>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
        <!-- End Main Top -->

        <!-- Start Main Top -->
        <header class="main-header">
            <!-- Start Navigation -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
                <div class="container">
                    <!-- Start Header Navigation -->
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a class="navbar-brand" href="index.jsp"><img src="images/logo2.png" class="logo" alt=""></a>
                    </div>
                    <!-- End Header Navigation -->

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item "><a class="nav-link" href="DispatchServlet?btAction=LoadAllproduct">Home</a></li>                          
                                 <li class="nav-item"><a class="nav-link" href="DispatchServlet?btAction=ShowProductOfCategory&category=All">Menu</a></li>  
                            <li class="nav-item active"><a class="nav-link " href="cart.jsp"> <i class="fa fa-shopping-bag"></i>
                                    
                                    My Cart</a></li>
                            <li class="nav-item"><a class="nav-link" href="checkout.jsp">Checkout</a></a></li>
                            <li class="nav-item"><a class="nav-link" href="DispatchServlet?btAction=PurchaseHistory">Purchase history</a></a></li>
                        </ul>
                    </div>
                    <!-- End Side Menu -->
            </nav>
            <!-- End Navigation -->
        </header>
        <!-- End Main Top -->

        <!-- Start Top Search -->
        <div class="top-search">
            <div class="container">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i></span>
                    <input type="text" class="form-control" placeholder="Search">
                    <span class="input-group-addon close-search"><i class="fa fa-times"></i></span>
                </div>
            </div>
        </div>
        <!-- End Top Search -->

        <!-- Start All Title Box -->
        <div class="all-title-box">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Cart</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Shop</a></li>
                            <li class="breadcrumb-item active">Cart</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start Cart  -->
        <div class="cart-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="table-main table-responsive">
                            <% int total = 0;
                                
                                //1. Cust goes to his/here cart place
                                if (session != null) {
                                    //2. Cust takes his/her 
                                    CartObject cart = (CartObject) session.getAttribute("CUSTCART");
                                    if (cart != null) {
                                        //3. Cust get items
                                        Map<String, Integer> Products = cart.getProducts();
                                        List<tblProductDTO> DTOProduct = (List<tblProductDTO>) session.getAttribute("LISTPRODUCT");

                                        if (Products != null) {
                                            if (DTOProduct != null) {
                            %> 

                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Images</th>
                                        <th>Product Name</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th>Remove</th>
                                    </tr>
                                </thead>
                                <tbody>    
                                    <%
                                        for (String itemKey : Products.keySet()) {%>                                                

                                    <tr>
                                        <td class="thumbnail-img">
                                            <% for (tblProductDTO dto : DTOProduct) {
                                                    if (dto.getProductname().equals(itemKey)) {%>
                                            <a href="#">
                                                <img class="img-fluid"  src="images/<%=dto.getImage()%>" alt="" />
                                            </a>
                                            <%}
                                                }%>
                                        </td>
                                        <td class="name-pr">
                                            <%= itemKey%>
                                        </td>


                                        <td class="price-pr">
                                            <% for (tblProductDTO dto : DTOProduct) {
                                                    if (dto.getProductname().equals(itemKey)) {%>
                                            <%=dto.getPrice()%>

                                        </td>
                                <form action="EditQuantityServlet">
                                    <td class="quantity-box">
                                        <input type="number"  min="0" max="<%=dto.getQuantity()%>"name="quantity" value="<%= Products.get(itemKey)%>"/>
                                        <input type="hidden" name="productname" value="<%= itemKey%>"/>
                                </td>
                                </form>
                                <td class="total-pr">
                                    <%=Products.get(itemKey) * dto.getPrice()%>
                                    <% total += Products.get(itemKey) * dto.getPrice();%>
                                </td>
                                <%}
                                    }%>

                                <td class="remove-pr">

                                    <form action="DeleteProductoutofCartServlet">
                                        <input type="hidden" name="productremove" value="<%= itemKey%>"/>
                                        <input value="Remove Product" onclick="myFunction()"type="submit" name="btAction"/>

                                    </form>

                                </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                            <%}}%>
                        </div>
                    </div>
                </div>

                <div class="row my-5">

                    
                </div>

                <div class="row my-5">
                    <div class="col-lg-8 col-sm-12"></div>
                    <div class="col-lg-4 col-sm-12">
                        <div class="order-box">
                            <h3>Order summary</h3>
                            <div class="d-flex">
                                <h4>Sub Total</h4>
                                <div class="ml-auto font-weight-bold"><%=total%> </div>
                            </div>
                            <div class="d-flex">
                                <h4>Discount</h4>
                                <div class="ml-auto font-weight-bold"> $0</div>
                            </div>
                            <hr class="my-1">


                            <div class="d-flex">
                                <h4>Shipping Cost</h4>
                                <div class="ml-auto font-weight-bold"> <%int ship = 2;%>
                                    $<%=ship%>
                                </div>
                            </div>
                            <hr>
                            <div class="d-flex gr-total">
                                <h5>Grand Total</h5>
                                <div class="ml-auto h5"> $<%=total + ship%></div>
                            </div>
                            <hr> </div>
                    </div>
                    <div class="col-12 d-flex shopping-box"><a href="checkout.jsp" class="ml-auto btn hvr-hover">Checkout</a> </div>
                </div>

            </div>
        </div>
        <%}
            if (cart==null) {
 

%>
        <h2>Not Item in your Cart</h2>
        <%
            }}%>
        <!-- End Cart -->


        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

        <!-- ALL JS FILES -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- ALL PLUGINS -->
        <script src="js/jquery.superslides.min.js"></script>
        <script src="js/bootstrap-select.js"></script>
        <script src="js/inewsticker.js"></script>
        <script src="js/bootsnav.js."></script>
        <script src="js/images-loded.min.js"></script>
        <script src="js/isotope.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/baguetteBox.min.js"></script>
        <script src="js/form-validator.min.js"></script>
        <script src="js/contact-form-script.js"></script>
        <script src="js/custom.js"></script>
    </body>

</html>
