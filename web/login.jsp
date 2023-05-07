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
                        String error = request.getParameter("error");
                        if(error!=null){
                    %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Incorrect email or password!
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    <%
                        }
                    %>
                    <%
                        String success = request.getParameter("success");
                        if(success!=null){
                    %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        User created successfully please Sing In!
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
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
