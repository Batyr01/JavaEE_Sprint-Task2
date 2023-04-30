package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.Items;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Items> items = DBConnection.getItems();
        request.setAttribute("items", items);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
