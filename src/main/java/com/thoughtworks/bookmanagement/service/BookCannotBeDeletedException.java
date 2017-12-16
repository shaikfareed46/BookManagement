/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.service;

import com.thoughtworks.bookmanagement.constants.LibraryConstants;

/**
 * @author Shaik Fareed
 *
 */
public class BookCannotBeDeletedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BookCannotBeDeletedException() {
		super(LibraryConstants.BOOK_CANNOT_BE_DELETED_MESSAGE);
	}
	
	public BookCannotBeDeletedException(String msg) {
		super(msg);
	}
	
}
