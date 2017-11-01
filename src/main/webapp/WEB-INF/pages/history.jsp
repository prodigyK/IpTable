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
        body {
            background-color: white;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<br/>
<hr>

<div class="container">
    <table class="table table-striped w3-small">
        <thead>
        <tr>
            <th width="150px">Ip Address</th>
            <th width="220px">Date</th>
            <th>Author</th>
            <th width="150">Field Name</th>
            <th width="200">Previous Value</th>
            <th width="200">New Value</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHistory}" var="history">
            <c:forEach items="${history.listDetails}" var="detail">
                <tr>
                    <td><b>${history.ipAddress}</b></td>
                    <td>${history.datetime}</td>
                    <td>${history.userName}</td>
                    <td>${detail.fieldName}</td>
                    <td>${detail.previousValue}</td>
                    <td>${detail.newValue}</td>
                </tr>
            </c:forEach>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
