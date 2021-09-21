<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<!-- Mirrored from resources/form-login-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:22:30 GMT -->
<head>

<%@include file="core.jsp" %></head>
<body class="">
<div id="wrapper" class="clearfix">
  <!-- preloader -->
  <div id="preloader">
    <div id="spinner">
      <div class="preloader-dot-loading">
        <div class="cssload-loading"><i></i><i></i><i></i><i></i></div>
      </div>
    </div>
    <div id="disable-preloader" class="btn btn-default btn-sm">Disable Preloader</div>
  </div>
  
  <!-- Header -->
  
  <!-- Start main-content -->
  <div class="main-content">
    <!-- Section: inner-header -->
    
    <section class="inner-header divider parallax layer-overlay overlay-white-5" data-bg-img="resources/images/loginpage.jpeg">
      <div class="container" id="main" >
        <div class="row">
          <div class="col-md-6 col-md-push-2">
           <center><h4 class="text-theme-colored font-weight-600 font-25"> LOGIN</h4></center>
            <center><hr id="hr"></center>
          
            <form method="post" action="/unfoldhappiness_volunteer/volunteer/volloggingIn" modelAttribute="vollog" enctype="multipart/form-data">
              <div class="row" id="u1">
                <div class="form-group col-md-12">
                  <label for="form_username_email">Email</label>
                  <input id="email" name="email" class="form-control" type="text" path="email" />
                </div>
              </div>
              <div class="row" id="u1">
                <div class="form-group col-md-12">
                  <label for="form_password">Password</label>
                  <input type="password" id="password" name="password" class="form-control" type="text" path="password" />
                </div>
              </div>
               <%if(request.getParameter("errorMsg") != null){ %>
                                <div style="color: red;margin-left:70px"><%= request.getParameter("errorMsg") %></div>
                                <%} %>
              <div class="id1">
              	<a class="text-theme-colored font-weight-600 font-12" href="#">Forgot Your Password?</a>
                </div>
              
              
              
               <div class="clear text-center pt-10" id="u1">
              <button type="submit" class="btn btn-block btn-dark btn-theme-colored btn-sm mt-20 pt-10 pb-10">Login</button>
              
              </div>
              
              
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
  <!-- end main-content -->

  <!-- Footer -->
  <footer id="footer" class="footer bg-black-222">
      <div class="row mt-10">
        
        <%@include file="userfooter.jsp" %>
      </div>
    </div>
      </footer>
  
    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- end wrapper -->

<!-- Footer Scripts -->
<!-- JS | Custom script for all pages -->
<script src="/unfoldhappiness_volunteer/resources/js/custom.js"></script>

</body>
<style>
.id1
{
	text-align:right;
	position:relative;
	top:-10px;
	left:50px;
}
.l1
{
	position:absolute;
	top:700px;
	left:280px;
}
#main
{
	border:10;
	border-color:black;
	border-style:solid;
	background-color:white;
	height:600px;
	width:550px;
	position:relative;
	left:-10px;
}
#u1
{
	position:relative;
	top:2px;
	left:50px;
}
h4
{
	position:relative;
	top:-40px;
	left:50px;
}
hr
{
	position:relative;
	top:-45px;
	left:50px;
}
#reg
{
	position:relative;
	top:-40px;
	left:50px;
}
#bt
{
	position:relative;
	top:-35px;
}
</style>

<!-- Mirrored from resources/form-login-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:22:30 GMT -->
</html>