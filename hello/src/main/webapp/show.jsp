<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styleaffiche.css">
<title>Insert title here</title>
<style>
	body {margin: 0;}
	ul.topnav {
	  list-style-type: none;
	  margin: 0;
	  padding: 0;
	  overflow: hidden;
	  background-color: #333;
	}
	
	ul.topnav li {float: left;}
	
	ul.topnav li a {
	  display: block;
	  color: white;
	  text-align: center;
	  padding: 14px 16px;
	  text-decoration: none;
	}
	
	ul.topnav li a:hover:not(.active) {background-color: #111;}
	
	ul.topnav li a.active {background-color: #04AA6D;}
	
	ul.topnav li.right {float: right;}
	
	@media screen and (max-width: 600px) {
	  ul.topnav li.right, 
	  ul.topnav li {float: none;}
	}
	
	
	#customers {
	  font-family: Arial, Helvetica, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	#customers td, #customers th {
	  border: 1px solid #ddd;
	  padding: 8px;
	}
	
	#customers tr:nth-child(even){background-color: #f2f2f2;}
	
	#customers tr:hover {background-color: #ddd;}
	
	#customers th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  text-align: left;
	  background-color: #04AA6D;
	  color: white;
	}
	
	.dimi{
		display: flex;
		justify-content : space-between;
		align-items : center;
		padding: 10px 5%;
	}
	.dimi a{
		background : darkblue;
		padding: 10px;
		cursor: pointer;
		text-decoration : none;
		border-radius: 15px;
		color : white;
		
	}
	.di{
	padding: 0 5%;
	}
</style>
</head>
<body>
	<ul class="topnav">
	  <li><a class="active" href="#home">KOKOU</a></li>
	  <!-- <li><a href="#news">News</a></li>
	  <li><a href="#contact">Contact</a></li>
	  <li class="right"><a href="#about">About</a></li> -->
	</ul>
	
	
	<div class="di">
		<div class="dimi">
			<h1>LISTES DES UTILISATEURS</h1>
			<a href="${pageContext.request.contextPath}/formulaire">Ajouter utilisateur</a>
		</div>
		

		<table id="customers">
		  <tr>
		    <th>Nom</th>
		    <th>Prenom</th>
		    <th>email</th>
		    <th>contact</th>
		    <th>username</th>
		    <th>role</th>
		    <th>edit</th>
		    <th>supprimer</th>
		  </tr>
		  <c:forEach var="user" items="${ListesUers}">
			  <tr>
			    <td>${user.nom}</td>
			    <td>${user.prenom}</td>
			    <td>${user.email}</td>
			    <td>${user.contact}</td>
			    <td>${user.username}</td>
			    <td>
		   		<c:forEach var="rle" items="${user.roles}">
		    		${rle.libelle}</td>
			    </c:forEach> 
			    <td>
				    <a href="${pageContext.request.contextPath}/edit/${user.getId_user()}">Edit</a>
			    </td>
			    
			    <td>
				    <a href="Delete/${user.getId_user()}">Supprimer</a>
				</td>
			    
			  </tr>
		  </c:forEach>
		</table>
	</div>
	
</body>
</html>