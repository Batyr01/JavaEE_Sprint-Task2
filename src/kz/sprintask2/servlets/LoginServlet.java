package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.Users;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users user = DBConnection.getUser(email, password);
        if (user != null){
            request.setAttribute("userInfo", user);
            request.getRequestDispatcher("/profile.jsp").forward(request,response);
        }
        request.setAttribute("errorMessage", "Invalid email or password");
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
}
