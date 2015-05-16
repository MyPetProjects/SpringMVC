<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Valentine
  Date: 12.05.15
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Username input successful</title>
</head>
<body>
    User name: ${customer.userName}
    <br/>
    Resident: ${customer.resident}
    <br/>
    <h4>Languages:</h4>
    <c:forEach var="language" items="${customer.languages}">
        <c:out value="${language}"/><br/>
    </c:forEach>
    <br/>
    <h4>Skills:</h4>
    <c:forEach var="skill" items="${customer.skills}">
        <c:out value="${skill}"/><br/>
    </c:forEach>
    <br/>
    <h4>Citizenship:</h4>
    <c:forEach var="citizen" items="${customer.citizenship}">
        <c:out value="${citizen}"/><br/>
    </c:forEach>
</body>
</html>