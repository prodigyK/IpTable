<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core_rt" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">IP Addresses</a>
        </div>
        <div class="container">


            <ul class="nav navbar-nav">
                <spring:url value="/ip/main" var="main"/>
                <li class="active"><a href="${main}">Office</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <spring:url var="showFilter" value="/ip/showFilter"/>
                <li class=""><a href="${showFilter}">Filter</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <spring:url var="history" value="/ip/history"/>
                <li class=""><a href="${history}">History</a></li>
            </ul>
            <spring:url var="search" value="/ip/search"/>
            <form:form class="navbar-form navbar-left" action="${search}" modelAttribute="ipSearch">
                <div class="input-group">
                    <input type="text" class="form-control" name="ip" placeholder="Search by IP, Compname or Username" style="width: 300px">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit" style="height: 34px">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form:form>
            <spring:url var="addNew" value="/ip/addNew"/>
            <a class="btn btn-primary navbar-btn" href="${addNew}">Add Ip Address</a>

            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#"><%= userName%></a> </li>--%>
                <spring:url var="logout" value="/j_spring_security_logout" />
                <li><a href="${logout}"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
            </ul>

        </div>
    </div>


</nav>
