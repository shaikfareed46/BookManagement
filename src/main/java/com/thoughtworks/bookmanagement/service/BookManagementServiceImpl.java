/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thoughtworks.bookmanagement.client.BookManagementClient;
import com.thoughtworks.bookmanagement.constants.LibraryConstants;
import com.thoughtworks.bookmanagement.dao.BookManagementDAO;
import com.thoughtworks.bookmanagement.entity.BookInfo;

@Service
@Transactional
public class BookManagementServiceImpl implements BookManagementService{

	
	private static Logger logger = LoggerFactory.getLogger(BookManagementServiceImpl.class);
	
	@Autowired
	private BookManagementDAO bookManagementDAO;
	
	@Autowired
	private BookManagementClient bookmanagementClient;
	
	
	@Override
	public BookInfo addBook(BookInfo bookInfo) {
		logger.info("Service : Saving the book");
		return bookManagementDAO.save(bookInfo);
	}

	@Override
	public List<BookInfo> addBooks(List<BookInfo> bookInfosList) throws Exception{
		logger.info("Service : Saving the book");
		return bookManagementDAO.save(bookInfosList);
	}


	@Override
	public String deleteBooks(String bookId) throws BookCannotBeDeletedException {
		boolean isBookAlreadyBooked = bookmanagementClient.isBookAvailable(bookId);
		if(!isBookAlreadyBooked){
			bookManagementDAO.delete(bookId);
		}else{
			throw new BookCannotBeDeletedException();
		}
		return LibraryConstants.BOOK_DELETED_SUCCESSFULLY;
	}

	@Override
	public List<BookInfo> findByTags(List<String> tags) throws BookNotPresentException {
		List<BookInfo>  list = bookManagementDAO.findByTags(tags);
		if(list!=null){
			return list;
		}else{
			throw new BookNotPresentException();
		}
	}

}
