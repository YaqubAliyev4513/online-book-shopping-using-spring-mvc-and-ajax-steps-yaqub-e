package az.developia.bookshopping_yaqub_e.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

  @GetMapping()
  public String showHomePage(){
	  return "home";
  }
}
