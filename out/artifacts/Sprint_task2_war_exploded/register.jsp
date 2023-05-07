<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.sprintask2.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <%--<div class="container mt-4">
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
    </div>--%>
    <div class="container mt-4">
        <div class="row">
            <div class="col-5 mx-auto">
                <div class="row">
                    <div class="col-12">
                        <h3>Registration Page</h3>
                        <hr>
                    </div>
                </div>
                <%
                    String emailerror = request.getParameter("emailerror");
                    if(emailerror!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Email is busy!
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %>
                <%
                    String passworderror = request.getParameter("passworderror");
                    if(passworderror!=null){
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Password are not same!
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
                    User created successfully!
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %>
                <form action="/register" method="post">
                    <div class="row">
                        <div class="col-12">
                            <label>Email</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="email" class="form-control" name="email" required placeholder="Email">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Password</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="password" class="form-control" name="password" required placeholder="Password">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Repeat Password</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="password" class="form-control" name="re_password" required placeholder="Repeat Password">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Full Name</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="full_name" required placeholder="Full Name">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">Sign Up</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
