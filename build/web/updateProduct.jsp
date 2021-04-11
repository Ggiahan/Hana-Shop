<%@page import="hanlg.tblCategory.tblCategoryDTO"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Hana Shop - Update Product</title>
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
        <c:if test= "${empty sessionScope.role}">
<c:if test= "${sessionScope.role!='ADMIN'}">
            <c:redirect url="DispatchServlet?btAction=LoadAllproduct"/>
        </c:if>
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
                            <%}%>
                        </div>
                        <div class="text-slid-box">
                            <div id="offer-box" class="carouselTicker">
                                <ul class="offer-box">
                                    <li>

                                </ul>
                            </div>
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
                                                    
                            
                            <li class="nav-item active"><a class="nav-link" href="DispatchServlet?btAction=managersearch&category=All"> 
                                    LIST PRODUCT</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">CREATE</a></a></li>
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
                    <h2>Create New Product</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">lIST PRODUCT</a></li>
                        <li class="breadcrumb-item active"> CREATE </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Contact Us  -->
    <div class="contact-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-12">
                    <div class="contact-form-right">
                        <h2>Create New Product</h2>
                        <form action="DispatchServlet">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <p>
                                            <input type="hidden" name="productID" value="<%=request.getParameter("productID").toString()%>"/>

                                        <h3>Product ID: <strong><%=request.getParameter("productID").toString()%></strong></h3>
                                    </p>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <h3>Product name:</h3>
                                        <input type="text" class="createForm" id="name" value="<%=request.getParameter("productname").toString()%>" name="productname" placeholder="ProductName" required data-error="Please enter Product name"/>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="createForm">
                                        <p>
                                         <h3>Category</h3>
                                          <%
                                            List<tblCategoryDTO> result = (List<tblCategoryDTO>) session.getAttribute("LISTCATEGORY");
                                            if (result != null) {
                                        %>
                                        
                                         <select name="category">
                                             <%
                                                // int count = 0;
                                                String category = request.getParameter("category").toString();
                                                for (tblCategoryDTO dto : result) {
                                                    if(dto.getCategoryname().equals(category)){
                                            %>
                                            <option data-display="Select"><%= dto.getCategoryname()%></option>
                                            <%}else {%>
                                            <option><%= dto.getCategoryname()%></option>
                                             <%}}%>
                                        </select>
                                        <%}%>
                                       

                                    </p>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                         <h3>Price:</h3>
                                         <input type="text" class="createForm" id="price" name="price" placeholder="Price" value="<%=request.getParameter("price").toString()%>"required data-error="Please enter Price"/>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                 <div class="col-md-12">
                                    <div class="form-group">
                                        <h3>Quantity:</h3>
                                        <input type="number" class="createForm" id="quantity" name="quantity" placeholder="Quantity" value="<%=request.getParameter("quantity").toString()%>"required data-error="Please enter Quantity"/>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                 <div class="col-md-12">
                                    <div class="form-group">
                                        <h3>Status:</h3>
                                        <select name="Status">
                                            <option>Active</option>
                                             <option>Non-active</option>
                                        </select>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <h3>Product Discription: </h3>
                                        <textarea class="createForm" id="description" name="Discription"placeholder="Product Discription" rows="4"  data-error="Write Product Discription" required><%=request.getParameter("Discription").toString()%></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>  
                                         <div class="col-md-12">
                                    <div class="createForm">
                                        
                                            <input type="hidden" name="image" value="<%=request.getParameter("image").toString()%>"/>
                                            <img class="img-fluid" src="images/<%=request.getParameter("image").toString()%>" alt="" />
                                        
                                        <div class="help-block with-errors"></div>
                                    </div>
                            
                                    <div class="submit-button text-center">
                                        <input type="hidden" name="action" value="Update"/>
                                        <button class="btn hvr-hover" name="btAction" value="Update" type="submit">Submit</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
				<div class="col-lg-4 col-sm-12">
                    <div class="contact-info-left">
                        <h2>CONTACT INFO</h2>
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Cart -->

                
       
    <!-- End Instagram Feed  -->



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