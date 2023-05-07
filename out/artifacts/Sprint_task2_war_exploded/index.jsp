<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.sprintask2.db.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container">
        <div class="row">
            <%
                ArrayList<News> newsList = (ArrayList<News>) request.getAttribute("news");
                if (newsList!=null){
                    for (News news : newsList){
            %>
            <div class="card mt-4">
                <div class="card-header">
                    <%=news.getPost_date()%>
                </div>
                <div class="card-body">
                    <h5 class="card-title"><%=news.getTitle()%></h5>
                    <p class="card-text"><%=news.getContent()%></p>
                    <a class="btn btn-success" href="/news-details?id=<%=news.getId()%>">Читать дальше</a>
                </div>
            </div>

            <%
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
