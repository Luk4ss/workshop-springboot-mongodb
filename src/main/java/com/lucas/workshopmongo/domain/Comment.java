package com.lucas.workshopmongo.domain;

import java.io.Serializable;

public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
  
	private String text;
	private String date;
	
	public Comment() {}
	
	

	public Comment(String text, String date) {
		super();
		this.text = text;
		this.date = date;
	}



	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	

}
