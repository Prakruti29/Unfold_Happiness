<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="coreJs.jsp"%>
<!doctype html>
<html lang="en">

<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/forms/validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:45 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<!-- /Added by HTTrack -->
<head>





<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'../../../../../www.googletagmanager.com/gtm5445.html?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-NKDMSK6');</script>
<!-- End Google Tag Manager -->

</head>


<body>
	<!-- Google Tag Manager (noscript) -->
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="wrapper">

		<div class="sidebar" data-active-color="rose"
			data-background-color="black"
			data-image="../../assets/img/sidebar-1.jpg">
			<!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->

			
			<%@include file="admin_sidebar.jsp"%>

			<div class="main-panel">

								<div class="content">
					<div class="container-fluid" id="f1">
						<div class="row">

							<div class="col-md-10">
								<div class="card">
									<form:form modelAttribute="volregister" enctype="multipart/form-data">
										<div class="card-header card-header-icon"
											data-background-color="rose">
											<i class="material-icons">perm_identity</i>
										</div>
										<div class="card-content">
											<h4 class="card-title">Volunteer Registration</h4>

											<div class="form-group label-floating">
												<label class="id1"> Name <small>*</small>
												</label> <form:input class="form-control" name="name" type="text"
													path="name" required="true" pattern="[a-zA-Z][a-zA-Z ]{1,}" />
											</div>


											<div class="form-group label-floating">
												<label class="id1"> Email Address <small>*</small>
												</label> <form:input class="form-control" name="email" type="email"
												path="email"	required="true" />
											</div>
											<div class="form-group label-floating">
												<label class="id1"> Address <small>*</small>
												</label> <form:textarea name="address" id="add" rows="5" cols="30"
													path="address" type="textarea" required="true" />
											</div>
											<div class="form-group label-floating">
												<label class="id1"> Choose Area : <small>*</small>
												</label>&nbsp; <br>


												<div class="col-lg-3 col-md-5 col-sm-3">
													<form:select class="selectpicker" path="area_name"
																data-style="btn btn-primary btn-round"
																title="Single Select" data-size="7" name="area_name"
																required="true">
																<c:forEach items="${areaList }" var="type">
													<form:option value="${type.area_id}" label="${type.area_name }"/>
																</c:forEach>
															</form:select>
												</div>
											</div>
                            
											<br>
											<br>
											<div class="form-group label-floating">
												<label> Mobile Number <small>*</small>
										
												</label> <form:input class="form-control" name="mobnum" id="mobnum"
													path="mobileno" type="text" required="true" pattern="[0-9]{10}" />
											</div>

											<div class="form-group label-floating">
												<label class="id1"> Date of Birth <small>*</small>
												</label> <form:input class="form-control" name="dob" id="dob" type="date"
													path="dob" required="true" />
											</div>
											<br>
											<div class="form-group label-floating">
												<div class="radio">

													<label> Gender <small>*</small>
													</label> <label> <form:radiobutton name="optionsRadios"
														value="Male" checked="true" path="gender"/> Male
													</label> <label> <form:radiobutton name="optionsRadios"
														value="Female" checked="true" path="gender" /> Female
													</label>
												</div>
											</div>

										

											<div class="fileinput fileinput-new text-center"
											data-provides="fileinput"
											style="margin-top: 10px; margin-left: 25px">
											<div class="fileinput-new thumbnail img-circle">
											<c:choose>
												<c:when test="${edit}">
													<img
													src="/unfoldhappiness_admin/resources/images/volunteer/profileImage/${volregister.photo}"
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
												style="margin-top: 10px; margin-left: 25px;"></div>
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
										<br>
										</br>
										<br>
										</br>
										
                       <c:choose>
												<c:when test="${edit}">
													<div class="form-group label-floating is-empty"
													style="margin-top: -50px; margin-left: 0px">
													
														<label class="control-label"> ID Proof <small>*</small>
														</label>
														 <span class="btn btn-round btn-rose btn-file"
														style="margin-top: 30px;"> <span
														class="fileinput-new">Choose File</span>
												
												 		<input type="file"
														name="idProof" id="idProof" path="idProof" aria-invalid="false"
														class="valid"/>
													<div class="ripple-container"></div></span>
													</div>
												</c:when>
												<c:otherwise>
													<div class="form-group label-floating is-empty"
													style="margin-top: -50px;">
														<label class="control-label">Add ID Proof <small>*</small>
														</label>
														 <span class="btn btn-round btn-rose btn-file"
														style="margin-top: 30px; margin-left: 0%"> <span
														class="fileinput-new">Choose File</span>
												
												 		<input type="file"
														name="idProof" id="idProof" path="idProof" aria-invalid="false"
														class="valid" required/>
													<div class="ripple-container"></div></span>
													</div>
												</c:otherwise>	
										</c:choose>		
																	<br></br>
                        									<br>
									<br>
									<br>
									<br>
									<br>	
									<div class="clearfix"></div>
									 <%if(request.getParameter("errorMsg") != null){ %>
                                <div style="color: red;"><%= request.getParameter("errorMsg") %></div>
                                <%} %>
 
									 <div class="form-footer text-center">
									<c:choose>
												<c:when test="${edit}">
													<input type="submit" class="btn btn-rose btn-fill"
														value="Update" formaction="/unfoldhappiness_admin/volunteer/updateVol"/>
												</c:when>
												<c:otherwise>
													<input type="submit" class="btn btn-rose btn-fill"
														value="Register" formaction="/unfoldhappiness_admin/volunteer/saveVol" />
												</c:otherwise>
											</c:choose>
											</div>
									</form:form>
								</div>
							</div>


						</div>
					</div>



					<%@include file="admin_footer.jsp"%>



				</div>
			</div>
			<div class="fixed-plugin">
				<div class="dropdown show-dropdown">
					<a href="#" data-toggle="dropdown"> <i class="fa fa-cog fa-2x">
					</i>
					</a>
					<ul class="dropdown-menu">
						<li class="header-title">Sidebar Filters</li>
						<li class="adjustments-line"><a href="javascript:void(0)"
							class="switch-trigger active-color">
								<div class="badge-colors text-center">
									<span class="badge filter badge-purple" data-color="purple"></span>
									<span class="badge filter badge-blue" data-color="blue"></span>
									<span class="badge filter badge-green" data-color="green"></span>
									<span class="badge filter badge-orange" data-color="orange"></span>
									<span class="badge filter badge-red" data-color="red"></span> <span
										class="badge filter badge-rose active" data-color="rose"></span>
								</div>
								<div class="clearfix"></div>
						</a></li>
						<li class="header-title">Sidebar Background</li>
						<li class="adjustments-line"><a href="javascript:void(0)"
							class="switch-trigger background-color">
								<div class="text-center">
									<span class="badge filter badge-white" data-color="white"></span>
									<span class="badge filter badge-black active"
										data-color="black"></span>
								</div>
								<div class="clearfix"></div>
						</a></li>

						<li class="adjustments-line"><a href="javascript:void(0)"
							class="switch-trigger">
								<p>Sidebar Mini</p>
								<div class="togglebutton switch-sidebar-mini">
									<label> <input type="checkbox" unchecked="">
									</label>
								</div>
								<div class="clearfix"></div>
						</a></li>

						<li class="adjustments-line"><a href="javascript:void(0)"
							class="switch-trigger">
								<p>Sidebar Image</p>
								<div class="togglebutton switch-sidebar-image">
									<label> <input type="checkbox" checked="">
									</label>
								</div>
								<div class="clearfix"></div>
						</a></li>

						<li class="header-title">Images</li>
						<li class="active"><a class="img-holder switch-trigger"
							href="javascript:void(0)"> <img
								src="resources/img/sidebar-1.jpg" alt="" />
						</a></li>
						<li><a class="img-holder switch-trigger"
							href="javascript:void(0)"> <img
								src="resources/img/sidebar-2.jpg" alt="" />
						</a></li>
						<li><a class="img-holder switch-trigger"
							href="javascript:void(0)"> <img
								src="resources/img/sidebar-3.jpg" alt="" />
						</a></li>
						<li><a class="img-holder switch-trigger"
							href="javascript:void(0)"> <img
								src="resources/img/sidebar-4.jpg" alt="" />
						</a></li>

						<li class="button-container">
							<div class="">
								<a
									href="http://www.creative-tim.com/product/material-dashboard-pro"
									target="_blank" class="btn btn-rose btn-block">Buy Now</a>
							</div>

							<div class="">
								<a href="http://www.creative-tim.com/product/material-dashboard"
									target="_blank" class="btn btn-info btn-block">Get Free
									Demo</a>
							</div>
						</li>

						<li class="header-title">Thank you for 95 shares!</li>

						<li class="button-container">
							<button id="twitter" class="btn btn-social btn-twitter btn-round">
								<i class="fa fa-twitter"></i> &middot; 45
							</button>
							<button id="facebook"
								class="btn btn-social btn-facebook btn-round">
								<i class="fa fa-facebook-square"> &middot;</i>50
							</button>
						</li>
					</ul>
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
	<img height="1" width="1" style="display: none"
		src="https://www.facebook.com/tr?id=111649226022273&amp;ev=PageView&amp;noscript=1" />
</noscript>




<style type="text/javascript">

		function setFormValidation(id){
			$(id).validate({
				errorPlacement: function(error, element) {
					$(element).closest('div').addClass('has-error');
		        }
			});
		}

		$(document).ready(function(){
			setFormValidation('#RegisterValidation');
			setFormValidation('#TypeValidation');
			setFormValidation('#LoginValidation');
			setFormValidation('#RangeValidation');
		});
		.id1
		{
			font-size:30;
			position:relative;
			left:100px;
		}
		#f1
		{
			height:300px;
		width:2500px;
		}
	</style>





<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/forms/validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:45 GMT -->
</html>
