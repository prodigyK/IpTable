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

        .red {
            color: red;
            font-size: small;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container" align="center">
    <c:if test="${not empty edit}">
        <h3>Update ip address</h3>
    </c:if>
    <c:if test="${empty edit}">
        <h3>Add ip address</h3>
    </c:if>
    <hr>
    <spring:url var="add" value="/ip/add"/>
    <form:form modelAttribute="ipAddressView" method="post" action="${add}">
        <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
        <br/>
        <table align="center" width="400">
            <tr>
                <td width="50%">Subnet</td>
                <td>Department</td>
            </tr>
            <tr>
                <td>
                    <form:hidden path="id"/>
                    <form:select path="subnet" class="selectpicker" id="ipSelect">
                        <c:forEach items="${subnets}" var="subnet">
                            <form:option value="${subnet.id}" label="${subnet.name}"/>
                        </c:forEach>
                    </form:select>

                </td>
                <td>
                    <form:select path="department" cssClass="selectpicker">
                        <c:forEach items="${departments}" var="department">
                            <form:option value="${department.id}" label="${department.name}"/>
                        </c:forEach>
                    </form:select>

                </td>
            </tr>
            <tr>
                <td>Ip</td>
                <td>Mac</td>
            </tr>
            <tr>
                <td><form:errors path="ipAddress" cssClass="red"/></td>
                <td></td>
            </tr>
            <tr>
                <td><form:input path="ipAddress" cssClass="form-control" id="ipAddr"/></td>
                <td><form:input path="macAddress" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Device Type</td>
                <td>Comp Name</td>
            </tr>
            <tr>
                <td>
                    <form:select path="deviceType" cssClass="selectpicker">
                        <c:forEach items="${deviceTypes}" var="deviceType">
                            <form:option value="${deviceType.id}" label="${deviceType.name}"/>
                        </c:forEach>
                    </form:select>
                </td>
                <td><form:input path="compName" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td>Port Name</td>
            </tr>
            <tr>
                <td><form:input path="userName" cssClass="form-control"/></td>
                <td><form:input path="portName" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Device login</td>
                <td>Device pass</td>
            </tr>
            <tr>
                <td><form:input path="deviceLogin" cssClass="form-control"/></td>
                <td><form:input path="devicePassword" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td>Teamviewer ID</td>
                <td>Teamviewer Pass</td>
            </tr>
            <tr>
                <td><form:input path="teamId" cssClass="form-control"/></td>
                <td><form:input path="teamPass" cssClass="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2">Comments</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:input path="comments" cssClass="form-control"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <hr>
                    <button type="submit" class="btn btn-block">
                        <c:if test="${not empty edit}">Update</c:if>
                        <c:if test="${empty edit}">Add</c:if>
                    </button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
