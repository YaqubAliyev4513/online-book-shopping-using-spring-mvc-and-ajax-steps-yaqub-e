package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshopping_yaqub_e.config.MySession;
import az.developia.bookshopping_yaqub_e.dao.BookDAO;

@Controller
public class BasketController {
	
	@Autowired
	private BookDAO bookDAO;
	private String username;
	
	@Autowired
	private MySession mySession;
	
	@GetMapping("/basket")
	public String show(){
		return "basket";
	}
	
}
