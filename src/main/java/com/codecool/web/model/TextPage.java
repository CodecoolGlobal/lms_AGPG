package com.codecool.web.model;

public class TextPage {

    private String title;
    private String textContent;
    private boolean isPublished;

    public TextPage(String title, String textContent, boolean isPublished) {
        super();
        this.title = title;
        this.textContent = textContent;

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

    public boolean isPublished() {
        return isPublished;
    }

    @Override
    public String toString() {
        return "TextPage{" +
            "title='" + title + '\'' +
            ", textContent='" + textContent + '\'' +
            ", isPublished=" + isPublished +
            '}';
    }
}
