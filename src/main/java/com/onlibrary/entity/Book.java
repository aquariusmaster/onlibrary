package com.onlibrary.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue
	private int id;
	

	@Column(name="title")
	private String title;


	@Column(name="author")
	private String author;


	@Column(name="genre")
	private String genre;


	@Column(name="filename")
	private String filename;
	
	public Book() {

	}

	public Book(String title, String author, String genre, String filename) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.filename = filename;
	}

	public Book(int id, String title, String author, String genre, String filename) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (author== null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book{" +
				"name='" + title + '\'' +
				", author='" + author + '\'' +
				", genre='" + genre + '\'' +
				", filename='" + filename + '\'' +
				'}';
	}
}
