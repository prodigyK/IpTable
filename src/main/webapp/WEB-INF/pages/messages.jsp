<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <jsp:include page="resources.jsp"/>
    <style>
        body{
            background-color: white;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<br/>
<hr>
<div class="container">
    <c:if test="${not empty deleteBlock}">
        <c:if test="${not empty deleted}">
            <div class="alert alert-success">
                <strong>Success!</strong> IP Address successfully deleted.
            </div>

        </c:if>
        <c:if test="${empty deleted}">
            <div class="alert alert-danger">
                <strong>Warning!</strong> Cannot delete IP Address.
            </div>
        </c:if>

    </c:if>

</div>
</body>
</html>
