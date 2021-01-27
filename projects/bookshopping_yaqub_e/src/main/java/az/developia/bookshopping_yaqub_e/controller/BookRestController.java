package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping_yaqub_e.dao.BookDAO;
import az.developia.bookshopping_yaqub_e.model.Book;


@RestController
@RequestMapping(path="/books")
public class BookRestController {

	@Autowired
	private BookDAO bookDAO;
	
	@PostMapping
	public Integer add(@RequestBody Book book){
		book.setId(null);
		Integer id=bookDAO.save(book).getId();
		return id;
	}
}
