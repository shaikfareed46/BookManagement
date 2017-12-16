package com.thoughtworks.bookmanagement.constants;

/**
 * @author Shaik Fareed
 *
 */
public class LibraryConstants {

	public enum GenereType {
		Action,
		Comedy,
		Thriller,
		Romantic,
		Horror,
		Fiction
	}
	
	public static final String BOOK_CANNOT_BE_DELETED_MESSAGE = "Book is already been booked by someone and cannot be deleted";
	public static final String BOOK_DELETED_SUCCESSFULLY = "Deleted book successfully";
	public static final String BOOK_NOT_PRESENT = "Book not found for tag";
	
	
}
