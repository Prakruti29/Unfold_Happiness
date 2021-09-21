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
    
    <li class="active"><a href="donate1.jsp">1 <span class="sr-only">(current)</span></a></li>
    <li ><a href="donate2.jsp">2 <span class="sr-only"></span></a></li>
    <li ><a href="donate3.jsp">3 <span class="sr-only"></span></a></li>
  </ul>
</nav>
</center>
    
    <section>
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-push-3">
           <center><h4 class="text-theme-colored font-weight-600 font-25"> DONATION DETAILS</h4></center>
            
            <form name="login-form" class="clearfix">
              <div class="form-group mb-20">
                      <label><strong>I Want to Donate:</strong></label>
                      <select name="items" class="form-control" required="true">
                      	<option></option>
                        <option value="food">Food</option>
                        <option value="clothes">Clothes</option>
                        <option value="toys">Toys</option>
                        <option value="furniture">Furniture</option>
                        <option value="others">Others</option>
                      </select>
                    </div>
                    <div class="row">
                <div class="form-group col-md-12">
                  <label><strong>Quantity</strong></label>
                  <input id="quantity" name="quantity" class="form-control" type="text" required="true">
                </div>
              </div>
              <label><strong>Pick up Date</strong></label>
              
              
    <div class="row">
        <div class='col-sm-12'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker3'>
                    <input type='text' class="form-control" name="date" />
                    <span class="input-group-addon">
                        <span class="fa fa-calendar mr-5"></span>
                    </span>
                </div>
            </div>
        </div>
        
    </div>

              
<label><strong>Pick up Time</strong></label>  

    <div class="row">
        <div class='col-sm-12'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" name="time"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>
                </div>
            </div>
        </div>
        
    </div>
 <div class="form-group mb-20">
                      <label><strong>Pick Up Area:</strong></label>
                      <select name="area" class="form-control">
                        <option value="Paldi">Paldi</option>
                        <option value="S.G.Highway">S.G.Highway</option>
                        <option value="Bopal">Bopal</option>
                        <option value="Sindhu Bhawan">Sindhu Bhawan</option>
                        <option value="Satellite">Satellite</option>
                      </select>
                    </div>
                 <div class="row">
                <div class="form-group col-md-12">
                  <label><strong>Address:</strong></label>
                  <input id="address" name="address" class="form-control" type="text">
                </div>
              </div>      
              
              <div class="clear text-center pt-10">
              <a class="btn btn-dark btn-lg btn-block no-border mt-15 mb-15" href="donate2.jsp" data-bg-color="darkorange">Make Request</a>
              <div class="clear text-center pt-10">
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