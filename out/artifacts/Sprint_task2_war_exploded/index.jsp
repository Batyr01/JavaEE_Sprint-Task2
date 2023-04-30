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
            <div class="col-12 text-center">
                <h1>Welcome to Bitlab Shop</h1>
                <p>Electronic devices with high quality and service</p>
            </div>
        </div>
        <div class="row">
            <%
                ArrayList<Items> items = (ArrayList<Items>) request.getAttribute("items");
                if (items!=null){
                    for (Items item : items){
            %>
            <div class="card col-4" style="width: 18rem;">
                <div class="card-body text-center">
                    <div>
                        <h4 class="card-title"><%=item.getName()%></h4>
                        <hr>
                    </div>
                    <div>
                        <h3 style="color: lightgreen">$<%=item.getPrice()%></h3>
                    </div>
                    <p class="card-text"><%=item.getDescription()%></p>
                    <div>
                        <button class="btn btn-success">Buy now</button>
                    </div>

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
