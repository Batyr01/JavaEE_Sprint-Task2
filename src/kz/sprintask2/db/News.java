package kz.sprintask2.db;

import java.sql.Timestamp;

public class News {

    private Long id;
    private String title;
    private String content;
    private Timestamp post_date;
    private Categories category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public News(Long id, String title, String content, Timestamp post_date, Categories category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.post_date = post_date;
        this.category = category;
    }

    public News() {
    }
}
