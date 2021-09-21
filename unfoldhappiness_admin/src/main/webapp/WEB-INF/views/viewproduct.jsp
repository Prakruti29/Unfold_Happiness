<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@include file="coreJs.jsp" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:42 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>





	
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
					 	    <div class="row-md-10">
        <div class="col-md-10" >
            <div class="card" >
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">perm_identity</i>
                </div>
                <div class="card-content">
                    <strong><h4 class="card-title" id="h1">Product Details </h4></strong>
                    <form:form modelAttribute="product" enctype="multipart/form-data" disabled="true">
                    <div class="fileinput fileinput-new text-center"
											data-provides="fileinput"
											style="margin-top: 10px; margin-left: 25px">
											<div class="fileinput-new thumbnail img-circle">
												<img
													src="/unfoldhappiness_admin/resources/images/product/photo1/${product.photo1}"
													class="picture-src" id="wizardPicturePreview" title="" />
											</div>
											<div
												class="fileinput-preview fileinput-exists thumbnail img-circle"
												style=""></div>
											<div>
												<span class="btn btn-round btn-rose btn-file"> <span
													class="fileinput-new">Photo 1</span> <span
													class="fileinput-exists">Change</span> <form:input
														type="hidden" path="" /><input type="file"
													name="image1" id="image1" disabled="true"/>
													</span> <br> <a href="#pablo"
													class="btn btn-danger btn-round fileinput-exists"
													data-dismiss="fileinput"><i class="fa fa-times"></i>
													Remove</a>
											</div>
										</div>
								<div class="fileinput fileinput-new text-center"
											data-provides="fileinput"
											style="margin-top: 10px; margin-left: 50px">
											<div class="fileinput-new thumbnail img-circle">
												<img
													src="/unfoldhappiness_admin/resources/images/product/photo2/${product.photo2}"
													class="picture-src" id="wizardPicturePreview" title="" />
											</div>
				
											<div
												class="fileinput-preview fileinput-exists thumbnail img-circle"
												style=""></div>
											<div>
												<span class="btn btn-round btn-rose btn-file"> <span
													class="fileinput-new">Photo 2</span> <span
													class="fileinput-exists">Change</span> <form:input
														type="hidden" path="" /><input type="file"
													name="image2" id="image2" disabled="true"/>
													</span> <br> <a href="#pablo"
													class="btn btn-danger btn-round fileinput-exists"
													data-dismiss="fileinput"><i class="fa fa-times"></i>
													Remove</a>
											</div>
										</div>
				 <form:input type="hidden" path="id" id="id"/>
                    <div class="col-md-3 col-sm-4" id="d1">
                    <br>
                    <br>
                    			<div>
										<strong>Product Name : Water Pot</strong>
										
										
									<br />
									
								</div>
							</div>
						</div>
						<br>
						<br>
                        

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Description</label>
                                    <form:input type="text" class="form-control" path="description" disabled="true"/>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
              
                                    <label class="control-label">Price</label>
                                    <form:input type="text" class="form-control" path="price" disabled="true"/>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group label-floating">
                                    <label class="control-label">Discount</label>
                                    <form:input type="text" class="form-control" path="discount" disabled="true"/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group label-floating">
                                    <label class="control-label">Quantity</label>
                                    <form:input type="text" class="form-control" path="quantity" disabled="true" />
                                </div>
                            </div>
                            </div>
							<div class="row">
                            <div class="col-md-6">
                                <div class="form-group label-floating">
                                    <label class="control-label">Product Type</label>
                                    <form:input type="text" class="form-control" path="product_type" disabled="true"/>
                                </div>
                            </div>
 							</div>                       
                        
                   			 </form:form>     
                        <div class="clearfix"></div>
                   
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
	position:relative;
	left:250px;
	top:120px;
	
}
#l1
{
	fontweight:strong;
}
#h1
{
	font-size:20pt;
}
</style>










<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:43 GMT -->
</html>
