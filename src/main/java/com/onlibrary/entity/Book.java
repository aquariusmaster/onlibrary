package com.onlibrary.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;


@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue
	private int id;

    @Column(name = "title", nullable= false, length = 128)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String title;

    @Column(name = "author", nullable= false, length = 64)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String author;

	@Size(min=2, max = 255)
    @Column(name = "genre", nullable= false, length = 64)
	private String genre;

    @Column(name = "description", nullable= false, length = 256)
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String description;

    @Column(name = "filename", nullable= false, length = 256)
	private String filename;
	
	public Book() {

	}

	public Book(String title, String author, String genre, String description, String filename) {
		this.title = title;
		this.author = author;
		this.genre = genre;
        this.description =  description;
		this.filename = filename;
	}

	public Book(int id, String title, String author, String genre, String description, String filename) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
        this.description =  description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        return genre.equals(book.genre);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + genre.hashCode();
        return result;
    }

}
