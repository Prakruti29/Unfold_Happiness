<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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

							<div class="content" >
					<div class="container-fluid">
					 	    <div class="row">
        <div class="col-md-10" >
            <div class="card" id="d1">
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">perm_identity</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Admin Details </h4>

                    <form:form  id="RegisterValidation"
											modelAttribute="adminregister" enctype="multipart/form-data" method="post">
											<form:hidden path="id" name="id" />
											<form:hidden path="password" name="password" />
                    <div class="row">
                            <div class="col-md-12">
                            <div class="form-group label-floating">
                                   <small>*</small><label class="id1">Mandatory Fields</label>
                                    
                                </div>
                                <div class="form-group label-floating">
                                    <label class="id1">Name</label><small>*</small>
                                    <form:input type="text" class="form-control" path="name" pattern="[a-zA-Z][a-zA-Z ]{1,}" required="true" />
                                </div>
                            </div>
                                                   </div>
                    
                        <div class="row">
                            
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="id1">Email address</label><small>*</small>
                                    <form:input type="email" class="form-control" path="email"/>
                                </div>
                            </div>
                        </div>
			<%if(request.getParameter("errorMsg") != null){ %>
                                <div style="color: red;"><%= request.getParameter("errorMsg") %></div>
                                <%} %>
                        
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="id1">Address:</label><small>*</small>
                                    <br>
                                    <form:textarea  rows="4" cols="35" path="address" name="address" required="true"/>
                                    
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group label-floating">
														<label class="id1"> Choose Area : <small>*</small>
														</label>&nbsp; <br>
														<div class="col-lg-3 col-md-5 col-sm-3">
															<form:select class="selectpicker" path="area_name"
																data-style="btn btn-primary btn-round"
																title="Single Select" data-size="7" name="area_name" required="true">
																<c:forEach items="${areaList }" var="type">
										<form:option value="${type.area_id}" label="${type.area_name }"/>
										</c:forEach>
										
															</form:select>
														</div>
													</div>
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="id1">Mobile Number</label><small>*</small>
                                    <form:input type="text" class="form-control" path="mobileno" required="true" pattern="[0-9]{10}"/>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="id1">Date of Birth</label><small>*</small>
                                    <form:input type="date" class="form-control" path="dob" name="dob" required="true"/>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="id1">Gender</label><small>*</small>
                                    <div class="radio">
									<label>
										<form:radiobutton name="r1" checked="true" path="gender" value="male" />
										Male
									</label>
									<label>
										<form:radiobutton name="r1" checked="true" path="gender" value="female"/>
										Female
									</label>
								</div>
								
                                </div>
                        <div class="fileinput fileinput-new text-center"
											data-provides="fileinput"
											style="margin-left:10px;">
											<div class="fileinput-new thumbnail img-circle">
											<c:choose>
												<c:when test="${edit}">
													<img
													src="/unfoldhappiness_admin/resources/images/admin/profileImage/${adminregister.photo}"
													class="picture-src" id="wizardPicturePreview" title="" />
												</c:when>
												<c:otherwise>
													 <img src="/unfoldhappiness_admin/resources/demos.creative-tim.com/bs3/material-dashboard-pro/assets/img/default-avatar.png"
													class="picture-src" id="wizardPicturePreview" title="" /> 
												</c:otherwise>	
										</c:choose>		
											</div>
											<div
												class="fileinput-preview fileinput-exists thumbnail img-circle"
												style=""></div>
											<div>
												<span class="btn btn-round btn-rose btn-file"> <span
													class="fileinput-new">Add Profile Photo</span> <span
													class="fileinput-exists">Change</span> <form:input
														type="hidden" path="" />
														<input type="file"
													name="profileImage" id="profileImage" path="profileImage" required
													/></span> <br> <a href="#pablo"
													class="btn btn-danger btn-round fileinput-exists"
													data-dismiss="fileinput"><i class="fa fa-times"></i>
													Remove</a>
											</div>
										</div>
						                                        
                                                    </div>
                        </div>
                        
		<div class="clearfix"></div>
                        <c:choose>
                        						
												<c:when test="${edit}">
												<center>
													<input type="submit" class="btn btn-rose btn-fill"
														value="Update" formaction="/unfoldhappiness_admin/admin/updateAdmin"/>
												</center>
												</c:when>
												<c:otherwise>
												<center>
													<input type="submit" class="btn btn-rose btn-fill" align="center"
														value="Register" formaction="/unfoldhappiness_admin/admin/saveAdmin"/>
														</center>
												</c:otherwise>
											</c:choose>
                    </form:form>
                </div>
            </div>
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
height:950px;
	
}
.id1
		{
			font-size:30;
			position:relative;
			
		}
</style>










<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:43 GMT -->
</html>