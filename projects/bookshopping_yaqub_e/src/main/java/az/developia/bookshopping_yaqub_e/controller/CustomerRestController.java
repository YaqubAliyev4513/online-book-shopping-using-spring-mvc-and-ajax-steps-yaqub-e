package az.developia.bookshopping_yaqub_e.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshopping_yaqub_e.dao.BookDAO;
import az.developia.bookshopping_yaqub_e.file.StorageService;
import az.developia.bookshopping_yaqub_e.model.Book;
import az.developia.bookshopping_yaqub_e.model.OrderModel;

@RestController
@RequestMapping(path="/customer-rest")
public class CustomerRestController {

	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BookDAO bookDAO;
	
	@GetMapping(path="/find-partial",produces = MediaType.APPLICATION_XML_VALUE)
	public List<Book> showBooks() {
		 return addImagePath(bookDAO.findAllPartial(0, 100));		 
	}
	
	private List<Book> addImagePath(List<Book> books) {
		String contextPath = servletContext.getContextPath();
		System.out.println("contextPath : " + contextPath);
		for (Book book : books) {
			book.setImagePath(contextPath + "/files/" + book.getImagePath());
		}
		return books;
	}
	
	@PostMapping
	public void confirm(@RequestBody OrderModel orderModel){
		
	}
	
	
}
