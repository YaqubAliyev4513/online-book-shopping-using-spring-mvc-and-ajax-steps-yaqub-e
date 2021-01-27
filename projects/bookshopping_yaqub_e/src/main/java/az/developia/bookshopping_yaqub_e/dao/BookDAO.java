package az.developia.bookshopping_yaqub_e.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshopping_yaqub_e.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{

}
