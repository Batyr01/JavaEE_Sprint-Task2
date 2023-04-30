<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.sprintask2.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-4">
        <div class="row">
            <form action="/login" method="post">
                <div class="col-5 mx-auto">
                    <div class="row">
                        <div class="col-12">
                            <h3>Login Page</h3>
                            <hr>
                        </div>
                    </div>
                    <%
                        String error = (String) request.getAttribute("errorMessage");
                        if (error != null){
                    %>
                    <div class="alert alert-danger" role="alert">
                        <%=error%>
                    </div>
                    <%
                        }
                    %>
                    <div class="row">
                        <div class="col-12">
                            <label>Email</label>
                        </div>
                    </div>
                    <div class="row mt-2 mb-3">
                        <div class="col-12">
                            <input placeholder="Email" type="text" class="form-control" name="email">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <label>Password : </label>
                        </div>
                    </div>
                    <div class="row mt-2 mb-3">
                        <div class="col-12">
                            <input placeholder="Password" type="password" class="form-control" name="password">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>

            </form>
        </div>
    </div>
</body>
</html>
