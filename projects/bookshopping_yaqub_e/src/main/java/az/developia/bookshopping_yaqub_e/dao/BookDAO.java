package az.developia.bookshopping_yaqub_e.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.bookshopping_yaqub_e.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{
	public List<Book> findAllByUsername(String username);
	
	@Query(value="select * from book where name like %?1%",nativeQuery=true)
	public List<Book> findAllSearch(String search);
}
