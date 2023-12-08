<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${ListUser[0]}</h1>
	
	<h3>Affichage des infos de la classe Personne</h3>
	
	<h1>${Perso.nom}</h1>
	<h3>${header["Host"]}</h3>
	<h3>${header["user-agent"]}</h3>
	
	<c:if test="${param['age'] lt 18}">
            Vous êtes mineur !
        </c:if>
        <c:if test="${param['age'] ge 18}">
            Vous êtes majeur !
        </c:if>

        <!-- c:choose permet de spécifier autant de c:when que l'on souhaite -->
        <c:choose>
            <c:when test="${param['age'] lt 18}">
                Vous êtes mineur !
            </c:when>
            <c:otherwise>
                Vous êtes majeur !
            </c:otherwise>
        </c:choose>
	
</body>
</html>