package com.codecool.web.model;

public class TextPage{

	private String title;
	private String textContent;
	private int dateCreated;
	  
	public TextPage(String title, String textContent, int dateCreated) {
		super();
		this.title = title;
		this.textContent = textContent;
		this.dateCreated = dateCreated;
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
	public int getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(int dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "TextPage [title=" + title + ", textContent=" + textContent + ", dateCreated=" + dateCreated + "]";
	}

	
}
