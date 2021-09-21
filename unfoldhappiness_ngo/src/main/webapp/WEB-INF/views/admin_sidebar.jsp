<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.unfoldhappiness_ngo.model.Ngo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="logo">
        <a href="#" class="simple-text logo-mini">
             UH 
        </a>

        <a href="#" class="simple-text logo-normal">
             Unfold Happiness 
        </a>
    </div>

	<div class="sidebar-wrapper">
        <div class="user">
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <span>
                    <center>
                     	<% Ngo ngo = (Ngo)session.getAttribute("ngo"); %> 
                         <% out.println(ngo.getName()); %>  
                         <b class="caret"></b>
                    </center> 	
                    </span>

                </a>
                <div class="clearfix"></div>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="/unfoldhappiness_ngo/ngo/viewNgo">
                                <span class="sidebar-mini"> MP </span>
                                <span class="sidebar-normal"> My Profile </span>
                            </a>
                        </li>
                        <li>
                            <a href="/unfoldhappiness_ngo/ngo/editAdmin">
                                <span class="sidebar-mini"> EP </span>
                                <span class="sidebar-normal"> Edit Profile </span>
                            </a>
                        </li>
                        <li>
                            <a href="/unfoldhappiness_ngo/ngo/changePassword">
                                <span class="sidebar-mini"> CP </span>
                                <span class="sidebar-normal"> Change Password </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">
            
			<li>
                <a href="/unfoldhappiness_ngo/product/productList">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Products </p>
                </a>
            </li>
            
            <li>
                <a href="/unfoldhappiness_ngo/event/eventList">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Events </p>
                </a>
            </li>
            <li>
                <a href="/unfoldhappiness_ngo/ngo/logout">
                    <center><p> LogOut </p></center>
                    
                </a>
            </li>
            
        </ul>
    </div>
</div>
	
</body>
</html>