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
  <ul class="pagination theme-colored" id="n1">
    
    <li class="active"><a href="donate1.jsp">1 <span class="sr-only">(current)</span></a></li>
    <li ><a href="donate2.jsp">2 <span class="sr-only"></span></a></li>
    
  </ul>
</nav>
</center>
    
    <section>
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-push-3">
           <center><h4 class="text-theme-colored font-weight-600 font-25"> DONATION DETAILS</h4></center>
            
            <form:form name="login-form" class="clearfix" modelAttribute="donate">
            <form:hidden path="id" name="id" />
              <div class="form-group mb-20">
                      <label><strong>I Want to Donate:</strong></label>
                      <form:select name="donation_type" class="form-control" required="true" path="donation_type" id="mySelect">
                      <form:option value="Food">Food</form:option>
                         <form:option value="Clothes">Clothes</form:option>
                          <form:option value="Furniture">Furniture</form:option>
                          <form:option value="Toys">Toys</form:option>
                          <form:option value="Others">Others</form:option>
                         </form:select>
                    </div>
                    <div class="row">
                <div class="form-group col-md-12">
                  <label><strong>Quantity</strong></label>
                  <form:input id="quantity" name="donation_qty" class="form-control required" type="text" required="true" path="donation_qty" pattern="[0-9]{1,}"/>
                </div>
              </div>
              <label><strong>Pick up Date</strong></label>
              
              
    <div class="row">
        <div class='col-sm-12'>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker2'>
                    <form:input type='date' class="form-control required" name="donation_date" path="donation_date" required="true"/>
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
                <div class='input-group date'>
                    <form:input type="time" class="form-control required" name="donation_time" path="donation_time" required="true"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                    </span>
                </div>
            </div>
        </div>
        
    </div>
 <div class="form-group mb-20">
                      <label><strong>Pick Up Area:</strong></label>
                      <form:select name="donation_area" class="form-control required" path="donation_area" required="true">
                      	<c:forEach items="${area}" var="type">
													<form:option value="${type.area_id}" label="${type.area_name}"/>
																</c:forEach>
                      </form:select>
                       </div>
                 <div class="row">
                <div class="form-group col-md-12">
                  <label><strong>Address:</strong></label>
                  <form:input id="donation_address" name="donation_address" class="form-control required" required="true" type="text" path="donation_address"/>
                </div>
              </div>      
               <div class="form-group">
                  <input name="form_botcheck" class="form-control" type="hidden" value="" id="demo" />
                  <button type="submit" class="btn btn-block btn-dark btn-theme-colored btn-sm mt-20 pt-10 pb-10" formaction="/unfoldhappiness_user/donate/saveDetails">Make Request</button>
                </div>
              
              
          
            </form:form>
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
            
            $("#demo").live("click", function () {
                //Get text or inner html of the selected option
                var selectedText = $("#mySelect option:selected").html();
                alert(selectedText);
            });
        </script>
           
        
        <!-- Mirrored from resources/form-login-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:22:30 GMT -->
</html>