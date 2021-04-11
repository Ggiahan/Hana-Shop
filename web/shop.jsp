<%@page import="hanlg.tblProduct.tblProductDTO"%>
<%@page import="hanlg.tblCategory.tblCategoryDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Hana Shop - Shop</title>
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
                        <li class="nav-item active"><a class="nav-link" href="DispatchServlet?btAction=ShowProductOfCategory&category=All">Menu</a></li>  
                        <li class="nav-item"><a class="nav-link" href="cart.jsp"> <i class="fa fa-shopping-bag"></i>

                                My Cart</a></li>
                        <li class="nav-item"><a class="nav-link" href="checkout.jsp">Checkout</a></a></li>
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
                    <h2>Shop</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Shop</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                    <div class="right-product-box">
                        <div class="product-item-filter row">

                            <div class="pagination justify-content-xl-center mt-3 text-sm-right">

                                <%
                                    if (request.getAttribute("COUNT") != null) {
                                        String number = request.getAttribute("COUNT").toString();

                                        int count = Integer.parseInt(number);

                                        for (int i = 0; i < count; i++) {
                                %>
                                <form action="DispatchServlet">
                                    <a>
                                        <input type="hidden" name="category" value="<%= request.getAttribute("CATEGORY").toString()%>"/>
                                        <% if (request.getAttribute("txtSearch") == null) {%>


                                        <%} else {%> 
                                        <input type="hidden" name="txtSearch" value="<%=request.getAttribute("txtSearch").toString()%>"/>
                                        <%}%>

                                        <input type="hidden" name="page" value="<%=i + 1%>"/>
                                        <button class="btn-outline-success" style="size: 3" name="btAction" value="ShowProductOfCategory"  ><h4><%=i + 1%></h4> </button>
                                    </a>
                                </form> 
                                <%}
                                    }%> 




                            </div>

                        </div>
                        <!------------>
                        <div class="product-categorie-box">
                            <div class="tab-content">
                                <%
                                    List<tblProductDTO> DTOProduct = (List<tblProductDTO>) request.getAttribute("LISTPRODUCT");

                                    if (DTOProduct != null) {
                                %>         
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">
                                    <div class="row">
                                        <!--  show product -->
                                        <%
                                            for (tblProductDTO dto : DTOProduct) {
                                        %>
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <div class="type-lb">
                                                        <p class="new">New</p>
                                                    </div>
                                                    <img src="images/<%=dto.getImage()%>" class="img-fluid" alt="Image">
                                                    <div class="mask-icon">

                                                        <%
                                                            String urlRewriting = "DispatchServlet"
                                                                    + "?btAction=AddItemtoCart"
                                                                    + "&ProductName=" + dto.getProductname()
                                                                    + "&Price=" + dto.getPrice()
                                                                    + "&Quantity=" + dto.getQuantity()
                                                                    + "&Image=" + dto.getImage()
                                                                    + "&category=" + dto.getCategoryname() // +"&txtSearch="+request.getAttribute("txtSearch").toString()
                                                                    ;


                                                        %>
                                                        <a class="cart" href="<%=urlRewriting%>">Add to Cart</a>
                                                    </div>
                                                </div>
                                                <div class="why-text">

                                                    <h5><%=dto.getProductname()%></h5></br>
                                                    <h2 class="pagination justify-content-center mt-3"><strong>   <%=dto.getPrice().toString()%>$</strong></h2>
                                                    </br><h3><strong>Category:</strong><%=dto.getCategoryname()%></h3>
                                                    <p><%=dto.getDescription()%></p>


                                                </div>
                                            </div>
                                        </div>

                                        <%
                                            }
                                        %> 
                                        <!--  show product -->

                                    </div>
                                </div>
                                <%
                                    }
                                %> 

                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
  
                    <div class="product-categori">
                        <form action="DispatchServlet">
                        <div class="search-product">
                            
                                
                                <input class="form-control" placeholder="Search here..." type="text" name="txtSearch" value="">
                               
                                <input type="hidden" name="category" value="All"/>
                                <button type="submit" name="btAction" value="ShowProductOfCategory"> <i class="fa fa-search"></i> </button>
                           
                        </div>
                                  <div class="filter-price-left">

                                <div class="title-left">
                                    <h3>Price</h3>
                                </div>
                                FROM:
                                <div class="search-product">
                                    <input class="form-control" placeholder="Search here..." type="number" name="pricefrom" value="">
                                  
                                </div>
                                TO:
                                <div class="search-product">
                                    <input class="form-control" placeholder="Search here..." type="number" name="priceto" value="">
                                    <input type="hidden" name="category" value="All"/>
                                </div>
                            </div>
                                     </form>
                        <div class="filter-sidebar-left">
                            <%
                                List<tblCategoryDTO> result = (List<tblCategoryDTO>) session.getAttribute("LISTCATEGORY");
                                String CATEGORY = request.getAttribute("CATEGORY").toString();
                                if (result != null) {
                            %>
                            <div class="title-left">
                                <h3>Categories</h3>
                            </div>
                            <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men" data-children=".sub-men">

                                <%
                                    // int count = 0;
                                    for (tblCategoryDTO dto : result) {
                                        String getCategoryname = dto.getCategoryname();
                                        String urlRewriting = "DispatchServlet"
                                                + "?btAction=ShowProductOfCategory"
                                                + "&category=" + dto.getCategoryname();
                                        if (getCategoryname.equals(CATEGORY)) {
                                %>
                                <div class="list-group">                                   
                                    <a class="list-group-item list-group-item-action active" href="#sub-men1"
                                       data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1"><%= dto.getCategoryname()%> 

                                    </a>
                                </div>
                                <%
                                } else {
                                %> 
                                <div class="list-group-collapse sub-men" >

                                    <a href="<%= urlRewriting%>" class="list-group-item list-group-item-action "  ><%= dto.getCategoryname()%> 
                                        <input type="hidden" name="category" value="<%= dto.getCategoryname()%>"/>

                                    </a>

                                </div>
                                <%
                                        }

                                    }
                                    if (CATEGORY.equals("All")) {%>
                                <div class="list-group-collapse sub-men active" href="#sub-men1" data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">
                                    <a href="DispatchServlet?btAction=ShowProductOfCategory&txtSearch=&category=All" class="list-group-item list-group-item-action"> All

                                    </a>

                                </div>
                                <%} else {%>
                                <div class="list-group-collapse sub-men" >
                                    <a href="DispatchServlet?btAction=ShowProductOfCategory&txtSearch=&category=All" class="list-group-item list-group-item-action"> All

                                    </a>

                                </div>

                                <%}%>
                            </div>
                            <% }%> 

                           

                        </div>
                    </div>
                  


                </div>
            </div>
        </div>

    </div>
    <!-- End Shop Page -->

    <!-- End copyright  -->

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
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>