<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="core.jsp" %>


<!DOCTYPE html>
<html dir="ltr" lang="en">

<!-- Mirrored from resources/events-grid-2column.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:19:09 GMT -->
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
  <section class="inner-header divider parallax layer-overlay overlay-white-8" data-bg-img="resources/images/bg/bg6.jpg">
      <div class="container pt-60 pb-60">
        <!-- Section Content -->
        <div class="section-content">
          <div class="row">
            <div class="col-md-12 text-center">
              <h2 class="title">EVENTS LIST</h2>
             
            </div>
          </div>
        </div>
      </div>
    </section>
  
   <!-- Start main-content -->
  <section id="upcoming-events" class="divider parallax layer-overlay overlay-white-8" data-bg-img="/unfoldhappiness_user/resources/images/bg/bg10.jpg">
      
      <div class="container pb-50 pt-80">
        <div class="section-content">
        
          <div class="row">
           <c:forEach items="${eventList}" var="event">
            <div class="col-sm-6 col-md-6 col-lg-6">
              <div class="schedule-box maxwidth500 bg-light mb-30">
                <div class="thumb">
                  <img class="img-fullwidth" alt="" src="placehold.it/220x160">
                  
                </div>
                
                <div class="schedule-details clearfix p-15 pt-10">
                  <h5 class="font-16 title"><c:out value="${event.e_name}"/></h5>
                  <ul class="list-inline font-11 mb-20">
                    <li><i class="fa fa-calendar mr-5"></i> <c:out value="${event.e_date}"/></li>
                    <li><i class="font-16 title"></i><c:out value="${event.e_time}"/></li>
                    <li><i class="fa fa-map-marker mr-5"></i> <c:out value="${event.e_venue}"/></li>
                    
                  </ul>
                  <p><c:out value="${event.e_details}"/></p>
                  <div class="mt-10">
                  
                   <%@include file="eventDetails.jsp" %>
                  </div>
                </div>
                 
              </div>
            </div>
             </c:forEach>
            </div>
            
            </div>
            </div>
           
          </section>
  
  <!-- end main-content -->
  <footer id="footer" class="footer bg-black-222">
      <div class="row mt-10">
        
        <%@include file="userfooter.jsp" %>
      </div>
    
      </footer>
  

    <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
</div>
<!-- end wrapper -->

<!-- Footer Scripts -->
<!-- JS | Custom script for all pages -->
<script src="/unfoldhappiness_user/resources/js/custom.js"></script>

</body>

<!-- Mirrored from resources/events-grid-2column.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 16 Feb 2020 12:19:30 GMT -->
</html>