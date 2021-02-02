package az.developia.bookshopping_yaqub_e.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping_yaqub_e.dao.BookDAO;
import az.developia.bookshopping_yaqub_e.model.Book;

@RestController
@RequestMapping(path="/customer-rest")
public class CustomerRestController {

	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping(path="/find-partial",produces = MediaType.APPLICATION_XML_VALUE)
	public List<Book> showBooks() {
		 return bookDAO.findAllPartial(0, 100);		 
	}
	
	
}