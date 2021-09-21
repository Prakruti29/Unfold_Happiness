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
  <%@include file="userheader.jsp" %>
  <!-- Start main-content -->
  <div class="main-content">
    <!-- Section: inner-header -->
    
    <section class="inner-header divider parallax layer-overlay overlay-white-5" data-bg-img="/unfoldhappiness_volunteer/resources/images/loginpage.jpeg">
      <div class="container" id="main" >
        <div class="row">
          <div class="col-md-6 col-md-push-2">
           <center><h4 class="text-theme-colored font-weight-600 font-25"> LOGIN</h4></center>
            <center><hr id="hr"></center>
           <center> <p id="reg">New Partner?  &nbsp;&nbsp;&nbsp;<a href="ngoregister.jsp" class="text-theme-colored font-weight-600 font-14">REGISTER</a></p></center>
            <form name="login-form" class="clearfix">
              <div class="row" id="u1">
                <div class="form-group col-md-12">
                  <label for="form_username_email">Email</label>
                  <input id="email" name="email" class="form-control" type="text">
                </div>
              </div>
              <div class="row" id="u1">
                <div class="form-group col-md-12">
                  <label for="form_password">Password</label>
                  <input type="password" id="password" name="password" class="form-control" type="text">
                </div>
              </div>
              <div class="id1">
              	<a class="text-theme-colored font-weight-600 font-12" href="#">Forgot Your Password?</a>
                </div>
              
              
              
              <div class="clear text-center pt-10" id="u1">
              <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="#" data-bg-color="darkorange">Login</a><div class="clear text-center pt-10">
              </div>
              
               <label class="l1">OR</label>
             
              <div class="clear text-center pt-10" id="bt">
                <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="#" data-bg-color="#3b5998">Login with facebook</a>
                <a class="btn btn-dark btn-lg btn-block no-border" href="#" data-bg-color="#00acee">Login with Google</a>
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