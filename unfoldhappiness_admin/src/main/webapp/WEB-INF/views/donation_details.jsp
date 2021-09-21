<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	    <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="demos.creative-tim.com/bs3/material-dashboard-pro/assets/img/sidebar-1.jpg">
    <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->

   
    <%@include file="admin_sidebar.jsp" %>
	    <div class="main-panel">

							<div class="content" >
					<div class="container-fluid" >
					 	    <div class="row-md-10" >
        <div class="col-md-4" >
            <div class="card"  id="c1">
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">perm_identity</i>
                </div>
                <div class="card-content">
                    <strong><h4 class="card-title" id="p1"><u>Volunteer Details </u></h4></strong>

                    <form:form modelAttribute="details">
                    <center>
                    <div class="col-md-3 col-sm-4" id="d1">
							
							<div class="fileinput fileinput-new text-center" data-provides="fileinput">
								<div class="fileinput-new thumbnail img-circle">
									<img src="/unfoldhappiness_admin/resources/images/volunteer/profileImage/${details.photo}" alt="...">
								</div>
								
								
								<br>
								<div>
										
										
									
									
								</div>
							</div>
						</div>
						</center>
						
                         <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Name</label>
                                    <form:input type="text" class="form-control" path="vol_name" disabled="true" />
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Mobile Number</label>
                                    <input type="text" class="form-control" value="7600063875" disabled="true" />
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Email</label>
                                    <form:input type="text" class="form-control" path="v_email" disabled="true" />
                                </div>
                            </div>
                            
                            
                        </div>

                        
							<div class="row" id="a1">
                            <div class="col-lg-3 col-md-6 col-sm-6">
		
			
			
			
		</div>
	</div>
		<div id="b1">
			<a href="volview.jsp">More Details</a>
		</div>
 							</div>                       
                        
                        
                        
                    </form:form>
                </div>
            </div>
        </div>
            </div>

					</div>
				</div>

			  <div class="col-md-6">
            <div class="card" id="z1">
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">assignment</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title" id="p1"><u>Donation Details</h4></u>
                    <div class="table-responsive">
                        <form:form modelAttribute="details">
                            <div class="row">
                            
                            <br>
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                               
                                    <label class="control-label">Donation Id</label>
                                    <form:input type="text" class="form-control" path="id" disabled="true" />
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Donation Type</label>
                                    <form:input type="text" class="form-control" path="donation_type" disabled="true" />
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Donation Quantity</label>
                                    <form:input type="text" class="form-control" path="donation_qty" disabled="true" />
                                </div>
                            </div>
                            
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Donation Date</label>
                                    <form:input type="text" class="form-control" path="donation_date" disabled="true" />
                                </div>
                            </div>
                            
                        </div>
                        </form:form>
                    </div>
                </div>
            </div>
			 
<div class="content" >
					<div class="container-fluid" >
					 	    <div class="row-md-10" >
        <div class="col-md-4" >
            <div class="card"  id="k1">
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">perm_identity</i>
                </div>
                <div class="card-content">
                    <strong><h4 class="card-title" id="p1"><u>User Details </u></h4></strong>

                    <form:form modelAttribute="details">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Name</label>
                                    <form:input type="text" class="form-control" path="uname" disabled="true" />
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Mobile Number</label>
                                    <form:input type="text" class="form-control" path="u_mobileno" disabled="true" />
                                </div>
                            </div>
                            
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group label-floating">
                                    <label class="control-label">Email</label>
                                    <form:input type="text" class="form-control" path="u_email" disabled="true" />
                                </div>
                            </div>
                            
                            
                        </div>
						
                        
							<div id="b1">
			<a href="Userview.jsp">More Details</a>
		</div>
 							</div>                       
                        
                        
                        
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
	position:relative;
	left:130px;
	
}
#l1
{
	fontweight:strong;
}
#h1
{
	font-size:20pt;
}
#a1
{
	position:absolute;
	width:1400px;
	top:420px;
}
#c1
{
	position:relative;
	left:-30px;
	height:400px;
	width:350px;
	clear:both;
	
}
#b1
{
	font-size:15pt;
	position:absolute;
	top:530px;
	left:290px;
}
#z1
{
float:left;
	position:relative;
	left:615px;
	top:-500px;
	height:360px;
	width:300px;
	
}
#k1
{
	position:relative;
	left:610px;
	top:-500px;
	height:400px;
	width:350px;
}
#t1
{
	font-size:15pt;
}
#p1
{
	font-weight:bold;
}

</style>










<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/pages/user.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:43 GMT -->
</html>
