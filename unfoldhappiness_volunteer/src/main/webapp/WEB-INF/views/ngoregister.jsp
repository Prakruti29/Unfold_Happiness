<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
              <h3 class="text-theme-colored mt-0 pt-5">BECOME OUR PARTNER</h3>
              <hr>
             
              <form id="job_apply_form" name="job_apply_form" action="http://resources/includes/job.php" method="post" enctype="multipart/form-data">
                <div class="row">
                  <div class="col-sm-12">
                    <div class="form-group">
                      <label>Name <small>*</small></label>
                      <input name="name" type="text" placeholder="Enter Name" required="" class="form-control">
                    </div>
                  </div>
                  
                </div>
                <div class="row">               
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Services <small>*</small></label>
                      <select name="services" class="form-control required">
                      	<option></option>
                        <option value="Environmental">Environmental</option>
                        <option value="Working for Old Age Homes">Working for Old Age Homes</option>
                        <option value="Helping the poor">Helping the poor</option>
                        <option value="Food Distribution">Food Distribution</option>
                      </select>
                    </div>
                  </div>
                  <div class='col-sm-6'>
            <div class="form-group">
            	 <label>Date of Establishment<small>*</small></label>
                <div class='input-group date' id='datetimepicker3'>
                    <input type='text' class="form-control required" name="date" />
                    <span class="input-group-addon">
                        <span class="fa fa-calendar mr-5"></span>
                    </span>
                </div>
            </div>
        </div>
                  
                </div>
                
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Phone No <small>*</small></label>
                      <input name="phone" type="text" placeholder="Enter Phone No" required="" class="form-control">
                    </div>
                  </div>
                  
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Choose Area<small>*</small></label>
                      <select name="area" class="form-control required">
                      	<option placeholder="City"></option>
                        <option value="Paldi">Paldi</option>
                        <option value="Bopal">Bopal</option>
                        <option value="S.G.Highway">S.G.Highway</option>
                      </select>
                    </div>
                  </div>
                </div>
                
                <div class="form-group">
                  <label>Address<small>*</small></label>
                  <textarea name="address" class="form-control required" rows="5" placeholder=""></textarea>
                </div>
                <div class="row">
                <div class="form-group col-md-12">
                  <label>Website</label>
                  <input id="website" name="website" class="form-control" type="text">
                </div>
              </div>
              <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Bank Name<small>*</small></label>
                      <input name="bname" type="text" placeholder="" required="true" class="form-control">
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>IFSC Code: <small>*</small></label>
                      <input name="ifsc" class="form-control" required="true" type="text" placeholder="">
                    </div>
                  </div>
                </div>
            	
                <div class="row">
                <div class="form-group col-md-12">
                  <label>Email<small>*</small></label>
                  <input id="email" name="email" class="form-control required" type="text" required="true">
                </div>
              </div>
                <div class="row">
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Password<small>*</small></label>
                      <input name="password" type="password" placeholder="" required="true" class="form-control">
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="form-group">
                      <label>Confirm Password <small>*</small></label>
                      <input name="conpassword" class="form-control" required="true" type="password" placeholder="">
                    </div>
                  </div>
                </div>
            	
                <%@include file="terms.jsp" %>
                
                <div class="form-group">
                  <input name="form_botcheck" class="form-control" type="hidden" value="" />
                  <button type="submit" class="btn btn-block btn-dark btn-theme-colored btn-sm mt-20 pt-10 pb-10" data-loading-text="Please wait...">Apply Now</button>
                </div>
              </form>
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
<script src="/unfoldhappiness_volunteer/resources/js/custom.js"></script>

</body>

<!-- Mirrored from resources/form-job-apply-style1.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:18:12 GMT -->
</html>