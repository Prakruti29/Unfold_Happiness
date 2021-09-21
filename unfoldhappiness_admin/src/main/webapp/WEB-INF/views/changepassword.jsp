<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:42 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
	<%@include file="coreJs.jsp" %>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
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

	    <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="resources/img/sidebar-1.jpg">
    <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->

   
    <%@include file="admin_sidebar.jsp" %>
	    <div class="main-panel">

			 <div class="content">
            <div class="container">
                <div class="card">
				<div class="card-header card-header-icon" data-background-color="rose">
					<i class="material-icons">perm_identity</i>
				</div>

				<div class="card-content">
					<h4 class="card-title">Change Password</h4>
					<form:form method="post" action="/unfoldhappiness_admin/admin/change" modelAttribute="cpass">
	                    <div class="form-group label-floating is-empty">
	                    <div class="col-lg-11 col-md-9 col-sm-3">
	                    <div class="input-group">
                                      	<span class="input-group-addon">
                                            <i class="material-icons">lock_outline</i>
                                        </span>
                                        <form:input type="password" placeholder="Old Password" class="form-control" path="password" name="password" />
                        </div>
	                    </div></div><br><br>
	                    <div class="form-group label-floating is-empty">
	                    <div class="col-lg-11 col-md-9 col-sm-3">
	                        <div class="input-group">
                                      	<span class="input-group-addon">
                                            <i class="material-icons">lock_outline</i>
                                        </span>
                                        <form:input type="password" placeholder="New Password" class="form-control" path="npassword" name="npassword" />
                        </div>
                        </div></div><br><br>
                        <div class="form-group label-floating is-empty">
	                    <div class="col-lg-11 col-md-9 col-sm-3">
	                        <div class="input-group">
                                      	<span class="input-group-addon">
                                            <i class="material-icons">lock_outline</i>
                                        </span>
                                        <form:input type="password" placeholder="Confirm Password" class="form-control" path="conpassword" name="conpassword" />
                        </div>
                        </div></div><br><br>
                        <%if(request.getParameter("errorMsg") != null){ %>
                                <div style="color: red;"><%= request.getParameter("errorMsg") %></div>
                                <%} %>
	                    <button type="submit" class="btn btn-fill btn-rose" style="margin-left:40%">Submit</button>
	                </form:form>
				</div>
			</div>
		</div>             </div>
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
document,'script','../../../../../connect.facebook.net/en_US/fbevents.js');

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
height:7 50px;
	
}
.id1
		{
			font-size:30;
			position:relative;
			left:10px;
		}
</style>










<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:43 GMT -->
</html>