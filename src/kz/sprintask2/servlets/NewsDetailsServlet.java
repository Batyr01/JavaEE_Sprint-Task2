package kz.sprintask2.servlets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.Comment;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.News;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/news-details")
public class NewsDetailsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        News news = DBConnection.getNewsById(id);
        request.setAttribute("news", news);

        if (news != null) {
            ArrayList<Comment> comments = DBConnection.getComments(news.getId());
            request.setAttribute("comments", comments);
        }
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}
