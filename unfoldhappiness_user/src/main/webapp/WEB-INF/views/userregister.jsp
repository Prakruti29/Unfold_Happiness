<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<!-- Mirrored from resources/form-job-apply-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:18:12 GMT -->
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
    
    <!-- Section: Job Apply Form -->
    <section class="divider">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-md-push-3">
            <div class="border-1px p-30 mb-0">
              <h3 class="text-theme-colored mt-0 pt-5">SIGN IN</h3>
              <hr>
             
              <form:form  modelAttribute="userregister" >
                    <form:hidden path="id" name="id" />
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                      <label>Name <small>*</small></label>
                      <form:input name="name" type="text" placeholder="Enter Name" required="true" class="form-control" path="name" pattern="[a-zA-Z][a-zA-Z ]{1,}" />
                    </div>
                  </div>
                  
                </div>
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Phone No <small>*</small></label>
                      <form:input name="phone" type="text" placeholder="Enter Phone No" required="true" class="form-control" path="mobileno" pattern="[0-9]{10}" />
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>D.O.B <small>*</small></label>
                      <form:input name="dob" class="form-control required " type="text"  required="true" placeholder="Enter Date of Birth" path="dob" />
                    </div>
                  </div>
                </div>
                
                <div class="row">               
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Gender <small>*</small></label>
                     <br>
                        <form:radiobutton value="Male" path="gender" />Male</option>
                        <form:radiobutton  value="Female" path="gender" />Female</option>
                     
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Choose Area<small>*</small></label>
                       <form:select name="area_name" class="form-control required" path="area" required="true">
                      	<c:forEach items="${areaList}" var="type">
													<form:option value="${type.area_id}" label="${type.area_name }"/>
																</c:forEach>
                      </form:select>
  
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <label>Address<small>*</small></label>
                  <form:textarea name="address" class="form-control required" required="true" rows="5" placeholder="" path="address" /></textarea>
                </div>
                <div class="row">
                <div class="form-group col-md-12">
                  <label>Email<small>*</small></label>
                  <form:input id="email" name="email" class="form-control required" type="email" required="true" path="email" />
                </div>
              </div>
                
                
                <div class="form-group">
                  <input name="form_botcheck" class="form-control" type="hidden" value="" />
                  <button type="submit" class="btn btn-block btn-dark btn-theme-colored btn-sm mt-20 pt-10 pb-10" data-loading-text="Please wait..." formaction="/unfoldhappiness_user/user/saveUser" />Apply Now</button>
                </div>
              </form:form>
              <!-- Job Form Validation-->
              <script type="text/javascript">
                $("#job_apply_form").validate({
                  submitHandler: function(form) {
                    var form_btn = $(form).find('button[type="submit"]');
                    var form_result_div = '#form-result';
                    $(form_result_div).remove();
                    form_btn.before('<div id="form-result" class="alert alert-success" role="alert" style="display: none;"></div>');
                    var form_btn_old_msg = form_btn.html();
                    form_btn.html(form_btn.prop('disabled', true).data("loading-text"));
                    $(form).ajaxSubmit({
                      dataType:  'json',
                      success: function(data) {
                        if( data.status == 'true' ) {
                          $(form).find('.form-control').val('');
                        }
                        form_btn.prop('disabled', false).html(form_btn_old_msg);
                        $(form_result_div).html(data.message).fadeIn('slow');
                        setTimeout(function(){ $(form_result_div).fadeOut('slow') }, 6000);
                      }
                    });
                  }
                });
              </script>
            </div>
          </div>
        </div>
      </div>
    </section> 
  </div>  
  <!-- end main-content -->
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

<!-- Mirrored from resources/form-job-apply-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:18:12 GMT -->
</html>