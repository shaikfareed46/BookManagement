package com.thoughtworks.bookmanagement.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thoughtworks.bookmanagement.constants.LibraryConstants.GenereType;
import com.thoughtworks.bookmanagement.deserializer.CustomJsonDateDeserializer;

/**
 * @author Shaik Fareed
 *
 */

public class BookInfoModel {

	private String isbn; 
	
	private String name;
	
	private GenereType genre;
	
	private String author;
	
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	private Date publicationDate;
	
	private String edition;
	
	private Long price;
	
	private int quantity;
	
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
