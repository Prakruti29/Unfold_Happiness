<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.unfoldhappiness_user.model.User" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header id="header" class="header">
    <div class="header-nav">
      <div class="header-nav-wrapper navbar-scrolltofixed bg-white">
        <div class="container">
          <nav id="menuzord-right" class="menuzord orange bg-white">
           <!--<a class="menuzord-brand" href="javascript:void(0)">  --> 
              <img src="/unfoldhappiness_user/resources/images/logo.JPG" alt="">
       
            <ul class="menuzord-menu">
            <li><a href="home.jsp">HOME</a>
              <li class="active"><a href="#home">DONATE</a>
                <ul class="dropdown">
                  <li><a href="/unfoldhappiness_user/donate/donateItem">Donate Items</a>
                    
                  </li>
                  <li><a href="/unfoldhappiness_user/donate/donateamt">Donate Monetary Amount</a>
                    
                  </li>
                  <li><a href="/unfoldhappiness_user/donate/donatecause">Donate to Current Natural Disasters </a>
                    
                  </li>
                      
                  
                </ul>
              </li>
              <li><a href="/unfoldhappiness_user/volunteer/registerVol/">VOLUNTEER</a>
                  
                </li>
              <li><a href="/unfoldhappiness_user/ngo/addNgo/">PARTNER</a>
                </li>
              <li><a href="/unfoldhappiness_user/event/eventList">EVENTS</a>
                
              </li>
              <li><a href="/unfoldhappiness_user/product/products">PRODUCTS</a>
                
              </li>
              <%User user=(User)session.getAttribute("user"); %>
              <%if(user==null)
            	  {%>
              <li> <a href="#"><i class="fa fa-user"></i>LOGIN</a>
             <ul class="dropdown">
                  <li><a href="userlogin/">Login as User</a>
                    
                  </li>
                  <li><a href="vollogin/">Login as Volunteer</a>
                    
                  </li>
                 
                  <li><a href="ngologin/">Login as NGO </a>
                    
                  </li>
                      
                  
                </ul></li><% }
               else
            	  {%>
            	  <li><a href="#" style="font-size:15px"><%out.println(user.getName()); %></a>
                <ul class="dropdown">
                  <li><a href="myProfile.jsp">My profile</a>
                    
                  </li>
                  <li><a href="/unfoldhappiness_user/donate/donationList">My Donations</a>
                    
                  </li>
                   <li><a href="/unfoldhappiness_user/user/changePassword">Change Password</a>
                    
                  </li>
           
                  <li><a href="home.jsp">Logout </a>
                    
                  </li>
                  <%} %>    
                  
                </ul>
              </li>
            	  
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </header>
</body>
</html>