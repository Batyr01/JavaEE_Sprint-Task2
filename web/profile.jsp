<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.sprintask2.db.Items" %>
<%@ page import="kz.sprintask2.db.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <%
        Users user = (Users) request.getAttribute("userInfo");
    %>
    <div class="container mt-4">
        <div class="row text-center">
            <h3>Hello <%=user.getFullName()%></h3>
            <p>This is your profile page</p>
        </div>
    </div>
</body>
</html>
