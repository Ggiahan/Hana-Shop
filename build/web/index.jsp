<%@page import="hanlg.tblCategory.tblCategoryDTO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Hana Shop - Home</title>
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
                            <li class="nav-item active"><a class="nav-link" href="DispatchServlet?btAction=LoadAllproduct">Home</a></li>                          
                                 <li class="nav-item"><a class="nav-link" href="DispatchServlet?btAction=ShowProductOfCategory&category=All">Menu</a></li>  
                            <li class="nav-item"><a class="nav-link" href="cart.jsp"> <i class="fa fa-shopping-bag"></i>
                                    
                                    My Cart</a></li>
                            <li class="nav-item"><a class="nav-link" href="checkout.jsp">Checkout</a></a></li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->

                    
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

        <!-- Start Slider -->
        <div id="slides-shop" class="cover-slides">
            <ul class="slides-container">
                <li class="text-center">
                    <img src="images/background.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Welcome To <br> Hana Shop</strong></h1>
                                <p class="m-b-40">If this is coffee, please bring me some tea
                                    <br>But if this is tea, please bring me some coffee.</p>
                                <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="text-center">
                    <img src="images/banner-02.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Welcome To <br> Hana Shop</strong></h1>
                                <p class="m-b-40">If this is coffee, please bring me some tea
                                    <br>But if this is tea, please bring me some coffee.</p>
                                <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="text-center">
                    <img src="images/banner-03.jpg" alt="">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <h1 class="m-b-20"><strong>Welcome To <br> Hana Shop</strong></h1>
                                <p class="m-b-40">If this is coffee, please bring me some tea
                                    <br>But if this is tea, please bring me some coffee.</p>
                                <p><a class="btn hvr-hover" href="#">Shop New</a></p>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="slides-navigation">
                <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
                <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
            </div>
        </div>
        <!-- End Slider -->

        <!-- Start Categories  -->
<%
            List<tblCategoryDTO> result = (List<tblCategoryDTO>) session.getAttribute("LISTCATEGORY");
            if (result != null) {
        %>
        <div class="categories-shop">
            <div class="container">
                <div class="row">
                    <%
                int count = 0;
                for (tblCategoryDTO dto : result) {
                    String urlRewriting = "DispatchServlet"
                                + "?btAction=ShowProductOfCategory"
                                + "&category=" + dto.getCategoryname()
                                ;
            %>
            
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                <form action="DispatchServlet">
                        <div class="shop-cat-box">
                            <img class="img-fluid" src="images/<%= dto.getCategoryname()%>.jpg" alt="" />
                            <a class="btn hvr-hover" href="<%=urlRewriting%>" value=" <%= dto.getCategoryname()%> "><%= dto.getCategoryname()%></a>                          
                        </div>
                    </form>     
                    </div>
           
                        <%
                }
            %> 
                </div>
            </div>
        </div>
                    <%
            }
        %>
        <!-- End Categories -->

      

       
       
       
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