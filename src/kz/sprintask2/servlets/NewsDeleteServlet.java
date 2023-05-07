package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.Users;

import java.io.IOException;

@WebServlet(value = "/delete-news")
public class NewsDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");
        if (user != null && user.getRole() == 1) {
            long id = Long.parseLong(request.getParameter("id"));
            DBConnection.deleteNews(id);
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }

    }
}
