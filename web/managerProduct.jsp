<%@page import="hanlg.tblProduct.tblProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="hanlg.tblCategory.tblCategoryDTO"%>
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
        <title>Hana Shop - Admin Page</title>
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


                            <li class="nav-item active"><a class="nav-link" href="#"> 
                                    LIST PRODUCT</a></li>
                            <li class="nav-item"><a class="nav-link" href="createProduct.jsp">CREATE</a></a></li>
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
                    <div class="col-xl-9 col-lg-12 col-sm-12 col-xs-12 shop-content-right">
                        <div class="right-product-box">
                            <div class="product-item-filter row">
                                <form  action="DispatchServlet"> 

                                    <%
                                        List<tblCategoryDTO> result = (List<tblCategoryDTO>) session.getAttribute("LISTCATEGORY");
                                        String CATEGORY = request.getAttribute("CATEGORY").toString();
                                        if (result != null) {
                                    %>
                                    <span>CATEGORY </span>

                                    <div class="col-lg-12 col-sm-12 text-center text-sm-left">
                                        <div class="toolbar-sorter-right">
                                            <select name="category" class="selectpicker show-tick form-control" data-placeholder="$ USD">
                                                <% if (CATEGORY.equals("All")) {%>
                                                <option data-display="Select"selected="All">All </option>
                                                <%} else {%> 
                                                <option >All</option>
                                                <%}%>
                                                <%
                                                    // int count = 0;
                                                    for (tblCategoryDTO dto : result) {
                                                        String getCategoryname = dto.getCategoryname();

                                                        if (getCategoryname.equals(CATEGORY)) {
                                                %>
                                                <option data-display="Select" selected="<%= dto.getCategoryname()%>"><%= dto.getCategoryname()%></option>
                                                <%} else {%>   
                                                <option> <%= dto.getCategoryname()%></option>
                                                <%}
                                                    }
                                                %>
                                            </select>


                                            <%}%>
                                        </div>

                                    </div>

                                    <div class="mt-3 text-center text-sm-left">
                                        <div class="toolbar-sorter-right">
                                            <button type="submit" name="btAction" value="managersearch">Search</button>
                                        </div> 
                                    </div>
                                </form>
                                <div class="pagination justify-content-center mt-3">

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
                                            <input type="hidden" name="txtSearch"  value=""/> 

                                            <%} else {%> 
                                            <input type="hidden" name="txtSearch" value="<%=request.getAttribute("txtSearch").toString()%>"/>
                                            <%}%>

                                            <input type="hidden" name="page" value="<%=i + 1%>"/>
                                            <button name="btAction" value="managersearch"  ><%=i + 1%> </button>
                                        </a>
                                    </form> 
                                    <%}
                                        }%> 



                                </div>

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
                            List<tblProductDTO> DTOProduct = (List<tblProductDTO>) request.getAttribute("LISTPRODUCT");

                            if (DTOProduct != null) {

                        %>   
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Images</th>
                                    <th>Product Name</th>
                                    <th>Price</th>
                                    <th>category</th>
                                    <th>Create Date</th>
                                    <th>Status</th>
                                    <th>Edit</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>

                            <tbody> 

                            <form action="DispatchServlet">
                                <% for (tblProductDTO dto : DTOProduct) {%>

                                <tr>

                                    <td class="thumbnail-img">
                                        <a href="#">
                                            <img class="img-fluid" src="images/<%=dto.getImage()%>" alt="" />
                                        </a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#">
                                            <%=dto.getProductname()%>
                                        </a>
                                    </td>
                                    <td class="price-pr">
                                        <p><%=dto.getPrice()%></p>
                                    </td>
                                    <td class="quantity-box"><p><%=dto.getCategoryname()%></p>
                                    </td>
                                    <td class="total-pr">
                                        <p><%=dto.getCreatedate()%></p>
                                    </td>
                                    <td class="total-pr">
                                        <p><%=dto.getStatus()%></p>
                                    </td>

                                    <td>
                                        <%String url = "DispatchServlet?btAction=Update"
                                                    + "&productID=" + dto.getProductid()
                                                    + "&productname=" + dto.getProductname()
                                                    + "&category=" + dto.getCategoryname()
                                                    + "&price=" + dto.getPrice()
                                                    + "&quantity=" + dto.getQuantity()
                                                    + "&Discription=" + dto.getDescription()
                                                    + "&Status=" + dto.getStatus()
                                                    + "&image=" + dto.getImage()
                                                    + "&action=SendInfor";
                                        %>

                                        <a href="<%=url%>">Update</a>

                                    </td>

                                    <td class="add-to-btn">


                                        <input type="checkbox" name="chkDelete" value="<%=dto.getProductid()%>" />


                                    </td>

                                </tr>
                                <%}%>         

                                <tr>
                                    <td colspan="6">

                                    </td>
                                    <td colspan="2">


                                        <button class="btn btn-theme" type="submit"name="btAction" value="DeleteProduct">Delete Product</button>

                                    </td> 

                                </tr>

                            </form> 
                            </tbody>

                        </table>

                        <%}
                            if (DTOProduct == null) {
                        %>
                        <h2>THIS CATEGORY DOESN'T HAVE PRODUCTS </h2>
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
