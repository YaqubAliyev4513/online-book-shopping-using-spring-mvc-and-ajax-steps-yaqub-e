package az.developia.bookshopping_yaqub_e.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.bookshopping_yaqub_e.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{

	
	@Query(value="select * from book  limit ?1,?2",nativeQuery=true)
	public List<Book> findAllPartial(Integer begin,Integer length);
}
