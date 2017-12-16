/**
 * @author Shaik Fareed
 *
 */
package com.thoughtworks.bookmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thoughtworks.bookmanagement.entity.BookInfo;

/**
 * @author Shaik Fareed
 *
 */
public interface BookManagementDAO extends JpaRepository<BookInfo, String>{

	/**
	 * @param tags
	 * @return
	 */
	List<BookInfo> findByTags(List<String> tags);

}
