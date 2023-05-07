package kz.sprintask2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint-task2", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<News> getNews(){

        ArrayList<News> newsList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT n.id, n.title, n.content, n.post_date, n.category_id, cat.name\n" +
                            "FROM news AS n\n" +
                            "INNER JOIN news_categories AS cat ON n.category_id = cat.id"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setPost_date(resultSet.getTimestamp("post_date"));

                Categories category = new Categories();
                category.setId(resultSet.getLong("category_id"));
                category.setName(resultSet.getString("name"));

                news.setCategory(category);

                newsList.add(news);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return newsList;
    }

    public static void updateNews(News news) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news SET title = ?, content = ? " +
                    "WHERE id = ?");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static News getNewsById(Long id) {
        News news = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT n.id, n.title, n.content, n.category_id, n.post_date, cat.name " +
                    "FROM news n " +
                    "INNER JOIN news_categories cat ON cat.id = n.category_id " +
                    "WHERE n.id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                news = new News();
                news.setId(resultSet.getLong("id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setPost_date(resultSet.getTimestamp("post_date"));

                Categories category = new Categories();
                category.setId(resultSet.getLong("category_id"));
                category.setName(resultSet.getString("name"));

                news.setCategory(category);

            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

    public static void addNews(News news) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (title, content, post_date, category_id) " +
                    "VALUES (?, ?, NOW(), ?)");

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setLong(3, news.getCategory().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNews(long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM news WHERE id = ?");

            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Users getUser(String email) {
        Users user = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(resultSet.getInt("role_id"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(Users user) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (email, password, full_name, role_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRole());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getComments(Long newsId) {

        ArrayList<Comment> comments = new ArrayList<>();

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT co.id, co.comment, co.post_date, co.news_id, co.user_id, u.full_name " +
                    "FROM comments co " +
                    "INNER JOIN users u ON u.id = co.user_id " +
                    "WHERE co.news_id = ? " +
                    "ORDER BY co.post_date DESC");

            statement.setLong(1, newsId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setText(resultSet.getString("comment"));
                comment.setPost_date(resultSet.getTimestamp("post_date"));

                Users user = new Users();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                comment.setUser(user);

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                comment.setNews(news);

                comments.add(comment);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    public static void addComment(Comment comment) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (comment, user_id, news_id, post_date) " +
                    "VALUES (?, ?, ?, NOW())");

            statement.setString(1, comment.getText());
            statement.setLong(2, comment.getUser().getId());
            statement.setLong(3, comment.getNews().getId());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Categories getCategory(Long id){
        Categories category = null;
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM news_categories WHERE id = ?"
            );

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                category = new Categories();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));

            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    public static ArrayList<Categories> getCategories(){

        ArrayList<Categories> categoriesList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM news_categories"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Categories category = new Categories();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));

                categoriesList.add(category);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return categoriesList;
    }

}
