package com.crawler.domaincrawler.models;

import java.util.Objects;

public class News {
    private String title;
    private String description;

    public News() {
    }

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public News title(String title) {
        setTitle(title);
        return this;
    }

    public News description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof News)) {
            return false;
        }
        News news = (News) o;
        return Objects.equals(title, news.title) && Objects.equals(description, news.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
