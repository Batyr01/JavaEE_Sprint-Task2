package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.Comment;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.News;
import kz.sprintask2.db.Users;

import java.io.IOException;

@WebServlet(value = "/add-comment")
public class CommentAddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users user = (Users) request.getSession().getAttribute("currentUser");

        if (user != null) {

            String commentText = request.getParameter("comment");
            Long newsId = Long.parseLong(request.getParameter("news_id"));

            News news = DBConnection.getNewsById(newsId);

            if (news != null) {

                Comment comment = new Comment();
                comment.setNews(news);
                comment.setUser(user);
                comment.setText(commentText);

                DBConnection.addComment(comment);

                response.sendRedirect("/news-details?id="+newsId);

            }else{
                response.sendRedirect("/");
            }

        } else {
            response.sendRedirect("/login");
        }
    }
}
