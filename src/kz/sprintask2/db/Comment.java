package kz.sprintask2.db;

import java.sql.Timestamp;

public class Comment {

    private Long id;
    private String text;
    private Timestamp post_date;
    private Users user;
    private News news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Comment(Long id, String text, Timestamp post_date, Users user, News news) {
        this.id = id;
        this.text = text;
        this.post_date = post_date;
        this.user = user;
        this.news = news;
    }

    public Comment() {
    }
}
