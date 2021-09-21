<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="coreJs.jsp" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/tables/extended.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:46 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>





	
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'www.googletagmanager.com/gtm5445.html?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-NKDMSK6');</script>
<!-- End Google Tag Manager -->

</head>


<body >
  <!-- Google Tag Manager (noscript) -->
  <noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6"
  height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
  <!-- End Google Tag Manager (noscript) -->
  
  <div class="wrapper">

	    <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="assets/img/sidebar-1.jpg">
    <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->
    
   
<%@include file="admin_sidebar.jsp" %>

	    <div class="main-panel">

			
            				<div class="content">
					<div class="container-fluid">
					 	<div class="row">

				        <div class="col-md-12">
            <div class="card">
            <a href="Vol_reg.jsp">
                <div class="card-header card-header-icon" data-background-color="rose">
             
                    <i class="material-icons">assignment</i>
                </div>
				</a>
                <div class="card-content" id="d1">
                    <h4 class="card-title">Donation Requests</h4>
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    
                                    <th>Donation ID</th>
                                    <th>User Name</th>
                                    <th>Donation Type</th>
                                    <th>Donation Quantity</th>
                                    <th> Donation Date</th>
                                    <th>Donation Address</th>
                                    <th class="text-right">Actions</th>
                                </tr>
                            </thead>
                            <body>
                            <c:forEach items="${donationList}" var="d">
                                <tr>
                                    <td class="text-center"><c:out value="${d.id}"/></td>
                                    <td><c:out value="${d.uname}"/></td>
                                    <td><c:out value="${d.donation_type}"/></td>
                                    <td><c:out value="${d.donation_qty}"/></td>
                                    <td><c:out value="${d.donation_date}"/></td>
                                    <td><c:out value="${d.donation_address}"/></td>
                                    <c:choose>
						<c:when test="${d.status==0}">
						 <td class="td-actions text-right">
                                        <a href="/unfoldhappiness_admin/admin/login">
                                        <div class="footer text-center" color:red>
                                       <button type="submit" class="btn btn-rose btn-simple btn-wd btn-lg">Delete</button>
                                       </div>
                                       </a>
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
                             </body>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        
        
				
			 

			
			<%@include file="admin_footer.jsp" %>
			
		</div>
	</div>
	</body>
  
	<!--   Core JS Files   -->

<script>
// Facebook Pixel Code Don't Delete
!function(f,b,e,v,n,t,s){if(f.fbq)return;n=f.fbq=function(){n.callMethod?
n.callMethod.apply(n,arguments):n.queue.push(arguments)};if(!f._fbq)f._fbq=n;
n.push=n;n.loaded=!0;n.version='2.0';n.queue=[];t=b.createElement(e);t.async=!0;
t.src=v;s=b.getElementsByTagName(e)[0];s.parentNode.insertBefore(t,s)}(window,
document,'script','connect.facebook.net/en_US/fbevents.js');

try{
  fbq('init', '111649226022273');
  fbq('track', "PageView");

}catch(err) {
  console.log('Facebook Track Error:', err);
}

</script>
<noscript>
  <img height="1" width="1" style="display:none"
  src="https://www.facebook.com/tr?id=111649226022273&amp;ev=PageView&amp;noscript=1"
  />
</noscript>

<style>
#d1
{
	height:500px;
}
</style>









<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/tables/extended.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:47 GMT -->
</html>
