package com.thoughtworks.bookmanagement.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.thoughtworks.bookmanagement.constants.LibraryConstants.GenereType;

/**
 * @author Shaik Fareed
 *
 */

@Entity
@Table(name="Book")
public class BookInfo {

	@Id
	private String isbn; 
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="genre")
	private GenereType genre;
	
	@Column(name="author")
	private String author;
	
	@Column(name="publication_date")
	private Date publicationDate;
	
	@Column(name="edition")
	private String edition;
	
	@Column(name="price")
	private Long price;
	
	@Column(name="quantity")
	private int quantity;
	
	@ElementCollection
	@Column(name="tags", length=50)
	private List<String> tags;

	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return genre
	 */
	public GenereType getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 */
	public void setGenre(GenereType genre) {
		this.genre = genre;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return publicationDate
	 */
	public Date getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * @param edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * @return price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
