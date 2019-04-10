package com.codecool.web.model;

import java.util.Date;

public class TextPage {

    private String title;
    private String textContent;
    private Date dateCreated;
    private boolean isPublished;

    public TextPage(String title, String textContent, Date dateCreated, boolean isPublished) {
        super();
        this.title = title;
        this.textContent = textContent;
        this.dateCreated = dateCreated;
        this.isPublished = isPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isPublished() {
        return isPublished;
    }

    @Override
    public String toString() {
        return "TextPage{" +
            "title='" + title + '\'' +
            ", textContent='" + textContent + '\'' +
            ", dateCreated=" + dateCreated +
            ", isPublished=" + isPublished +
            '}';
    }
}
