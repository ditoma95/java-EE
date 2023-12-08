<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Page d'inscription</title>
		<style type="text/css">
						*{
			    padding: 0;
			    margin: 0;
			    font-family: sans-serif;
			    box-sizing: border-box;
			    text-decoration: none;
			    list-style: none;
			}
			:root{
			    --color1 : #161625;
			    --color2 :#E91e63;
			    --color3 : linear-gradient(30deg,rgba(255,255,255,0.1),rgba(255,255,255,0.4));
			    --color4 : 1px solid rgba(255,255,255,0.9);
			    --color5 : 1px solid rgba(255,255,255,0.5);
			    --color6 : 1px solid rgba(255,255,255,0.5);
			    --bac1 : linear-gradient(to top,rgba(255,255,255,0.1),rgba(255,255,255,0.3));
			    --bor1 : 1px solid rgba(255,255,255,0.4);
			    --bor2 : 1px solid rgba(255,255,255,0.3);
			    --txsha : 1px 1px 1px #000;
			    --bouts : rgb(41, 19, 19);
			}
			
			.container{
			    position: relative;
			    width: 25rem;
			    background: var(--color3);
			    margin: auto;
			    backdrop-filter: blur(20px);
			    padding: 20px;
			    border: var(--color4);
			    border-right: var(var(--color5));
			    border-bottom: var(--color6);
			    color: #fff;
			    margin-top: 5rem;
			    border-radius: 10px;
			    z-index: 999;
			
			}
			.groupe{
			    display: grid;
			    padding: 10px;
			}
			.container input{
			    font-style: italic;
			    text-align: center;
			    outline: none;
			    border: 0;
			    font-size: 18px;
			    border-radius: 7px;
			    color: #fff;
			    text-shadow: var(--txsha);
			    padding: 8px;
			    border-radius: 8px;
			    background: black;
			    border: var(--bor1);
			    border-right: var(--bor2);
			    border-bottom: var(--bor2)
			}
			.container p{
			    font-size: 20px;
			    margin: 17px 0;
			    color: #fff;
			}
			.container p a{
			    text-decoration: none;
			    color: #fff;
			    font-weight: bold;
			    font-size: 21px;
			}
			.container input::placeholder{
			    color: #ffffff;
			}
			body{
			    background: var(--color1);   
			}
			form h2{
			    text-align: center;
			}
			.group button{
			    margin-top: 2rem;
			    width: 12rem;
			    padding: 10px;
			    border: 8px;
			    background: var(--bouts);
			    color: #fff;
			    border-radius: 25px;
			    text-shadow: var(--txsha);
			    cursor: pointer;
			    margin-left: 4.5rem;
			    transition: 0.6s;
			}
			.group button:active, .g button:active{
			    transform: scale(1.2);
			}
			.group button:hover, .g button:hover{
			    background: green;
			}
			.carre1, .carre2{
			    background-image: linear-gradient(154deg, black , red);
			    height: 3rem;
			    width: 3rem;
			    position: absolute;
			    margin-left: -15px;
			    margin-top: -15px;
			}
			.carre1{
			    border-bottom-right-radius: 50px;
			    border-top-right-radius: 10px;
			}
			.carre2{
			    position: absolute;
			    bottom: 5px;
			    right: 5px;
			    border-top-left-radius: 50px;
			    border-top-right-radius: 10px;
			    background-image: linear-gradient(154deg, red, black);
			}
			
			.gon{
			    display: flex;
			    align-items: center;
			    justify-content: space-between;
			}
			.g button{
			    width: 12rem;
			    padding: 10px;
			    border: 8px;
			    background: var(--bouts);
			    color: #fff;
			    border-radius: 25px;
			    text-shadow: var(--txsha);
			    cursor: pointer;
			    margin-left: 4.5rem;
			    transition: 0.6s;
			}
			.gon a{
			    color: greenyellow;
			}
			.iconne a{
			    color: greenyellow;
			    position: absolute;
			    font-size: 10px;
			    left: 15px;
			    cursor: pointer;
			}
			.iconne a:hover, .gon small a:hover{
			    border-bottom: 2px solid #E91e63;
			}
		</style>
		<!-- <link rel="stylesheet" href="style.css"> -->
	</head>
	<body>
		   <div class="container">
	        <form action="/hello/show" method="post" autocomplete="off">
	            <div class="carre1"></div>
	            <div class="carre2"></div>
	            <h2>Inscription</h2>
	            
		                  
	            
		            <div class="grids">
		                <div class="groupe">
		                    <label for="">Nom</label>
		                    <input type="text" name="nom" value="${user.nom}">
		                    <small class="text"></small>
		                </div>
		                <div class="groupe">
		                    <label for="">prenom</label>
		                    <input type="text" name="prenom" value="${user.prenom}">
		                    <small class="text"></small>
		                </div>
		                <div class="groupe">
		                    <label for="">Mot de passe</label>
		                    <input type="password" name="password" value="">
		                    <small class="text"></small>
		                </div>
		                <div class="groupe">
		                    <label for="">Email</label>
		                    <input type="email" name="email" value="${user.email}">
		                    <small class="text"></small>
		                </div>
		                <div class="groupe">
		                    <label for="">contact</label>
		                    <input type="text" name="contact" value="${user.contact}">
		                    <small class="text"></small>
		                </div>
	                <div class="groupe">    
		               <c:forEach var="roles" items="${Listesroles}">
		                  <label for="">${roles.libelle}</label>
		               	  <input type="checkbox" value="${roles.getId_role()}" name="roles" >
	                    </c:forEach>
	                    <c:if test="${ not empty user }">
			                <c:forEach var="role_user" items="${user.roles}">
			                  <label>${role_user.libelle}</label>
			                  <input class="in" type="checkbox" name="roles" value="${role_user.getId_role()}" checked/>
			                </c:forEach>   
					     </c:if>
	                    
	                </div>
	                <div class="group">
	                    <button type="submit">Enregistrer</button>
	                </div>
	         
	            </div>
	        </form>
	    </div>
	</body>
</html>