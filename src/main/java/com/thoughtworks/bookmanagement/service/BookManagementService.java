/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.service;

import java.util.List;

import com.thoughtworks.bookmanagement.entity.BookInfo;

/**
 * @author Shaik Fareed
 *
 */
public interface BookManagementService {

	/**
	 * @param bookInfo
	 */
	BookInfo addBook(BookInfo bookInfo);

	/**
	 * @param bookInfosList
	 * @return 
	 * @throws Exception 
	 */
	List<BookInfo> addBooks(List<BookInfo> bookInfosList) throws Exception;

	/**
	 * @param bookId
	 * @return
	 * @throws BookCannotBeDeletedException 
	 */
	String deleteBooks(String bookId) throws BookCannotBeDeletedException;

	/**
	 * @param tags
	 * @return
	 * @throws BookNotPresentException 
	 */
	List<BookInfo> findByTags(List<String> tags) throws BookNotPresentException;

}
