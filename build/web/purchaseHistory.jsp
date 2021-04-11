<%@page import="hanlg.tblOrderDetail.purchaseHistoryDTO"%>
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
        <title>Hana Shop - Purchase History</title>
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
                                    <%} else {%>
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
                            <% } else if (session.getAttribute("email") != null) {
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
                            <li class="nav-item"><a class="nav-link" href="cart.jsp"> <i class="fa fa-shopping-bag"></i>

                                    My Cart</a></li>
                            <li class="nav-item"><a class="nav-link" href="checkout.jsp">Checkout</a></a></li>
                            <li class="nav-item active"><a class="nav-link" href="DispatchServlet?btAction=PurchaseHistory">Purchase history</a></a></li>
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

                        <ul class="breadcrumb">

                            <li class="breadcrumb-item active">View</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->
        <div class="shop-box-inner">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                        <div class="right-product-box">
                            <form action="DispatchServlet">
                                <div class="product-item-filter row">
                                    <div class="col-12 col-sm-6 text-center text-sm-left">
                                        Product name:
                                        <div class="search-product">

                                            <%if (request.getAttribute("txtproductname") == null) {%>

                                            <input class="form-control" placeholder="Search here..." type="text" name="txtproductname" value="${param.productname}">
                                            <%} else {%>
                                            <input class="form-control" placeholder="Search here..." type="text" name="txtproductname" value="${param.productname}">
                                            <%}%>
                                          


                                        </div>
                                    </div>
                                    <div class="mt-3 text-center text-sm-left">
                                        From date:
                                        <div class="search-product">

                                            <%if (request.getAttribute("datefrom") == null) {%>
                                            <input class="form-control" placeholder="Search here..." type="date" name="datefrom" value="${param.datefrom}">
                                            <%} else {%>
                                            <input class="form-control" placeholder="Search here..." type="date" name="datefrom" value="${param.datefrom}">
                                            <%}%>
                                           


                                        </div>

                                    </div>
                                    <div class="mt-3 text-center text-sm-left">
                                        To date:
                                        <div class="search-product">

                                            <%if (request.getAttribute("dateto") == null) {%>
                                            <input class="form-control" placeholder="Search here..." type="date"  name="dateto" value="">
                                            <%} else {%>
                                            <input class="form-control" placeholder="Search here..." type="date" name="dateto" value="${param.dateto}">

                                            <%}%>
                                            <input type="hidden" name="category" value="All"/>


                                        </div>
                                    </div>
                                    <div class="mt-3 text-center text-sm-left">
                                       
                                        <button type="submit" name="btAction" value="PurchaseHistory"<i class="fa fa-search"></i>Search</button>
                                      
                                    </div>
                                </div>
                            </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Start Cart  -->
<div class="cart-box-main">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-sm-6">
                <div class="table-main table-responsive">

                    <%
                        List<purchaseHistoryDTO> history = (List<purchaseHistoryDTO>) request.getAttribute("HISTORYLIST");

                        if (history != null) {

                    %>   
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Productname</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Order Date</th>
                                <th>Address</th>

                            </tr>
                        </thead>

                        <tbody> 

                        <form action="DispatchServlet">
                            <% for (purchaseHistoryDTO dto : history) {%>

                            <tr>

                                <td class="thumbnail-img ">
                                    <p><%=dto.getProductname()%></p>
                                <td class="name-pr">

                                    <p><%=dto.getQuantity()%></p>

                                </td>
                                <td class="price-pr">
                                    <p><%=dto.getPrice()%></p>
                                </td>
                                <td><p><%=dto.getOrderDate()%></p>
                                </td>
                                <td class="total-pr">
                                    <p><%=dto.getAddress()%></p>
                                </td>

                            </tr>
                            <%}%>         

                        </form> 
                        </tbody>

                    </table>

                    <%}
                        if (history == null) {
                    %>
                    
                    <%}%>
                </div>
            </div>
        </div>



    </div>
</div>
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
