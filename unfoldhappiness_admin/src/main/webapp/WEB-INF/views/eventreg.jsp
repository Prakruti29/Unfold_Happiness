<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="coreJs.jsp" %>
<html lang="en">

<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/forms/validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:45 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>





	
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'../../../../../www.googletagmanager.com/gtm5445.html?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-NKDMSK6');</script>
<!-- End Google Tag Manager -->

</head>


<body >
  <!-- Google Tag Manager (noscript) -->
  <noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NKDMSK6"
  height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
  <!-- End Google Tag Manager (noscript) -->

	<div class="wrapper">

	    <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="../../assets/img/sidebar-1.jpg">
    <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->

    
<%@include file="admin_sidebar.jsp" %>
    
	    <div class="main-panel">

							<div class="content">
					<div class="container-fluid" id="f1">
					 	    <div class="row" >
					 	    
        <div class="col-md-10" >
            <div class="card" >
                  <form:form  modelAttribute="eventregister">
                 
                   							<form:hidden path="id" name="id" />
											
                
                    <div class="card-header card-header-icon" data-background-color="rose">
                        <i class="material-icons">mail_outline</i>
                    </div>
                    <div class="card-content">
                        <h4 class="card-title">Event Registration</h4>
                        
                        <div class="form-group label-floating">
                            <label class="id1">
                                Event-Name
                                <small>*</small>
                            </label>
                            <form:input class="form-control"
                                   name="name"
                                   type="text"
                                   required="true"
                                   path="e_name"
                                   
                             />
                        </div>

                        
                        <div class="form-group label-floating">
                            <label class="id1">
                                Event-Venue
                                <small>*</small>
                            </label>
                            <form:input class="form-control"
                                   name="venue"
                                   type="textarea"
                                   path="e_venue"
                                   required="true"
                                   
                             />
                        </div>
                        		
							
									
                       
                        
                        <div class="form-group label-floating">
                            <label class="id1">
                                Event-Date
                                <small>*</small>
                            </label>
                            <div class="card-content">
                    
                    <div class="form-group">
                        
                        <form:input type="date" class="form-control datepicker" path="e_date" required="true"/>
                    </div>
                </div>
                        </div>
						
						<div class="form-group label-floating">
                            <label class="id1">
                                Event-Time
                                <small>*</small>
                            </label>
                            <form:input class="form-control"
                                   name="add"
                                   type="text"
                                   path="e_time"
                                   required="true"
                             />
                        </div>
						<div class="form-group label-floating">
                            <label class="id1">
                                Event-Description
                                <small>*</small>
                            </label>
                            <form:textarea rows="4" cols="35" path="e_details" required="true"/>
         
                        </div>
						<div class="form-group label-floating">
                            <label class="id1">
                                NGO-Name
                                <small>*</small>
                            </label>
                            <form:select class="selectpicker" path="ngo_id"
																data-style="btn btn-primary btn-round"
																title="Single Select" data-size="7" name="ngoid" required="true">
																<c:forEach items="${ngolist}" var="ngo">
																<form:option value="${ngo.id }" label="${ngo.name}"/>
																</c:forEach>
																
															</form:select>
                        </div>
												
                        
                        <div class="form-footer text-right">
                        <c:choose>
												<c:when test="${edit}">
													<input type="submit" class="btn btn-rose btn-fill"
														value="Update" formaction="/unfoldhappiness_admin/event/eventSave"/>
												</c:when>
												<c:otherwise>
													<input type="submit" class="btn btn-rose btn-fill"
														value="Register" formaction="/unfoldhappiness_admin/event/saveEvent" />
												</c:otherwise>
											</c:choose>
                        </div>
                        
                    </div>
                </form:form>
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




	<script type="text/javascript">

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
		#s1
		{
			width:-100px;
		height:10px;
		}
	</script>





<!-- Mirrored from demos.creative-tim.com/bs3/material-dashboard-pro/examples/forms/validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 04 Jan 2020 08:43:45 GMT -->
</html>
        