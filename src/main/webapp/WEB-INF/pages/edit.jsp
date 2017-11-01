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
        td {
            font-size: small;
            font-weight: bold;
            vertical-align: bottom;
            height: 30px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="container" align="center">
    <c:if test="${not empty edit}">
        <h3><b>Update ip address</b></h3>
    </c:if>
    <c:if test="${empty edit}">
        <h3><b>Add ip address</b></h3>
    </c:if>
    <hr>
    <spring:url var="add" value="/ip/add"/>
    <form:form modelAttribute="ipAddressView" method="post" action="${add}">
        <%--<form:errors path="*" cssClass="alert alert-danger" element="div"/>--%>
        <table align="center" width="400">
            <tr>
                <td width="50%">Subnet</td>
                <td>Department</td>
            </tr>
            <tr>
                <td>
                    <form:hidden path="id"/>
                    <form:select path="subnet" class="selectpicker" id="ipSelect" data-style="btn">
                        <c:forEach items="${subnets}" var="subnet">
                            <form:option value="${subnet.id}" label="${subnet.name}"/>
                        </c:forEach>
                    </form:select>

                </td>
                <td>
                    <form:select path="department" cssClass="selectpicker" data-style="btn">
                        <c:forEach items="${departments}" var="department">
                            <form:option value="${department.id}" label="${department.name}"/>
                        </c:forEach>
                    </form:select>

                </td>
            </tr>
            <tr>
                <td><form:errors path="ipAddress" cssClass="red"/><br>Ip</td>
                <td>Mac</td>
            </tr>
            <tr>
                <td><form:input path="ipAddress" cssClass="form-control" id="ipAddr" cssStyle="border-color:lightsteelblue"/></td>
                <td><form:input path="macAddress" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
            </tr>
            <tr>
                <td>Device Type</td>
                <td>Comp Name</td>
            </tr>
            <tr>
                <td>
                    <form:select path="deviceType" cssClass="selectpicker" data-style="btn">
                        <c:forEach items="${deviceTypes}" var="deviceType">
                            <form:option value="${deviceType.id}" label="${deviceType.name}"/>
                        </c:forEach>
                    </form:select>
                </td>
                <td><form:input path="compName" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td>Port Name</td>
            </tr>
            <tr>
                <td><form:input path="userName" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
                <td><form:input path="portName" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
            </tr>
            <tr>
                <td>Device login</td>
                <td>Device pass</td>
            </tr>
            <tr>
                <td><form:input path="deviceLogin" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
                <td><form:input path="devicePassword" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
            </tr>
            <tr>
                <td>Teamviewer ID</td>
                <td>Teamviewer Pass</td>
            </tr>
            <tr>
                <td><form:input path="teamId" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
                <td><form:input path="teamPass" cssClass="form-control" cssStyle="border-color: lightsteelblue"/></td>
            </tr>
            <tr>
                <td colspan="2">Comments</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:input path="comments" cssClass="form-control" cssStyle="border-color: lightsteelblue"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <br/>
                    <button type="submit" class="btn btn-block btn-primary" cssStyle="border-color: lightsteelblue"><b>
                        <c:if test="${not empty edit}">Update</c:if>
                        <c:if test="${empty edit}">Add</c:if></b>
                    </button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
