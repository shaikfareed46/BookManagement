package com.thoughtworks.bookmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.bookmanagement.assembler.BookAssembler;
import com.thoughtworks.bookmanagement.entity.BookInfo;
import com.thoughtworks.bookmanagement.models.BookInfoModel;
import com.thoughtworks.bookmanagement.service.BookCannotBeDeletedException;
import com.thoughtworks.bookmanagement.service.BookManagementService;
import com.thoughtworks.bookmanagement.service.BookNotPresentException;

/**
 * @author Shaik Fareed
 *
 */
@RestController
public class BookManagementController {

	private static Logger logger = LoggerFactory.getLogger(BookManagementController.class);
	
	@Autowired
	private BookManagementService bookManagementService;
	
	@RequestMapping(value="/isAlive",method=RequestMethod.GET)
	public String isAlive(){
		return "Hello there";
	}
	
	/**
	 * @param bookInfoModel
	 * @return
	 */
	@RequestMapping(value="/books",method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<BookInfo> addBook(@RequestBody BookInfoModel bookInfoModel){
		logger.info("Adding book into the table");
		BookInfo bookInfo = BookAssembler.populateBookEntityFromModel(bookInfoModel);
		return new ResponseEntity<BookInfo>(bookManagementService.addBook(bookInfo), HttpStatus.CREATED);
	}
	
	/**
	 * @param bookInfoModel
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/books/bulk",method=RequestMethod.POST)
	public ResponseEntity<List<BookInfo>> addBooks(@RequestBody List<BookInfoModel> bookInfoModelList) throws Exception{
		logger.info("Adding book into the table");
		List<BookInfo> bookInfosList = BookAssembler.populateBookEntityListFromModelList(bookInfoModelList);
		return new ResponseEntity<List<BookInfo>>(bookManagementService.addBooks(bookInfosList), HttpStatus.CREATED);
	}
	
	
	/**
	 * @param bookInfoModel
	 * @return
	 * @throws BookCannotBeDeletedException 
	 */
	@RequestMapping(value="/books/{bookId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("bookId")String bookId) throws BookCannotBeDeletedException{
		logger.info("Deleting book from the table");
		return new ResponseEntity<String>(bookManagementService.deleteBooks(bookId), HttpStatus.CREATED);
	}
	
	/**
	 * @param bookInfoModel
	 * @return
	 * @throws BookCannotBeDeletedException 
	 * @throws BookNotPresentException 
	 */
	@RequestMapping(value="/books/{bookId}",method=RequestMethod.GET)
	public ResponseEntity<List<BookInfo>> findBookByTags(@RequestBody List<String> tags) throws BookNotPresentException{
		logger.info("Deleting book from the table");
		return new ResponseEntity<List<BookInfo>>(bookManagementService.findByTags(tags), HttpStatus.OK);
	}
	
}
