<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  </nav>
</center>
    
    <section>
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-push-3">
           
           <center><div class="form-group mb-20">
                     <strong> <p id="s1">Your request has been accepted by Volunteer!!</p>
                      <p id="s1">Please be ready with the specified items.</p> 
                      <p id="s1">Volunteer is ready to serve at mentioned time and date.</p></strong>
                    </div></center>
           
           
               
            <form:form name="login-form" class="clearfix" modelAttribute="volunteer">
            <center><img alt="" src="/unfoldhappiness_user/resources/images/womansnip.JPG"></center>
                        <center> Name :
                        <form:input type="text" name="vol_name" path="vol_name" disabled="true"/></center>
                         <center>Mobile No :
                         <form:input type="text" name="mobileno" path="mobileno" disabled="true" value="7600063875"/></center>
                         
             
              <div class="clear text-center pt-10">
              <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="donate2.jsp" data-bg-color="darkorange">Cancel Request</a><div class="clear text-center pt-10">
              </div>
              
          </form:form>
            </div>
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
<script src="/unfoldhappiness_user/resources/js/custom.js"></script>

</body>
<style>
.id1
{
	text-align:right;
}
.l1
{
	position:absolute;
	top:390px;
	left:280px;
}
#n1
{
	text-align:center;
	
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