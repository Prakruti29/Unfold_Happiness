<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.unfoldhappiness_volunteer.model.Volunteer" %>
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
           
              <img src="/unfoldhappiness_volunteer/resources/images/logo.JPG" alt="">
           
            <ul class="menuzord-menu">
            <li><a href="home.jsp">HOME</a>
              <li class="active"><a href="#home">DONATE</a>
                <ul class="dropdown">
                  
                  <li><a href="donateamt.jsp">Donate Monetary Amount</a>
                    
                  </li>
                  <li><a href="donatecause.jsp">Donate to Current Natural Disasters </a>
                    
                  </li>
                      
                  
                </ul>
              </li>
              <li><a href="/unfoldhappiness_volunteer/volunteer/requestList">MANAGE REQUEST</a>
                  
                </li>
              <li><a href="events.jsp">EVENTS</a>
                
              </li>
              <li><a href="products.jsp">BUY PRODUCTS</a>
                
              </li>
              <%Volunteer volunteer=(Volunteer)session.getAttribute("volunteer"); %>
              <%if(volunteer==null)
            	  {%>
              <li> <a href="/unfoldhappiness_volunteer/volunteer/vollogin"><i class="fa fa-user"></i>LOGIN</a>
             </li><% }
               else
            	  {%>
            	  <li><a href="#" style="font-size:15px"><%out.println(volunteer.getName()); %></a>
                <ul class="dropdown">
                  <li><a href="myProfile.jsp">My profile</a>
                    
                  </li>
                  <li><a href="myDonations.jsp">My Donations</a>
                    
                  </li>
                   <li><a href="myDonations.jsp">Change Password</a>
                    
                  </li>
                 
                  <li><a href="myOrders.jsp">My Orders </a>
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