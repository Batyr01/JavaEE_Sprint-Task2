<%@ page import="kz.sprintask2.db.Users" %>
<%
    Users currentUser = (Users) session.getAttribute("currentUser");
%>
<nav class="navbar navbar-expand-lg bg-success navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="/home">Bitlab Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="/home">All news</a>
                </li>
                <%
                    if (currentUser != null) {
                %>
                <%
                    if (currentUser.getRole() == 1) {
                %>
                <li class="nav-item">
                    <a class="nav-link active" href="/add-news">Add news</a>
                </li>
                <%
                    }
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <%=currentUser.getFullName()%>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/profile">Profile</a></li>
                        <li><a class="dropdown-item" href="/">Settings</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="/logout">Logout</a></li>
                    </ul>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link active" href="/login">Sign in</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/register">Sign up</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>