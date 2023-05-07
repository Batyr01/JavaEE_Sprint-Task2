package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.News;
import kz.sprintask2.db.Users;

import java.io.IOException;

@WebServlet(value = "/save-news")
public class NewsUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if(user!=null) {
            if (user.getRole() == 1){
                String title = request.getParameter("title");
                String content = request.getParameter("content");
                Long id = Long.parseLong(request.getParameter("id"));

                News news = DBConnection.getNewsById(id);
                if(news!=null) {
                    news.setTitle(title);
                    news.setContent(content);

                    DBConnection.updateNews(news);

                    response.sendRedirect("/news-details?id="+id);

                }else{
                    response.sendRedirect("/");
                }
            }else {
                request.getRequestDispatcher("/403.jsp").forward(request, response);
            }

        }else{
            response.sendRedirect("/login");
        }
    }
}
