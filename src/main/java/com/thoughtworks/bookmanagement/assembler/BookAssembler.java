/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.assembler;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.bookmanagement.entity.BookInfo;
import com.thoughtworks.bookmanagement.models.BookInfoModel;

/**
 * @author Shaik Fareed
 *
 */
public class BookAssembler {

	/**
	 * @param bookInfoModel
	 * @return
	 */
	public static BookInfo populateBookEntityFromModel(BookInfoModel bookInfoModel) {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn(bookInfoModel.getIsbn());
		bookInfo.setName(bookInfoModel.getName());
		bookInfo.setGenre(bookInfoModel.getGenre());
		bookInfo.setAuthor(bookInfoModel.getAuthor());
		bookInfo.setEdition(bookInfoModel.getEdition());
		bookInfo.setPrice(bookInfoModel.getPrice());
		bookInfo.setPublicationDate(bookInfoModel.getPublicationDate());
		bookInfo.setQuantity(bookInfoModel.getQuantity());
		bookInfo.setTags(bookInfoModel.getTags());
		return bookInfo;
	}

	/**
	 * @param bookInfoModelList
	 * @return
	 */
	public static List<BookInfo> populateBookEntityListFromModelList(List<BookInfoModel> bookInfoModelList) {
		List<BookInfo> list = new ArrayList<>();
		
		for(BookInfoModel bookInfoModel:bookInfoModelList){
			BookInfo bookInfo = new BookInfo();
			bookInfo.setIsbn(bookInfoModel.getIsbn());
			bookInfo.setName(bookInfoModel.getName());
			bookInfo.setGenre(bookInfoModel.getGenre());
			bookInfo.setAuthor(bookInfoModel.getAuthor());
			bookInfo.setEdition(bookInfoModel.getEdition());
			bookInfoModel.setPrice(bookInfoModel.getPrice());
			bookInfoModel.setPublicationDate(bookInfoModel.getPublicationDate());
			bookInfo.setQuantity(bookInfoModel.getQuantity());
			bookInfo.setTags(bookInfoModel.getTags());
			list.add(bookInfo);
		}
		
		return list;
	}

}
