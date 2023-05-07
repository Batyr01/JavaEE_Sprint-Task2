package kz.sprintask2.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.sprintask2.db.Categories;
import kz.sprintask2.db.DBConnection;
import kz.sprintask2.db.News;
import kz.sprintask2.db.Users;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/add-news")
public class NewsAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Categories> categories = DBConnection.getCategories();
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/addnews.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("currentUser");
        if(user!=null) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Long category_id = Long.parseLong(request.getParameter("category"));

            Categories category = DBConnection.getCategory(category_id);

            News news = new News();
            news.setTitle(title);
            news.setContent(content);
            news.setCategory(category);


            DBConnection.addNews(news);

            response.sendRedirect("/add-news");

        }else{
            response.sendRedirect("/login");
        }
    }
}
