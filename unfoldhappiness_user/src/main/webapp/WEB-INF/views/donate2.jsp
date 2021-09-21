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
   <center> <nav>
  <ul class="pagination theme-colored" id="n1">
    
    <li ><a href="#">1 <span class="sr-only">(current)</span></a></li>
    <li class="active"><a href="#">2 <span class="sr-only"></span></a></li>
   
  </ul>
</nav>
</center>
    <div class="main">
    <section>
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-push-3">
           
   
              <center><div class="form-group mb-20">
                     <strong> <p id="s1" name="s1">Your request has been sent to volunteer!!</p>
                      <p id="s1" name="s2">You will be notified when volunteer accepts your request!!</p> </strong> 
                    </div></center>
                                  
             <center> <div class="clear text-center pt-10" id="d1">
              <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="donate3.jsp" data-bg-color="darkorange">Cancel Request</a><div class="clear text-center pt-10">
              </div></center>
              
          
            
          </div>
        </div>
      </div>
    </section>
  </div>
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
<script src="/unfoldhappiness_user/resources/js/custom.js"></script>

</body>
<style>
#s1
{
	position:relative;
	top:50px;
	right:310px;
	font-size:15pt;
}
#d1
{
	position:relative;
	top:70px;
	right:310px;
	width:200px;
	
	
}
.main
{
	border:10;
	border-color:black;
	border-style:solid;
	height:500px;
	width:550px;
	position:relative;
	left:450px;
}
</style>
<script type="text/javascript">
            $(function () {
                $('#datetimepicker3').datetimepicker({
                    format: 'LT'
                });
            });
           
        </script>
        <!-- Mirrored from resources/form-login-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:22:30 GMT -->
</html>