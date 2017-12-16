/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thoughtworks.bookmanagement.client.BookManagementClient;
import com.thoughtworks.bookmanagement.constants.LibraryConstants;
import com.thoughtworks.bookmanagement.dao.BookManagementDAO;
import com.thoughtworks.bookmanagement.entity.BookInfo;

/**
 * @author Shaik Fareed
 *
 */
public class BookManagementServiceTest {

	@Mock
	private BookManagementClient bookManagementClient;
	
	@Mock
	private BookManagementDAO bookManagementDAO;
	
	
	@InjectMocks
	private BookManagementServiceImpl bookManagementServiceImpl;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testDeleteForIsBookSuccessfullyDeleted(){
		when(bookManagementClient.isBookAvailable(any(String.class))).thenReturn(false);
		doNothing().when(bookManagementDAO).delete(any(BookInfo.class));;
		try {
			assertEquals(LibraryConstants.BOOK_DELETED_SUCCESSFULLY, bookManagementServiceImpl.deleteBooks("124"));
		} catch (BookCannotBeDeletedException e) {
			assert(false);
		}
	}
	
	
	@Test(expected=BookCannotBeDeletedException.class)
	public void testDeleteForIsBookCannotBeDeleted() throws BookCannotBeDeletedException{
		when(bookManagementClient.isBookAvailable(any(String.class))).thenReturn(true);
		bookManagementServiceImpl.deleteBooks("321");
	}
	
	
	
}
