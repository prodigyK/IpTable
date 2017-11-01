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
<c:if test="${not empty filter}">
    <div class="container">
        <form:form modelAttribute="ipAddressFilter" method="post" action="filtered">
            <table align="center">
                <tr>
                    <td style="padding: 5px">
                        <form:select path="department" cssClass="selectpicker" title="Departments">
                            <c:forEach items="${departments}" var="department">
                                <form:option value="${department.id}" label="${department.name}"/>
                            </c:forEach>
                        </form:select>

                    </td>
                    <td style="padding: 5px">
                        <form:select path="deviceType" cssClass="selectpicker" title="Device Types">
                            <c:forEach items="${deviceTypes}" var="deviceType">
                                <form:option value="${deviceType.id}" label="${deviceType.name}"/>
                            </c:forEach>
                        </form:select>

                    </td>
                    <td style="padding: 5px">
                        <form:select path="subnet" class="selectpicker" title="Subnets">
                            <c:forEach items="${subnets}" var="subnet">
                                <form:option value="${subnet.id}" label="${subnet.name}"/>
                            </c:forEach>
                        </form:select>

                    </td>
                    <td style="padding: 5px">
                        <button type="submit" class="btn"><b>Filter</b></button>

                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</c:if>
<hr>

<c:if test="${listIpAddresses != null}">
    <div class="container">
        <table class="table table-striped table-condensed w3-medium">
            <thead>
            <tr>
                <th>Ip Address</th>
                <th>Comp name</th>
                <th>Username</th>
                <th>Type</th>
                <th>Department</th>
                <th width="20%">Comment</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listIpAddresses}" var="ipAddress">
                <tr>
                    <td><a href="#" style="color:blue" data-toggle="modal" data-target="#myModal-${ipAddress.id}"><b>${ipAddress.ipAddress}</b></a>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal-${ipAddress.id}" role="dialog">
                            <div class="modal-dialog">

                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title"><b>Ip Address Card</b></h4>
                                    </div>
                                    <div class="modal-body">


                                        <table align="center" width="400" class="table table-bordered table-hover w3-small">
                                            <tr>
                                                <td width="50%">Ip Address</td>
                                                <td>${ipAddress.ipAddress}</td>
                                            </tr>
                                            <tr>
                                                <td>MAC Address</td>
                                                <td>${ipAddress.macAddress}</td>
                                            </tr>
                                            <tr>
                                                <td>User Name</td>
                                                <td>${ipAddress.userName}</td>
                                            </tr>
                                            <tr>
                                                <td>Comp Name</td>
                                                <td>${ipAddress.compName}</td>
                                            </tr>
                                            <tr>
                                                <td>Port Name</td>
                                                <td>${ipAddress.portName}</td>
                                            </tr>
                                            <tr>
                                                <td>Device login</td>
                                                <td>${ipAddress.deviceLogin}</td>
                                            </tr>
                                            <tr>
                                                <td>Device password</td>
                                                <td>${ipAddress.devicePassword}</td>
                                            </tr>
                                            <tr>
                                                <td>Teamviewer ID</td>
                                                <td>${ipAddress.teamId}</td>
                                            </tr>
                                            <tr>
                                                <td>Teamviewer password</td>
                                                <td>${ipAddress.teamPass}</td>
                                            </tr>
                                            <tr>
                                                <td>Comments</td>
                                                <td>${ipAddress.comments}</td>
                                            </tr>
                                        </table>



                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>

                            </div>
                        </div>



                    </td>
                    <td>${ipAddress.compName}</td>
                    <td><b>${ipAddress.userName}</b></td>
                    <td>${ipAddress.deviceType.name}</td>
                    <td>${ipAddress.department.name}</td>
                    <td>${ipAddress.comments}</td>
                    <spring:url var="edit" value="/ip/edit"/>
                    <td><a href="${edit}/${ipAddress.id}" class="glyphicon glyphicon-edit"/></td>
                    <spring:url var="delete" value="/ip/delete"/>
                    <td><a href="${delete}/${ipAddress.id}" class="glyphicon glyphicon-remove"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</c:if>
</body>
</html>
