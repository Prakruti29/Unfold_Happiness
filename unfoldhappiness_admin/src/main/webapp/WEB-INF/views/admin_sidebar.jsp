<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.unfoldhappiness_admin.model.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="logo">
        <a href="http://www.creative-tim.com/" class="simple-text logo-mini">
             UH
        </a>

        <a href="http://www.creative-tim.com/" class="simple-text logo-normal">
             UNFOLD HAPPINESS
        </a>
    </div>
	<div class="sidebar-wrapper">
        <div class="user">
        
        
            <div class="photo">
               <% if(session.getAttribute("admin")==null){%> 
                	<img src="/unfoldhappiness_admin/resources/img/faces/avatar.jpg" />
                <% }else{ %>
                <img src="/unfoldhappiness_admin/resources/images/admin/profileImage/${admin.photo}"/>
			<% } %>
               
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    <span>
                     	<% Admin admin = (Admin)session.getAttribute("admin"); %> 
                         <% out.println(admin.getName()); %>  
                         <b class="caret"></b>
                     	
                    </span>

                </a>
                <div class="clearfix"></div>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="/unfoldhappiness_admin/admin/viewProfile">
                              <i class="material-icons">perm_identity</i>
                                <span class="sidebar-normal"> My Profile </span>
                            </a>
                        </li>
                        <li>
                            <a href="/unfoldhappiness_admin/admin/editAdmin">
                                <i class="material-icons">edit</i>
                                <span class="sidebar-normal"> Edit Profile </span>
                            </a>
                        </li>
                        <li>
                            <a href="/unfoldhappiness_admin/admin/adminForm">
                               <i class="material-icons">addition</i>
                                <span class="sidebar-normal"> Add Admin </span>
                            </a>
                        </li>
                        <li>
                            <a href="/unfoldhappiness_admin/admin/changePassword">
                                <i class="material-icons">lock_outline</i>
                                <span class="sidebar-normal"> Change Password </span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav">

            
            
            <li>
                <a  href="/unfoldhappiness_admin/volunteer/volList">
                     <i class="material-icons">grid_on</i>
					<p>Manage Volunteer</p>
                </a>

                
            <li>
                <a  href="/unfoldhappiness_admin/user/userList">
                     <i class="material-icons">grid_on</i>
                    <p> Manage User
                       
                    </p>
                </a>

                
            <li>
                <a  href="/unfoldhappiness_admin/ngo/ngoList">
                    <i class="material-icons">grid_on</i>
                    <p> Manage NGO
                     
                    </p>
                </a>

                
            <li>
                <a  href="/unfoldhappiness_admin/admin/viewdonation">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Donations
                       
                    </p>
                </a>
			</li>
			<li>                
					<a href="/unfoldhappiness_admin/product/productList">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Products </p>
                </a>
            </li>
            
            <li>
                <a href="/unfoldhappiness_admin/event/eventList">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Events </p>
                </a>
            </li>
            <li>
                <a href="/unfoldhappiness_admin/admin/managerequest">
                    <i class="material-icons">grid_on</i>
                    <p> Manage Requests </p>
                </a>
            </li>
            
            <li>
                <a href="/unfoldhappiness_admin/admin/logout">
                    <center><p> LogOut </p></center>
                    
                </a>
            </li>
            
        </ul>
    </div>
</div>
	
</body>
</html>