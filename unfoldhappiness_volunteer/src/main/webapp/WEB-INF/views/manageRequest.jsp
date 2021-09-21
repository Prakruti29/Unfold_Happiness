<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  <%@include file="volHeader.jsp" %>
  <div class="col-md-12 text-center">
              <h2 class="title">REQUEST LIST</h3>
             
            </div>
            <br></br>
            
<table class="table table-bordered"> 
<thead> 
<tr> 
		<th>Donation Id</th> 
		<th>Donation Quantity</th>
		<th>Pick Up Address</th>
		<th>Pick Up Area</th>
		<th>Pick Up Time</th>
		<th>Pick Up Date</th>
		 <th>Request Status</th>
		 <th>Actions</th>
</tr> 
</thead> 
<tbody> 
 <c:forEach items="${donationList}" var="d">
						<tr>
						<td><c:out value="${d.id}"/></td>
						<td><c:out value="${d.donation_qty}"/></td>
						<td><c:out value="${d.donation_address}"/></td>
						<td><c:out value="${d.area_name}"/></td>
						 <td><c:out value="${d.donation_time}"/></td>
						<td><c:out value="${d.donation_date}"/></td>
						<td><c:out value="${d.status}"/></td>
						<c:choose>
						<c:when test="${d.status==0}">
						 <td class="td-actions text-right">
                                        <a href="/unfoldhappiness_volunteer/volunteer/acceptRequest/<c:out value='${d.id}'/>">
                                       <button type="button" rel="tooltip" class="btn btn-success" >
                                            <i class="material-icons">Accept</i>
                                        </button></a>
                             </td>
                          </c:when>
                          <c:otherwise>
 							<td class="td-actions text-right">
                                       Completed
                             </td>
                                                  
                          </c:otherwise>
                        </c:choose>                 
                                                                  
					</tr>
				</c:forEach>
				</tbody> 
</table>
<nav>
  <ul class="pager">
    <li><a href="#">Previous</a></li>
    <li><a href="#">Next</a></li>
  </ul>
</nav>
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